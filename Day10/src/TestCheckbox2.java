
/**
 * AWT - CheckBox2 라디오 버튼
 * */
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestCheckbox2 {
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setBounds(100, 100, 200, 300);
		f.setLayout(new FlowLayout());

		f.add(new Label("당신이 가장 좋아하는 것은?"));
		CheckboxGroup cg = new CheckboxGroup();
		Checkbox cb1 = new Checkbox("강아지", cg, false);
		Checkbox cb2 = new Checkbox("송아지", cg, false);
		Checkbox cb3 = new Checkbox("망아지", cg, false);
		Checkbox cb4 = new Checkbox("고양이", cg, false);

		f.add(cb1);
		f.add(cb2);
		f.add(cb3);
		f.add(cb4);

		Button b = new Button("선택완료");
		f.add(b);

		TextArea ta = new TextArea(10, 20);
		f.add(ta);

		f.setVisible(true);

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = "";
				// str += cb1.getState() ? cb1.getLabel()+"선택\n" : "";
				// str += cb2.getState() ? cb2.getLabel()+"선택\n" : "";
				// str += cb3.getState() ? cb3.getLabel()+"선택\n" : "";
				// str += cb4.getState() ? cb4.getLabel()+"선택\n" : "";

				str += cg.getSelectedCheckbox().getLabel() + "\n";
				ta.append(str + "\n");
			}
		});

	}// end of main
}// end of class
