package com.monkeylluffy.webviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

/**
 * @author liuqun
 * 对webView添加滚动事件的监听
 */
public class OwnWebviewTest extends Activity{

	private MyWebView myWebView;
	private Button btn_icon;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.mywebviewtest);
		
		 btn_icon = (Button) findViewById(R.id.btn_icon);
		 myWebView = (MyWebView) findViewById(R.id.webView);
		 
		 myWebView.loadUrl("http://www.hao123.com");
		 myWebView.setWebViewClient(new WebViewClient() {
	            //在webview里打开新链接
	            @Override
	            public boolean shouldOverrideUrlLoading(WebView view, String url) {
	                view.loadUrl(url);
	                return true;
	            }
	        });
		 
		//比如这里做一个简单的判断，当页面发生滚动，显示那个Button
	        myWebView.setOnScrollChangedCallback(new MyWebView.OnScrollChangedCallback() {
	            @Override
	            public void onScroll(int dx, int dy) {
	                if (dy > 0) {
	                    btn_icon.setVisibility(View.VISIBLE);
	                } else {
	                    btn_icon.setVisibility(View.GONE);
	                }
	            }
	        });
		 
		 btn_icon.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                myWebView.setScrollY(0);
	                btn_icon.setVisibility(View.GONE);
	            }
	        });
		 
	}
	
}
