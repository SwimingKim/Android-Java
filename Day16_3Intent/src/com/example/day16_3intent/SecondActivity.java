package com.example.day16_3intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.second);// ����java���ϰ� ������ layout���� ���

		Button b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
				startActivity(intent);
			}
		});
		Button b2 = (Button) findViewById(R.id.button2);
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), // ����ȭ����
																	// �������
						MainActivity.class);// ���� �Ѿ ȭ��
				finish();
				;// ���� ȭ���� �ݾ���
				startActivity(intent);
			}
		});

	}// end of onCreate
}// end of class
