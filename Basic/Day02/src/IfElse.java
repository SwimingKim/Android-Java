/**
 * 조건문 : if~else, switch~case, 삼항연산자
 */
public class IfElse {
	public static void main(String[] args) {
		// if문의 조건식은 참, 거짓으로 결과가 나와야 한다
		boolean b = false;
		if (b) {
			// 조건식이 참일 경우 블럭의 실행문을 수행
		}
		if (b) {
			// 조건식이 참일 경우 블럭의 실행문을 수행
		} else {
			// 조건식이 거짓일 경우 블럭의 실행문을 수행
		}

		boolean gender = true;// 여자, 남자는 false
		if (gender) {
			System.out.println("여자");
		} else {
			System.out.println("남자");
		}
		System.out.println(gender ? "여자" : "남자");

		int score = 87;
		if (score == 10 || score == 9) {
			System.out.println("수");
		} else if (score == 8) {
			System.out.println("우");
		} else if (score == 7) {
			System.out.println("미");
		} else if (score == 6) {
			System.out.println("양");
		} else {
			System.out.println("가");
		}

		int number = 87;
		if (number == 100 && number >= 90) {
			System.out.println("수");
		} else if (number >= 80) {
			System.out.println("우");
		} else if (number >= 70) {
			System.out.println("미");
		} else {
			System.out.println("가");
		}

		int num = 7;
		// 짝수, 홀수 판별해서 출력하기
		if (num % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}

		System.out.println((num % 2 == 0) ? "짝수" : "홀수");

		char c = 'w';
		if (c == 'x') {
			System.out.println("엑스입니다");
		} else {
			System.out.println("엑스가 아닙니다");
		}

		// 중첩 if문
		int q = 5;
		if (q > 4) {
			if (q > 6) {// q는 4보다 크고

			} else {// q는 4보다 크고, 6보다 작거나 같다

			}
		} else { // q는 4보다 작거나 같다

		}

		boolean isOn = false;
		if (isOn) {
			System.out.println("켜져있다");
		}

		// 문자열의 비교
		String str = "홍길동";
		if (str.equals("홍길동")) {// 문자열이 같은지 비교
			System.out.println("홍길동 맞습니다");
		}

		// 문자열의 비교
		if (!str.equals("홍길동")) {// 문자열이 다른지 비교
			System.out.println("홍길동이 아닙니다");
		}

	}// end of main
}// end of class
