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

		b1.setOnClickListener(new OnClickListener() {// ���ϱ⿬��
			public void onClick(View v) {
				try {
					int num1 = Integer.valueOf(ed1.getText().toString());
					int num2 = Integer.valueOf(ed2.getText().toString());
					tv.setText("���� ��� = " + (num1 + num2) + "");
				} catch (NumberFormatException e) {
					tv.setText("���ڸ� ��Ȯ�� �Է����ּ���");
				}
			}
		});
		b2.setOnClickListener(new OnClickListener() {// ���⿬��
			public void onClick(View v) {
				try {
					int num1 = Integer.valueOf(ed1.getText().toString());
					int num2 = Integer.valueOf(ed2.getText().toString());
					tv.setText("���� ��� = " + (num1 - num2) + "");
				} catch (NumberFormatException e) {
					tv.setText("���ڸ� ��Ȯ�� �Է����ּ���");
				}
			}
		});
		b3.setOnClickListener(new OnClickListener() {// ���ϱ⿬��
			public void onClick(View v) {
				try {
					int num1 = Integer.valueOf(ed1.getText().toString());
					int num2 = Integer.valueOf(ed2.getText().toString());
					tv.setText("���� ��� = " + (num1 * num2) + "");
					// if (num1==0&&num2==0) {
					// tv.setText("���ϴ� ���� 0�̸� �ȵſ�");
					// }
				} catch (NumberFormatException e) {
					tv.setText("���ڸ� ��Ȯ�� �Է����ּ���");
				}
			}
		});
		b4.setOnClickListener(new OnClickListener() {// �����⿬��
			public void onClick(View v) {
				try {
					int num1 = Integer.valueOf(ed1.getText().toString());
					int num2 = Integer.valueOf(ed2.getText().toString());

					// num2�� 0�̸� ������ �ʵ���
					if (num2 == 0) {
						// tv.setText("0���� ���� �� �����ϴ�");
						throw new Exception("0���� ���� �� �����ϴ�");// ��ź����
					} else {// 0�� �ƴ� �� : ����
						tv.setText("������ ��� = " + (double) num1 / num2 + "");
					}
				} catch (NumberFormatException e) {
					tv.setText("���ڸ� ��Ȯ�� �Է����ּ���");
				} catch (Exception e) {
					tv.setText("0���� ���� �� �����ϴ�");
				}
			}
		});

	}// end of onCreate
}// end of class
