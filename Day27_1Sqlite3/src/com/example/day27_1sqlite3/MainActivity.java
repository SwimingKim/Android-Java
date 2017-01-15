package com.example.day27_1sqlite3;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	PPSQLiteOpenHelper helper;
	SQLiteDatabase db;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button b_create = (Button) findViewById(R.id.button1);
		Button b_insert = (Button) findViewById(R.id.button2);
		Button b_update = (Button) findViewById(R.id.button3);
		Button b_delete = (Button) findViewById(R.id.button4);
		Button b_drop = (Button) findViewById(R.id.button5);
		Button b_select = (Button) findViewById(R.id.button6);

		Log.d("sqlite3", "onCreat 시작");
		b_create.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 객체생성 - 생성자 호출
				helper = new PPSQLiteOpenHelper(getApplicationContext(), // 현재화면의
																			// 제어권자
						"myfile4.db", // 데이터베이스 파일명
						null, // 표준 커서사용
						1);// 데이터베이스버전
				Log.d("sqlite3", "DB 객체 생성");
			}
		});

		// 데이터 삽입 - insert
		b_insert.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				db = helper.getWritableDatabase();
				// db.execSQL("insert into desk values (1, '홍')");
				ContentValues values = new ContentValues();// insert할 내용을 작성
				values.put("id", 3);
				values.put("name", "하하");
				long result = db.insert("desk", null, values);
				Log.d("sqlite3", result + "번째 insert 완료");

			}
		});

		b_select.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 데이터 조회 - select
				db = helper.getReadableDatabase();// 읽기전용
				Cursor c = db.query("desk", null, null, null, null, null, null);
				// 테이블명

				while (c.moveToNext()) {
					// 다음 데이터로 커서 이동, 다음 데이터가 존재하면 true
					int id = c.getInt(c.getColumnIndex("id"));
					String name = c.getString(c.getColumnIndex("name"));

					Log.d("sqlite3", "id : " + id + ", name : " + name);
				}

				Log.d("sqlite3", "select 완료");

			}
		});

		b_update.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 수정 : update
				db = helper.getWritableDatabase();
				ContentValues values = new ContentValues();
				values.put("name", "서민규");
				int result = db.update("desk", values, // 뭐라고 수정할지
						"id=?", // 어떤 항목이
						new String[] { "5" });// 이런한 값인 데이터를 수정하라
				Log.d("sqlite3", result + "개 update 완료");

			}
		});

		b_delete.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 제거 : delete
				db = helper.getWritableDatabase();
				int result = db.delete("desk", "id=?", new String[] { "3" });
				Log.d("sqlite3", result + "개 delete 완료");
			}
		});

		b_drop.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 테이블 삭제 : drop
				db = helper.getWritableDatabase();
				db.execSQL("drop table if exists desk");
				Log.d("sqlite3", "drop 완료");
			}
		});

	}// end of onCreate
}// end of class
