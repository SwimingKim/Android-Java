package com.example.secret;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
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
	arrArray a = new arrArray(0, "사이트", "아이디", "비밀번호");
	arrArray ba[] = new arrArray[100];
	AlertDialog.Builder dialog4;
	ArrayList<arrArray> arr;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		hm = new HelpMe(getApplicationContext(), "MySecret.db", null, 1);
		arr = new ArrayList<MainActivity.arrArray>();

		db = hm.getReadableDatabase();
		c = db.query("array", null, null, null, null, null, null);

		while (c.moveToNext()) {
			int num = c.getInt(c.getColumnIndex("num"));
			String site = c.getString(c.getColumnIndex("site"));
			String id = c.getString(c.getColumnIndex("id"));
			String pass = c.getString(c.getColumnIndex("pass"));

			arr.add(new arrArray(num, site, id, pass));

		}

		final EditText et_search = (EditText) findViewById(R.id.editText1);
		Button b = (Button) findViewById(R.id.button1);

		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (et_search.getText().toString().equals("")) {
					Toast.makeText(getApplicationContext(), "내용을 입력하세요", 0).show();
				} else {
					db = hm.getReadableDatabase(); // 검색을 위해 읽기모드
					Cursor c = db.query("array", null, "site=?", new String[] { et_search.getText().toString() }, null,
							null, null);

					while (c.moveToNext()) {
						a.num = c.getInt(c.getColumnIndex("num"));
						a.site = c.getString(c.getColumnIndex("site"));
						a.id = c.getString(c.getColumnIndex("id"));
						a.pass = c.getString(c.getColumnIndex("pass"));
						showDialog(DIALOG_RESULT);
					}
					et_search.setText("");

				}

			}
		});

		ListView lv = (ListView) findViewById(R.id.listView1);
		MyAdater adapter = new MyAdater(getApplicationContext(), R.layout.show, arr);
		lv.setAdapter(adapter);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				db = hm.getReadableDatabase(); // 검색을 위해 읽기모드
				Cursor c = db.query("array", null, "site=?", new String[] { arr.get(position).site }, null, null, null);

				while (c.moveToNext()) {
					a.num = c.getInt(c.getColumnIndex("num"));
					a.site = c.getString(c.getColumnIndex("site"));
					a.id = c.getString(c.getColumnIndex("id"));
					a.pass = c.getString(c.getColumnIndex("pass"));
					showDialog(DIALOG_RESULT);
				}
				et_search.setText("");

			}
		});

	}// end of onCreate

	class MyAdater extends BaseAdapter {
		int row;
		ArrayList<arrArray> arr;
		LayoutInflater lif;

		public MyAdater(Context context, int row, ArrayList<arrArray> arr) {
			this.row = row;
			this.arr = arr;
			this.lif = (LayoutInflater) getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
		}

		public int getCount() {
			return arr.size();
		}

		public Object getItem(int position) {
			return arr.get(position);
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = lif.inflate(row, null);
			}

			TextView et1 = (TextView) convertView.findViewById(R.id.textView4);
			TextView et2 = (TextView) convertView.findViewById(R.id.textView5);
			TextView et3 = (TextView) convertView.findViewById(R.id.textView6);

			et1.setText(arr.get(position).site);
			et2.setText(arr.get(position).id);
			et3.setText(arr.get(position).pass);

			return convertView;
		}

	}

	class arrArray {
		int num;
		String site;
		String id;
		String pass;

		public arrArray(int num, String site, String id, String pass) {
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
		case R.id.add:
			showDialog(DIALOG_ADD);
			return true;
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

			final EditText et_site = (EditText) dialog.findViewById(R.id.editText1);
			final EditText et_id = (EditText) dialog.findViewById(R.id.editText2);
			final EditText et_pass = (EditText) dialog.findViewById(R.id.editText3);

			et_site.setText(a.site);
			et_id.setText(a.id);
			et_pass.setText(a.pass);

			dialog4.setPositiveButton("수정", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					db = hm.getWritableDatabase();
					ContentValues values = new ContentValues();
					values.put("site", et_site.getText().toString());
					values.put("id", et_id.getText().toString());
					values.put("pass", et_pass.getText().toString());

					db.update("array", values, "num=?", new String[] { "a.num" });
					Toast.makeText(getApplicationContext(), "수정완료", 0).show();

					et_result.setText("회원가입목록");
					Cursor c = db.query("array", null, null, null, null, null, null);
					while (c.moveToNext()) {
						int num = c.getInt(c.getColumnIndex("num"));
						String site = c.getString(c.getColumnIndex("site"));
						String id = c.getString(c.getColumnIndex("id"));
						String pass = c.getString(c.getColumnIndex("pass"));

						arr.add(new arrArray(num, site, id, pass));
					}

				}
			});

			break;

		default:
			break;
		}

		super.onPrepareDialog(id, dialog);
	}

	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DIALOG_ADD:
			LayoutInflater lif = (LayoutInflater) getApplicationContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			final View myView = lif.inflate(R.layout.plus, null);
			AlertDialog.Builder dialog = new Builder(this);
			dialog.setTitle("추가하기");
			dialog.setView(myView);
			dialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					final EditText et_site = (EditText) myView.findViewById(R.id.editText1);
					final EditText et_id = (EditText) myView.findViewById(R.id.editText2);
					final EditText et_pass = (EditText) myView.findViewById(R.id.editText3);
					if (et_site.getText().toString().equals("") && et_id.getText().toString().equals("")
							&& et_pass.getText().toString().equals("")) {
						Toast.makeText(getApplicationContext(), "내용을 입력하세요", 0).show();
					} else {
						db = hm.getWritableDatabase();
						ContentValues values = new ContentValues();

						values.put("site", et_site.getText().toString());
						values.put("id", et_id.getText().toString());
						values.put("pass", et_pass.getText().toString());
						long result = db.insert("array", null, values);

						db = hm.getReadableDatabase();
						Cursor c = db.query("array", null, null, null, null, null, null);

						while (c.moveToNext()) {
							int num = c.getInt(c.getColumnIndex("num"));
							String site = c.getString(c.getColumnIndex("site"));
							String id = c.getString(c.getColumnIndex("id"));
							String pass = c.getString(c.getColumnIndex("pass"));
							arr.add(num, new arrArray(num, site, id, pass));
						}

						et_site.setText("");
						et_id.setText("");
						et_pass.setText("");
					}

				}
			});
			dialog.setNegativeButton("아니요", null);
			return dialog.create();
		case DIALOG_INTRO:
			AlertDialog.Builder dialog2 = new Builder(this);
			dialog2.setTitle("개발자 소개");
			dialog2.setMessage("전화번호 : 010-9622-0213\n개발자에게 연락해보시겠습니까?");
			dialog2.setPositiveButton("예", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:010-9622-0213"));
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
			LayoutInflater lif2 = (LayoutInflater) getApplicationContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View MyView2 = lif2.inflate(R.layout.look, null);
			dialog4 = new Builder(this);
			dialog4.setTitle("검색 결과");
			dialog4.setView(MyView2);

			dialog4.setNegativeButton("확인", null);
			dialog4.setNeutralButton("삭제", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					db = hm.getWritableDatabase();
					int result = db.delete("array", "site=?", new String[] { a.site });
					Toast.makeText(getApplicationContext(), "삭제완료", 0).show();

					Cursor c = db.query("array", null, null, null, null, null, null);
					while (c.moveToNext()) {
						int num = c.getInt(c.getColumnIndex("num"));
						String site = c.getString(c.getColumnIndex("site"));
						String id = c.getString(c.getColumnIndex("id"));
						String pass = c.getString(c.getColumnIndex("pass"));
						arr.add(new arrArray(num, site, id, pass));
					}
				}
			});

			return dialog4.create();

		default:
			break;
		}
		return super.onCreateDialog(id);
	}

}
