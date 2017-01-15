package com.example.day42_gridveiw_puzzle;

import java.util.Random;
import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	int seo[] = {R.drawable.seo_01, R.drawable.seo_02,R.drawable.seo_03,R.drawable.seo_04,
			R.drawable.seo_05,R.drawable.seo_06,R.drawable.seo_07,R.drawable.seo_08,
			R.drawable.seo_09,R.drawable.seo_10,R.drawable.seo_11,R.drawable.seo_12,
			R.drawable.seo_13,R.drawable.seo_14,R.drawable.seo_15,R.drawable.seo_16,};
	private Random ran;
	MyGrid mg;
	GridView gv;

	Vibrator vib;
	MediaPlayer mp;
	
	int index[] = new int [16]; //섞인 인덱스를 저장할 배열
	int indexBlankImg; // 빈 이미지의 인덱스 
	int moveCount; // 이동횟수 
	private Button bStart;
	private Button bSuffle;
	private Button bHint;
	private TextView tvMoveCount;
	private TextView tvMessage;
	private Chronometer chro;
	Handler handler = new Handler();
	Runnable r_change = new Runnable() {
		public void run() {
			gv.setAdapter(mg);
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mg = new MyGrid(getApplicationContext(),R.layout.row,seo);
		gv = (GridView)findViewById(R.id.gridView1);
		gv.setAdapter(mg);
		gv.setEnabled(false);
		
		tvMoveCount = (TextView)findViewById(R.id.textView1);
		tvMessage = (TextView)findViewById(R.id.textView2); // 게임설명

		bStart = (Button)findViewById(R.id.button1);
		bSuffle = (Button)findViewById(R.id.button2);
		bHint = (Button)findViewById(R.id.button3);
		chro = (Chronometer)findViewById(R.id.chronometer1);
		vib = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
		
		// 사진 넣기&버튼이벤트
		for (int i = 0; i < seo.length; i++) {
			index[i] = i;
			if (seo[i]==R.drawable.seo_01) {
				indexBlankImg = i;
			}
		}
		bSuffle.setEnabled(false);
		bHint.setEnabled(false);

		// 셔플 이벤트
		ran = new Random();

		bStart.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (bStart.getText().toString().equals("게임시작")){ // 게임 시작
					for (int i = 0; i < seo.length; i++) {
						int n1 = ran.nextInt(seo.length);
						int n2 = ran.nextInt(seo.length);

						int temp = index[n1];
						index[n1] = index[n2];
						index[n2] = temp;	
					}
					gv.setAdapter(mg);
					chro.setBase(SystemClock.elapsedRealtime()); // 시간초기화 
					chro.start(); // 시간 시작 
					
					mp = MediaPlayer.create(getApplicationContext(), R.raw.music);
					if (mp==null||!mp.isPlaying()) {
						mp.start();
						mp.setLooping(true);
					}

					tvMessage.setText("게임진행중");
					bStart.setText("게임종료");
					bSuffle.setEnabled(true);
					bHint.setEnabled(true);

					// 모든 이미지 뷰를 클릭할 수 있게 
					gv.setEnabled(true);
					for (int i = 0; i < seo.length; i++) {
						if (seo[index[i]]==R.drawable.seo_01) {
							indexBlankImg = i;
						}
					}


				} else {// 게임 종료하기 
					chro.stop();
					if (mp!=null) {
						mp.stop();
					}
					tvMessage.setText("게임종료");
					bStart.setText("게임시작");
					// 모든 imageView를 클릭하지 못하게 
					gv.setEnabled(false);
					bSuffle.setEnabled(false);
					bHint.setEnabled(false);
					tvMoveCount.setText("이동횟수 : 0");
				}

			}
		});

		bSuffle.setOnClickListener(new OnClickListener() {
			public void onClick(View v) { // 순서섞기
				for (int i = 0; i < seo.length; i++) {
					int n1 = ran.nextInt(seo.length);
					int n2 = ran.nextInt(seo.length);

					int temp = index[n1];
					index[n1] = index[n2];
					index[n2] = temp;	
				}
				gv.setAdapter(mg);
			}
		});

		bHint.setOnTouchListener(new OnTouchListener() {
			int temp[] = new int[16];
			public boolean onTouch(View v, MotionEvent event) {
				if (MotionEvent.ACTION_DOWN == event.getAction()) {// 버튼을 눌렀을 때 
					for (int i = 0; i < index.length; i++) {
						temp[i] = index[i];
						index[i] = i;
					}
					gv.setAdapter(mg);

				} else if (MotionEvent.ACTION_UP == event.getAction()) { // 버튼을 떼었을때
					for (int i = 0; i < index.length; i++) {
						index[i] = temp[i];
					}
					gv.setAdapter(mg);// 다시 게임화면으로 돌아가기 
				}
				return true;
			}
		});

//		animationToLeft = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.toright);
//		animationToRight = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.toleft);
//		animationToUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.toup);
//		animationToDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.todown);
		
		
		gv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int clickIndex, long id) {
				moveCount++;
				if (indexBlankImg-4<seo.length&&(clickIndex-indexBlankImg)%4==0&&indexBlankImg<clickIndex) {
					// 빈칸이 위쪽에 있을 때
					for (int i = 1; i <= (clickIndex-indexBlankImg)/4; i++) {
						int temp = index[clickIndex];
						index[clickIndex] = index[clickIndex-i*4];
						index[clickIndex-i*4] = temp;
					}
					gv.setAdapter(mg);
				} else if(indexBlankImg-4>=0&&(indexBlankImg-clickIndex)%4==0&&indexBlankImg>clickIndex) {
					// 빈칸이 아래쪽에 있을 때
					for (int i = 1; i <= (indexBlankImg-clickIndex)/4; i++) {
						int temp = index[clickIndex];
						index[clickIndex] = index[clickIndex+i*4];
						index[clickIndex+i*4] = temp;
					}
					gv.setAdapter(mg);
				} else if (clickIndex%4!=0&&clickIndex/4==indexBlankImg/4&&
						(clickIndex-indexBlankImg)<4&&indexBlankImg<clickIndex){
					// 빈칸이 왼쪽에 있을 때
					for (int i = 1; i <= clickIndex-indexBlankImg; i++) {
						int temp = index[clickIndex];
						index[clickIndex] = index[clickIndex-i];
						index[clickIndex-i] = temp;
					}
					gv.setAdapter(mg);
				} else if (clickIndex%4!=3&&clickIndex/4==indexBlankImg/4&&
						(indexBlankImg-clickIndex)<4&&indexBlankImg>clickIndex) {
					// 빈칸이 오른쪽에 있을 때
					for (int i = 1; i <= indexBlankImg-clickIndex; i++) {
						int temp = index[clickIndex];
						index[clickIndex] = index[clickIndex+i];
						index[clickIndex+i] = temp;
					}
					gv.setAdapter(mg);
				} else {
					vib.vibrate(100);
					moveCount--;
				}
				tvMoveCount.setText("이동횟수 : "+moveCount);
				
				int count = 0;
				for (int i = 0; i < index.length; i++) {
					if (index[i] == i) {
						count++;
						if (count==16) {
							count = 0;
							tvMessage.setText("성공");
						} 
					} else {
						count = 0;
						tvMessage.setText("게임진행중");
					}
				}
//				if (pos == indexBlankImg) {
//					Toast.makeText(getApplicationContext(), "땡", 0).show();
//				}
//				if (pos == indexBlankImg-1 && indexBlankImg!=0) {
//					int temp = position[indexBlankImg];
//					position[indexBlankImg] = position[indexBlankImg-1];
//					position[indexBlankImg-1] = temp;	
//					gv.setAdapter(mg);
//					tv.setText(Arrays.toString(position)+","+indexBlankImg);
//				}
//				if (pos == indexBlankImg+1 && indexBlankImg!=4) {
//					int temp = position[indexBlankImg];
//					position[indexBlankImg] = position[indexBlankImg+1];
//					position[indexBlankImg+1] = temp;	
//					gv.setAdapter(mg);
//					tv.setText(Arrays.toString(position)+","+indexBlankImg);
//				}
//				if (pos == indexBlankImg-4 && indexBlankImg>=4) {
//					int temp = position[indexBlankImg];
//					position[indexBlankImg] = position[indexBlankImg-4];
//					position[indexBlankImg-4] = temp;	
//					gv.setAdapter(mg);
//					tv.setText(Arrays.toString(position)+","+indexBlankImg);
//				}
//				if (pos == indexBlankImg+4 && indexBlankImg<=11) {
//					int temp = position[indexBlankImg];
//					position[indexBlankImg] = position[indexBlankImg+4];
//					position[indexBlankImg+4] = temp;	
//					gv.setAdapter(mg);
//					tv.setText(Arrays.toString(position)+","+indexBlankImg);
//				}
				
				
				
				
				
			}
			
		});





	}//end of onCreate

	class MyGrid extends BaseAdapter{
		int row;
		int[] img;
		LayoutInflater lif;		

		public MyGrid(Context context, int row, int[] seo) {
			this.row = row;
			this.img = seo;
			this.lif = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		}
		

		@Override
		public int getCount() {
			return seo.length;
		}

		@Override
		public Object getItem(int position) {
			return seo[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int pos, View convertView, ViewGroup parent) {
			if (convertView==null) {
				convertView = lif.inflate(R.layout.row, null);
			}
			ImageView ima = (ImageView)convertView.findViewById(R.id.imageView1);
			ima.setImageResource(seo[index[pos]]);
			
			for (int i = 0; i < seo.length; i++) {
				if (seo[index[i]]==R.drawable.seo_01) {
					indexBlankImg = i;
				}
			}
			return convertView;
		}

	}
	
	protected void onDestroy() {
		super.onDestroy();
		mp.stop();
	}


}//end of class
