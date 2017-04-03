package com.example.day16_3intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.second);// 현재java파일과 연결할 layout파일 등록

		Button b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
				startActivity(intent);
			}
		});
		Button b2 = (Button) findViewById(R.id.button2);
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), // 현재화면의
																	// 제어권자
						MainActivity.class);// 다음 넘어갈 화면
				finish();
				;// 현재 화면을 닫아줌
				startActivity(intent);
			}
		});

	}// end of onCreate
}// end of class
