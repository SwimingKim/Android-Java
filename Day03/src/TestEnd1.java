import java.util.Scanner;

/**
 * Ȱ�빮��
 */
public class TestEnd1 {
	public static void main(String[] args) {

		// ����� �Է��� �޾�
		// 2�� ����̸� "2�� ����Դϴ�" ���
		// 3�� ����̸� "3�� ����Դϴ�" ���
		// 6�� ����̸� "6�� ����Դϴ�" ���

		// Scanner scan = new Scanner(System.in);
		// System.out.println("���ڸ� �Է��ϼ���");
		// int num = scan.nextInt();
		// if(num%6==0){
		// System.out.println("6�� ����Դϴ�");
		// } else if(num%3==0){
		// System.out.println("3�� ����Դϴ�");
		// } else if(num%2==0){
		// System.out.println("2�� ����Դϴ�");
		// }

		// switch case
		// �ȳ����� ���
		// �����ϴ� ������ ������
		// 1. ���
		// 2. ������
		// 3. �ٳ���
		// 4. ����
		// ����� �Է��� �޾�
		// 1�̸� "����� �����ϼ̽��ϴ�" ���
		// 2�̸� "�������� �����ϼ̽��ϴ�" ���
		// 3�̸� "�ٳ����� �����ϼ̽��ϴ�" ���
		// 4�̸� "������ �����ϼ̽��ϴ�" ���
		// 1~4 �̿��� ���̸� "�߸� �Է��ϼ̽��ϴ�" ���

		Scanner scan = new Scanner(System.in);
		System.out.println("�����ϴ� ������ ������");
		System.out.println("1. ���");
		System.out.println("2. ������");
		System.out.println("3. �ٳ���");
		System.out.println("4. ����");

		int num = scan.nextInt();
		switch (num) {
		case 1:
			System.out.println("����� �����ϼ̽��ϴ�");
			break;
		case 2:
			System.out.println("�������� �����ϼ̽��ϴ�");
			break;
		case 3:
			System.out.println("�ٳ����� �����ϼ̽��ϴ�");
			break;
		case 4:
			System.out.println("������ �����ϼ̽��ϴ�");
			break;
		default:
			System.out.println("�� �� �Է��ϼ̽��ϴ�");
			break;
		}

	}// end of main
}// end of class
