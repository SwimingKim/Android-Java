import java.util.Arrays;
import java.util.Random;

/**
 * ����
 */
public class TestShuffle {
	public static void main(String[] args) {
		int num[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };// 10��
		// for (int i = 0; i < num.length; i++) {
		// System.out.println(num[i]);
		// }
		System.out.println(Arrays.toString(num));// �迭���� ���

		Random ran = new Random();

		// 0��°�� index ��° ���� �ٲ���

		for (int i = 0; i < 20; i++) {// ������ ����
			int index = ran.nextInt(num.length);// 0~9
			int temp = num[0];
			num[0] = num[index];
			num[index] = temp;
		}

		System.out.println("���� ��");
		System.out.println(Arrays.toString(num));

	}// end of main
}// end of class
