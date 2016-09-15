package com.example.day11_2textview2;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// onCreate 메서드 : MainActivity 화면에 그려질 때 가장 먼저 호출되는 콜백 메서드
		super.onCreate(savedInstanceState);// 부모의 onCreate메서드를 호출
		setContentView(R.layout.activity_main);// xml과 연결
		// 보통 하나의 화면은 xml과 java 두 개의 파일로 구성된다

		TextView tv1 = (TextView) findViewById(R.id.textView1);
		// xml에서 선언한 자원을 java 소스에서 사용할 수 있도록 객체를 가져오는 방법
		TextView tv2 = (TextView) findViewById(R.id.textView2);
		TextView tv3 = (TextView) findViewById(R.id.textView3);
		TextView tv4 = (TextView) findViewById(R.id.textView4);
		TextView tv5 = (TextView) findViewById(R.id.textView5);

		String str = tv1.getText().toString();
		tv2.setText(str);

		tv3.setText("서민규");
		tv3.setTextColor(Color.GREEN);

		tv4.setBackgroundColor(0xffff00ff);

		tv5.setBackgroundColor(0xff0f0f33);
		tv5.setTextSize(30f);

	}// end of onCreate
}// end of class
