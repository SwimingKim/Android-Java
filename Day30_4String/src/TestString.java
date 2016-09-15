import java.util.Arrays;

/**
 * String 클래스를 활용해서 문자열 처리하는 방법을 알아보자
 * */
public class TestString {
	public static void main(String[] args) {
// 찾고자하는 문자열이 "이름:" 이후에 있을 때 추출방법
		String str1 = "이름:서민규";
//		System.out.println(str1.substring(3));
		
// 찾고자하는 문자열이 "이름:"과 "단계:"사이에 있을 때 추출방법
		String str2 = "이름:서민규단계:9";
		int index = str2.indexOf("단계:");
		System.out.println(str2.substring(3, index));//서민규
//		System.out.println(str2.substring(str2.indexOf("단계:")+3));
		
// "이름/단계/점수/주소" 구분자를 내각 정해놓고 기억하자
		String str3 = "서민규/9/98/Bucheon";
		String arr[] = str3.split("/");
		System.out.println(Arrays.toString(arr));
		String name = arr[0];
		int step = Integer.parseInt(arr[1]);
		int point = Integer.parseInt(arr[2]);
		String address = arr[3];
		
		
		
		
	}//end of main
}//end of class
