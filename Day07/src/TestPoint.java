/**
 * 클래스 상속
 */
public class TestPoint {
	public static void main(String[] args) {
		Point pp = new Point();
		pp.x = 3;
		pp.y = 4;

		System.out.println(pp.x + "," + pp.y);

		Point3D ppp = new Point3D();
		ppp.x = 10;
		ppp.y = 20;
		ppp.z = 30;
		System.out.println(ppp.x + "," + ppp.y + "," + ppp.z);

	}// end of main
}// end of class

// 중복을 줄이기 위하여 기존에 사용하던 클래스를 재활용
class Point {// 2차원 좌표계의 점을 표현하기 위한 클래스
	int x;
	int y;

}

class Point3D extends Point {// 3차원 좌표계의 점을 표현하기 위한 클래스
	// int x;
	// int y;
	int z;

}