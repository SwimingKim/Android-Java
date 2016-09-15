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

	int index[] = new int [16]; //���� �ε����� ������ �迭
	int indexBlankImg; // �� �̹����� �ε��� 
	int moveCount; // �̵�Ƚ�� 
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
		tvMessage = (TextView)findViewById(R.id.textView2); // ���Ӽ���

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

		for (int i = 0; i < iv.length; i++) { // index�迭 �ʱ�ȭ
			index[i] = i;

		}

		indexBlankImg = 15;

		for (int i = 0; i < iv.length; i++) {
			iv[i].setOnClickListener(this);
			iv[i].setTag(i); // �� �̹����並 �����ϱ� ���� tag���� ���� 
			iv[i].setImageResource(img[index[i]]); // �̹��� ���� , �ʱ�ȭ


		}



		bStart.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (bStart.getText().toString().equals("���ӽ���")){ // ���� ����
					suffle();
					chro.setBase(SystemClock.elapsedRealtime()); // �ð��ʱ�ȭ 

					chro.start(); // �ð� ���� 
					bStart.setText("��������");

					// ��� �̹��� �並 Ŭ���� �� �ְ� 
					for (int i = 0; i < iv.length; i++) {
						setIVEnable(true);
					}


				} else {// ���� �����ϱ� 
					chro.stop();
					bStart.setText("���ӽ���");
					setIVEnable(true);
					// ��� imageView�� Ŭ������ ���ϰ� 
					for (int i = 0; i < iv.length; i++) {
						iv[i].setEnabled(false);
					}

				}

			}
		});

		bSuffle.setOnClickListener(new OnClickListener() {
			public void onClick(View v) { // ��������
				suffle();
			}
		});

		bHint.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (MotionEvent.ACTION_DOWN == event.getAction()) {// ��ư�� ������ �� 
					for (int i = 0; i < iv.length; i++) {// ����ȭ���� �����ֱ� 
						iv[i].setImageResource(img[i]); 
					}

				} else if (MotionEvent.ACTION_UP == event.getAction()) { // ��ư�� ��������
					for (int i = 0; i < iv.length; i++) {// �ٽ� ����ȭ������ ���ư��� 
						iv[i].setImageResource(img[index[i]]); 
					}
				}
				return true;
			}
		});


		//		chro.start(); // �ð� ���� 
		//		chro.stop(); 



	} // end of onCreate


	public void onClick(View v) { // �̹����並 Ŭ���� �̺�Ʈ ó�� 
		int clickIndex = (Integer) v.getTag(); // ���� ����ڰ� Ŭ���� �̹��� index
		// indexBlankImg : ��ĭ�̹����� index
		if (clickIndex-4 >= 0 && clickIndex-4 == indexBlankImg) { // Ŭ���� ������ ��ĭ?
			//����(��ĭ)�� ������ ����
			//			swapImage(clickIndex);

		} else if (clickIndex+4 < iv.length && clickIndex+4 == indexBlankImg){ //�Ʒ���
			//�Ʒ���(��ĭ)�� ������ ����
			swapImage(clickIndex);

		} else if (clickIndex%4 != 0 && clickIndex-1 == indexBlankImg ){ // ���� 
			//����(��ĭ)�� ������ ����
			//			swapImage(clickIndex);

		} else if (clickIndex%4 != 3 && clickIndex+1 == indexBlankImg ){ // ������
			//������(��ĭ)�� ������ ����
			//			swapImage(clickIndex);

		}
		
		if (indexBlankImg-4<iv.length&&(clickIndex-indexBlankImg)%4==0&&indexBlankImg<clickIndex) {
			// ��ĭ�� ���ʿ� ���� ��
			for (int i = 1; i <= (clickIndex-indexBlankImg)/4; i++) {
				int temp = index[clickIndex];
				index[clickIndex] = index[clickIndex-i*4];
				index[clickIndex-i*4] = temp;
				
				iv[clickIndex].setImageResource(img[index[clickIndex]]);
				iv[clickIndex-i*4].setImageResource(img[index[clickIndex-i*4]]);
			}
			indexBlankImg = clickIndex;
		} else if(indexBlankImg-4>=0&&(indexBlankImg-clickIndex)%4==0&&indexBlankImg>clickIndex) {
			// ��ĭ�� �Ʒ��ʿ� ���� ��
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
			// ��ĭ�� ���ʿ� ���� ��
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
			// ��ĭ�� �����ʿ� ���� ��
			for (int i = 1; i <= indexBlankImg-clickIndex; i++) {
				int temp = index[clickIndex];
				index[clickIndex] = index[clickIndex+i];
				index[clickIndex+i] = temp;

				iv[clickIndex].setImageResource(img[index[clickIndex]]);
				iv[clickIndex+i].setImageResource(img[index[clickIndex+i]]);
			}
			indexBlankImg = clickIndex;
		} 


		//		Toast.makeText(getApplicationContext(), clickIndex+"��° �̹��� Ŭ��", Toast.LENGTH_SHORT).show();

	} // end of onClick(View v)

	void swapImage(int clickIndex) { //��ĭ�� �� �̹����� ��ü�ϴ� �޼���
		int temp = index[clickIndex];
		index[clickIndex] = index[indexBlankImg];
		index[indexBlankImg] = temp;

		iv[clickIndex].setImageResource(img[index[clickIndex]]);
		iv[indexBlankImg].setImageResource(img[index[indexBlankImg]]);

		indexBlankImg = clickIndex; // ��ĭ�� ��ġ�� ��������

	}

	void suffle() { // �������� ���� 
		Random ran = new Random();

		for (int i = 0; i < iv.length; i++) {
			int ranNum1 = ran.nextInt(iv.length); // 0~15
			int ranNum2 = ran.nextInt(iv.length); // 0~15

			int temp = index[ranNum1];
			index[ranNum1] = index[ranNum2];
			index[ranNum2] = temp;

		}

		//indexBlankImg�� ��ġ ���� 
		for (int i = 0; i < iv.length; i++) {
			if(index[i] == 15 ) {
				indexBlankImg = i; //��ĭ�� �̹����� ����ִ� �� �ε���
				break;
			}

		}


		// iv�� image�� index ���� ������ ��ü�ϱ� 
		for (int i = 0; i < iv.length; i++) {
			iv[i].setImageResource(img[index[i]]); //���� ��ȣ��� �̹��� ���ġ 
		}
	}

	void setIVEnable (boolean b){
		for (int i = 0; i < iv.length; i++) {
			iv[i].setEnabled(b);
		}
	}
} // end of class
