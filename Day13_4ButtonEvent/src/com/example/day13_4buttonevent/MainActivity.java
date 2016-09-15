package com.example.day13_4buttonevent;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	static EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		et = (EditText) findViewById(R.id.editText1);
		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);
		Button b4 = (Button) findViewById(R.id.button4);

		// 1.익명클래스를 이용하는 방법
		// 2.메서드 안쪽에 클래스를 선언하는 방법
		// 내부에서 사용하는 변수들을 마음껏 사용할 수 있다(장점)
		// 외부에서는 사용할 수 없다
		class MyEvent implements OnClickListener {
			public void onClick(View v) {// 클릭시 이벤트 처리
				Button b = (Button) v;
				et.append(b.getText());
			}
		}
		MyEvent me = new MyEvent();// 이벤트객체생성
		b1.setOnClickListener(me);
		b2.setOnClickListener(me);
		b3.setOnClickListener(me);
		b4.setOnClickListener(me);

	}// end of onCreate

	// 3.전역변수 영역에 클래스 선언하는 방법
	// 다른 메서드에서도 클래스를 같이 사용할 수 있다(장점)
	// 지역변수 값에 접근할 수 없다(단점)
	class MyEvent implements OnClickListener {
		public void onClick(View v) {// 클릭시 이벤트 처리
			Button b = (Button) v;
			et.append(b.getText());
		}
	}
}// end of class

// 4.외부 영역에 클래스 선언하는 법
// 내부 자원에 접근하기가 매우 어렵다(단점)
// static 만으로 접근할 수 있다
class MyEvent implements OnClickListener {
	public void onClick(View v) {// 클릭시 이벤트 처리
		Button b = (Button) v;
		MainActivity.et.append(b.getText());
	}
}

// 5.내클래스에서this로 구현하는 방법
// 6.xml로 선언하는 방법
