import java.util.Random;

/**
 * �ζǹ�ȣ ������
 */
public class TestLotto {
	public static void main(String[] args) {
		// �ζǹ�ȣ 6���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		Random ran = new Random();
		// ran.nextInt(45)+1;//0+1<= ran+1<45+1
		System.out.println(ran.nextInt(45) + 1);
		System.out.println(ran.nextInt(45) + 1);
		System.out.println(ran.nextInt(45) + 1);
		System.out.println(ran.nextInt(45) + 1);
		System.out.println(ran.nextInt(45) + 1);
		System.out.println(ran.nextInt(45) + 1);

		int lotto[] = new int[6];
		int count = 0;// �ζ� ���� ����
		while (count < 6) {// 6�� ��� ������ ��������
			int r = ran.nextInt(45) + 1;

			// ������ �̾Ҵ� �ζ� ��ȣ�� ������ Ȯ��
			boolean isSame = false;// �ߺ��� �ִ� üũ�ϴ� ����
			if (lotto[0] == r)
				isSame = true;// �ߺ��߻�
			if (lotto[1] == r)
				isSame = true;// �ߺ��߻�
			if (lotto[2] == r)
				isSame = true;// �ߺ��߻�
			if (lotto[3] == r)
				isSame = true;// �ߺ��߻�
			if (lotto[4] == r)
				isSame = true;// �ߺ��߻�
			if (lotto[5] == r)
				isSame = true;// �ߺ��߻�

			for (int i = 0; i < count; i++) {// ���� �͵�� ��
				if (lotto[i] == r)
					isSame = true;// �ߺ��߻�
			}

			if (isSame == false) {
				lotto[count] = r;
				count++;
			}
		} // end of while

		// �迭�� �����ص� �ζǹ�ȣ ����ϱ�
		for (int i = 0; i < lotto.length; i++) {
			System.out.println(lotto[i]);
		}

	}// end of main
}// end of class
