import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {

		// ������ 3�� ����� �Է��� �޾�
		// ū ���� ���

		Scanner scan = new Scanner(System.in);
		System.out.println("���ڸ� 3�� �Է��ϼ���");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();

		// System.out.println(num1>num2? num1 : num2);
		System.out.println(num1 > num2 ? (num1 > num3 ? num1 : num3) : (num2 > num3 ? num2 : num3));
		// �ڵ尡 ���������� ���׿����ڴ� ���� �ʴ´�

		if (num1 > num2) {// ������ �������� ��򸰴�
			if (num1 > num3) {
				System.out.println(num1);
			} else
				System.out.println(num3);
		} else {
			if (num2 > num3) {
				System.out.println(num2);
			} else
				System.out.println(num3);
		}

		// �ִ�, �ּҸ� ã�� ���
		int max = num1;// �ִ밪�� ������ ����
		if (max < num1)
			max = num1;
		if (max < num2)
			max = num2;
		if (max < num3)
			max = num3;
		System.out.println(max);

		// �ּҰ��� ã�� ���
		int min = num1;
		if (min > num1)
			min = num1;
		if (min > num2)
			min = num2;
		if (min > num3)
			min = num3;

		char x = '6';
		if (x > 0 && x <= 9) {
			System.out.println("����");
		} else {
			System.out.println("���ھƴ�");
		}

	}// end of main
}// end of class
