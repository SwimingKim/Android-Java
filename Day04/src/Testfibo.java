import java.util.Arrays;

/**
 * 피보나치 수열 - 1, 1, 2, 3, 5, 8
 */
public class Testfibo {
	public static void main(String[] args) {
		// 피보나치 수열 20개를 출력하시오.//6765

		int fibo[] = new int[20];// 배열변수 선언, 생성
		fibo[0] = 1;
		fibo[1] = 1;
		for (int i = 2; i < fibo.length; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}
		System.out.println(Arrays.toString(fibo));

	}// end of main
}// end of class
