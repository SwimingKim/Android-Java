import java.util.Scanner;

public class TestEnd2 {
	public static void main(String[] args) {

		// Switch case
		// �ȳ����� ���
		// ���� ���α׷�
		// ���� ������ ���� ������ �Է��ϼ���(�����ڴ� :, +, -, *, / 4�����Դϴ�)
		// ����1, ������, ����2
		// Switch(������)
		// ����� �Է��� �޾�
		// '+'�̸� �������� ���� ���
		// '-'�̸� �������� ���� ���
		// '*'�̸� �������� ���� ���
		// '/'�̸� ���������� ���� ���

		Scanner scan = new Scanner(System.in);
		System.out.println("���ڸ� �Է����ּ���");
		int num1 = Integer.parseInt(scan.nextLine());
		System.out.println("�����ڸ� �Է����ּ���(�����ڴ� +, -, *, / 4�����Դϴ�)");
		String op = scan.nextLine();
		System.out.println("���ڸ� �Է����ּ���");
		int num2 = Integer.parseInt(scan.nextLine());

		switch (op) {
		case "+":
			System.out.println(num1 + num2);
			break;
		case "-":
			System.out.println(num1 - num2);
			break;
		case "*":
			System.out.println(num1 * num2);
			break;
		case "/":
			System.out.println(num1 / num2);
			break;
		default:
			System.out.println("�����Դϴ�");
			break;
		}

	}// end of main
}// end of class
