import java.util.Scanner;
/**
 * ���Ǳ� ���α׷�
 * */
public class VendingMachine {
	public static void main(String[] args) {
//���Ǳ� ���α׷�
//�޴�
//�ݶ� 1290
//���̴� 890
//�� 610
//Ŀ�� 560
//<���ȭ��>
//���� �Է� : 3000
//�޴� �Է� : �ݶ�
//�ݶ� �����ϼ̽��ϴ�
//�ݶ� ����
//�ܵ� �� 1710��
//500�� : 3��
//100�� : 2��
//50�� : 0��
//10�� : 1��
//����
//<���ܻ���>
//���� ���� �Է½� '�ٽ� �Է��ϼ���'
//���α׷� ó������ �ٽ�
//���� �޴� �Է½� '�׷� �޴� �����ϴ�'
//���α׷� ó������ �ٽ�
//��ǰ���� ���� ������ ��� '�ܾ��� �����մϴ�'
//���α׷� ó������ �ٽ�

		
		Scanner scan = new Scanner(System.in);
		
		//��ǰ�� ������ �迭������ �����ص���
		String item[]={"�ݶ�","���̴�","��","Ŀ��"};
		int price[]={1290,890,610,560};
				
		while (true) {
			System.out.println("���Ǳ����α׷��Դϴ�");
			System.out.println("�޴�\n"
					+ "�ݶ� 1290\n"
					+ "���̴� 890��\n"
					+ "�� 610��\n"
					+ "Ŀ�� 560�� �Դϴ�");
			System.out.println("���� �־��ּ���");
			int money = Integer.parseInt(scan.nextLine());
		//����ڰ� ������ ���� �Է��ϴ� �� üũ
			if (money<0){
				System.out.println("�ٽ� �Է��ϼ���");
				continue;
			}
			System.out.println(money+"���� �Է¹޾ҽ��ϴ�");	
			
			System.out.println("�޴��� �Է����ּ���");			
			String menu = scan.nextLine();
			
				
			int select = -1;//����ڰ� ������ ��ǰ�� index
			switch (menu) {
			case "�ݶ�":
				select=0;
				break;
			case "���̴�":
				select=1;
				break;
			case "��":
				select=2;
				break;	
			case "Ŀ��":
				select=3;
				break;		
			default:
		//���� �޴� �Է� �� üũ		
				System.out.println("�׷� �޴� �����ϴ�");
				continue;
			}
		//��ǰ���� ���� ������ ���
			if(money<price[select]){
				System.out.println("�ܾ��� �����մϴ�");
				continue;
			}			
			
			System.out.println(item[select]+"�� �����ϼ̽��ϴ�");
			System.out.println(item[select]+" ����");
			
			//�ܵ� �Ž����ֱ�
			int change = money - price[select];
			System.out.println("�ܵ��� ��"+ change +"���̰�\n"+
					"500�� :"+change /500+"��\n"+
					"100�� :"+change %500/100+"��\n"+
					"50�� :"+change %100/50+"��\n"+
					"10�� :"+change %50/10+"�� �Դϴ�");
			break;
		} 
		System.out.println("����");
		
		
		
		
		
//		String menu = scan.nextLine();
//		System.out.println(menu+"�� �����߽��ϴ�");
		
	
		
		
		
		
	}//end of main
}//end of class
