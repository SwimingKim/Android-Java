package com.example.day12_6edittext3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final EditText ed1 = (EditText) findViewById(R.id.editText1);
		final EditText ed2 = (EditText) findViewById(R.id.editText2);

		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);
		Button b4 = (Button) findViewById(R.id.button4);

		final TextView tv = (TextView) findViewById(R.id.textView1);

		b1.setOnClickListener(new OnClickListener() {// 더하기연산
			public void onClick(View v) {
				try {
					int num1 = Integer.valueOf(ed1.getText().toString());
					int num2 = Integer.valueOf(ed2.getText().toString());
					tv.setText("덧셈 결과 = " + (num1 + num2) + "");
				} catch (NumberFormatException e) {
					tv.setText("숫자를 정확히 입력해주세요");
				}
			}
		});
		b2.setOnClickListener(new OnClickListener() {// 빼기연산
			public void onClick(View v) {
				try {
					int num1 = Integer.valueOf(ed1.getText().toString());
					int num2 = Integer.valueOf(ed2.getText().toString());
					tv.setText("뺄셈 결과 = " + (num1 - num2) + "");
				} catch (NumberFormatException e) {
					tv.setText("숫자를 정확히 입력해주세요");
				}
			}
		});
		b3.setOnClickListener(new OnClickListener() {// 곱하기연산
			public void onClick(View v) {
				try {
					int num1 = Integer.valueOf(ed1.getText().toString());
					int num2 = Integer.valueOf(ed2.getText().toString());
					tv.setText("곱셈 결과 = " + (num1 * num2) + "");
					// if (num1==0&&num2==0) {
					// tv.setText("곱하는 수는 0이면 안돼요");
					// }
				} catch (NumberFormatException e) {
					tv.setText("숫자를 정확히 입력해주세요");
				}
			}
		});
		b4.setOnClickListener(new OnClickListener() {// 나누기연산
			public void onClick(View v) {
				try {
					int num1 = Integer.valueOf(ed1.getText().toString());
					int num2 = Integer.valueOf(ed2.getText().toString());

					// num2가 0이면 나누지 않도록
					if (num2 == 0) {
						// tv.setText("0으로 나눌 수 없습니다");
						throw new Exception("0으로 나눌 수 없습니다");// 폭탄제조
					} else {// 0이 아닐 때 : 정상
						tv.setText("나눗셈 결과 = " + (double) num1 / num2 + "");
					}
				} catch (NumberFormatException e) {
					tv.setText("숫자를 정확히 입력해주세요");
				} catch (Exception e) {
					tv.setText("0으로 나눌 수 없습니다");
				}
			}
		});

	}// end of onCreate
}// end of class
