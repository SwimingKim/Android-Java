package com.su.project05_puzzle;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class TwoActivity extends Activity{
	Toast to;
	final int DIALOG_LOSE = 0;
	int good, bad;
	int order[] = new int[16];
	ImageView iv[] = new ImageView[16];
	//	MediaPlayer mp1, mp2;
	Handler handler = new Handler();
	int cycle, count, po;
	int a = 0;
	Runnable r1 = new Runnable() {
		@Override
		public void run() {
			if (cycle<=order.length-1) {
				iv[order[cycle]].setBackgroundResource(R.drawable.mole);
				iv[order[cycle]].setTag("show");
				cycle++;
			} else {
				cycle = 0;
			}
			handler.postDelayed(r1, 500);
			tv.setText("잡은횟수 : "+good);
		}
	};
	Runnable r2 = new Runnable() {
		@Override
		public void run() {
			if (cycle<=iv.length-2) {
				iv[order[cycle]].setBackgroundResource(R.drawable.mole);
				iv[order[cycle+1]].setBackgroundResource(R.drawable.mole);
				iv[order[cycle]].setTag("show");
				iv[order[cycle+1]].setTag("show");
				cycle+=2;
			} else {
				cycle = 0;
			}
			handler.postDelayed(r2, 500);
			tv.setText("잡은횟수 : "+good);
		}
	};
	Runnable r3 = new Runnable() {
		@Override
		public void run() {
			if (cycle<=iv.length-4) {
				iv[order[cycle]].setBackgroundResource(R.drawable.mole);
				iv[order[cycle+1]].setBackgroundResource(R.drawable.mole);
				iv[order[cycle+2]].setBackgroundResource(R.drawable.mole);
				iv[order[cycle+3]].setBackgroundResource(R.drawable.mole);
				iv[order[cycle]].setTag("show");
				iv[order[cycle+1]].setTag("show");
				iv[order[cycle+2]].setTag("show");
				iv[order[cycle+3]].setTag("show");
				cycle+=4;
			} else {
				cycle = 0;
			}
			handler.post(r_check);
			handler.postDelayed(r3, 500);
			tv.setText("잡은횟수 : "+good);
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
	Runnable r_check= new Runnable() {
		public void run() {
			tv.setText("잡은횟수 : "+good);
			for (int i = iv.length-1; i >= 0; i--) {
				if (iv[i].getTag().equals("no")) {
					a++;
					if (a>=iv.length) {
						showDialog(5);
						to.cancel();
					}
				} else {
					a=0;
				}

			}
			Log.e("line", "핸들러진행중");
			handler.post(r_check);
		}
	};
	//	private ProgressBar pro;
	private TextView tv;
	private Timer timer;
	private Chronometer chro;
	private Vibrator vib;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two);

		chro = (Chronometer)findViewById(R.id.chronometer1);
		chro.setBase(SystemClock.elapsedRealtime()); // 시간초기화 
		chro.start();

		vib = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
		//		mp1 = MediaPlayer.create(getApplicationContext(), R.raw.hit);
		//		mp2 = MediaPlayer.create(getApplicationContext(), R.raw.bighit);

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

		tv = (TextView)findViewById(R.id.tv);
		tv.setText("잡은횟수 : 0");

		final Button b_colum = (Button)findViewById(R.id.button1);
		final Button b_row = (Button)findViewById(R.id.button2);
		final Button b_all = (Button)findViewById(R.id.button3);

		final Random ran = new Random();

		b_colum.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int num = ran.nextInt(4);
				for (int i = 0; i < 4; i++) {
					iv[num*4+i].setBackgroundResource(R.drawable.hh);
					iv[num*4+i].setTag("no");
				}
				b_colum.setClickable(false);
				b_colum.setText("");
				//				mp2.start();
			}
		});

		b_row.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int num = ran.nextInt(4);
				for (int i = 0; i < 4; i++) {
					iv[num+i*4].setBackgroundResource(R.drawable.hh);
					iv[num+i*4].setTag("no");
				}
				b_row.setClickable(false);
				b_row.setText("");
				//				mp2.start();
			}
		});
		b_all.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(intent);
				finish();
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
		handler.removeCallbacks(r_check);
		timer.cancel();
	}

	class MyEvent implements OnClickListener {
		@Override
		public void onClick(View v) {
			ImageView im = (ImageView)v;			
			if (im.getTag().equals("show")) {
				im.setBackgroundResource(R.drawable.hh);
				//				mp1.start();
				im.setTag("no");
				good++;
			} else {
				to.makeText(getApplicationContext(), "MISS", 0).show();
				vib.vibrate(300);
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
		} else if (id==5) {
			AlertDialog.Builder dialog1 = new Builder(this);
			dialog1.setTitle("성공");
			dialog1.setMessage("게임을 다시 시작하겠습니까?");
			dialog1.setPositiveButton("예", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent(getApplicationContext(),MainActivity.class);
					startActivity(intent);
					finish();					
				}
			});
			dialog1.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					finish();
				}
			});
			dialog1.setCancelable(false);
			return dialog1.create();
		}
		return super.onCreateDialog(id);
	}

}//end of class