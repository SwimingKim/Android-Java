package com.example.day12_3checkbox3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
		CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
		CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
		CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
		final TextView tv = (TextView) findViewById(R.id.textView2);

		cb1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				CheckBox cb = (CheckBox) buttonView;// ���°� �ٲ� ��ü
				tv.setText(cb.getText().toString() + (cb.isChecked() ? " üũ ��" : " üũ �� ��"));
			}
		});
		cb2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				CheckBox cb = (CheckBox) buttonView;// ���°� �ٲ� ��ü
				tv.setText(cb.getText().toString() + (cb.isChecked() ? " üũ ��" : " üũ �� ��"));
			}
		});
		cb3.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				CheckBox cb = (CheckBox) buttonView;// ���°� �ٲ� ��ü
				tv.setText(cb.getText().toString() + (cb.isChecked() ? " üũ ��" : " üũ �� ��"));
			}
		});
		cb4.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				CheckBox cb = (CheckBox) buttonView;// ���°� �ٲ� ��ü
				tv.setText(cb.getText().toString() + (cb.isChecked() ? " üũ ��" : " üũ �� ��"));
			}
		});

	}// end of onCreate
}// end of class
