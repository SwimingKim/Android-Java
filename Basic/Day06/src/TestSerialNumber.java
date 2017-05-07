/**
 * static 활용 제품의 고융한 정보를 나타내기 위해서 Serial Number
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

class Product {// 제품
	static int count = 0;// 현재까지 제품 몇번째까지 사용했는지 기억할 변수
	int SN;// 시리얼 넘버

}