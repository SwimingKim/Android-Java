/**
 * Modifiers 제어자 제어자 : 클래스, 메서드, 변수의 선언부 앞에 작성하여 부가적인 의미를 부여함 static(공통의, 클래스의),
 * final(상수의, 바꿀 수 없는) 접근제어자 : private, (default), protected, public
 */
public class TestModifiers {
	public int a;
	protected int b;
	int c;
	private int d;

	public static void main(String[] args) {
		final int x = 3;
		// x = 4; 상수의 값은 바꿀 수 없다

		// class 앞에는 public, default만 가능하다
		// public class는 자기 자바파일의 이름이 같은 클래스에만 붙일 수 있다

	}// end of main
}// end of class

class A {
	final void z() {

	} // 다른 클래스에서 메서드를 변경할 수 없다

}

class B extends A {
	// @Override//상속관계에서 부모클래스의 메서드를 자식 클래스에서 재정의하는 것
	// void z(){}

}

final class C {
}// 클래스의 내용을 변경할 수 없다
// class D extends C{}//final 클래스는 상속받을 수 없다

/*
 * private : 같은 클래스 내에서만 접근이 가능하다 
 * default : 같은 패키지 내에서만 접근이 가능하다 
 * protected : 같은 패키지 내에서, 그리고 다른 패키지의 자손 클래스에서 접근이 가능하다 
 * public : 접근제한에 전혀 없다
 * 
 * 같은 클래스 같은 패키지 자손클래스 전체 public o o o o protected o o o default o o private o
 * 
 */
