import java.awt.print.Printable;

public class TestBook {
	public static void main(String[] args) {
		Book bo1 = new Book();
		bo1.name = "�ڹ��� ����";
		bo1.publisher = "����";
		bo1.price = 30000;

		bo1.printBook();

	}// end of main
}// end of class

class Book {
	String name;// å�̸�
	String publisher;// ���ǻ�
	int price;// ����

	void printBook() {// ������� �� ���
		System.out.println("å �̸��� " + name + "�̸�,\n" + "���ǻ�� " + publisher + "�̰�,\n" + "������ " + price + "���Դϴ�.");

	};
}