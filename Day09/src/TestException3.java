import java.util.*;

/**
 * 예외처리3
 */
public class TestException3 {
	public static void main(String[] args) {
		// 사용자 입력을 숫자로 받아서 출력하기

		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요");
		while (true) {
			try {
				int num = scan.nextInt();
				System.out.println(10 / num);
				break;
			} catch (InputMismatchException e) {// 문자 입력시
				System.out.println("숫자가 아닌 것을 입력하셨습니다.");
				scan.nextLine();// 버퍼에 잘못 들어간 내용을 제거
			} catch (ArithmeticException ae) {// 숫자 0 입력시
				System.out.println("0를 입력하면 안 됩니다");
			} catch (Exception e) {// 나머지 모든 에외 처리 - 가장 마지막 catch에 사용
				System.out.println("오류가 발생했습니다");
			} finally {// 반드시 실행하고 빠져나가야 되는 내용
				System.out.println("파이널리 반드시 실행됨");
			}
		}

	}// end of main
}// end of class
