package com.example.day46_project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	Text str[] = {new Text("화면", "Dialog, Toast, Intent, Tab"),
			new Text("소리", "MediaPlayer, SoundPlayer, 진동"),
			new Text("어댑터뷰", "ListView, Gallery, GridView"),
			new Text("버튼", "selector, touch, click"),
			new Text("시간관리", "TimerTask, Handler, Chrometer"),
			new Text("애니메이션", "FrameAnimation, AlphaAnimation"),
			new Text("파일", "MySQlite3, 내부파일, 외부파일"),
			new Text("웹", "web, parser")};
	private TextView tv;
	private String co;
	private SharedPreferences sp;
	private ListView lv;
	private boolean bgm;
	MediaPlayer mp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		lv = (ListView)findViewById(R.id.listView1);
		MyView mv = new MyView(getApplicationContext(), R.layout.row, str);
		lv.setAdapter(mv);
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
				
				intent.putExtra("sound", mp.getCurrentPosition());
				intent.putExtra("name", str[position].name);
				
				startActivity(intent);

			}
		});
		
		
		
		sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		co = sp.getString("color", "");
		bgm = sp.getBoolean("sound", false);
		
		mp = MediaPlayer.create(getApplicationContext(), R.raw.bgm);

		
	}//end of onCreate
	
	@Override
	protected void onResume() {
		super.onResume();
		bgm = sp.getBoolean("sound", true);
		if (bgm==true) {
			mp.start();
		} else {
			if (mp.isPlaying()) {
				mp.pause();				
			}
		}

		co = sp.getString("color", "");
		if ("White".equals(co)) {
			lv.setBackgroundColor(Color.WHITE);
		} else if ("Red".equals(co)) {
			lv.setBackgroundColor(Color.rgb(241, 95, 95));
		} else if ("Yellow".equals(co)) {
			lv.setBackgroundColor(Color.rgb(250, 237, 125));
		} else if ("Green".equals(co)) {
			lv.setBackgroundColor(Color.rgb(206, 242, 121));
		} else {
			lv.setBackgroundColor(Color.rgb(178, 235, 244));
		}
		
	}
	
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		mp.stop();
	}
	
	class MyView extends BaseAdapter {
		
		int row;
		Text[] str;
		LayoutInflater lif;

		public MyView(Context applicationContext, int row, Text[] str) {
			this.row = row;
			this.str = str;
			this.lif = (LayoutInflater)applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}
		public int getCount() {
			return str.length;
		}
		public Object getItem(int position) {
			return str[position];
		}
		public long getItemId(int position) {
			return position;
		}
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView==null) {
				convertView = lif.inflate(R.layout.row, null);
			}
			
			TextView tvName = (TextView)convertView.findViewById(R.id.textView1);
			TextView tvDetail = (TextView)convertView.findViewById(R.id.textView2);
			
			tvName.setText(str[position].name);
			tvDetail.setText(str[position].datail);
			
			return convertView;
		}
		
	}
	
	class Text {
		String name;
		String datail;
		
		public Text(String name, String detail) {
			this.name = name;
			this.datail = detail;
		}
	}
	
	
	
	
}//end of class
