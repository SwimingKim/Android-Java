/**
 * ��ٹ���2 : �ݺ���
 */
public class Quiz2 {
	public static void main(String[] args) {

		// �ݺ���, ����Լ�
		// 15�� 10�������� 3�������� �ٲ㼭 ���

		int num = 19;
		int base = 3;

		System.out.println(dap1(num, base));// �ݺ������� ������ȯ
		System.out.println(dap2(num, base));// ����Լ��� ������ȯ

	}// end of main

	static String dap2(int num, int base) {
		if (num == 0)
			return "";
		else
			return dap2(num / base, base) + (num % base);
	}

	static String dap1(int num, int base) {
		String dap = "";// ����� ���ڿ�
		while (num != 0) {
			dap = num % base + dap;
			num = num / base;
		}
		return dap;
	}
}// end of class
