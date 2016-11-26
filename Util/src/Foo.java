import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Foo {
	static String game_str="";
	
	public static void main(String[] args) {
        // 버퍼 생성
        BufferedReader br = null;        
         
        // Input 스트림 생성
        InputStreamReader isr = null;    
         
        // File Input 스트림 생성
        FileInputStream fis = null;        
 
        // File 경로
        File file = new File("C:\\Users\\Administrator\\Desktop\\memo.txt");

        // 버퍼로 읽어들일 임시 변수
        String temp = "";
         
        // 최종 내용 출력을 위한 변수
        String content = "";
        String text="";
        ArrayList<String> arr;
        try {
             
            // 파일을 읽어들여 File Input 스트림 객체 생성
            fis = new FileInputStream(file);
             
            // File Input 스트림 객체를 이용해 Input 스트림 객체를 생서하는데 인코딩을 UTF-8로 지정
            isr = new InputStreamReader(fis, "UTF-8");
             
            // Input 스트림 객체를 이용하여 버퍼를 생성
            br = new BufferedReader(isr);
         
            arr = new ArrayList<String>();
            // 버퍼를 한줄한줄 읽어들여 내용 추출
            while( (temp = br.readLine()) != null) {
            	arr.add(temp + "\n");
            	

            }
			int num = arr.size();
			int i = 0;
			game_str="";
			int j=1;
			for (i = 0; i < num; i++) {
				String str = arr.get(i);
				String[] arrr = str.split("=");
				game_str = arrr[2];
				
				String[] arrrr = game_str.split("&");
				game_str = arrrr[0];
				
				game_str =game_str.replaceAll("(^\\p{Z}+|\\p{Z}+$)", "");
				//game_str =game_str.replaceAll("\\s", "");
				//game_str =game_str.replaceAll(" ", "");
				game_str =game_str.trim();
				

				File file1 = new File("C:\\Users\\Administrator\\Desktop\\korea\\"+ game_str+".mp3");
				 File file2 = new File("C:\\Users\\Administrator\\Desktop\\korea\\"+ j+".mp3");


				    if (!file1.renameTo(file2)) {
				     //System.err.println("이름 변경 에러 : " + file1);

				    }else{
				   	 System.err.println("이름 변경 : " + file1 +" > "+file2);
				    }
			
			content += game_str+ "\n"; //+ "\n"
				// String stringForIntArray = Arrays.toString(game_str);
				
				j++;
				
				
			}
			//System.out.println("================== 파일 내용 출력 ==================");
			System.out.println(content);

			    
        } catch (FileNotFoundException e) {
            e.printStackTrace();
             
        } catch (Exception e) {
            e.printStackTrace();
             
        } finally {
 
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
             
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
             
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
             
        }
         
    }

	public void printFileNameList(String filePath) {

		File f = new File(filePath);

		File listFile[] = f.listFiles();

		int num = 1;
		for (int i = 0; i < listFile.length; i++) {
			String string1 = listFile[i].getName();

			System.out.println(listFile[i].getName());

			File file1 = new File("D:/사전/작업중폴더/합/" + string1);
			File file2 = new File("D:/사전/작업중폴더/합/" + num + ".mp3");

			if (!file1.renameTo(file2)) {
				System.err.println("이름 변경 에러 : " + file1);
			}
			num++;
		}
	}

}
