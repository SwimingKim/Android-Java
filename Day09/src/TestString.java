/**
 * ������ Ŭ���� - String
 */
public class TestString {
	public static void main(String[] args) {

		// 123456789
		String str = "abcdefghij";
		String str2 = new String("abcdefghij");
		// str1.value = "Sdfsf";

		System.out.println("d");
		p("str");// toString()�� �����Ǿ� ����
		p(str.toString());// ����� ���ڿ� ���
		p(str.charAt(3) + "");// �ش� �ε��� ��°�� ���ڸ� ����
		p(str.contains("cdef") + "");// �ش繮�ڿ��� ���Կ��� ����
		p(str.equals(str2) + "");// ���ڿ��� ���빰 ��
		p(str.indexOf("cde") + "");// ���ڿ��� ������ġ, ���ڿ��� �� ã���� -1
		p(str.length() + "");// ���ڿ��� ����
		p(str.replace("ef", "xx"));// ���ڿ��� ��ü
		p(str.substring(3, 6));// ���ڿ��� �Ϻ� ����(��index�� ����, ��index������)
		p(str.toUpperCase());// �빮�ڷ� ��ȯ
		p("AbCdEdEfGhIj".toLowerCase());// �ҹ��ڷ� ��ȯ
		p(str.concat("Xxx"));// ���ڿ� �̾���̱�

		String str3 = "ȣ����/������/�����/�۾���";
		String[] w = str3.split("/");//
		for (int i = 0; i < w.length; i++) {
			System.out.println(w[i]);
		}

		String str4 = "   ��  ��  ��     ";
		p(str4);
		p(str4.trim());// �յ��� �����̽� �����ϱ�

		// ���� => ���ڿ�
		String s1 = String.valueOf(123);// 123 int => String ����ȯ
		String s2 = String.valueOf(true);//
		p(s1);
		p(s2);

		// ���ڿ� => �⺻��
		int num = Integer.valueOf("123");// Integer.parseInt("123");
		boolean b = Boolean.valueOf("true");// Boolean.parseBoolean("true");
		double d = Double.valueOf("3.14");// Double.parseDouble("3.14");

	}// end of main

	static void p(String s) {
		System.out.println(s);
	}
}// end of class
