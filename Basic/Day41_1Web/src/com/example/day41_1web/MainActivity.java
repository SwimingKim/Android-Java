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
		// Web에 있는 자료를 가져오기
		// 1. AndroidManifest.xml에 인터넷 사용권한 퍼미션 등록한다.
		// 2. 별도의 Thread를 생성하여 웹자료를 받아온다.
		// 3. 별도의 Thread에서 화면의 변경작업을 하려면, Handler객체를 사용해야 한다.

		Thread t = new Thread(new Runnable() {

			public void run() {//별도의 Thread에서 수행할 작업을 기술한다
//				String result = "";// 문자열 작업속도가 늦다, 쓰지 말 것
//				StringBuffer : 싱글쓰레드
//				StringBuilder : 멀티쓰레드
				final StringBuilder result = new StringBuilder();

				try {
					URL url = new URL("http://www.naver.com/");//try~catch
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();//try-catch
					if (conn != null) {// 연결이 되었다면
						conn.setConnectTimeout(1000); // 대기시간 얼마나 참을건지
						conn.setUseCaches(false);
						if (conn.getResponseCode()==HttpURLConnection.HTTP_OK) {// 서버의 응답을 정상적으로 받았다면
							// 서버의 응답을 정상적으로 받았다면
							BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));//한글인코딩처리
							while (true) {
								String str = br.readLine();
								if (str==null) break;// 서버 페이지의 마지막일 경우
								result.append(str+"\n");
								Log.d("web", str);
							}
							br.close();//BufferedReader닫기
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

		t.start();// 쓰레드 동작시키기		

	}

}//end of class
