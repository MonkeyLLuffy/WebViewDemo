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
 *���Ͻ�һ������رյ�ǰActivity�İ�ť,�м������ŵ�title,������һ��ˢ�°�ť, �������½ǿ���������һ�������İ�ť,
 *�����ǻ���������Ļ������ͻ���ʾ����, ���û�������ֻ�ع�����ҳ�Ķ����������������򵥵�ʵ���£�
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
	            //�������û�ȡ������վtitle
	            @Override
	            public void onReceivedTitle(WebView view, String title) {
	                super.onReceivedTitle(view, title);
	                txt_title.setText(title);
	            }
	        });


	        wView.setWebViewClient(new WebViewClient() {
	            //��webview���������
	            @Override
	            public boolean shouldOverrideUrlLoading(WebView view, String url) {
	                view.loadUrl(url);
	                return true;
	            }
	        });
	    }

	// ��back�����д���
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
            finish();          //�رյ�ǰActivity
            break;
        case R.id.btn_refresh:
            wView.reload();    //ˢ�µ�ǰҳ��
            break;
        case R.id.btn_top:
            wView.setScrollY(0);   //����������
            break;
    }
	}

}
