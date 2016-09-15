import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * AWT 활용
 */
public class TestFrame {
	public static void main(String[] args) {
		Frame f = new Frame("프레임");
		f.setBounds(100, 100, 200, 300);
		f.setLayout(new FlowLayout());
		f.setResizable(false);// 크기를 변경하지 못하게 설정

		TextField tf = new TextField(10);
		tf.setEchoChar('#');// 글자 대신 보안을 위해 보여줄 글자

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
