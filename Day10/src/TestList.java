import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.List;

/**
 * AWT - List �������� ����� �Ѳ����� �����ִ� ������Ʈ
 */
public class TestList {
	public static void main(String[] args) {
		Frame f = new Frame("������");
		f.setBounds(100, 100, 200, 300);
		f.setLayout(new FlowLayout());

		List l = new List(5);
		l.add("���");
		l.add("��");
		l.add("����");
		l.add("����");
		l.add("����");
		l.add("���ξ���");
		l.add("����");
		l.add("������");
		l.add("������");
		l.add("����");
		l.add("��");
		l.remove(1);
		System.out.println(l.getSelectedItem());// ���õ� ���� �����´�

		f.add(l);

		f.setVisible(true);

	}// end of main
}// end of class
