/**
 * 오버로딩 : 같은 클래스안에서 메서드의 인자값이 개수 or순서 or타입이 다르면 동일한 메서드명을 사용할 수 있도록 허용하는 기법
 * 오버라이딩 : 상속관계의 클래스에서 부모 클래스의 메서드를 자식클래스에서 재정의하는 것
 */
public class TestClass3 {
	public static void main(String[] args) {
		// 오버로딩 : 한 클래스 동일한 메서드명 (인자값의 개수, 순서, 타입 변경)
		// 오버라이딩 : 상속 메서드 재정의

		new Child().ppp();

	}// end of main
}// end of class

class MyClass { // 오버로딩 : 동일한 이름으로 메서드명을 작성하는 것,
	// 인자값의 개수, 타입, 순서를 다르게 해야 한다
	void bb() {
	}

	void bb(int a) {
	}

	void bb(boolean a) {
	}

	void bb(boolean a, int z) {
	}

	void bb(int z, boolean a) {
	}

}

class Parent {
	void ppp() {
		System.out.println("나는 ppp입니다");
	}

}

class Child extends Parent {

	void ppp() { // 오버라이딩 : 부모클래스의 메서드를 재정의하는 것
		System.out.println("나는 자식의 피피피입니다");
	}

}