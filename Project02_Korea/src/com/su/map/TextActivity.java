package com.su.map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class TextActivity extends Activity{
	String [] str = {"������", "������", "��󳲵�", "���ϵ�", "����������","�︪������" , "���󳲵�", "����ϵ�", 
			"��û����", "��û�ϵ�", "���ֵ�"};

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);

		GridView gv = (GridView)findViewById(R.id.gridView1);
		MyAdapter adapter = new MyAdapter(getApplicationContext(), str, R.layout.text_row);
		gv.setAdapter(adapter);
		
		gv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
//				Toast.makeText(getApplicationContext(), str[position], 0).show();
				Intent intent = new Intent(getApplicationContext(), RowActivity.class);
				intent.putExtra("����", position);
				startActivity(intent);
			}
		});
		


	}//end of onCreate

	class MyAdapter extends BaseAdapter {
		String[] str;
		int row;
		LayoutInflater lif;

		public MyAdapter(Context context, String[] str, int row) {
			this.str = str;
			this.row = row;
			this.lif = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		}

		public int getCount() {
			return str.length;
		}

		public Object getItem(int position) {
			return str[position];
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = lif.inflate(row, null);
			}
			
			TextView tv = (TextView)convertView.findViewById(R.id.textView1);
			tv.setText(str[position]);
			
			return convertView;
		}

	}

}//end of class

