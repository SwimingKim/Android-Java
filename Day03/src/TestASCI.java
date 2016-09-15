/**
 * 문자는 코드값(숫자)으로 저장된다
 */
public class TestASCI {
	public static void main(String[] args) {
		for (int i = 0; i < 127; i++) {
			System.out.println(i + ":" + (char) i);
		}

		// abcdefgh~z
		for (int i = 'a'; i <= 'z'; i++) {
			System.out.print((char) i);
		}

		char c = 'd';
		// 소문자인지 대문자인지 출력
		// 소문자라면 => 대문자로 변환 출력
		// 대문자라면 => 소문자로 변환 출력

		if (c >= 'A' && c <= 'Z') {
			System.out.println("대문자입니다");
			System.out.println((char) (c + ('a' - 'A')));
		} else if (c >= 'a' && c <= 'z') {
			System.out.println("소문자입니다");
			System.out.println((char) (c - ('a' - 'A')));
		} else
			System.out.println("오류입니다");

	}// end of main
}// end of class
