/**
 * ���� - ī��Ʈ ���� ������ �����Ͱ� �����̾�� �Ѵ�.
 */
public class TestSort2 {
	public static void main(String[] args) {
		// �������� ���
		int num[] = { 3, 1, 4, 7, 8, 2, 4, 2, 4, 2, 3, 8, 1 };
		int count[] = new int[9];// index 0~8

		for (int i = 0; i < num.length; i++) {
			count[num[i]]++;
		}

		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count[i]; j++) {
				System.out.print(i + ", ");
			}
		}

		// �������� ���
		int num2[] = { 3, 1, 4, 7, 8, 2, 4, 2, 4, 2, 3, 8, 1 };
		int count2[] = new int[9];// index 0~8

		for (int i = 0; i < num.length; i++) {
			count2[num2[i]]++;
		}

		for (int i = count2.length - 1; i >= 0; i--) {
			for (int j = 0; j < count2[i]; j++) {
				System.out.print(i + ", ");
			}
		}

	}// end of main
}// end of class
