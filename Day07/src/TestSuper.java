/**
 * super : �θ� Ŭ������ ��ü�� ����Ű�� ��������
 */
public class TestSuper {
	public static void main(String[] args) {
		Child c = new Child();
		c.ccc();
	}// end of main
}// end of class

class Parent {
	int g = 100;// ��������

	void ddd() {
		int g = 2000;
	}// ��������
}

class Child extends Parent {
	int g = 30;// ��������

	void ccc() {
		int g = 4;
		System.out.println(g);// 4
		System.out.println(this.g);// 30, this ��Ŭ������ �������� �̻�
		System.out.println(super.g);// 100, super �θ�Ŭ������ ���������̻�
		super.ddd();// �θ�Ŭ������ ���(����,�޼���)�� ���ٽ� super ���

	}// ��������
}