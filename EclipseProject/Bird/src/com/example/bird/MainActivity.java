package com.example.bird;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageView iv[][] = new ImageView[5][5];
	int num;
	boolean state[] = new boolean[5];
	Timer timer;
	Random ran;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		iv[0][0] = (ImageView) findViewById(R.id.imageView1);
		iv[0][1] = (ImageView) findViewById(R.id.imageView2);
		iv[0][2] = (ImageView) findViewById(R.id.imageView3);
		iv[0][3] = (ImageView) findViewById(R.id.imageView4);
		iv[0][4] = (ImageView) findViewById(R.id.imageView5);
		iv[1][0] = (ImageView) findViewById(R.id.imageView6);
		iv[1][1] = (ImageView) findViewById(R.id.imageView7);
		iv[1][2] = (ImageView) findViewById(R.id.imageView8);
		iv[1][3] = (ImageView) findViewById(R.id.imageView9);
		iv[1][4] = (ImageView) findViewById(R.id.imageView10);
		iv[2][0] = (ImageView) findViewById(R.id.imageView11);
		iv[2][1] = (ImageView) findViewById(R.id.imageView12);
		iv[2][2] = (ImageView) findViewById(R.id.imageView13);
		iv[2][3] = (ImageView) findViewById(R.id.imageView14);
		iv[2][4] = (ImageView) findViewById(R.id.imageView15);
		iv[3][0] = (ImageView) findViewById(R.id.imageView16);
		iv[3][1] = (ImageView) findViewById(R.id.imageView17);
		iv[3][2] = (ImageView) findViewById(R.id.imageView18);
		iv[3][3] = (ImageView) findViewById(R.id.imageView19);
		iv[3][4] = (ImageView) findViewById(R.id.imageView20);
		iv[4][0] = (ImageView) findViewById(R.id.imageView21);
		iv[4][1] = (ImageView) findViewById(R.id.imageView22);
		iv[4][2] = (ImageView) findViewById(R.id.imageView23);
		iv[4][3] = (ImageView) findViewById(R.id.imageView24);
		iv[4][4] = (ImageView) findViewById(R.id.imageView25);

		for (int i = 0; i < iv.length; i++) {
			iv[0][i].setVisibility(View.INVISIBLE);
		}
		ran = new Random();
		num = ran.nextInt(5);

		class MyEvent implements OnClickListener {
			public void onClick(View v) {
				ImageView iw = (ImageView) v;
				Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.set);
				iw.startAnimation(animation);
			}
		}
		MyEvent me = new MyEvent();

		for (int i = 0; i < iv.length; i++) {
			for (int j = 0; j < iv[i].length; j++) {
				iv[i][j].setOnClickListener(me);
			}
		}

		// HandlerThread hThread = new HandlerThread("mythread");
		// Handler handler = new Handler(hThread.getLooper());
		// hThread.start();

		// handler.post(new Runnable() {
		// public void run() {
		// if (iv[0][num].getVisibility()==View.INVISIBLE) {
		// iv[0][num].setVisibility(View.VISIBLE);
		// }
		// }
		// });

		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			public void run() {
				if (iv[0][num].getVisibility() == View.INVISIBLE) {
					iv[0][num].setVisibility(View.VISIBLE);
				}

			}
		}, 3000);

		// handler.post(new Runnable() {
		// public void run() {
		// if (iv[0][num].getVisibility()==View.INVISIBLE) {
		// iv[0][num].setVisibility(View.VISIBLE);
		// }
		// }
		// });

		// Timer timer = new Timer();
		// timer.schedule(task, 3000,2000);

		//
		//
		//
		// Handler ha = new Handler();
		//
		//
		//// for (int i = 0; i < 1000000; i++) {
		//// Timer timer = new Timer();
		//// timer.schedule(task, 3000, 5000);
		//// }
		////
		//
		//// Timer timer = new Timer();
		//// timer.schedule(task, 3000,2000);
		//
		// do {
		// num = ran.nextInt(5);
		// Log.v("", "타이머 작동중 ");
		// timer.schedule(task, 3000,2000);
		// } while (num==3);
		// iv[0][num].setVisibility(View.VISIBLE);
		//
		//
		//
		//
		//
		//
	}
	//
	//
	//
	// TimerTask task = new TimerTask() {
	// public void run() {
	// num = ran.nextInt(5);
	// Log.v("", "타이머 작동중 ");
	// cancel();
	//
	// }
	// };

	protected void onDestroy() {
		timer.cancel();
		super.onDestroy();
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
