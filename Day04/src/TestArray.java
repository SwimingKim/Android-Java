/**
 * ���� :�ϳ��� �����͸� ������ �� �ִ� ������ �������� ����� �����͸� ��� �迭 : �������� (���� Ÿ����) �������� ���� �ݺ������ε�
 * ��밡��
 */
public class TestArray {
	public static void main(String[] args) {
		int a;// ���� ����
		a = 3;// ������ �ʱ�ȭ

		int b[];// �迭 ���� ����
		b = new int[3];// �迭 ���� ����
		b[0] = 5;
		b[1] = 9;
		b[2] = 7;
		// b={5,9,7};//ó�� �迭 ���� �����̼��� �ѹ��� ó�������ϴ�.

		System.out.println(b[1]);// 9

		int c[] = { 5, 9, 7 };// �迭 ���� ����, ����, �ʱ�ȭ�� �� ����
		System.out.println(c[0]);
		System.out.println(c[1]);
		System.out.println(c[2]);

		for (int i = 0; i < 3; i++) {
			System.out.println(c[i]);
		}

		// �����迭(���Ұ����� 5��)�� ����, ����, �ʱ�ȭ ��
		// �ݺ����� ����ؼ� ������ ����� ����Ͻÿ�

		int jumsu[] = { 5, 8, 3, 2, 7 };
		int sum = 0;
		int mid = sum / 5;
		for (int i = 0; i < 5; i++) {
			sum = sum + jumsu[i];
		}
		System.out.println("������ " + sum);
		System.out.println("����� " + sum / jumsu.length);

		System.out.println(jumsu.length);// �迪�� ũ��(������ ����)

		int num[] = { 9, 5, 7 };// �ִ밪�� ����Ͻÿ�.
		int max = num[0];
		if (max <= num[1])
			max = num[1];
		if (max <= num[2])
			max = num[2];
		System.out.println(max);

		for (int i = 0; i < num.length; i++) {
			if (max <= num[i])
				max = num[i];
		}
		System.out.println(max);

	}// end of main
}// end of class
