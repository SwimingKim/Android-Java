import java.util.Scanner;

/**
 * 사용자 입력받기1 - Scanner
 *
 */
public class Testinput {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 사용자입력을 받기 위한 객체를 준비한다(프로그램에서 한번만 선언하면 됨)
		// Scanner 클래스를 import해야한다

		System.out.println("나이를 입력하세요");
		int age = scan.nextInt();// 사용자의 입력을 받아온다
		System.out.println("당신이 입력한 나이는" + age + "살입니다");

		System.out.println("몸무게를 입력하세요");
		int weight = scan.nextInt();
		System.out.println("당신의 몸무게는" + weight + "kg 입니다");

		System.out.println("이름을 입력하세요");
		String name = scan.next();// 문자열 입력받기
		System.out.println("당신의 이름은" + name + "입니다");

	}// end of main
}// end of class
