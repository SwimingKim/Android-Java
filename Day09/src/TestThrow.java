import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ����ó��
 */

// �����Ϸ� ���� : ����ȯ, ����Ʈ, �⺻ ������ �ۼ�, ���� ã�� ��, ���� �ε� ���,
// �ڱ��ڽ� ��ü(this) ȣ��, �θ�Ŭ����(super) ȣ��
public class TestThrow {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();

		new TestThrow().first();
		// try catch

	}// end of main

	void first() {// throws ArithmeticException
		try {
			second();
		} catch (Exception e) {
			System.out.println("�����忡�� ��ź ó��");
		}
		System.out.println("yyyy");
	}

	void second() throws ArithmeticException {
		// Exception�� ���� ó������ �ʰ�, ���� ȣ���� �޼���� Exception ������ ����
		System.out.println(3 / 0);
		System.out.println("xxxx");
	}
}// end of class
