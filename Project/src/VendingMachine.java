import java.util.Scanner;
/**
 * 자판기 프로그램
 * */
public class VendingMachine {
	public static void main(String[] args) {
//자판기 프로그램
//메뉴
//콜라 1290
//사이다 890
//물 610
//커피 560
//<출력화면>
//돈을 입력 : 3000
//메뉴 입력 : 콜라
//콜라를 선택하셨습니다
//콜라 나옴
//잔돈 총 1710원
//500원 : 3개
//100원 : 2개
//50원 : 0개
//10원 : 1개
//종료
//<예외사항>
//돈을 음수 입력시 '다시 입력하세요'
//프로그램 처음부터 다시
//없는 메뉴 입력시 '그런 메뉴 없습니다'
//프로그램 처음부터 다시
//제품보다 돈이 부족할 경우 '잔액이 부족합니다'
//프로그램 처음부터 다시

		
		Scanner scan = new Scanner(System.in);
		
		//제품의 정보를 배열변수에 저장해두자
		String item[]={"콜라","사이다","물","커피"};
		int price[]={1290,890,610,560};
				
		while (true) {
			System.out.println("자판기프로그램입니다");
			System.out.println("메뉴\n"
					+ "콜라 1290\n"
					+ "사이다 890원\n"
					+ "물 610원\n"
					+ "커피 560원 입니다");
			System.out.println("돈을 넣어주세요");
			int money = Integer.parseInt(scan.nextLine());
		//사용자가 음수로 돈을 입력하는 것 체크
			if (money<0){
				System.out.println("다시 입력하세요");
				continue;
			}
			System.out.println(money+"원을 입력받았습니다");	
			
			System.out.println("메뉴를 입력해주세요");			
			String menu = scan.nextLine();
			
				
			int select = -1;//사용자가 선택한 제품의 index
			switch (menu) {
			case "콜라":
				select=0;
				break;
			case "사이다":
				select=1;
				break;
			case "물":
				select=2;
				break;	
			case "커피":
				select=3;
				break;		
			default:
		//없는 메뉴 입력 시 체크		
				System.out.println("그런 메뉴 없습니다");
				continue;
			}
		//제품보다 돈이 부족할 경우
			if(money<price[select]){
				System.out.println("잔액이 부족합니다");
				continue;
			}			
			
			System.out.println(item[select]+"를 선택하셨습니다");
			System.out.println(item[select]+" 나옴");
			
			//잔돈 거슬러주기
			int change = money - price[select];
			System.out.println("잔돈은 총"+ change +"원이고\n"+
					"500원 :"+change /500+"개\n"+
					"100원 :"+change %500/100+"개\n"+
					"50원 :"+change %100/50+"개\n"+
					"10원 :"+change %50/10+"개 입니다");
			break;
		} 
		System.out.println("종료");
		
		
		
		
		
//		String menu = scan.nextLine();
//		System.out.println(menu+"을 선택했습니다");
		
	
		
		
		
		
	}//end of main
}//end of class
