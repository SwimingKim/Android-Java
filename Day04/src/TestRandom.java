import java.util.Random;

/**
 * 랜덤 - 무작위의 수를 얻을 수 있는 방법 Math 클래스의 random()매서드 Random 클래스에서도 제공한다
 */
public class TestRandom {
	public static void main(String[] args) {
		System.out.println(Math.random());
		// 0.0 <= Math.Random() < 1.0
		// 0,1,2,3

		System.out.println((int) (Math.random() * 2));
		System.out.println((int) (Math.random() * 3));
		System.out.println((int) (Math.random() * 4));

		Random ran = new Random();
		System.out.println(ran.nextInt(4));
		System.out.println(ran.nextInt(4));
		System.out.println(ran.nextInt(4));

		System.out.println(ran.nextInt(4) + 1);// 1<=ran+1<5

		int num[] = {};
		double num2[] = { 3.14, 2.6, 3, 4.0 };
		char num3[] = { 'd', 'w', 'a', '\n', ' ' };
		String str[] = { "asdf", "234", "sdf245" };

		System.out.println(str[0]);

		String menu[] = { "닭갈비", "칼국수", "국밥", "된장찌개", "짜장면" };

		Random ran2 = new Random();
		ran2.nextInt(menu.length);
		int n = ran2.nextInt(menu.length);
		System.out.println(menu[n]);

	}// end of main
}// end of class
