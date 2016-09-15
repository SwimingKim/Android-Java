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

// �ڵ����� �ڿ��� �ϳ� ���̹Ƿ�,
//		�츮 ���� ���̻� ȭ�鿡�� ������ ���� ���, �ڿ��� ��ȯ�ؾ� �Ѵ�.		
		// �ڿ��� ����
		sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
//		sensor = sm.getDefaultSensor(Sensor.TYPE_ORIENTATION);//���⼾�� : ��ħ��
		sensor = sm.getDefaultSensor(sensor.TYPE_ACCELEROMETER);//���ӵ�����
		// ������ ��ü ����
		oriL = new OriListner();


	}//end of onCreate

	protected void onResume() {
		super.onResume();
		// �ڿ��� ���
//		sm.registerListener(������, � ����, ���� ���� �ֱ�)
		sm.registerListener(oriL, sensor, SensorManager.SENSOR_DELAY_NORMAL);// ���� ���� �ֱ�
		
	}//end of onResume

	protected void onPause() {
		super.onPause();
		// �ڿ��� ��ȯ
		sm.unregisterListener(oriL,sensor);//������ ����
	}
	
	class OriListner implements SensorEventListener {
		
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// ������ ���е��� ����Ǿ��� �� ȣ��Ǵ� �ݹ� �޼���
			
		}
		
		@Override
		public void onSensorChanged(SensorEvent event) {
			// ������ ���� ����Ǿ��� �� ȣ��Ǵ� �ݹ� �޼���
			// TextView�� ����� ���� ����
			
			tvX.setText("X�� : "+event.values[0]);
			tvY.setText("Y�� : "+event.values[1]);
			tvZ.setText("Z�� : "+event.values[2]);
			
		}
		
		
	}


}//end of class
