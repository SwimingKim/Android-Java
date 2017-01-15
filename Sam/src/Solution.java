import java.util.Scanner;
import java.io.FileInputStream;

/* 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */

class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * 아래 메소드 호출은 앞으로 표준입력(키보드) 대신 input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다. 만약 본인의
		 * PC 에서 테스트 할 때는, 입력값을 input.txt에 저장한 후 이 코드를 첫 부분에 사용하면, 표준입력 대신
		 * input.txt 파일로 부터 입력값을 읽어 올 수 있습니다. 또한, 본인 PC에서 아래 메소드를 사용하지 않고 표준입력을
		 * 사용하여 테스트하셔도 무방합니다. 단, Codeground 시스템에서 "제출하기" 할 때에는 반드시 이 메소드를 지우거나
		 * 주석(//) 처리 하셔야 합니다.
		 */
		// Scanner sc = new Scanner(new FileInputStream("input.txt"));

		// 3N+1
		// f(n) = n/2 (n이 짝수)
		// f(n) = 3n+1 (n이 홀수)
		// 2 3 8
		// 전체 문제는 2가지인 경우, 3과 8까지 가는 횟수의 작은 수와 큰 수를 구해여라
		// 1<=t<=32
		// 0<=k<=63

		System.out.println(new Function().result(3) + "");

		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		int count = 0;

		System.out.println("32이내의 숫자를 입력하세요");
		T = Integer.valueOf(sc.nextLine());

		// T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도
			// 됩니다.

			System.out.println("숫자를 입력해주세요");
			int num = Integer.valueOf(sc.nextLine());

			int dap = new Function().result(num);

			if (dap == num) {
				System.out.println("답이 나왔어" + num);
			}

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(dap + "\t");

		}

	}// end of main
}// end of class

class Function {
	int num;

	public Function() {
	}

	public Function(int num) {
		this.num = num;
	}

	int count = 1;

	int result(int num) {// 특정 숫자가 1까지 가는 경로
		int num_og = num;
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
		return count;
	}

	int dap[][];

	int path = 1;
	int num_og;

	int path(int k) {
		for (int num_og = 2; num_og < 63; num_og++) {
			// int num_og;
			while (num_og != 1) {
				num_og++;
				if (num_og % 2 == 0) {
					num_og = num_og / 2;
					System.out.print("-" + num_og);
					continue;
				} else {
					num_og = num_og * 3 + 1;
					System.out.print("-" + num);
					continue;
				}
			}
			dap[path][num_og] = k;
		}

		return num_og;
	}

}
