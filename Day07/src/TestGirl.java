/**
 * ����ģ�� ��ü �߻�ȭ
 */
public class TestGirl {
	public static void main(String[] args) {
		Girl g1 = new Girl("����", 35, 80);
		Girl g2 = new Girl("������", 30, 85);
		Girl g3 = new Girl();

		g1.printGirl();
		g2.printGirl();
		g3.printGirl();

	}// end of main
}// end of class

class Girl {
	String name = "";
	int age;
	int pretty;// �̻� ô��(100������)

	Girl() {
	}

	Girl(String name, int age, int pretty) {
		this.name = name;
		this.age = age;
		this.pretty = pretty;
	}

	void printGirl() {
		System.out.println(name + "��\t" + age + "��\t" + pretty + "��");
	}

}
