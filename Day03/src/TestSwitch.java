/**
 * �帧 ���� : if, switch, ���׿�����
 */
public class TestSwitch {
	public static void main(String[] args) {
		int num = 4;

		switch (num) {// ���ǰ����� �� �� �ִ� ��, int ���� ���� ����,
		case 3:
			System.out.println(3);
			break;
		case 4:
			System.out.println(4);
			break;// switch���� ����������
		case 5:
			System.out.println(5);
			break;
		}

		int jumsoo = 8;
		// 10, 9 �� 8 �� 7 �� 6 �� ������ (1~5) ��

		int jungsoo = 8;
		switch (jungsoo) {
		case 10:
		case 9:
			System.out.println("��");
			break;
		case 8:
			System.out.println("��");
			break;
		case 7:
			System.out.println("��");
			break;
		case 6:
			System.out.println("��");
			break;
		case 5:
		case 4:
		case 3:
		case 2:
		case 1:
			System.out.println("��");
			break;

		default:// �ش�Ǵ� case���� ���� ��� �����
			System.out.println("�⺻��");
			break;
		}

		// 100~90 �� 89~80 �� 79~70 �� 69~60 �� 59~0 ��
		int jumsu = 89;

		switch (jumsu / 10) {
		case 10:
		case 9:
			System.out.println("��");
			break;
		case 8:
			System.out.println("��");
			break;
		case 7:
			System.out.println("��");
			break;
		case 6:
			System.out.println("��");
			break;
		default:
			if (jumsu >= 0 && jumsu <= 100)
				System.out.println("��");
			break;
		}

	}// end of main
}// end of class
