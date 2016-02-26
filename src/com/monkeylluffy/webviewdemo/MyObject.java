package com.monkeylluffy.webviewdemo;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class MyObject {
	private Context context;
    public MyObject(Context context) {
        this.context = context;
    }

    //����ʾToast�ͶԻ���ķ�����¶��JS�ű�����
    public void showToast() {
    	String name = "����ǰ���չ�~";
    	Log.i("my", name);
        Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
    }

    public void showDialog() {
        new AlertDialog.Builder(context)
                .setTitle("��ϵ���б�").setIcon(R.drawable.ic_launcher)
                .setItems(new String[]{"����", "B��", "����", "����", "����"}, null)
                .setPositiveButton("ȷ��", null).create().show();
    }
}
