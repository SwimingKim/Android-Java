package com.example.window;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ImageView iv[] = new ImageView[12];
	int dap1;
	int dap2;
	int dap3;
	int count = 0;

	SoundPool sp;
	int soundID1;

	final int DIGALOG_WAY = 0;
	final int DIGALOG_INTRO = 1;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		iv[0] = (ImageView) findViewById(R.id.ImageView1);
		iv[1] = (ImageView) findViewById(R.id.ImageView2);
		iv[2] = (ImageView) findViewById(R.id.ImageView3);
		iv[3] = (ImageView) findViewById(R.id.ImageView4);
		iv[4] = (ImageView) findViewById(R.id.ImageView5);
		iv[5] = (ImageView) findViewById(R.id.ImageView6);
		iv[6] = (ImageView) findViewById(R.id.ImageView7);
		iv[7] = (ImageView) findViewById(R.id.ImageView8);
		iv[8] = (ImageView) findViewById(R.id.ImageView9);
		iv[9] = (ImageView) findViewById(R.id.ImageView10);
		iv[10] = (ImageView) findViewById(R.id.ImageView11);
		iv[11] = (ImageView) findViewById(R.id.ImageView12);

		Random ran = new Random();
		dap1 = ran.nextInt(12);
		dap1 = ran.nextInt(12);
		dap1 = ran.nextInt(12);

		MyClick mc = new MyClick();
		for (int i = 0; i < iv.length; i++) {
			iv[i].setOnClickListener(mc);
		}

		sp = new SoundPool(255, AudioManager.STREAM_MUSIC, 0);
		soundID1 = sp.load(this, R.raw.sound, 1);

	}// end of onCreate

	class MyClick implements OnClickListener {
		public void onClick(View v) {
			ImageView window = (ImageView) v;

			window.setImageResource(R.drawable.broken);
			sp.play(soundID1, 1, 1, 0, 0, 1);
			if (iv[dap1].isPressed()) {
				Intent intent = new Intent(getApplicationContext(), LastActivity.class);
				startActivity(intent);

				finish();
			}

			// if (iv[dap1].isPressed()&&
			// iv[dap2].isPressed()&&
			// iv[dap3].isPressed()) {
			// Intent intent = new
			// Intent(getApplicationContext(),LastActivity.class);
			// startActivity(intent);
			//
			// finish();
			// } else if (iv[dap1].isPressed()&&iv[dap2].isPressed()||
			// iv[dap2].isPressed()&&iv[dap3].isPressed()||
			// iv[dap2].isPressed()&&iv[dap3].isPressed()) {
			// Toast.makeText(getApplicationContext(), "2개 맞춤", 0).show();
			// } else if (iv[dap1].isPressed()||
			// iv[dap2].isPressed()||
			// iv[dap3].isPressed()){
			// Toast.makeText(getApplicationContext(), "1개 맞춤", 0).show();
			// }

		}
	}

	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DIGALOG_WAY:
			AlertDialog.Builder dialog = new Builder(this);
			dialog.setTitle("게임방법");
			dialog.setMessage("창문에 숨겨진 트로피를 찾아주세요");
			dialog.setPositiveButton("예", null);
			return dialog.create();
		case DIGALOG_INTRO:
			AlertDialog.Builder dialog2 = new Builder(this);
			dialog2.setTitle("개발자 소개");
			dialog2.setMessage("개발자에게 연락해보시겠습니까?");
			dialog2.setPositiveButton("예", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:010-9622-0213"));
					startActivity(intent);
				}
			});
			dialog2.setNegativeButton("아니오", null);
			return dialog2.create();

		default:
			break;
		}

		return super.onCreateDialog(id);
	}

	// public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo
	// menuInfo) {
	// getMenuInflater().inflate(R.menu.main, menu);
	// super.onCreateContextMenu(menu, v, menuInfo);
	// }

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
		switch (item.getItemId()) {
		case R.id.intro:
			showDialog(DIGALOG_INTRO);
			return true;
		case R.id.way:
			showDialog(DIGALOG_WAY);
			return true;
		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}
}
