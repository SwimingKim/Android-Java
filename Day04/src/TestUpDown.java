import java.util.Random;
import java.util.Scanner;

/**
 * ���ڰ��� UpDown
 */
public class TestUpDown {
	public static void main(String[] args) {
		// ��ǻ�Ͱ� �������� ������ ����(0~99)�� ����ڰ� ���� �� �ֵ���
		// Up or Down ������ �������ְ�, ���� Ƚ���� �������� ����Ͻÿ�

		Random ran = new Random();
		int num = ran.nextInt(100);
		System.out.println("��ǻ�Ͱ� �������� ������ �� :" + num);
		Scanner scan = new Scanner(System.in);
		System.out.println("����� ��������� �Է����ּ���");

		int user = scan.nextInt();
		int count = 0;
		while (true) {
			System.out.println("0���� 99���� ���ڸ� �Է����ּ���");
			user = scan.nextInt();
			count++;
			if (user == num) {// ����
				// �� ������ ������� ���
				System.out.println(count + "�� ���� ������ϴ�");
				break;
			} else if (user < num) {
				System.out.println("Up");
			} else { // user>num)
				System.out.println("Down");
			}

		}
		System.out.println("��������");

	}// end of main
}// end of class
