
public class TestCard {
	public static void main(String[] args) {

		Card ca1 = new Card();
		ca1.kind = "��Ʈ";
		ca1.number = 4;

		ca1.printCard();

		Card ca2 = new Card();
		ca2.kind = "���̾Ƹ��";
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
		System.out.println("ī���� ���̴� " + kind + "�̰�\n" + "ī���� ���ڴ� " + number + "�Դϴ�.");
	}

}
