import java.util.Scanner;

public class Fighting {
	public static void main(String[] args) {
		// ������� �Է��� �޾Ƽ� ������ ������ ���ϰ�
		// �ش� ���̽����� 1���� �����ϴ� ��� �߿���
		// ���� ū���� ���� ���� ���� ���غ���

		System.out.println("�� ������ ������ �Է��ϼ���");
		Scanner scan = new Scanner(System.in);
		int T = Integer.valueOf(scan.nextLine());

		for (int i = 1; i <= T; i++) {
			System.out.println("");
			System.out.println("���ڸ� �Է��Ͻ���");
			int num = Integer.valueOf(scan.nextLine());
			int count = 1;

			for (int j = 1; j <= 1000000; j++) {// Ư���� ���ڰ� 1���� ���� ��� ���ϱ�
				count = 1;
				while (num != 1) {
					count++;
					if (num % 2 == 0) {
						num = num / 2;
						System.out.print("¦��" + num);
						continue;
					} else {
						num = num * 3 + 1;
						System.out.print("Ȧ��" + num);
						continue;
					}
				}
			}
			System.out.println("");
			System.out.println(num + "�� 1���� ���� ���� " + count);

			System.out.println("");
			System.out.println("CASE " + i);
			System.out.println(count + "");

		}

		// for (int i = 0; i < 100000000; i++) {
		// int count = 1;
		// System.out.println("���ڸ� �Է��ϼ���");
		// int num = Integer.valueOf(scan.nextLine());
		//
		// int dap = 0;
		// for (int j = 1; j <= 20; j++) {
		// count=1;
		// while (num!=1) {
		// count++;
		// if (num%2==0) {
		// num=num/2;
		// System.out.print("¦��"+num);
		// continue;
		// } else {
		// num=num*3+1;
		// System.out.print("Ȧ��"+num);
		// continue;
		// }
		// }
		// dap=count;
		// }
		// System.out.println(dap+"");
		//
		//
		//
		//
		// }
		//

	}// end of main
}// end of class
