import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Machine {
	public static void main(String[] args) {
		String menu[] = { "칸타타", "밀키스", "마운틴듀", "레쓰비", "사이다", "카페타임", "맥콜", "콜라", "게토레이" };
		int price[] = { 1800, 800, 900, 500, 1100, 700, 600, 700, 700 };

		Frame f = new Frame("자판기 프로그램");
		f.setBounds(100, 100, 280, 500);
		f.setLayout(new FlowLayout());
		f.setBackground(Color.orange);

		f.add(new Label("우리 자판기 골라골라~\n"));

		TextArea ta1 = new TextArea(12, 20);
		f.add(ta1);
		for (int i = 0; i <= 8; i++) {
			;
			ta1.append(i + 1 + ". " + menu[i] + "\t" + price[i] + "\n");
		}
		TextArea ta2 = new TextArea(8, 30);

		f.add(new Label("돈을 입력해주세요."));
		TextField tf1 = new TextField(8);
		f.add(tf1);

		Button b1 = new Button("전송");
		f.add(b1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Integer.parseInt(tf1.getText()) < 0) {
						ta2.append("돈은 마이너스는 안돼요\n");
					} else
						ta2.append("넣은 돈 : " + Integer.parseInt(tf1.getText()) + "\n");
				} catch (Exception e2) {
					ta2.append("돈은 숫자로 넣어주세요\n");
				}
			}
		});

		f.add(new Label("음료수를 고르세요."));
		TextField tf2 = new TextField(6);
		f.add(tf2);

		Button b2 = new Button("선택");
		f.add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Integer.parseInt(tf2.getText()) >= 10) {
						ta2.append("메뉴의 범위를 벗어나요\n");
					} else
						ta2.append(menu[Integer.parseInt(tf2.getText()) - 1] + "를 선택하셨습니다.\n");
				} catch (Exception e2) {
					ta2.append("메뉴는 숫자로 넣어주세요\n");
				}

			}
		});

		f.add(ta2);

		Button b3 = new Button("계산하기");
		f.add(b3);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int money = Integer.valueOf(tf1.getText());
				int select = Integer.valueOf(tf2.getText()) - 1;
				ta2.append("\n잔돈 : " + (money - price[select]) + "\n" + "500원 : " + (money - price[select]) / 500
						+ "개\n" + "100원 : " + (money - price[select]) % 500 / 100 + "개\n" + " 50원 : "
						+ (money - price[select]) % 100 / 50 + "개\n" + " 10원 : " + (money - price[select]) % 50 / 10
						+ "개\n" + "구매완료!!\n\n");
			}
		});

		f.setVisible(true);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});

	}// end of main
}// end of class
