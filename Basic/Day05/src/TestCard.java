
public class TestCard {
	public static void main(String[] args) {

		Card ca1 = new Card();
		ca1.kind = "하트";
		ca1.number = 4;

		ca1.printCard();

		Card ca2 = new Card();
		ca2.kind = "다이아몬드";
		ca2.number = 9;

		ca2.printCard();

		Card ccc[] = new Card[2];
		ccc[0] = ca1;
		ccc[1] = ca2;

		int a[] = new int[3];
		a[0] = 3;
		a[2] = 2;

	}// end of main
}// end of class

class Card {
	String kind;
	int number;

	void printCard() {
		System.out.println("카드의 무늬는 " + kind + "이고\n" + "카드의 숫자는 " + number + "입니다.");
	}

}
