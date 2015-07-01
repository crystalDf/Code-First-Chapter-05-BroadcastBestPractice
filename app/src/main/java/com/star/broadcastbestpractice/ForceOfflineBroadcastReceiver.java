package com.star.broadcastbestpractice;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ForceOfflineBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {

        if ("com.star.broadcastbestpractice.FORCE_OFFLINE".equals(intent.getAction())) {

            Intent startAlertDialog = new Intent(context, AlertDialogActivity.class);
            startAlertDialog.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(startAlertDialog);
        }

    }
}
