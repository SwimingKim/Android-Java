import java.util.Scanner;

/**
 * 반복문 : for, while, do~while
 */
public class TestDoWhile {
	public static void main(String[] args) {
		// 사용자의 입력을 받아서 출력하다가, 값이 0이면 종료하기
		Scanner scan = new Scanner(System.in);

		// System.out.println("숫자를 입력하세요");
		// int num=scan.nextInt();//사용자가 입력한 값을 넣겠다
		//
		// while(num != 0){//0이 아니면(0을 입력할 때까지) 반복하곘다
		// System.out.println("숫자를 입력하세요");
		// num=scan.nextInt();
		// }

		// do {
		// 반복할 실행문;
		// } while(조건문);
		// 최소 1번의 실행을 보장해야 할 때 사용하는 반복문

		int num;// 사용자가 입력한 값을 넣겠다
		do {
			System.out.println("숫자를 입력하세요");
			num = scan.nextInt();
		} while (num != 0);

	}// end of main
}// end of class
