/**
 * ���ɹ���
 */
public class Quiz {
	public static void main(String[] args) {
		// �ﰢ���� ���̸� ����ϴ� �ڵ� �ۼ�
		int width = 7;
		int height = 5;
		System.out.println(width * height / 2.);

		// ����� ��µ� �ʿ��� �ٱ���(����)�� ���� ���ϴ� �ڵ��ۼ�
		// ���� ����� ���� 123���̰� �ϳ��� �ٱ��Ͽ��� 10���� ����� ���� �� �ִٸ�,
		// 13���� �ٱ��ϰ� �ʿ��� ���̴�.
		int numOfApples = 123;// ����� ����
		int sizeOfBucket = 10;// �ٱ����� ũ��(�ٱ��Ͽ� ���� �� �ִ� ����� ����)
		int numOfBucket = numOfApples / sizeOfBucket + (numOfApples % sizeOfBucket == 0 ? 0 : 1);
		System.out.println("�ʿ��� �ٱ����� �� : " + numOfBucket);

		// �ּ��� ���� ������ �Ž������� �ַ��� ��� ����ؾ� �ұ��?
		int change = 3780;// �� �Ž�����

		System.out.println("500��" + change / 500 + "��");
		int coin = change % 500; // 3780 - 500*change/500;
		System.out.println("100d��" + change % 500 / 100 + "��");
		System.out.println("50��" + change % 100 / 50 + "��");
		System.out.println("10��" + change % 50 / 10 + "��");

	}// end of main
}// end of class
