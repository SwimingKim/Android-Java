import java.util.Random;
import java.util.Scanner;

public class TestStaticMethod {
	public static void main(String[] args) {
		N k = new N();
		k.aa();

		N.bb();// Ŭ������ �̸����� ������ �� �ִ�(��ü ������ �ʿ����)

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		Math.random();// static ����

	}// end of main
}// end of class

class N {
	void aa() {
		System.out.println("aa");
	}

	static void bb() {
		System.out.println("bb");
	}
}
