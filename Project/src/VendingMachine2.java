import javax.swing.JOptionPane;

/**
 * ���Ǳ� ���α׷�
 * */
public class VendingMachine2 {
	public static void main(String[] args) {
		
		while (true) {
			
			String item[] = {"","ĭŸŸ","��Ű��","����ƾ ��","������","���̴�"
					,"ī��Ÿ��","����","�ݶ�","���䷹��"};
			int value[] = {0,1800,800,900,500,1100,700,600,700,700};
						
			System.out.println("1. ĭŸŸ 1800\n"
					+ "2. ��Ű�� 800\n"
					+ "3. ����ƾ �� 900\n"
					+ "4. ������ 500\n"
					+ "5. ���̴� 1100\n"
					+ "6. ī��Ÿ�� 700\n"
					+ "7. ���� 600\n"
					+ "8. �ݶ� 700\n"
					+ "9. ���䷹�� 700\n");
			System.out.println("�츮 ���Ǳ� �����~");
						
			int money;
			while (true){
				try {
					String strMoney = JOptionPane.showInputDialog("���� ��������");
					money = Integer.valueOf(strMoney);
					if (money<0) {//0���� Ŀ���Ѵ�
						System.out.println("���� ����� �Է��ϼž� �մϴ�");
					} else {//0���� Ŭ �� - ����� �Է����� ���
						break;
					}
				} catch (Exception e) {//int�� ���ڰ� �ƴ� ���(���� �ͼ��� ó��)
					System.out.println("���� ���ڷ� �Է��ϼž� �մϴ�");
				}			
			}
							
			//1~9������ �������� �Ѵ�
			int menu;
			while (true) {
				try {
					String strMenu = JOptionPane.showInputDialog("������� ������");
					menu = Integer.valueOf(strMenu);
					if (menu>=1 && menu <=9) {//1~9������ �������� �Ѵ�
						break;//����� �Էµ�
					} else {
						System.out.println("�޴��� 1~9������ �������� �Ѵ�");
					}
				} catch (Exception e) {// ���� �Է� �ͼ��� ó��
					System.out.println("�޴��� ���ڷ� �Է��ϼ���");
				}
				
			}
			
			
			if (money>value[menu]) {//��ǰ���� ���� ���� Ŭ �� 

				System.out.println(item[menu]+" �����ϼ̽��ϴ�");
				System.out.println("���� �� : "+money+"��");
				System.out.println("������ ��ǰ : "+item[menu]);
				System.out.println("��ǰ ���� : "+value[menu]+"��\n");
				int change = money - value[menu];
				System.out.println("�ܵ� : "+change);
				System.out.println("500�� - "+change/500+"��\n"
						+ "100�� - "+change%500/100+"��\n"
						+ " 50�� - "+change%100/50+"��\n"
						+ " 10�� - "+change%50/10+"��\n"
						+ "���ſϷ�\n\n");		
				break;
			} else {//��ǰ���� ���� ���� ������
				System.out.println("�ܾ��� �����մϴ�");
			}
				
		}
		
	}//end of main
}//end of class
