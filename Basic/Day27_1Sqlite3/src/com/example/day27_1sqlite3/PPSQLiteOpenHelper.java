package com.example.day27_1sqlite3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * sqlite3 : 모바일용으로 적합한, 경량화된 데이터베이스 프로그램, iPhone, 안드로이드 등에서 사용 안드로이드에서는
 * SQLiteOpenHelper 클래스를 통해서 손쉽게 사용할 수 있다
 */
public class PPSQLiteOpenHelper extends SQLiteOpenHelper {
	// 생성자
	public PPSQLiteOpenHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);

	}

	public void onCreate(SQLiteDatabase db) {
		// 데이터베이스를 처음 생성할 떄 호출하는 메서드, 테이블 초기화작업

		String str = "create table desk(id integer, name text);";
		db.execSQL(str);

	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// 데이터 베이스의 업그레이드를 할 때 호출하는 메서드
		// 버젼이 업그레이드 되었을 때 내부 구성을 어떻게 바꿀지에 대한 정의
		// 우리는 기존 테이블을 삭제하고, 새로 테이블 만들자
		String str = "drop table if exists desk";
		db.execSQL(str);

		onCreate(db);// 테이블을 새롭게 작성

	}

}
