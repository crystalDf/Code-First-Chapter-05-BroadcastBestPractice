package com.star.broadcastbestpractice;


import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {

    private static List<Activity> sActivities = new ArrayList<>();

    public static void addActivity(Activity activity) {

        if (!sActivities.contains(activity)) {
            sActivities.add(activity);
        }

    }

    public static void removeActivity(Activity activity) {
        sActivities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : sActivities) {
            if(!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    public static List<Activity> getActivities() {
        return sActivities;
    }
}
