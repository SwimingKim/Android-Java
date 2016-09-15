import java.util.Arrays;
import java.util.Random;

/**
 * 섞기
 */
public class TestShuffle {
	public static void main(String[] args) {
		int num[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };// 10개
		// for (int i = 0; i < num.length; i++) {
		// System.out.println(num[i]);
		// }
		System.out.println(Arrays.toString(num));// 배열내용 출력

		Random ran = new Random();

		// 0번째와 index 번째 값을 바꾸자

		for (int i = 0; i < 20; i++) {// 여러번 섞기
			int index = ran.nextInt(num.length);// 0~9
			int temp = num[0];
			num[0] = num[index];
			num[index] = temp;
		}

		System.out.println("섞은 후");
		System.out.println(Arrays.toString(num));

	}// end of main
}// end of class
