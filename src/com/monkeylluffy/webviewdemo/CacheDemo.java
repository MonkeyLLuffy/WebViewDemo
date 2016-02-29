package com.monkeylluffy.webviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class CacheDemo extends Activity {

	private WebView mWebView;
	private Button btn_clear_cache;
	private Button btn_refresh;
	private static final String APP_CACHE_DIRNAME = "/webcache";
	private static final String URL = "http://blog.csdn.net/coder_pig";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cache_demo);

		mWebView = (WebView) findViewById(R.id.webView);
		btn_clear_cache = (Button) findViewById(R.id.btn_clear_cache);
		btn_refresh = (Button) findViewById(R.id.btn_refresh);

		mWebView.loadUrl(URL);
		mWebView.setWebViewClient(new WebViewClient() {
			// ������ת��ҳ���ʱ���������������
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				view.loadUrl(url);
				return true;
			}
		});

		WebSettings settings = mWebView.getSettings();
		settings.setJavaScriptEnabled(true);
		// ���û���ģʽ
		settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		// ����DOM storage API ����
		settings.setDomStorageEnabled(true);
		// ����database storage API����
		settings.setDatabaseEnabled(true);
		String cacheDirPath = getFilesDir().getAbsolutePath() + APP_CACHE_DIRNAME;
		Log.i("111", cacheDirPath);

		settings.setAppCachePath(cacheDirPath);
		settings.setAppCacheEnabled(true);
		Log.i("111", settings.getDatabasePath());

		btn_clear_cache.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mWebView.clearCache(true);
				Toast.makeText(CacheDemo.this, "����", Toast.LENGTH_SHORT).show();
			}
		});

		btn_refresh.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mWebView.reload();
			}
		});

	}

	@Override
	public void onBackPressed() {
		if (mWebView.canGoBack()) {
			mWebView.goBack();
		} else {
			super.onBackPressed();
		}
	}
}
