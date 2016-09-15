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
			// ���̾�α� ����
			showDialog(DIALOG_ID_DELETE);
			// ���̾�α��� �����ֱ⵵ �ȵ���̵�os���� �����Ѵ�.
		}
	});
	b2.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// ���̾�α� ����
			showDialog(DIALOG_ID_GOTOLUNCH);
			
		}
	});
	}//end of onCreate
	
	protected Dialog onCreateDialog(int id){
		// ���ڰ� : showDialog �޼��� ȣ��� ������ ���̾�α� ID ��
		switch (id) {
		case DIALOG_ID_DELETE:
			// dialog ��ü�� �����Ѵ�. ����ȭ���� ������ڸ� this�� ǥ�����ش�
			AlertDialog.Builder dialog = new AlertDialog.Builder(this);
			dialog.setTitle("����").setMessage("������ �����ϰڽ��ϱ�?")
				.setPositiveButton("����", new DialogInterface.OnClickListener() {
			// ���̾�α� ��ư �̺�Ʈ ó���� DialogInterface.onClickLister �̸��� ��Ȯ�� �����
					@Override
					public void onClick(DialogInterface dialog, int which){
					Toast.makeText(getApplicationContext(),"������.",Toast.LENGTH_SHORT).show();
					}
				
				});
			dialog.setNegativeButton("���",null);
			return dialog.create();// ����� ���̾�α׸� ���� ����
		case DIALOG_ID_GOTOLUNCH:
			AlertDialog.Builder dialog2 = new AlertDialog.Builder(this);
			dialog2.setTitle("����");
			dialog2.setMessage("���ɸ����� ������?");
			dialog2.setPositiveButton("�� ���� ����",new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(),"��Ա�",Toast.LENGTH_SHORT).show();
				}});
			dialog2.setNegativeButton("�ƴϿ� ���̾�Ʈ",null);
			
			return dialog2.create();//����� ���̾�α׸� ���� ����
		default:
			return null;//����� ���̾�α׸� ���� ����
		}
	}
}//end of class
