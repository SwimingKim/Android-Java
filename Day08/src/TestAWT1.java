import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * �ڹ��� GUI AWT(Abstract Window Toolkit)
 */
public class TestAWT1 {
	public static void main(String[] args) {
		Frame f = new Frame();// ������â
		// JFrame f = new JFrame();//������â

		f.setTitle("���񺯰� �� �� ����");// Ÿ��Ʋ����
		f.setSize(300, 200);// ũ������
		f.setLocation(100, 100);// ��ġ����
		f.setLayout(null);// ȭ�鿡 ������Ʈ ��ġ�ϴ� ���

		f.setVisible(true);

		String title = f.getTitle();
		System.out.println("â�� ������ " + title);

		Dimension d = f.getSize();
		System.out.println("â�� ���̴� " + d.getWidth() + "�̰�,\n" + "â�� ���̴� " + d.getHeight() + "�̴�.");

		f.setBackground(Color.green);// ���� ����
		f.setVisible(true);

		// ����� �Է��� �޾Ƽ�(����, �Ķ�, ���)
		String co = JOptionPane.showInputDialog("����, �Ķ�, ��� �߿��� �ϳ��� �����ϼ���");
		// switch (co) {
		// case "����":
		// f.setBackground(Color.RED);
		// break;
		// case "�Ķ�":
		// f.setBackground(Color.BLUE);
		// break;
		// case "���":
		// f.setBackground(Color.YELLOW);
		// break;
		// default: System.out.println("�� �� �����ϼ̽��ϴ�");
		// break;
		// }
		if ("����".equals(co)) {
			f.setBackground(Color.RED);
		} else if ("�Ķ�".equals(co)) {
			f.setBackground(Color.BLUE);
		} else if ("���".equals(co)) {
			f.setBackground(Color.YELLOW);
		} else {
			System.out.println("�� �� �����ϼ̽��ϴ�");
			f.setBackground(Color.black);
		}

		f.setVisible(true);

	}// end of main
}// end of class
