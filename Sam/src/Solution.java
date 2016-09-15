import java.util.Scanner;
import java.io.FileInputStream;

/* ����ϴ� Ŭ�������� Solution �̾�� �ϸ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� ������ �� �� �ֽ��ϴ�. */

class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * �Ʒ� �޼ҵ� ȣ���� ������ ǥ���Է�(Ű����) ��� input.txt ���Ϸ� ���� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�. ���� ������
		 * PC ���� �׽�Ʈ �� ����, �Է°��� input.txt�� ������ �� �� �ڵ带 ù �κп� ����ϸ�, ǥ���Է� ���
		 * input.txt ���Ϸ� ���� �Է°��� �о� �� �� �ֽ��ϴ�. ����, ���� PC���� �Ʒ� �޼ҵ带 ������� �ʰ� ǥ���Է���
		 * ����Ͽ� �׽�Ʈ�ϼŵ� �����մϴ�. ��, Codeground �ý��ۿ��� "�����ϱ�" �� ������ �ݵ�� �� �޼ҵ带 ����ų�
		 * �ּ�(//) ó�� �ϼž� �մϴ�.
		 */
		// Scanner sc = new Scanner(new FileInputStream("input.txt"));

		// 3N+1
		// f(n) = n/2 (n�� ¦��)
		// f(n) = 3n+1 (n�� Ȧ��)
		// 2 3 8
		// ��ü ������ 2������ ���, 3�� 8���� ���� Ƚ���� ���� ���� ū ���� ���ؿ���
		// 1<=t<=32
		// 0<=k<=63

		System.out.println(new Function().result(3) + "");

		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		int count = 0;

		System.out.println("32�̳��� ���ڸ� �Է��ϼ���");
		T = Integer.valueOf(sc.nextLine());

		// T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�. �⺻ ������ �ڵ带 ���� �Ǵ� �����ϰ� ������ �ڵ带 ����ϼŵ�
			// �˴ϴ�.

			System.out.println("���ڸ� �Է����ּ���");
			int num = Integer.valueOf(sc.nextLine());

			int dap = new Function().result(num);

			if (dap == num) {
				System.out.println("���� ���Ծ�" + num);
			}

			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println(dap + "\t");

		}

	}// end of main
}// end of class

class Function {
	int num;

	public Function() {
	}

	public Function(int num) {
		this.num = num;
	}

	int count = 1;

	int result(int num) {// Ư�� ���ڰ� 1���� ���� ���
		int num_og = num;
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
		return count;
	}

	int dap[][];

	int path = 1;
	int num_og;

	int path(int k) {
		for (int num_og = 2; num_og < 63; num_og++) {
			// int num_og;
			while (num_og != 1) {
				num_og++;
				if (num_og % 2 == 0) {
					num_og = num_og / 2;
					System.out.print("-" + num_og);
					continue;
				} else {
					num_og = num_og * 3 + 1;
					System.out.print("-" + num);
					continue;
				}
			}
			dap[path][num_og] = k;
		}

		return num_og;
	}

}
