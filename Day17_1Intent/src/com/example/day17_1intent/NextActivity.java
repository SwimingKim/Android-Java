package com.example.day17_1intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// xml�� �ҽ������� �����ϴ� �۾�
		setContentView(R.layout.next);

		// ���� ȭ�鿡�� �Ǿ�� �����͸� ������ ���� ��� : intent�� ���´�
		Intent intent = getIntent();// ���� ȭ�鿡�� �����ؿ� ����
		// intent.getŸ��Extra();
		int num1 = intent.getIntExtra("num1", 0);
		int num2 = intent.getIntExtra("num2", 0);
		String op = intent.getStringExtra("operator");

		final TextView re = (TextView) findViewById(R.id.textView2);
		final TextView tv = (TextView) findViewById(R.id.textView1);

		if ("+".equals(op)) {
			re.setText("����");
			tv.setText("���� ��� = " + (num1 + num2));
		} else if ("-".equals(op)) {
			re.setText("����");
			tv.setText("���� ��� = " + (num1 - num2));
		}

	}// end of onCreate
}// end of class
