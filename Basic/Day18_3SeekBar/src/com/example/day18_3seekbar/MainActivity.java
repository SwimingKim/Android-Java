package com.example.day18_3seekbar;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button b = (Button) findViewById(R.id.button1);
		final EditText et = (EditText) findViewById(R.id.editText1);
		final SeekBar sb = (SeekBar) findViewById(R.id.seekBar1);

		sb.setMax(200);

		sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			public void onStopTrackingTouch(SeekBar arg0) {
				Log.d("seekbar", "onStopTrackingTouch");
			}

			public void onStartTrackingTouch(SeekBar arg0) {
				Log.d("seekbar", "onStartTrackingTouch");
			}

			public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {
				Log.d("seekbar", "onProgressChanged" + progress);
			}
		});

		b.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				sb.setProgress(Integer.valueOf(et.getText().toString()));
			}
		});

	}// end of onCreate
}// end of class
