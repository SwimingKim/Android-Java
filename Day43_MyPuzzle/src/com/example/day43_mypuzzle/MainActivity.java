package com.example.day43_mypuzzle;

import java.util.Arrays;
import java.util.Random;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ImageView iv[] = new ImageView[16];
	int img[] = {R.drawable.kakao_01,R.drawable.kakao_02,R.drawable.kakao_03,
			R.drawable.kakao_04,R.drawable.kakao_05,R.drawable.kakao_06,R.drawable.kakao_07,
			R.drawable.kakao_08,R.drawable.kakao_09,R.drawable.kakao_10,R.drawable.kakao_11,R.drawable.kakao_12,
			R.drawable.kakao_13,R.drawable.kakao_14,R.drawable.kakao_15,R.drawable.kakao_16};
	private Random ran;

	Animation animationToLeft;
	Animation animationToRight;
	Animation animationToUp;
	Animation animationToDown;
	int indexBlankImg;
	int index[] = new int[16];
	Handler handler = new Handler();
	Runnable r = new Runnable() {
		public void run() {
			int count = 0;
			for (int i = 0; i < index.length; i++) {
				if (index[i] == i) {
					count++;
					if (count==16) {
						count = 0;
						Toast.makeText(getApplicationContext(), "종료", 0).show();
						handler.removeCallbacks(r);
					} 
				} else {
					count = 0;
				}
			}
			handler.postDelayed(r, 1000);
		}
	};
	Runnable r_change = new Runnable() {
		public void run() {
			Arrange();
		}
	};
	private TextView tv;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		iv[0] = (ImageView)findViewById(R.id.imageView1);
		iv[1] = (ImageView)findViewById(R.id.imageView2);
		iv[2] = (ImageView)findViewById(R.id.imageView3);
		iv[3] = (ImageView)findViewById(R.id.imageView4);
		iv[4] = (ImageView)findViewById(R.id.imageView5);
		iv[5] = (ImageView)findViewById(R.id.imageView6);
		iv[6] = (ImageView)findViewById(R.id.imageView7);
		iv[7] = (ImageView)findViewById(R.id.imageView8);
		iv[8] = (ImageView)findViewById(R.id.imageView9);
		iv[9] = (ImageView)findViewById(R.id.imageView10);
		iv[10] = (ImageView)findViewById(R.id.imageView11);
		iv[11] = (ImageView)findViewById(R.id.imageView12);
		iv[12] = (ImageView)findViewById(R.id.imageView13);
		iv[13] = (ImageView)findViewById(R.id.imageView14);
		iv[14] = (ImageView)findViewById(R.id.imageView15);
		iv[15] = (ImageView)findViewById(R.id.imageView16);
		tv = (TextView)findViewById(R.id.textView1);

		MyEvent me = new MyEvent();

		// 사진 넣기&버튼이벤트
		for (int i = 0; i < index.length; i++) {
			index[i] = i;
		}

		indexBlankImg = 15;
		for (int i = 0; i < iv.length; i++) {
			iv[i].setImageResource(img[index[i]]);
			iv[i].setTag(i);
			iv[i].setOnClickListener(me);	
		}
		tv.setText(Arrays.toString(index)+"");
		tv.append("\n"+indexBlankImg);
		// 셔플 이벤트
		ran = new Random();
		Button b = (Button)findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				handler.post(r);
				// 위치 순서 섞음
				for (int i = 0; i < img.length; i++) {
					int n1 = ran.nextInt(img.length);
					int n2 = ran.nextInt(img.length);

					int temp = index[n1];
					index[n1] = index[n2];
					index[n2] = temp;	
				}
				// 이미지뷰 다시 정렬
				Arrange();
				tv.setText(Arrays.toString(index)+"");
				tv.append("\n"+indexBlankImg);
			}
		});

		Button bShow = (Button)findViewById(R.id.button3);
		bShow.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (MotionEvent.ACTION_DOWN == event.getAction()) {// 버튼을 눌렀을 때 
					for (int i = 0; i < iv.length; i++) {// 정답화면을 보여주기 
						iv[i].setImageResource(img[i]); 
					}

				} else if (MotionEvent.ACTION_UP == event.getAction()) { // 버튼을 떼었을때
					for (int i = 0; i < iv.length; i++) {// 다시 게임화면으로 돌아가기 
						iv[i].setImageResource(img[index[i]]); 
					}
				}
				return true;
			}
		});


	}//end of onCreate


	protected void onDestroy() {
		super.onDestroy();
		handler.removeCallbacks(r);
	}

	class MyEvent implements OnClickListener{

		public void onClick(View v) {
			int clickIndex = (Integer) v.getTag(); // 현재 사용자가 클릭한 이미지 index


			if (indexBlankImg-4<iv.length&&(clickIndex-indexBlankImg)%4==0&&indexBlankImg<clickIndex) {
				// 빈칸이 위쪽에 있을 때
				for (int i = 1; i <= (clickIndex-indexBlankImg)/4; i++) {
					int temp = index[clickIndex];
					index[clickIndex] = index[clickIndex-i*4];
					index[clickIndex-i*4] = temp;

					iv[clickIndex].setImageResource(img[index[clickIndex]]);
					iv[clickIndex-i*4].setImageResource(img[index[clickIndex-i*4]]);
				}
				indexBlankImg = clickIndex;
			} else if(indexBlankImg-4>=0&&(indexBlankImg-clickIndex)%4==0&&indexBlankImg>clickIndex) {
				// 빈칸이 아래쪽에 있을 때
				for (int i = 1; i <= (indexBlankImg-clickIndex)/4; i++) {
					int temp = index[clickIndex];
					index[clickIndex] = index[clickIndex+i*4];
					index[clickIndex+i*4] = temp;

					//					iv[iv[clickIndex+(i-1)*4].set]
					//					iv[clickIndex+(i-1)*4].startAnimation(animationToDown);

					//					iv[clickIndex+(i-1)*4].startAnimation(animationToDown);


					iv[clickIndex].setImageResource(img[index[clickIndex]]);
					iv[clickIndex+i*4].setImageResource(img[index[clickIndex+i*4]]);
				}
				//				handler.postDelayed(r_change,50);
				indexBlankImg = clickIndex;
			} else if (clickIndex%4!=0&&clickIndex/4==indexBlankImg/4&&
					(clickIndex-indexBlankImg)<4&&indexBlankImg<clickIndex){
				// 빈칸이 왼쪽에 있을 때
				for (int i = 1; i <= clickIndex-indexBlankImg; i++) {
					int temp = index[clickIndex];
					index[clickIndex] = index[clickIndex-i];
					index[clickIndex-i] = temp;

					iv[clickIndex].setImageResource(img[index[clickIndex]]);
					iv[clickIndex-i].setImageResource(img[index[clickIndex-i]]);
				}
				indexBlankImg = clickIndex;
			} else if (clickIndex%4!=3&&clickIndex/4==indexBlankImg/4&&
					(indexBlankImg-clickIndex)<4&&indexBlankImg>clickIndex) {
				// 빈칸이 오른쪽에 있을 때
				for (int i = 1; i <= indexBlankImg-clickIndex; i++) {
					int temp = index[clickIndex];
					index[clickIndex] = index[clickIndex+i];
					index[clickIndex+i] = temp;

					iv[clickIndex].setImageResource(img[index[clickIndex]]);
					iv[clickIndex+i].setImageResource(img[index[clickIndex+i]]);
				}
				indexBlankImg = clickIndex;
			} 






		}
	}
	void Arrange() {
		for (int i = 0; i < iv.length; i++) {
			iv[i].setImageResource(img[index[i]]);
			if (index[i]==15){
				indexBlankImg = i;
			}
			tv.setText(Arrays.toString(index)+"");
			tv.append("\n"+indexBlankImg);
		}
	}


}//end of class

