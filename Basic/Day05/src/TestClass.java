/**
 * 클래스 class : 새로운 타입의 정리
 */
public class TestClass {
	public static void main(String[] args) {
		int a = 3;
		int num[] = new int[3];

		Cup b; // 클래스 변수의 선언
		b = new Cup();// 클래스 변수의 생성
		Cup c = new Cup();
		c.name = "머그컵";
		c.size = 200;
		System.out.println(c.name + c.size);

		// 변수 : 1개의 데이터
		// 배열 : 같은 타입의 변수 묶음
		// 구조체 : 변수, 다른 타입 변수, 배열
		// 클래스 : 구조체 + 메서드

	}// end of main
}// end of class

class Cup {// 클래스 정의 :
	String name;// 컵의 이름
	int size;// 컵의 용량
	// 매서드
}
