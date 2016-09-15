import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * AWT - Choice
 */
public class TestChoice {
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setBounds(100, 100, 200, 300);
		f.setLayout(new FlowLayout());

		Choice c = new Choice();
		c.add("�Ͽ���");
		c.add("������");
		c.add("ȭ����");
		c.add("������");
		c.add("�����");
		c.add("�ݿ���");
		c.add("�����");

		c.remove("�ݿ���");// ��� ����
		c.remove(2);// �ε��� 2���� ȭ���� ��� ����

		f.add(c);

		System.out.println("0���� ���ڿ� :" + c.getItem(0));
		System.out.println("����� ���� : " + c.getItemCount());
		System.out.println("���õ� ����� index : " + c.getSelectedIndex());
		System.out.println("������ ��� ���ڿ� : " + c.getSelectedItem());

		Button b = new Button("��ư");
		f.add(b);

		f.setVisible(true);

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(c.getSelectedItem());
			}
		});

	}// end of main
}// end of class
