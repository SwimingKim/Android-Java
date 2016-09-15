package com.example.day12_0helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final TextView tv1 = (TextView) findViewById(R.id.textView1);
		final TextView tv2 = (TextView) findViewById(R.id.textView2);
		Button b1 = (Button) findViewById(R.id.button1);

		// 버튼을 클릭동작을 했을 때 (text1 => text2)
		b1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) { // 버튼이 클릭되었을 때, 호출되는 콜백메서드
				String str = tv1.getText().toString();
				tv2.setText(str);
			}
		});
	} // end of onCreate
} // end of class
