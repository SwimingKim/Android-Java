/**
 * String이 연산속도가 느리다 StringBuffer (싱글 쓰레드 용) StringBuilder(멀티 쓰레드 용)
 */
public class TestStringBuffer {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("abc");// 문자열 크기 + 버퍼 16

		System.out.println(sb.length());// 문자열의 길이
		System.out.println(sb.capacity());// 문자열 크기 + 버퍼 크기
		System.out.println(sb.charAt(2));
		System.out.println(sb.delete(1, 2));// 삭제, 1포함 2미포함
		System.out.println(sb);// 처리된 값이 저장되어버린다
		System.out.println(sb.insert(1, "helloworld"));
		System.out.println(sb);
		// ahelloWorldc
		// 012345678901
		System.out.println(sb.substring(4, 8));// 저장 안됨
		System.out.println(sb);
		System.out.println(sb.reverse());// 역순으로 출력

		// 퀴즈
		String str = "HelloWorld";
		// 역순으로 출력하시오
		StringBuffer sb2 = new StringBuffer(str);// String=>StringBuffer
		sb2.reverse();
		System.out.println(sb2.toString());

	}// end of main
}// end of class
