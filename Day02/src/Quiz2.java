import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class Quiz2 {
	public static void main(String[] args) {

		// �����Կ� Ű�� ����� �Է��� �޾�
		// �������� �Ǻ��Ͽ� ���
		// ��ü��������(BMI)=ü��(kg)/[����(m)]
		// ��ü�� 20 �̸�
		// ���� 20�̻�-25�̸�
		// ��ü�� 25�̻�-30�̸�
		// �� 30�̻�

		Scanner scan = new Scanner(System.in);
		System.out.println("�����Ը� �Է��ϼ���");
		int weight = scan.nextInt();
		System.out.println("Ű�� �Է��ϼ���");
		double height = scan.nextInt();
		double bmi = weight / ((height / 100) * (height / 100));
		System.out.println("����� BMI��" + bmi + "�Դϴ�");

		if (bmi >= 30) {
			System.out.println("���Դϴ�");
		} else if (bmi >= 25) {
			System.out.println("��ü���Դϴ�");
		} else if (bmi >= 20) {
			System.out.println("�����Դϴ�");
		} else {
			System.out.println("��ü���Դϴ�");
		}

	}// end of main
}// end of class
