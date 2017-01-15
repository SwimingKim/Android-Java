package com.example.day15_5listview2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	int img[] = { R.drawable.seo, R.drawable.jae, R.drawable.kang, R.drawable.jin, R.drawable.park, R.drawable.seo,
			R.drawable.jae, R.drawable.kang, R.drawable.jin, R.drawable.park, R.drawable.seo, R.drawable.jae,
			R.drawable.kang, R.drawable.jin, R.drawable.park, R.drawable.seo, R.drawable.jae, R.drawable.kang,
			R.drawable.jin, R.drawable.park, R.drawable.seo, R.drawable.jae, R.drawable.kang, R.drawable.jin,
			R.drawable.park };// 마지막 컴마는 에러로 인정하지 않는다
	String name[] = { "서인국", "재희", "강지환", "진구", "박기웅", "서인국", "재희", "강지환", "진구", "박기웅", "서인국", "재희", "강지환", "진구", "박기웅",
			"서인국", "재희", "강지환", "진구", "박기웅", "서인국", "재희", "강지환", "진구", "박기웅", "서인국", "재희", "강지환", "진구", "박기웅", };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// ListView 작성하기
		// 1. 다량의 데이터 준비
		// 2. 아답타 구성(한 행을 담당하는 Layout, 아답타 구성)
		// 3. 아답타 뷰(ListView, GridView, Gallery, Spinner)에 아답타 등록
		ListView lv = (ListView) findViewById(R.id.listView1);

		// 아답타
		MyAdapter ma = new MyAdapter(getApplicationContext(), // 현재화면의 제어권자
				R.layout.row, // 리스트의 한 행에 그려줄 레이아웃
				img);
		lv.setAdapter(ma);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(getApplicationContext(), "클릭한 포지션 : " + name[position], 1).show();
			}
		});

	}// end of onCreate
}// end of class

class MyAdapter extends BaseAdapter {
	int layout;
	int[] img;
	LayoutInflater lif;

	public MyAdapter() {
	}

	public MyAdapter(Context context, int layout, int[] img) {
		this.layout = layout;
		this.img = img;
		lif = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {// 필수 : 리스트 보여줄 목록의 총 개수(데이터의 개수)
		return img.length;
	}

	@Override
	public Object getItem(int position) {// 선택 : 해당 position번째의 데이터
		return img[position];
	}

	@Override
	public long getItemId(int position) {// 선택 : 해당 position번째의 데이터의 고유id
		return position;
	}

	// 필수 : 리스트의 한 행에 어떤 데이터를 어디 위젯에 보여줄 것인지 설정
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = lif.inflate(layout, null);
		}
		ImageView iv = (ImageView) convertView.findViewById(R.id.imageView1);
		iv.setImageResource(img[position]);
		return convertView;
	}
}
