package com.example.day42_3puzzle;

import java.util.Arrays;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ImageView iv[][] = new ImageView[4][4];
	int seo[] = {R.drawable.seo_01, R.drawable.seo_02,R.drawable.seo_03,R.drawable.seo_04,
			R.drawable.seo_05,R.drawable.seo_06,R.drawable.seo_07,R.drawable.seo_08,
			R.drawable.seo_09,R.drawable.seo_10,R.drawable.seo_11,R.drawable.seo_12,
			R.drawable.seo_13,R.drawable.seo_14,R.drawable.seo_15,R.drawable.bin,};
	private Random ran;

	Animation animationToLeft;
	Animation animationToRight;
	Animation animationToUp;
	Animation animationToDown;
	int dapI, dapJ; // 빈그림이 있는 답의 행과 열
	int position[] = new int[16];
	private TextView tv;
	Handler handler = new Handler();
	Runnable r = new Runnable() {
		public void run() {
			int count = 0;
			for (int i = 0; i < position.length; i++) {
				if (position[i] == i) {
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
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		iv[0][0] = (ImageView)findViewById(R.id.imageView1);
		iv[0][1] = (ImageView)findViewById(R.id.imageView2);
		iv[0][2] = (ImageView)findViewById(R.id.imageView3);
		iv[0][3] = (ImageView)findViewById(R.id.imageView4);
		iv[1][0] = (ImageView)findViewById(R.id.imageView5);
		iv[1][1] = (ImageView)findViewById(R.id.imageView6);
		iv[1][2] = (ImageView)findViewById(R.id.imageView7);
		iv[1][3] = (ImageView)findViewById(R.id.imageView8);
		iv[2][0] = (ImageView)findViewById(R.id.imageView9);
		iv[2][1] = (ImageView)findViewById(R.id.imageView10);
		iv[2][2] = (ImageView)findViewById(R.id.imageView11);
		iv[2][3] = (ImageView)findViewById(R.id.imageView12);
		iv[3][0] = (ImageView)findViewById(R.id.imageView13);
		iv[3][1] = (ImageView)findViewById(R.id.imageView14);
		iv[3][2] = (ImageView)findViewById(R.id.imageView15);
		iv[3][3] = (ImageView)findViewById(R.id.imageView16);

		tv = (TextView)findViewById(R.id.textView1);

		MyEvent me = new MyEvent();

		// 사진 넣기&버튼이벤트
		for (int i = 0; i < iv.length; i++) {
			for (int j = 0; j < iv[i].length; j++) {				
				iv[i][j].setImageResource(seo[i*4+j+0]);
				if (seo[i*4+j]==R.drawable.bin) {
					dapI = i;
					dapJ = j;	
				}
				iv[i][j].setOnClickListener(me);	
			}
		}
		for (int i = 0; i < seo.length; i++) {
			position[i] = i;
		}
		tv.setText(Arrays.toString(position)+"");
		tv.append("\n"+dapI+","+dapJ);

		handler.post(r);

		// 셔플 이벤트
		ran = new Random();
		Button b = (Button)findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 위치 순서 섞음
				for (int i = 0; i < seo.length; i++) {
					int n1 = ran.nextInt(seo.length);
					int n2 = ran.nextInt(seo.length);

					int temp = position[n1];
					position[n1] = position[n2];
					position[n2] = temp;	
				}
				// 이미지뷰 다시 정렬
				Arrange();
				tv.setText(Arrays.toString(position)+"");
				tv.append("\n"+dapI+","+dapJ);
			}
		});

		Button bRenew = (Button)findViewById(R.id.button2);
		bRenew.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				for (int i = 0; i < position.length; i++) {
					position[i] = i;
				}
				Arrange();
				tv.setText(Arrays.toString(position)+"");
				tv.append("\n"+dapI+","+dapJ);
			}
		});

		Button bShow = (Button)findViewById(R.id.button3);
		bShow.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog(0);		
			}
		});


		animationToLeft = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.toright);
		animationToRight = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.toleft);
		animationToUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.toup);
		animationToDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.todown);




	}//end of onCreate

	protected Dialog onCreateDialog(int id) {
		if (id==0) {
			AlertDialog.Builder dialog = new Builder(this);
			LayoutInflater lif = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View myview = lif.inflate(R.layout.show, null);
			dialog.setView(myview);
			dialog.setTitle("사진보기");
			ImageView dap = (ImageView)myview.findViewById(R.id.imageView1);
			dap.setImageResource(R.drawable.frame);
			return dialog.create();
		}
		return super.onCreateDialog(id);
	}

	protected void onDestroy() {
		super.onDestroy();
		handler.removeCallbacks(r);
	}

	class MyEvent implements OnClickListener{

		public void onClick(View v) {
			ImageView img = (ImageView)v;
			int i = 0, j = 0;
			img = iv[i][j];

			if (img == iv[dapI][dapJ]) {
				Toast.makeText(getApplicationContext(), "땡", 0).show();
			}

			if (i!=dapI&&i == dapI+1) {//아래에 있는 경우
				int temp = position[dapI*4+dapJ];
				position[dapI*4+dapJ] = position[(dapI+1)*4+dapJ];
				position[(dapI+1)*4+dapJ] = temp;	
				iv[i][dapJ].startAnimation(animationToUp);
				handler.postDelayed(r_change, 200);
				tv.setText(Arrays.toString(position)+"");
				tv.append("\n"+dapI+","+dapJ);
			}
			if (i!=dapI&&i == dapI-1) {//위에 있는 경우
				int temp = position[dapI*4+dapJ];
				position[dapI*4+dapJ] = position[(dapI-1)*4+dapJ];
				position[(dapI-1)*4+dapJ] = temp;	
				iv[i][dapJ].startAnimation(animationToDown);
				handler.postDelayed(r_change, 200);
				tv.setText(Arrays.toString(position)+"");
				tv.append("\n"+dapI+","+dapJ);
			} 

			if (j!=dapJ&&j == dapJ+1) {//오른쪽에 있는 경우
				int temp = position[dapI*4+dapJ];
				position[dapI*4+dapJ] = position[dapI*4+dapJ+1];
				position[dapI*4+dapJ+1] = temp;	
				iv[dapI][j].startAnimation(animationToLeft);
				handler.postDelayed(r_change, 200);
				tv.setText(Arrays.toString(position)+"");
				tv.append("\n"+dapI+","+dapJ);
			}

			if (j!=dapJ&&j == dapJ-1) {//왼쪽에 있는 경우
				int temp = position[dapI*4+dapJ];
				position[dapI*4+dapJ] = position[dapI*4+dapJ-1];
				position[dapI*4+dapJ-1] = temp;	
				iv[dapI][j].startAnimation(animationToRight);
				handler.postDelayed(r_change, 200);
				tv.setText(Arrays.toString(position)+"");
				tv.append("\n"+dapI+","+dapJ);
			} 


		}
	}
	void Arrange() {
		for (int i = 0; i < iv.length; i++) {
			for (int j = 0; j < iv[i].length; j++) {
				iv[i][j].setImageResource(seo[position[i*4+j]]);
				if (seo[position[i*4+j]]== R.drawable.bin) {
					dapI = i;
					dapJ = j;							
				}
			}
		}
	}


}//end of class
