/**
 * 클래스 활용
 */
public class TestTime {
	public static void main(String[] args) {
		// 출근 시간, 점심 시간, 퇴근 시간
		Time tStart = new Time();
		tStart.h = 10;
		tStart.m = 0;
		tStart.s = 1;
		System.out.printf("%2d:%2d:%2d\n", tStart.h, tStart.m, tStart.s);

		Time tLunch = new Time();
		tLunch.h = 13;
		tLunch.m = 2;
		tLunch.s = 0;
		System.out.printf("%2d:%2d:%2d\n", tLunch.h, tLunch.m, tLunch.s);

		Time tEnd = new Time();
		tEnd.h = 19;
		tEnd.m = 31;
		tEnd.s = 5;
		System.out.printf("%2d:%2d:%2d\n", tEnd.h, tEnd.m, tEnd.s);

	}// end of main
}// end of class

class Time {// 새로운 타입의 정의 : 추상화 작업
	int h;
	int m;
	int s;
}