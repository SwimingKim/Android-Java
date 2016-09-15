package com.example.day14_4worldcup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	int man[] = { R.drawable.eric, R.drawable.jae, R.drawable.jin, R.drawable.seo, R.drawable.kae, R.drawable.kang,
			R.drawable.lee, R.drawable.park };
	String name[] = { "����", "����", "����", "���α�", "����", "����ȯ", "����", "�ڱ��" };
	int indexL = 0;
	int indexR = 1;
	int index = 1;// ���� �ε���

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ImageView ivL = (ImageView) findViewById(R.id.imageView1);
		final ImageView ivR = (ImageView) findViewById(R.id.imageView2);

		ivL.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				index++;
				if (index == man.length) {// �����¸�
					ivR.setImageResource(R.drawable.ic_launcher);
					// �佺Ʈ�ٿ��"�����¸�"
					Toast.makeText(getApplicationContext(), "�����¸�", 1).show();
					// ���̻� ������� �ʰ� - Ŭ������
					ivR.setClickable(false);
					ivL.setClickable(false);
				} else {
					indexR = index;
					ivR.setImageResource(man[indexR]);
				}
			}
		});

		ivR.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				index++;
				if (index == man.length) {
					ivL.setImageResource(R.drawable.ic_launcher);
					// �佺Ʈ�ٿ��"�����¸�"
					Toast.makeText(getApplicationContext(), "�����¸�", 1).show();
					// ���̻� ������� �ʰ� - Ŭ������
					ivR.setClickable(false);
					ivL.setClickable(false);
				} else {
					indexL = index;
					ivL.setImageResource(man[indexL]);
				}

			}
		});

	}// end of onCreate
}// end of class
