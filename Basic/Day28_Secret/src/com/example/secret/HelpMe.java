package com.example.secret;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class HelpMe extends SQLiteOpenHelper {

	public HelpMe(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table array(num integer primary key autoincrement, site text, id text, pass text)");
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists array");
		onCreate(db);
	}

}
