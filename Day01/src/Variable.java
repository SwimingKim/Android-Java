/**
 * 변수 - 메모리에 데이터를 저장
 */
public class Variable {
	public static void main(String[] args) {
		// 변수의 종류 - 정수, 실수, 문자, 논리형(참,거짓)
		// 기본형 타입변수 - 정수 : byte(1), short(2), "int(4)", long(8)
		// 실수 : float(4), "double(8)"
		// 문자 : char(2)
		// 논리 : boolean(1)

		int a, a2, a3; // 컴마연산자 - 같은 타입변수를 한번에 선언가능
		int b; // 변수의 선언
		boolean c;
		long d;

		b = 3; // 초기화 : 변수에 값을 처음 넣는 작업

		int f = 4; // 선언과 초기화를 한번에
		System.out.println(4444);
		System.out.println(f); // 변수를 출력하면 저장된 데이터가 출력됨
		f = 7; // 변수는 마지막에 저장된 데이터만 기억한다
		System.out.println(f);

		short s = 5;
		byte bb = 4;
		System.out.println(s);
		long y = 10L; // 리터럴 접미사 l, L
		System.out.println(y); // 10 만 출력됨

		float tt = 3.14f; // 리터럴 접미사 f, F
		double dd = 3.14; // 리터럴 접미사 d, D, 안붙여도 됨

		char cc = 'a'; // 문자 한글자를 저장한다 '' 작은따옴표로 싸준다
		// char cc2= ''; // 한글자를 넣어야한다
		// char cc3= 'abc'; // 한글자만 가능하다
		char cc4 = ' '; // 스페이스바 한글자로 인식

		boolean zz = true; // 참(true)과 거짓(false)만 저장가능
		System.out.println(zz); // true

		// 자바의 기본형 타입 8개
		// 기본형타입이 아닌 변수 = 참조형 타입
		String str; // 문자열 변수 선언
		str = "sdfd"; // 초기화

		String str2 = "abcd"; // 변수의 선언과 초기화를 한번에
		System.out.println(str2);

		str2 = "xxx"; // 마지막 저장된 데이터만 기억한다
		str2 = ""; // 빈 문자열도 가능하다

		// 문자열의 덧셈연산
		str2 = "a" + "bc"; // 문자열을 이어붙여준다
		str2 = "w" + 6; // 문자열 + 비문자열 => 문자열로 바꿔서 덧셈해준다
		// "w" + "6"
		// "w6"
		str2 = true + "a";
		// "true"+ "a"
		// "truea"
		str2 = 7 + 3 + "a" + 6;
		System.out.println(str2); // 10a6
		System.out.println(xx3 + 55); // null55

		// 상수 : 변하지 않는 수, 변수
		final float PI = 3.14f; // 상수선언, 프로그램 종료시까지 값이 일정
		// pi = 0; // 상수는 값을 변경하면 에러
		// 상수명은 전체를 모두 대문자 표시(권장)

		float f3 = 3.f;

		// 변수명 명명규칙 (필수)
		// 변수명은 대소문자 구분됨, 길이 제한이 없다 Aa, aa 서로 다른변수로 인식함
		// 예약어는 사용할 수 없다
		// 숫자로 시작하면 안된다 7up 은 안된다
		// 특수문자는 변수명으로 사용불가, _ $ 두가지는 허용

		// 형변환 casting : 데이터의 타입을 변경
		int w = (int) 3.14; // 명시적 형변환 : 값의 손실이 있을 때
		float p = 3; // 묵시적 형변환 : 값의 손실이 없을 때
		float p2 = (float) 3.14; // 명시적 형변환 : 값의 손실이 있을 때

	} // end of main

	static String xx3;
} // end of class
