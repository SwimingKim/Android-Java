import java.util.Arrays;

/**
 * sort : ����
 */
public class TestSort {
	public static void main(String[] args) {
		// {3,1,4,7,8,2,4,2,4,2,3,8,1}
		// ������������ �����Ͻÿ�.

		// ��������
		int num[] = { 3, 1, 4, 7, 8, 2, 4, 2, 4, 2, 3, 8, 1 };

		// ���� - �������� (�ּҰ�, ��ȯ)

		// �ּҰ��� ã�´�
		int minIndex;
		for (int i = 0; i < num.length; i++) {
			minIndex = i;
			for (int j = i + 1; j < num.length; j++) {
				if (num[minIndex] > num[j])
					minIndex = j;
			}
			// ã�� �ּҰ��� ù��° ����� ��ȯ�Ѵ�
			// swap : i��° ���� minIndex��°�� ���� ��ȯ
			int temp = num[i];
			num[i] = num[minIndex];
			num[minIndex] = temp;

		}

		System.out.println(Arrays.toString(num));// ���ĵ� �� ���

	}// end of main
}// end of class
