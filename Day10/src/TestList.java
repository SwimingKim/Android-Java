import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.List;

/**
 * AWT - List 여러개의 목록을 한꺼번에 보여주는 컴포넌트
 */
public class TestList {
	public static void main(String[] args) {
		Frame f = new Frame("프레임");
		f.setBounds(100, 100, 200, 300);
		f.setLayout(new FlowLayout());

		List l = new List(5);
		l.add("사과");
		l.add("배");
		l.add("딸기");
		l.add("오이");
		l.add("가지");
		l.add("파인애플");
		l.add("수박");
		l.add("복숭아");
		l.add("오렌지");
		l.add("포도");
		l.add("귤");
		l.remove(1);
		System.out.println(l.getSelectedItem());// 선택된 값을 가져온다

		f.add(l);

		f.setVisible(true);

	}// end of main
}// end of class
