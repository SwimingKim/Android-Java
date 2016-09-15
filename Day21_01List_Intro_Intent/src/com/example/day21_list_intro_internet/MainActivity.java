package com.example.day21_list_intro_internet;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	int img[] = { R.drawable.ain, R.drawable.ain2, R.drawable.ain4, R.drawable.ain, R.drawable.ain2, R.drawable.ain4,
			R.drawable.ain, R.drawable.ain2 };

	String name[] = { "���", "�κ�", "ü��", "�ٳ���", "����", "�ο캿", "�鸮", "ghgh" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 1. �ٷ��� ������ �غ�
		// 2. �� ĭ�� �ش��ϴ� layout ������ �������Ѵ�.
		// 3. adapter �� �������ش�.

		GridView gv = (GridView) findViewById(R.id.gridView1);

		MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.row, img, name);
		gv.setAdapter(adapter);

	}// end of onCreate
}// end of class

class MyAdapter extends BaseAdapter {
	int img[];
	int row;
	String name[];
	LayoutInflater lif;

	public MyAdapter(Context context, int row, int[] img, String[] name) {
		this.row = row;
		this.img = img;
		this.name = name;

		this.lif = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return img.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
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
		ImageView iv = (ImageView) convertView.findViewById(R.id.imageView1);
		TextView tv = (TextView) convertView.findViewById(R.id.textView1);
		iv.setImageResource(img[position]);
		tv.setText(name[position]);

		return convertView;
	}

}