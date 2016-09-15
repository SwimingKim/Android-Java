import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;

/**
 * AWT-Label 라벨 : 단순한 문자열 표시
 * 
 */
public class TestLabel {
	public static void main(String[] args) {
		Frame f = new Frame("라벨 활용");
		f.setBounds(100, 100, 300, 200);
		f.setLayout(new FlowLayout());

		Label l = new Label("계좌번호를 알려주세요");
		System.out.println(l.getText());
		l.setText("계좌번호는 알려줄 수 없어요");
		l.setAlignment(Label.RIGHT);// 좌, 우 , 센터

		f.add(l);
		f.setVisible(true);

	}// end of main
}// end of class
