package com.xcz1899.androidguide.scoller;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class MyScrollView extends ScrollView {
    private OnScrollChangedListener onScrollChangedListener;

    public MyScrollView(Context context, AttributeSet attrs) {
	super(context, attrs);
    }

    public MyScrollView(Context context) {
	super(context);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
	// l oldl 分别代表水平位移
	// t oldt 代表当前左上角距离Scrollview顶点的距离
	super.onScrollChanged(l, t, oldl, oldt);
	if (this.onScrollChangedListener != null) {
	    onScrollChangedListener.onScrollChanged(t, oldt);
	}
    }

    public void setOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
	this.onScrollChangedListener = onScrollChangedListener;
    }

}
