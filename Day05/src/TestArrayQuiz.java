import java.util.Scanner;

public class TestArrayQuiz {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5 };
		// �迭 a�� �迭 b�� ���� �� ����Ͻÿ�.

		int b[];
		b = a;// �迭�ּҺ���//��������
		System.out.println(b[2]);
		b[0] = 100;
		System.out.println(b[0]);
		System.out.println(b[1]);

		// ���� ����-���ο� ����� ���� �����
		int d[] = new int[5];
		for (int i = 0; i < d.length; i++) {
			d[i] = a[i];// �迭 ������ ���� - ���� ����
		}
		System.out.println(d[4]);
		d[4] = 400;
		System.out.println(d[4]);
		System.out.println(a[4]);

		// ���� : 3���� �л��� ������ �Է¹޾Ƽ� �� ���� ����Ͻÿ�

		Scanner scan = new Scanner(System.in);// �Է¹޴� ��ü����
		int jumsoo[] = new int[3];// �迭 ���� 3��¥��
		System.out.println("3�� �л��� ������ �Է����ּ���");

		int sum = 0;
		for (int i = 0; i < jumsoo.length; i++) {// �ݺ���
			jumsoo[i] = scan.nextInt();
			sum += jumsoo[i];
		}

		System.out.println("�л����� ������ " + sum);

	}
}
