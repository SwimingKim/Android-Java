/**
 * �ݽ���
 */
public class TestCallStack {
	public static void main(String[] args) {
		System.out.println("main����");

		new TT().first();

		System.out.println("main��");

	}// end of main
}// end of class

class TT {
	void first() {
		System.out.println("1����");
		second();
		System.out.println("1��");
	}

	void second() {
		System.out.println("2����");
		third();
		System.out.println("2��");
	}

	void third() {
		System.out.println("3����");

		System.out.println("3��");
	}
}
