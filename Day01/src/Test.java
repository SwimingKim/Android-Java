/**
 * ��ħ����
 */
public class Test {
	public static void main(String[] args) {
		int a = 3;
		int b = 4;

		System.out.println("a = " + a + ", b = " + b);// a=3, b=4

		// �ڵ� �ۼ� a <-> b ��ü
		int temp = a; // �ӽ÷� a ���� ����
		a = b; // a = 4
		b = temp; // b = 3

		System.out.println("a = " + a + ", b = " + b);// a=4, b=3

		int c = 4, d = 7, f = 1;

		System.out.println("" + c + d + f); // 471

		// ���� ��ü swap
		temp = c;
		c = d;
		d = f;
		f = temp;

		System.out.println("" + c + d + f); // 714

		c = 4;
		d = 7;
		f = 1;

		System.out.println("" + c + d + f); // 471

		// ���� ��ü swap
		temp = f;
		f = d;
		d = c;
		c = temp;

		System.out.println("" + c + d + f); // 147
	} // end of main
} // end of class
