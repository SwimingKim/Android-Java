/**
 * ������ Constructor : ������ �ʱ�ȭ - �޼���� ����ϴ�(�빮�ڷ� �����Ѵ�) - �����ڸ��� Ŭ������ �̸��� �����ϴ� - ���ڰ���
 * ���� �����ڴ� �⺻������ - ����Ÿ���� ���� - ��� �ۼ��� Ŭ�������� �ݵ�� �ϳ� �̻��� �����ڰ� �����ؾ� �Ѵ� - �츮�� �����ڸ�
 * �ϳ��� �ۼ����� ������,�����Ϸ��� �⺻ �����ڸ� �߰����ش�
 */
public class TestCar {
	public static void main(String[] args) {

		// Car c1 = new Car();
		// c1.name = "Ƽ��";
		// c1.color = "����";
		// c1.speed = 80;

		Car c1 = new Car("�ƹݶ�", "���", 600);

		c1.speedUp();
		c1.printCar();

		Car c2 = new Car("�׷���", "����", 200);

		Car c3 = new Car("���Ϻ�", "����", 150);

	}

}

class Car {
	String name;
	String color;
	int speed;

	Car() {// �⺻������

	}

	Car(String n, String c, int s) {// ������
		name = n;// �����ڿ��� �ַ� ������ �ʱ�ȭ �۾��� �Ѵ�
		color = c;
		speed = s;
		printCar();
	}

	void speedUp() {// speed 1 ����
		speed++;
	}

	void speedDown() {// speed 1 ����
		speed--;
	}

	void printCar() {// ������� �� ���
		System.out.println("�ش� ���� " + name + "�̰�,\n" + "������ " + color + "�̰�,\n" + "�ӵ��� " + speed + "�̴�");
	}

}