
package com.example.day15_4listview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	String str[] = { "���", "����", "��", "����", "�ٳ���", "���ξ���", "����丶��", "���", "����", "��", "����", "�ٳ���", "���ξ���", "����丶��", "���",
			"����", "��", "����", "�ٳ���", "���ξ���", "����丶��", "���", "����", "��", "����", "�ٳ���", "���ξ���", "����丶��", };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// ������� : ListView �����
		// 1. �ٷ��� ������
		// 2. �ƴ�Ÿ�� �����Ѵ�(�ϳ��� �࿡ �ش��ϴ� layout �غ�, �ƴ�Ÿ ����)
		// 3. �ƴ�Ÿ��(ListView, GridView, Gallery, Spinner)�� �ƴ�Ÿ�� ����Ѵ�

		ListView lv = (ListView) findViewById(R.id.listView1);

		// 2. �ƴ�Ÿ�� �����Ѵ�
		MyAdapter ma = new MyAdapter(getApplicationContext(), // ����ȭ���� �������
				R.layout.row, // ListView�� ������ �� �� layout
				str);// �ٷ��ǵ�����
		lv.setAdapter(ma);// 3.�ƴ�Ÿ�信 �ƴ�Ÿ���

	}// end of onCreate
}// end of class

// ���� ���� �ƴ�Ÿ - �����͸� row���̾ƿ��� ��� ��� ��ġ���� ����
class MyAdapter extends BaseAdapter {
	// Context context;
	int layout;
	String[] str;
	LayoutInflater lif; // ������ ����ϴ� ���̾ƿ��� �ڿ��� �����ϱ� ����

	public MyAdapter() {
	}// �⺻ ������

	public MyAdapter(Context context, int layout, String[] str) {// ������
		// this.context = context;
		this.layout = layout;
		this.str = str;
		lif = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);// C,c����
																							// �������
																							// �׷���
																							// �빮��
																							// ����
	}

	public int getCount() {// �ʼ� : ����Ʈ�� �� ����� ����
		return str.length;
	}

	public Object getItem(int position) {// ���� : ����Ʈ �׸��� �ش� ������
		return str[position];
	}

	public long getItemId(int position) {// ���� : ����Ʈ �׸��� �ش� �������� ����id
		return position;
	}

	// getView �ʼ� : �����͸� row ���̾ƿ��� ��� ��� ��ġ���� ����
	public View getView(int position, View convertView, ViewGroup parent) {
		// ���� �߿��� �޼��� �ڡڡڡڡ�
		if (convertView == null) {
			convertView = lif.inflate(layout, null);
		}
		TextView tv = (TextView) convertView.findViewById(R.id.textView1);
		tv.setText(str[position]);
		return convertView;// �� ���� �����͸� �����ؼ� ����
	}
}
