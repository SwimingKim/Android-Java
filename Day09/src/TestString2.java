/**
 * ��ٹ��� String
 */
public class TestString2 {
	public static void main(String[] args) {
		// 0123456789
		String str1 = new String("HelloWorld");
		// oWorl
		System.out.println(str1.substring(4, 9));
		// ���ڿ� ���� ���
		System.out.println(str1.length() + "");
		// ���ڿ��� �������� ���
		int count[] = new int[10];
		for (int i = str1.length() - 1; i >= 0; i--) {
			System.out.print(str1.charAt(i));
		}
		System.out.println();
		// �Ϻ� �� ����
		System.out.println(str1.replace("ll", "LL"));
		// HELLOWORLD
		System.out.println(str1.toUpperCase());
		// helloworld
		System.out.println(str1.toLowerCase());

	}// end of main
}// end of class
