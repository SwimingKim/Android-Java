import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 예외처리
 */

// 컴파일러 역할 : 형변환, 임포트, 기본 생성자 작성, 에러 찾는 것, 오버 로딩 허용,
// 자기자신 객체(this) 호출, 부모클래스(super) 호출
public class TestThrow {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();

		new TestThrow().first();
		// try catch

	}// end of main

	void first() {// throws ArithmeticException
		try {
			second();
		} catch (Exception e) {
			System.out.println("세컨드에서 폭탄 처리");
		}
		System.out.println("yyyy");
	}

	void second() throws ArithmeticException {
		// Exception을 직접 처리하지 않고, 나를 호출한 메서드로 Exception 정보를 전달
		System.out.println(3 / 0);
		System.out.println("xxxx");
	}
}// end of class
