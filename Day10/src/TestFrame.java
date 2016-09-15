import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * AWT Ȱ��
 */
public class TestFrame {
	public static void main(String[] args) {
		Frame f = new Frame("������");
		f.setBounds(100, 100, 200, 300);
		f.setLayout(new FlowLayout());
		f.setResizable(false);// ũ�⸦ �������� ���ϰ� ����

		TextField tf = new TextField(10);
		tf.setEchoChar('#');// ���� ��� ������ ���� ������ ����

		f.add(tf);

		f.setVisible(true);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});

		f.setVisible(true);

	}// end of main
}// end of class
