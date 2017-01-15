/**
 * static 변수의 활용
 */
public class TestCard {
	public static void main(String[] args) {
		Card c1 = new Card();
		c1.kind = "하트";
		c1.number = 7;
		Card.w = 4;
		Card.h = 6;

		Card c2 = new Card();
		c2.kind = "다이아";
		c2.number = 5;
		Card.w = 10;
		Card.h = 20;

		c1.printCard();
		c2.printCard();

	}// end of main
}// end of class

class Card {
	static int w;
	static int h;
	String kind;
	int number;

	void printCard() {
		System.out.println("[" + kind + "," + number + "] " + w + "," + h);
	}

}