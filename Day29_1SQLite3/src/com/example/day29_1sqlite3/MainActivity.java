package com.example.day29_1sqlite3;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	MySQLiteOpenHelper helper;
	SQLiteDatabase db;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// DB�� Ȱ���ϴ� ��� - sqLite3 (����Ͽ����� ����, �淮ȭ), Oracle, mySQL
		// sqLite3�� ����ϱ� ���ؼ� SQLiteOpenHelper Ŭ������ Ȱ��

		helper = new MySQLiteOpenHelper(getApplicationContext(), "st_file.db", null, 1);
		Log.d("sqlite3", "MySQLiteOpenHelper �ʱ�ȭ ����");
		// ������ ���� - insert
		{
			db = helper.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("name", "���α�");
			values.put("kor", 80);
			db.insert("student", null, values);
			Log.d("sqlite3", "insert �Ϸ�");
		}

		// ������ ���� - delete
		// db = helper.getWritableDatabase();
		// db.delete("student", "name=?", new String[] {"���α�"});
		// Log.d("sqlite3", "delete �Ϸ�");

		// ������ ���� - update
		{
			db = helper.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("kor", 90);
			db.update("student", values, "name=?", new String[] { "���α�" });
			Log.d("sqlite3", "update �Ϸ�");
		}

		// ������ ��ȸ - select
		{
			db = helper.getReadableDatabase();
			Cursor c = db.query("student", null, null, null, null, null, null);
			while (c.moveToNext()) {
				int id = c.getInt(c.getColumnIndex("id"));
				String name = c.getString(c.getColumnIndex("name"));
				int kor = c.getInt(c.getColumnIndex("kor"));
				Log.d("sqlite3", id + "&" + name + "&" + kor);
			}
			Log.d("sqlite3", "select�Ϸ�");

		}

	}// end of onCreate
}// end of class

class MySQLiteOpenHelper extends SQLiteOpenHelper {

	public MySQLiteOpenHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);

	}

	public void onCreate(SQLiteDatabase db) {
		// ó�� �����ͺ��̽� ���̺��� ������ �� - sql�� create�� ����
		db.execSQL("create table student (id integer primary key autoincrement, name text, kor integer)");
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// �����ͺ��̽��� ������ ����Ǿ ���׷��̵尡 �ʿ��� �� - �츮�� ���̺� drop�� �ٽ� create ����
		db.execSQL("drop table if exists student"); // drop
		onCreate(db); // create
	}

}
