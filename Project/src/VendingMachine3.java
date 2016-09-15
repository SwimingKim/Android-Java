import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 자판기 프로젝트 
 * */
public class VendingMachine3 {
	static int money;//사용자가 입력한 돈
	static TextArea ta;
//	static String itemName = "";//사용자가 선택한 제품
//	static int itemValue;//사용자가 선택한 제품의 가격
	
	public static void main(String[] args) {
		
		
		Frame f = new Frame("자판기 프로그램");
		f.setBounds(100, 100, 400, 300);
		f.setLayout(new FlowLayout());
		f.setResizable(false); //사용자가 창의 크기를 조절하지 못하게 막음
		f.setFont(new Font("맑은고딕",Font.BOLD, 15));

		Panel p = new Panel();//컨테이너 - 컴포넌트를 담을 수 있는 컴포넌트
		p.setLayout(new GridLayout(3, 3,5,5));
		Button b1 = new Button("칸타타 1820원"); p.add(b1);
		Button b2 = new Button("밀키스 870원"); p.add(b2);
		Button b3 = new Button("마운틴듀 960원"); p.add(b3);
		Button b4 = new Button("레쓰비 510원"); p.add(b4);
		Button b5 = new Button("사이다 1190원"); p.add(b5);
		Button b6 = new Button("카페타임 740원"); p.add(b6);
		Button b7 = new Button("맥콜 660원"); p.add(b7);
		Button b8 = new Button("콜라 720원"); p.add(b8);
		Button b9 = new Button("게토레이 780원"); p.add(b9);
	
		f.add(p);
		
		TextField tfMoney = new TextField(20); 
		f.add(tfMoney);
		
		Button bMoney = new Button("돈 입력"); 
		f.add(bMoney);
		
		ta = new TextArea(5,40);
		f.add(ta);
		ta.setEditable(false);//사용자가 값을 수정하지 못하게 막음
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {//닫기 버튼 눌렀을때
				f.dispose();
			}
		});		
		
		
		bMoney.addActionListener(new ActionListener() {//돈 입력 버튼 클릭시
			public void actionPerformed(ActionEvent e) {
				try {
					String strMoney = tfMoney.getText();
					int num = Integer.valueOf(strMoney);
					if (num<0) {//음수 입력시
						ta.append("돈은 양수로 입력해주세요\n");
					} else {
						ta.append(num+"원을 입력하셨습니다\n");
						money += num;//입력한 돈을 누적
						ta.append("총 입력 금액 : "+money+"원\n");
					}
					tfMoney.setText("");//Textfield를 비워 줌	
				} catch (NumberFormatException e2) {
					ta.append("돈은 숫자로 입력해주세요\n");
				}
							
			}
		});
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick("칸타타", 1820);
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick("밀키스", 870);
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick("마운틴듀", 960);
			}
		});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick("레쓰비", 510);
			}
		});
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick("사이다", 1190);
			}
		});
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick("카페타임", 740);
			}
		});
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick("맥콜", 660);
			}
		});
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick("콜라", 720);
			}
		});
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick("게토레이", 780);
			}
		});
		
		
		
		f.setVisible(true);
	}//end of main
	static void buttonClick(String itemName, int itemValue) {
		//입력한 돈이 제품가격보다 크거나 같은 지 확인
		if (money>=itemValue) {
			ta.append("선택한 제품은 "+itemName+"입니다\n");
			ta.append("선택한 제품의 가격은 "+itemValue+"입니다\n");
			int change = money - itemValue;
			ta.append("잔액은 "+change+"입니다\n");
			ta.append("500원 - "+change/500+"개\n");
			ta.append("100원 - "+change%500/100+"개\n");
			ta.append(" 50원 - "+change%100/50+"개\n");
			ta.append(" 10원 - "+change%50/10+"개\n");
			
			money -= itemValue;
		} else {
			ta.append("잔액이 부족합니다\n");//TextArea에 금액이 부족합니다 출력
		}
		
	}
	
	
	
}//end of class
