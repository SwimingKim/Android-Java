import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {

		// 정수를 3개 사용자 입력을 받아
		// 큰 수를 출력

		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 3개 입력하세요");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();

		// System.out.println(num1>num2? num1 : num2);
		System.out.println(num1 > num2 ? (num1 > num3 ? num1 : num3) : (num2 > num3 ? num2 : num3));
		// 코드가 복잡해지면 삼항연산자는 쓰지 않는다

		if (num1 > num2) {// 변수가 많아지면 헤깔린다
			if (num1 > num3) {
				System.out.println(num1);
			} else
				System.out.println(num3);
		} else {
			if (num2 > num3) {
				System.out.println(num2);
			} else
				System.out.println(num3);
		}

		// 최대, 최소를 찾을 경우
		int max = num1;// 최대값을 저장할 변수
		if (max < num1)
			max = num1;
		if (max < num2)
			max = num2;
		if (max < num3)
			max = num3;
		System.out.println(max);

		// 최소값을 찾는 경우
		int min = num1;
		if (min > num1)
			min = num1;
		if (min > num2)
			min = num2;
		if (min > num3)
			min = num3;

		char x = '6';
		if (x > 0 && x <= 9) {
			System.out.println("숫자");
		} else {
			System.out.println("숫자아님");
		}

	}// end of main
}// end of class
