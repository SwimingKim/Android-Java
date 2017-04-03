package com.example.student;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

//	MySQLite3 helper;
	SQLiteDatabase db;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		MySQLite3 helper = new MySQLite3(getApplicationContext(), "Student3.db", null, 1);
		
		Button b_insert = (Button)findViewById(R.id.button1);
		Button b_update = (Button)findViewById(R.id.button2);
		Button b_delete = (Button)findViewById(R.id.button3);
		Button b_select = (Button)findViewById(R.id.button4);
		
		b_insert.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), InsertActivity.class);
				startActivity(intent);
				finish();				
			}
		});
		b_update.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), UpdateActivity.class);
				startActivity(intent);
				finish();				
			}
		});
		b_delete.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), DeleteActivity.class);
				startActivity(intent);
				finish();				
			}
		});
		b_select.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), SelectActivity.class);
				startActivity(intent);
				finish();				
			}
		});
		
		
		
		
	}//end of onCreate
}//end of class

class MySQLite3 extends SQLiteOpenHelper{

	public MySQLite3(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table student (_id integer primary key autoincrement, name text, "
				+ "num integer, ko integer, en integer, ma integer);");
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists table");
		onCreate(db);
	}
	
}