import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 버튼 추가
 */
public class TestAWT2 {
	public static void main(String[] args) {
		Frame f = new Frame("버튼 추가 프레임");
		// f.setSize(300, 200);
		// f.setLocation(100, 100);
		f.setBounds(100, 100, 300, 200);// 위치와 크기를 한번에 설정
		f.setLayout(null);// 화면배치

		// 버튼을 추가해서 프레임에 달아보기
		Button b = new Button("까꿍");// 라벨
		b.setBounds(100, 100, 50, 50);
		// b.setLabel("버튼입니당");

		f.add(b);
		f.setVisible(true);

		// 버튼의 이벤트 처리 - 무엇을 어떻게 했을 때 이벤트를 처리할지
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {// 클릭하면 실행
				f.setBackground(Color.red);
			}
		});// 버튼 클릭시 이벤트 처리

	}// end of main
}// end of class
