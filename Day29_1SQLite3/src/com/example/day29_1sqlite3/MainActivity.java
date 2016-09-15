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

		// DB를 활용하는 방법 - sqLite3 (모바일용으로 적합, 경량화), Oracle, mySQL
		// sqLite3를 사용하기 위해서 SQLiteOpenHelper 클래스를 활용

		helper = new MySQLiteOpenHelper(getApplicationContext(), "st_file.db", null, 1);
		Log.d("sqlite3", "MySQLiteOpenHelper 초기화 성공");
		// 데이터 삽입 - insert
		{
			db = helper.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("name", "서민규");
			values.put("kor", 80);
			db.insert("student", null, values);
			Log.d("sqlite3", "insert 완료");
		}

		// 데이터 삭제 - delete
		// db = helper.getWritableDatabase();
		// db.delete("student", "name=?", new String[] {"서민규"});
		// Log.d("sqlite3", "delete 완료");

		// 데이터 수정 - update
		{
			db = helper.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("kor", 90);
			db.update("student", values, "name=?", new String[] { "서민규" });
			Log.d("sqlite3", "update 완료");
		}

		// 데이터 조회 - select
		{
			db = helper.getReadableDatabase();
			Cursor c = db.query("student", null, null, null, null, null, null);
			while (c.moveToNext()) {
				int id = c.getInt(c.getColumnIndex("id"));
				String name = c.getString(c.getColumnIndex("name"));
				int kor = c.getInt(c.getColumnIndex("kor"));
				Log.d("sqlite3", id + "&" + name + "&" + kor);
			}
			Log.d("sqlite3", "select완료");

		}

	}// end of onCreate
}// end of class

class MySQLiteOpenHelper extends SQLiteOpenHelper {

	public MySQLiteOpenHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);

	}

	public void onCreate(SQLiteDatabase db) {
		// 처음 데이터베이스 테이블을 생성할 때 - sql의 create문 실행
		db.execSQL("create table student (id integer primary key autoincrement, name text, kor integer)");
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// 데이터베이스의 버젼이 변경되어서 업그레이드가 필요할 때 - 우리는 테이블 drop후 다시 create 하자
		db.execSQL("drop table if exists student"); // drop
		onCreate(db); // create
	}

}
