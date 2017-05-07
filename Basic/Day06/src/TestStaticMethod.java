import java.util.Random;
import java.util.Scanner;

public class TestStaticMethod {
	public static void main(String[] args) {
		N k = new N();
		k.aa();

		N.bb();// 클래스의 이름으로 접근할 수 있다(객체 생성할 필요없다)

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		Math.random();// static 정의

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
