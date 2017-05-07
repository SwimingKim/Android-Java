import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Match {

	public static void main(String[] args) throws IOException {

		ArrayList<String> name = new ArrayList<>();
		ArrayList<String> sound = new ArrayList<>();

		// 사진 목록 부르기
		File dir = new File("C:\\Users\\Administrator\\Desktop\\halfdata\\words\\images\\"); 
		File[] fileList = dir.listFiles(); 
		for(int i = 0 ; i < fileList.length ; i++){
			File file = fileList[i]; 
			if(file.isFile()){
				String temp = "";
				if(file.getName().contains(".jpg")) {
					temp = file.getName().replace(".jpg", "");
				} else if(file.getName().contains(".JPG")) {
					temp = file.getName().replace(".JPG", "");
				} else {
					temp = file.getName();
				}
				name.add(temp);
			}
		}
		System.out.println(name.size());

		// 음성 목록 부르기
		File dir2 = new File("C:\\Users\\Administrator\\Desktop\\halfdata\\words\\sounds\\"); 
		File[] fileList2 = dir2.listFiles(); 
		for(int i = 0 ; i < fileList2.length ; i++){
			File file2 = fileList2[i]; 
			if(file2.isFile()){
				sound.add(file2.getName().replace(".mp3", ""));
			}
		}
		System.out.println(sound.size());


		for (int j = sound.size()-1; j >= 0; j--) {
			for (int i = name.size()-1; i >= 0; i--) {
				if (name.get(i).equals(sound.get(j))) {			
					name.remove(i);
				}
			}
		}

		System.out.println(name.size());
		for (int i = 0; i < name.size(); i++) {
			System.out.println("누락 = "+name.get(i));
		}


	}//end of main
}//end of class
