package com.monkeylluffy.webviewdemo;

import android.R.id;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		//webView = (WebView) findViewById(R.id.webView);
		webView = new WebView(this);
		webView.getSettings().setUseWideViewPort(true);//设定支持viewport
		webView.getSettings().setSupportZoom(true);//设定支持缩放
//		webView.getSettings().setLoadWithOverviewMode(true);   //自适应屏幕
		webView.setHorizontalScrollBarEnabled(true);//滚动条水平显示
		webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);//滚动条在WebView内侧显示
//		webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY)//滚动条在WebView外侧显示
		webView.getSettings().setDisplayZoomControls(false);
		
		
		
		webView.setWebViewClient(new WebViewClient() {
			
            //设置在webView点击打开的新网页在当前界面显示,而不跳转到新的浏览器中
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
		webView.getSettings().setJavaScriptEnabled(true);  //设置WebView属性,运行执行js脚本
		webView.loadUrl("https://www.duba.com/?f=liebaont");
		setContentView(webView);

	}

	// 对back键进行处理
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
			webView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
