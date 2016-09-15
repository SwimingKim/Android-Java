/**
 * 아침문제
 */
public class Test {
	public static void main(String[] args) {
		int a = 3;
		int b = 4;

		System.out.println("a = " + a + ", b = " + b);// a=3, b=4

		// 코드 작성 a <-> b 교체
		int temp = a; // 임시로 a 값을 보존
		a = b; // a = 4
		b = temp; // b = 3

		System.out.println("a = " + a + ", b = " + b);// a=4, b=3

		int c = 4, d = 7, f = 1;

		System.out.println("" + c + d + f); // 471

		// 값을 교체 swap
		temp = c;
		c = d;
		d = f;
		f = temp;

		System.out.println("" + c + d + f); // 714

		c = 4;
		d = 7;
		f = 1;

		System.out.println("" + c + d + f); // 471

		// 값을 교체 swap
		temp = f;
		f = d;
		d = c;
		c = temp;

		System.out.println("" + c + d + f); // 147
	} // end of main
} // end of class
