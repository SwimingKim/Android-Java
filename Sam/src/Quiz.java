import java.util.Arrays;
import java.util.Scanner;

public class Quiz {
	public static void main(String[] args) {

		System.out.println("�� ������ ������ �Է��ϼ���");
		Scanner scan = new Scanner(System.in);
		int T = Integer.valueOf(scan.nextLine());
		int og = T;

		// Ư�� ���ڵ��� 1���� ���� ��δ� ����
		int num_og = 0;
		int num = 0;

		// for (int j = 2; j <= 63; j++) {
		// int path=1;
		//
		// num_og = j;
		// num = num_og;
		// while (num!=1) {
		// path++;
		// if (num%2==0) {
		// num=num/2;
		// System.out.print("-"+num);
		// } else{
		// num=num*3+1;
		// System.out.print("-"+num);
		// }
		// }
		// System.out.println("");
		// System.out.println(num_og+"�� 1���� ���� ��δ� "+path);
		// System.out.println(path+"���� 1���� ���� ���ڴ� "+num_og+"\n");
		// }
		//
		int one;
		int two;

		int[][] dap;
		for (int i = 2; i <= 63; i++) {
			int path = 1;

			num_og = i;
			num = i;
			while (num != 1) {
				path++;
				if (num % 2 == 0) {
					num = num / 2;
					System.out.print("-" + num);
					continue;
				} else {
					num = num * 3 + 1;
					System.out.print("-" + num);
					continue;
				}
			}
			one = path;
			two = num_og;
		}
		// for (int i = 0; i < dap.length; i++) {
		// for (int j = 0; j < dap[i].length; i++) {
		// System.out.println(dap[3][j]);
		// }
		// }

	}// end of main
}// end of class

class Fun {
	public Fun() {
	}

}