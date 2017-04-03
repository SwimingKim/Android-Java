package com.example.day18_5spinner;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class MainActivity extends Activity {
	String[] data = { "월", "화", "수", "목", "금", "토", "일" };

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 아답타뷰
		// 1.다량의 데이터
		// 2.아답타구성(layout, 클래스 작성)
		// 3.아답타뷰에 아답타등록
		Spinner s = (Spinner) findViewById(R.id.spinner1);

		MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.row, data);
		s.setAdapter(adapter);
		
		

	}// end of onCreate
}// end of class

class MyAdapter implements SpinnerAdapter {
	int row;
	String[] data;
	LayoutInflater lif;

	public MyAdapter() {
	}

	public MyAdapter(Context context, int row, String[] data) {
		this.row = row;
		this.data = data;
		this.lif = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return data.length;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public int getItemViewType(int position) {
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = lif.inflate(row, null);
		}

		TextView tv = (TextView) convertView.findViewById(R.id.textView1);
		tv.setText(data[position]);

		return convertView;
	}

	public int getViewTypeCount() {
		return 0;
	}

	public boolean hasStableIds() {
		return false;
	}

	public boolean isEmpty() {
		return false;
	}

	public void registerDataSetObserver(DataSetObserver arg0) {

	}

	public void unregisterDataSetObserver(DataSetObserver arg0) {

	}

	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = lif.inflate(row, null);
		}

		TextView tv = (TextView) convertView.findViewById(R.id.textView1);
		tv.setText(data[position]);

		return convertView;
	}

}