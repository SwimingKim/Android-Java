package com.example.day12_5edittext2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final EditText et1 = (EditText) findViewById(R.id.editText1);// 지역변수 삭제
																		// 안함
		final EditText et2 = (EditText) findViewById(R.id.editText2);
		Button b1 = (Button) findViewById(R.id.button1);
		final TextView tv1 = (TextView) findViewById(R.id.textView1);

		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String id = et1.getText().toString();
				String pw = et2.getText().toString();

				// 문자열 비교시 상수를 앞쪽에 작성하는 것이 좋다(앞쪽이 스트링이어야 오류가 안난다)
				if ("민쌤".equals(id) && "멋짐".equals(pw)) {
					tv1.setText("로그인 성공");
					et1.setText("");
					et2.setText("");
				} else {
					tv1.setText("로그인 실패");
				}
			}
		});

	}// end of onCreate
}// end of class
