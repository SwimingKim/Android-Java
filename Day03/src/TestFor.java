/**
 * �ݺ���:for, while, do~while
 */
public class TestFor {
	public static void main(String[] args) {
		// for(�ʱ��;���ǽ�;������){
		// �ݺ��� ����;
		// }
		// �ʱ�� -> ���ǽ� -> �ݺ��ҹ��� -> ������
		// |----------------|

		// System.out.println("******");

		for (int i = 0; i < 3; i++) {
			System.out.println(i);
		}

		// 0,1,2,3,4,5
		for (int i = 0; i < 6; i++) {
			System.out.println(i);
		}

		// 2,4,6,8
		for (int i = 2; i <= 8; i += 2) {
			System.out.print(i);
		}

		System.out.println();

		// 1 3 5 7
		for (int i = 1; i <= 7; i += 2) {
			System.out.print(i + " ");
		}

		// ���ѷ���
		// for (int i = 0; ; i++) { //���ǽ��� �� ����, ������ ������
		// System.out.println("********");
		// }

		// ���ѷ���
		// for (int i = 0; i < 2; ) {//i���� �׻� 0�̹Ƿ�, ������ �׻� ���̴�
		// System.out.println("*****");
		// }

		for (;;) {// ���ѷ���
			System.out.println("*****");// ���ǽ� ������ �׻� ��
		}

		// �ʱ�Ŀ��� ���� Ÿ���� ���������� ������ �� �� �ִ�.
		// for (int i=1, j=15 ; i < 10 ; i++){
		// System.out.println(i+j+"");
		// };

		// for (int i = 0; i < 3&& i>-1; i++) {
		// System.out.println("ppp");
		// }
	}// end of main
}// end of class
