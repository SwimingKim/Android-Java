import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * 사용자의 입력받기
 */
public class TestInput {
	public static void main(String[] args) throws IOException {

		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		// System.out.println("입력하세요");
		// String str = br.readLine();
		// System.out.println(str+"입니다");

		// Scanner scan = new Scanner(System.in);
		// System.out.println("입력하세요");
		// String str2 = br.readLine();
		// System.out.println(str2+"입니다");

		String name = JOptionPane.showInputDialog("안녕하세요 이름을 입력하세요");
		System.out.println(name + "이죠?");

	}// end of main
}// end of class
