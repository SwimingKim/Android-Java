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
 * 그래픽 AWT => Swing, TextArea, TextField
 */
public class TestAWT2 {
	public static void main(String[] args) {
		Frame f = new Frame("텍스트 에어리어, 텍스트 필드 예제");
		f.setBounds(100, 100, 200, 300);// 위치와 크기
		f.setLayout(new FlowLayout());// 컴포넌트의 배치 관리 : 레이아웃 매니저

		Button b1 = new Button("전송");
		b1.setBounds(50, 50, 100, 50);
		f.add(b1);

		TextField tf = new TextField("입력하세요", 20);// 문자열, 열의 크기
		f.add(tf);

		TextArea ta = new TextArea(5, 20);
		f.add(ta);

		f.setVisible(true);// 화면에 보여주기
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = tf.getText();
				// ta.setText(str);//TextArea에 써라
				ta.append(str + "\n");// 기본 문자열의 뒤에 붙여써라
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

			public void windowClosing(WindowEvent e) {// 창닫기 버튼 눌렀을 때
				// System.out.println("창닫기눌렀습니다");
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
