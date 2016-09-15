import java.util.Scanner;

public class Fighting {
	public static void main(String[] args) {
		// 사용자의 입력을 받아서 문제의 개수를 정하고
		// 해당 케이스별로 1까지 도달하는 방법 중에서
		// 가장 큰수와 가장 작은 수를 구해보자

		System.out.println("총 문제의 개수를 입력하세요");
		Scanner scan = new Scanner(System.in);
		int T = Integer.valueOf(scan.nextLine());

		for (int i = 1; i <= T; i++) {
			System.out.println("");
			System.out.println("숫자를 입력하시죠");
			int num = Integer.valueOf(scan.nextLine());
			int count = 1;

			for (int j = 1; j <= 1000000; j++) {// 특정한 숫자가 1까지 가는 경로 구하기
				count = 1;
				while (num != 1) {
					count++;
					if (num % 2 == 0) {
						num = num / 2;
						System.out.print("짝수" + num);
						continue;
					} else {
						num = num * 3 + 1;
						System.out.print("홀수" + num);
						continue;
					}
				}
			}
			System.out.println("");
			System.out.println(num + "가 1까지 가는 수는 " + count);

			System.out.println("");
			System.out.println("CASE " + i);
			System.out.println(count + "");

		}

		// for (int i = 0; i < 100000000; i++) {
		// int count = 1;
		// System.out.println("숫자를 입력하세요");
		// int num = Integer.valueOf(scan.nextLine());
		//
		// int dap = 0;
		// for (int j = 1; j <= 20; j++) {
		// count=1;
		// while (num!=1) {
		// count++;
		// if (num%2==0) {
		// num=num/2;
		// System.out.print("짝수"+num);
		// continue;
		// } else {
		// num=num*3+1;
		// System.out.print("홀수"+num);
		// continue;
		// }
		// }
		// dap=count;
		// }
		// System.out.println(dap+"");
		//
		//
		//
		//
		// }
		//

	}// end of main
}// end of class
