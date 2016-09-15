
public class Google {
	public static void main(String[] args) {
		int num[] = new int[10];// 0~9

		for (int i = 1; i <= 8888; i++) {
			num[i / 1000 % 10]++;
			num[i / 100 % 10]++;
			num[i / 10 % 10]++;
			num[i % 10]++;
		}
		System.out.println("8개의 개수 = " + num[8]);

	}
}
