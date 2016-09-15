import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Buffered Reader 활용하기
 */
public class Testinput2Quiz {
	public static void main(String[] args) throws IOException {
		// Buffered Reader를 사용해서 사용자의 입력을 받으세요
		// 숫자3개 입력 받아서 최대값을 출력하세요
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("숫자 3개를 입력하세요.");
		String str = br.readLine();
		int num1 = Integer.parseInt(str);

		str = br.readLine();
		int num2 = Integer.parseInt(str);

		str = br.readLine();
		int num3 = Integer.parseInt(str);

		System.out.println("" + num1 + num2 + num3);

		int max = num1;
		if (max < num2)
			max = num2;
		if (max < num3)
			max = num3;
		System.out.println("최대값은" + max + "입니다");

	}// end of main
}// end of class
