import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.border.Border;

/**
 * 
 * */
public class TestLayout {
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setBounds(100, 100, 300, 400);
		f.setLayout(new FlowLayout());// ���̾ƿ� �Ŵ��� ����
		// ��å�� �ۼ��ϴ� ��ó�� ������ ��->�� ��ġ �� ���� �ٷ� ������ ��ġ

		f.add(new JButton("��ư"));
		f.add(new JButton("��ư"));
		f.add(new JButton("��ư"));
		f.add(new JButton("��ư"));
		f.add(new JButton("��ư"));
		f.add(new JButton("��ư"));
		f.add(new JButton("��ư"));

		// f.setVisible(true);

		Frame f2 = new Frame("BorderLayout");
		f2.setBounds(100, 400, 300, 400);
		f2.setLayout(new BorderLayout());
		//
		JButton jb1 = new JButton("��ư1");
		JButton jb2 = new JButton("��ư2");
		JButton jb3 = new JButton("��ư3");
		JButton jb4 = new JButton("��ư4");
		JButton jb5 = new JButton("��ư5");
		f2.add(jb1, BorderLayout.NORTH);
		f2.add(jb2, BorderLayout.EAST);
		f2.add(jb3, BorderLayout.WEST);
		f2.add(jb4, BorderLayout.SOUTH);
		f2.add(jb5, BorderLayout.CENTER);
		f2.add(jb5);// center
		f2.setVisible(true);

		Frame f3 = new Frame("GridLayout");
		f3.setBounds(700, 100, 300, 400);
		f3.setLayout(new GridLayout(3, 2));// ��, ��
		f3.add(new Button("��ư"));
		f3.add(new Button("��ư"));
		f3.add(new Button("��ư"));
		f3.add(new Button("��ư"));
		f3.add(new Button("��ư"));
		f3.add(new Button("��ư"));
		// f3.setVisible(true);

	}// end of main
}// end of class
