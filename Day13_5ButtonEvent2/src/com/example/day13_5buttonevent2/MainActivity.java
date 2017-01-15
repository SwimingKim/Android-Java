package com.example.day13_5buttonevent2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

	static EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		et = (EditText) findViewById(R.id.editText1);
		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);
		Button b4 = (Button) findViewById(R.id.button4);

		b1.setOnClickListener(this);// 내 클래스에서 이벤트 처리까지 하겠다
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);

	}// end of onCreate

	public void onClick(View v) {// 클릭시 이벤트 처리
		Button b = (Button) v;
		et.append(b.getText());
	}
}// end of class
