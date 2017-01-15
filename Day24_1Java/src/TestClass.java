/**
 * 객체지향 - 클래스 : 새로운 타입의 정의 변수 - 배열(같은 타입 변수들의 묶음) - 구조체(변수, 배열의 묶음) - 클래스(구조체,
 * 메서드)
 */
public class TestClass {
	public static void main(String[] args) {
		// 절차지향언어 : 한줄씩 실행
		// 클래스 : 새로운 타입의 선언

		// 변수 : 기본형, 참조형

		int t = 3;
		A aa = new A();
		aa.s = false;

	}// end of main
}// end of class

class A { // 클래스의 정의
	int a;
	boolean s;
	char c[] = new char[3];

	void print() {// 메서드

	}

}