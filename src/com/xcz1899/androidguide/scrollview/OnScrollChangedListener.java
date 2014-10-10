package com.xcz1899.androidguide.scrollview;
/**
 * 主要用来实时ScrollView的onScrollChanged方法中的值
 * @author Administrator
 *
 */
public abstract interface OnScrollChangedListener {
	public abstract void onScrollChanged(int top, int oldTop);
}
