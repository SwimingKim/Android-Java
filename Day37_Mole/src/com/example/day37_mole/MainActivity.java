package com.example.day37_mole;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	final int DIALOG_LOSE = 0;
	int good, bad;
	int order[] = new int[16];
	ImageView iv[] = new ImageView[16];
	MediaPlayer mp1, mp2;
	Handler handler = new Handler();
	int cycle, count, po;
	Runnable r1 = new Runnable() {
		@Override
		public void run() {
			if (cycle<=order.length-1) {
				iv[order[cycle]].setBackgroundResource(R.drawable.selector_mole);
				iv[order[cycle]].setTag("show");
				cycle++;
			} else {
				cycle = 0;
			}
			pro.setProgress(po++);
			handler.postDelayed(r1, 500);
		}
	};
	Runnable r2 = new Runnable() {
		@Override
		public void run() {
			if (cycle<=iv.length-2) {
				iv[order[cycle]].setBackgroundResource(R.drawable.selector_mole);
				iv[order[cycle+1]].setBackgroundResource(R.drawable.selector_mole);
				iv[order[cycle]].setTag("show");
				iv[order[cycle+1]].setTag("show");
				cycle+=2;
			} else {
				cycle = 0;
			}
			pro.setProgress(po++);
			handler.postDelayed(r2, 500);
			tv.setText("2단계 진행중");
		}
	};
	Runnable r3 = new Runnable() {
		@Override
		public void run() {
			if (cycle<=iv.length-4) {
				iv[order[cycle]].setBackgroundResource(R.drawable.selector_mole);
				iv[order[cycle+1]].setBackgroundResource(R.drawable.selector_mole);
				iv[order[cycle+2]].setBackgroundResource(R.drawable.selector_mole);
				iv[order[cycle+3]].setBackgroundResource(R.drawable.selector_mole);
				iv[order[cycle]].setTag("show");
				iv[order[cycle+1]].setTag("show");
				iv[order[cycle+2]].setTag("show");
				iv[order[cycle+3]].setTag("show");
				cycle+=4;
			} else {
				cycle = 0;
			}
			pro.setProgress(po++);
			handler.postDelayed(r3, 500);
			tv.setText("3단계 진행중");
		}
	};
	Runnable r_end = new Runnable() {
		@Override
		public void run() {
			for (int i = iv.length-1; i >= 0; i--) {
				if (iv[i].getTag().equals("show")) {
					count++;
					if (count>=16) {
						showDialog(DIALOG_LOSE);
					}
				} else {
					count = 0;
				}
			}
			handler.post(r_end);
		}
	};
	private ProgressBar pro;
	private TextView tv;
	private Timer timer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mp1 = MediaPlayer.create(getApplicationContext(), R.raw.hit);
		mp2 = MediaPlayer.create(getApplicationContext(), R.raw.bighit);

		iv[0] = (ImageView)findViewById(R.id.ImageView1);
		iv[1] = (ImageView)findViewById(R.id.ImageView2);
		iv[2] = (ImageView)findViewById(R.id.ImageView3);
		iv[3] = (ImageView)findViewById(R.id.ImageView4);
		iv[4] = (ImageView)findViewById(R.id.ImageView5);
		iv[5] = (ImageView)findViewById(R.id.ImageView6);
		iv[6] = (ImageView)findViewById(R.id.ImageView7);
		iv[7] = (ImageView)findViewById(R.id.ImageView8);
		iv[8] = (ImageView)findViewById(R.id.ImageView9);
		iv[9] = (ImageView)findViewById(R.id.ImageView10);
		iv[10] = (ImageView)findViewById(R.id.ImageView11);
		iv[11] = (ImageView)findViewById(R.id.ImageView12);
		iv[12] = (ImageView)findViewById(R.id.ImageView13);
		iv[13] = (ImageView)findViewById(R.id.ImageView14);
		iv[14] = (ImageView)findViewById(R.id.ImageView15);
		iv[15] = (ImageView)findViewById(R.id.ImageView16);

		tv = (TextView)findViewById(R.id.textView1);
		tv.setText("1단계 진행중");

		final Button b_all = (Button)findViewById(R.id.all);
		final Button b_colum = (Button)findViewById(R.id.colum);
		final Button b_row = (Button)findViewById(R.id.row);

		pro = (ProgressBar)findViewById(R.id.progressBar1);
		
		final Random ran = new Random();

		b_all.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				for (int i = 0; i < iv.length; i++) {
					iv[i].setBackgroundResource(R.drawable.pan);
					iv[i].setTag("no");
				}
				b_all.setClickable(false);
				b_all.setText("");
				mp2.start();
			}
		});

		b_colum.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int num = ran.nextInt(4);
				for (int i = 0; i < 4; i++) {
					iv[num*4+i].setBackgroundResource(R.drawable.pan);
					iv[num*4+i].setTag("no");
				}
				b_colum.setClickable(false);
				b_colum.setText("");
				mp2.start();
			}
		});

		b_row.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int num = ran.nextInt(4);
				for (int i = 0; i < 4; i++) {
					iv[num+i*4].setBackgroundResource(R.drawable.pan);
					iv[num+i*4].setTag("no");
				}
				b_row.setClickable(false);
				b_row.setText("");
				mp2.start();
			}
		});


		for (int i = 0; i < iv.length; i++) {
			order[i] = i;
		}
		for (int i = 0; i < iv.length*2; i++) {
			int n1 = ran.nextInt(iv.length);
			int n2 = ran.nextInt(iv.length);

			int temp1 = order[n1];
			order[n1] = order[n2];
			order[n2] = temp1;				
		}

		handler.post(r1);
		handler.post(r_end);

		TimerTask task1 = new TimerTask() {
			public void run() {
				handler.removeCallbacks(r1);
				handler.post(r2);
			}
		};
		TimerTask task2 = new TimerTask() {
			public void run() {
				handler.removeCallbacks(r2);
				handler.post(r3);
			}
		};
		TimerTask task3 = new TimerTask() {
			public void run() {
				handler.removeCallbacks(r3);	
				handler.removeCallbacks(r_end);	
				Intent intent = new Intent(getApplicationContext(),EndActivity.class);
				intent.putExtra("성공", good);
				intent.putExtra("실패", bad);
				startActivity(intent);
				finish();
			}
		};

		timer = new Timer();
		timer.schedule(task1, 10000);// 1단계 종료&2단계 시작
		timer.schedule(task2, 20000);// 2단계 종료&3단계 시작
		timer.schedule(task3, 30000);// 3단계 종료&다음화면 전환


		MyEvent me = new MyEvent();
		for (int i = 0; i < iv.length; i++) {
			iv[i].setTag("no");
			iv[i].setOnClickListener(me);
		}



	}//end of onCreate

	protected void onDestroy() {
		super.onDestroy();
		handler.removeCallbacks(r1);
		handler.removeCallbacks(r2);
		handler.removeCallbacks(r3);
		handler.removeCallbacks(r_end);
		timer.cancel();
	}

	class MyEvent implements OnClickListener {
		@Override
		public void onClick(View v) {
			ImageView im = (ImageView)v;			
			if (im.getTag().equals("show")) {
				im.setBackgroundResource(R.drawable.pan);
				mp1.start();
				im.setTag("no");
				good++;
			} else {
				Toast.makeText(getApplicationContext(), "MISS", 0).show();
				bad++;
			}

		}
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		if (id==DIALOG_LOSE) {
			AlertDialog.Builder dialog = new Builder(this);
			handler.removeCallbacks(r1);
			handler.removeCallbacks(r2);
			handler.removeCallbacks(r3);
			handler.removeCallbacks(r_end);
			timer.cancel();
			dialog.setTitle("실패");
			dialog.setMessage("두더지가 모두 마을로 침입했습니다. 다시 도전하시겠습니까?");
			dialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent(getApplicationContext(),MainActivity.class);
					startActivity(intent);
					finish();					
				}
			});
			dialog.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					finish();
				}
			});
			dialog.setCancelable(false);
			return dialog.create();
		}
		return super.onCreateDialog(id);
	}

}//end of class
