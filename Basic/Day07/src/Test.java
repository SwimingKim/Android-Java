import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		// 구구단 자리수를 맞춰서 2~9단까지 출력하시오

		for (int i = 2; i <= 9; i += 2) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d*%d=%2d\t", i, j, i * j);
				System.out.printf("%d*%d=%2d\n", i + 1, j, (i + 1) * j);
			}
		}

		// 배열을 만들어서 (3,7,1,9,2,5) 저장 후 최대값을 출력하시오.
		int s[] = { 3, 7, 1, 9, 2, 5 };
		int max = s[0];
		for (int i = 1; i < s.length; i++) {
			if (s[i] >= max) {
				max = s[i];
			}
			continue;
		}
		System.out.println("최대값은 " + max);

		int min = s[0];
		for (int i = 1; i < s.length; i++) {
			if (s[i] <= min) {
				min = s[i];
			}
			continue;
		}
		System.out.println("최소값은 " + min);

		// 사용자의 입력을 받아서 4개 받아서
		// 배열에 저장후 총점과 평균을 출력

		Scanner scan = new Scanner(System.in);
		int num[] = new int[4];
		System.out.println("숫자 " + num.length + "개를 입력해주세요");
		int sum = 0;
		for (int i = 0; i < num.length; i++) {
			num[i] = scan.nextInt();
			sum += num[i];
		}
		System.out.println("총점은 " + sum);
		System.out.println("평균은 " + (float) (sum / num.length));

		System.out.println(3 + 4 + "abc" + 5 + 6);

		// System.out.println("\t\a");

	}// end of main
}// end of class
