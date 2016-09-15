package com.example.day17_1intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final EditText et1 = (EditText) findViewById(R.id.editText1);
		final EditText et2 = (EditText) findViewById(R.id.editText2);
		Button b1 = (Button) findViewById(R.id.button1);

		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// 다음 페이지로 화면 전환
				// 1. 다음 넘어갈 화면을 준비한다(java, xml)
				// 2. 화면을 등록한다(AndroidManifest.xml)
				// 3. Intent 객체를 생성해서 화면전환한다(인텐트 날린다)
				Intent intent = new Intent// 명시적 인텐트
				(getApplicationContext()// 현재 화면의 제어권자
				, NextActivity.class);// 다음 넘어갈 화면

				intent.putExtra("num1", Integer.valueOf(et1.getText().toString()));// 데이터
																					// 실어서
																					// 보내기
				intent.putExtra("num2", Integer.valueOf(et2.getText().toString()));

				intent.putExtra("operator", "+");

				startActivity(intent);// 인텐트 날리기
			}
		});

		Button b2 = (Button) findViewById(R.id.button2);
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent// 명시적 인텐트
				(getApplicationContext()// 현재 화면의 제어권자
				, NextActivity.class);// 다음 넘어갈 화면

				intent.putExtra("num1", Integer.valueOf(et1.getText().toString()));// 데이터
																					// 실어서
																					// 보내기
				intent.putExtra("num2", Integer.valueOf(et2.getText().toString()));

				intent.putExtra("operator", "-");

				startActivity(intent);

			}
		});

	}// end of onCreate
}// end of class
