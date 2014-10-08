package com.xcz1899.androidguide;

import com.xcz1899.androidguide.splash.SplashActivity;
import com.xcz1899.androidguide.viewflipper.ViewFlipperActivity;
import com.xcz1899.androidguide.viewpager.ViewPagerActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
    private Button mBtnSplashActivity;
    private Button mBtnViewPagerActivity;
    private Button mBtnViewFlipperActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	initView();
	setOnClick();
    }

    private void initView() {
	mBtnSplashActivity = (Button) findViewById(R.id.btn_splashactivity);
	mBtnViewPagerActivity= (Button) findViewById(R.id.btn_viewpageractivity);
	mBtnViewFlipperActivity= (Button) findViewById(R.id.btn_viewflipperactivity);
    }

    private void setOnClick() {
	mBtnSplashActivity.setOnClickListener(this);
	mBtnViewPagerActivity.setOnClickListener(this);
	mBtnViewFlipperActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
	switch (v.getId()) {
	case R.id.btn_splashactivity:
	    Intent intent = new Intent();
	    intent.setClass(this, SplashActivity.class);
	    startActivity(intent);
	    break;
	case R.id.btn_viewpageractivity:
	    Intent intent1 = new Intent();
	    intent1.setClass(this, ViewPagerActivity.class);
	    startActivity(intent1);
	    break;
	case R.id.btn_viewflipperactivity:
	    Intent intent2 = new Intent();
	    intent2.setClass(this, ViewFlipperActivity.class);
	    startActivity(intent2);
	    break;
	}
    }
}
