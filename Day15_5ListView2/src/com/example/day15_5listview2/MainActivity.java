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
			R.drawable.park };// ������ �ĸ��� ������ �������� �ʴ´�
	String name[] = { "���α�", "����", "����ȯ", "����", "�ڱ��", "���α�", "����", "����ȯ", "����", "�ڱ��", "���α�", "����", "����ȯ", "����", "�ڱ��",
			"���α�", "����", "����ȯ", "����", "�ڱ��", "���α�", "����", "����ȯ", "����", "�ڱ��", "���α�", "����", "����ȯ", "����", "�ڱ��", };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// ListView �ۼ��ϱ�
		// 1. �ٷ��� ������ �غ�
		// 2. �ƴ�Ÿ ����(�� ���� ����ϴ� Layout, �ƴ�Ÿ ����)
		// 3. �ƴ�Ÿ ��(ListView, GridView, Gallery, Spinner)�� �ƴ�Ÿ ���
		ListView lv = (ListView) findViewById(R.id.listView1);

		// �ƴ�Ÿ
		MyAdapter ma = new MyAdapter(getApplicationContext(), // ����ȭ���� �������
				R.layout.row, // ����Ʈ�� �� �࿡ �׷��� ���̾ƿ�
				img);
		lv.setAdapter(ma);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(getApplicationContext(), "Ŭ���� ������ : " + name[position], 1).show();
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
	public int getCount() {// �ʼ� : ����Ʈ ������ ����� �� ����(�������� ����)
		return img.length;
	}

	@Override
	public Object getItem(int position) {// ���� : �ش� position��°�� ������
		return img[position];
	}

	@Override
	public long getItemId(int position) {// ���� : �ش� position��°�� �������� ����id
		return position;
	}

	// �ʼ� : ����Ʈ�� �� �࿡ � �����͸� ��� ������ ������ ������ ����
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = lif.inflate(layout, null);
		}
		ImageView iv = (ImageView) convertView.findViewById(R.id.imageView1);
		iv.setImageResource(img[position]);
		return convertView;
	}
}
