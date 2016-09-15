import java.lang.invoke.SwitchPoint;

import javax.swing.JOptionPane;

/**
 * �帧���� : if, switch, ���׿�����
 */
public class TestSwitchQuiz {
	public static void main(String[] args) {
		// ������� �Է��� ���ڷ� �޾Ƽ�(�� �Է� 1~12)
		// �� ���� ��¥�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		String str = JOptionPane.showInputDialog("1~12 �߿��� ���ڸ� �Է��ϼ���.");
		int month = Integer.parseInt(str);
		System.out.println("����� ������ ���� " + month + "�� �Դϴ�");

		if (month == 2) {
			System.out.println(28);
		} else if (month == 4 || month == 6) {
			System.out.println(30);
		} else {
			System.out.println(31);
		}

		switch (month) {
		case 2:
			System.out.println(28);
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println(30);
			break;
		default:
			if (month >= 1 && month <= 12)
				System.out.println(31);
		}
	}// end of main
}// end of class
