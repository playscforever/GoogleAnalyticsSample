package com.yzj.google;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class GoogleAnalyticsTestFinal extends Activity
{
	@Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Tracker t =  GoogleAnalytics.getInstance(this).newTracker("UA-77241894-1");
		t.setScreenName("Home12354555");
		t.send(new HitBuilders.AppViewBuilder().build());
		t.send(new HitBuilders.AppViewBuilder().build());
		t.send(new HitBuilders.AppViewBuilder().build());
    }
}
