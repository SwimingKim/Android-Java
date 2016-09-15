package com.example.day27_1sqlite3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * sqlite3 : ����Ͽ����� ������, �淮ȭ�� �����ͺ��̽� ���α׷�, iPhone, �ȵ���̵� ��� ��� �ȵ���̵忡����
 * SQLiteOpenHelper Ŭ������ ���ؼ� �ս��� ����� �� �ִ�
 */
public class PPSQLiteOpenHelper extends SQLiteOpenHelper {
	// ������
	public PPSQLiteOpenHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);

	}

	public void onCreate(SQLiteDatabase db) {
		// �����ͺ��̽��� ó�� ������ �� ȣ���ϴ� �޼���, ���̺� �ʱ�ȭ�۾�

		String str = "create table desk(id integer, name text);";
		db.execSQL(str);

	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// ������ ���̽��� ���׷��̵带 �� �� ȣ���ϴ� �޼���
		// ������ ���׷��̵� �Ǿ��� �� ���� ������ ��� �ٲ����� ���� ����
		// �츮�� ���� ���̺��� �����ϰ�, ���� ���̺� ������
		String str = "drop table if exists desk";
		db.execSQL(str);

		onCreate(db);// ���̺��� ���Ӱ� �ۼ�

	}

}
