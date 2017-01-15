/**
 * Exception Handling(예외 처리)
 */
public class TestException {
	public static void main(String[] args) {

		System.out.println(1);

		try {
			System.out.println(2);
			System.out.println(3 / 0); // 정수의 나눗셈에서 0으로 나는 것은 Exception
			// ArithmeticException
			System.out.println(3);
		} catch (ArithmeticException ae) {
			System.out.println(4);
			System.out.println("0으로 입력하면 안 됩니다");
			System.out.println(5);
		}

		System.out.println("정상종료");

	}// end of main
}// end of class
