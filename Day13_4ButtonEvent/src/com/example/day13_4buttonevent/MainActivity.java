package com.example.day13_4buttonevent;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	static EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		et = (EditText) findViewById(R.id.editText1);
		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);
		Button b4 = (Button) findViewById(R.id.button4);

		// 1.�͸�Ŭ������ �̿��ϴ� ���
		// 2.�޼��� ���ʿ� Ŭ������ �����ϴ� ���
		// ���ο��� ����ϴ� �������� ������ ����� �� �ִ�(����)
		// �ܺο����� ����� �� ����
		class MyEvent implements OnClickListener {
			public void onClick(View v) {// Ŭ���� �̺�Ʈ ó��
				Button b = (Button) v;
				et.append(b.getText());
			}
		}
		MyEvent me = new MyEvent();// �̺�Ʈ��ü����
		b1.setOnClickListener(me);
		b2.setOnClickListener(me);
		b3.setOnClickListener(me);
		b4.setOnClickListener(me);

	}// end of onCreate

	// 3.�������� ������ Ŭ���� �����ϴ� ���
	// �ٸ� �޼��忡���� Ŭ������ ���� ����� �� �ִ�(����)
	// �������� ���� ������ �� ����(����)
	class MyEvent implements OnClickListener {
		public void onClick(View v) {// Ŭ���� �̺�Ʈ ó��
			Button b = (Button) v;
			et.append(b.getText());
		}
	}
}// end of class

// 4.�ܺ� ������ Ŭ���� �����ϴ� ��
// ���� �ڿ��� �����ϱⰡ �ſ� ��ƴ�(����)
// static ������ ������ �� �ִ�
class MyEvent implements OnClickListener {
	public void onClick(View v) {// Ŭ���� �̺�Ʈ ó��
		Button b = (Button) v;
		MainActivity.et.append(b.getText());
	}
}

// 5.��Ŭ��������this�� �����ϴ� ���
// 6.xml�� �����ϴ� ���
