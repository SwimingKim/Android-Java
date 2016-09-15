package com.example.memo;

import java.util.List;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Help helper;
	SQLiteDatabase db;
	Text[] t = new Text[100];

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		helper = new Help(getApplicationContext(), "memo.db", null, 1);

		ListView lv = (ListView) findViewById(R.id.listView1);
		MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.row);
		lv.setAdapter(adapter);

		final EditText e_first_id = (EditText) findViewById(R.id.editText1);
		final EditText e_first_write = (EditText) findViewById(R.id.editText2);
		final EditText e_second_id = (EditText) findViewById(R.id.editText5);
		final EditText e_second_write = (EditText) findViewById(R.id.editText4);
		final EditText e_third_id = (EditText) findViewById(R.id.editText6);
		final EditText e_third_write = (EditText) findViewById(R.id.editText3);

		Button b_insert = (Button) findViewById(R.id.button1);
		Button b_update = (Button) findViewById(R.id.button2);
		Button b_delete = (Button) findViewById(R.id.button3);

		b_insert.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				db = helper.getWritableDatabase();
				ContentValues values = new ContentValues();
				values.put("write", e_first_write.getText().toString());
				long result = db.insert("list", null, values);
				Toast.makeText(getApplicationContext(), result + "¹øÂ° insert", 1).show();

				db = helper.getReadableDatabase();
				Cursor c = db.query("list", null, null, null, null, null, null);

				int a = 0;
				while (c.moveToNext()) {
					int id = c.getInt(c.getColumnIndex("num"));
					String write = c.getString(c.getColumnIndex("write"));
					t[a] = new Text();
					t[a].setNum(id);
					t[a].setWrite(write);
					a++;
					Toast.makeText(getApplicationContext(), "\n" + t[a].num + ", " + t[a].write, 0).show();
					// Log.d("sqlite3", t[a].num+","+t[a].write);
				}

			}
		});

		b_update.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

			}
		});

		b_delete.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				db = helper.getWritableDatabase();
				long result = db.delete("list", "num=?", new String[] { e_third_id.getText().toString() });
				Toast.makeText(getApplicationContext(), result + "°³ delete", 1).show();

				db = helper.getReadableDatabase();
				Cursor c = db.query("list", null, null, null, null, null, null);

				while (c.moveToNext()) {
					int id = c.getInt(c.getColumnIndex("num"));
					String write = c.getString(c.getColumnIndex("write"));
					Toast.makeText(getApplicationContext(), "\n" + id + ", " + write, 1).show();
				}

			}

		});

	}// end of onCreate

	class MyAdapter extends BaseAdapter {
		int row;
		LayoutInflater lif;

		public MyAdapter(Context context, int row) {
			this.row = row;
			this.lif = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return t.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return t[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = lif.inflate(row, null);
			}

			TextView tv_num = (TextView) convertView.findViewById(R.id.textView1);
			TextView tv_write = (TextView) convertView.findViewById(R.id.textView2);

			// tv_num.setText(Integer.valueOf(t[position].num)+"");
			// tv_write.setText(t[position].write);

			return convertView;
		}

	}

	class Text {
		int num;
		String write;

		public Text() {
		}

		public Text(int num, String write) {
			this.num = num;
			this.write = write;
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public String getWrite() {
			return write;
		}

		public void setWrite(String write) {
			this.write = write;
		}

	}

}// end of class
