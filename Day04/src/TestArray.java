/**
 * 변수 :하나의 데이터를 저장할 수 있는 기억공간 마지막에 저장된 데이터만 기억 배열 : 여러개의 (같은 타입의) 변수들의 묶음 반복문으로도
 * 사용가능
 */
public class TestArray {
	public static void main(String[] args) {
		int a;// 변수 선언
		a = 3;// 변수의 초기화

		int b[];// 배열 변수 선언
		b = new int[3];// 배열 변수 생성
		b[0] = 5;
		b[1] = 9;
		b[2] = 7;
		// b={5,9,7};//처음 배열 변수 선언이세만 한번에 처리가능하다.

		System.out.println(b[1]);// 9

		int c[] = { 5, 9, 7 };// 배열 변수 선언, 생성, 초기화를 한 번에
		System.out.println(c[0]);
		System.out.println(c[1]);
		System.out.println(c[2]);

		for (int i = 0; i < 3; i++) {
			System.out.println(c[i]);
		}

		// 정수배열(원소개수는 5개)을 선언, 생성, 초기화 후
		// 반복문을 사용해서 총점과 평균을 출력하시오

		int jumsu[] = { 5, 8, 3, 2, 7 };
		int sum = 0;
		int mid = sum / 5;
		for (int i = 0; i < 5; i++) {
			sum = sum + jumsu[i];
		}
		System.out.println("총점은 " + sum);
		System.out.println("평균은 " + sum / jumsu.length);

		System.out.println(jumsu.length);// 배역의 크기(원소의 개수)

		int num[] = { 9, 5, 7 };// 최대값을 출력하시오.
		int max = num[0];
		if (max <= num[1])
			max = num[1];
		if (max <= num[2])
			max = num[2];
		System.out.println(max);

		for (int i = 0; i < num.length; i++) {
			if (max <= num[i])
				max = num[i];
		}
		System.out.println(max);

	}// end of main
}// end of class
