import java.util.Arrays;

import javax.naming.StringRefAddr;

public class Test2 {
	public static void main(String[] args) {
		// 배열 data의 원소를 역순으로 배열 data2에 저장 후 data2를 출력

		int data[] = { 3, 7, 2, 1, 5, 9, 4 };
		int data2[] = new int[data.length];
		for (int i = 0; i < data.length; i++) {
			data2[i] = data[data.length - (i + 1)];
		}
		System.out.println(Arrays.toString(data2));

	}// end of main
}// end of class
