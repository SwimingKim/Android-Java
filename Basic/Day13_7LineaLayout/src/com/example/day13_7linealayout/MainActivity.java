package com.example.day13_7linealayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		et = (EditText) findViewById(R.id.editText1);

		Button b1 = (Button) findViewById(R.id.button10);
		Button b2 = (Button) findViewById(R.id.button11);

		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int num = Integer.valueOf(et.getText().toString());
				et.setText("");
				num += num;
				// int num2 = Integer.valueOf(et.getText().toString());

			}
		});

	}// end of onCreate

	public void myStyle(View v) {
		Button b = (Button) v;
		et.append(b.getText());

	}
}// end of class
