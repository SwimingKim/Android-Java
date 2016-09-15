/**
 * Modifiers ������ ������ : Ŭ����, �޼���, ������ ����� �տ� �ۼ��Ͽ� �ΰ����� �ǹ̸� �ο��� static(������, Ŭ������),
 * final(�����, �ٲ� �� ����) ���������� : private, (default), protected, public
 */
public class TestModifiers {
	public int a;
	protected int b;
	int c;
	private int d;

	public static void main(String[] args) {
		final int x = 3;
		// x = 4; ����� ���� �ٲ� �� ����

		// class �տ��� public, default�� �����ϴ�
		// public class�� �ڱ� �ڹ������� �̸��� ���� Ŭ�������� ���� �� �ִ�

	}// end of main
}// end of class

class A {
	final void z() {

	} // �ٸ� Ŭ�������� �޼��带 ������ �� ����

}

class B extends A {
	// @Override//��Ӱ��迡�� �θ�Ŭ������ �޼��带 �ڽ� Ŭ�������� �������ϴ� ��
	// void z(){}

}

final class C {
}// Ŭ������ ������ ������ �� ����
// class D extends C{}//final Ŭ������ ��ӹ��� �� ����

/*
 * private : ���� Ŭ���� �������� ������ �����ϴ� 
 * default : ���� ��Ű�� �������� ������ �����ϴ� 
 * protected : ���� ��Ű�� ������, �׸��� �ٸ� ��Ű���� �ڼ� Ŭ�������� ������ �����ϴ� 
 * public : �������ѿ� ���� ����
 * 
 * ���� Ŭ���� ���� ��Ű�� �ڼ�Ŭ���� ��ü public o o o o protected o o o default o o private o
 * 
 */
