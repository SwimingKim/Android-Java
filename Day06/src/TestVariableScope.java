/**
 * ���� ������ : ���� ���� ��ġ�� ���� ����
 */
public class TestVariableScope {
	public static void main(String[] args) {
		AAA aaa1 = new AAA();
		aaa1.cc = 1;
		AAA.www = 10;

		System.out.println(aaa1.cc + "," + aaa1.www);// 1,10

		AAA aaa2 = new AAA();
		aaa2.cc = 2;
		aaa2.www = 20;
		aaa2.www = 100;
		System.out.println(aaa2.cc + "," + aaa2.www);// 2,100
		System.out.println(aaa1.cc + "," + aaa1.www);// 1,100

	}// end of main
}// end of class

class AAA {// Ŭ���� ���� = Ŭ���� ��ü - �޼��� ����
	static int www;
	// ��������, �۷ι�����, �������, Ŭ��������, static ����, ��������
	// Ŭ������ �̸��� ó�� ��޵� �� �޸𸮿� ���������
	// ���α׷��� ����� �� ��������
	// ��������.������ or Ŭ������.������

	int cc;
	// Ŭ���� ������ ������ ���� = ��������, �۷ι� ����, �������, �ν��Ͻ�����, non static ����
	// ��ü(�ν��Ͻ�)�� ������ �޸𸮿� ���������
	// ��ü�� ���������� �������� �޸𸮿��� ��������

	void x() {
		// a=3;
		int a;// �޼��� ������ ������ ���� = ��������, ���ú���
		// ������ ������ ���๮�� ����� ������ �޸𸮿� ���������.
		// �޼��带 ���������� �޸𸮿��� ��������
		a = 3;
	}

	void print() {// �޼���

	}

}