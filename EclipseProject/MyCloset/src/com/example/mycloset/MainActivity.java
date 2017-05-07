package com.example.mycloset;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	ArrayList<Closet> clo = new ArrayList<Closet>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		clo.add(new Closet(R.drawable.c1, "전신", "검정색", "겨울"));
		clo.add(new Closet(R.drawable.c2, "상의", "빨간색", "여름"));
		clo.add(new Closet(R.drawable.c3, "상의", "파랑색", "봄"));
		clo.add(new Closet(R.drawable.c4, "상의", "회색", "가을"));
		clo.add(new Closet(R.drawable.c1, "전신", "검정색", "겨울"));
		clo.add(new Closet(R.drawable.c2, "상의", "빨간색", "여름"));
		clo.add(new Closet(R.drawable.c3, "상의", "파랑색", "봄"));
		clo.add(new Closet(R.drawable.c4, "상의", "회색", "가을"));
		clo.add(new Closet(R.drawable.c1, "전신", "검정색", "겨울"));
		clo.add(new Closet(R.drawable.c2, "상의", "빨간색", "여름"));
		clo.add(new Closet(R.drawable.c3, "상의", "파랑색", "봄"));
		clo.add(new Closet(R.drawable.c4, "상의", "회색", "가을"));
		clo.add(new Closet(R.drawable.c1, "전신", "검정색", "겨울"));
		clo.add(new Closet(R.drawable.c2, "상의", "빨간색", "여름"));
		clo.add(new Closet(R.drawable.c3, "상의", "파랑색", "봄"));
		clo.add(new Closet(R.drawable.c4, "상의", "회색", "가을"));
		
		
		
		
		ListView lv = (ListView)findViewById(R.id.listView1);
		MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.row, clo);
		lv.setAdapter(adapter);
		
		
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
				
				intent.putExtra("type",clo.get(position).type);
				intent.putExtra("color",clo.get(position).color);
				intent.putExtra("weather",clo.get(position).weather);
				intent.putExtra("img",clo.get(position).img);
				
				
				startActivity(intent);
				
			}
		});
		
		
		

		
	}//end of onCreate
	
	class MyAdapter extends BaseAdapter {
		int layout;
		ArrayList<Closet> clo;
		LayoutInflater lif;
		
		public MyAdapter() {}
		public MyAdapter(Context context, int layout, ArrayList<Closet> clo) {
			super();
			this.layout = layout;
			this.clo = clo;
			this.lif = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		}

		public int getCount() {
			return clo.size();
		}
		public Object getItem(int position) {
			return clo.get(position);
		}
		public long getItemId(int position) {
			return position;
		}
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView==null) {
				convertView = lif.inflate(layout, null);
			}
			ImageView iv = (ImageView)convertView.findViewById(R.id.imageView1);
			TextView tType = (TextView)convertView.findViewById(R.id.textView1);
			TextView tColor = (TextView)convertView.findViewById(R.id.textView2);
			TextView tWeather = (TextView)convertView.findViewById(R.id.textView3);
			
			iv.setImageResource(clo.get(position).img);
			tType.setText(clo.get(position).type);
			tColor.setText(clo.get(position).color);
			tWeather.setText(clo.get(position).weather);
			
			return convertView;
		}
		
		
	}
	
	class Closet {
		int img;
		String type;
		String color;
		String weather;
		public Closet() {}
		public Closet(int img, String type, String color, String weather) {
			this.img=img;
			this.type=type;
			this.color=color;
			this.weather=weather;
		}
		
	}
}//end of class

