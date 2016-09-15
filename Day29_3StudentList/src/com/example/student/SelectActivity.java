package com.example.student;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SelectActivity extends Activity{

	MySQLite3 helper;
	//	SQLiteDatabase db;
	//	ArrayList<MyStudent> arrStu;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select);

		Button b_insert = (Button)findViewById(R.id.button1);
		Button b_update = (Button)findViewById(R.id.button2);
		Button b_delete = (Button)findViewById(R.id.button3);
		Button b_main = (Button)findViewById(R.id.button4);

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
		b_main.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(intent);
				finish();				
			}
		});








		//		arrStu = new ArrayList<SelectActivity.MyStudent>();
		//		
		//		ListView lv = (ListView)findViewById(R.id.listView1);
		//		MyAdapter adapter = new MyAdapter(getApplicationContext(),R.layout.row, arrStu);
		//		lv.setAdapter(adapter);

		//		
		//		helper = new MySQLite3(getApplicationContext(), "Student2.db", null, 1);
		//		
		//		db = helper.getReadableDatabase();
		//		Cursor c = db.query("student", null, null, null, null, null, null);
		//		
		//		
		//		while (c.moveToNext()) {
		//			int p = c.getInt(c.getColumnIndex("p"));
		//			String name = c.getString(c.getColumnIndex("name"));
		//			int id = c.getInt(c.getColumnIndex("id"));
		//			int ko = c.getInt(c.getColumnIndex("ko"));
		//			int en = c.getInt(c.getColumnIndex("en"));
		//			int ma = c.getInt(c.getColumnIndex("ma"));
		//			
		////			i = p;
		////			arrStu.add(i, new MyStudent(name, id, ko, ma, en));
		//			arrStu.add(new MyStudent(name, id, ko, ma, en));
		//			
		//		}

		// DataBase에서 읽어서 ListView에 보여주기 - 1. 배열사용

		//		SQLiteDatabase db = helper.getReadableDatabase();
		//		Cursor c = db.query("student", null, null, null, null, null, null);
		//		
		//		MyStudent arrS[] = new MyStudent[c.getCount()];
		//		
		//		int i = 0;
		//		while (c.moveToNext()) {
		//			arrS[i] = new MyStudent(c.getString(c.getColumnIndex("name")),
		//					c.getInt(c.getColumnIndex("id")),
		//					c.getInt(c.getColumnIndex("ko")),
		//					c.getInt(c.getColumnIndex("ma")),
		//					c.getInt(c.getColumnIndex("en")));
		//			i++;
		//		}
		//		
		//		ListView lv = (ListView)findViewById(R.id.listView1);
		//		MyAdapter adapter = new MyAdapter(getApplicationContext(),R.layout.row, arrS);
		//		lv.setAdapter(adapter);
		// DataBase에서 읽어서 ListView에 보여주기 - 2. ArrayList
		//		
		//		SQLiteDatabase db = helper.getReadableDatabase();
		//		Cursor c = db.query("student", null, null, null, null, null, null);
		//		
		//		ArrayList<MyStudent> al = new ArrayList<SelectActivity.MyStudent>();
		//
		//		while (c.moveToNext()) {
		//			al.add(new MyStudent(c.getString(c.getColumnIndex("name")),
		//					c.getInt(c.getColumnIndex("id")),
		//					c.getInt(c.getColumnIndex("ko")),
		//					c.getInt(c.getColumnIndex("ma")),
		//					c.getInt(c.getColumnIndex("en"))));
		//		}
		//		
		//		ListView lv = (ListView)findViewById(R.id.listView1);
		//		MyAdapter adapter = new MyAdapter(getApplicationContext(),R.layout.row, al);
		//		lv.setAdapter(adapter);
		// DataBase에서 읽어서 ListView에 보여주기 - 2. ArrayList
		//		
		//		SQLiteDatabase db = helper.getReadableDatabase();
		//		Cursor c = db.query("student", null, null, null, null, null, null);
		//		
		//		ArrayList<MyStudent> al = new ArrayList<SelectActivity.MyStudent>();
		//
		//		while (c.moveToNext()) {
		//			al.add(new MyStudent(c.getString(c.getColumnIndex("name")),
		//					c.getInt(c.getColumnIndex("id")),
		//					c.getInt(c.getColumnIndex("ko")),
		//					c.getInt(c.getColumnIndex("ma")),
		//					c.getInt(c.getColumnIndex("en"))));
		//		}
		//		
		//		ListView lv = (ListView)findViewById(R.id.listView1);
		//		MyAdapter adapter = new MyAdapter(getApplicationContext(),R.layout.row, al);
		//		lv.setAdapter(adapter);
		// DataBase에서 읽어서 ListView에 보여주기 - 3. CursorAdapter

		helper = new MySQLite3(getApplicationContext(), "Student3.db", null, 1);
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor c = db.query("student", null, null, null, null, null, null);


		ListView lv = (ListView)findViewById(R.id.listView1);
		MyAdapter adapter = new MyAdapter(getApplicationContext(), c, false, R.layout.row);
		lv.setAdapter(adapter);







	}//end of onCreate

	class MyStudent {
		String name;
		int id;
		int ko;
		int ma;
		int en;

		public MyStudent(String name, int id, int ko, int ma, int en) {
			this.name = name;
			this.id = id;
			this.ko = ko;
			this.ma = ma;
			this.en = en;
		}



	}
	//
	//	class MyAdapter extends BaseAdapter{
	//		int row;
	//		ArrayList<MyStudent> al;
	//		LayoutInflater lif;
	//		Cursor c;
	//		MyStudent[] arrS;
	//// 배열 사용시 생성자		
	//		public MyAdapter(Context context, int row, MyStudent[] arrS) {
	//			this.row = row;
	//			this.arrS = arrS;
	//			this.lif = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
	//		}
	//// Arraylist 사용시 생성자
	//		public MyAdapter(Context context, int row,ArrayList<MyStudent> al) {
	//			this.row = row;
	//			this.al = al;
	//			this.lif = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
	//		}
	//
	//
	//		public int getCount() {
	//			// 배열 사용시
	////			return arrS.length;
	//			// ArrayList 사용시	
	//			return al.size();
	//		}
	//
	//		public Object getItem(int position) {
	//			// 배열 사용시
	////			return arrS[position];
	//			// ArrayList 사용시	
	//			return al.get(position);
	//		}
	//
	//		public long getItemId(int position) {
	//			return position;
	//		}
	//
	//		public View getView(int position, View convertView, ViewGroup parent) {
	//			if (convertView==null) {
	//				convertView = lif.inflate(row, null);
	//			}
	//			
	//			TextView tv_num = (TextView)convertView.findViewById(R.id.num);
	//			TextView tv_name = (TextView)convertView.findViewById(R.id.nm);
	//			TextView tv_ko = (TextView)convertView.findViewById(R.id.ks);
	//			TextView tv_ma = (TextView)convertView.findViewById(R.id.ms);
	//			TextView tv_en = (TextView)convertView.findViewById(R.id.es);
	//			
	////			tv_num.setText(arrStu.get(position).id+"");
	////			tv_name.setText(arrStu.get(position).name);
	////			tv_ko.setText(arrStu.get(position).ko+"");
	////			tv_ma.setText(arrStu.get(position).ma+"");
	////			tv_en.setText(arrStu.get(position).en+"");
	//			
	//			
	//// 배열 사용시			
	////			tv_num.setText(arrS[position].id+"");
	////			tv_name.setText(arrS[position].name);
	////			tv_ko.setText(arrS[position].ko+"");
	////			tv_ma.setText(arrS[position].ma+"");
	////			tv_en.setText(arrS[position].en+"");
	//			
	//// ArrayList 사용시			
	//			MyStudent s = al.get(position);
	//			tv_num.setText(s.id+"");
	//			tv_name.setText(s.name);
	//			tv_ko.setText(s.ko+"");
	//			tv_ma.setText(s.ma+"");
	//			tv_en.setText(s.en+"");
	//			
	//			
	//			
	//			
	//			return convertView;
	//		}
	//		
	//	}

	class MyAdapter extends CursorAdapter{
		int row;

		public MyAdapter(Context context, Cursor c, boolean autoRequery, int row) {
			super(context, c, autoRequery);
			this.row = row;
		}
		// 한 행에 해당하는 View를 생성 : xml에서 가져온 layout을 객체로 준비
		public View newView(Context context, Cursor cursor, ViewGroup parent) {
			LayoutInflater lif = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			View view = lif.inflate(row, null);
			return view;
		}

		// newView에서 준비한 한 행의 뷰를 어떤 데이터와 연결할지 설정
		public void bindView(View view, Context context, Cursor cursor) {
			TextView tv_num = (TextView)view.findViewById(R.id.num);
			TextView tv_name = (TextView)view.findViewById(R.id.nm);
			TextView tv_ko = (TextView)view.findViewById(R.id.ks);
			TextView tv_ma = (TextView)view.findViewById(R.id.ms);
			TextView tv_en = (TextView)view.findViewById(R.id.es);
			
			tv_num.setText(cursor.getString(cursor.getColumnIndex("num"))+"");
			tv_name.setText(cursor.getString(cursor.getColumnIndex("name")));
			tv_ko.setText(cursor.getString(cursor.getColumnIndex("ko"))+"");
			tv_ma.setText(cursor.getString(cursor.getColumnIndex("ma"))+"");
			tv_en.setText(cursor.getString(cursor.getColumnIndex("en"))+"");
			
			
			
			
		}




	}











}//end of class
