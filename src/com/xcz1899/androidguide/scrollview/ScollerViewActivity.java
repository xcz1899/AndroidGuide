package com.xcz1899.androidguide.scrollview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.xcz1899.androidguide.R;

public class ScollerViewActivity extends Activity implements OnScrollChangedListener {
    private LinearLayout mLLAnim;
    private MyScrollView mSVmain;
    private int mScrollViewHeight;
    private int mStartAnimateTop;
    private boolean hasStart = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_scrollview);
	initView();
	setView();
    }

    private void initView() {
	mSVmain = (MyScrollView) findViewById(R.id.sv_main);
	mLLAnim = (LinearLayout) findViewById(R.id.ll_anim);
    }

    private void setView() {
	mSVmain.setOnScrollChangedListener(this);
	mLLAnim.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
	super.onWindowFocusChanged(hasFocus);
	mScrollViewHeight = mSVmain.getHeight();
	mStartAnimateTop = mScrollViewHeight / 5 * 4;// 在距离ScrollView顶部mStartAnimateTop距离的地方开始加载动画
    }

    @Override
    public void onScrollChanged(int top, int oldTop) {
	int animTop = mLLAnim.getTop() - top;// 获得mLLAnim控件到ScrollView可视界面顶部的距离
	if (top > oldTop) {// 向上滑动
	    if (animTop < mStartAnimateTop && !hasStart) {// 当mLLAnim到可视界面的顶部高度小于我们设置的高度，开始加载动画
		Animation anim = AnimationUtils.loadAnimation(this, R.anim.show);
		mLLAnim.setVisibility(View.VISIBLE);
		mLLAnim.startAnimation(anim);
		hasStart = true;
	    }
	} else {// 向下滑动
	    if (animTop > mStartAnimateTop && hasStart) {
		Animation anim = AnimationUtils.loadAnimation(this, R.anim.close);
		mLLAnim.setVisibility(View.INVISIBLE);
		mLLAnim.startAnimation(anim);
		hasStart = false;
	    }
	}
    }

}
