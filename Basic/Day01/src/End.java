import java.util.Arrays;
import java.util.Random;

public class End {
	public static void main(String[] args) {
		// 자신의 나이를 상수에 저장후 출력
		// 자신의 이름을 변수에 저장후 출력

		final int AGE = 26;
		String name = "서민규";
		System.out.println(AGE + " 살");
		System.out.println(name);

		// 숙제 : 오늘 배운 내용 복습 (1. 환경설치, 2. 변수)
		double d = 3.14;
		float f = 3.14f;
		f = (float) d;

		int num[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		int now = 1;
		int dap1[] = new int[16]; // 1에서 16까지
		int dap2[] = new int[16]; // 17에서 32까지
		int dap3[] = new int[16]; // 33에서 48까지
		int dap4[] = { 49, 50 }; // 49에서 50까지

		Random ran = new Random();
		for (int i = 0; i < num.length * 2; i++) {
			int n1 = ran.nextInt(num.length);
			int n2 = ran.nextInt(num.length);

			int temp = num[n1];
			num[n1] = num[n2];
			num[n2] = temp;
		}
		for (int i = 0; i < num.length; i++) {
			dap1[i] = num[i];
		}
		for (int i = 0; i < num.length; i++) {
			dap2[i] = num[i];
		}
		for (int i = 0; i < num.length; i++) {
			dap3[i] = num[i];
		}
		System.out.println(Arrays.toString(dap1));
		System.out.println(Arrays.toString(dap2));
		System.out.println(Arrays.toString(dap3));
		System.out.println(Arrays.toString(dap4));

	} // end of main
} // end of class
