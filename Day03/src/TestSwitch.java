/**
 * 흐름 제어 : if, switch, 삼항연산자
 */
public class TestSwitch {
	public static void main(String[] args) {
		int num = 4;

		switch (num) {// 조건값으로 들어갈 수 있는 것, int 범위 이하 숫자,
		case 3:
			System.out.println(3);
			break;
		case 4:
			System.out.println(4);
			break;// switch문을 빠져나간다
		case 5:
			System.out.println(5);
			break;
		}

		int jumsoo = 8;
		// 10, 9 수 8 우 7 미 6 양 나머지 (1~5) 가

		int jungsoo = 8;
		switch (jungsoo) {
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

		default:// 해당되는 case값이 없을 경우 수행됨
			System.out.println("기본값");
			break;
		}

		// 100~90 수 89~80 우 79~70 미 69~60 양 59~0 가
		int jumsu = 89;

		switch (jumsu / 10) {
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
		default:
			if (jumsu >= 0 && jumsu <= 100)
				System.out.println("가");
			break;
		}

	}// end of main
}// end of class
