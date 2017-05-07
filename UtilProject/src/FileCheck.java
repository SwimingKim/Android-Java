import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileCheck {
	public static void main(String[] args) {

		// 음성 파일 목록 불러오기
		ArrayList<String> eng = new ArrayList<String>();
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\SuYoung\\Desktop\\allfile.txt");
			Scanner s = new Scanner( fis );
			while ( s.hasNext( ) ){
				eng.add(s.nextLine());
			}
		} catch ( Exception e ){
			e.printStackTrace( );
		}


		// 필요한 파일 불러오기
		ArrayList<String> word = new ArrayList<String>();
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\SuYoung\\Desktop\\memo.txt");
			Scanner s = new Scanner( fis );
			while ( s.hasNext( ) ){
				word.add(s.nextLine());
			}
		} catch ( Exception e ){
			e.printStackTrace( );
		}


		for (int i = eng.size()-1; i >= 0; i--) {
			for (int j = word.size()-1; j >= 0; j--) {
				if (eng.get(i).equals(word.get(j))) {			
					//word.remove(j);
					word.set(j, "0");
				}
			}
		}


		for (int i = 0; i < word.size(); i++) {
			if (!"0".equals(word.get(i))) {
				System.out.println(i + "||" + word.get(i));
			}
		}




	}//end of main
}//end of class
