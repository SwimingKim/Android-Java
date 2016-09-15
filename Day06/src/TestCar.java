/**
 * 생성자 Constructor : 변수의 초기화 - 메서드와 흡사하다(대문자로 시작한다) - 생성자명은 클래스의 이름과 동일하다 - 인자값이
 * 없는 생성자는 기본생성자 - 리턴타입이 없다 - 모든 작성된 클래스에는 반드시 하나 이상의 생성자가 존재해야 한다 - 우리가 생성자를
 * 하나도 작성하지 않으면,컴파일러가 기본 생성자를 추가해준다
 */
public class TestCar {
	public static void main(String[] args) {

		// Car c1 = new Car();
		// c1.name = "티코";
		// c1.color = "검정";
		// c1.speed = 80;

		Car c1 = new Car("아반떼", "흰색", 600);

		c1.speedUp();
		c1.printCar();

		Car c2 = new Car("그랜져", "검정", 200);

		Car c3 = new Car("모하비", "빨강", 150);

	}

}

class Car {
	String name;
	String color;
	int speed;

	Car() {// 기본생성자

	}

	Car(String n, String c, int s) {// 생성자
		name = n;// 생성자에서 주로 변수의 초기화 작업을 한다
		color = c;
		speed = s;
		printCar();
	}

	void speedUp() {// speed 1 증가
		speed++;
	}

	void speedDown() {// speed 1 감소
		speed--;
	}

	void printCar() {// 멤버변수 값 출력
		System.out.println("해당 차는 " + name + "이고,\n" + "색상은 " + color + "이고,\n" + "속도는 " + speed + "이다");
	}

}