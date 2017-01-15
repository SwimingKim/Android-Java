/**
 * 콜스택
 */
public class TestCallStack {
	public static void main(String[] args) {
		System.out.println("main시작");

		new TT().first();

		System.out.println("main끝");

	}// end of main
}// end of class

class TT {
	void first() {
		System.out.println("1시작");
		second();
		System.out.println("1끝");
	}

	void second() {
		System.out.println("2시작");
		third();
		System.out.println("2끝");
	}

	void third() {
		System.out.println("3시작");

		System.out.println("3끝");
	}
}
