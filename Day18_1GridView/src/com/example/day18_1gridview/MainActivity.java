package com.example.day18_1gridview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends Activity {
	int img[] = { R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5, R.drawable.c6,
			R.drawable.c7, R.drawable.c8, };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 아답타뷰 (ListView, GridView, Gallery, Spinner)
		// 1. 다량의 데이터 준비
		// 2. adapter 구성(한 행을 담당할 layout, 클래스 작성)
		// 3. 아답타뷰에 adapter를 등록한다

		GridView gv = (GridView) findViewById(R.id.gridView1);
		MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.row, img);
		gv.setAdapter(adapter);

	}// end of onCreate
}// end of class

class MyAdapter extends BaseAdapter {
	int row;
	int[] img;
	LayoutInflater lif;

	public MyAdapter(Context context, int row, int[] img) {
		super();
		this.row = row;
		this.img = img;
		this.lif = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return img.length;
	}

	public Object getItem(int position) {
		return img[position];
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = lif.inflate(row, null);
		}

		ImageView iv = (ImageView) convertView.findViewById(R.id.imageView1);
		iv.setImageResource(img[position]);

		return convertView;
	}

}
