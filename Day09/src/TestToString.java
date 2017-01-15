/**
 * Object 최고조상 클래스 toString - 문자열로 변경해주는 메서드
 */
public class TestToString {
	public static void main(String[] args) {
		Card c1 = new Card();
		c1.kind = "다이아";
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

	public String toString() {// 객체의 정보를 문자열로 만들어서 리턴해주는 메서드
		return "[" + kind + "," + num + "]";
	}

}