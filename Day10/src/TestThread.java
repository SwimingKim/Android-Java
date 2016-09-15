/**
 * ������ Thread - �ϳ��� ���μ���(����� ���α׷�) �ȿ��� �ú��� �����ٸ��� ����, ��ġ ���ÿ� ���� �۾��� �����ϴ� ���� ȿ����
 * �ִ� ��
 */
public class TestThread {
	public static void main(String[] args) {

		MyT mt = new MyT();
		mt.start();

		Thread t = new Thread(new Runnable() {// �������̽� ����
			public void run() {// ������ ������� ���۽�ų �۾�
				for (int i = 0; i < 100000; i++) {
					System.out.println("��");
				}
			}
		});
		t.start();

		for (int i = 0; i < 100000; i++) {
			System.out.println("|");
		}

	}// end of main
}// end of class

class MyT extends Thread {// Thread Ŭ������ ��ӹ޾Ƽ� run �޼��� ����
	@Override
	public void run() {
		for (int i = 0; i < 100000; i++) {
			System.out.println("��");
		}
	}
}