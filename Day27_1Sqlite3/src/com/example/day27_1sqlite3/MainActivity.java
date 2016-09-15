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

		Log.d("sqlite3", "onCreat ����");
		b_create.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// ��ü���� - ������ ȣ��
				helper = new PPSQLiteOpenHelper(getApplicationContext(), // ����ȭ����
																			// �������
						"myfile4.db", // �����ͺ��̽� ���ϸ�
						null, // ǥ�� Ŀ�����
						1);// �����ͺ��̽�����
				Log.d("sqlite3", "DB ��ü ����");
			}
		});

		// ������ ���� - insert
		b_insert.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				db = helper.getWritableDatabase();
				// db.execSQL("insert into desk values (1, 'ȫ')");
				ContentValues values = new ContentValues();// insert�� ������ �ۼ�
				values.put("id", 3);
				values.put("name", "����");
				long result = db.insert("desk", null, values);
				Log.d("sqlite3", result + "��° insert �Ϸ�");

			}
		});

		b_select.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// ������ ��ȸ - select
				db = helper.getReadableDatabase();// �б�����
				Cursor c = db.query("desk", null, null, null, null, null, null);
				// ���̺��

				while (c.moveToNext()) {
					// ���� �����ͷ� Ŀ�� �̵�, ���� �����Ͱ� �����ϸ� true
					int id = c.getInt(c.getColumnIndex("id"));
					String name = c.getString(c.getColumnIndex("name"));

					Log.d("sqlite3", "id : " + id + ", name : " + name);
				}

				Log.d("sqlite3", "select �Ϸ�");

			}
		});

		b_update.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// ���� : update
				db = helper.getWritableDatabase();
				ContentValues values = new ContentValues();
				values.put("name", "���α�");
				int result = db.update("desk", values, // ����� ��������
						"id=?", // � �׸���
						new String[] { "5" });// �̷��� ���� �����͸� �����϶�
				Log.d("sqlite3", result + "�� update �Ϸ�");

			}
		});

		b_delete.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// ���� : delete
				db = helper.getWritableDatabase();
				int result = db.delete("desk", "id=?", new String[] { "3" });
				Log.d("sqlite3", result + "�� delete �Ϸ�");
			}
		});

		b_drop.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// ���̺� ���� : drop
				db = helper.getWritableDatabase();
				db.execSQL("drop table if exists desk");
				Log.d("sqlite3", "drop �Ϸ�");
			}
		});

	}// end of onCreate
}// end of class
