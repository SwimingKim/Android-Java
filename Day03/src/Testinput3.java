import javax.swing.JOptionPane;

/**
 * ����� �Է¹ޱ�3
 */
public class Testinput3 {
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("�̸��� �Է��ϼ���");

		System.out.println("����� �̸��� " + name + " �Դϴ�");

		String str = JOptionPane.showInputDialog("���̸� �Է��ϼ���");
		int age = Integer.parseInt(str);
		System.out.println("����� ���̴� " + age + "�� �Դϴ�");

	}// end of main
}// end of class
