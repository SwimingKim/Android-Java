/**
 * 클래스 활용
 */
public class TestMart {
	public static void main(String[] args) {
		Mart m1 = new Mart();
		m1.name = "홈플러스";
		m1.ball = 10000;
		m1.pen = 3000;

		m1.printPrice();

		System.out.println("\n세일 후의 가격");
		m1.sale();

		m1.printPrice();

		Mart m2 = new Mart();
		m2.name = "이마트";
		m2.ball = 9000;
		m2.pen = 2500;

		System.out.println("");
		m2.printPrice();

		m2.sale();

	}// end of main
}// end of class

class Mart {
	String name;
	int ball;
	int pen;

	void sale() {// 10%할인
		ball = (int) (ball * 0.9);
		// ball = ball * 9 / 10
		// ball *= 0.9;
		pen = (int) (pen * 0.9);
	}

	void printPrice() {
		System.out.println(name + "마트의 가격정보는\n" + "볼의 가격은 " + ball + "원이고\n" + "펜의 가격은 " + pen + "원이다.");
	}
}