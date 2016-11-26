import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Upload {

	public static void main(String[] args) throws IOException {

		ArrayList<String> name = new ArrayList<>();

		File dir = new File("C:\\Users\\Administrator\\Desktop\\all\\"); 
		File[] fileList = dir.listFiles(); 
		for(int i = 0 ; i < fileList.length ; i++){
			//			for(int i = 0 ; i < fileList.length ; i++){
			File file = fileList[i]; 
			if(file.isFile()){
				System.out.println(file.getName());
				name.add(file.getName().replace(".mp3", ""));
			}
		}

		String fileName = "C:\\Users\\Administrator\\Desktop\\array\\allfile.txt";


		PrintWriter pw = new PrintWriter("C:\\Users\\Administrator\\Desktop\\array\\allfile.txt");
		for(int i = 1; i < name.size(); i++) {
//			String data = i+" 번째 줄입니다.";
			pw.println(name.get(i));
		}
		pw.close();

		//		try{
		//			BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
		//			
		//			// 파일안에 문자열 쓰기
		//			for (int i = 0; i < name.size(); i++) {
		//				fw.write(name.get(i));
		//			}
		//			
		//			fw.flush();
		//			
		//			// 객체 닫기
		//			fw.close(); 
		//			
		//			
		//		}catch(Exception e){
		//			e.printStackTrace();
		//		}



	}//end of main
}//end of class
