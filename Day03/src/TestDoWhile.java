import java.util.Scanner;

/**
 * �ݺ��� : for, while, do~while
 */
public class TestDoWhile {
	public static void main(String[] args) {
		// ������� �Է��� �޾Ƽ� ����ϴٰ�, ���� 0�̸� �����ϱ�
		Scanner scan = new Scanner(System.in);

		// System.out.println("���ڸ� �Է��ϼ���");
		// int num=scan.nextInt();//����ڰ� �Է��� ���� �ְڴ�
		//
		// while(num != 0){//0�� �ƴϸ�(0�� �Է��� ������) �ݺ��ρٴ�
		// System.out.println("���ڸ� �Է��ϼ���");
		// num=scan.nextInt();
		// }

		// do {
		// �ݺ��� ���๮;
		// } while(���ǹ�);
		// �ּ� 1���� ������ �����ؾ� �� �� ����ϴ� �ݺ���

		int num;// ����ڰ� �Է��� ���� �ְڴ�
		do {
			System.out.println("���ڸ� �Է��ϼ���");
			num = scan.nextInt();
		} while (num != 0);

	}// end of main
}// end of class
