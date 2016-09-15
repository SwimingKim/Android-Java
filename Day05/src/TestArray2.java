
public class TestArray2 {
	public static void main(String[] args) {
		int a[];// 배열변수의 선언
		// int []a;
		a = new int[4];// 배열변수의 생성 -> 각 타입의 기본값이 저장된다
		// 기본형타입, 정수 - 0, 실수 -0.0, 문자 - '\u0000', 논리 - false
		// 참조형타입, null (String, System, Scanner)
		a[0] = 3;
		// a[4]=5; 배열 인덱스 범위 (0~3)를 벗어나서 에러발생
		System.out.println(a[0]);

		int b[] = { 1, 2, 3 };// 배열의 선언, 생성, 초기화를 한 번에
		// 컴파일러가 하는 일 정리(문장을 기계가 이해할 수 있도록 기계어로 바꾸기, 그 외에도 형변환)

		int c[][];// 2차원 배열
		// int [][]c;
		// int []c[];
		c = new int[2][3];
		c[0][0] = 1;
		c[0][1] = 2;
		c[0][2] = 3;
		c[1][0] = 4;
		c[1][1] = 5;
		c[1][2] = 6;

		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				System.out.println(i + "." + j + "=" + c[i][j]);
			}
		}

		int d[][] = { { 1, 2, 3 }, { 4, 5, 6 } };// 2행3열

	}// end of main
}// end of class
