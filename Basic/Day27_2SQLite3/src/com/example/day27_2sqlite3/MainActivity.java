package com.example.day27_2sqlite3;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	AddHelp helper;
	SQLiteDatabase db;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final EditText e_first_name = (EditText) findViewById(R.id.editText1);
		final EditText e_first_age = (EditText) findViewById(R.id.editText2);
		final EditText e_first_address = (EditText) findViewById(R.id.editText3);
		final EditText e_second_name = (EditText) findViewById(R.id.editText4);
		final EditText e_second_age = (EditText) findViewById(R.id.editText5);
		final EditText e_third_name = (EditText) findViewById(R.id.editText6);

		Button b_insert = (Button) findViewById(R.id.button1);
		Button b_update = (Button) findViewById(R.id.button2);
		Button b_delete = (Button) findViewById(R.id.button3);

		final TextView tv = (TextView) findViewById(R.id.textView4);

		helper = new AddHelp(getApplicationContext(), "first.db", null, 1);

		db = helper.getReadableDatabase();
		Cursor c = db.query("array", null, null, null, null, null, null);

		while (c.moveToNext()) {
			int id = c.getInt(c.getColumnIndex("id"));
			String name = c.getString(c.getColumnIndex("name"));
			int age = c.getInt(c.getColumnIndex("age"));
			String address = c.getString(c.getColumnIndex("address"));

			tv.append("\n" + id + ", " + name + ", " + age + "," + address);
		}

		e_second_name.setText("");
		e_second_age.setText("");

		b_insert.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				db = helper.getWritableDatabase();
				ContentValues values = new ContentValues();
				values.put("name", e_first_name.getText().toString());
				values.put("age", Integer.valueOf(e_first_age.getText().toString()));
				values.put("address", e_first_address.getText().toString());
				long result = db.insert("array", null, values);

				db = helper.getReadableDatabase();
				Cursor c = db.query("array", null, null, null, null, null, null);

				tv.setText(result + "번째 insert 완료");
				while (c.moveToNext()) {
					int id = c.getInt(c.getColumnIndex("id"));
					String name = c.getString(c.getColumnIndex("name"));
					int age = c.getInt(c.getColumnIndex("age"));
					String address = c.getString(c.getColumnIndex("address"));

					tv.append("\n" + id + ", " + name + ", " + age + "," + address);
				}

				e_first_name.setText("");
				e_first_age.setText("");
				e_first_address.setText("");

			}
		});

		b_update.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				db = helper.getWritableDatabase();
				ContentValues values = new ContentValues();
				values.put("age", Integer.valueOf(e_second_age.getText().toString()));
				long result = db.update("array", values, "name=?", new String[] { e_second_name.getText().toString() });
				tv.setText(result + "개 update 완료");

				// db = helper.getReadableDatabase();
				// Cursor c = db.query("array", null, null, null, null, null,
				// null);
				//
				// while (c.moveToNext()) {
				// int id = c.getInt(c.getColumnIndex("id"));
				// String name = c.getString(c.getColumnIndex("name"));
				// int age = c.getInt(c.getColumnIndex("age"));
				// String address = c.getString(c.getColumnIndex("address"));
				//
				// tv.append("\n"+id + ", " + name + ", " + age + "," +
				// address);
				// }
				//
				// e_second_name.setText("");
				// e_second_age.setText("");

			}
		});

		b_delete.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				db = helper.getWritableDatabase();
				long result = db.delete("array", "name=?", new String[] { e_third_name.getText().toString() });
				tv.setText(result + "개 delete 완료");

				db = helper.getReadableDatabase();
				Cursor c = db.query("array", null, null, null, null, null, null);

				while (c.moveToNext()) {
					int id = c.getInt(c.getColumnIndex("id"));
					String name = c.getString(c.getColumnIndex("name"));
					int age = c.getInt(c.getColumnIndex("age"));
					String address = c.getString(c.getColumnIndex("address"));

					tv.append("\n" + id + ", " + name + ", " + age + "," + address);
				}

				e_third_name.setText("");

			}
		});

	}// end of onCreate
}// end of class
