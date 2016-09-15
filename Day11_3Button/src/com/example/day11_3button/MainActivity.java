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
		// Acitivity�� ȭ�鿡 �׷��� �� ���� ���� ȣ��Ǵ� �ݹ� �޼���
		super.onCreate(savedInstanceState);// �θ� onCreate�޼��� ȣ��
		setContentView(R.layout.activity_main);// xml�� ����

		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);

		final TextView tv = (TextView) findViewById(R.id.textView1);

		// String bt1 = b1.getText().toString();

		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {// ��ư Ŭ���� ȣ��Ǵ� �ݹ� �޼���
				tv.setText("Ŭ���߽��ϴ�");
			}
		});

		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				tv.setText("");
			}
		});

		b3.setOnClickListener(new OnClickListener() {
			int num = 0;

			public void onClick(View v) {// ��ư�� Ŭ������ �� ȣ��Ǵ� �ݹ�޼���
				num++;
				tv.setText(num + "");// ���ڰ��� ���ڿ��� �־�� �Ѵ�
			}
		});

	}// end of OnCreate

}// end of class