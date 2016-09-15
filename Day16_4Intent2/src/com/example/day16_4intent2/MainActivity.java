package com.example.day16_4intent2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// ���̾� ȭ������ ��ȯ�ϱ� - ���� ���� Ŭ������ �ƴϸ�, Ŭ���� �̸��� �� �� ����
				// ������ ����Ʈ

				Intent intent = new Intent(Intent.ACTION_VIEW, // ���
						Uri.parse("tel:010-9622-0213"));// ���ε�����
				startActivity(intent);// �������� Intent ȭ����ȯ

			}
		});
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);
		Button b4 = (Button) findViewById(R.id.button4);
		Button b5 = (Button) findViewById(R.id.button5);
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// ��ȭ�ɾ������
				Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-9622-0213"));
				startActivity(intent);
			}
		});

		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://cafe.naver.com/minsseam1"));
				startActivity(intent);
			}
		});
		b4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// ���ں�����
				Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:010-9622-0213"));
				startActivity(intent);
			}
		});
		b5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:rumex13@naver.com"));
				startActivity(intent);
			}
		});

	}// end of onCreate
}// end of class
