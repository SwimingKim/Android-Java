import java.util.Arrays;

import javax.naming.StringRefAddr;

public class Test2 {
	public static void main(String[] args) {
		// �迭 data�� ���Ҹ� �������� �迭 data2�� ���� �� data2�� ���

		int data[] = { 3, 7, 2, 1, 5, 9, 4 };
		int data2[] = new int[data.length];
		for (int i = 0; i < data.length; i++) {
			data2[i] = data[data.length - (i + 1)];
		}
		System.out.println(Arrays.toString(data2));

	}// end of main
}// end of class
