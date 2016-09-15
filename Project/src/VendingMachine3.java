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
 * ���Ǳ� ������Ʈ 
 * */
public class VendingMachine3 {
	static int money;//����ڰ� �Է��� ��
	static TextArea ta;
//	static String itemName = "";//����ڰ� ������ ��ǰ
//	static int itemValue;//����ڰ� ������ ��ǰ�� ����
	
	public static void main(String[] args) {
		
		
		Frame f = new Frame("���Ǳ� ���α׷�");
		f.setBounds(100, 100, 400, 300);
		f.setLayout(new FlowLayout());
		f.setResizable(false); //����ڰ� â�� ũ�⸦ �������� ���ϰ� ����
		f.setFont(new Font("�������",Font.BOLD, 15));

		Panel p = new Panel();//�����̳� - ������Ʈ�� ���� �� �ִ� ������Ʈ
		p.setLayout(new GridLayout(3, 3,5,5));
		Button b1 = new Button("ĭŸŸ 1820��"); p.add(b1);
		Button b2 = new Button("��Ű�� 870��"); p.add(b2);
		Button b3 = new Button("����ƾ�� 960��"); p.add(b3);
		Button b4 = new Button("������ 510��"); p.add(b4);
		Button b5 = new Button("���̴� 1190��"); p.add(b5);
		Button b6 = new Button("ī��Ÿ�� 740��"); p.add(b6);
		Button b7 = new Button("���� 660��"); p.add(b7);
		Button b8 = new Button("�ݶ� 720��"); p.add(b8);
		Button b9 = new Button("���䷹�� 780��"); p.add(b9);
	
		f.add(p);
		
		TextField tfMoney = new TextField(20); 
		f.add(tfMoney);
		
		Button bMoney = new Button("�� �Է�"); 
		f.add(bMoney);
		
		ta = new TextArea(5,40);
		f.add(ta);
		ta.setEditable(false);//����ڰ� ���� �������� ���ϰ� ����
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {//�ݱ� ��ư ��������
				f.dispose();
			}
		});		
		
		
		bMoney.addActionListener(new ActionListener() {//�� �Է� ��ư Ŭ����
			public void actionPerformed(ActionEvent e) {
				try {
					String strMoney = tfMoney.getText();
					int num = Integer.valueOf(strMoney);
					if (num<0) {//���� �Է½�
						ta.append("���� ����� �Է����ּ���\n");
					} else {
						ta.append(num+"���� �Է��ϼ̽��ϴ�\n");
						money += num;//�Է��� ���� ����
						ta.append("�� �Է� �ݾ� : "+money+"��\n");
					}
					tfMoney.setText("");//Textfield�� ��� ��	
				} catch (NumberFormatException e2) {
					ta.append("���� ���ڷ� �Է����ּ���\n");
				}
							
			}
		});
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick("ĭŸŸ", 1820);
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick("��Ű��", 870);
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick("����ƾ��", 960);
			}
		});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick("������", 510);
			}
		});
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick("���̴�", 1190);
			}
		});
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick("ī��Ÿ��", 740);
			}
		});
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick("����", 660);
			}
		});
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick("�ݶ�", 720);
			}
		});
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick("���䷹��", 780);
			}
		});
		
		
		
		f.setVisible(true);
	}//end of main
	static void buttonClick(String itemName, int itemValue) {
		//�Է��� ���� ��ǰ���ݺ��� ũ�ų� ���� �� Ȯ��
		if (money>=itemValue) {
			ta.append("������ ��ǰ�� "+itemName+"�Դϴ�\n");
			ta.append("������ ��ǰ�� ������ "+itemValue+"�Դϴ�\n");
			int change = money - itemValue;
			ta.append("�ܾ��� "+change+"�Դϴ�\n");
			ta.append("500�� - "+change/500+"��\n");
			ta.append("100�� - "+change%500/100+"��\n");
			ta.append(" 50�� - "+change%100/50+"��\n");
			ta.append(" 10�� - "+change%50/10+"��\n");
			
			money -= itemValue;
		} else {
			ta.append("�ܾ��� �����մϴ�\n");//TextArea�� �ݾ��� �����մϴ� ���
		}
		
	}
	
	
	
}//end of class
