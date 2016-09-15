import java.util.*;

/**
 * ����ó��3
 */
public class TestException3 {
	public static void main(String[] args) {
		// ����� �Է��� ���ڷ� �޾Ƽ� ����ϱ�

		Scanner scan = new Scanner(System.in);
		System.out.println("���ڸ� �Է����ּ���");
		while (true) {
			try {
				int num = scan.nextInt();
				System.out.println(10 / num);
				break;
			} catch (InputMismatchException e) {// ���� �Է½�
				System.out.println("���ڰ� �ƴ� ���� �Է��ϼ̽��ϴ�.");
				scan.nextLine();// ���ۿ� �߸� �� ������ ����
			} catch (ArithmeticException ae) {// ���� 0 �Է½�
				System.out.println("0�� �Է��ϸ� �� �˴ϴ�");
			} catch (Exception e) {// ������ ��� ���� ó�� - ���� ������ catch�� ���
				System.out.println("������ �߻��߽��ϴ�");
			} finally {// �ݵ�� �����ϰ� ���������� �Ǵ� ����
				System.out.println("���̳θ� �ݵ�� �����");
			}
		}

	}// end of main
}// end of class
