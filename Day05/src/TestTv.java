/**
 * Ŭ���� �޼��� Ȱ��
 */
public class TestTv {
	public static void main(String[] args) {

		Tv t1 = new Tv();
		t1.name = "�Ｚ�ĺ�";
		t1.size = 40;
		t1.channel = 11;
		t1.volumn = 10;
		t1.power = false;
		int x = t1.add(3, 9);
		System.out.println(x);
		System.out.println(t1.add(3, 9));
		System.out.println(t1.add2(9));

		System.out.println(t1.channel);
		t1.channelDown();
		t1.channelDown();
		System.out.println(t1.channel);

		t1.powerOnOff();
		System.out.println(t1.power);

		t1.ppp();
		t1.printPower();

	}// end of main
}// end of class

class Tv {// �߻�ȭ �۾�
	String name;// ��ǰ��
	int size;// ȭ�� ũ��
	int channel;// ä��
	int volumn;// �Ҹ�ũ��
	boolean power;// ����

	void printPower() {// ���� ���� ���°� �������� �������� ���
		System.out.println(power ? "�����ֽ��ϴ�" : "�����ֽ��ϴ�");
	}

	void powerOnOff() {// �Ŀ� ��->����, ��-> �Ѷ�

		// if(power){
		// power = false;
		// } else power = true;

		// power = power ? false : true;
		power = !power;
	}

	// void powerOn(){
	// power=true;
	// }
	//
	// void powerOff() {
	// power=false;
	// }
	//
	void channelDown() {// ������ ����� channel���� 1������Ű��
		channel--;
	}

	void channelUp() {// ������ ����� channel���� 1������Ű��
		channel++;
	}

	// �޼���(���๮���� ����)
	// ��ȯ�� : ���ϰ� - 1���� ��밡��, �����Ϸ��� void
	// �޼���� : �Լ� ȣ��� ����ϴ� �̸�
	// ���ڰ� : �Ķ����, �Ű����� - ������� �ʾƵ� �ǰ�, �������� ���ڸ� ����� �� �ִ�.
	// ��ȯ��, �޼����, ���ڰ�
	void ppp() {
		System.out.println("���� �޼����");
		return;// ����Ÿ���� void�� ���� return���� �ᵵ �ǰ� �� �ᵵ �ȴ�
	}

	int add2(int x) {// ���ڰ��� �޾Ƽ� +2�Ͽ� �����ϴ� �޼���
		int y = x + 2;
		return y;
	}

	int add(int x, int y) {// ���ڰ��� �ΰ� �޾Ƽ� ���ؼ� �����ϴ� �޼���
		int z = x + y;
		return z;
	}
}