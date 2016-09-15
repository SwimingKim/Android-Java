import java.awt.Button;
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * AWT - Check Box
 */
public class TestCheckBox {
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setBounds(100, 100, 200, 300);
		f.setLayout(new FlowLayout());

		f.add(new Label("����� ���� �����ϴ� ����?"));
		Checkbox cb1 = new Checkbox("������");
		Checkbox cb2 = new Checkbox("�۾���");
		Checkbox cb3 = new Checkbox("������");
		Checkbox cb4 = new Checkbox("�����");

		f.add(cb1);
		f.add(cb2);
		f.add(cb3);
		f.add(cb4);

		Button b = new Button("���ÿϷ�");
		f.add(b);

		TextArea ta = new TextArea(10, 20);
		f.add(ta);

		f.setVisible(true);

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = "";
				str += cb1.getState() ? cb1.getLabel() + "����\n" : "";
				str += cb2.getState() ? cb2.getLabel() + "����\n" : "";
				str += cb3.getState() ? cb3.getLabel() + "����\n" : "";
				str += cb4.getState() ? cb4.getLabel() + "����\n" : "";
				ta.append(str + "\n");
			}
		});

	}// end of main
}// end of class
