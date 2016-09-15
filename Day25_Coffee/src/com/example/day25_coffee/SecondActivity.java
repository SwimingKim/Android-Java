package com.example.day25_coffee;

import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends MainActivity {
	// Coffee(String menu,boolean esp, boolean milk, boolean water, boolean
	// syrup)
	Coffee[] co = { new Coffee("����������", true, false, false, false, "�Ӹ��� �������� ���� �� Ŀ�Ǹ� ���ž߰ھ��"),
			new Coffee("�Ƹ޸�ī��", true, false, true, false, "���� �Ƹ޸�ĭ ��Ÿ�Ϸ� ��Ź�帳�ϴ�"),
			new Coffee("ī���", true, true, false, false, "������ ������ �Բ� Ŀ�Ǹ� ���ð� �;��"),
			new Coffee("�ٴҶ��", true, true, false, true, "�޴��ϰ� ��Ư�� ���� ���� ���� �����մϴ�"), new Coffee() };

	int num = 0;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.second);

		Button b_hint = (Button) findViewById(R.id.button1);
		Button b_start = (Button) findViewById(R.id.button2);
		final TextView tv = (TextView) findViewById(R.id.textView1);

		b_hint.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				num = new Random().nextInt(4);
				tv.setText(co[num].hint);
			}
		});

		b_start.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);

				if (!!(tv.getText().toString().equals("�̺��� �� ��ٷο� ����̿���. ����� �� Ŀ�� ���� �� ������??"))) {
					Toast.makeText(getApplicationContext(), "������ �����ּ���", 1).show();
					return;
				}

				for (int i = 0; i < co.length; i++) {
					if (co[num].hint.equals(tv.getText().toString())) {
						intent.putExtra("co_menu", co[num].menu);
						intent.putExtra("co_esp", co[num].esp);
						intent.putExtra("co_milk", co[num].milk);
						intent.putExtra("co_water", co[num].water);
						intent.putExtra("co_syrup", co[num].syrup);
						intent.putExtra("co_hint", co[num].hint);
					}
				}

				startActivity(intent);

			}
		});

	}// end of onCreate
}// end of class

class Coffee {
	String menu;
	boolean esp;
	boolean milk;
	boolean water;
	boolean syrup;
	String hint;

	public Coffee() {
	}

	public Coffee(String menu, boolean esp, boolean milk, boolean water, boolean syrup, String hint) {
		this.menu = menu;
		this.esp = esp;
		this.milk = milk;
		this.water = water;
		this.syrup = syrup;
		this.hint = hint;
	}

}
