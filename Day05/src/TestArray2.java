
public class TestArray2 {
	public static void main(String[] args) {
		int a[];// �迭������ ����
		// int []a;
		a = new int[4];// �迭������ ���� -> �� Ÿ���� �⺻���� ����ȴ�
		// �⺻��Ÿ��, ���� - 0, �Ǽ� -0.0, ���� - '\u0000', �� - false
		// ������Ÿ��, null (String, System, Scanner)
		a[0] = 3;
		// a[4]=5; �迭 �ε��� ���� (0~3)�� ����� �����߻�
		System.out.println(a[0]);

		int b[] = { 1, 2, 3 };// �迭�� ����, ����, �ʱ�ȭ�� �� ����
		// �����Ϸ��� �ϴ� �� ����(������ ��谡 ������ �� �ֵ��� ����� �ٲٱ�, �� �ܿ��� ����ȯ)

		int c[][];// 2���� �迭
		// int [][]c;
		// int []c[];
		c = new int[2][3];
		c[0][0] = 1;
		c[0][1] = 2;
		c[0][2] = 3;
		c[1][0] = 4;
		c[1][1] = 5;
		c[1][2] = 6;

		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				System.out.println(i + "." + j + "=" + c[i][j]);
			}
		}

		int d[][] = { { 1, 2, 3 }, { 4, 5, 6 } };// 2��3��

	}// end of main
}// end of class
