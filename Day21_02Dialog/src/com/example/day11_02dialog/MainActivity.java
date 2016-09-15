package com.example.day11_02dialog;



import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	final int DIALOG_ID_DELETE = 1;
	final int DIALOG_ID_GOTOLUNCH = 2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	TextView tv=(TextView)findViewById(R.id.textView1);
	Button b1=(Button)findViewById(R.id.button1);
	Button b2=(Button)findViewById(R.id.button2);
	b1.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			// 다이얼로그 띄우기
			showDialog(DIALOG_ID_DELETE);
			// 다이얼로그의 생명주기도 안드로이드os에서 관리한다.
		}
	});
	b2.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// 다이얼로그 띄우기
			showDialog(DIALOG_ID_GOTOLUNCH);
			
		}
	});
	}//end of onCreate
	
	protected Dialog onCreateDialog(int id){
		// 인자값 : showDialog 메서드 호출시 진단한 다이얼로그 ID 값
		switch (id) {
		case DIALOG_ID_DELETE:
			// dialog 객체를 생성한다. 현재화면의 제어권자를 this로 표시해준다
			AlertDialog.Builder dialog = new AlertDialog.Builder(this);
			dialog.setTitle("삭제").setMessage("정말로 삭제하겠습니까?")
				.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
			// 다이얼로그 버튼 이벤트 처리시 DialogInterface.onClickLister 이름을 정확히 써야함
					@Override
					public void onClick(DialogInterface dialog, int which){
					Toast.makeText(getApplicationContext(),"삭제됨.",Toast.LENGTH_SHORT).show();
					}
				
				});
			dialog.setNegativeButton("취소",null);
			return dialog.create();// 띄어줄 다이얼로그를 만들어서 리턴
		case DIALOG_ID_GOTOLUNCH:
			AlertDialog.Builder dialog2 = new AlertDialog.Builder(this);
			dialog2.setTitle("점심");
			dialog2.setMessage("점심먹을러 갈래요?");
			dialog2.setPositiveButton("예 지금 ㄱㄱ",new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(),"밥먹기",Toast.LENGTH_SHORT).show();
				}});
			dialog2.setNegativeButton("아니오 다이어트",null);
			
			return dialog2.create();//띄어줄 다이얼로그를 만들어서 리턴
		default:
			return null;//띄어줄 다이얼로그를 만들어서 리턴
		}
	}
}//end of class
