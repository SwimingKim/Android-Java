package com.su.project01;

import java.util.ArrayList;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final int DIALOG_ADD = 0;
	private static final int DIALOG_WAY = 1;
	private static final int DIALOG_INTRO = 2;
	private static final int DIALOG_RESULT = 3;
	HelpMe hm;
	SQLiteDatabase db;
	EditText et_result;
	Cursor c;
	AlertDialog.Builder dialog4;
	ArrayList<Site> ss;
	int findnum;
	String findsite;
	String findid;
	String findpass;
	private ListView lv;
	private MyAdater adapter;
	private String Fsite;
	private String Fid;
	private String Fpass;
	private SharedPreferences sp;
	private String co;
	private boolean bgm;
	private MediaPlayer mp;
	final String KEY = "open";
	EditTextPreference ep;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		hm = new HelpMe(getApplicationContext(), "AAA.db", null, 1);

		ss = new ArrayList<MainActivity.Site>();

		sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		co = sp.getString("color", "");
		bgm = sp.getBoolean("sound", false);
		mp = MediaPlayer.create(getApplicationContext(), R.raw.bgm);


		final EditText et_search = (EditText)findViewById(R.id.editText1);
		Button b = (Button)findViewById(R.id.button1);
		Button bAdd = (Button)findViewById(R.id.button2);
		Button bSetting = (Button)findViewById(R.id.button3);
		Button bIntro = (Button)findViewById(R.id.button4);

		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (et_search.getText().toString().equals("")) {
					Toast.makeText(getApplicationContext(), "내용을 입력하세요", 0).show();
				} else if (Integer.valueOf(et_search.getText().toString())>=ss.size()){
					Toast.makeText(getApplicationContext(), "범위를 초과했습니다", 0).show();
					et_search.setText("");
				} else {
					findnum = Integer.valueOf(et_search.getText().toString());
					showDialog(DIALOG_RESULT);
					et_search.setText("");
				}

			}
		});

		bAdd.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog(DIALOG_ADD);
			}
		});

		bIntro.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				openOptionsMenu();
			}
		});

		lv = (ListView)findViewById(R.id.listView1);
		adapter = new MyAdater(getApplicationContext(),R.layout.show, ss);

		Read();

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				findnum = ss.get(position).num;
				findsite = ss.get(position).site;
				findid = ss.get(position).id;
				findpass = ss.get(position).pass;
				showDialog(DIALOG_RESULT);
			} 
		});

		bSetting.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//				openOptionsMenu();
				Intent intent = new Intent(getApplicationContext(),SettingActivity.class);
				startActivity(intent);
			}
		});


	}//end of onCreate
	protected void onResume() {
		super.onResume();
		bgm = sp.getBoolean("sound", false);
		if (bgm==true) {
			mp.start();
		} else {
			if (mp.isPlaying()) {
				mp.pause();				
			}
		}

		co = sp.getString("color","");
		if ("White".equals(co)) {
			lv.setBackgroundColor(Color.argb(0, 0, 0, 0));
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

	void Read(){
		db = hm.getReadableDatabase();
		c = db.query("array", null, null, null, null, null, null);

		int i = 0;
		while (c.moveToNext()) {
			ss.add(new Site(i,
					c.getString(c.getColumnIndex("site")),
					c.getString(c.getColumnIndex("id")),
					c.getString(c.getColumnIndex("pass"))));
			i++;
		}

		lv.setAdapter(adapter);


	}

	class MyAdater extends BaseAdapter{
		int row;
		ArrayList<Site> ss;
		LayoutInflater lif;

		public MyAdater(Context context, int row, ArrayList<Site> ss) {
			this.row = row;
			this.ss = ss;
			this.lif = (LayoutInflater)getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
		}

		public int getCount() {
			return ss.size();
		}

		public Object getItem(int position) {
			return ss.get(position);
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView==null) {
				convertView = lif.inflate(row, null);
			}

			TextView et1 = (TextView)convertView.findViewById(R.id.textView4);
			TextView et2 = (TextView)convertView.findViewById(R.id.textView5);

			Site st = ss.get(position);
			et1.setText(st.num+"");
			et2.setText(st.site);

			return convertView;
		}

	}

	class Site{
		int num;
		String site;
		String id;
		String pass;

		public Site(int num, String site, String id, String pass) {
			this.num = num;
			this.site = site;
			this.id = id;
			this.pass = pass;
		}
	}


	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.intro:
			showDialog(DIALOG_INTRO);
			return true;
		case R.id.way:
			showDialog(DIALOG_WAY);
			return true;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	protected void onPrepareDialog(int id, Dialog dialog) {
		switch (id) {
		case DIALOG_RESULT:

			final EditText et_site = (EditText)dialog.findViewById(R.id.editText1);
			final EditText et_id = (EditText)dialog.findViewById(R.id.editText2);
			final EditText et_pass = (EditText)dialog.findViewById(R.id.editText3);	

			//			db = hm.getReadableDatabase(); // 검색을 위해 읽기모드
			//			Cursor c = db.query("array", null, "num=?", new String[] {findnum+""}, null, null, null);
			//
			//			if (c==null) {
			//				Toast.makeText(getApplicationContext(), "번호를 확인해주세요", 0).show();
			//			}
			//
			//			while (c.moveToNext()) {
			//				Fsite = c.getString(c.getColumnIndex("site"));
			//				Fid = c.getString(c.getColumnIndex("id"));
			//				Fpass = c.getString(c.getColumnIndex("pass"));
			//			}

			et_site.setText(ss.get(findnum).site);
			et_id.setText(ss.get(findnum).id);
			et_pass.setText(ss.get(findnum).pass);


			et_site.setEnabled(false);
			et_id.setEnabled(false);
			et_pass.setEnabled(false);

			break;

		default:
			break;
		}


		super.onPrepareDialog(id, dialog);
	}






	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DIALOG_ADD:
			LayoutInflater lif = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			final View myView = lif.inflate(R.layout.plus, null);
			AlertDialog.Builder dialog = new Builder(this);
			dialog.setTitle("추가하기");
			dialog.setView(myView);
			dialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					final EditText et_site = (EditText)myView.findViewById(R.id.editText1);
					final EditText et_id = (EditText)myView.findViewById(R.id.editText2);
					final EditText et_pass = (EditText)myView.findViewById(R.id.editText3);	
					if (et_site.getText().toString().equals("")||
							et_id.getText().toString().equals("")||
							et_pass.getText().toString().equals("")) {
						Toast.makeText(getApplicationContext(), "내용을 입력하세요", 0).show();
					} else {
						db = hm.getWritableDatabase();
						ContentValues values = new ContentValues();

						values.put("site", et_site.getText().toString());
						values.put("id", et_id.getText().toString());
						values.put("pass", et_pass.getText().toString());
						long result = db.insert("array", null, values);

						ss.clear(); 
						Read();

						et_site.setText("");
						et_id.setText("");
						et_pass.setText("");
						et_site.requestFocus();
					}

				}
			});
			dialog.setNegativeButton("아니요", null);
			return dialog.create();
		case DIALOG_INTRO:
			AlertDialog.Builder dialog2 = new Builder(this);
			dialog2.setTitle("개발자 소개");
			dialog2.setMessage("이메일주소 : rumex13@naver.com\n개발자에게 연락해보시겠습니까?");
			dialog2.setPositiveButton("예", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Intent intent =
							new Intent(Intent.ACTION_SENDTO,
									Uri.parse("mailto:rumex13@naver.com"));
					startActivity(intent);
				}
			});
			dialog2.setNegativeButton("아니오", null);
			return dialog2.create();

		case DIALOG_WAY:
			AlertDialog.Builder dialog3 = new Builder(this);
			dialog3.setTitle("이용 안내");
			dialog3.setMessage("잃어버리기 쉬운 아이디와 비밀번호를 손쉽게 저장하세요.");
			dialog3.setPositiveButton("예", null);
			return dialog3.create();	
		case DIALOG_RESULT:
			LayoutInflater lif2 = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View MyView2 = lif2.inflate(R.layout.look, null);
			dialog4 = new Builder(this);
			dialog4.setTitle("검색 결과");
			dialog4.setView(MyView2);

			dialog4.setNegativeButton("확인",null);
			dialog4.setNeutralButton("삭제", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					db = hm.getReadableDatabase(); 
					Cursor c1 = db.query("array", null, "site=?", new String[] {ss.get(findnum).site+""}, null, null, null);

					int deletenum = 0;
					while (c1.moveToNext()) {
						deletenum = c1.getInt(c1.getColumnIndex("num"));
					}

					db=hm.getWritableDatabase();
					int result = db.delete("array", "num=?", new String[] {deletenum+""});
					Toast.makeText(getApplicationContext(), "삭제완료", 0).show();					

					int i = 0;
					ss.clear();
					Cursor c = db.query("array", null, null, null, null, null, null);
					while (c.moveToNext()) {
						ss.add(new Site(i,
								c.getString(c.getColumnIndex("site")),
								c.getString(c.getColumnIndex("id")),
								c.getString(c.getColumnIndex("pass"))));
						i++;
					}
					lv.setAdapter(adapter);
				}
			});



			return dialog4.create();

		default:
			break;
		}
		return super.onCreateDialog(id);
	}












}
