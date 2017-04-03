/**
 * 추상클래스 - 미완성클래스 추상메서드를 가질 수 있는 클래스
 */
public class TestAbstract {
	// abstract void ppp();일반클래스에는 추상클래스가 있을 수 없다
	void print() {// 일반메서드
		SmartTv s = new SmartTv();
		CaptionTv c = new CaptionTv();
		// TV t = new TV();//추상클래스로 객체를 생성할 수 없다
		c.powerOnOff();
	}

	public static void main(String[] args) {
	}// end of main
}// end of class

class SmartTv extends TV {// 추상클래스를 상속받아서 객체 생성하려면 : 추상메서드의 바디 작성
	void powerOnOff() {
	}
}

class CaptionTv extends TV {
	void powerOnOff() {
	}
}

abstract class TV {
	abstract void powerOnOff();// 선언부만 작성하고, 내용은 자식 클래스에서 구현한다
}

abstract class H {// 추상클래스 : 추상메서드, 일반메서드를 가질 수 있다
	abstract void print();// 추상메서드 - 바디(몸통)을 구현하지 않는다

	abstract void ppp();

	void abe() {// 일반메서드

	}

}