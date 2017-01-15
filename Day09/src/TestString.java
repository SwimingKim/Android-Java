/**
 * 유용한 클래스 - String
 */
public class TestString {
	public static void main(String[] args) {

		// 123456789
		String str = "abcdefghij";
		String str2 = new String("abcdefghij");
		// str1.value = "Sdfsf";

		System.out.println("d");
		p("str");// toString()이 생략되어 있음
		p(str.toString());// 저장된 문자열 출력
		p(str.charAt(3) + "");// 해당 인덱스 번째의 문자를 리턴
		p(str.contains("cdef") + "");// 해당문자열의 포함여부 리턴
		p(str.equals(str2) + "");// 문자열의 내용물 비교
		p(str.indexOf("cde") + "");// 문자열의 시작위치, 문자열을 못 찾으면 -1
		p(str.length() + "");// 문자열의 길이
		p(str.replace("ef", "xx"));// 문자열의 교체
		p(str.substring(3, 6));// 문자열의 일부 추출(앞index는 포함, 뒤index미포함)
		p(str.toUpperCase());// 대문자로 변환
		p("AbCdEdEfGhIj".toLowerCase());// 소문자로 변환
		p(str.concat("Xxx"));// 문자열 이어붙이기

		String str3 = "호랑이/강아지/고양이/송아지";
		String[] w = str3.split("/");//
		for (int i = 0; i < w.length; i++) {
			System.out.println(w[i]);
		}

		String str4 = "   서  민  규     ";
		p(str4);
		p(str4.trim());// 앞뒤의 스페이스 제거하기

		// 숫자 => 문자열
		String s1 = String.valueOf(123);// 123 int => String 형변환
		String s2 = String.valueOf(true);//
		p(s1);
		p(s2);

		// 문자열 => 기본형
		int num = Integer.valueOf("123");// Integer.parseInt("123");
		boolean b = Boolean.valueOf("true");// Boolean.parseBoolean("true");
		double d = Double.valueOf("3.14");// Double.parseDouble("3.14");

	}// end of main

	static void p(String s) {
		System.out.println(s);
	}
}// end of class
