import java.util.Scanner;

public class TestMachine {
	public static void main(String[] args) {
		String menu[] = { "칸타타", "밀키스", "마운틴듀", "레쓰비", "사이다", "카페타임", "맥콜", "콜라", "게토레이" };
		int price[] = { 1800, 800, 900, 500, 1100, 700, 600, 700, 700 };

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("자판기 골라골라");
			for (int i = 0; i < price.length; i++) {
				System.out.println(i + 1 + ". " + menu[i] + "\t" + price[i]);
			}
			System.out.println("돈을 입력해주세요");

			int money = Integer.parseInt(scan.nextLine());
			try {
				if (money < 0) {
					System.out.println("돈은 마이너스는 안돼요");
					continue;
				} else
					System.out.println(money + "원을 넣었습니다");
			} catch (NumberFormatException ae) {
				System.out.println("돈은 숫자로 입력해주세요");
				continue;
			}

			System.out.println("음료수를 선택해주세요");
			int select = Integer.parseInt(scan.nextLine());
			try {
				System.out.println(menu[select - 1] + "를 선택했습니다");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("메뉴선택의 범위를 벗어나요");
				continue;
			}

			System.out.println("잔돈은 " + (money - price[select - 1]));
			System.out.println("500원 " + (money - price[select - 1]) / 500 + "개\n" + "100원 "
					+ (money - price[select - 1]) % 500 / 100 + "개\n" + "50원 " + (money - price[select - 1]) % 100 / 50
					+ "개\n" + "10원 " + (money - price[select - 1]) % 50 / 10 + "개");
			System.out.println("구매완료\n");

		}
	}// end of main
}// end of class
