import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

/**
 * AWT활용
 */
public class TestQuiz {
	public static void main(String[] args) {
		// 준비한 프레임을 띄운다
		// 버튼을 누르면 학생의 이름을 사용자 입력 받는다(JOptionPane 사용)
		// 입력 받은 학생의 이름을 텍스트 에어리어로 옮긴다

		Frame f = new Frame("학생이름관리");
		f.setBounds(100, 100, 200, 300);
		f.setLayout(new FlowLayout());

		Button b = new Button("전송");
		f.add(b);

		TextArea ta = new TextArea(10, 20);
		f.add(ta);

		f.setVisible(true);

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("이름을 입력하세요");
				if (name != null) {
					ta.append(name + "\n");
				}
			}
		});

		// 프레임 이벤트 처리(창닫기)
		// WindowListener를 구현하려면 사용하지 않더라도 7개의 메서드를 모두 구현해야 함(불편)
		// WinsowAdapter는 위 7개의 메서드의 몸통을 만들어 둘어서, 우리는 필요한 것만 작성하면 됨
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			};
		});

	}// end of main
}// end of class
