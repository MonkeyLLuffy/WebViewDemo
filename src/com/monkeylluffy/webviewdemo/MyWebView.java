package com.monkeylluffy.webviewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

public class MyWebView extends WebView {

	private OnScrollChangedCallback mOnScrollChangedCallback;

	public MyWebView(Context context) {
		super(context);
	}

	public MyWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

	}

	//ˮƽ�����ĵ㣬��ֱ�����ĵ�
	//��ǰ��ˮƽ�����ĵ㣬��ǰ��ֱ�����ĵ�
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		if (mOnScrollChangedCallback != null) {
			mOnScrollChangedCallback.onScroll(l - oldl, t - oldt);
		}
	}

	public OnScrollChangedCallback getOnScrollChangedCallback() {
		return mOnScrollChangedCallback;
	}

	public void setOnScrollChangedCallback(final OnScrollChangedCallback onScrollChangedCallback) {
		mOnScrollChangedCallback = onScrollChangedCallback;
	}

	public static interface OnScrollChangedCallback {
		// �����dx��dy�������x���y���ϵ�ƫ��������Ҳ�����Լ���l, t, oldl, oldt�ĸ�������¶����
		public void onScroll(int dx, int dy);
	}
}
