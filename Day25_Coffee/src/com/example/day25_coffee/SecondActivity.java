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
	Coffee[] co = { new Coffee("에스프레소", true, false, false, false, "머리가 맑아지게 아주 쎈 커피를 마셔야겠어요"),
			new Coffee("아메리카노", true, false, true, false, "리얼 아메리칸 스타일로 부탁드립니다"),
			new Coffee("카페라떼", true, true, false, false, "따끈한 우유와 함께 커피를 마시고 싶어요"),
			new Coffee("바닐라라떼", true, true, false, true, "달달하고 독특한 향이 나는 것을 좋아합니다"), new Coffee() };

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

				if (!!(tv.getText().toString().equals("이봐요 나 까다로운 사람이에요. 당신이 내 커피 만들 수 있을까??"))) {
					Toast.makeText(getApplicationContext(), "시작을 눌러주세요", 1).show();
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
