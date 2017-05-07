import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * 자바의 GUI AWT(Abstract Window Toolkit)
 */
public class TestAWT1 {
	public static void main(String[] args) {
		Frame f = new Frame();// 윈도우창
		// JFrame f = new JFrame();//윈도우창

		f.setTitle("제목변경 할 수 있음");// 타이틀설정
		f.setSize(300, 200);// 크기지정
		f.setLocation(100, 100);// 위치지정
		f.setLayout(null);// 화면에 컴포넌트 배치하는 방법

		f.setVisible(true);

		String title = f.getTitle();
		System.out.println("창의 제목은 " + title);

		Dimension d = f.getSize();
		System.out.println("창의 넓이는 " + d.getWidth() + "이고,\n" + "창의 높이는 " + d.getHeight() + "이다.");

		f.setBackground(Color.green);// 색상 설정
		f.setVisible(true);

		// 사용자 입력을 받아서(빨강, 파랑, 노랑)
		String co = JOptionPane.showInputDialog("빨강, 파랑, 노랑 중에서 하나를 선택하세요");
		// switch (co) {
		// case "빨강":
		// f.setBackground(Color.RED);
		// break;
		// case "파랑":
		// f.setBackground(Color.BLUE);
		// break;
		// case "노랑":
		// f.setBackground(Color.YELLOW);
		// break;
		// default: System.out.println("잘 못 선택하셨습니다");
		// break;
		// }
		if ("빨강".equals(co)) {
			f.setBackground(Color.RED);
		} else if ("파랑".equals(co)) {
			f.setBackground(Color.BLUE);
		} else if ("노랑".equals(co)) {
			f.setBackground(Color.YELLOW);
		} else {
			System.out.println("잘 못 선택하셨습니다");
			f.setBackground(Color.black);
		}

		f.setVisible(true);

	}// end of main
}// end of class
