import java.util.Random;
import java.util.Scanner;

/**
 * 숫자게임 UpDown
 */
public class TestUpDown {
	public static void main(String[] args) {
		// 컴퓨터가 랜덤으로 생성한 숫자(0~99)를 사용자가 맞출 수 있도록
		// Up or Down 정보를 제공해주고, 맞춘 횟수를 마지막에 출력하시오

		Random ran = new Random();
		int num = ran.nextInt(100);
		System.out.println("컴퓨터가 랜덤으로 생성한 값 :" + num);
		Scanner scan = new Scanner(System.in);
		System.out.println("당신의 생년월일을 입력해주세요");

		int user = scan.nextInt();
		int count = 0;
		while (true) {
			System.out.println("0부터 99까지 숫자를 입력해주세요");
			user = scan.nextInt();
			count++;
			if (user == num) {// 맞춤
				// 몇 번만에 맞췄는지 출력
				System.out.println(count + "번 만에 맞췄습니다");
				break;
			} else if (user < num) {
				System.out.println("Up");
			} else { // user>num)
				System.out.println("Down");
			}

		}
		System.out.println("게임종료");

	}// end of main
}// end of class
