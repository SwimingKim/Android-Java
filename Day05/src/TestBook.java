import java.awt.print.Printable;

public class TestBook {
	public static void main(String[] args) {
		Book bo1 = new Book();
		bo1.name = "자바의 정석";
		bo1.publisher = "도우";
		bo1.price = 30000;

		bo1.printBook();

	}// end of main
}// end of class

class Book {
	String name;// 책이름
	String publisher;// 출판사
	int price;// 가격

	void printBook() {// 멤버변수 값 출력
		System.out.println("책 이름은 " + name + "이며,\n" + "출판사는 " + publisher + "이고,\n" + "가격은 " + price + "원입니다.");

	};
}