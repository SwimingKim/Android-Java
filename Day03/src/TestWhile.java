import java.util.Scanner;

/**
 * �ݺ��� : for, while, do~while
 */
public class TestWhile {
	public static void main(String[] args) {
		// while(���ǽ�){//���ǽ� : �� or ����
		// �ݺ��� ���๮;
		// }
		// �ݺ��� Ƚ���� ������ �������� while���

		boolean b = false;
		while (b) {
			System.out.println("***");
		}

		int num = 4;
		while (num < 6) {
			System.out.println("xxxx");
			num++;
		}

		for (int i = 4; i < 6; i++) {
			System.out.println("xxxx");
		}

		// ����ڰ� ���ڸ� �Է¹޾Ƽ� �״�� ���
		// ������� �Է¼��ڰ� 0�̸� ����

		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("���ڸ� �Է��ϼ���");
			int n = scan.nextInt();
			System.out.println(n);

			if (n == 0) {
				System.out.println("0�� �Է��ؼ� ������");
				break;// ����� switch�� �Ǵ� �ݺ��� �ϳ��� ����������
			}
		}

	}// end of main
}// end of class
