import java.util.Arrays;

/**
 * 반복문 활용
 */
public class TestStar {
	public static void main(String[] args) {
		// ******

		// for (int i = 0; i < 6; i++) {
		// System.out.printf("*");
		// }

		// *
		// **
		// ***
		// ****
		// *****

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < i; j++) {
				System.out.printf("*");
				if (j == i - 1)
					System.out.println("");
			}
		}

		for (int i = 1; i < 6; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}

		// *****
		// ****
		// ***
		// **
		// *

		for (int i = 5; i >= 1; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}

		// *41
		// **32
		// ***23
		// ****14
		// *****05

		for (int i = 1; i <= 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}

		// *****05
		// ****14
		// ***23
		// **32
		// *41

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 5 - i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}

		// **2
		// ****4
		// ******6
		// ********8
		// **********10

		for (int i = 2; i <= 10; i += 2) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}

		// **2 10
		// ****4 6
		// ******6 4
		// ********8 2
		// **********10 0
		// ********8 2
		// ******6 4
		// ****4 6
		// **2 8
		System.out.println("여기");
		for (int i = 2; i <= 18; i += 2) {
			if (i <= 10) {
				for (int j = 0; j < i; j++) {
					System.out.print("*");
				}
			} else {
				for (int j = 0; j < 20 - i; j++) {
					System.out.print("*");
				}
			}
			System.out.println("");
		}

	}// end of main
}// end of class
