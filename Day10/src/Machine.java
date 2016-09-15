import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Machine {
	public static void main(String[] args) {
		String menu[] = { "ĭŸŸ", "��Ű��", "����ƾ��", "������", "���̴�", "ī��Ÿ��", "����", "�ݶ�", "���䷹��" };
		int price[] = { 1800, 800, 900, 500, 1100, 700, 600, 700, 700 };

		Frame f = new Frame("���Ǳ� ���α׷�");
		f.setBounds(100, 100, 280, 500);
		f.setLayout(new FlowLayout());
		f.setBackground(Color.orange);

		f.add(new Label("�츮 ���Ǳ� �����~\n"));

		TextArea ta1 = new TextArea(12, 20);
		f.add(ta1);
		for (int i = 0; i <= 8; i++) {
			;
			ta1.append(i + 1 + ". " + menu[i] + "\t" + price[i] + "\n");
		}
		TextArea ta2 = new TextArea(8, 30);

		f.add(new Label("���� �Է����ּ���."));
		TextField tf1 = new TextField(8);
		f.add(tf1);

		Button b1 = new Button("����");
		f.add(b1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Integer.parseInt(tf1.getText()) < 0) {
						ta2.append("���� ���̳ʽ��� �ȵſ�\n");
					} else
						ta2.append("���� �� : " + Integer.parseInt(tf1.getText()) + "\n");
				} catch (Exception e2) {
					ta2.append("���� ���ڷ� �־��ּ���\n");
				}
			}
		});

		f.add(new Label("������� ������."));
		TextField tf2 = new TextField(6);
		f.add(tf2);

		Button b2 = new Button("����");
		f.add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Integer.parseInt(tf2.getText()) >= 10) {
						ta2.append("�޴��� ������ �����\n");
					} else
						ta2.append(menu[Integer.parseInt(tf2.getText()) - 1] + "�� �����ϼ̽��ϴ�.\n");
				} catch (Exception e2) {
					ta2.append("�޴��� ���ڷ� �־��ּ���\n");
				}

			}
		});

		f.add(ta2);

		Button b3 = new Button("����ϱ�");
		f.add(b3);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int money = Integer.valueOf(tf1.getText());
				int select = Integer.valueOf(tf2.getText()) - 1;
				ta2.append("\n�ܵ� : " + (money - price[select]) + "\n" + "500�� : " + (money - price[select]) / 500
						+ "��\n" + "100�� : " + (money - price[select]) % 500 / 100 + "��\n" + " 50�� : "
						+ (money - price[select]) % 100 / 50 + "��\n" + " 10�� : " + (money - price[select]) % 50 / 10
						+ "��\n" + "���ſϷ�!!\n\n");
			}
		});

		f.setVisible(true);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});

	}// end of main
}// end of class
