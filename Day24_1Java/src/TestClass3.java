/**
 * �����ε� : ���� Ŭ�����ȿ��� �޼����� ���ڰ��� ���� or���� orŸ���� �ٸ��� ������ �޼������ ����� �� �ֵ��� ����ϴ� ���
 * �������̵� : ��Ӱ����� Ŭ�������� �θ� Ŭ������ �޼��带 �ڽ�Ŭ�������� �������ϴ� ��
 */
public class TestClass3 {
	public static void main(String[] args) {
		// �����ε� : �� Ŭ���� ������ �޼���� (���ڰ��� ����, ����, Ÿ�� ����)
		// �������̵� : ��� �޼��� ������

		new Child().ppp();

	}// end of main
}// end of class

class MyClass { // �����ε� : ������ �̸����� �޼������ �ۼ��ϴ� ��,
	// ���ڰ��� ����, Ÿ��, ������ �ٸ��� �ؾ� �Ѵ�
	void bb() {
	}

	void bb(int a) {
	}

	void bb(boolean a) {
	}

	void bb(boolean a, int z) {
	}

	void bb(int z, boolean a) {
	}

}

class Parent {
	void ppp() {
		System.out.println("���� ppp�Դϴ�");
	}

}

class Child extends Parent {

	void ppp() { // �������̵� : �θ�Ŭ������ �޼��带 �������ϴ� ��
		System.out.println("���� �ڽ��� �������Դϴ�");
	}

}