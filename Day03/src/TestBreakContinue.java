/**
 * �ݺ����� �帧����-break,continue break : ���� ����� switch�� or �ݺ��� �ϳ��� ���������� continue :
 * �ݺ����� ���� ������ �Ѿ��.
 */
public class TestBreakContinue {
	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 1) {
					continue;
				}
				System.out.println(i + "," + j);
			}

		}

		xx: for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 4; k++) {
					if (k == 1) {
						break xx;// �ݺ��� �տ� �پ��ִ� ���� ��������
					}
					System.out.println("" + i + j + k);
				}
			}

		}

	}// end of main
}// end of class
