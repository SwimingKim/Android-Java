import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

/**
 * AWTȰ��
 */
public class TestQuiz {
	public static void main(String[] args) {
		// �غ��� �������� ����
		// ��ư�� ������ �л��� �̸��� ����� �Է� �޴´�(JOptionPane ���)
		// �Է� ���� �л��� �̸��� �ؽ�Ʈ ������ �ű��

		Frame f = new Frame("�л��̸�����");
		f.setBounds(100, 100, 200, 300);
		f.setLayout(new FlowLayout());

		Button b = new Button("����");
		f.add(b);

		TextArea ta = new TextArea(10, 20);
		f.add(ta);

		f.setVisible(true);

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("�̸��� �Է��ϼ���");
				if (name != null) {
					ta.append(name + "\n");
				}
			}
		});

		// ������ �̺�Ʈ ó��(â�ݱ�)
		// WindowListener�� �����Ϸ��� ������� �ʴ��� 7���� �޼��带 ��� �����ؾ� ��(����)
		// WinsowAdapter�� �� 7���� �޼����� ������ ����� �Ѿ, �츮�� �ʿ��� �͸� �ۼ��ϸ� ��
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			};
		});

	}// end of main
}// end of class
