import java.util.Random;
import java.util.Scanner;

/**
 * ���������� ���� - ����ڰ� ����,����,�� �� �ϳ��� �Է�, ����ڰ� �̰���� ���
 */
public class TestRock {
	public static void main(String[] args) {
		// ����� �Է� ���ڿ��� �ޱ�
		// ���ڿ� ��
		// �������� �� ����

		Scanner scan = new Scanner(System.in);
		System.out.println("����, ����, �� �� �ϳ��� �Է��ϼ���");
		String user = scan.nextLine();
		System.out.println("����� " + user + "�Դϴ�");

		Random ran = new Random();
		int com = ran.nextInt(3);// 0 ����, 1 ����, 2 ��
		System.out.println("��ǻ�ʹ� " + com + "�Դϴ�");

		switch (user) {
		case "����":
			if (com == 0)
				System.out.println("�����ϴ�");
			else if (com == 1)
				System.out.println("�����ϴ�");
			else
				System.out.println("�̰���ϴ�");
			break;
		case "����":
			if (com == 0)
				System.out.println("�̰���ϴ�");
			else if (com == 1)
				System.out.println("�����ϴ�");
			else
				System.out.println("�����ϴ�");
			break;
		case "��":
			if (com == 0)
				System.out.println("�����ϴ�");
			else if (com == 1)
				System.out.println("�̰���ϴ�");
			else
				System.out.println("�����ϴ�");
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�");
			break;
		}

	}
}
