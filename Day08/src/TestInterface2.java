/**
 * 자바의 클래스는 단일상속만을 허용한다(애매모호한 에러를 방지하기 위해서 다중상속의 장점을 포기함) 인터페이스를 구현하는데, 여러개의
 * 인터페이스를 구현할 수 있다
 */
public class TestInterface2 {
	public static void main(String[] args) {

	}// end of main
}// end of class

interface Movable {// ~able로 끝나는 이름으로 명명한다
	void move();
}

interface Attackable {
	void attack();// public static / abstract생략

}

class BBB {
}

class Fight extends BBB implements Movable, Attackable {
	@Override
	public void attack() {

	}

	@Override
	public void move() {

	}
}