import java.util.Arrays;

import javax.swing.JOptionPane;

/**
 * �迭 : ���� Ÿ�� �������� ����
 */
public class TestArray {
	public static void main(String[] args) {
		int a = 4;
		int b[] = new int[3];
		int c[] = { 1, 2, 3, 4 };

		int sum = 0;
		for (int i = 0; i < c.length; i++) {
			sum += c[i];
		}
		System.out.println((float) sum / c.length);

		// ������� �Է��� 3ȸ �޾Ƽ� ������ ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
		int user[] = new int[3];
		int sum_user = 0;
		for (int i = 0; i < user.length; i++) {
			user[i] = Integer.valueOf(JOptionPane.showInputDialog(i + 1 + "��° ���ڸ� �Է��ϼ���"));

			sum_user += user[i];
		}
		System.out.println("���� = " + sum_user + " ��� = " + sum_user / user.length);

	}// end of main
}// end of class
