/**
 * �������̵�(Over riding):����Ŭ�����κ��� ��ӹ��� �޼����� ������ �������ϴ� �� ���� :�θ�Ŭ������ �޼��� ����ο� �ڽ�Ŭ��������
 * �������ϴ� �޼��� ����ΰ� �����ؾ���
 * 
 * �����ε����� ������ �����ε�(Over loading) : �ϳ��� Ŭ���� �ȿ��� �޼����� �̸��� �����ϰ� ����ϴ� �� ���� : �Ű�������
 * ���� or Ÿ�� or ������ �޶�� �Ѵ�
 */
public class TestOverriding {
	public static void main(String[] args) {
		PP pp = new PP();
		pp.x = 1;
		pp.y = 2;
		pp.printPP();

		PPP ppp = new PPP();
		ppp.x = 40;
		ppp.y = 50;
		ppp.z = 60;
		ppp.printPP();

	}// end of main
}// end of class

class PP {// 2���� ��ǥ��
	int x;
	int y;

	void printPP() {
		System.out.println(x + "," + y);
	}
}

class PPP extends PP {// 3���� ��ǥ��
	int z;

	// @Override
	// void printPP() {
	// super.printPP();
	// }

	@Override // ������̼� :�������̵� ����� ���������Ƿ� ����ΰ� ���ƾ����� �ǹ�
	void printPP() {
		// System.out.println(x+","+y+","+z);
		super.printPP();
		System.out.print("," + z);
	}

}
