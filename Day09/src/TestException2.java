import java.util.Scanner;

/**
 * ����ó��
 */
public class TestException2 {
	public static void main(String[] args) {
		// ������� �Է��� �޾Ƽ� 3/n

		Scanner scan = new Scanner(System.in);
		System.out.println("���ڸ� �Է����ּ���");

		while (true) {
			int num = scan.nextInt();
			// if (num==0) System.out.println("0�� �Է��ϸ� �ȵ˴ϴ�");//�̷��� ó���� ���� �ִ�
			try {
				System.out.println(3 / num);
				break;
			} catch (ArithmeticException ae) {
				System.out.println("0�� �Է��ϸ� �ȵ˴ϴ�");
			}
		}

	}// end of main
}// end of class
