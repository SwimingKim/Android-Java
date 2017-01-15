package com.example.day14_92gohome;

import android.app.Activity;
import android.graphics.Rect;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private float saveX;
	private float saveY;
	private float moveX;
	private float moveY;
	private float difX;
	private float difY;
	Rect rect_iv;
	Rect rect_ic;
	float iv_x;
	float iv_y;
	private float ic_x;
	private float ic_y;
	private ImageView iv;
	private ImageView ic;	
	Handler handler = new Handler();
	Runnable r = new Runnable() {
		public void run() {
			if (rect_iv.intersects(390,410,390+300,410+300)) {
				Toast.makeText(getApplicationContext(), "접근", 0).show();
			}
//			if {
//				Toast.makeText(getApplicationContext(), "정상", 0).show();
//				
//			}
			handler.post(r);
		}
	};
	public void onWindowFocusChanged(boolean hasFocus) {

		Log.i("check ivx", iv.getX()+"");
		Log.i("check ivy", iv.getY()+"");
		Log.i("check icx", ic.getX()+"");
		Log.i("check icy", ic.getY()+"");
		Log.i("check ivw", iv.getWidth()+"");
		Log.i("check ivh", iv.getHeight()+"");
		Log.i("check icw", ic.getWidth()+"");
		Log.i("check ich", ic.getHeight()+"");
		
	};


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);
		Button b4 = (Button) findViewById(R.id.button4);
		Button b5 = (Button) findViewById(R.id.button5);
		Button b6 = (Button) findViewById(R.id.button6);
		iv = (ImageView) findViewById(R.id.imageView1);
		ic = (ImageView) findViewById(R.id.imageView2);
		
		handler.post(r);
		
		iv.measure(MeasureSpec.UNSPECIFIED,MeasureSpec.UNSPECIFIED);
		ic.measure(MeasureSpec.UNSPECIFIED,MeasureSpec.UNSPECIFIED);
		
	
		rect_iv = new Rect(390,710,390+300,710+300);
		rect_ic = new Rect(390,410,390+300,410+300);
//		Log.i("check","iv:"+rect_iv.bottom+","+rect_iv.top+","
//				+ rect_iv.left+","+rect_iv.right);
//		Log.d("check","iv:"+iv.getWidth()+","+location_iv[1]+","
//				+ (int)(location_iv[0]+iv.getMeasuredWidth())+","+(int)(location_iv[1]+iv.getMeasuredHeight()));
//		Log.d("check","ic:"+(int)ic.getX()+","+(int)ic.getY()+","
//				+(int)(ic.getX()+ic.getMeasuredWidth())+","+(int)(ic.getY()+ic.getMeasuredHeight()));

		b1.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				iv.setX(iv.getX() - 20);
				rect_iv.bottom=-20;
				rect_iv.right=-20;
				return false;
			}
		});
		b2.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				iv.setX(iv.getX() + 20);
				rect_iv.bottom=+20;
				rect_iv.right=+20;
				return false;
			}
		});
		b3.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				iv.setY(iv.getY() - 20);
				rect_iv.top=-20;
				rect_iv.bottom=-20;
				return false;
			}
		});
		b4.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				iv.setY(iv.getY() + 20);
				rect_iv.top=+20;
				rect_iv.bottom=+20;
				return false;
			}
		});
		b5.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				iv.setRotation(iv.getRotation() + 20);
				return false;
			}
		});
		b6.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				iv.setRotation(iv.getRotation() - 20);
				return false;
			}
		});
		
		iv.setOnTouchListener(new OnTouchListener() {

			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction()==MotionEvent.ACTION_DOWN) {
					saveX = event.getX();
					saveY = event.getY();
					iv.setX(saveX);
					iv.setY(saveY);
				} else if (event.getAction()==MotionEvent.ACTION_UP) {
					iv.setX(iv.getX());
					iv.setY(iv.getY());
				} else if (event.getAction()==MotionEvent.ACTION_MOVE) {
					moveX = event.getX();
					moveY = event.getY();
					difX = saveX-moveX;
					difY = saveY-moveY;
					iv.setX(iv.getX()-difX);
					iv.setY(iv.getY()-difY);
				} 
				return true;
			}
		});

	}// end of onCreate
	void toViewRawXY (View view){
		View parentView = view.getRootView();
		int sumX =0;
		int sumY =0;
		
		boolean chk = false;
		while (!chk) {
			sumX = sumX+view.getLeft();
			sumY = sumX+view.getTop();
			
			view = (View)view.getParent();
			if (parentView==view) {
				chk=true;
			}
		}
	}
}// end of class
