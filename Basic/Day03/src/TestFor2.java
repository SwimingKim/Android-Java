/**
 * 다중 for
 */
public class TestFor2 {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.println(i + "," + j);
			}
		}

		// 구구단
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (i * j < 10) {
					System.out.println(i + "*" + j + "=" + " " + i * j);
				} else
					System.out.println(i + "*" + j + "=" + i * j);
			}
		}

		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + "*" + j + (i * j < 10 ? "= " : "=") + i * j);
			}
		}

		// printf문 사용하기
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d*%d=%3d\n", i, j, i * j);
				// \n 한줄 내리고, %d는 숫자, %f는 문자열, %3은 3자리숫자
			}
		}

		// 3.142
		final double PI = 3.141592;
		System.out.println(PI);
		System.out.println((int) ((PI + 0.0005) * 1000) / 1000.);
		System.out.printf("%10.3f", PI);

	}// end of mainx
}// end of class
