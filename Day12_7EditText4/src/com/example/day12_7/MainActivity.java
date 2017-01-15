package com.example.day12_7;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final TextView tv = (TextView) findViewById(R.id.textView1);

		final EditText ed = (EditText) findViewById(R.id.editText1);

		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);

		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String text = ed.getText().toString();
				if ("글자".equals(text)) {
					tv.setTextColor(Color.RED);
				} else if ("배경".equals(text)) {
					tv.setBackgroundColor(Color.RED);
				} else {
					Toast.makeText(getApplicationContext(), "글자 혹은 배경 중 택일", 1).show();
				}
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String text = ed.getText().toString();
				if ("글자".equals(text)) {
					tv.setTextColor(Color.GREEN);
				} else if ("배경".equals(text)) {
					tv.setBackgroundColor(Color.GREEN);
				} else {
					Toast.makeText(getApplicationContext(), "글자 혹은 배경 중 택일", 1).show();
				}
			}
		});
		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String text = ed.getText().toString();
				if ("글자".equals(text)) {
					tv.setTextColor(Color.BLUE);
				} else if ("배경".equals(text)) {
					tv.setBackgroundColor(Color.BLUE);
				} else {
					Toast.makeText(getApplicationContext(), "글자 혹은 배경 중 택일", 1).show();
				}
			}
		});

	}// end of onCreate
}// end of class
