/**
 * ���ǹ� : if~else, switch~case, ���׿�����
 */
public class IfElse {
	public static void main(String[] args) {
		// if���� ���ǽ��� ��, �������� ����� ���;� �Ѵ�
		boolean b = false;
		if (b) {
			// ���ǽ��� ���� ��� ���� ���๮�� ����
		}
		if (b) {
			// ���ǽ��� ���� ��� ���� ���๮�� ����
		} else {
			// ���ǽ��� ������ ��� ���� ���๮�� ����
		}

		boolean gender = true;// ����, ���ڴ� false
		if (gender) {
			System.out.println("����");
		} else {
			System.out.println("����");
		}
		System.out.println(gender ? "����" : "����");

		int score = 87;
		if (score == 10 || score == 9) {
			System.out.println("��");
		} else if (score == 8) {
			System.out.println("��");
		} else if (score == 7) {
			System.out.println("��");
		} else if (score == 6) {
			System.out.println("��");
		} else {
			System.out.println("��");
		}

		int number = 87;
		if (number == 100 && number >= 90) {
			System.out.println("��");
		} else if (number >= 80) {
			System.out.println("��");
		} else if (number >= 70) {
			System.out.println("��");
		} else {
			System.out.println("��");
		}

		int num = 7;
		// ¦��, Ȧ�� �Ǻ��ؼ� ����ϱ�
		if (num % 2 == 0) {
			System.out.println("¦��");
		} else {
			System.out.println("Ȧ��");
		}

		System.out.println((num % 2 == 0) ? "¦��" : "Ȧ��");

		char c = 'w';
		if (c == 'x') {
			System.out.println("�����Դϴ�");
		} else {
			System.out.println("������ �ƴմϴ�");
		}

		// ��ø if��
		int q = 5;
		if (q > 4) {
			if (q > 6) {// q�� 4���� ũ��

			} else {// q�� 4���� ũ��, 6���� �۰ų� ����

			}
		} else { // q�� 4���� �۰ų� ����

		}

		boolean isOn = false;
		if (isOn) {
			System.out.println("�����ִ�");
		}

		// ���ڿ��� ��
		String str = "ȫ�浿";
		if (str.equals("ȫ�浿")) {// ���ڿ��� ������ ��
			System.out.println("ȫ�浿 �½��ϴ�");
		}

		// ���ڿ��� ��
		if (!str.equals("ȫ�浿")) {// ���ڿ��� �ٸ��� ��
			System.out.println("ȫ�浿�� �ƴմϴ�");
		}

	}// end of main
}// end of class
