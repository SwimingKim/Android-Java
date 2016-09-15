package com.example.friend;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
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

	Friend fri[] = { new Friend("김수영", "010-9622-0213", 940213, R.drawable.suyoung),
			new Friend("김아영", "010-6662-3586", 940207, R.drawable.ayoung),
			new Friend("김유나", "010-4695-1880", 931122, R.drawable.una),
			new Friend("이은지", "010-8902-4091", 931119, R.drawable.eunji),
			new Friend("정혜진", "010-2345-8896", 930716, R.drawable.hejin),
			new Friend("최아은", "010-4802-3098", 931227, R.drawable.aeun), };
	int num = 0;
	MyAdapter ma;
	String nm[] = { fri[0].name, fri[1].name, fri[2].name, fri[3].name, fri[4].name, fri[5].name, };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ListView lv = (ListView) findViewById(R.id.listView1);
		ma = new MyAdapter(getApplicationContext(), R.layout.row, fri);
		lv.setAdapter(ma);

		final EditText ed = (EditText) findViewById(R.id.editText1);
		Button b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				for (int i = 0; i < fri.length; i++) {
					if (ed.getText().toString().equals(fri[i].name)) {
						num = i;
						showDialog(1);
					} else
						break;
				}
				// Toast.makeText(getApplicationContext(), "검색어를 확인해주세요",
				// 0).show();

			}
		});

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				num = position;
				showDialog(1);

			}
		});

	}// end of onCreate

	protected Dialog onCreateDialog(int id) {
		// Dialog dialog = null;
		if (id == 1) {
			LayoutInflater li = (LayoutInflater) getApplicationContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View myview = (View) li.inflate(R.layout.row, null);
			AlertDialog.Builder dialog = new Builder(this);
			dialog.setTitle("검색결과");
			dialog.setView(myview);
			//
			return dialog.create();
		}
		return null;

	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog, Bundle args) {
		ImageView div = (ImageView) dialog.findViewById(R.id.imageView1);
		TextView dtName = (TextView) dialog.findViewById(R.id.textView1);
		TextView dtBirth = (TextView) dialog.findViewById(R.id.textView2);
		TextView dtNumber = (TextView) dialog.findViewById(R.id.textView3);

		div.setImageResource(fri[num].img);
		dtName.setText(fri[num].name);
		dtNumber.setText(fri[num].number);
		dtBirth.setText(fri[num].birth + "");

		super.onPrepareDialog(id, dialog, args);
	}

}// end of class

class MyAdapter extends BaseAdapter {
	int layout;
	Friend[] fri;
	LayoutInflater lif;

	public MyAdapter() {
	}

	public MyAdapter(Context context, int layout, Friend[] fri) {
		this.layout = layout;
		this.fri = fri;
		this.lif = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return fri.length;
	}

	public Object getItem(int position) {
		return fri[position];
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = lif.inflate(layout, null);
		}

		ImageView iv = (ImageView) convertView.findViewById(R.id.imageView1);
		TextView tName = (TextView) convertView.findViewById(R.id.textView1);
		TextView tBirth = (TextView) convertView.findViewById(R.id.textView2);
		TextView tNumber = (TextView) convertView.findViewById(R.id.textView3);

		iv.setImageResource(fri[position].img);
		tName.setText(fri[position].name);
		tNumber.setText(fri[position].number);
		tBirth.setText(fri[position].birth + "");

		return convertView;
	}

}

class Friend {
	String name;
	String number;
	int birth;
	int img;

	public Friend() {
	}

	public Friend(String name, String number, int birth, int img) {
		this.name = name;
		this.number = number;
		this.birth = birth;
		this.img = img;
	}

}
