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

	Student stu[] = { new Student("ȫ����", 24, "���̸� ����", R.drawable.kae), new Student("�嵿��", 27, "�������", R.drawable.kae),
			new Student("������", 24, "�Ұ�������", R.drawable.kae), new Student("�躴��", 24, "�����Ǹ�����", R.drawable.kae),
			new Student("������", 25, "���� ����ʹ�", R.drawable.kae), new Student("������", 24, "����", R.drawable.kae),
			new Student("���α�", 26, "ȥ�ڼ��������־��", R.drawable.kae), new Student("�����", 24, "�ɽ���", R.drawable.kae), };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// ListView �����
		// 1.�ٷ��� ������ �غ�
		// 2.�ƴ�Ÿ ����(������ Layout, �ƴ�Ÿ ����)
		// 3.�ƴ�Ÿ�信 �ƴ�Ÿ ����

		ListView lv = (ListView) findViewById(R.id.listView1);

		MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.row, stu);

		lv.setAdapter(adapter);

		// �̺�Ʈó��
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
	public int getCount() {// ȭ�鿡 ������ List�� ����(�������� ����)
		return stu.length;
	}

	@Override
	public Object getItem(int position) {// �ش� ��°�� item
		return stu[position];
	}

	@Override
	public long getItemId(int position) {// �ش� ��°�� item�� ������ id
		return position;
	}

	// �� ���� layout�� �����͸� ����
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
		tvAge.setText(stu[position].age + "��");
		tvMessage.setText(stu[position].message);

		return convertView;
	}
}

class Student {// �� ���� ������ ������ ��ü
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
