import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Buffered Reader Ȱ���ϱ�
 */
public class Testinput2Quiz {
	public static void main(String[] args) throws IOException {
		// Buffered Reader�� ����ؼ� ������� �Է��� ��������
		// ����3�� �Է� �޾Ƽ� �ִ밪�� ����ϼ���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("���� 3���� �Է��ϼ���.");
		String str = br.readLine();
		int num1 = Integer.parseInt(str);

		str = br.readLine();
		int num2 = Integer.parseInt(str);

		str = br.readLine();
		int num3 = Integer.parseInt(str);

		System.out.println("" + num1 + num2 + num3);

		int max = num1;
		if (max < num2)
			max = num2;
		if (max < num3)
			max = num3;
		System.out.println("�ִ밪��" + max + "�Դϴ�");

	}// end of main
}// end of class
