
public class TestIfElse {
	public static void main(String[] args) {
		// if (조건식) {
		// 조건식이 참일 경우 발생
		// }

		// switch (정수) {// switch문에 사용될 수 있는 조건식 : int범위내의 정수, 문자열도 가능
		// case value:
		//
		// break;
		//
		// default:
		// break;
		// }

		// 수100~90 우89~80 미79~70 양69~60 가59~0 출력
		int jumsoo = 73;
		switch (jumsoo / 10) {
		case 10:
		case 9:
			System.out.println("수");
			break;
		case 8:
			System.out.println("우");
			break;
		case 7:
			System.out.println("미");
			break;
		case 6:
			System.out.println("양");
			break;
		case 5:
		case 4:
		case 3:
		case 2:
		case 1:
			System.out.println("가");
			break;
		default:
			break;
		}

	}// end of main
}// end of class
