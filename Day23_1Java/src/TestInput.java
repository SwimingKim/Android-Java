import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * ������� �Է¹ޱ�
 */
public class TestInput {
	public static void main(String[] args) throws IOException {

		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		// System.out.println("�Է��ϼ���");
		// String str = br.readLine();
		// System.out.println(str+"�Դϴ�");

		// Scanner scan = new Scanner(System.in);
		// System.out.println("�Է��ϼ���");
		// String str2 = br.readLine();
		// System.out.println(str2+"�Դϴ�");

		String name = JOptionPane.showInputDialog("�ȳ��ϼ��� �̸��� �Է��ϼ���");
		System.out.println(name + "����?");

	}// end of main
}// end of class
