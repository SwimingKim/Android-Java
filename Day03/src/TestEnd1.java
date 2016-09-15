import java.util.Scanner;

/**
 * 활용문제
 */
public class TestEnd1 {
	public static void main(String[] args) {

		// 사용자 입력을 받아
		// 2의 배수이면 "2의 배수입니다" 출력
		// 3의 배수이면 "3의 배수입니다" 출력
		// 6의 배수이면 "6의 배수입니다" 출력

		// Scanner scan = new Scanner(System.in);
		// System.out.println("숫자를 입력하세요");
		// int num = scan.nextInt();
		// if(num%6==0){
		// System.out.println("6의 배수입니다");
		// } else if(num%3==0){
		// System.out.println("3의 배수입니다");
		// } else if(num%2==0){
		// System.out.println("2의 배수입니다");
		// }

		// switch case
		// 안내문구 출력
		// 좋아하는 과일을 고르세요
		// 1. 사과
		// 2. 오렌지
		// 3. 바나나
		// 4. 수박
		// 사용자 입력을 받아
		// 1이면 "사과를 선택하셨습니다" 출력
		// 2이면 "오렌지를 선택하셨습니다" 출력
		// 3이면 "바나나를 선택하셨습니다" 출력
		// 4이면 "수박을 선택하셨습니다" 출력
		// 1~4 이외의 값이면 "잘못 입력하셨습니다" 출력

		Scanner scan = new Scanner(System.in);
		System.out.println("좋아하는 과일을 고르세요");
		System.out.println("1. 사과");
		System.out.println("2. 오렌지");
		System.out.println("3. 바나나");
		System.out.println("4. 수박");

		int num = scan.nextInt();
		switch (num) {
		case 1:
			System.out.println("사과를 선택하셨습니다");
			break;
		case 2:
			System.out.println("오렌지를 선택하셨습니다");
			break;
		case 3:
			System.out.println("바나나를 선택하셨습니다");
			break;
		case 4:
			System.out.println("수박을 선택하셨습니다");
			break;
		default:
			System.out.println("잘 못 입력하셨습니다");
			break;
		}

	}// end of main
}// end of class
