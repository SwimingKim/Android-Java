/**
 * static Ȱ�� ��ǰ�� ������ ������ ��Ÿ���� ���ؼ� Serial Number
 */
public class TestSerialNumber {
	public static void main(String[] args) {

		Product p1 = new Product();
		p1.SN = ++Product.count;
		Product p2 = new Product();
		p2.SN = ++Product.count;

		System.out.println(p1.SN);
		System.out.println(p2.SN);

	}// end of main
}// end of class

class Product {// ��ǰ
	static int count = 0;// ������� ��ǰ ���°���� ����ߴ��� ����� ����
	int SN;// �ø��� �ѹ�

}