import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.prefs.BackingStoreException;

/**
 * �׷��� AWT => Swing, TextArea, TextField
 */
public class TestAWT2 {
	public static void main(String[] args) {
		Frame f = new Frame("�ؽ�Ʈ �����, �ؽ�Ʈ �ʵ� ����");
		f.setBounds(100, 100, 200, 300);// ��ġ�� ũ��
		f.setLayout(new FlowLayout());// ������Ʈ�� ��ġ ���� : ���̾ƿ� �Ŵ���

		Button b1 = new Button("����");
		b1.setBounds(50, 50, 100, 50);
		f.add(b1);

		TextField tf = new TextField("�Է��ϼ���", 20);// ���ڿ�, ���� ũ��
		f.add(tf);

		TextArea ta = new TextArea(5, 20);
		f.add(ta);

		f.setVisible(true);// ȭ�鿡 �����ֱ�
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = tf.getText();
				// ta.setText(str);//TextArea�� ���
				ta.append(str + "\n");// �⺻ ���ڿ��� �ڿ� �ٿ����
				tf.setText("");
			}
		});

		f.addWindowListener(new WindowListener() {
			public void windowOpened(WindowEvent e) {
			}

			public void windowIconified(WindowEvent e) {
			}

			public void windowDeiconified(WindowEvent e) {
			}

			public void windowDeactivated(WindowEvent e) {
			}

			public void windowClosing(WindowEvent e) {// â�ݱ� ��ư ������ ��
				// System.out.println("â�ݱⴭ�����ϴ�");
				// f.setVisible(false);
				// f.dispose();
				System.exit(0);
			}

			public void windowClosed(WindowEvent e) {
			}

			public void windowActivated(WindowEvent e) {
			}
		});

	}// end of main
}// end of class
