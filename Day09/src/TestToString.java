/**
 * Object �ְ����� Ŭ���� toString - ���ڿ��� �������ִ� �޼���
 */
public class TestToString {
	public static void main(String[] args) {
		Card c1 = new Card();
		c1.kind = "���̾�";
		c1.num = 7;
		// c1.printCard();
		System.out.println(c1);
		System.out.println(c1.toString());

	}// end of main
}// end of class

class Card {
	String kind = "";
	int num;

	// void printCard(){
	// System.out.println(kind+num);
	// }

	public String toString() {// ��ü�� ������ ���ڿ��� ���� �������ִ� �޼���
		return "[" + kind + "," + num + "]";
	}

}