package com.xcz1899.androidguide.viewflipper;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.ViewFlipper;

import com.xcz1899.androidguide.R;

public class ViewFlipperActivity extends Activity implements OnGestureListener{

    private ViewFlipper mVFActivity;
    private GestureDetector  mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_viewflipper);
	initView();
    }

    private void initView() {
	mGestureDetector = new GestureDetector(this);
	mVFActivity = (ViewFlipper) findViewById(R.id.vf_activity);
	
    }

    @Override
    public boolean onDown(MotionEvent e) {
	return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
	return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
	return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
	if (e1.getX() > e2.getX()) {// move to left
	    mVFActivity.showNext();
	} else if (e1.getX() < e2.getX()) {
	    mVFActivity.showPrevious();
	} else {
	    return false;
	}
	return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
	return mGestureDetector.onTouchEvent(event);
    }

}
