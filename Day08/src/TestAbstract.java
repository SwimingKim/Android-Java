/**
 * �߻�Ŭ���� - �̿ϼ�Ŭ���� �߻�޼��带 ���� �� �ִ� Ŭ����
 */
public class TestAbstract {
	// abstract void ppp();�Ϲ�Ŭ�������� �߻�Ŭ������ ���� �� ����
	void print() {// �Ϲݸ޼���
		SmartTv s = new SmartTv();
		CaptionTv c = new CaptionTv();
		// TV t = new TV();//�߻�Ŭ������ ��ü�� ������ �� ����
		c.powerOnOff();
	}

	public static void main(String[] args) {
	}// end of main
}// end of class

class SmartTv extends TV {// �߻�Ŭ������ ��ӹ޾Ƽ� ��ü �����Ϸ��� : �߻�޼����� �ٵ� �ۼ�
	void powerOnOff() {
	}
}

class CaptionTv extends TV {
	void powerOnOff() {
	}
}

abstract class TV {
	abstract void powerOnOff();// ����θ� �ۼ��ϰ�, ������ �ڽ� Ŭ�������� �����Ѵ�
}

abstract class H {// �߻�Ŭ���� : �߻�޼���, �Ϲݸ޼��带 ���� �� �ִ�
	abstract void print();// �߻�޼��� - �ٵ�(����)�� �������� �ʴ´�

	abstract void ppp();

	void abe() {// �Ϲݸ޼���

	}

}