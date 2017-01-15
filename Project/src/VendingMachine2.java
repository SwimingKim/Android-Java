import javax.swing.JOptionPane;

/**
 * 자판기 프로그램
 * */
public class VendingMachine2 {
	public static void main(String[] args) {
		
		while (true) {
			
			String item[] = {"","칸타타","밀키스","마운틴 듀","레쓰비","사이다"
					,"카페타임","맥콜","콜라","게토레이"};
			int value[] = {0,1800,800,900,500,1100,700,600,700,700};
						
			System.out.println("1. 칸타타 1800\n"
					+ "2. 밀키스 800\n"
					+ "3. 마운틴 듀 900\n"
					+ "4. 레쓰비 500\n"
					+ "5. 사이다 1100\n"
					+ "6. 카페타임 700\n"
					+ "7. 맥콜 600\n"
					+ "8. 콜라 700\n"
					+ "9. 게토레이 700\n");
			System.out.println("우리 자판기 골라골라~");
						
			int money;
			while (true){
				try {
					String strMoney = JOptionPane.showInputDialog("돈을 넣으세요");
					money = Integer.valueOf(strMoney);
					if (money<0) {//0보다 커야한다
						System.out.println("돈은 양수로 입력하셔야 합니다");
					} else {//0보다 클 때 - 제대로 입력했을 경우
						break;
					}
				} catch (Exception e) {//int형 숫자가 아닐 경우(글자 익셉션 처리)
					System.out.println("돈은 숫자로 입력하셔야 합니다");
				}			
			}
							
			//1~9사이의 정수여야 한다
			int menu;
			while (true) {
				try {
					String strMenu = JOptionPane.showInputDialog("음료수를 고르세요");
					menu = Integer.valueOf(strMenu);
					if (menu>=1 && menu <=9) {//1~9사이의 정수여야 한다
						break;//제대로 입력됨
					} else {
						System.out.println("메뉴는 1~9사이의 정수여야 한다");
					}
				} catch (Exception e) {// 글자 입력 익셉션 처리
					System.out.println("메뉴는 숫자로 입력하세요");
				}
				
			}
			
			
			if (money>value[menu]) {//제품도바 넣은 돈이 클 때 

				System.out.println(item[menu]+" 선택하셨습니다");
				System.out.println("넣은 돈 : "+money+"원");
				System.out.println("선택한 제품 : "+item[menu]);
				System.out.println("제품 가격 : "+value[menu]+"원\n");
				int change = money - value[menu];
				System.out.println("잔돈 : "+change);
				System.out.println("500원 - "+change/500+"개\n"
						+ "100원 - "+change%500/100+"개\n"
						+ " 50원 - "+change%100/50+"개\n"
						+ " 10원 - "+change%50/10+"개\n"
						+ "구매완료\n\n");		
				break;
			} else {//제품보다 넣은 돈이 적으면
				System.out.println("잔액이 부족합니다");
			}
				
		}
		
	}//end of main
}//end of class
