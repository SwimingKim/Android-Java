package com.example.student;

import java.util.ArrayList;
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
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class SelectActivity extends Activity {

	MySQLite3 helper;
	SQLiteDatabase db;
	ArrayList<MyStudent> arrStu;
	int i = 0;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select);

		Button b_insert = (Button) findViewById(R.id.button1);
		Button b_update = (Button) findViewById(R.id.button2);
		Button b_delete = (Button) findViewById(R.id.button3);
		Button b_main = (Button) findViewById(R.id.button4);

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

		arrStu = new ArrayList<SelectActivity.MyStudent>();

		ListView lv = (ListView) findViewById(R.id.listView1);
		MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.row, arrStu);
		lv.setAdapter(adapter);

		// TextView tv = (TextView)findViewById(R.id.textView1);

		// tv.append("\n이름\t\t|\t\t학번\t\t|\t\t국어\t\t|\t\t영어\t\t|\t\t수학");

		helper = new MySQLite3(getApplicationContext(), "Student2.db", null, 1);

		db = helper.getReadableDatabase();
		Cursor c = db.query("student", null, null, null, null, null, null);

		// tv.setText("학생 목록");

		while (c.moveToNext()) {
			int p = c.getInt(c.getColumnIndex("p"));
			String name = c.getString(c.getColumnIndex("name"));
			int id = c.getInt(c.getColumnIndex("id"));
			int ko = c.getInt(c.getColumnIndex("ko"));
			int en = c.getInt(c.getColumnIndex("en"));
			int ma = c.getInt(c.getColumnIndex("ma"));

			// i = p;
			// arrStu.add(i, new MyStudent(name, id, ko, ma, en));
			arrStu.add(new MyStudent(name, id, ko, ma, en));

			// tv.append("\n"+name+"\t\t|\t\t"+id+"\t\t|\t\t"+ko+"\t\t|\t\t"+en+"\t\t|\t\t"+ma);
		}

	}// end of onCreate

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

	class MyAdapter extends BaseAdapter {
		int row;
		ArrayList<MyStudent> arrStu;
		LayoutInflater lif;

		public MyAdapter(Context context, int row, ArrayList<MyStudent> arrStu) {
			this.row = row;
			this.arrStu = arrStu;
			this.lif = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		}

		public int getCount() {
			return arrStu.size();
		}

		public Object getItem(int position) {
			return arrStu.get(position);
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = lif.inflate(row, null);
			}

			TextView tv_num = (TextView) convertView.findViewById(R.id.num);
			TextView tv_name = (TextView) convertView.findViewById(R.id.nm);
			TextView tv_ko = (TextView) convertView.findViewById(R.id.ks);
			TextView tv_ma = (TextView) convertView.findViewById(R.id.ms);
			TextView tv_en = (TextView) convertView.findViewById(R.id.es);

			tv_num.setText(arrStu.get(position).id + "");
			tv_name.setText(arrStu.get(position).name);
			tv_ko.setText(arrStu.get(position).ko + "");
			tv_ma.setText(arrStu.get(position).ma + "");
			tv_en.setText(arrStu.get(position).en + "");

			return convertView;
		}

	}

}// end of class
