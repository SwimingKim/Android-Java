/**
 * 퇴근문제2 : 반복문
 */
public class Quiz2 {
	public static void main(String[] args) {

		// 반복문, 재귀함수
		// 15를 10진법에서 3진법으로 바꿔서 출력

		int num = 19;
		int base = 3;

		System.out.println(dap1(num, base));// 반복문으로 진법변환
		System.out.println(dap2(num, base));// 재귀함수로 진법변환

	}// end of main

	static String dap2(int num, int base) {
		if (num == 0)
			return "";
		else
			return dap2(num / base, base) + (num % base);
	}

	static String dap1(int num, int base) {
		String dap = "";// 출력할 문자열
		while (num != 0) {
			dap = num % base + dap;
			num = num / base;
		}
		return dap;
	}
}// end of class
