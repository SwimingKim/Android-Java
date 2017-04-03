/**
 * 연산자
 */
public class TestOper {
	public static void main(String[] args) {
		// 연산자를 피연산자의 개수에 따라
		// 단항연산자, 이항연산자, 삼항연산자, 대입연산자
		// 단항연산자 : ++ -- +/- !
		int a = 3;
		a++;// 4
		++a;// 5
		a--;// 4

		a = -3;// 부호연산자
		a = -a;

		boolean b = false;
		b = !b;// 논리부정연산자
		b = !true;

		// 이항 연산자
		int c = 3 + 4;
		c = 5 % 2;// 나머지 연산자

		boolean bb = true && false;// 논리연산자(효율적인 연산을 한다)
		bb = true || false;

		bb = false & false;// 비트연산자
		bb = true | false;

		// if (args instanceof type) {// args 변수의 내용이 "type"으호 형변환이 가능한지
		// type new_name = (type) args;
		//
		// }

		// 삼항 연산자
		int z = (3 < 5) ? 7 : 8;

		// 대입 연산자 : =(등호) 와 이항연산자의 조합
		int y = 4;
		y += 2; // y = y+2;
		y -= 2;
		y *= 2;
		y %= 2;
		y &= 2;

		int numOfApples = 123;
		int sizeOfBucket = 10;
		int numOfBucket = numOfApples / sizeOfBucket + (numOfApples % sizeOfBucket >= 1 ? 1 : 0);
		System.out.println("필요한 바구니의 수 :" + numOfBucket);

	}// end of main
}// end of class
