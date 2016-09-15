/**
 * Object Ŭ���� : ��� Ŭ������ �ְ� ���� Ŭ���� �ڹٴ� ���ϻ�Ӹ��� ����Ѵ� : �ڹ��� ��Ȯ��(�ָŸ�ȣ�� ���׿��� �߻��� ������
 * ����) �ƹ��͵� ��ӹ��� ���� Ŭ������ extends Object�� �����ؼ�, ��� Ŭ������ Object�� ��ӹ���
 */
public class TestEquals {
	public static void main(String[] args) {
		String str1 = "ȫ�浿"; // String Ŭ������ �̷� ����� ������ ����Ѵ�(�ּ�)
		String str2 = "ȫ�浿";
		if (str1 == str2) {
			System.out.println("== ��� ����");// ����
		} else {
			System.out.println("== ��� �ٸ�");
		}
		/////////////////////////////////////////////////////////////
		String str3 = new String("�αԽ�");// ��ü ������ ��Ģ(���Ǯ)
		String str4 = new String("�αԽ�");
		if (str3 == str4) {
			System.out.println("== ����");
		} else {
			System.out.println("== �ٸ�");// ���
		}
		// ��ü(���ڿ�)�� ���빰�� ���Ϸ��� equals() �޼��带 ����ؾ� ��
		if (str3.equals(str4)) {
			System.out.println("equals ���ƿ�");// ���
		} else {
			System.out.println("equals �޶��");
		}

		Car c1 = new Car();
		Car c2 = new Car();
		c1.door = 4;
		c1.���� = 21.0;
		c2.door = 4;
		c2.���� = 21.0;

		if (c1 == c2) {
			System.out.println("== ����");
		} else {
			System.out.println("== �ٸ�");// ���
		}

		if (c1.equals(c2)) {// equals() ����Ϸ��� overriding �ؾ� �Ѵ�
			System.out.println("equals ����");
		} else {
			System.out.println("equals �ٸ�");// ���
		}

	}// end of main
}// end of class

class Car {
	int door;
	double ����;

	@Override
	public boolean equals(Object obj) {
		Car c = (Car) obj;// Car ��ü�� �������� ����ȯ�ؾ��Ѵ�
		if (this.door == c.door && this.���� == c.����) {
			return true;
		} else
			return false;
	}
}
