
public class TestMovie {
	public static void main(String[] args) {
		Movie mo1 = new Movie();
		mo1.title = "�̽�����Ʈ";
		mo1.type = "�׼�";
		mo1.grade = 3;
		mo1.veiwCount = 10000;

		mo1.print();

		Movie mo2 = new Movie();
		mo2.title = "�̼����ļ���";
		mo2.type = "�׼�";
		mo2.grade = 4;
		mo2.veiwCount = 100000;

		mo2.print();

		Movie mmm[] = new Movie[2];
		mmm[0] = mo1;
		mmm[1] = mo2;

	}// end of main
}// end of class

class Movie {
	String title;// ����
	String type;// �帣
	int grade;// ��������
	int veiwCount;// ������

	void print() {// ������� ���
		System.out.println("�ش� ��ȭ�� " + title + "�̰�,\n" + "�帣�� " + type + "�̸�,\n" + "���������� " + grade + "���� ���������,\n"
				+ "�� ���� ���� " + veiwCount + "���Դϴ�.");

	}
}
