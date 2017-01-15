import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 사용자의 입력을 받는 방법2
 */
public class Testinput2 {
	public static void main(String[] args) throws IOException {
		// 사용자의 입력을 키보드로투터 받기 위햇 객체를 선언한다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("당신의 이름을 입력하세요");// 문자열로만 입력받을 수 있다.
		String name = br.readLine();// 문자열로만 입력받을 수 있다
		// 익셉션 처리를 한다
		System.out.println("당신의 이름은:" + name);

		System.out.println("당신의 나이를 입력하세요.");
		String str = br.readLine();
		// Buffered Reader는 무조건 문자열로만 입력을 받아준다
		// 숫자를 사용하고 싶으면, 받은 문자열을 =>숫자로 변환해야 한다

		int age = Integer.parseInt(str);// 문자열=>숫자로 변환
		System.out.println(age);

		// 숫자=>문자열
		String a = 26 + "";

	}// end of main
}// end of class
