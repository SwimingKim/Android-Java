package com.example.day13_6buttonevent4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 버튼의 이벤트 처리방법 : xml에서 이벤트 등록
		// 장점 : 코드가 간단
		// 단점 : 추적(디버깅)이 어렵다

		et = (EditText) findViewById(R.id.editText1);
		// Button b1 = (Button)findViewById(R.id.button1);
		// Button b2 = (Button)findViewById(R.id.button2);
		// Button b3 = (Button)findViewById(R.id.button3);
		// Button b4 = (Button)findViewById(R.id.button4);

	}// end of onCreate

	public void myCEvent(View v) {
		Button b = (Button) v;
		et.append(b.getText());
	}

}// end of class
