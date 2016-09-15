
/**
 * package 패키지 : 클래스들의 묶음
 * 		관리를 편리하게 하기 위해, 관련된 클래스들끼리 구분해서 묶어줌
 * 		패키지의 이름은 소문자로 작성하자
 * 클래스의 full name : 패키지명. 클래스명		 
 * */

import java.io.BufferedReader;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Scanner;
//같은 패키지를 한 줄로 표시할 수 있다
import java.util.*;

import angel.kr.ac.www.TestCAU;

public class TestPackage {
	public static void main(String[] args) {
		Scanner scan;
		// angel.kr.ac.www.TestCAU cau = new angel.kr.ac.www.TestCAU();
		TestCAU cau = new TestCAU();// 풀네임 작성하지 않고 클래스 명으로 접근 - import하지 않음
		Date d;
		BufferedReader br;
		Calendar c;
		Bcc b;
		// 컴파일러가 java.lang 패키지를 임포트해준다
		String str;// import없이 사용
		Math.random();// import없이 사용

	}// end of main
}// end of class

class Bcc {

}
