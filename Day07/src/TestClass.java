
public class TestClass {
	public static void main(String[] args) {
		Boy b1 = new Boy("ȫ�浿", 50, 15);
		Boy b2 = new Boy("���α�", 26, 100);

		b1.name = "ȫ�浿";
		b1.age = 50;
		b1.money = 15;

		System.out.println(b1.name + b1.age + b1.money);
		b1.printBoy();

		// b2.name = "���α�";
		// b2.age = 26;
		// b2.money = 100;

		b2.printBoy();

	}// end of main
}// end of class

class Boy {
	String name = "";
	int age;
	int money;

	Boy() {// �⺻ ������ : ���� �ʱ�ȭ �۾�

	}

	Boy(String n, int a, int m) {// ������
		name = n;// ���ڿ��� �ʱ�ȭ�� "" ���ڿ��� �ʱ�ȭ����
		age = a;
		money = m;
	}

	void printBoy() {
		System.out.println(name + "\t" + age + "��\t" + money + "��");
	}

}