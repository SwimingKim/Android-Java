package com.su.map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class RowActivity extends Activity{
	String [] str = {"������", "������", "��󳲵�", "���ϵ�", "����������","�︪������" , "���󳲵�", "����ϵ�", 
			"��û����", "��û�ϵ�", "���ֵ�"};
	List[] st = { new List("������", "�ȸ��غ�", 4, "ka.txt", R.drawable.kaim,37.7731182,128.9429963),
			new List("������", "�ϻ� ȣ������", 4.5f, "su.txt", R.drawable.suim,37.6584131,126.7620336),
			new List("��󳲵�", "�뿵 �ҸŹ���", 5, "kn.txt", R.drawable.knim,34.6222575,128.5459788),
			new List("���ϵ�", "���� �Ⱦ���", 4.5f, "kb.txt", R.drawable.kbim,35.8347202,129.2247643),
			new List("����������", "�뵿�ϴð���", 3, "da.txt", R.drawable.daim,36.3325029,127.4492084),
			new List("�︪������", "����", 4, "wd.txt", R.drawable.wdim,37.2419723,131.862681),
			new List("���󳲵�", "��� �׳��", 4.5f, "jn.txt", R.drawable.jnim,35.3258532,126.9841248),
			new List("����ϵ�", "���� �ѿ�����", 4, "jb.txt", R.drawable.jbim,35.8153767,127.1059535),
			new List("��û����", "���� ��õ�ؼ�����", 3.5f, "cn.txt", R.drawable.cnim,36.3056132,126.5072723),
			new List("��û�ϵ�", "�ܾ� ������", 3, "cb.txt", R.drawable.cbim,36.9999664,128.3417429),
			new List("���ֵ�", "�Ѷ��", 4, "je.txt", R.drawable.jeim,33.3616837,126.5203904)};
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.row);

		TextView tv_name = (TextView)findViewById(R.id.name);
		TextView tv_division = (TextView)findViewById(R.id.split);
		RatingBar rate = (RatingBar)findViewById(R.id.ratingBar1);
		TextView intro = (TextView)findViewById(R.id.intro);
		ImageView iv = (ImageView)findViewById(R.id.imageView1);

		Intent intent = getIntent();
		final int num = intent.getIntExtra("����", 0);
		tv_name.setText(st[intent.getIntExtra("����", 0)].name);
		tv_division.append(" : "+st[intent.getIntExtra("����", 0)].division);
		rate.setRating(st[intent.getIntExtra("����", 0)].point);
		//		intro.setText(st[intent.getIntExtra("����", 0)].intro);
		File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
				st[intent.getIntExtra("����", 0)].intro);
		String result = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while (true) {
				String str = br.readLine();
				if (str==null) break;
				result += str ;
			}			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		intro.setText(result);

		iv.setImageResource(st[intent.getIntExtra("����", 0)].image);
		iv.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),UpActivity.class);
				intent.putExtra("�׸�", st[num].image);
				startActivity(intent);
			}
		});
		
		tv_name.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),GoogleMap.class);
				intent.putExtra("up", st[num].up);
				intent.putExtra("down", st[num].down);
				startActivity(intent);
			}
		});

	}//end of onCreate
}//end of class

class List{
	String name;
	String division;
	float point;
	String intro;
	int image;
	double up;
	double down;
	public List(String name, String division, float point, String intro, int image, double up, double down) {
		super();
		this.name = name;
		this.division = division;
		this.point = point;
		this.intro = intro;
		this.image = image;
		this.up = up;
		this.down = down;
	}



}
