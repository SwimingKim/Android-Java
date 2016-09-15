package com.example.day13_2checkbox2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	boolean dap1[] = { true, false, true, false };
	boolean dap2[] = { false, true, true, false };
	boolean dap[] = dap1;// ���� ������ ��

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final TextView tv = (TextView) findViewById(R.id.textView1);
		final CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
		final CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
		final CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
		final CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
		final Button b1 = (Button) findViewById(R.id.button1);
		final Button b2 = (Button) findViewById(R.id.button2);

		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String str = "��! Ʋ����";
				if (cb1.isChecked() == dap[0] && cb2.isChecked() == dap[1] && cb3.isChecked() == dap[2]
						&& cb4.isChecked() == dap[3])
					str = "������~! �¾���";
				Toast.makeText(getApplicationContext(), str, 1).show();
			}
		});

		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				cb1.setChecked(false);
				cb2.setChecked(false);
				cb3.setChecked(false);
				cb4.setChecked(false);
				String ss = b2.getText().toString();
				if ("��������".equals(ss)) {// 2��������
					tv.setText("����2 ���ɸ޴��� ��� ���ÿ�");
					cb1.setText("���");
					cb2.setText("���κ�");
					cb3.setText("�߾ӵ�������");
					cb4.setText("�н�");
					b2.setText("��������");
					dap = dap2;
				} else if ("��������".equals(ss)) {// 1��������
					tv.setText("����1 �����ϴ� ��ȭ�� ��� ���ÿ�");
					cb1.setText("�����Ǿ�");
					cb2.setText("�");
					cb3.setText("�������α׳�");
					cb4.setText("�������α׳�2");
					b2.setText("��������");
					dap = dap1;
				}
			}
		});

	}// end of onCreate
}// end of class
