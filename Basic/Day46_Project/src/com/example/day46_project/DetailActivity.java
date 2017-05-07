package com.example.day46_project;

		
import com.example.day46_project.R.layout;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class DetailActivity extends Activity{
	private Spinner s;
	private ImageView iv;
	Android[] an = {new Android("가", R.drawable.ic_launcher),
			new Android("나", R.drawable.ic_launcher),
			new Android("다", R.drawable.ic_launcher)};
	private SharedPreferences sp;
	private String co;
	private LinearLayout ll;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);
		
		s = (Spinner)findViewById(R.id.spinner1);
		iv = (ImageView)findViewById(R.id.imageView1);
		
		MyAdapte ma = new MyAdapte(getApplicationContext(),layout.row, an);
		s.setAdapter(ma);
		
		sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		co = sp.getString("color", "");
		
		ll = (LinearLayout)findViewById(R.id.layout);
		
		
	}//end of onCreate
	
	@Override
	protected void onResume() {
		super.onResume();
		co = sp.getString("color", "");
		if ("White".equals(co)) {
			ll.setBackgroundColor(Color.WHITE);
		} else if ("Red".equals(co)) {
			ll.setBackgroundColor(Color.rgb(241, 95, 95));
		} else if ("Yellow".equals(co)) {
			ll.setBackgroundColor(Color.rgb(250, 237, 125));
		} else if ("Green".equals(co)) {
			ll.setBackgroundColor(Color.rgb(206, 242, 121));
		} else {
			ll.setBackgroundColor(Color.rgb(178, 235, 244));
		}
	}
	
	class Android {
		String name;
		int iv;
		public Android(String name, int iv) {
			super();
			this.name = name;
			this.iv = iv;
		}
		
		
	}
	
	
	class MyAdapte implements SpinnerAdapter{
		
		int row;
		Android[] an;
		LayoutInflater lif;

		public MyAdapte(Context applicationContext, int row, Android[] an) {
			this.row = row;
			this.an = an;
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
			return an.length;
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
				convertView = lif.inflate(R.layout.text, null);
			}
			
			TextView tv = (TextView)convertView.findViewById(R.id.textView1);
			tv.setText(an[position].name);
			
			
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
				convertView = lif.inflate(R.layout.text, null);
			}
			
			TextView tv = (TextView)convertView.findViewById(R.id.textView1);
			tv.setText(an[position].name);
			
			
			return convertView;
		}
		
	}
	
	
}//end of class
