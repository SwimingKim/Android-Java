
public class memo {
	public static void main(String[] args) {

		int arr[][] = new int[10][10];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i % 2 == 0) {
					arr[i][j] = 0;
				} else {
					arr[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] == 0 ? "□ " : "■ ");
			}
			System.out.println("");
		}

		System.out.println("");

		int array[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
				{ 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, }, { 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, }, { 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, },
				{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, }, { 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, }, { 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, },
				{ 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, }, { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, }, };

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] == 0 ? "□ " : "■ ");
			}
			System.out.println("");
		}

	}// end of main
}// end of class
