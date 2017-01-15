/**
 * 점심문제
 */
public class Quiz {
	public static void main(String[] args) {
		// 삼각형의 넓이를 출력하는 코드 작성
		int width = 7;
		int height = 5;
		System.out.println(width * height / 2.);

		// 사과를 담는데 필요한 바구니(버켓)의 수를 구하는 코드작성
		// 만일 사과의 수가 123개이고 하나의 바구니에는 10개의 사과를 담을 수 있다면,
		// 13개의 바구니가 필요할 것이다.
		int numOfApples = 123;// 사과의 개수
		int sizeOfBucket = 10;// 바구니의 크기(바구니에 담을 수 있는 사과의 개수)
		int numOfBucket = numOfApples / sizeOfBucket + (numOfApples % sizeOfBucket == 0 ? 0 : 1);
		System.out.println("필요한 바구니의 수 : " + numOfBucket);

		// 최소의 동전 개수로 거스름돈을 주려면 어떻게 배분해야 할까요?
		int change = 3780;// 원 거스름돈

		System.out.println("500원" + change / 500 + "개");
		int coin = change % 500; // 3780 - 500*change/500;
		System.out.println("100d원" + change % 500 / 100 + "개");
		System.out.println("50원" + change % 100 / 50 + "개");
		System.out.println("10원" + change % 50 / 10 + "개");

	}// end of main
}// end of class
