package com.example.day43_puzzle;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	ImageView iv [] = new ImageView[16];
	int img[] = {R.drawable.kakao_01,R.drawable.kakao_02,R.drawable.kakao_03,R.drawable.kakao_04
			,R.drawable.kakao_05,R.drawable.kakao_06,R.drawable.kakao_07,R.drawable.kakao_08
			,R.drawable.kakao_09,R.drawable.kakao_10,R.drawable.kakao_11,R.drawable.kakao_12,R.drawable.kakao_13
			,R.drawable.kakao_14,R.drawable.kakao_15,R.drawable.kakao_16};

	int index[] = new int [16]; //섞인 인덱스를 저장할 배열
	int indexBlankImg; // 빈 이미지의 인덱스 
	int moveCount; // 이동횟수 
	private Button bStart;
	private Button bSuffle;
	private Button bHint;
	private TextView tvMoveCount;
	private TextView tvMessage;
	private Chronometer chro;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tvMoveCount = (TextView)findViewById(R.id.textView1);
		tvMessage = (TextView)findViewById(R.id.textView2); // 게임설명

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

		bStart = (Button)findViewById(R.id.button1);
		bSuffle = (Button)findViewById(R.id.button2);
		bHint = (Button)findViewById(R.id.button3);
		chro = (Chronometer)findViewById(R.id.chronometer1);

		setIVEnable(false);

		for (int i = 0; i < iv.length; i++) { // index배열 초기화
			index[i] = i;

		}

		indexBlankImg = 15;

		for (int i = 0; i < iv.length; i++) {
			iv[i].setOnClickListener(this);
			iv[i].setTag(i); // 각 이미지뷰를 구분하기 위한 tag값을 저장 
			iv[i].setImageResource(img[index[i]]); // 이미지 세팅 , 초기화


		}



		bStart.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (bStart.getText().toString().equals("게임시작")){ // 게임 시작
					suffle();
					chro.setBase(SystemClock.elapsedRealtime()); // 시간초기화 

					chro.start(); // 시간 시작 
					bStart.setText("게임종료");

					// 모든 이미지 뷰를 클릭할 수 있게 
					for (int i = 0; i < iv.length; i++) {
						setIVEnable(true);
					}


				} else {// 게임 종료하기 
					chro.stop();
					bStart.setText("게임시작");
					setIVEnable(true);
					// 모든 imageView를 클릭하지 못하게 
					for (int i = 0; i < iv.length; i++) {
						iv[i].setEnabled(false);
					}

				}

			}
		});

		bSuffle.setOnClickListener(new OnClickListener() {
			public void onClick(View v) { // 순서섞기
				suffle();
			}
		});

		bHint.setOnTouchListener(new OnTouchListener() {
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


		//		chro.start(); // 시간 시작 
		//		chro.stop(); 



	} // end of onCreate


	public void onClick(View v) { // 이미지뷰를 클릭시 이벤트 처리 
		int clickIndex = (Integer) v.getTag(); // 현재 사용자가 클릭한 이미지 index
		// indexBlankImg : 빈칸이미지의 index
		if (clickIndex-4 >= 0 && clickIndex-4 == indexBlankImg) { // 클릭의 위쪽이 빈칸?
			//위쪽(빈칸)과 내꺼를 변경
			//			swapImage(clickIndex);

		} else if (clickIndex+4 < iv.length && clickIndex+4 == indexBlankImg){ //아래쪽
			//아래쪽(빈칸)과 내꺼를 변경
			swapImage(clickIndex);

		} else if (clickIndex%4 != 0 && clickIndex-1 == indexBlankImg ){ // 왼쪽 
			//왼쪽(빈칸)과 내꺼를 변경
			//			swapImage(clickIndex);

		} else if (clickIndex%4 != 3 && clickIndex+1 == indexBlankImg ){ // 오른쪽
			//오른쪽(빈칸)과 내꺼를 변경
			//			swapImage(clickIndex);

		}
		
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
				
				iv[clickIndex].setImageResource(img[index[clickIndex]]);
				iv[clickIndex+i*4].setImageResource(img[index[clickIndex+i*4]]);
			}
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


		//		Toast.makeText(getApplicationContext(), clickIndex+"번째 이미지 클릭", Toast.LENGTH_SHORT).show();

	} // end of onClick(View v)

	void swapImage(int clickIndex) { //빈칸과 내 이미지를 교체하는 메서드
		int temp = index[clickIndex];
		index[clickIndex] = index[indexBlankImg];
		index[indexBlankImg] = temp;

		iv[clickIndex].setImageResource(img[index[clickIndex]]);
		iv[indexBlankImg].setImageResource(img[index[indexBlankImg]]);

		indexBlankImg = clickIndex; // 빈칸의 위치를 변경해줌

	}

	void suffle() { // 무작위로 셔플 
		Random ran = new Random();

		for (int i = 0; i < iv.length; i++) {
			int ranNum1 = ran.nextInt(iv.length); // 0~15
			int ranNum2 = ran.nextInt(iv.length); // 0~15

			int temp = index[ranNum1];
			index[ranNum1] = index[ranNum2];
			index[ranNum2] = temp;

		}

		//indexBlankImg의 위치 설정 
		for (int i = 0; i < iv.length; i++) {
			if(index[i] == 15 ) {
				indexBlankImg = i; //빈칸의 이미지가 들어있는 방 인덱스
				break;
			}

		}


		// iv에 image를 index 방의 값으로 교체하기 
		for (int i = 0; i < iv.length; i++) {
			iv[i].setImageResource(img[index[i]]); //섞인 번호대로 이미지 재배치 
		}
	}

	void setIVEnable (boolean b){
		for (int i = 0; i < iv.length; i++) {
			iv[i].setEnabled(b);
		}
	}
} // end of class
