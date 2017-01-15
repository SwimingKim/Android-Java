/**
 * Object 클래스 : 모든 클래스의 최고 조상 클래스 자바는 단일상속만을 허용한다 : 자바의 명확성(애매모호한 사항에서 발생할 오류를
 * 제거) 아무것도 상속받지 않은 클래스는 extends Object를 삽입해서, 모든 클래스가 Object를 상속받음
 */
public class TestEquals {
	public static void main(String[] args) {
		String str1 = "홍길동"; // String 클래스만 이런 방식의 생성을 허용한다(주소)
		String str2 = "홍길동";
		if (str1 == str2) {
			System.out.println("== 결과 같음");// 같음
		} else {
			System.out.println("== 결과 다름");
		}
		/////////////////////////////////////////////////////////////
		String str3 = new String("민규쌤");// 객체 생성의 원칙(상수풀)
		String str4 = new String("민규쌤");
		if (str3 == str4) {
			System.out.println("== 같음");
		} else {
			System.out.println("== 다름");// 결과
		}
		// 객체(문자열)의 내용물을 비교하려면 equals() 메서드를 사용해야 함
		if (str3.equals(str4)) {
			System.out.println("equals 같아요");// 결과
		} else {
			System.out.println("equals 달라요");
		}

		Car c1 = new Car();
		Car c2 = new Car();
		c1.door = 4;
		c1.연비 = 21.0;
		c2.door = 4;
		c2.연비 = 21.0;

		if (c1 == c2) {
			System.out.println("== 같음");
		} else {
			System.out.println("== 다름");// 결과
		}

		if (c1.equals(c2)) {// equals() 사용하려면 overriding 해야 한다
			System.out.println("equals 같음");
		} else {
			System.out.println("equals 다름");// 결과
		}

	}// end of main
}// end of class

class Car {
	int door;
	double 연비;

	@Override
	public boolean equals(Object obj) {
		Car c = (Car) obj;// Car 객체를 꺼내려면 형변환해야한다
		if (this.door == c.door && this.연비 == c.연비) {
			return true;
		} else
			return false;
	}
}
