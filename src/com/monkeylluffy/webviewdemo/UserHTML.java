package com.monkeylluffy.webviewdemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

@SuppressLint("JavascriptInterface")
public class UserHTML extends Activity {
	 private WebView wView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_main);
	        wView = (WebView) findViewById(R.id.webView);
	        wView.loadUrl("file:///android_asset/demo1.html");
	        //①设置WebView允许调用js
	        wView.getSettings().setJavaScriptEnabled(true);
	        wView.getSettings().setDefaultTextEncodingName("UTF-8");
	        //②将object对象暴露给Js,调用addjavascriptInterface
	        wView.addJavascriptInterface(new MyObject(this), "myObj");
	    }
		
}
