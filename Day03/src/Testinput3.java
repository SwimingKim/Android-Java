import javax.swing.JOptionPane;

/**
 * 사용자 입력받기3
 */
public class Testinput3 {
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("이름을 입력하세요");

		System.out.println("당신의 이름은 " + name + " 입니다");

		String str = JOptionPane.showInputDialog("나이를 입력하세요");
		int age = Integer.parseInt(str);
		System.out.println("당신의 나이는 " + age + "세 입니다");

	}// end of main
}// end of class
