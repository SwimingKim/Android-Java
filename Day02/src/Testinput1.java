import java.util.Scanner;

/**
 * ����� �Է¹ޱ�1 - Scanner
 */
public class Testinput1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// ������Է��� �ޱ� ���� ��ü�� �غ��Ѵ�(���α׷����� �ѹ��� �����ϸ� ��)
		// Scanner Ŭ������ import�Ѵ�

		System.out.println("���̸� �Է��ϼ���");
		int age = scan.nextInt(); // ������� �Է��� �޾ƿ´�

		System.out.println("����� �Է��� ���̴�" + age + "��");

		System.out.println("�����Ը� �Է��ϼ���");
		int weight = scan.nextInt();
		System.out.println("����� �����Դ�" + weight + "kg�Դϴ�");

		System.out.println("�̸��� �Է��ϼ���");
		String name = scan.next();// ���ڿ��Է¹ޱ�
		System.out.println("����� �̸���" + name + "�Դϴ�");
	}// end of main
}// end of class
