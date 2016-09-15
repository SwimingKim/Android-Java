import java.lang.invoke.SwitchPoint;

import javax.swing.JOptionPane;

/**
 * 흐름제어 : if, switch, 삼항연산자
 */
public class TestSwitchQuiz {
	public static void main(String[] args) {
		// 사용자의 입력을 숫자로 받아서(달 입력 1~12)
		// 그 달의 날짜를 출력하는 프로그램을 작성하시오.
		String str = JOptionPane.showInputDialog("1~12 중에서 숫자를 입력하세요.");
		int month = Integer.parseInt(str);
		System.out.println("당신이 선택한 달은 " + month + "월 입니다");

		if (month == 2) {
			System.out.println(28);
		} else if (month == 4 || month == 6) {
			System.out.println(30);
		} else {
			System.out.println(31);
		}

		switch (month) {
		case 2:
			System.out.println(28);
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println(30);
			break;
		default:
			if (month >= 1 && month <= 12)
				System.out.println(31);
		}
	}// end of main
}// end of class
