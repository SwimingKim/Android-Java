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
		Frame f = new Frame("회원가입");
		f.setBounds(100, 100, 220, 400);
		f.setLayout(new FlowLayout());
		f.setResizable(false);// 창의 크기를 변경하지 못하도록 설정

		f.add(new Label("이름 : "));
		TextField tf1 = new TextField(18);
		f.add(tf1);

		f.add(new Label("나이 : "));
		TextField tf2 = new TextField(18);
		f.add(tf2);

		f.add(new Label("생일 : "));
		Choice c1 = new Choice();
		f.add(c1);
		for (int i = 1; i <= 12; i++) {
			c1.add(i + "");
		}
		f.add(new Label("월"));
		Choice c2 = new Choice();
		f.add(c2);
		for (int i = 1; i <= 31; i++) {
			c2.add(i + "");
		}
		f.add(new Label("일\n"));

		f.add(new Label("주소 : "));
		List l = new List(4);
		f.add(l);
		l.add("서울");
		l.add("경기");
		l.add("부산");
		l.add("대전");
		l.add("인천");
		l.add("대구");

		TextArea ta = new TextArea(10, 25);
		f.add(ta);

		f.setVisible(true);

		Button b = new Button("작성완료");
		f.add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int num = Integer.parseInt(tf2.getText());

					ta.append("회원 가입 성공!!\n\n" + "이름 : " + tf1.getText() + "\n나이 : " + tf2.getText() + "세" + "\n생일 : "
							+ c1.getSelectedItem() + "월 " + c2.getSelectedItem() + "일" + "\n주소 : "
							+ l.getSelectedItem());
				} catch (NumberFormatException e2) {
					ta.append("나이는 숫자로 입력하셔야 합니다\n\n");
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
