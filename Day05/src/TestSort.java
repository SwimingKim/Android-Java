import java.util.Arrays;

/**
 * sort : 정렬
 */
public class TestSort {
	public static void main(String[] args) {
		// {3,1,4,7,8,2,4,2,4,2,3,8,1}
		// 오름차순으로 정렬하시오.

		// 선택정렬
		int num[] = { 3, 1, 4, 7, 8, 2, 4, 2, 4, 2, 3, 8, 1 };

		// 정렬 - 삽입정렬 (최소값, 교환)

		// 최소값을 찾는다
		int minIndex;
		for (int i = 0; i < num.length; i++) {
			minIndex = i;
			for (int j = i + 1; j < num.length; j++) {
				if (num[minIndex] > num[j])
					minIndex = j;
			}
			// 찾은 최소값은 첫번째 결과를 교환한다
			// swap : i번째 값과 minIndex번째의 값을 교환
			int temp = num[i];
			num[i] = num[minIndex];
			num[minIndex] = temp;

		}

		System.out.println(Arrays.toString(num));// 정렬된 값 출력

	}// end of main
}// end of class
