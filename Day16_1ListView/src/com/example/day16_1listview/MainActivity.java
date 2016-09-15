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

	String name[] = { "���α�", "ȫ����", "������", "������", "Ȳ����", "�ų���", "�����", "������", "�嵿��", "�躴��" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// ���ѵ� ȭ�鿡 �ٷ��� �����͸� �����ִ� ��� : AdapterView �ƴ�Ÿ��
		// (ListView, GridView, Spinner, Gallery)
		// 1. �ٷ��� ������
		// 2. Adapter �ƴ�Ÿ ���� (�� ���� �׷��� layout, Ŭ���� ����)
		// 3. �ƴ�Ÿ�信 �ƴ�ī�� ����Ѵ�

		final ListView lv = (ListView) findViewById(R.id.listView1);
		MyAdapter adapter = new MyAdapter(getApplicationContext(), // ���� ȭ����
																	// �������
				R.layout.row, // �� ���� �׷��� ���̾ƿ�
				name);// �ٷ��� ������
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

	public int getCount() {// ȭ�鿡 ������ listview�� �� ���� : �������� ������ ����
		return name.length;
	}

	public Object getItem(int position) {// �࿡ �ش��ϴ� ��ü�� ����
		return name[position];
	}

	public long getItemId(int position) {// �࿡ �ش��ϴ� ��ü�� ������ id ����
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