
public class Daum {
	public static void main(String[] args) {
		int s[] = { 1, 3, 4, 8, 13, 17, 20 };

		int min = s[1] - s[0];
		int a = 0;
		int b = 0;
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s.length; j++) {
				if (s[j] - s[i] > 0 && min > s[j] - s[i]) {
					min = s[j] - s[i];
					a = i;
					b = j;
				}
			}
		}
		System.out.println("정해진 수에서 가장 작은 결과는 " + min);
		System.out.println("그 수는 " + s[a] + "," + s[b]);

	}
}
