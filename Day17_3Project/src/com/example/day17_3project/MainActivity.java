package com.example.day17_3project;

import java.io.Serializable;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Rest arrRest[] = { new Rest(R.drawable.c1, "�ʴ�κ�", "02-000-0000", "������ ������", "�κ�"),
			new Rest(R.drawable.c2, "�ߵŸ���", "02-000-0000", "����� ���۱�", "���"),
			new Rest(R.drawable.c3, "�佺����", "02-000-0000", "����� ���۱�", "�佺"),
			new Rest(R.drawable.c4, "���κ��", "02-000-0000", "����� ���۱�", "���κ�"),
			new Rest(R.drawable.c5, "�������", "02-000-0000", "��⵵ ����", "������ġ"),
			new Rest(R.drawable.c6, "������", "02-000-0000", "����� ���۱�", "���"),
			new Rest(R.drawable.c7, "�긮��", "02-000-0000", "����� ���۱�", "������ġ"),
			new Rest(R.drawable.c8, "����Į����", "02-000-0000", "����� ���۱�", "��") };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ListView lv = (ListView) findViewById(R.id.listView1);
		MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.row, arrRest);
		lv.setAdapter(adapter);

		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(getApplicationContext(), arrRest[position].name + "�� �����߽��ϴ�", 1).show();
				Intent intent = new Intent(getApplicationContext(), DeepActivity.class);

				intent.putExtra("Rest", arrRest[position]);
				startActivity(intent);

			}
		});

		MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.love);
		mp.start();

	}// end of onCreate
}// end of class

class MyAdapter extends BaseAdapter {
	int row;
	Rest[] arrRest;
	LayoutInflater lif;

	public MyAdapter() {
	}

	public MyAdapter(Context context, int row, Rest[] arrRest) {
		this.row = row;
		this.arrRest = arrRest;
		this.lif = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return arrRest.length;
	}

	public Object getItem(int position) {
		return arrRest[position];
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = lif.inflate(row, null);
		}

		ImageView iv = (ImageView) convertView.findViewById(R.id.imageView1);
		TextView tv1 = (TextView) convertView.findViewById(R.id.textView1);
		TextView tv2 = (TextView) convertView.findViewById(R.id.textView2);
		TextView tv3 = (TextView) convertView.findViewById(R.id.textView3);
		TextView tv4 = (TextView) convertView.findViewById(R.id.textView4);

		iv.setImageResource(arrRest[position].img);
		tv1.setText(arrRest[position].name);

		return convertView;
	}

}

class Rest implements Serializable {// ������
	int img;
	String name;
	String number;
	String address;
	String menu;

	public Rest() {
	}

	public Rest(int img, String name, String number, String address, String menu) {
		this.img = img;
		this.name = name;
		this.number = number;
		this.address = address;
		this.menu = menu;

	}

}