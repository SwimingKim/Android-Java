package com.example.project04_weather;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class CloActivity extends Activity {
	Clothes[] clo = {new Clothes("Ƽ����", R.drawable.clo1, false, true, false, false),
			new Clothes("�����", R.drawable.clo2, false, false, true, false),
			new Clothes("����", R.drawable.clo3, true, false, true, false),
			new Clothes("������", R.drawable.clo4, false, false, true, false),
			new Clothes("��Ʈ", R.drawable.clo5, false, false, false, true),
			new Clothes("ī��Ƽ", R.drawable.clo6, true, true, false, false),
			new Clothes("�ĵ�Ƽ", R.drawable.clo7, false, false, true, true),
			new Clothes("�е�", R.drawable.clo8, false, false, false, true),
			new Clothes("û����", R.drawable.clo9, true, true, true, true),
			new Clothes("�ݹ���", R.drawable.clo10, true, false, false, false),
			new Clothes("ġ��", R.drawable.clo11, true, false, true, false),
			new Clothes("���ǽ�", R.drawable.clo12, true, true, false, false)};
	String str[] = {"��ü","��","����","����","�ܿ�"};
	String season = "��ü";
	ArrayList<Clothes> ct = new ArrayList<CloActivity.Clothes>();
	private GridView gv;
	private MyGrid mg;
	private int num;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clo);

		mg = new MyGrid(getApplicationContext(),R.layout.clo_row,ct);
		gv = (GridView)findViewById(R.id.gridView1);
		gv.setAdapter(mg);
		

		if ("��ü".equals(season)) {
			for (int i = 0; i < clo.length; i++) {
				ct.add(clo[i]);
			}
		} else if ("��".equals(season)) {
			for (int i = 0; i < clo.length; i++) {
				if (clo[i].spring) {
					ct.add(clo[i]);
				}
			}
		} else if ("����".equals(season)) {
			for (int i = 0; i < clo.length; i++) {
				if (clo[i].summer) {
					ct.add(clo[i]);
				}
			}
		} else if ("����".equals(season)) {
			for (int i = 0; i < clo.length; i++) {
				if (clo[i].fall) {
					ct.add(clo[i]);
				}
			}
		} else if ("�ܿ�".equals(season)) {
			for (int i = 0; i < clo.length; i++) {
				if (clo[i].winter) {
					ct.add(clo[i]);
				}
			}
		}

		Spinner s = (Spinner)findViewById(R.id.spinner1);
		MyAdapte ma = new MyAdapte(getApplicationContext(),R.layout.row, str);
		s.setAdapter(ma);
		
		
		final Button b_start = (Button)findViewById(R.id.button1);		
		final Button b_way = (Button)findViewById(R.id.button2);		
		
		b_start.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), IntroActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
		b_way.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
		gv.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				num = position;
				showDialog(0);
			}
		});
		

	}//end of onCreate
	
	protected void onPrepareDialog(int id, Dialog dialog) {
		switch (id) {
		case 0:

			final ImageView iv = (ImageView)dialog.findViewById(R.id.imageView1);
			final EditText et_site = (EditText)dialog.findViewById(R.id.editText1);
			final EditText et_id = (EditText)dialog.findViewById(R.id.editText2);

			iv.setImageResource(ct.get(num).img);
			et_site.setText(ct.get(num).name);
			String str = "";
			if (ct.get(num).spring) str += "�� "; 
			if (ct.get(num).summer) str += "���� "; 
			if (ct.get(num).fall) str += "���� "; 
			if (ct.get(num).winter) str += "�ܿ� "; 
			et_id.setText(str);


			et_site.setEnabled(false);
			et_id.setEnabled(false);

			break;

		default:
			break;
		}


		super.onPrepareDialog(id, dialog);
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case 0:
			AlertDialog.Builder dialog = new Builder(this);
			LayoutInflater lif2 = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View MyView2 = lif2.inflate(R.layout.look, null);
			dialog = new Builder(this);
			dialog.setTitle("�˻� ���");
			dialog.setView(MyView2);

			dialog.setNegativeButton("Ȯ��",null);

			return dialog.create();

		default:
			break;
		}
		return super.onCreateDialog(id);
	}

	class Clothes{
		String name;
		int img;
		boolean spring;
		boolean summer;
		boolean fall;
		boolean winter;
		public Clothes(String name, int img, boolean spring, boolean summer, boolean fall, boolean winter) {
			super();
			this.name = name;
			this.img = img;
			this.spring = spring;
			this.summer = summer;
			this.fall = fall;
			this.winter = winter;
		}

	}

	class MyGrid extends BaseAdapter{
		int row;
		ArrayList<Clothes> ct;
		LayoutInflater lif;		

		public MyGrid(Context context, int row,ArrayList<Clothes> ct) {
			this.row = row;
			this.ct = ct;
			this.lif = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		}


		@Override
		public int getCount() {
			return ct.size();
		}

		@Override
		public Object getItem(int position) {
			return ct.get(position).img;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int pos, View convertView, ViewGroup parent) {
			if (convertView==null) {
				convertView = lif.inflate(R.layout.clo_row, null);
			}
			ImageView ima = (ImageView)convertView.findViewById(R.id.imageView1);
			ima.setImageResource(ct.get(pos).img);

			return convertView;
		}

	}
	class MyAdapte implements SpinnerAdapter{

		int row;
		String str[];
		LayoutInflater lif;

		public MyAdapte(Context applicationContext, int row, String str[]) {
			this.row = row;
			this.str = str;
			this.lif = (LayoutInflater)applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public void registerDataSetObserver(DataSetObserver observer) {
		}

		@Override
		public void unregisterDataSetObserver(DataSetObserver observer) {
		}

		@Override
		public int getCount() {
			return str.length;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public boolean hasStableIds() {
			return false;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView==null) {
				convertView = lif.inflate(row, null);
			}

			TextView tv = (TextView)convertView.findViewById(R.id.textView1);
			tv.setText(str[position]);
			
			season = str[position];
			ct.clear();
			if ("��ü".equals(season)) {
				for (int i = 0; i < clo.length; i++) {
					ct.add(clo[i]);
				}
			} else if ("��".equals(season)) {
				for (int i = 0; i < clo.length; i++) {
					if (clo[i].spring) {
						ct.add(clo[i]);
					}
				}
			} else if ("����".equals(season)) {
				for (int i = 0; i < clo.length; i++) {
					if (clo[i].summer) {
						ct.add(clo[i]);
					}
				}
			} else if ("����".equals(season)) {
				for (int i = 0; i < clo.length; i++) {
					if (clo[i].fall) {
						ct.add(clo[i]);
					}
				}
			} else if ("�ܿ�".equals(season)) {
				for (int i = 0; i < clo.length; i++) {
					if (clo[i].winter) {
						ct.add(clo[i]);
					}
				}
			}
			gv.setAdapter(mg);


			return convertView;
		}

		@Override
		public int getItemViewType(int position) {
			return 0;
		}

		@Override
		public int getViewTypeCount() {
			return 0;
		}

		@Override
		public boolean isEmpty() {
			return false;
		}

		@Override
		public View getDropDownView(int position, View convertView, ViewGroup parent) {
			if (convertView==null) {
				convertView = lif.inflate(row, null);
			}

			TextView tv = (TextView)convertView.findViewById(R.id.textView1);
			tv.setText(str[position]);


			return convertView;
		}

	}

}//end of class
