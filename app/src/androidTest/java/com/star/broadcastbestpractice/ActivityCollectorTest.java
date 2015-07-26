package com.star.broadcastbestpractice;


import android.test.InstrumentationTestCase;

public class ActivityCollectorTest extends InstrumentationTestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testAddActivity() throws Exception {
        assertEquals(0, ActivityCollector.getActivities().size());

        LoginActivity loginActivity = new LoginActivity();

        ActivityCollector.addActivity(loginActivity);

        assertEquals(1, ActivityCollector.getActivities().size());

        ActivityCollector.addActivity(loginActivity);

        assertEquals(1, ActivityCollector.getActivities().size());
    }
}
