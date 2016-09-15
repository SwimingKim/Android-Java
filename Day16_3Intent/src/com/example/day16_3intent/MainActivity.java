package com.example.day16_3intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// ȭ����ȯ �ϱ�
		// 1. ���� �Ѿ ȭ���� �غ��Ѵ�.(���̾ƿ�xml, �ҽ�java)
		// 2. ���� ȭ���� AndroidManifest.xml ����Ѵ�.
		// 3. ���� ȭ������ ��ȯ�ϱ�(Intent ��ü ���� �� ����Ʈ ������ startActivity)

		Button b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// ��ư Ŭ���� �ι��� ȭ������ ��ȯ�ϱ�
				Intent intent = new Intent(getApplicationContext(), // ����ȭ����
																	// �������
						SecondActivity.class);// ���� �Ѿ ȭ��.class
				startActivity(intent);// ȭ����ȯ�ϱ�
			}
		});

	}// end of onCreate
}// end of class
