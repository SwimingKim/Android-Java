import java.util.Scanner;

/**
 * swith�� ���� ���� int�� ���� ���� ������ ���� ���ڿ��� �����ϴ�
 */
public class TestSwitch2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("�̸��� �Է��ϼ���");

		switch (scan.nextLine()) {
		case "���α�":
			System.out.println("�߻�����ϴ�");
			break;
		case "������":
			System.out.println("�̻޴ϴ�");
			break;
		case "ȫ����":
			System.out.println("�����ϴ�");
			break;

		}
	}// end of main
}// end of class
