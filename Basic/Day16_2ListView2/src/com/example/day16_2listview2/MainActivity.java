package com.example.day16_2listview2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	Food[] arrF = { new Food(R.drawable.f1, "양자강", "언덕위", "010-9622-0213", "중식"),
			new Food(R.drawable.f2, "교가루", "자연대학앞", "010-9622-0213", "일식"),
			new Food(R.drawable.f3, "치즈밥잇슈", "자연대학앞", "010-9622-0213", "정식"),
			new Food(R.drawable.f4, "캘리버거", "자연대학앞", "010-9622-0213", "양식"),
			new Food(R.drawable.f5, "빨간계단", "언덕중간왼쪽", "010-9622-0213", "분식"),
			new Food(R.drawable.f6, "봉구스밥버거", "언덕중간오른쪽", "010-9622-0213", "간식"),
			new Food(R.drawable.f1, "양자강", "언덕위", "010-9622-0213", "중식"),
			new Food(R.drawable.f2, "교가루", "자연대학앞", "010-9622-0213", "일식"),
			new Food(R.drawable.f3, "치즈밥잇슈", "자연대학앞", "010-9622-0213", "정식"),
			new Food(R.drawable.f4, "캘리버거", "자연대학앞", "010-9622-0213", "양식"),
			new Food(R.drawable.f5, "빨간계단", "언덕중간왼쪽", "010-9622-0213", "분식"),
			new Food(R.drawable.f6, "봉구스밥버거", "언덕중간오른쪽", "010-9622-0213", "간식"),
			new Food(R.drawable.f1, "양자강", "언덕위", "010-9622-0213", "중식"),
			new Food(R.drawable.f2, "교가루", "자연대학앞", "010-9622-0213", "일식"),
			new Food(R.drawable.f3, "치즈밥잇슈", "자연대학앞", "010-9622-0213", "정식"),
			new Food(R.drawable.f4, "캘리버거", "자연대학앞", "010-9622-0213", "양식"),
			new Food(R.drawable.f5, "빨간계단", "언덕중간왼쪽", "010-9622-0213", "분식"),
			new Food(R.drawable.f6, "봉구스밥버거", "언덕중간오른쪽", "010-9622-0213", "간식"), };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ListView lv = (ListView) findViewById(R.id.listView1);
		MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.row, arrF);
		lv.setAdapter(adapter);

	}// end of onCreate
}// end of class

class MyAdapter extends BaseAdapter {
	int row;
	Food[] arrF;
	LayoutInflater lif;

	public MyAdapter() {
	}

	public MyAdapter(Context context, int row, Food[] arrF) {
		this.row = row;
		this.arrF = arrF;
		this.lif = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return arrF.length;
	}

	public Object getItem(int position) {
		return arrF[position];
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = lif.inflate(row, null);
		}
		ImageView iv = (ImageView) convertView.findViewById(R.id.imageView1);
		TextView tName = (TextView) convertView.findViewById(R.id.textView1);
		TextView tType = (TextView) convertView.findViewById(R.id.textView2);
		TextView tTel = (TextView) convertView.findViewById(R.id.textView3);
		TextView tAd = (TextView) convertView.findViewById(R.id.textView4);

		iv.setImageResource(arrF[position].img);
		tName.setText(arrF[position].name);
		tType.setText(arrF[position].type);
		tTel.setText(arrF[position].tel);
		tAd.setText(arrF[position].addr);

		return convertView;
	}

}

class Food {
	/** 사진 파일임 */
	int img;// 사진
	String name = "";// 상호
	String addr = "";// 주소
	String tel = "";// 전화번호
	String type = "";// 음식종류분류

	public Food() {
	}

	public Food(int img, String name, String addr, String tel, String type) {
		super();
		this.img = img;
		this.name = name;
		this.addr = addr;
		this.tel = tel;
		this.type = type;
	}

}