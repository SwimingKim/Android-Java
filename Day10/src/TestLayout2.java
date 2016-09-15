import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JButton;

/**
 * ���̾ƿ� �Ŵ��� �Բ� ����(penel) ���
 */
public class TestLayout2 {
	public static void main(String[] args) {
		Frame f = new Frame("���̾ƿ� �Ŵ��� �Բ�����");
		f.setBounds(100, 100, 300, 400);
		f.setLayout(new BorderLayout());
		f.add(new Button("��ư"), BorderLayout.NORTH);
		f.add(new Button("��ư"), BorderLayout.SOUTH);
		f.add(new Button("��ư"), BorderLayout.EAST);
		f.add(new Button("��ư"), BorderLayout.WEST);

		// ������Ʈ : ��ư, �ؽ�Ʈ�ʵ�, ��, ���̽�..
		// �����̳� : �������� ������Ʈ�� �ϳ��� ����� �����ִ� ����
		Panel p = new Panel();
		p.setLayout(new GridLayout(3, 2));
		p.add(new JButton("Button"));
		p.add(new JButton("Button"));
		p.add(new JButton("Button"));
		p.add(new JButton("Button"));
		p.add(new JButton("Button"));
		p.add(new JButton("Button"));

		f.add(p, BorderLayout.CENTER);

		f.setVisible(true);

	}// end of main
}// end of class
