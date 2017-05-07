import java.util.Arrays;

/**
 * 퇴근문제
 */
public class Quiz {
	public static void main(String[] args) {

		// 1000~9999 : 범위내의 숫자 중에서 사용된 숫자의 개수를 출력하시오.
		// 10~13 범위내의 숫자
		// 0:1개 1:5개 2:1개 3:1개
		// 1 5 1 1 0 0 0 0 0 0

		int count[] = new int[10]; // 각 숫자의 사용횟수 저장
		for (int i = 1000; i <= 9999; i++) {
			count[i % 10]++;// 일의 자리
			count[i / 10 % 10]++;// 십의 자리
			count[i / 100 % 10]++;// 백의 자리
			count[i / 1000 % 10]++;// 천의 자리
		}
		System.out.println(Arrays.toString(count));
		System.out.println(1234 % 10);
		System.out.println(1234 / 10 % 10);
		System.out.println(1234 / 100 % 10);
		System.out.println(1234 / 1000 % 10);

	}// end of main
}// end of class
