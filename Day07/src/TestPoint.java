/**
 * Ŭ���� ���
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

// �ߺ��� ���̱� ���Ͽ� ������ ����ϴ� Ŭ������ ��Ȱ��
class Point {// 2���� ��ǥ���� ���� ǥ���ϱ� ���� Ŭ����
	int x;
	int y;

}

class Point3D extends Point {// 3���� ��ǥ���� ���� ǥ���ϱ� ���� Ŭ����
	// int x;
	// int y;
	int z;

}