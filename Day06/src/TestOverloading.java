/**
 * (메서드)오버로딩 : 하나의 클래스에서 같은 이름의 메서드명을 허용하는 기법 조건 : 인자값의 개수, 또는 타입, 또는 순서가 달라야
 * 한다.
 */
public class TestOverloading {
	public static void main(String[] args) {

		System.out.println(new CC().add(3));
		System.out.println(new CC().add(3, 8));
		System.out.println(3);
		System.out.println(3.14);
		System.out.println("sdfkd");
		System.out.println('d');
		new CC().add();
		new CC().add(true);

	}// end of main
}// end of class

class CC {
	// int add(int a, int b){
	// return 0;
	// }

	void add(boolean a) {
	}

	void add(double a) {
	}

	void add(double a, double b) {
	}

	void add() {
	}

	void add(double a, boolean b) {
	}

	void add(boolean a, double b) {
	}

	int add(int a, int b) {
		int x = a + b;
		return x;
	}

	int add(int a) {
		int x = a + 3;
		return x;
	}

}