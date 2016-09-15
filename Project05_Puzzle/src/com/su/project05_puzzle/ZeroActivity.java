package com.su.project05_puzzle;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

public class ZeroActivity extends Activity{
	private TextView tvMoveCount;
	private Chronometer chro;
	private ImageView iv_com;
	private ImageView iv_blue;
	private ImageView iv_red;
	ImageView user[] = new ImageView[3];
	int choice;
	int computer;
	final int DIALOG_DRAW = 0;
	final int DIALOG_WIN = 1;
	final int DIALOG_LOOSE = 2;
	final int DIALOG_INTRO = 3;
	final int DIALOG_RULE = 4;
	final int DIALOG_SAVE = 5;
	boolean rcp = true ;
	boolean result;
	int win = 0;
	int lose = 0;
	private TextView tv_uc;
	private TextView tv_up;
	private TextView tv_cc;
	private TextView tv_cp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zero);

		tvMoveCount = (TextView)findViewById(R.id.tv);

		Button b1 = (Button)findViewById(R.id.button1);
		Button b2 = (Button)findViewById(R.id.button2);
		Button b3 = (Button)findViewById(R.id.button3);
		chro = (Chronometer)findViewById(R.id.chronometer1);
		chro.setBase(SystemClock.elapsedRealtime()); // �ð��ʱ�ȭ 
		chro.start(); // �ð� ���� 

		tv_uc = (TextView)findViewById(R.id.uc);
		tv_up = (TextView)findViewById(R.id.up);
		tv_cc = (TextView)findViewById(R.id.cc);
		tv_cp = (TextView)findViewById(R.id.cp);

		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				win = 0;
				lose = 0;
				tv_uc.setText(lose+"");
				tv_cc.setText(win+"");
				iv_red.setTranslationX(0);iv_red.setTranslationY(0);
				iv_blue.setTranslationX(0);iv_blue.setTranslationY(0);
				rcp = true;

			}
		});
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				iv_red.setTranslationX(0);iv_red.setTranslationY(0);
				iv_blue.setTranslationX(0);iv_blue.setTranslationY(0);
				rcp = true;
			}
		});
		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(intent);
				finish();
			}
		});


		iv_com = (ImageView)findViewById(R.id.imageView1);
		user[0] = (ImageView)findViewById(R.id.imageView2);
		user[1] = (ImageView)findViewById(R.id.imageView3);
		user[2] = (ImageView)findViewById(R.id.imageView4);


		iv_blue = (ImageView)findViewById(R.id.imageView6);
		iv_red = (ImageView)findViewById(R.id.imageView7);

		//		final Animation animaiton = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bl);
		// ��ǻ�Ϳ� ������ ���� ����
		iv_com.setImageResource(R.drawable.umm);
		user[0].setImageResource(R.drawable.rc);
		user[1].setImageResource(R.drawable.sc);
		user[2].setImageResource(R.drawable.pc);

		//���� Ŭ���� ��ǻ���� ��+���â
		class MyEvent implements OnClickListener {
			int num;
			public void onClick(View v) {
				ImageView iv = (ImageView)v;

				num++;
				Random ran = new Random();
				computer = ran.nextInt(3);

				switch (computer) {//��ǻ���� �� ���ϱ�
				case 0:
					iv_com.setImageResource(R.drawable.rc);
					break;
				case 1:
					iv_com.setImageResource(R.drawable.sc);
					break;
				case 2:
					iv_com.setImageResource(R.drawable.pc);
					break;
				default:
					break;
				}	

				for (int i = 0; i < user.length; i++) {//������� ���� �ҷ�����
					if(iv==user[i]) choice = i;
				}

				if (rcp) {//������������	
					if (computer==choice) {//���º�
						iv_red.setTranslationX(0);iv_red.setTranslationY(0);
						iv_blue.setTranslationX(0);iv_blue.setTranslationY(0);
					} else if (//����� ��
							(choice==0&&computer==1
							||choice==1&&computer==2
							||choice==2&&computer==0)){
						//						iv_blue.startAnimation(animaiton);
						iv_red.setTranslationX(-200);iv_red.setTranslationY(-200);
						iv_blue.setTranslationX(0);iv_blue.setTranslationY(0);
						rcp = false;
						result=true;
					} else {//����� ��
						rcp = false;
						result=false;
						iv_blue.setTranslationX(200);iv_blue.setTranslationY(-200);
						iv_red.setTranslationX(0);iv_red.setTranslationY(0);
					}
				} else {//����� ������
					if (computer==choice){//���� ����
						if (result) {
							iv_red.setTranslationX(-400);iv_red.setTranslationY(-250);
							win++;
							showDialog(DIALOG_WIN);
							rcp = true;
						} else {
							iv_blue.setTranslationX(400);iv_blue.setTranslationY(-250);
							lose++;
							showDialog(DIALOG_LOOSE);
							rcp = true;
						}
					} else {
						if (//����� ��
								(choice==0&&computer==1
								||choice==1&&computer==2
								||choice==2&&computer==0)){
							//						iv_blue.startAnimation(animaiton);
							iv_red.setTranslationX(-200);iv_red.setTranslationY(-200);
							iv_blue.setTranslationX(0);iv_blue.setTranslationY(0);
							result=true;
						} else {//����� ��
							result=false;
							iv_blue.setTranslationX(200);iv_blue.setTranslationY(-200);
							iv_red.setTranslationX(0);iv_red.setTranslationY(0);
						}
					}
				} 
				tv_uc.setText(lose+"");
				tv_cc.setText(win+"");
				tvMoveCount.setText("Ŭ�� Ƚ�� : "+num);


			}
		}


		MyEvent me = new MyEvent();
		for (int i = 0; i < user.length; i++) {
			user[i].setOnClickListener(me);
		}








	}//end of onCreate
}//end of class
