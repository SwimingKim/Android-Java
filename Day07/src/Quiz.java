import java.util.Arrays;

/**
 * ��ٹ���
 */
public class Quiz {
	public static void main(String[] args) {

		// 1000~9999 : �������� ���� �߿��� ���� ������ ������ ����Ͻÿ�.
		// 10~13 �������� ����
		// 0:1�� 1:5�� 2:1�� 3:1��
		// 1 5 1 1 0 0 0 0 0 0

		int count[] = new int[10]; // �� ������ ���Ƚ�� ����
		for (int i = 1000; i <= 9999; i++) {
			count[i % 10]++;// ���� �ڸ�
			count[i / 10 % 10]++;// ���� �ڸ�
			count[i / 100 % 10]++;// ���� �ڸ�
			count[i / 1000 % 10]++;// õ�� �ڸ�
		}
		System.out.println(Arrays.toString(count));
		System.out.println(1234 % 10);
		System.out.println(1234 / 10 % 10);
		System.out.println(1234 / 100 % 10);
		System.out.println(1234 / 1000 % 10);

	}// end of main
}// end of class
