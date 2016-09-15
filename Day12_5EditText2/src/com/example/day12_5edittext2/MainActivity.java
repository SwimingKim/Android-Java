package com.example.day12_5edittext2;

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

		final EditText et1 = (EditText) findViewById(R.id.editText1);// �������� ����
																		// ����
		final EditText et2 = (EditText) findViewById(R.id.editText2);
		Button b1 = (Button) findViewById(R.id.button1);
		final TextView tv1 = (TextView) findViewById(R.id.textView1);

		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String id = et1.getText().toString();
				String pw = et2.getText().toString();

				// ���ڿ� �񱳽� ����� ���ʿ� �ۼ��ϴ� ���� ����(������ ��Ʈ���̾�� ������ �ȳ���)
				if ("�ν�".equals(id) && "����".equals(pw)) {
					tv1.setText("�α��� ����");
					et1.setText("");
					et2.setText("");
				} else {
					tv1.setText("�α��� ����");
				}
			}
		});

	}// end of onCreate
}// end of class
