/**
 * �ڹ��� Ŭ������ ���ϻ�Ӹ��� ����Ѵ�(�ָŸ�ȣ�� ������ �����ϱ� ���ؼ� ���߻���� ������ ������) �������̽��� �����ϴµ�, ��������
 * �������̽��� ������ �� �ִ�
 */
public class TestInterface2 {
	public static void main(String[] args) {

	}// end of main
}// end of class

interface Movable {// ~able�� ������ �̸����� ����Ѵ�
	void move();
}

interface Attackable {
	void attack();// public static / abstract����

}

class BBB {
}

class Fight extends BBB implements Movable, Attackable {
	@Override
	public void attack() {

	}

	@Override
	public void move() {

	}
}