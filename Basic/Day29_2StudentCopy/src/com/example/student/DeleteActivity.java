package com.example.student;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DeleteActivity extends Activity {
	MySQLite3 helper;
	SQLiteDatabase db;

	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.delete);

		Button b_delete = (Button) findViewById(R.id.button1);
		Button b_select = (Button) findViewById(R.id.button2);
		Button b_main = (Button) findViewById(R.id.button3);

		final EditText et = (EditText) findViewById(R.id.editText1);

		helper = new MySQLite3(getApplicationContext(), "Student2.db", null, 1);

		b_delete.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				db = helper.getWritableDatabase();
				db.delete("student", "name=?", new String[] { et.getText().toString() });
				et.setText("");

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
