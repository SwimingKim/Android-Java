/**
 * while Ȱ��
 */
public class TestWhileQuiz {
	public static void main(String[] args) {
		// 1+2+3+4 ..args + 9+10

		int sum = 0;// ���� ������ ����
		for (int i = 1; i <= 10; i++) {
			// System.out.println(i);
			sum = sum + i;
		}
		System.out.println(sum);

		// 2+4+6+8+10+12+14
		sum = 0;
		for (int i = 2; i <= 14; i += 2) {
			sum += i;
		}
		System.out.println(sum);

		// 7+14+21+... ���� 1000�� �Ѵ� ���� ���� ���
		sum = 0;
		for (int i = 7; sum <= 1000; i += 7) {
			sum += i;
		}
		System.out.println(sum);

		sum = 0;
		int add = 7;
		while (true) {
			sum += add;
			add += 7;
			if (sum > 1000) {
				break;
			}
		}
		System.out.println(sum);

		// sum�� 1000�� �ѱ� ������ �����
		sum = 0;
		add = 7;
		while (true) {
			if (sum + add > 1000) {
				break;
			}
			sum += add;
			add += 7;
		}
		System.out.println(sum);

	}// end of main
}// end of class
