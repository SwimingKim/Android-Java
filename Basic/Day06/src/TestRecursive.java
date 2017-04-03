/**
 * 재귀함수
 */
public class TestRecursive {
	public static void main(String[] args) {
		int n = 8;
		long da = 1;
		for (int i = 1; i <= 19; i++) {
			da = da * i;
		}
		System.out.println(da);
		long x = new M().re(25);
		System.out.println(x);

	}// end of main
}// end of class

class M {
	long re(long n) {// 재귀함수 -탈출포인트를 작성해야한다
		if (n == 1) {
			return 1;
		} else {
			return n * re(n - 1);
		}
	}

}