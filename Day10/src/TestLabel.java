import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;

/**
 * AWT-Label �� : �ܼ��� ���ڿ� ǥ��
 * 
 */
public class TestLabel {
	public static void main(String[] args) {
		Frame f = new Frame("�� Ȱ��");
		f.setBounds(100, 100, 300, 200);
		f.setLayout(new FlowLayout());

		Label l = new Label("���¹�ȣ�� �˷��ּ���");
		System.out.println(l.getText());
		l.setText("���¹�ȣ�� �˷��� �� �����");
		l.setAlignment(Label.RIGHT);// ��, �� , ����

		f.add(l);
		f.setVisible(true);

	}// end of main
}// end of class
