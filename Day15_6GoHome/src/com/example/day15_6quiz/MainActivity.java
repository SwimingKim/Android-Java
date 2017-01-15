package com.example.day15_6quiz;

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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Student stu[] = { new Student("홍정택", 24, "나이를 속임", R.drawable.kae), new Student("장동진", 27, "와츄고나두", R.drawable.kae),
			new Student("주희진", 24, "불가능한일", R.drawable.kae), new Student("김병일", 24, "상추의목을벰", R.drawable.kae),
			new Student("문새미", 25, "집에 가고싶다", R.drawable.kae), new Student("류연지", 24, "나도", R.drawable.kae),
			new Student("서민규", 26, "혼자서앉을수있어요", R.drawable.kae), new Student("김수영", 24, "심심해", R.drawable.kae), };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// ListView 사용방법
		// 1.다량의 데이터 준비
		// 2.아답타 구성(한행의 Layout, 아답타 구성)
		// 3.아답타뷰에 아답타 구성

		ListView lv = (ListView) findViewById(R.id.listView1);

		MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.row, stu);

		lv.setAdapter(adapter);

		// 이벤트처리
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(getApplicationContext(), stu[position].message, 1).show();
			}
		});

	}// end of onCreate
}// end of class

class MyAdapter extends BaseAdapter {
	int layout;
	Student[] stu;
	LayoutInflater lif;

	public MyAdapter() {
	}

	public MyAdapter(Context context, int layout, Student[] stu) {
		this.layout = layout;
		this.stu = stu;
		this.lif = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {// 화면에 보여줄 List의 개수(데이터의 개수)
		return stu.length;
	}

	@Override
	public Object getItem(int position) {// 해당 번째의 item
		return stu[position];
	}

	@Override
	public long getItemId(int position) {// 해당 번째의 item의 고유한 id
		return position;
	}

	// 한 행의 layout과 데이터를 연결
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = lif.inflate(layout, null);
		}
		ImageView iv = (ImageView) convertView.findViewById(R.id.imageView1);
		TextView tvName = (TextView) convertView.findViewById(R.id.textView1);
		TextView tvAge = (TextView) convertView.findViewById(R.id.textView2);
		TextView tvMessage = (TextView) convertView.findViewById(R.id.textView3);

		iv.setImageResource(stu[position].img);
		tvName.setText(stu[position].name);
		tvAge.setText(stu[position].age + "살");
		tvMessage.setText(stu[position].message);

		return convertView;
	}
}

class Student {// 한 명의 정보를 저장할 객체
	String name;
	int age;
	String message;
	int img;

	public Student() {
	}

	public Student(String name, int age, String message, int img) {
		super();
		this.name = name;
		this.age = age;
		this.message = message;
		this.img = img;
	}
}
