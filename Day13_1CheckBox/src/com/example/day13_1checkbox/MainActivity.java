package com.example.day13_1checkbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
		final CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
		final CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
		final CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
		Button bt = (Button) findViewById(R.id.button1);

		bt.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String str = "";
				if (cb1.isChecked())
					str += cb1.getText() + ", ";
				if (cb2.isChecked())
					str += cb2.getText() + ", ";
				if (cb3.isChecked())
					str += cb3.getText() + ", ";
				if (cb4.isChecked())
					str += cb4.getText() + ", ";

				Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();

				// if (cb1.isChecked()) {
				// Toast.makeText(getApplicationContext(),
				// cb1.getText().toString(), Toast.LENGTH_SHORT).show();
				// } else if (cb2.isChecked()) {
				// Toast.makeText(getApplicationContext(),
				// cb2.getText().toString(), Toast.LENGTH_SHORT).show();
				// } else if (cb3.isChecked()) {
				// Toast.makeText(getApplicationContext(),
				// cb3.getText().toString(), Toast.LENGTH_SHORT).show();
				// } else if (cb4.isChecked()) {
				// Toast.makeText(getApplicationContext(),
				// cb4.getText().toString(), Toast.LENGTH_SHORT).show();
				// } else {
				// Toast.makeText(getApplicationContext(), "선택해야죠",
				// Toast.LENGTH_LONG).show();
				// }
			}
		});

	}// end of onCreate
}// end of class
