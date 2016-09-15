/**
 * 변수
 */
public class TestVariable {
	public static void main(String[] args) {
		// 변수 : 기본형 타입(8), 참조형 타입(기본형이 아닌 나머지 모두)

		// 정수형 : byte(1), short(2), "int"(4), long(8)
		// 실수형 : float(4), "double"(8)
		// 문자형 : char(2)
		// 논리형 : boolean(1)

		int a;
		a = 3;
		int b = 3;
		int c, d, e;// 같은 타입의 변수 선업은 컴마연산자로 한꺼번에 할 수 있다
		int f = 5, t;

		long u = 1000000000000l;// 리터럴 접미사 l, L
		float ff = 3.14568920f;// 리터럴 접미사 f, F
		double dd = 3.14;// 리터럴 접미사 d, D, 생략가능
		dd = 3.0;
		dd = 3;
		dd = 0;// 묵시적(자동) 형변화 (int -> double)
		dd = .7;

		final boolean SEX = false;// 상수

		char cc = 'c';// 한 글자만 저장가능

		String str = "asdg";// 문자열을 관리하는 String 클래스를 이용한다
		str = 4 + 3 + "ab" + 7;// 7ab7
		str = 4 * 3 + "ab" + 7;// 12ab7
		System.out.println(str);

	}// end of main
}// end of class
