package com.example.day29_2student;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends Activity {
	MySQLite3 helper;
	SQLiteDatabase db;

	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.update);

		helper = new MySQLite3(getApplicationContext(), "Student2.db", null, 1);

		Button b_update = (Button) findViewById(R.id.button1);
		Button b_select = (Button) findViewById(R.id.button2);
		Button b_main = (Button) findViewById(R.id.button3);

		final EditText et_name = (EditText) findViewById(R.id.editText1);
		final EditText et_ko = (EditText) findViewById(R.id.editText3);
		final EditText et_ma = (EditText) findViewById(R.id.editText4);
		final EditText et_en = (EditText) findViewById(R.id.editText5);

		b_update.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (et_ko.getText().toString().equals("") && et_ma.getText().toString().equals("")
						&& et_en.getText().toString().equals("")) {
					Toast.makeText(getApplicationContext(), "내용을 입력해주세요", 0).show();
				} else {
					db = helper.getWritableDatabase();
					ContentValues values = new ContentValues();
					values.put("ko", Integer.valueOf(et_ko.getText().toString()));
					values.put("en", Integer.valueOf(et_en.getText().toString()));
					values.put("ma", Integer.valueOf(et_ma.getText().toString()));

					db.update("student", values, "name=?", new String[] { et_name.getText().toString() });

					et_name.setText("");
					et_ko.setText("");
					et_ma.setText("");
					et_en.setText("");

				}

			}
		});

		b_select.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), SelectActivity.class);
				startActivity(intent);
				finish();

			}
		});

		b_main.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}

}
