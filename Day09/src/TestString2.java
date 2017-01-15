/**
 * 퇴근문제 String
 */
public class TestString2 {
	public static void main(String[] args) {
		// 0123456789
		String str1 = new String("HelloWorld");
		// oWorl
		System.out.println(str1.substring(4, 9));
		// 문자열 길이 출력
		System.out.println(str1.length() + "");
		// 문자열을 역순으로 출력
		int count[] = new int[10];
		for (int i = str1.length() - 1; i >= 0; i--) {
			System.out.print(str1.charAt(i));
		}
		System.out.println();
		// 일부 값 변경
		System.out.println(str1.replace("ll", "LL"));
		// HELLOWORLD
		System.out.println(str1.toUpperCase());
		// helloworld
		System.out.println(str1.toLowerCase());

	}// end of main
}// end of class
