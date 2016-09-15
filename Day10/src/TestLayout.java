import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.border.Border;

/**
 * 
 * */
public class TestLayout {
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setBounds(100, 100, 300, 400);
		f.setLayout(new FlowLayout());// 레이아웃 매니저 설정
		// 공책에 작성하는 것처럼 윗줄의 좌->우 배치 후 다음 줄로 내려서 배치

		f.add(new JButton("버튼"));
		f.add(new JButton("버튼"));
		f.add(new JButton("버튼"));
		f.add(new JButton("버튼"));
		f.add(new JButton("버튼"));
		f.add(new JButton("버튼"));
		f.add(new JButton("버튼"));

		// f.setVisible(true);

		Frame f2 = new Frame("BorderLayout");
		f2.setBounds(100, 400, 300, 400);
		f2.setLayout(new BorderLayout());
		//
		JButton jb1 = new JButton("버튼1");
		JButton jb2 = new JButton("버튼2");
		JButton jb3 = new JButton("버튼3");
		JButton jb4 = new JButton("버튼4");
		JButton jb5 = new JButton("버튼5");
		f2.add(jb1, BorderLayout.NORTH);
		f2.add(jb2, BorderLayout.EAST);
		f2.add(jb3, BorderLayout.WEST);
		f2.add(jb4, BorderLayout.SOUTH);
		f2.add(jb5, BorderLayout.CENTER);
		f2.add(jb5);// center
		f2.setVisible(true);

		Frame f3 = new Frame("GridLayout");
		f3.setBounds(700, 100, 300, 400);
		f3.setLayout(new GridLayout(3, 2));// 행, 열
		f3.add(new Button("버튼"));
		f3.add(new Button("버튼"));
		f3.add(new Button("버튼"));
		f3.add(new Button("버튼"));
		f3.add(new Button("버튼"));
		f3.add(new Button("버튼"));
		// f3.setVisible(true);

	}// end of main
}// end of class
