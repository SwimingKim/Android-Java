import java.util.Arrays;

public class GenericMethodTest {
	public static void main(String args[]) {
		Integer[] iArray = { 10, 20, 30, 40, 50 };
		Double[] dArray = { 1.1, 1.2, 1.3, 1.4, 1.5 };
		Character[] cArray = { 'K', 'O', 'R', 'E', 'A' };

		// ���׸� �޼ҵ带 �̿��Ͽ�, �־��� GenericMethodTest.java ���Ͽ�
		// ��� Ÿ���� �迭�� ����� �� �ִ� printArray �޼ҵ带 �����غ�����.
		// ���� ����� ������ ���ƾ� �մϴ�. (15)
		// 10 20 30 40 50
		// 1.1 1.2 1.3 1.4 1.5
		// K O R E A

		printArray(iArray);
		printArray(dArray);
		printArray(cArray);

	}// end of main

	static void printArray(Integer[] iArray) {
		for (int i = 0; i < iArray.length; i++) {
			System.out.print(iArray[i] + " ");
		}
		System.out.println("");
	};

	static void printArray(Double[] dArray) {
		for (int i = 0; i < dArray.length; i++) {
			System.out.print(dArray[i] + " ");
		}
		System.out.println("");
	};

	static void printArray(Character[] cArray) {
		for (int i = 0; i < cArray.length; i++) {
			System.out.print(cArray[i] + " ");
		}
		System.out.println("");
	};
}// end of class
