import java.util.Arrays;

import javax.swing.JOptionPane;

/**
 * 배열 : 같은 타입 변수들의 묶음
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

		// 사용자의 입력을 3회 받아서 총점과 평균을 구하는 프로그램을 작성하시오.
		int user[] = new int[3];
		int sum_user = 0;
		for (int i = 0; i < user.length; i++) {
			user[i] = Integer.valueOf(JOptionPane.showInputDialog(i + 1 + "번째 숫자를 입력하세요"));

			sum_user += user[i];
		}
		System.out.println("총점 = " + sum_user + " 평균 = " + sum_user / user.length);

	}// end of main
}// end of class
