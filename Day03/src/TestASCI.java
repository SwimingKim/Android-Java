/**
 * ���ڴ� �ڵ尪(����)���� ����ȴ�
 */
public class TestASCI {
	public static void main(String[] args) {
		for (int i = 0; i < 127; i++) {
			System.out.println(i + ":" + (char) i);
		}

		// abcdefgh~z
		for (int i = 'a'; i <= 'z'; i++) {
			System.out.print((char) i);
		}

		char c = 'd';
		// �ҹ������� �빮������ ���
		// �ҹ��ڶ�� => �빮�ڷ� ��ȯ ���
		// �빮�ڶ�� => �ҹ��ڷ� ��ȯ ���

		if (c >= 'A' && c <= 'Z') {
			System.out.println("�빮���Դϴ�");
			System.out.println((char) (c + ('a' - 'A')));
		} else if (c >= 'a' && c <= 'z') {
			System.out.println("�ҹ����Դϴ�");
			System.out.println((char) (c - ('a' - 'A')));
		} else
			System.out.println("�����Դϴ�");

	}// end of main
}// end of class
