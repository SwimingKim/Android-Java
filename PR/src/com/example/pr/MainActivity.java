package com.example.pr;

import java.io.Serializable;
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
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	Act ac[] = { new Act("ȫ����", R.drawable.h, "2014.04.07~2014.12.31\n" + "���� �ڿ����缾�� ȫ���� �� ���ڴ�Ȱ��\n" + "��� ���� ǥâ�� ����"),
			new Act("�ؿܺ���", R.drawable.c, "2016.01.12~2016.01.25\n" + "į����� �ʵ��л� 1000�� ���\n��������, ��º���, ��ȭ����Ȱ��"),
			new Act("�������", R.drawable.s, "2013.08.24~2014.12.28\n" + "�� ���� �� ���� ����, ��� ����,\n������ġ ���� �� �Ǹ�"),
			new Act("����Ȱ��", R.drawable.b, "500�ð� ����Ȱ�� ����\n" + "���� �����Ű�� ���������, ���� �����Ƶ�����, ��� �����ְ�����, YMCA"),
			new Act("R", R.drawable.wom, "����м����Ƹ� 1�Ⱓ Ȱ��\n" + "Twitter API�� ���� ������ ����� �ν���\n�м��Ͽ� wordcloud ����"),
			new Act("SPSS", R.drawable.wom, "��ȸ����м��� 2�� ���\n" + "���� �����Ϳ� �����м�, ����м� �� ����� ��� ����"),
			new Act("Excel", R.drawable.wom, "��ǻ��Ȱ��ɷ� 2�� ���\n" + "��� �Լ� �� ��ũ�� Ȱ�� ����"),
			new Act("Java", R.drawable.m, "���α׷����� ���� ����\n" + "���Ǳ� ���α׷� ����") };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ListView lv = (ListView) findViewById(R.id.listView1);
		MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.row, ac);
		lv.setAdapter(adapter);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(getApplicationContext(), DetailActivity.class);

				intent.putExtra("act", ac[position]);

				startActivity(intent);
			}
		});

	}// end of onCreate
}// end of class

class Act implements Serializable {
	String name;
	int img;
	String text;

	public Act() {

	}

	public Act(String name, int img, String text) {
		this.name = name;
		this.img = img;
		this.text = text;
	}
}

class MyAdapter extends BaseAdapter {
	int layout;
	Act[] ac;
	LayoutInflater lif;

	public MyAdapter() {
	}

	public MyAdapter(Context context, int layout, Act[] ac) {
		this.layout = layout;
		this.ac = ac;
		this.lif = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return ac.length;
	}

	public Object getItem(int position) {
		return ac[position];
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = lif.inflate(layout, null);
		}
		TextView tv = (TextView) convertView.findViewById(R.id.textView1);

		tv.setText(ac[position].name);

		return convertView;
	}

}
