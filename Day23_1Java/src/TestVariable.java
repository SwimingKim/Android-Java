/**
 * ����
 */
public class TestVariable {
	public static void main(String[] args) {
		// ���� : �⺻�� Ÿ��(8), ������ Ÿ��(�⺻���� �ƴ� ������ ���)

		// ������ : byte(1), short(2), "int"(4), long(8)
		// �Ǽ��� : float(4), "double"(8)
		// ������ : char(2)
		// ���� : boolean(1)

		int a;
		a = 3;
		int b = 3;
		int c, d, e;// ���� Ÿ���� ���� ������ �ĸ������ڷ� �Ѳ����� �� �� �ִ�
		int f = 5, t;

		long u = 1000000000000l;// ���ͷ� ���̻� l, L
		float ff = 3.14568920f;// ���ͷ� ���̻� f, F
		double dd = 3.14;// ���ͷ� ���̻� d, D, ��������
		dd = 3.0;
		dd = 3;
		dd = 0;// ������(�ڵ�) ����ȭ (int -> double)
		dd = .7;

		final boolean SEX = false;// ���

		char cc = 'c';// �� ���ڸ� ���尡��

		String str = "asdg";// ���ڿ��� �����ϴ� String Ŭ������ �̿��Ѵ�
		str = 4 + 3 + "ab" + 7;// 7ab7
		str = 4 * 3 + "ab" + 7;// 12ab7
		System.out.println(str);

	}// end of main
}// end of class
