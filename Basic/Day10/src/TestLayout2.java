import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JButton;

/**
 * 레이아웃 매니저 함께 쓰기(penel) 사용
 */
public class TestLayout2 {
	public static void main(String[] args) {
		Frame f = new Frame("레이아웃 매니저 함께쓰기");
		f.setBounds(100, 100, 300, 400);
		f.setLayout(new BorderLayout());
		f.add(new Button("버튼"), BorderLayout.NORTH);
		f.add(new Button("버튼"), BorderLayout.SOUTH);
		f.add(new Button("버튼"), BorderLayout.EAST);
		f.add(new Button("버튼"), BorderLayout.WEST);

		// 컴포넌트 : 버튼, 텍스트필드, 라벨, 초이스..
		// 컨테이너 : 여러개의 컴포넌트를 하나의 덩어리로 묶어주는 개념
		Panel p = new Panel();
		p.setLayout(new GridLayout(3, 2));
		p.add(new JButton("Button"));
		p.add(new JButton("Button"));
		p.add(new JButton("Button"));
		p.add(new JButton("Button"));
		p.add(new JButton("Button"));
		p.add(new JButton("Button"));

		f.add(p, BorderLayout.CENTER);

		f.setVisible(true);

	}// end of main
}// end of class
