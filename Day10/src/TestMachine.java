import java.util.Scanner;

public class TestMachine {
	public static void main(String[] args) {
		String menu[] = { "ĭŸŸ", "��Ű��", "����ƾ��", "������", "���̴�", "ī��Ÿ��", "����", "�ݶ�", "���䷹��" };
		int price[] = { 1800, 800, 900, 500, 1100, 700, 600, 700, 700 };

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("���Ǳ� �����");
			for (int i = 0; i < price.length; i++) {
				System.out.println(i + 1 + ". " + menu[i] + "\t" + price[i]);
			}
			System.out.println("���� �Է����ּ���");

			int money = Integer.parseInt(scan.nextLine());
			try {
				if (money < 0) {
					System.out.println("���� ���̳ʽ��� �ȵſ�");
					continue;
				} else
					System.out.println(money + "���� �־����ϴ�");
			} catch (NumberFormatException ae) {
				System.out.println("���� ���ڷ� �Է����ּ���");
				continue;
			}

			System.out.println("������� �������ּ���");
			int select = Integer.parseInt(scan.nextLine());
			try {
				System.out.println(menu[select - 1] + "�� �����߽��ϴ�");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("�޴������� ������ �����");
				continue;
			}

			System.out.println("�ܵ��� " + (money - price[select - 1]));
			System.out.println("500�� " + (money - price[select - 1]) / 500 + "��\n" + "100�� "
					+ (money - price[select - 1]) % 500 / 100 + "��\n" + "50�� " + (money - price[select - 1]) % 100 / 50
					+ "��\n" + "10�� " + (money - price[select - 1]) % 50 / 10 + "��");
			System.out.println("���ſϷ�\n");

		}
	}// end of main
}// end of class
