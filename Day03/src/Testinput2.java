import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * ������� �Է��� �޴� ���2
 */
public class Testinput2 {
	public static void main(String[] args) throws IOException {
		// ������� �Է��� Ű��������� �ޱ� ���� ��ü�� �����Ѵ�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("����� �̸��� �Է��ϼ���");// ���ڿ��θ� �Է¹��� �� �ִ�.
		String name = br.readLine();// ���ڿ��θ� �Է¹��� �� �ִ�
		// �ͼ��� ó���� �Ѵ�
		System.out.println("����� �̸���:" + name);

		System.out.println("����� ���̸� �Է��ϼ���.");
		String str = br.readLine();
		// Buffered Reader�� ������ ���ڿ��θ� �Է��� �޾��ش�
		// ���ڸ� ����ϰ� ������, ���� ���ڿ��� =>���ڷ� ��ȯ�ؾ� �Ѵ�

		int age = Integer.parseInt(str);// ���ڿ�=>���ڷ� ��ȯ
		System.out.println(age);

		// ����=>���ڿ�
		String a = 26 + "";

	}// end of main
}// end of class
