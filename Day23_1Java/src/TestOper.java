/**
 * ������
 */
public class TestOper {
	public static void main(String[] args) {
		// �����ڸ� �ǿ������� ������ ����
		// ���׿�����, ���׿�����, ���׿�����, ���Կ�����
		// ���׿����� : ++ -- +/- !
		int a = 3;
		a++;// 4
		++a;// 5
		a--;// 4

		a = -3;// ��ȣ������
		a = -a;

		boolean b = false;
		b = !b;// ������������
		b = !true;

		// ���� ������
		int c = 3 + 4;
		c = 5 % 2;// ������ ������

		boolean bb = true && false;// ��������(ȿ������ ������ �Ѵ�)
		bb = true || false;

		bb = false & false;// ��Ʈ������
		bb = true | false;

		// if (args instanceof type) {// args ������ ������ "type"��ȣ ����ȯ�� ��������
		// type new_name = (type) args;
		//
		// }

		// ���� ������
		int z = (3 < 5) ? 7 : 8;

		// ���� ������ : =(��ȣ) �� ���׿������� ����
		int y = 4;
		y += 2; // y = y+2;
		y -= 2;
		y *= 2;
		y %= 2;
		y &= 2;

		int numOfApples = 123;
		int sizeOfBucket = 10;
		int numOfBucket = numOfApples / sizeOfBucket + (numOfApples % sizeOfBucket >= 1 ? 1 : 0);
		System.out.println("�ʿ��� �ٱ����� �� :" + numOfBucket);

	}// end of main
}// end of class
