import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ��ư �߰�
 */
public class TestAWT2 {
	public static void main(String[] args) {
		Frame f = new Frame("��ư �߰� ������");
		// f.setSize(300, 200);
		// f.setLocation(100, 100);
		f.setBounds(100, 100, 300, 200);// ��ġ�� ũ�⸦ �ѹ��� ����
		f.setLayout(null);// ȭ���ġ

		// ��ư�� �߰��ؼ� �����ӿ� �޾ƺ���
		Button b = new Button("���");// ��
		b.setBounds(100, 100, 50, 50);
		// b.setLabel("��ư�Դϴ�");

		f.add(b);
		f.setVisible(true);

		// ��ư�� �̺�Ʈ ó�� - ������ ��� ���� �� �̺�Ʈ�� ó������
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {// Ŭ���ϸ� ����
				f.setBackground(Color.red);
			}
		});// ��ư Ŭ���� �̺�Ʈ ó��

	}// end of main
}// end of class
