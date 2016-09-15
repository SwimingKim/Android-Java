import java.util.Scanner;

/**
 * 반복문 : for, while, do~while
 */
public class TestWhile {
	public static void main(String[] args) {
		// while(조건식){//조건식 : 참 or 거짓
		// 반복할 실행문;
		// }
		// 반복할 횟수나 범위가 정해지면 while사용

		boolean b = false;
		while (b) {
			System.out.println("***");
		}

		int num = 4;
		while (num < 6) {
			System.out.println("xxxx");
			num++;
		}

		for (int i = 4; i < 6; i++) {
			System.out.println("xxxx");
		}

		// 사용자가 숫자를 입력받아서 그대로 출력
		// 사용자의 입력숫자가 0이면 종료

		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("숫자를 입력하세요");
			int n = scan.nextInt();
			System.out.println(n);

			if (n == 0) {
				System.out.println("0을 입력해서 종료함");
				break;// 가까운 switch문 또는 반복문 하나만 빠져나간다
			}
		}

	}// end of main
}// end of class
