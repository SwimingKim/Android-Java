/**
 * this - 자기 자신의 객체를 가리키는 참조변수
 */
public class TestMart {
	public static void main(String[] args) {

		Mart m1 = new Mart("이마트", 30000, 5000);
		Mart m2 = new Mart("홈플러스", 25000, 4000);
		Mart m3 = new Mart("롯데마트", 28000, 5100);

	}// end of main
}// end of class

class Mart {
	String name;
	int ball;
	int pen;

	Mart(String name, int ball, int pen) {
		this.name = name;
		this.ball = ball;
		this.pen = pen;
		printPrice();
		System.out.println("세일 후");
		sale();
		printPrice();
	}

	void sale() {
		int ttttttttt = 0;// 지역변수는 멤버가 아니다
		ball *= 0.9;
		pen *= 0.9;
	}

	void printPrice() {
		System.out.println(name + "마트에서는 \n" + "볼의 가격은 " + ball + "원이고,\n" + "펜의 가격은 " + pen + "원이다\n");
	}

}
