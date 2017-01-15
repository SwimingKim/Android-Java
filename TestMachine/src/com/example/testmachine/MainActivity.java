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
				eResult.append("\t넣은 돈? " + num + "원\n");
				money += num;
				eResult.append("\t총 넣은 돈? " + money + "원\n\n");
				eMoney.setText("");
			}
		});

		Button b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				eResult.append("\t선택한 제품? 사이다\n");
				eResult.append("\t선택한 제품의 가격? 960원\n\n");
				int index = 1;
			}
		});

		Button b2 = (Button) findViewById(R.id.button2);
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				eResult.append("\t선택한 제품? 옥수수수염차\n");
				eResult.append("\t선택한 제품의 가격? 1120원\n\n");
				int index = 2;
			}
		});

		Button b3 = (Button) findViewById(R.id.button3);
		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				eResult.append("\t선택한 제품? 아이스아메리카노\n");
				eResult.append("\t선택한 제품의 가격? 1340원\n\n");
				int index = 3;
			}
		});

		Button b4 = (Button) findViewById(R.id.button4);
		b4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				eResult.append("\t선택한 제품? 유자차\n");
				eResult.append("\t선택한 제품의 가격? 2350원\n\n");
				int index = 4;
			}
		});

		Button b6 = (Button) findViewById(R.id.button6);
		b6.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int change = money - price[index];
				if (money - price[index] < 0) {
					Toast.makeText(getApplicationContext(), "돈이 부족해요", 0).show();
				} else {
					eResult.append("\t잔액? " + change + "원\n");
					eResult.append("\t\t500원? " + change / 500 + "개\n");
					eResult.append("\t\t100원? " + change % 500 / 100 + "개\n");
					eResult.append("\t\t\t50원? " + change % 100 / 50 + "개\n");
					eResult.append("\t\t\t10원? " + change % 50 / 10 + "개\n\n");

					money -= price[index];
				}
			}
		});

	}// end of onCreate
}// end of class
