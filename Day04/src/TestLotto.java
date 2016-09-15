import java.util.Random;

/**
 * 로또번호 생성기
 */
public class TestLotto {
	public static void main(String[] args) {
		// 로또번호 6개를 출력하는 프로그램을 작성하시오.
		Random ran = new Random();
		// ran.nextInt(45)+1;//0+1<= ran+1<45+1
		System.out.println(ran.nextInt(45) + 1);
		System.out.println(ran.nextInt(45) + 1);
		System.out.println(ran.nextInt(45) + 1);
		System.out.println(ran.nextInt(45) + 1);
		System.out.println(ran.nextInt(45) + 1);
		System.out.println(ran.nextInt(45) + 1);

		int lotto[] = new int[6];
		int count = 0;// 로또 뽑은 개수
		while (count < 6) {// 6개 모두 뽑으면 빠져나감
			int r = ran.nextInt(45) + 1;

			// 이전에 뽑았던 로또 번호와 같은지 확인
			boolean isSame = false;// 중복이 있는 체크하는 변수
			if (lotto[0] == r)
				isSame = true;// 중복발생
			if (lotto[1] == r)
				isSame = true;// 중복발생
			if (lotto[2] == r)
				isSame = true;// 중복발생
			if (lotto[3] == r)
				isSame = true;// 중복발생
			if (lotto[4] == r)
				isSame = true;// 중복발생
			if (lotto[5] == r)
				isSame = true;// 중복발생

			for (int i = 0; i < count; i++) {// 이전 것들과 비교
				if (lotto[i] == r)
					isSame = true;// 중복발생
			}

			if (isSame == false) {
				lotto[count] = r;
				count++;
			}
		} // end of while

		// 배열에 저장해둔 로또번호 출력하기
		for (int i = 0; i < lotto.length; i++) {
			System.out.println(lotto[i]);
		}

	}// end of main
}// end of class
