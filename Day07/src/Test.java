import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		// ������ �ڸ����� ���缭 2~9�ܱ��� ����Ͻÿ�

		for (int i = 2; i <= 9; i += 2) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d*%d=%2d\t", i, j, i * j);
				System.out.printf("%d*%d=%2d\n", i + 1, j, (i + 1) * j);
			}
		}

		// �迭�� ���� (3,7,1,9,2,5) ���� �� �ִ밪�� ����Ͻÿ�.
		int s[] = { 3, 7, 1, 9, 2, 5 };
		int max = s[0];
		for (int i = 1; i < s.length; i++) {
			if (s[i] >= max) {
				max = s[i];
			}
			continue;
		}
		System.out.println("�ִ밪�� " + max);

		int min = s[0];
		for (int i = 1; i < s.length; i++) {
			if (s[i] <= min) {
				min = s[i];
			}
			continue;
		}
		System.out.println("�ּҰ��� " + min);

		// ������� �Է��� �޾Ƽ� 4�� �޾Ƽ�
		// �迭�� ������ ������ ����� ���

		Scanner scan = new Scanner(System.in);
		int num[] = new int[4];
		System.out.println("���� " + num.length + "���� �Է����ּ���");
		int sum = 0;
		for (int i = 0; i < num.length; i++) {
			num[i] = scan.nextInt();
			sum += num[i];
		}
		System.out.println("������ " + sum);
		System.out.println("����� " + (float) (sum / num.length));

		System.out.println(3 + 4 + "abc" + 5 + 6);

		// System.out.println("\t\a");

	}// end of main
}// end of class
