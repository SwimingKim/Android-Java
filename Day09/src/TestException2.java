import java.util.Scanner;

/**
 * 예외처리
 */
public class TestException2 {
	public static void main(String[] args) {
		// 사용자의 입력을 받아서 3/n

		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요");

		while (true) {
			int num = scan.nextInt();
			// if (num==0) System.out.println("0를 입력하면 안됩니다");//이렇게 처리할 수도 있다
			try {
				System.out.println(3 / num);
				break;
			} catch (ArithmeticException ae) {
				System.out.println("0를 입력하면 안됩니다");
			}
		}

	}// end of main
}// end of class
