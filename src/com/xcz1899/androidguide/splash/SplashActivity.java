package com.xcz1899.androidguide.splash;

import com.xcz1899.androidguide.MainActivity;
import com.xcz1899.androidguide.R;
import com.xcz1899.androidguide.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

    private static final long DELAY_TIME = 3000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_splash);
	redirectByTime();
    }

    private void redirectByTime() {
	new Handler().postDelayed(new Runnable() {
	    @Override
	    public void run() {
		Intent intent = new Intent();
		intent.setClass(SplashActivity.this, MainActivity.class);
		startActivity(intent);
		finish();
	    }
	}, DELAY_TIME);
    }
}
