/**
 * Ŭ���� class : ���ο� Ÿ���� ����
 */
public class TestClass {
	public static void main(String[] args) {
		int a = 3;
		int num[] = new int[3];

		Cup b; // Ŭ���� ������ ����
		b = new Cup();// Ŭ���� ������ ����
		Cup c = new Cup();
		c.name = "�ӱ���";
		c.size = 200;
		System.out.println(c.name + c.size);

		// ���� : 1���� ������
		// �迭 : ���� Ÿ���� ���� ����
		// ����ü : ����, �ٸ� Ÿ�� ����, �迭
		// Ŭ���� : ����ü + �޼���

	}// end of main
}// end of class

class Cup {// Ŭ���� ���� :
	String name;// ���� �̸�
	int size;// ���� �뷮
	// �ż���
}
