/**
 * static 메서드 특징 static 멤버(변수, 메서드)는 non-static 멤버를 사용할 수 없다
 */
public class TestStaticMethod2 {
	int b = 4;// 전역변수
	// static int b;
	// static을 지운다

	public static void main(String[] args) {
		int a = 3;// 지역변수
		a = 4;
		// TestStaticMethod2 t = new TestStaticMethod2();
		// b =4; //static 멤버(변수, 메서드)는 non-static 멤버를 사용할 수 없다

	}// end of main
}// end of class

class DD {
	static int s = 4;
	static int t = s;

	int d = s;// non-static변수
	// static int q = d;

	void xx() {
		d = 4;
		yy();
	}

	void www() {
		xx();
	}

	static void yy() {
		// d = 4;
		zz();
	}

	static void zz() {

	}

}