package com.example.day35_4compass;

import android.app.Activity;
import android.content.Context;
import android.graphics.Path.Direction;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private SensorManager sm;
	private OL ol;
	private ImageView iv;
	private TextView tv;
	private Sensor sensor_acc;
	private Sensor sensor_mag;
	float[] gravity;
	float[] geomagnetic;
	float azimut;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		sensor_acc = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		sensor_mag = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
		ol = new OL();

		iv = (ImageView)findViewById(R.id.imageView2);
		tv = (TextView)findViewById(R.id.textView1);

	}//end of onCreate

	@Override
	protected void onResume() {
		super.onResume();
		sm.registerListener(ol, sensor_acc, SensorManager.SENSOR_DELAY_NORMAL);
		//		sm.registerListener(ol, sensor_mag, SensorManager.SENSOR_DELAY_FASTEST);
	}

	@Override
	protected void onPause() {
		super.onPause();
		sm.unregisterListener(ol, sensor_acc);
		//		sm.unregisterListener(ol, sensor_mag);
	}

	class OL implements SensorEventListener {

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {

		}

		@Override
		public void onSensorChanged(SensorEvent event) {
			if (event.sensor.getType()==Sensor.TYPE_ACCELEROMETER) {
				gravity = event.values;
			}
			if (event.sensor.getType()==Sensor.TYPE_MAGNETIC_FIELD) {
				geomagnetic = event.values;
			}
			//			if (gravity!=null&&geomagnetic!=null) {
			//				float temp[] = new float[9];
			//				float R[] = new float[9];
			//				SensorManager.getRotationMatrix(temp, null, gravity, geomagnetic);
			//				SensorManager.remapCoordinateSystem(temp, SensorManager.AXIS_X,
			//						SensorManager.AXIS_MINUS_Z, R);
			//
			//				float values[] = new float[3];
			//				SensorManager.getOrientation(R, values);
			//				for (int i = 0; i < values.length; i++) {
			//					Double degress = (values[i]*180)/Math.PI;
			//					values[i] = degress.floatValue();
			//				}
			//			}
			tv.setText("X축 : "+event.values[0]);
			if (event.values!=null){
				iv.setRotation(iv.getRotation()-+event.values[0]);
			}
		}
	}
}//end of class
