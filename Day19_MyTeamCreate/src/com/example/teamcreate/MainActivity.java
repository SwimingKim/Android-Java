package com.example.teamcreate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnCheckedChangeListener {

	CheckBox cb1;
	CheckBox cb2;
	CheckBox cb3;
	CheckBox cb4;
	CheckBox cb5;
	CheckBox cb6;
	CheckBox cb7;
	CheckBox cb8;
	CheckBox cb9;
	CheckBox cb10;
	CheckBox cb11;
	CheckBox cb12;
	TextView tMember;
	TextView tNum;
	String man[];

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		cb1 = (CheckBox) findViewById(R.id.checkBox1);
		cb2 = (CheckBox) findViewById(R.id.checkBox2);
		cb3 = (CheckBox) findViewById(R.id.checkBox3);
		cb4 = (CheckBox) findViewById(R.id.checkBox4);
		cb5 = (CheckBox) findViewById(R.id.checkBox5);
		cb6 = (CheckBox) findViewById(R.id.checkBox6);
		cb7 = (CheckBox) findViewById(R.id.checkBox7);
		cb8 = (CheckBox) findViewById(R.id.checkBox8);
		cb9 = (CheckBox) findViewById(R.id.checkBox9);
		cb10 = (CheckBox) findViewById(R.id.checkBox10);
		cb11 = (CheckBox) findViewById(R.id.checkBox11);
		cb12 = (CheckBox) findViewById(R.id.checkBox12);

		tNum = (TextView) findViewById(R.id.textView2);
		tMember = (TextView) findViewById(R.id.textView5);
		final TextView tTeam = (TextView) findViewById(R.id.textView7);

		cb1.setOnCheckedChangeListener(this);
		cb2.setOnCheckedChangeListener(this);
		cb3.setOnCheckedChangeListener(this);
		cb4.setOnCheckedChangeListener(this);
		cb5.setOnCheckedChangeListener(this);
		cb6.setOnCheckedChangeListener(this);
		cb7.setOnCheckedChangeListener(this);
		cb8.setOnCheckedChangeListener(this);
		cb9.setOnCheckedChangeListener(this);
		cb10.setOnCheckedChangeListener(this);
		cb11.setOnCheckedChangeListener(this);
		cb12.setOnCheckedChangeListener(this);

		final EditText et = (EditText) findViewById(R.id.editText1);

		Button b = (Button) findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Random ran = new Random();

				for (int i = 0; i < 50; i++) {// ¿©·¯¹ø ¼¯±â
					int index = ran.nextInt(man.length);// 0~9
					String temp = man[0];
					man[0] = man[index];
					man[index] = temp;
				}

				int team = Integer.valueOf(et.getText().toString());

				tTeam.setText("1ÆÀ " + Arrays.toString(man) + "\n2ÆÀ " + Arrays.toString(man) + "\n3ÆÀ "
						+ Arrays.toString(man) + "\n4ÆÀ " + Arrays.toString(man));

			}
		});

	}// end of onCreate

	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		String str = "";
		int num = 0;
		if (cb1.isChecked()) {
			str += cb1.getText().toString() + ",";
			num++;
		}
		if (cb2.isChecked()) {
			str += cb2.getText().toString() + ",";
			num++;
		}
		if (cb3.isChecked()) {
			str += cb3.getText().toString() + ",";
			num++;
		}
		if (cb4.isChecked()) {
			str += cb4.getText().toString() + ",";
			num++;
		}
		if (cb5.isChecked()) {
			str += cb5.getText().toString() + ",";
			num++;
		}
		if (cb6.isChecked()) {
			str += cb6.getText().toString() + ",";
			num++;
		}
		if (cb7.isChecked()) {
			str += cb7.getText().toString() + ",";
			num++;
		}
		if (cb8.isChecked()) {
			str += cb8.getText().toString() + ",";
			num++;
		}
		if (cb9.isChecked()) {
			str += cb9.getText().toString() + ",";
			num++;
		}
		if (cb10.isChecked()) {
			str += cb10.getText().toString() + ",";
			num++;
		}
		if (cb11.isChecked()) {
			str += cb11.getText().toString() + ",";
			num++;
		}
		if (cb12.isChecked()) {
			str += cb12.getText().toString() + ",";
			num++;
		}
		tMember.setText(str);
		tNum.setText(Integer.valueOf(num).toString());

		man = str.split(",");
		for (int i = 0; i < man.length; i++) {
			System.out.println(man[i]);
		}
	}

}// end of class
