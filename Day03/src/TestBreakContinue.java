/**
 * 반복문의 흐름제어-break,continue break : 가장 가까운 switch문 or 반복문 하나를 빠져나간다 continue :
 * 반복문의 다음 차수로 넘어간다.
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
						break xx;// 반복문 앞에 붙어있는 라벨을 빠져나감
					}
					System.out.println("" + i + j + k);
				}
			}

		}

	}// end of main
}// end of class
