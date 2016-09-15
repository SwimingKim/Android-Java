package com.example.day41_1web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv;
	private Button b;
	Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv = (TextView)findViewById(R.id.textView1);
		b = (Button)findViewById(R.id.button1);		

		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				downloadHtml();
			}

		});



	}//end of onCreate

	void downloadHtml() {
		// Web�� �ִ� �ڷḦ ��������
		// 1. AndroidManifest.xml�� ���ͳ� ������ �۹̼� ����Ѵ�.
		// 2. ������ Thread�� �����Ͽ� ���ڷḦ �޾ƿ´�.
		// 3. ������ Thread���� ȭ���� �����۾��� �Ϸ���, Handler��ü�� ����ؾ� �Ѵ�.

		Thread t = new Thread(new Runnable() {

			public void run() {//������ Thread���� ������ �۾��� ����Ѵ�
//				String result = "";// ���ڿ� �۾��ӵ��� �ʴ�, ���� �� ��
//				StringBuffer : �̱۾�����
//				StringBuilder : ��Ƽ������
				final StringBuilder result = new StringBuilder();

				try {
					URL url = new URL("http://www.naver.com/");//try~catch
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();//try-catch
					if (conn != null) {// ������ �Ǿ��ٸ�
						conn.setConnectTimeout(1000); // ���ð� �󸶳� ��������
						conn.setUseCaches(false);
						if (conn.getResponseCode()==HttpURLConnection.HTTP_OK) {// ������ ������ ���������� �޾Ҵٸ�
							// ������ ������ ���������� �޾Ҵٸ�
							BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));//�ѱ����ڵ�ó��
							while (true) {
								String str = br.readLine();
								if (str==null) break;// ���� �������� �������� ���
								result.append(str+"\n");
								Log.d("web", str);
							}
							br.close();//BufferedReader�ݱ�
						}// end of if (HTTP_OK)
						conn.disconnect();
						handler.post(new Runnable() {
							public void run() {
								tv.setText(result.toString());
							}
						});
					}
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}


			}
		});

		t.start();// ������ ���۽�Ű��		

	}

}//end of class
