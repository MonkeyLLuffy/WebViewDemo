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
		webView.getSettings().setUseWideViewPort(true);//�趨֧��viewport
		webView.getSettings().setSupportZoom(true);//�趨֧������
//		webView.getSettings().setLoadWithOverviewMode(true);   //����Ӧ��Ļ
		webView.setHorizontalScrollBarEnabled(true);//������ˮƽ��ʾ
		webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);//��������WebView�ڲ���ʾ
//		webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY)//��������WebView�����ʾ
		webView.getSettings().setDisplayZoomControls(false);
		
		
		
		webView.setWebViewClient(new WebViewClient() {
			
            //������webView����򿪵�����ҳ�ڵ�ǰ������ʾ,������ת���µ��������
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
		webView.getSettings().setJavaScriptEnabled(true);  //����WebView����,����ִ��js�ű�
		webView.loadUrl("https://www.duba.com/?f=liebaont");
		setContentView(webView);

	}

	// ��back�����д���
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
			webView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
