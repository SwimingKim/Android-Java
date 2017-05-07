package com.example.day17_1intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// xml와 소스파일을 연결하는 작업
		setContentView(R.layout.next);

		// 이전 화면에서 실어온 데이터를 꺼내기 위한 방법 : intent를 얻어온다
		Intent intent = getIntent();// 이전 화면에서 전달해온 정보
		// intent.get타입Extra();
		int num1 = intent.getIntExtra("num1", 0);
		int num2 = intent.getIntExtra("num2", 0);
		String op = intent.getStringExtra("operator");

		final TextView re = (TextView) findViewById(R.id.textView2);
		final TextView tv = (TextView) findViewById(R.id.textView1);

		if ("+".equals(op)) {
			re.setText("덧셈");
			tv.setText("덧셈 결과 = " + (num1 + num2));
		} else if ("-".equals(op)) {
			re.setText("뺄셈");
			tv.setText("뺄셈 결과 = " + (num1 - num2));
		}

	}// end of onCreate
}// end of class
