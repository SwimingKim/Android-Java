package com.example.day16_1listview;

import javax.crypto.spec.IvParameterSpec;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	String name[] = { "서민규", "홍정택", "문새미", "류연지", "황보람", "신나은", "김수영", "주희진", "장동진", "김병일" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 제한된 화면에 다량의 데이터를 보여주는 방법 : AdapterView 아답타뷰
		// (ListView, GridView, Spinner, Gallery)
		// 1. 다량의 데이터
		// 2. Adapter 아답타 구성 (한 행을 그려줄 layout, 클래스 생성)
		// 3. 아답타뷰에 아답카를 등록한다

		final ListView lv = (ListView) findViewById(R.id.listView1);
		MyAdapter adapter = new MyAdapter(getApplicationContext(), // 현재 화면의
																	// 제어권자
				R.layout.row, // 한 행을 그려줄 레이아웃
				name);// 다량의 데이터
		lv.setAdapter(adapter);

		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);

		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (lv.getVisibility() == View.INVISIBLE) {
					lv.setVisibility(View.VISIBLE);
				} else if (lv.getVisibility() == View.VISIBLE) {
					lv.setVisibility(View.INVISIBLE);
				}
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				lv.setBackgroundColor(Color.RED);
			}
		});
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(getApplicationContext(), name[position], 1).show();
			}
		});

	}// end of main
}// end of class

class MyAdapter extends BaseAdapter {
	int layout;
	String[] name;
	LayoutInflater lif;

	public MyAdapter() {
	}

	public MyAdapter(Context context, int layout, String[] name) {
		this.layout = layout;
		this.name = name;
		this.lif = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {// 화면에 보여줄 listview의 행 개수 : 데이터의 개수로 지정
		return name.length;
	}

	public Object getItem(int position) {// 행에 해당하는 객체를 리턴
		return name[position];
	}

	public long getItemId(int position) {// 행에 해당하는 객체의 고유한 id 리턴
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = lif.inflate(layout, null);
		}

		TextView tv = (TextView) convertView.findViewById(R.id.textView1);
		tv.setText(name[position]);

		return convertView;
	}

}