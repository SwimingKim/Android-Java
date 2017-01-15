package com.example.day35_2sensor_orientation;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
	SensorManager sm;
	private Sensor sensor;
	private OriListner oriL;
	private TextView tvX;
	private TextView tvY;
	private TextView tvZ; 
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tvX = (TextView)findViewById(R.id.textView2);
		tvY = (TextView)findViewById(R.id.textView3);
		tvZ = (TextView)findViewById(R.id.textView4);

// 핸드폰의 자원은 하나 뿐이므로,
//		우리 앱이 더이상 화면에서 보이지 않을 경우, 자원을 반환해야 한다.		
		// 자원의 선언
		sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
//		sensor = sm.getDefaultSensor(Sensor.TYPE_ORIENTATION);//방향센서 : 나침반
		sensor = sm.getDefaultSensor(sensor.TYPE_ACCELEROMETER);//가속도센서
		// 리스너 객체 선언
		oriL = new OriListner();


	}//end of onCreate

	protected void onResume() {
		super.onResume();
		// 자원을 등록
//		sm.registerListener(리스너, 어떤 센서, 값을 받을 주기)
		sm.registerListener(oriL, sensor, SensorManager.SENSOR_DELAY_NORMAL);// 값을 받을 주기
		
	}//end of onResume

	protected void onPause() {
		super.onPause();
		// 자원을 반환
		sm.unregisterListener(oriL,sensor);//리스너 해제
	}
	
	class OriListner implements SensorEventListener {
		
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// 센서의 정밀도가 변경되었을 때 호출되는 콜백 메서드
			
		}
		
		@Override
		public void onSensorChanged(SensorEvent event) {
			// 센서의 값이 변경되었을 때 호출되는 콜백 메서드
			// TextView에 변경된 값을 띄우기
			
			tvX.setText("X축 : "+event.values[0]);
			tvY.setText("Y축 : "+event.values[1]);
			tvZ.setText("Z축 : "+event.values[2]);
			
		}
		
		
	}


}//end of class
