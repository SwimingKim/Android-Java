package com.example.day16_4intent2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 다이얼 화면으로 전환하기 - 내가 만든 클래스가 아니면, 클래스 이름을 알 수 없다
				// 묵시적 인텐트

				Intent intent = new Intent(Intent.ACTION_VIEW, // 모드
						Uri.parse("tel:010-9622-0213"));// 세부데이터
				startActivity(intent);// 묵시적인 Intent 화면전환

			}
		});
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);
		Button b4 = (Button) findViewById(R.id.button4);
		Button b5 = (Button) findViewById(R.id.button5);
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 전화걸어버리기
				Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-9622-0213"));
				startActivity(intent);
			}
		});

		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://cafe.naver.com/minsseam1"));
				startActivity(intent);
			}
		});
		b4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 문자보내기
				Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:010-9622-0213"));
				startActivity(intent);
			}
		});
		b5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:rumex13@naver.com"));
				startActivity(intent);
			}
		});

	}// end of onCreate
}// end of class
