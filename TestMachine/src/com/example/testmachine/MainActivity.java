package com.example.testmachine;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	int price[] = { 0, 960, 1120, 1340, 2350 };
	int money = 0;
	int index = 1;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final EditText eMoney = (EditText) findViewById(R.id.editText1);
		final EditText eResult = (EditText) findViewById(R.id.editText2);

		Button bMoney = (Button) findViewById(R.id.button5);

		bMoney.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int num = Integer.valueOf(eMoney.getText().toString());
				eResult.append("\t���� ��? " + num + "��\n");
				money += num;
				eResult.append("\t�� ���� ��? " + money + "��\n\n");
				eMoney.setText("");
			}
		});

		Button b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				eResult.append("\t������ ��ǰ? ���̴�\n");
				eResult.append("\t������ ��ǰ�� ����? 960��\n\n");
				int index = 1;
			}
		});

		Button b2 = (Button) findViewById(R.id.button2);
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				eResult.append("\t������ ��ǰ? ������������\n");
				eResult.append("\t������ ��ǰ�� ����? 1120��\n\n");
				int index = 2;
			}
		});

		Button b3 = (Button) findViewById(R.id.button3);
		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				eResult.append("\t������ ��ǰ? ���̽��Ƹ޸�ī��\n");
				eResult.append("\t������ ��ǰ�� ����? 1340��\n\n");
				int index = 3;
			}
		});

		Button b4 = (Button) findViewById(R.id.button4);
		b4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				eResult.append("\t������ ��ǰ? ������\n");
				eResult.append("\t������ ��ǰ�� ����? 2350��\n\n");
				int index = 4;
			}
		});

		Button b6 = (Button) findViewById(R.id.button6);
		b6.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int change = money - price[index];
				if (money - price[index] < 0) {
					Toast.makeText(getApplicationContext(), "���� �����ؿ�", 0).show();
				} else {
					eResult.append("\t�ܾ�? " + change + "��\n");
					eResult.append("\t\t500��? " + change / 500 + "��\n");
					eResult.append("\t\t100��? " + change % 500 / 100 + "��\n");
					eResult.append("\t\t\t50��? " + change % 100 / 50 + "��\n");
					eResult.append("\t\t\t10��? " + change % 50 / 10 + "��\n\n");

					money -= price[index];
				}
			}
		});

	}// end of onCreate
}// end of class
