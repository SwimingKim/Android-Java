/**
 * 반복문:for, while, do~while
 */
public class TestFor {
	public static void main(String[] args) {
		// for(초기식;조건식;증감식){
		// 반복할 문장;
		// }
		// 초기식 -> 조건식 -> 반복할문장 -> 증감식
		// |----------------|

		// System.out.println("******");

		for (int i = 0; i < 3; i++) {
			System.out.println(i);
		}

		// 0,1,2,3,4,5
		for (int i = 0; i < 6; i++) {
			System.out.println(i);
		}

		// 2,4,6,8
		for (int i = 2; i <= 8; i += 2) {
			System.out.print(i);
		}

		System.out.println();

		// 1 3 5 7
		for (int i = 1; i <= 7; i += 2) {
			System.out.print(i + " ");
		}

		// 무한루프
		// for (int i = 0; ; i++) { //조건식을 안 쓰면, 참으로 간주함
		// System.out.println("********");
		// }

		// 무한루프
		// for (int i = 0; i < 2; ) {//i값이 항상 0이므로, 조건은 항상 참이다
		// System.out.println("*****");
		// }

		for (;;) {// 무한루프
			System.out.println("*****");// 조건식 없으면 항상 참
		}

		// 초기식에서 같은 타입의 변수선언을 여러개 할 수 있다.
		// for (int i=1, j=15 ; i < 10 ; i++){
		// System.out.println(i+j+"");
		// };

		// for (int i = 0; i < 3&& i>-1; i++) {
		// System.out.println("ppp");
		// }
	}// end of main
}// end of class
