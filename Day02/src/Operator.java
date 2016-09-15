/**
 * ������
 */
public class Operator {
	public static void main(String[] args) {
		// ������, �ǿ����� 3+4
		// ���׿�����, ���׿�����, ���׿�����, ���Կ�����
		// ���׿����� : ��ȣ������, ()ĳ���ÿ�����, ����������, ������������
		// ��ȣ������ + -
		int x = 3;
		System.out.println(-x);// ���� �տ��� ��ȣ������ ��밡��

		// ĳ���� ������ : �� ��ȯ �� ���

		// ���� ������ ++ -- ��ġ����������, ��ġ����������
		int a = 4;
		++a;// a=a+1;(��ġ����������)
		System.out.println(a);

		int b = 5;
		System.out.println(b++);// 5 ��ġ���������� : ���� �� ����
		System.out.println(b);// 6

		b = 5;
		System.out.println(++b);// 6 ��ġ���������� : ���� �� ����
		System.out.println(b);// 6

		// ������������ ! : true, false�� ���� ������ų �� ���
		System.out.println(!true);// false
		boolean bb = false;
		System.out.println(!bb);// true

		// ���׿����� : ���������, �񱳿�����, ��Ʈ������, ��������, ����Ʈ������
		// Ư¡ : �ΰ��� �ǿ����� Ÿ���� ���ƾ� �Ѵ�
		// => �ΰ��� �ǿ����� Ÿ���� �ٸ��� ū ���� Ÿ������ �ڵ�����ȯ���ش�
		// => �ǿ����ڿ� ���� Ÿ���� ����� ��ȯ�Ѵ�.

		System.out.println("���������");
		System.out.println(5 + 2);// 7
		System.out.println(5 - 2);// 3
		System.out.println(5 * 2);// 10
		System.out.println(5 / 2);// 2(���׿������� Ư¡)
		System.out.println(5 / (float) 2);// 2.5
		System.out.println(5 % 2);// 1 mod ������������

		// �񱳿����� < > <= >= == !=
		// => �������� true, false�� ������ ��ȯ
		System.out.println("�񱳿�����");
		System.out.println(3 < 4);// true
		System.out.println(3 <= 3);// true
		System.out.println(6 == 7);// false
		System.out.println(6 != 7);// true �ٸ��� ��

		// ��Ʈ������ &(and) |(or)
		// => �ǿ����ڰ� ����, ������ ���� => true, false�� ��ȯ
		System.out.println("��Ʈ������");
		System.out.println(true & true);// true
		System.out.println(true & false);// false
		System.out.println(false & true);// false
		System.out.println(false & false);// false

		System.out.println(true | true);// true
		System.out.println(true | false);// true
		System.out.println(false | true);// true
		System.out.println(false | false);// false

		// �������� &&||
		// => �ǿ����ڰ� ������ ���� => true, false�� ��ȯ
		// => ��� ���� ��Ʈ�����ڿ� ����, ȿ������ ���� ����
		System.out.println("��������");
		System.out.println(true && true);// true
		System.out.println(true && false);// false
		System.out.println(false && true);// false
		System.out.println(false && false);// false

		System.out.println(true || true);// true
		System.out.println(true || false);// true
		System.out.println(false || true);// true
		System.out.println(false || false);// false

		// ����Ʈ ������ << >>

		// ���� ������ (���ǽ�) ? (���� ���) : (������ ���)
		int t = 3 < 5 ? 5 : 3;
		System.out.println(t);
		System.out.println(3 < 5 ? "5�Դϴ�" : 3);

		// ���Կ����� =�� ���׿������� ����
		int d;
		d = 3;
		d += 4; // d=d+4;
		System.out.println(d);
		d -= 4; // d=d-4
		d *= 4; // d=d*4
		d /= 4; // d=d/4
		d %= 4; // d=d%4
		d |= 4; // d=d|4

		d = 3;
		d *= 4 + 6;// d=d*(4+6)
		System.out.println(d);// 30
		System.out.println(3 ^ 7);// 4

		int r = 3 * 4 * 5;
		int p = 4, e = 5;

		r = p = e;// ��->�·� ������ �����Ѵ�(���Կ�����)
		System.out.println("" + r + p + e);
		System.out.println((-6) * (-7));

		System.out.println(p == 5 && r < e);

	}// end of main
}// end of class
