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
		// ��ǻ�Ϳ� ������ ���� ����
		iv_com.setImageResource(R.drawable.umm);
		user[0].setImageResource(R.drawable.rc);
		user[1].setImageResource(R.drawable.sc);
		user[2].setImageResource(R.drawable.pc);

		//���� Ŭ���� ��ǻ���� ��+���â
		class MyEvent implements OnClickListener {
			public void onClick(View v) {
				ImageView iv = (ImageView)v;

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
			d.setMessage("�Ϳ�!! �̰���\n"+"����� "+win+"�� "+lose+"�и� �߽��ϴ�.");
			return;
		case DIALOG_LOOSE:
			d.setMessage("����!! �����\n"+"����� "+win+"�� "+lose+"�и� �߽��ϴ�.");
			return;
		case DIALOG_SAVE:
			d.setMessage("����� "+win+"�� "+lose+"�и� �߽��ϴ�.\n�����Ϸ��� �̸��� �Է����ּ���");
			return;
		}
	}
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DIALOG_DRAW:
			AlertDialog.Builder dialog1 = new Builder(this);
			dialog1.setTitle("���º�");
			dialog1.setMessage("���!! �����");
			return dialog1.create();
		case DIALOG_WIN:
			AlertDialog.Builder dialog2 = new Builder(this);
			dialog2.setTitle("�¸�");
			dialog2.setMessage("�Ϳ�!! �̰���\n"+"����� "+win+"�� "+lose+"�и� �߽��ϴ�.");
			dialog2.setPositiveButton("�ٽ��ϱ�",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					iv_com.setImageResource(R.drawable.umm);
					iv_red.setTranslationX(0);
					iv_red.setTranslationY(0);
				}
			});
			dialog2.setNegativeButton("������", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					finish();
				}
			});
			dialog2.setNeutralButton("�����ϱ�", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface arg0, int arg1) {
					showDialog(DIALOG_SAVE);
				}
			});
			return dialog2.create();
		case DIALOG_LOOSE:
			AlertDialog.Builder dialog3 = new Builder(this);
			dialog3.setTitle("�й�");
			dialog3.setMessage("����!! �����\n"+"����� "+win+"�� "+lose+"�и� �߽��ϴ�.");
			dialog3.setPositiveButton("�ٽ��ϱ�",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					iv_com.setImageResource(R.drawable.umm);
					iv_blue.setTranslationX(0);
					iv_blue.setTranslationY(0);
				}
			});
			dialog3.setNegativeButton("������", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					finish();
				}
			});
			dialog3.setNeutralButton("�����ϱ�", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					showDialog(DIALOG_SAVE);					
				}
			});
			return dialog3.create();
		case DIALOG_INTRO:
			AlertDialog.Builder dialog4 = new Builder(this);
			dialog4.setTitle("�Ұ�");
			dialog4.setMessage("������ \n�̸��� : rumex13@naver.com");
			return dialog4.create();
		case DIALOG_RULE:
			AlertDialog.Builder dialog5 = new Builder(this);
			dialog5.setTitle("��Ģ");
			dialog5.setMessage("���������� �� �ϳ��� �����ϸ� ��ǻ�Ϳ� ����� �մϴ�\n��ǻ�Ϳ��� ��ῡ�� �¸��ϼ���");
			return dialog5.create();
		case DIALOG_SAVE:
			LayoutInflater lif = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			final View MyView = (View)lif.inflate(R.layout.save, null);
			AlertDialog.Builder dialog6 = new Builder(this);
			dialog6.setTitle("�����ϱ�");
			dialog6.setView(MyView);
			dialog6.setMessage("����� "+win+"�� "+lose+"�и� �߽��ϴ�.\n�����Ϸ��� �̸��� �Է����ּ���");
			dialog6.setPositiveButton("��", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface arg0, int arg1) {
					EditText et = (EditText)MyView.findViewById(R.id.editText1);
					String str = et.getText().toString();	
					try {
						FileOutputStream fos = openFileOutput("game.txt", Context.MODE_APPEND);
						PrintWriter out = new PrintWriter(fos);
						out.println("��:"+str);
						out.println("��:"+win);
						out.println("��:"+lose);
						out.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					
					Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
					startActivity(intent);
					finish();
				}
			});
			dialog6.setNegativeButton("�ƴϿ�", new DialogInterface.OnClickListener() {
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
