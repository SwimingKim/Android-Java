import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class QuizButton {
	public static void main(String[] args) {
		Frame f = new Frame("��ư �𿩶�");
		f.setBounds(100, 100, 300, 400);
		f.setLayout(null);

		Button b1 = new Button("����");
		b1.setBounds(80, 50, 50, 50);
		b1.setBackground(Color.red);
		b1.setVisible(true);

		Button b2 = new Button("�Ķ�");
		b2.setBounds(80, 100, 50, 50);
		b2.setBackground(Color.blue);
		b2.setVisible(true);

		Button b3 = new Button("���");
		b3.setBounds(80, 150, 50, 50);
		b3.setBackground(Color.YELLOW);
		b3.setVisible(true);

		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.setVisible(true);

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {// Ŭ���ϸ� ����
				f.setBackground(Color.red);
			}
		});

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {// Ŭ���ϸ� ����
				f.setBackground(Color.blue);
			}
		});

		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {// Ŭ���ϸ� ����
				f.setBackground(Color.yellow);
			}
		});
		f.addWindowListener(new WindowListener() {

			public void windowOpened(WindowEvent e) {
				System.out.println("â�� ������ ��");
			}// â�� ������ ��

			public void windowIconified(WindowEvent e) {
				System.out.println("�ּ�ȭ ������ ��");
			}// �ּ�ȭ ������ ��

			public void windowDeiconified(WindowEvent e) {
				System.out.println("�ּ�ȭ ������");
			}// �ּ�ȭ ������

			public void windowDeactivated(WindowEvent e) {
				System.out.println("��Ȱ��ȭ��");
			}// ��Ȱ��ȭ��

			public void windowClosing(WindowEvent e) {
				System.out.println("â�ݱ��ư Ŭ����");
				f.setTitle("â ���� �� �˾���??");
				// f.setVisible(false);//ȭ�鿡�� �����ֱ�
				f.dispose();// frame��ü�� �޸𸮿��� �����ϱ�
				// System.exit(0);//���α׷��� ������ ����
			}// â�ݱ��ư Ŭ����

			public void windowClosed(WindowEvent e) {
				System.out.println("â�� ������ ��");
			}// â�� ������ ��

			public void windowActivated(WindowEvent e) {
				System.out.println("Ȱ��ȭ ���� ��");
			}// Ȱ��ȭ ������
		});

	}// end of main
}// end of class
