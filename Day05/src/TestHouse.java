
public class TestHouse {
	public static void main(String[] args) {
		House ho1 = new House();
		ho1.address = "������";
		ho1.roomNum = 3;
		ho1.size = 34;
		ho1.hasElavator = true;
		ho1.hasParkingPlace = true;
		ho1.print();

	}// end of main
}// end of class

class House {
	String address;
	int roomNum;// �氳��
	int size;// ���
	boolean hasElavator;// ���������� ����
	boolean hasParkingPlace;// ������ ����

	void print() {// ������� �� ���
		System.out.println(address + "�� ��ġ�� ����\n" + "���� ������ " + roomNum + "���̰�,\n" + "����� " + size + "���̰�,\n"
				+ "���������ʹ� " + (hasElavator ? "�ְ�,\n" : "����,\n") + "�������� " + (hasParkingPlace ? "�ֽ��ϴ�" : "�����ϴ�"));
	}

}
