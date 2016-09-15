package com.example.day11_2textview2;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// onCreate �޼��� : MainActivity ȭ�鿡 �׷��� �� ���� ���� ȣ��Ǵ� �ݹ� �޼���
		super.onCreate(savedInstanceState);// �θ��� onCreate�޼��带 ȣ��
		setContentView(R.layout.activity_main);// xml�� ����
		// ���� �ϳ��� ȭ���� xml�� java �� ���� ���Ϸ� �����ȴ�

		TextView tv1 = (TextView) findViewById(R.id.textView1);
		// xml���� ������ �ڿ��� java �ҽ����� ����� �� �ֵ��� ��ü�� �������� ���
		TextView tv2 = (TextView) findViewById(R.id.textView2);
		TextView tv3 = (TextView) findViewById(R.id.textView3);
		TextView tv4 = (TextView) findViewById(R.id.textView4);
		TextView tv5 = (TextView) findViewById(R.id.textView5);

		String str = tv1.getText().toString();
		tv2.setText(str);

		tv3.setText("���α�");
		tv3.setTextColor(Color.GREEN);

		tv4.setBackgroundColor(0xffff00ff);

		tv5.setBackgroundColor(0xff0f0f33);
		tv5.setTextSize(30f);

	}// end of onCreate
}// end of class
