import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.List;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Quiz {
	public static void main(String[] args) {
		Frame f = new Frame("ȸ������");
		f.setBounds(100, 100, 220, 400);
		f.setLayout(new FlowLayout());
		f.setResizable(false);// â�� ũ�⸦ �������� ���ϵ��� ����

		f.add(new Label("�̸� : "));
		TextField tf1 = new TextField(18);
		f.add(tf1);

		f.add(new Label("���� : "));
		TextField tf2 = new TextField(18);
		f.add(tf2);

		f.add(new Label("���� : "));
		Choice c1 = new Choice();
		f.add(c1);
		for (int i = 1; i <= 12; i++) {
			c1.add(i + "");
		}
		f.add(new Label("��"));
		Choice c2 = new Choice();
		f.add(c2);
		for (int i = 1; i <= 31; i++) {
			c2.add(i + "");
		}
		f.add(new Label("��\n"));

		f.add(new Label("�ּ� : "));
		List l = new List(4);
		f.add(l);
		l.add("����");
		l.add("���");
		l.add("�λ�");
		l.add("����");
		l.add("��õ");
		l.add("�뱸");

		TextArea ta = new TextArea(10, 25);
		f.add(ta);

		f.setVisible(true);

		Button b = new Button("�ۼ��Ϸ�");
		f.add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int num = Integer.parseInt(tf2.getText());

					ta.append("ȸ�� ���� ����!!\n\n" + "�̸� : " + tf1.getText() + "\n���� : " + tf2.getText() + "��" + "\n���� : "
							+ c1.getSelectedItem() + "�� " + c2.getSelectedItem() + "��" + "\n�ּ� : "
							+ l.getSelectedItem());
				} catch (NumberFormatException e2) {
					ta.append("���̴� ���ڷ� �Է��ϼž� �մϴ�\n\n");
					tf2.setText("");
				}
			}
		});

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});

	}// end of main
}// end of class
