package com.example.day30_1arraylist;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// �迭�� ���� : �б�/���� �۾��� ���� ������
		// �迭�� ���� : ũ�⺯�� �Ұ�, �߰��� �����۾��� �ð��� ���� �ɸ���
		
		int num[] = {2,3,4,5,6};		
		
		ArrayList al = new ArrayList();		
		al.add("ȣ����");// ����, ���ڰ����� ��ü�� �����ϴ�
		al.add(new Integer(3));
		al.add(new Boolean(false));
		
		// �⺻�� Ÿ���� => ��ü�� ��ȯ���ִ� WrapperŬ������ �������ش�
//				�׷��� �⺻�� Ÿ�Ե� ArrayList�� ������ �����ϴ�		
		
		al.add(7); // ���� : ũ�⸦ �̸� ������ �ʾƵ� �ȴ�, ���Ѵ�� �߰��� �� �ִ�
		//�о����
		System.out.println(num[1]);
		System.out.println(al.get(0));
		
		int x = num[1];
		String str = (String)al.get(2);//����Ǿ� �ִ� ��ü�� ��ȯ�ؼ� ����ؾ� ��
		
//		ArrayList al2 = new ArrayList();
//		al2.add("ȣ����");
//		String str2 = (String)al2.get(0);
		//���׸� ����� ����ϸ� ����ȭ ���� ��밡���ϴ�
		
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("ȣ����");
		String str2 = al2.get(0);
		// toString�� String Ÿ���� �ƴ� ���� StringŸ������ �ٲٴ� ��
		// String ����ȯ�� ���ο� String�־�� �����ϴ�.
		
		al2.size();//ArrayList�� ũ��
		al2.contains("ȣ����"); // ȣ���̰� al2�� �����Ǿ����� Ȯ��
		al2.set(0, "����"); // 0���� �ε����� ���빰�� ���ڷ� ��ü
		al2.remove(0); // 0��° ������ ����
		al2.remove("����");// "����" ������ ����
		al2.isEmpty(); // ���빰�� ������� Ȯ��
		
		Car c = new Car();
		c.speed = 100;
		System.out.println(c.toString());
//		String sc = (String) c;//���ο� StringŸ���� �����Ǹ� �Ұ����ϴ�
		
		
		
	}
}


class Car{
	int speed;
	
}