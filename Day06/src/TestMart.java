/**
 * this - �ڱ� �ڽ��� ��ü�� ����Ű�� ��������
 */
public class TestMart {
	public static void main(String[] args) {

		Mart m1 = new Mart("�̸�Ʈ", 30000, 5000);
		Mart m2 = new Mart("Ȩ�÷���", 25000, 4000);
		Mart m3 = new Mart("�Ե���Ʈ", 28000, 5100);

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
		System.out.println("���� ��");
		sale();
		printPrice();
	}

	void sale() {
		int ttttttttt = 0;// ���������� ����� �ƴϴ�
		ball *= 0.9;
		pen *= 0.9;
	}

	void printPrice() {
		System.out.println(name + "��Ʈ������ \n" + "���� ������ " + ball + "���̰�,\n" + "���� ������ " + pen + "���̴�\n");
	}

}
