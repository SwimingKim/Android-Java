package com.example.day29_2student;

import java.util.ArrayList;

import com.example.day29_2student.SelectActivity.MyStudent;

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

public class InsertActivity extends Activity {

	MySQLite3 helper;
	SQLiteDatabase db;
	ArrayList<SelectActivity.MyStudent> arrStu;

	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.insert);

		helper = new MySQLite3(getApplicationContext(), "Student2.db", null, 1);

		arrStu = new ArrayList<SelectActivity.MyStudent>();

		final EditText dt_name = (EditText) findViewById(R.id.editText1);
		final EditText dt_id = (EditText) findViewById(R.id.editText2);
		final EditText dt_ko = (EditText) findViewById(R.id.editText3);
		final EditText dt_en = (EditText) findViewById(R.id.editText4);
		final EditText dt_ma = (EditText) findViewById(R.id.editText5);

		Button b_insert = (Button) findViewById(R.id.button1);
		Button b_select = (Button) findViewById(R.id.button2);
		Button b_main = (Button) findViewById(R.id.button3);

		b_insert.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (dt_name.getText().toString().equals("") && dt_id.getText().toString().equals("")
						&& dt_ko.getText().toString().equals("") && dt_en.getText().toString().equals("")
						&& dt_ma.getText().toString().equals("")) {
					Toast.makeText(getApplicationContext(), "내용을 입력하세요", 0).show();
				} else {
					db = helper.getWritableDatabase();
					ContentValues values = new ContentValues();

					values.put("name", dt_name.getText().toString());
					values.put("id", Integer.valueOf(dt_id.getText().toString()));
					values.put("ko", Integer.valueOf(dt_ko.getText().toString()));
					values.put("en", Integer.valueOf(dt_en.getText().toString()));
					values.put("ma", Integer.valueOf(dt_ma.getText().toString()));
					db.insert("student", null, values);

					dt_name.setText("");
					dt_id.setText("");
					dt_ko.setText("");
					dt_en.setText("");
					dt_ma.setText("");
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
