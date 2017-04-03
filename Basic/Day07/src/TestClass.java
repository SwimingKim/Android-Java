
public class TestClass {
	public static void main(String[] args) {
		Boy b1 = new Boy("홍길동", 50, 15);
		Boy b2 = new Boy("서민규", 26, 100);

		b1.name = "홍길동";
		b1.age = 50;
		b1.money = 15;

		System.out.println(b1.name + b1.age + b1.money);
		b1.printBoy();

		// b2.name = "서민규";
		// b2.age = 26;
		// b2.money = 100;

		b2.printBoy();

	}// end of main
}// end of class

class Boy {
	String name = "";
	int age;
	int money;

	Boy() {// 기본 생성자 : 값의 초기화 작업

	}

	Boy(String n, int a, int m) {// 생성자
		name = n;// 문자열의 초기화는 "" 빈문자열로 초기화하자
		age = a;
		money = m;
	}

	void printBoy() {
		System.out.println(name + "\t" + age + "살\t" + money + "원");
	}

}