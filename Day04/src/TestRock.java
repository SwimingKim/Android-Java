import java.util.Random;
import java.util.Scanner;

/**
 * 가위바위보 게임 - 사용자가 가위,바위,보 중 하나를 입력, 사용자가 이겼는지 출력
 */
public class TestRock {
	public static void main(String[] args) {
		// 사용자 입력 문자열로 받기
		// 문자열 비교
		// 랜덤으로 값 생성

		Scanner scan = new Scanner(System.in);
		System.out.println("가위, 바위, 보 중 하나를 입력하세요");
		String user = scan.nextLine();
		System.out.println("당신은 " + user + "입니다");

		Random ran = new Random();
		int com = ran.nextInt(3);// 0 가위, 1 바위, 2 보
		System.out.println("컴퓨터는 " + com + "입니다");

		switch (user) {
		case "가위":
			if (com == 0)
				System.out.println("비겼습니다");
			else if (com == 1)
				System.out.println("졌습니다");
			else
				System.out.println("이겼습니다");
			break;
		case "바위":
			if (com == 0)
				System.out.println("이겼습니다");
			else if (com == 1)
				System.out.println("비겼습니다");
			else
				System.out.println("졌습니다");
			break;
		case "보":
			if (com == 0)
				System.out.println("졌습니다");
			else if (com == 1)
				System.out.println("이겼습니다");
			else
				System.out.println("비겼습니다");
			break;
		default:
			System.out.println("잘못 입력하셨습니다");
			break;
		}

	}
}
