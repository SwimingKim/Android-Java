
public class TestIfElse {
	public static void main(String[] args) {
		// if (���ǽ�) {
		// ���ǽ��� ���� ��� �߻�
		// }

		// switch (����) {// switch���� ���� �� �ִ� ���ǽ� : int�������� ����, ���ڿ��� ����
		// case value:
		//
		// break;
		//
		// default:
		// break;
		// }

		// ��100~90 ��89~80 ��79~70 ��69~60 ��59~0 ���
		int jumsoo = 73;
		switch (jumsoo / 10) {
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
		default:
			break;
		}

	}// end of main
}// end of class
