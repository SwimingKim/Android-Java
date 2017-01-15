package com.example.day33_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsoluteLayout;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MapActivity extends Activity{
	ImageView iv[] = new ImageView[11];
	String [] str = {"강원도", "수도권", "경상남도", "경상북도", "대전광역시","울릉도독도" , "전라남도", "전라북도", 
			"충청남도", "충청북도", "제주도"};
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);

		iv[0] = (ImageView)findViewById(R.id.ka);
		iv[1] = (ImageView)findViewById(R.id.su);
		iv[2] = (ImageView)findViewById(R.id.kn);
		iv[3] = (ImageView)findViewById(R.id.kb);
		iv[4] = (ImageView)findViewById(R.id.da);
		iv[5] = (ImageView)findViewById(R.id.wd);
		iv[6] = (ImageView)findViewById(R.id.jn);
		iv[7] = (ImageView)findViewById(R.id.jb);
		iv[8] = (ImageView)findViewById(R.id.cn);
		iv[9] = (ImageView)findViewById(R.id.cb);
		iv[10] = (ImageView)findViewById(R.id.je);
		findViewById(R.id.nor).setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "통일되면 업그레이드됩니다", 0).show();
			}
		});
		
//		iv[0].getId()
		
		AbsoluteLayout ab = (AbsoluteLayout)findViewById(R.id.AbsoluteLayout1);
		class ButtonEvent implements OnClickListener{
			public void onClick(View v) {
				ImageView im = (ImageView)v;
				Intent intent = new Intent(getApplicationContext(), RowActivity.class);
				for (int a = 0; a < iv.length; a++) {
					if (im.getId()==iv[a].getId()) {
						intent.putExtra("구분", a);
					}
				}
//				switch (im.getId()) {
//				case R.id.ka: intent.putExtra("구분", 0); break;
//				case R.id.su: intent.putExtra("구분", 1); break;
//				case R.id.kn: intent.putExtra("구분", 2); break;
//				case R.id.kb: intent.putExtra("구분", 3); break;
//				case R.id.da: intent.putExtra("구분", 4); break;
//				case R.id.wd: intent.putExtra("구분", 5); break;
//				case R.id.jn: intent.putExtra("구분", 6); break;
//				case R.id.jb: intent.putExtra("구분", 7); break;
//				case R.id.cn: intent.putExtra("구분", 8); break;
//				case R.id.cb: intent.putExtra("구분", 9); break;
//				case R.id.je: intent.putExtra("구분", 10); break;
//				default:
//					break;
//				}				
				startActivity(intent);
			}		
		}
		ButtonEvent be = new ButtonEvent();

		for (int i = 0; i < iv.length; i++) {
			iv[i].setOnClickListener(be);
		}

	}//end of onCreate
}//end of class

