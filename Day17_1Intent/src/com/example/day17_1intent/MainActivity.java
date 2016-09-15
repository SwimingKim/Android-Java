package com.example.day17_1intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final EditText et1 = (EditText) findViewById(R.id.editText1);
		final EditText et2 = (EditText) findViewById(R.id.editText2);
		Button b1 = (Button) findViewById(R.id.button1);

		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// ���� �������� ȭ�� ��ȯ
				// 1. ���� �Ѿ ȭ���� �غ��Ѵ�(java, xml)
				// 2. ȭ���� ����Ѵ�(AndroidManifest.xml)
				// 3. Intent ��ü�� �����ؼ� ȭ����ȯ�Ѵ�(����Ʈ ������)
				Intent intent = new Intent// ����� ����Ʈ
				(getApplicationContext()// ���� ȭ���� �������
				, NextActivity.class);// ���� �Ѿ ȭ��

				intent.putExtra("num1", Integer.valueOf(et1.getText().toString()));// ������
																					// �Ǿ
																					// ������
				intent.putExtra("num2", Integer.valueOf(et2.getText().toString()));

				intent.putExtra("operator", "+");

				startActivity(intent);// ����Ʈ ������
			}
		});

		Button b2 = (Button) findViewById(R.id.button2);
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent// ����� ����Ʈ
				(getApplicationContext()// ���� ȭ���� �������
				, NextActivity.class);// ���� �Ѿ ȭ��

				intent.putExtra("num1", Integer.valueOf(et1.getText().toString()));// ������
																					// �Ǿ
																					// ������
				intent.putExtra("num2", Integer.valueOf(et2.getText().toString()));

				intent.putExtra("operator", "-");

				startActivity(intent);

			}
		});

	}// end of onCreate
}// end of class
