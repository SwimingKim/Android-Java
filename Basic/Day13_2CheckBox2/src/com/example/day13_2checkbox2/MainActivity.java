package com.example.day13_2checkbox2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	boolean dap1[] = { true, false, true, false };
	boolean dap2[] = { false, true, true, false };
	boolean dap[] = dap1;// 현재 문제의 답

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final TextView tv = (TextView) findViewById(R.id.textView1);
		final CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
		final CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
		final CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
		final CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
		final Button b1 = (Button) findViewById(R.id.button1);
		final Button b2 = (Button) findViewById(R.id.button2);

		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String str = "땡! 틀렸음";
				if (cb1.isChecked() == dap[0] && cb2.isChecked() == dap[1] && cb3.isChecked() == dap[2]
						&& cb4.isChecked() == dap[3])
					str = "딩동댕~! 맞았음";
				Toast.makeText(getApplicationContext(), str, 1).show();
			}
		});

		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				cb1.setChecked(false);
				cb2.setChecked(false);
				cb3.setChecked(false);
				cb4.setChecked(false);
				String ss = b2.getText().toString();
				if ("다음문제".equals(ss)) {// 2번문제로
					tv.setText("문제2 점심메뉴를 모두 고르시오");
					cb1.setText("기식");
					cb2.setText("순두부");
					cb3.setText("중앙돼지마을");
					cb4.setText("학식");
					b2.setText("이전문제");
					dap = dap2;
				} else if ("이전문제".equals(ss)) {// 1번문제로
					tv.setText("문제1 좋아하는 영화를 모두 고르시오");
					cb1.setText("주토피아");
					cb2.setText("곡성");
					cb3.setText("엽기적인그녀");
					cb4.setText("엽기적인그녀2");
					b2.setText("다음문제");
					dap = dap1;
				}
			}
		});

	}// end of onCreate
}// end of class
