import java.util.Scanner;

/**
 * swith의 조건 값은 int형 범위 내의 정수만 가능 문자열도 가능하다
 */
public class TestSwitch2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("이름을 입력하세요");

		switch (scan.nextLine()) {
		case "서민규":
			System.out.println("잘생겼습니다");
			break;
		case "문새미":
			System.out.println("이쁩니다");
			break;
		case "홍정택":
			System.out.println("멋집니다");
			break;

		}
	}// end of main
}// end of class
