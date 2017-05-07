/**
 * 변수 스코프 : 변수 선언 위치에 따른 차이
 */
public class TestVariableScope {
	public static void main(String[] args) {
		AAA aaa1 = new AAA();
		aaa1.cc = 1;
		AAA.www = 10;

		System.out.println(aaa1.cc + "," + aaa1.www);// 1,10

		AAA aaa2 = new AAA();
		aaa2.cc = 2;
		aaa2.www = 20;
		aaa2.www = 100;
		System.out.println(aaa2.cc + "," + aaa2.www);// 2,100
		System.out.println(aaa1.cc + "," + aaa1.www);// 1,100

	}// end of main
}// end of class

class AAA {// 클래스 영역 = 클래스 전체 - 메서드 영역
	static int www;
	// 전역변수, 글로벌변수, 멤버변수, 클래스변수, static 변수, 공유변수
	// 클래스의 이름이 처음 언급될 때 메모리에 만들어진다
	// 프로그램이 종료될 때 없어진다
	// 참조변수.변수명 or 클래스명.변수명

	int cc;
	// 클래스 영역에 선언한 변수 = 전역변수, 글로벌 변수, 멤버변수, 인스턴스변수, non static 변수
	// 객체(인스턴스)가 생성시 메모리에 만들어진다
	// 객체의 참조변수가 없어지면 메모리에서 지워진다

	void x() {
		// a=3;
		int a;// 메서드 영역에 선언한 변수 = 지역변수, 로컬변수
		// 변수를 선언한 실행문이 실행된 시점에 메모리에 만들어진다.
		// 메서드를 빠져나가면 메모리에서 없어진다
		a = 3;
	}

	void print() {// 메서드

	}

}