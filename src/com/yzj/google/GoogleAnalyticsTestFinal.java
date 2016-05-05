package com.yzj.google;

import java.lang.reflect.Method;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.metaps.analytics.Analytics;
import com.metaps.common.Metaps;

public class GoogleAnalyticsTestFinal extends Activity {

	public static Context mContext = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);


		mContext = this;
		Metaps.initialize(this,
				getResources().getString(R.string.metaps_analytics_app_id));
		// MetapsAna
		Analytics.setLogEnabled(true);
		Metaps.setGcmSenderId("utility-ridge-129405");
		
		// String customText = Analytics.getPushNotificationCustomText();
		// System.out.println(customText);

		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectDiskReads().detectDiskWrites().detectNetwork()
				.penaltyLog().build());

		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
				.detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()
				.build());

		final ScrollView scrollView = new ScrollView(this);
		final LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		scrollView.addView(layout);
		setContentView(scrollView);



		for (final Method method : GoogleAnalyticsTestFinal.this.getClass().getMethods()) {
			if (method.getName().startsWith("test")) {
				Button button = new Button(this);
				button.setText(method.getName());
				layout.addView(button);
				button.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						try {
							method.invoke(GoogleAnalyticsTestFinal.this);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			} // end if
		} // end for
	}

	public void f(String str) {
		System.out.println("yzj " + str);
	}

	public void t(String str) {
		Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onStart() {
		super.onStart();
		Analytics.start(this);
	}

	// @Override
	// protected void onNewIntent(Intent intent) {
	// String customText = Analytics.getPushNotificationCustomText();
	// System.out.println(customText);
	// }

	@Override
	protected void onStop() {
		super.onStop();
		Analytics.stop(this);
	}
	

	public void testGoogleAnalytics(){
		String screenName = "hehe123";
		int loop = 5;
		Tracker t = GoogleAnalytics.getInstance(this).newTracker(
				"UA-77241894-1");
		t.setScreenName(screenName);
		for(int i = 0; i < loop; i++){
			t.send(new HitBuilders.AppViewBuilder().build());
		}
	}
	/**
	 * Call this when user purchased your item
	 * 
	 * @param view
	 */
	public void testPurchase() {
		Analytics.trackPurchase("SuperItemForSample", 0.99, "USD");
		Analytics.trackEvent("category human", "name yzj");

//		AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {
//			@Override
//			protected String doInBackground(Void... params) {
//				String token = null;
//				System.out.println("yzj doInBackground");
//				Info adInfo = null;
//
//				try {
//					adInfo = AdvertisingIdClient.getAdvertisingIdInfo(mContext);
//				} catch (IOException e) {
//					e.printStackTrace();
//				} catch (GooglePlayServicesNotAvailableException e) {
//					e.printStackTrace();
//				} catch (IllegalStateException e) {
//					e.printStackTrace();
//				} catch (GooglePlayServicesRepairableException e) {
//					e.printStackTrace();
//				}
//				if (adInfo != null) {
//					System.out.println("yzj " + adInfo.toString());
//					System.out.println("yzj AdId " + adInfo.getId());
//				}
//
//				return token;
//			}
//
//			@Override
//			protected void onPostExecute(String token) {
//				System.out.println("yzj onPostExecute");
//			}
//		};
//		task.execute();

	}

}
