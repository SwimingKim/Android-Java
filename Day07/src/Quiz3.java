import java.util.Arrays;

/**
 * 퇴근문제3 : 정렬
 */
public class Quiz3 {
	public static void main(String[] args) {
		int num[] = { 3, 8, 5, 2, 5, 8, 1, 3, 3, 4 };
		int count[] = new int[10];
		for (int i = 0; i < num.length; i++) {
			count[num[i]]++;
		}
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count[i]; j++) {
				System.out.print(i + " ");
			}
		}

	}// end of main
}// end of class
