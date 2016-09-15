package com.example.day12_2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);

		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), // ����ȭ���� �������
						"ª�� �佺Ʈ ���", // ȭ�鿡 ����� �޼���
						Toast.LENGTH_SHORT)// 0�� ª�� ��, 1�� �� ��
						.show();// ȭ�鿡 ����ֱ�
			}
		});

		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "��� �����ִ� �޼��� ��~��", Toast.LENGTH_LONG).show();
			}
		});
		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "�޷�", 1).show();
			}
		});

	}// end of onCreate

}// end of class
