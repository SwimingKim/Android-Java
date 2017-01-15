import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class QuizButton {
	public static void main(String[] args) {
		Frame f = new Frame("버튼 모여라");
		f.setBounds(100, 100, 300, 400);
		f.setLayout(null);

		Button b1 = new Button("빨강");
		b1.setBounds(80, 50, 50, 50);
		b1.setBackground(Color.red);
		b1.setVisible(true);

		Button b2 = new Button("파랑");
		b2.setBounds(80, 100, 50, 50);
		b2.setBackground(Color.blue);
		b2.setVisible(true);

		Button b3 = new Button("노랑");
		b3.setBounds(80, 150, 50, 50);
		b3.setBackground(Color.YELLOW);
		b3.setVisible(true);

		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.setVisible(true);

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {// 클릭하면 실행
				f.setBackground(Color.red);
			}
		});

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {// 클릭하면 실행
				f.setBackground(Color.blue);
			}
		});

		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {// 클릭하면 실행
				f.setBackground(Color.yellow);
			}
		});
		f.addWindowListener(new WindowListener() {

			public void windowOpened(WindowEvent e) {
				System.out.println("창이 열렸을 때");
			}// 창이 열렸을 때

			public void windowIconified(WindowEvent e) {
				System.out.println("최소화 눌렀을 떄");
			}// 최소화 눌렀을 때

			public void windowDeiconified(WindowEvent e) {
				System.out.println("최소화 복구시");
			}// 최소화 복구시

			public void windowDeactivated(WindowEvent e) {
				System.out.println("비활성화시");
			}// 비활성화시

			public void windowClosing(WindowEvent e) {
				System.out.println("창닫기버튼 클릭시");
				f.setTitle("창 닫힐 줄 알았지??");
				// f.setVisible(false);//화면에서 가려주기
				f.dispose();// frame객체를 메모리에서 제거하기
				// System.exit(0);//프로그램을 완전히 종료
			}// 창닫기버튼 클릭시

			public void windowClosed(WindowEvent e) {
				System.out.println("창이 닫혔을 때");
			}// 창이 닫혔을 떄

			public void windowActivated(WindowEvent e) {
				System.out.println("활성화 됐을 때");
			}// 활성화 됐을때
		});

	}// end of main
}// end of class
