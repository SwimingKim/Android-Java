import java.util.Scanner;

public class TestArrayQuiz {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5 };
		// 배열 a를 배열 b로 복사 후 출력하시오.

		int b[];
		b = a;// 배열주소복사//얕은복사
		System.out.println(b[2]);
		b[0] = 100;
		System.out.println(b[0]);
		System.out.println(b[1]);

		// 깊은 복사-새로운 대상을 따로 만든다
		int d[] = new int[5];
		for (int i = 0; i < d.length; i++) {
			d[i] = a[i];// 배열 내용의 복사 - 깊은 복수
		}
		System.out.println(d[4]);
		d[4] = 400;
		System.out.println(d[4]);
		System.out.println(a[4]);

		// 퀴즈 : 3명의 학생의 점수를 입력받아서 총 점을 출력하시오

		Scanner scan = new Scanner(System.in);// 입력받는 객체선언
		int jumsoo[] = new int[3];// 배열 선언 3개짜리
		System.out.println("3명 학생의 점수를 입력해주세요");

		int sum = 0;
		for (int i = 0; i < jumsoo.length; i++) {// 반복문
			jumsoo[i] = scan.nextInt();
			sum += jumsoo[i];
		}

		System.out.println("학생들의 총점은 " + sum);

	}
}
