
public class TestPermutation {
	public static void main(String[] args) {
		int data[] = { 1, 2, 3 };
		// 1,2,3 모든 순열을 출력하시오.

		// 123
		// 132
		// 213
		// 231
		// 312
		// 321

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j)
					continue;
				System.out.println(
						data[i] + "," + data[j] + "," + (data[i] + data[j] < 4 ? 3 : (data[i] + data[j] == 5 ? 1 : 2)));
			}
		}

		System.out.println("");

		int num[] = { 7, 9, 4 };

		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (i == j)
					continue;
				for (int k = 0; k <= 2; k++) {
					if (i == k || j == k)
						continue;
					System.out.println(num[i] + "," + num[j] + "," + num[k]);
				}
			}

		}

	}// end of main
}// end of class
