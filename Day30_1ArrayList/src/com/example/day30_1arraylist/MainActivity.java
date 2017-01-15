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
		
		// 배열의 장점 : 읽기/쓰기 작업이 가장 빠르다
		// 배열의 단점 : 크기변경 불가, 중간에 삽입작업시 시간이 많이 걸린다
		
		int num[] = {2,3,4,5,6};		
		
		ArrayList al = new ArrayList();		
		al.add("호랑이");// 삽입, 인자값으로 객체만 가능하다
		al.add(new Integer(3));
		al.add(new Boolean(false));
		
		// 기본형 타입을 => 객체로 변환해주는 Wrapper클래스를 제공해준다
//				그래서 기본형 타입도 ArrayList에 저장이 가능하다		
		
		al.add(7); // 장점 : 크기를 미리 정하지 않아도 된다, 무한대로 추가할 수 있다
		//읽어오기
		System.out.println(num[1]);
		System.out.println(al.get(0));
		
		int x = num[1];
		String str = (String)al.get(2);//저장되어 있는 객체로 변환해서 사용해야 함
		
//		ArrayList al2 = new ArrayList();
//		al2.add("호랑이");
//		String str2 = (String)al2.get(0);
		//제네릭 기법을 사용하면 형변화 없이 사용가능하다
		
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("호랑이");
		String str2 = al2.get(0);
		// toString은 String 타입이 아닌 것을 String타입으로 바꾸는 것
		// String 형변환은 내부에 String있어야 가능하다.
		
		al2.size();//ArrayList의 크기
		al2.contains("호랑이"); // 호랑이가 al2에 포람되었는지 확인
		al2.set(0, "사자"); // 0번쨰 인덱스의 내용물을 사자로 교체
		al2.remove(0); // 0번째 내용을 삭제
		al2.remove("사자");// "사자" 내용을 삭제
		al2.isEmpty(); // 내용물이 비었는지 확인
		
		Car c = new Car();
		c.speed = 100;
		System.out.println(c.toString());
//		String sc = (String) c;//내부에 String타입이 없으므르 불가능하다
		
		
		
	}
}


class Car{
	int speed;
	
}