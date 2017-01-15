package com.example.day11_3button;

import android.R.integer;
import android.R.string;
import android.accounts.OnAccountsUpdateListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Acitivity가 화면에 그려질 때 가장 먼저 호출되는 콜백 메서드
		super.onCreate(savedInstanceState);// 부모 onCreate메서드 호출
		setContentView(R.layout.activity_main);// xml과 연결

		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);

		final TextView tv = (TextView) findViewById(R.id.textView1);

		// String bt1 = b1.getText().toString();

		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {// 버튼 클릭시 호출되는 콜백 메서드
				tv.setText("클릭했습니다");
			}
		});

		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				tv.setText("");
			}
		});

		b3.setOnClickListener(new OnClickListener() {
			int num = 0;

			public void onClick(View v) {// 버튼을 클릭했을 때 호출되는 콜백메서드
				num++;
				tv.setText(num + "");// 인자값은 문자열을 넣어야 한다
			}
		});

	}// end of OnCreate

}// end of class