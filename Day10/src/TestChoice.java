import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * AWT - Choice
 */
public class TestChoice {
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setBounds(100, 100, 200, 300);
		f.setLayout(new FlowLayout());

		Choice c = new Choice();
		c.add("일요일");
		c.add("월요일");
		c.add("화요일");
		c.add("수요일");
		c.add("목요일");
		c.add("금요일");
		c.add("토요일");

		c.remove("금요일");// 목록 삭제
		c.remove(2);// 인덱스 2번인 화요일 목록 삭제

		f.add(c);

		System.out.println("0번쨰 문자열 :" + c.getItem(0));
		System.out.println("목록의 개수 : " + c.getItemCount());
		System.out.println("선택된 목록의 index : " + c.getSelectedIndex());
		System.out.println("선택한 목록 문자열 : " + c.getSelectedItem());

		Button b = new Button("버튼");
		f.add(b);

		f.setVisible(true);

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(c.getSelectedItem());
			}
		});

	}// end of main
}// end of class
