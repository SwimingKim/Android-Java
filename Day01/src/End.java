import java.util.Arrays;
import java.util.Random;

public class End {
	public static void main(String[] args) {
		// �ڽ��� ���̸� ����� ������ ���
		// �ڽ��� �̸��� ������ ������ ���

		final int AGE = 26;
		String name = "���α�";
		System.out.println(AGE + " ��");
		System.out.println(name);

		// ���� : ���� ��� ���� ���� (1. ȯ�漳ġ, 2. ����)
		double d = 3.14;
		float f = 3.14f;
		f = (float) d;

		int num[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		int now = 1;
		int dap1[] = new int[16]; // 1���� 16����
		int dap2[] = new int[16]; // 17���� 32����
		int dap3[] = new int[16]; // 33���� 48����
		int dap4[] = { 49, 50 }; // 49���� 50����

		Random ran = new Random();
		for (int i = 0; i < num.length * 2; i++) {
			int n1 = ran.nextInt(num.length);
			int n2 = ran.nextInt(num.length);

			int temp = num[n1];
			num[n1] = num[n2];
			num[n2] = temp;
		}
		for (int i = 0; i < num.length; i++) {
			dap1[i] = num[i];
		}
		for (int i = 0; i < num.length; i++) {
			dap2[i] = num[i];
		}
		for (int i = 0; i < num.length; i++) {
			dap3[i] = num[i];
		}
		System.out.println(Arrays.toString(dap1));
		System.out.println(Arrays.toString(dap2));
		System.out.println(Arrays.toString(dap3));
		System.out.println(Arrays.toString(dap4));

	} // end of main
} // end of class
