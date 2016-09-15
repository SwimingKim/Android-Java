/**
 * ������(Polymorphism) : ��ü�� ���� ������ ���������� ���� �� �ִ� ���� => �θ��� ���������� �ڽ��� ��ü�� ���� �� �ִ�
 */

// �ڹٿ����� ���߻���� �ȵȴ�
// �ֳ��ϸ�, ��Ȯ�� �� ����� ���ؼ� = �ָŸ�ȣ�� �� ���ֱ� ���ؼ�
class Q {
}

class R extends Q {
}

class P extends Q {
}

class T extends P {
}

public class TestPolymorphism {
	public static void main(String[] args) {
		Q q = new Q();
		R r = new R();
		P p = new P();
		T t = new T();

		Q q1 = r;
		Q q2 = p;
		Q q3 = t;
		// R r1 = q;//�ڽ��� ���������� �θ��� ��ü�� ���� �� ����
		R rr = (R) q1;// �ڽ��� ���������� �θ��� ��ü�� ���� �� ����, �������� ����ȯ�� �ʿ��ϴ�

	}// end of main
}// end of class
