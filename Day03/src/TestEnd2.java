import java.util.Scanner;

public class TestEnd2 {
	public static void main(String[] args) {

		// Switch case
		// 안내문구 출력
		// 계산기 프로그램
		// 숫자 연산자 숫자 순서로 입력하세요(연산자는 :, +, -, *, / 4가지입니다)
		// 숫자1, 연산자, 숫자2
		// Switch(연산자)
		// 사용자 입력을 받아
		// '+'이면 덧셈연산 내용 출력
		// '-'이면 뺄셈연산 내용 출력
		// '*'이면 곱셈연산 내용 출력
		// '/'이면 나눗셈연산 내용 출력

		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요");
		int num1 = Integer.parseInt(scan.nextLine());
		System.out.println("연산자를 입력해주세요(연산자는 +, -, *, / 4가지입니다)");
		String op = scan.nextLine();
		System.out.println("숫자를 입력해주세요");
		int num2 = Integer.parseInt(scan.nextLine());

		switch (op) {
		case "+":
			System.out.println(num1 + num2);
			break;
		case "-":
			System.out.println(num1 - num2);
			break;
		case "*":
			System.out.println(num1 * num2);
			break;
		case "/":
			System.out.println(num1 / num2);
			break;
		default:
			System.out.println("오류입니다");
			break;
		}

	}// end of main
}// end of class
