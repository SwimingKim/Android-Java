/**
 * static �޼��� Ư¡ static ���(����, �޼���)�� non-static ����� ����� �� ����
 */
public class TestStaticMethod2 {
	int b = 4;// ��������
	// static int b;
	// static�� �����

	public static void main(String[] args) {
		int a = 3;// ��������
		a = 4;
		// TestStaticMethod2 t = new TestStaticMethod2();
		// b =4; //static ���(����, �޼���)�� non-static ����� ����� �� ����

	}// end of main
}// end of class

class DD {
	static int s = 4;
	static int t = s;

	int d = s;// non-static����
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