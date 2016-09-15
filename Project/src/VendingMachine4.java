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
public class VendingMachine4 {
	int money;//����ڰ� �Է��� ��
	TextArea ta;
	Item arrItem[] = new Item[10];
	
	
	public static void main(String[] args) {
		VendingMachine4 v = new VendingMachine4();
		v.vending();
		
	}//end of main
	
	public void vending(){
		arrItem[0] = new Item("ĭŸŸ",1820);
		arrItem[1] = new Item("��Ű��",870);
		arrItem[2] = new Item("����ƾ��",960);
		arrItem[3] = new Item("������",510);
		arrItem[4] = new Item("���̴�",1190);
		arrItem[5] = new Item("ī��Ÿ��",740);
		arrItem[6] = new Item("����",660);
		arrItem[7] = new Item("�ݶ�",720);
		arrItem[8] = new Item("���䷹��",780);
		
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
				buttonClick(0);
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick(1);
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick(2);
			}
		});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick(3);
			}
		});
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick(4);
			}
		});
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick(5);
			}
		});
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick(6);
			}
		});
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick(7);
			}
		});
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick(8);
			}
		});
		
		
		
		f.setVisible(true);
	}
	
	void buttonClick(int index) {
		//�Է��� ���� ��ǰ���ݺ��� ũ�ų� ���� �� Ȯ��
		if (money>=arrItem[index].getValue()) {
			ta.append("������ ��ǰ�� "+arrItem[index].getName()+"�Դϴ�\n");
			ta.append("������ ��ǰ�� ������ "+arrItem[index].getValue()+"�Դϴ�\n");
			int change = money - arrItem[index].getValue();
			ta.append("�ܾ��� "+change+"�Դϴ�\n");
			ta.append("500�� - "+change/500+"��\n");
			ta.append("100�� - "+change%500/100+"��\n");
			ta.append(" 50�� - "+change%100/50+"��\n");
			ta.append(" 10�� - "+change%50/10+"��\n");
			
			money -= arrItem[index].getValue();
		} else {
			ta.append("�ܾ��� �����մϴ�\n");//TextArea�� �ݾ��� �����մϴ� ���
		}
		
	}	
}//end of class

class Item{//Ŭ���� : ����, ������, getter/setter �޼���, �޼���
	private String name = "";
	private int value;
	
	public Item() {}

	public Item(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	
	
}

