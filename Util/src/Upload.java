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
//			String data = i+" ��° ���Դϴ�.";
			pw.println(name.get(i));
		}
		pw.close();

		//		try{
		//			BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
		//			
		//			// ���Ͼȿ� ���ڿ� ����
		//			for (int i = 0; i < name.size(); i++) {
		//				fw.write(name.get(i));
		//			}
		//			
		//			fw.flush();
		//			
		//			// ��ü �ݱ�
		//			fw.close(); 
		//			
		//			
		//		}catch(Exception e){
		//			e.printStackTrace();
		//		}



	}//end of main
}//end of class
