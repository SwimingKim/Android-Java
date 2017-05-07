package com.example.day16_3intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 화면전환 하기
		// 1. 다음 넘어갈 화면을 준비한다.(레이아웃xml, 소스java)
		// 2. 다음 화면을 AndroidManifest.xml 등록한다.
		// 3. 다음 화면으로 전환하기(Intent 객체 생성 후 인텐트 날리기 startActivity)

		Button b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 버튼 클릭시 두번쨰 화면으로 전환하기
				Intent intent = new Intent(getApplicationContext(), // 현재화면의
																	// 제어권자
						SecondActivity.class);// 다음 넘어갈 화면.class
				startActivity(intent);// 화면전환하기
			}
		});

	}// end of onCreate
}// end of class
