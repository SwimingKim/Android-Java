/**
 * super : 부모 클래스의 객체를 가리키는 참조변수
 */
public class TestSuper {
	public static void main(String[] args) {
		Child c = new Child();
		c.ccc();
	}// end of main
}// end of class

class Parent {
	int g = 100;// 전역변수

	void ddd() {
		int g = 2000;
	}// 지역변수
}

class Child extends Parent {
	int g = 30;// 전역변수

	void ccc() {
		int g = 4;
		System.out.println(g);// 4
		System.out.println(this.g);// 30, this 내클래스의 전역변수 이상
		System.out.println(super.g);// 100, super 부모클래스의 전역변수이상
		super.ddd();// 부모클래스의 멤버(변수,메서드)에 접근시 super 사용

	}// 지역변수
}