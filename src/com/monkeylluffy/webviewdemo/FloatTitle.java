package com.monkeylluffy.webviewdemo;

import android.R.id;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * @author liuqun
 *左上角一个点击关闭当前Activity的按钮,中间是新闻的title,右面是一个刷新按钮, 而在右下角可能有这样一个悬浮的按钮,
 *当我们滑动超过屏幕宽度他就会显示出来, 当用户点击后又会回滚到网页的顶部！下面我们来简单的实现下！
 */
public class FloatTitle extends Activity implements OnClickListener {

	private WebView webView;
    private ImageButton btn_back;
    private TextView txt_title;
    private ImageButton btn_top;
    private ImageButton btn_refresh;
    private WebView wView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_float);
		bindViews();

	}
	
	
	
	 private void bindViews() {
	        btn_back = (ImageButton) findViewById(R.id.btn_back);
	        txt_title = (TextView) findViewById(R.id.txt_title);
	        btn_top = (ImageButton) findViewById(R.id.btn_top);
	        btn_refresh = (ImageButton) findViewById(R.id.btn_refresh);
	        wView = (WebView) findViewById(R.id.webView);

	        btn_back.setOnClickListener(this);
	        btn_refresh.setOnClickListener(this);
	        btn_top.setOnClickListener(this);

	        wView.loadUrl("http://www.baidu.com");
	        
	        wView.setWebChromeClient(new WebChromeClient() {
	            //这里设置获取到的网站title
	            @Override
	            public void onReceivedTitle(WebView view, String title) {
	                super.onReceivedTitle(view, title);
	                txt_title.setText(title);
	            }
	        });


	        wView.setWebViewClient(new WebViewClient() {
	            //在webview里打开新链接
	            @Override
	            public boolean shouldOverrideUrlLoading(WebView view, String url) {
	                view.loadUrl(url);
	                return true;
	            }
	        });
	    }

	// 对back键进行处理
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
			webView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
        case R.id.btn_back:
            finish();          //关闭当前Activity
            break;
        case R.id.btn_refresh:
            wView.reload();    //刷新当前页面
            break;
        case R.id.btn_top:
            wView.setScrollY(0);   //滚动到顶部
            break;
    }
	}

}
