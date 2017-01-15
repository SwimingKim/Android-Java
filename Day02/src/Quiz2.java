import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class Quiz2 {
	public static void main(String[] args) {

		// 몸무게와 키를 사용자 입력을 받아
		// 비만인지를 판별하여 출력
		// 신체질량지수(BMI)=체중(kg)/[신장(m)]
		// 저체중 20 미만
		// 정상 20이상-25미만
		// 과체중 25이상-30미만
		// 비만 30이상

		Scanner scan = new Scanner(System.in);
		System.out.println("몸무게를 입력하세요");
		int weight = scan.nextInt();
		System.out.println("키를 입력하세요");
		double height = scan.nextInt();
		double bmi = weight / ((height / 100) * (height / 100));
		System.out.println("당신의 BMI는" + bmi + "입니다");

		if (bmi >= 30) {
			System.out.println("비만입니다");
		} else if (bmi >= 25) {
			System.out.println("과체중입니다");
		} else if (bmi >= 20) {
			System.out.println("정상입니다");
		} else {
			System.out.println("저체중입니다");
		}

	}// end of main
}// end of class
