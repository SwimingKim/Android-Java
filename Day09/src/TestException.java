/**
 * Exception Handling(���� ó��)
 */
public class TestException {
	public static void main(String[] args) {

		System.out.println(1);

		try {
			System.out.println(2);
			System.out.println(3 / 0); // ������ ���������� 0���� ���� ���� Exception
			// ArithmeticException
			System.out.println(3);
		} catch (ArithmeticException ae) {
			System.out.println(4);
			System.out.println("0���� �Է��ϸ� �� �˴ϴ�");
			System.out.println(5);
		}

		System.out.println("��������");

	}// end of main
}// end of class
