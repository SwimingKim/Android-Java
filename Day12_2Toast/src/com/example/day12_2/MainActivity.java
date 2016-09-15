package com.example.day12_2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);

		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), // 현재화면의 제어권자
						"짧은 토스트 까꿍", // 화면에 띄어줄 메세지
						Toast.LENGTH_SHORT)// 0은 짧은 것, 1은 긴 것
						.show();// 화면에 띄어주기
			}
		});

		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "길게 보여주는 메세지 로~옹", Toast.LENGTH_LONG).show();
			}
		});
		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "메롱", 1).show();
			}
		});

	}// end of onCreate

}// end of class
