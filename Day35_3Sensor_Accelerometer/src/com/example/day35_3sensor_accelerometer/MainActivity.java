package com.example.day35_3sensor_accelerometer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private SensorManager sm;
	private Sensor sensor;
	private OL ol;
	private TextView tx;
	private TextView ty;
	private ImageView iv;
	private int h;
	private int w;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

// 핸드폰 화면의 크기를 알아오기
		WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		Display ds = wm.getDefaultDisplay();
		Point p = new Point();//2차원 좌표를 추상화한 클래스, x, y
		ds.getSize(p); // 화면의 크기를 Point 클래스에 담아준다
		h = p.x;
		w = p.y;
		
		sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		ol = new OL();

		tx = (TextView)findViewById(R.id.textView1);
		ty = (TextView)findViewById(R.id.textView2);
		iv = (ImageView)findViewById(R.id.imageView1);

	}//end of onCreate

	@Override
	protected void onResume() {
		super.onResume();
		sm.registerListener(ol, sensor, SensorManager.SENSOR_DELAY_FASTEST);
	}

	@Override
	protected void onPause() {
		super.onPause();
		sm.unregisterListener(ol, sensor);
	}

	class OL implements SensorEventListener {

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {

		}

		@Override
		public void onSensorChanged(SensorEvent event) {
			tx.setText("X축 : "+event.values[0]);
			ty.setText("Y축 : "+event.values[1]);
			
			
			float px = iv.getX()-event.values[0]; //event.values[0]*-500+400
			float py = iv.getY()+event.values[1]; //event.values[1]*100+100

// 설정하고자 하는 값이 화면범위에서 벗어나지 않는지 체크하자
			if (px<0) px = 0;// 왼쪽으로 벗어나지 못하게
			if (px>w-iv.getWidth()) px = w-iv.getWidth();// 오른쪽으로 벗어나지 못하게
		
			if (py<0) py = 0;// 위쪽으로 벗어나지 못하게
			if (py>h-iv.getHeight()*2) py = h-iv.getHeight()*2;// 아래쪽으로 벗어나지 못하게
																// 타이틀바의 영역의 높이를 고려
			
			iv.setX(px);
			iv.setY(py);
		}

	}

}//end of class
