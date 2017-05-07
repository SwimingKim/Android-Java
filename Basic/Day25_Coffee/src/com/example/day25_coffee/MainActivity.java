package com.example.day25_coffee;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	final int DIALOG_HINT = 0;
	String menu = "";
	boolean esp;
	boolean milk;
	boolean water;
	boolean syrup;
	String hint = "";

	boolean user_esp;
	boolean user_milk;
	boolean user_water;
	boolean user_syrup;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Intent intent = getIntent();
		menu = intent.getStringExtra("co_menu");
		esp = intent.getBooleanExtra("co_esp", false);
		milk = intent.getBooleanExtra("co_milk", false);
		water = intent.getBooleanExtra("co_water", false);
		syrup = intent.getBooleanExtra("co_syrup", false);
		hint = intent.getStringExtra("co_hint");

		final TextView tv1 = (TextView) findViewById(R.id.textView1);
		final TextView tv2 = (TextView) findViewById(R.id.textView2);
		final TextView tv3 = (TextView) findViewById(R.id.textView3);
		final TextView tv4 = (TextView) findViewById(R.id.textView4);

		Button b_hint = (Button) findViewById(R.id.button1);
		Button b_finish = (Button) findViewById(R.id.button2);

		b_hint.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog(DIALOG_HINT);
			}
		});

		Button b1 = (Button) findViewById(R.id.b1);
		Button b2 = (Button) findViewById(R.id.b2);
		Button b3 = (Button) findViewById(R.id.b3);
		Button b4 = (Button) findViewById(R.id.b4);

		b1.setOnClickListener(new OnClickListener() {
			int count = 0;

			public void onClick(View v) {
				count++;
				if (count % 2 == 0) {
					tv1.setText("에스프레소 X\n");
					user_esp = false;
				} else {
					tv1.setText("에스프레소 O\n");
					user_esp = true;
				}
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			int count = 0;

			public void onClick(View v) {
				count++;
				if (count % 2 == 0) {
					tv2.setText("우유 X\n");
					user_milk = false;
				} else {
					tv2.setText("우유 O\n");
					user_milk = true;
				}
			}
		});
		b3.setOnClickListener(new OnClickListener() {
			int count = 0;

			public void onClick(View v) {
				count++;
				if (count % 2 == 0) {
					tv3.setText("물 X\n");
					user_water = false;
				} else {
					tv3.setText("물 O\n");
					user_water = true;
				}
			}
		});
		b4.setOnClickListener(new OnClickListener() {
			int count = 0;

			public void onClick(View v) {
				count++;
				if (count % 2 == 0) {
					tv4.setText("시럽 X\n");
					user_syrup = false;
				} else {
					tv4.setText("시럽 O\n");
					user_syrup = true;
				}
			}
		});

		b_finish.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (esp == user_esp && milk == user_milk && water == user_water && syrup == user_syrup) {
					Intent intent = new Intent(getApplicationContext(), LastActivity.class);
					startActivity(intent);

				} else {
					showDialog(1);
				}

			}
		});

	}

	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DIALOG_HINT:
			AlertDialog.Builder dialog = new Builder(this);
			dialog.setTitle("힌트");
			dialog.setMessage("한번 더 기회를 드리죠\n" + hint);
			return dialog.create();

		case 1:
			AlertDialog.Builder dialog2 = new Builder(this);
			dialog2.setTitle("다시 한번 더");
			dialog2.setMessage("틀렸어요. 다시 한번 만들어보세요.");
			return dialog2.create();

		default:
			return null;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
