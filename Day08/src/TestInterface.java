/**
 * �������̽� interface : ������(�����)�� �ִ� �� (Ŭ������ �ƴϴ�)
 * 
 */
public class TestInterface {
	public static void main(String[] args) {
		// I i = new I();//�������̽��δ� ��ü�����Ұ�
		MyI m = new MyI();
	}// end of main
}// end of class

class MyI implements I {// interface�� �����Ѵ�
	@Override
	public void print() {
	}

	@Override
	public void p() {
	}
}

interface I {
	public static final int a = 3;// ��� �������� public static final�� �����ؾ� ��
	int b = 4;// �� �����ڸ� �������� ������, �����Ϸ��� �˾Ƽ� �߰����ش�
	static int c = 5;// ������ �κ��� �˾Ƽ� �߰����ش�

	public abstract void print();// ��� �޼��忡�� public abstract�� �����ؾ� ��

	void p();// �� �����ڸ� �������� ������, �����Ϸ��� �˾Ƽ� �߰����ش�

}