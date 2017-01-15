package com.example.rcp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {
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
	ImageView iv_com;
	ImageView iv_blue;
	ImageView iv_red;
	int win = 0;
	int lose = 0;


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		iv_com = (ImageView)findViewById(R.id.imageView1);
		user[0] = (ImageView)findViewById(R.id.imageView2);
		user[1] = (ImageView)findViewById(R.id.imageView3);
		user[2] = (ImageView)findViewById(R.id.imageView4);


		iv_blue = (ImageView)findViewById(R.id.imageView6);
		iv_red = (ImageView)findViewById(R.id.imageView7);

		final Animation animaiton = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bl);
		// 컴퓨터와 유저의 사진 설정
		iv_com.setImageResource(R.drawable.umm);
		user[0].setImageResource(R.drawable.rc);
		user[1].setImageResource(R.drawable.sc);
		user[2].setImageResource(R.drawable.pc);

		//유저 클릭시 컴퓨터의 패+결과창
		class MyEvent implements OnClickListener {
			public void onClick(View v) {
				ImageView iv = (ImageView)v;

				Random ran = new Random();
				computer = ran.nextInt(3);

				switch (computer) {//컴퓨터의 패 정하기
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

				for (int i = 0; i < user.length; i++) {//사용자의 선택 불러오기
					if(iv==user[i]) choice = i;
				}

				if (rcp) {//가위바위보중	
					if (computer==choice) {//무승부
						iv_red.setTranslationX(0);iv_red.setTranslationY(0);
						iv_blue.setTranslationX(0);iv_blue.setTranslationY(0);
					} else if (//사용자 승
							(choice==0&&computer==1
							||choice==1&&computer==2
							||choice==2&&computer==0)){
						//						iv_blue.startAnimation(animaiton);
						iv_red.setTranslationX(-200);iv_red.setTranslationY(-200);
						iv_blue.setTranslationX(0);iv_blue.setTranslationY(0);
						rcp = false;
						result=true;
					} else {//사용자 패
						rcp = false;
						result=false;
						iv_blue.setTranslationX(200);iv_blue.setTranslationY(-200);
						iv_red.setTranslationX(0);iv_red.setTranslationY(0);
					}
				} else {//묵찌빠 진행중
					if (computer==choice){//비기면 종료
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
						if (//사용자 승
								(choice==0&&computer==1
								||choice==1&&computer==2
								||choice==2&&computer==0)){
							//						iv_blue.startAnimation(animaiton);
							iv_red.setTranslationX(-200);iv_red.setTranslationY(-200);
							iv_blue.setTranslationX(0);iv_blue.setTranslationY(0);
							result=true;
						} else {//사용자 패
							result=false;
							iv_blue.setTranslationX(200);iv_blue.setTranslationY(-200);
							iv_red.setTranslationX(0);iv_red.setTranslationY(0);
						}
					}
				} 
				
				
			}
		}


		MyEvent me = new MyEvent();
		for (int i = 0; i < user.length; i++) {
			user[i].setOnClickListener(me);
		}






	}//end of onCreate

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.intro:
			showDialog(DIALOG_INTRO);
			return true;
		case R.id.rule:
			showDialog(DIALOG_RULE);
			return true;
		}
		return super.onContextItemSelected(item);
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		super.onPrepareDialog(id, dialog);
		AlertDialog d = (AlertDialog) dialog;
		switch (id) {
		case DIALOG_WIN:
			d.setMessage("와우!! 이겼어요\n"+"당신은 "+win+"승 "+lose+"패를 했습니다.");
			return;
		case DIALOG_LOOSE:
			d.setMessage("저런!! 졌어요\n"+"당신은 "+win+"승 "+lose+"패를 했습니다.");
			return;
		case DIALOG_SAVE:
			d.setMessage("당신은 "+win+"승 "+lose+"패를 했습니다.\n저장하려면 이름을 입력해주세요");
			return;
		}
	}
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DIALOG_DRAW:
			AlertDialog.Builder dialog1 = new Builder(this);
			dialog1.setTitle("무승부");
			dialog1.setMessage("어라!! 비겼어요");
			return dialog1.create();
		case DIALOG_WIN:
			AlertDialog.Builder dialog2 = new Builder(this);
			dialog2.setTitle("승리");
			dialog2.setMessage("와우!! 이겼어요\n"+"당신은 "+win+"승 "+lose+"패를 했습니다.");
			dialog2.setPositiveButton("다시하기",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					iv_com.setImageResource(R.drawable.umm);
					iv_red.setTranslationX(0);
					iv_red.setTranslationY(0);
				}
			});
			dialog2.setNegativeButton("나가기", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					finish();
				}
			});
			dialog2.setNeutralButton("저장하기", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface arg0, int arg1) {
					showDialog(DIALOG_SAVE);
				}
			});
			return dialog2.create();
		case DIALOG_LOOSE:
			AlertDialog.Builder dialog3 = new Builder(this);
			dialog3.setTitle("패배");
			dialog3.setMessage("저런!! 졌어요\n"+"당신은 "+win+"승 "+lose+"패를 했습니다.");
			dialog3.setPositiveButton("다시하기",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					iv_com.setImageResource(R.drawable.umm);
					iv_blue.setTranslationX(0);
					iv_blue.setTranslationY(0);
				}
			});
			dialog3.setNegativeButton("나가기", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					finish();
				}
			});
			dialog3.setNeutralButton("저장하기", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					showDialog(DIALOG_SAVE);					
				}
			});
			return dialog3.create();
		case DIALOG_INTRO:
			AlertDialog.Builder dialog4 = new Builder(this);
			dialog4.setTitle("소개");
			dialog4.setMessage("개발자 \n이메일 : rumex13@naver.com");
			return dialog4.create();
		case DIALOG_RULE:
			AlertDialog.Builder dialog5 = new Builder(this);
			dialog5.setTitle("규칙");
			dialog5.setMessage("가위바위보 중 하나를 선택하면 컴퓨터와 대결을 합니다\n컴퓨터와의 대결에서 승리하세요");
			return dialog5.create();
		case DIALOG_SAVE:
			LayoutInflater lif = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			final View MyView = (View)lif.inflate(R.layout.save, null);
			AlertDialog.Builder dialog6 = new Builder(this);
			dialog6.setTitle("저장하기");
			dialog6.setView(MyView);
			dialog6.setMessage("당신은 "+win+"승 "+lose+"패를 했습니다.\n저장하려면 이름을 입력해주세요");
			dialog6.setPositiveButton("예", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface arg0, int arg1) {
					EditText et = (EditText)MyView.findViewById(R.id.editText1);
					String str = et.getText().toString();	
					try {
						FileOutputStream fos = openFileOutput("game.txt", Context.MODE_APPEND);
						PrintWriter out = new PrintWriter(fos);
						out.println("계:"+str);
						out.println("승:"+win);
						out.println("패:"+lose);
						out.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					
					Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
					startActivity(intent);
					finish();
				}
			});
			dialog6.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					finish();
					
				}
			});
			return dialog6.create();
		default:
			return null;
		}
	}


}//end of class
