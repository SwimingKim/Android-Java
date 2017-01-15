/**
 * 연산자
 */
public class Operator {
	public static void main(String[] args) {
		// 연산자, 피연산자 3+4
		// 단항연산자, 이항연산자, 삼항연산자, 대입연산자
		// 단항연산자 : 부호연산자, ()캐스팅연산자, 증감연산자, 논리부정연산자
		// 부호연산자 + -
		int x = 3;
		System.out.println(-x);// 변수 앞에도 부호연산자 사용가능

		// 캐스팅 연산자 : 형 변환 시 사용

		// 증감 연산자 ++ -- 전치증감연산자, 후치증감연산자
		int a = 4;
		++a;// a=a+1;(전치증감연산자)
		System.out.println(a);

		int b = 5;
		System.out.println(b++);// 5 후치증감연산자 : 참조 후 증감
		System.out.println(b);// 6

		b = 5;
		System.out.println(++b);// 6 전치증감연산자 : 증감 후 참조
		System.out.println(b);// 6

		// 논리부정연산자 ! : true, false의 값을 반전시킬 때 사용
		System.out.println(!true);// false
		boolean bb = false;
		System.out.println(!bb);// true

		// 이항연산자 : 산술연산자, 비교연산자, 비트연산자, 논리연산자, 쉬프트연산자
		// 특징 : 두개의 피연산자 타입이 같아야 한다
		// => 두개의 피연산자 타입이 다르면 큰 범위 타입으로 자동형변환해준다
		// => 피연산자와 같은 타입의 결과를 반환한다.

		System.out.println("산술연산자");
		System.out.println(5 + 2);// 7
		System.out.println(5 - 2);// 3
		System.out.println(5 * 2);// 10
		System.out.println(5 / 2);// 2(이항연산자의 특징)
		System.out.println(5 / (float) 2);// 2.5
		System.out.println(5 % 2);// 1 mod 나머지연산자

		// 비교연산자 < > <= >= == !=
		// => 연산결과는 true, false의 값으로 반환
		System.out.println("비교연산자");
		System.out.println(3 < 4);// true
		System.out.println(3 <= 3);// true
		System.out.println(6 == 7);// false
		System.out.println(6 != 7);// true 다른지 비교

		// 비트연산자 &(and) |(or)
		// => 피연산자가 숫자, 논리값도 가능 => true, false로 반환
		System.out.println("비트연산자");
		System.out.println(true & true);// true
		System.out.println(true & false);// false
		System.out.println(false & true);// false
		System.out.println(false & false);// false

		System.out.println(true | true);// true
		System.out.println(true | false);// true
		System.out.println(false | true);// true
		System.out.println(false | false);// false

		// 논리연산자 &&||
		// => 피연산자가 논리값만 가능 => true, false로 반환
		// => 결과 값은 비트연산자와 동일, 효율적인 연산 가능
		System.out.println("논리연산자");
		System.out.println(true && true);// true
		System.out.println(true && false);// false
		System.out.println(false && true);// false
		System.out.println(false && false);// false

		System.out.println(true || true);// true
		System.out.println(true || false);// true
		System.out.println(false || true);// true
		System.out.println(false || false);// false

		// 쉬프트 연산자 << >>

		// 삼항 연산자 (조건식) ? (참일 경우) : (거짓일 경우)
		int t = 3 < 5 ? 5 : 3;
		System.out.println(t);
		System.out.println(3 < 5 ? "5입니다" : 3);

		// 대입연산자 =과 이항연산자의 조합
		int d;
		d = 3;
		d += 4; // d=d+4;
		System.out.println(d);
		d -= 4; // d=d-4
		d *= 4; // d=d*4
		d /= 4; // d=d/4
		d %= 4; // d=d%4
		d |= 4; // d=d|4

		d = 3;
		d *= 4 + 6;// d=d*(4+6)
		System.out.println(d);// 30
		System.out.println(3 ^ 7);// 4

		int r = 3 * 4 * 5;
		int p = 4, e = 5;

		r = p = e;// 우->좌로 연산을 진행한다(대입연산자)
		System.out.println("" + r + p + e);
		System.out.println((-6) * (-7));

		System.out.println(p == 5 && r < e);

	}// end of main
}// end of class
