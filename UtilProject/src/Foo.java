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
        // ���� ����
        BufferedReader br = null;        
         
        // Input ��Ʈ�� ����
        InputStreamReader isr = null;    
         
        // File Input ��Ʈ�� ����
        FileInputStream fis = null;        
 
        // File ���
        File file = new File("C:\\Users\\Administrator\\Desktop\\memo.txt");

        // ���۷� �о���� �ӽ� ����
        String temp = "";
         
        // ���� ���� ����� ���� ����
        String content = "";
        String text="";
        ArrayList<String> arr;
        try {
             
            // ������ �о�鿩 File Input ��Ʈ�� ��ü ����
            fis = new FileInputStream(file);
             
            // File Input ��Ʈ�� ��ü�� �̿��� Input ��Ʈ�� ��ü�� �����ϴµ� ���ڵ��� UTF-8�� ����
            isr = new InputStreamReader(fis, "UTF-8");
             
            // Input ��Ʈ�� ��ü�� �̿��Ͽ� ���۸� ����
            br = new BufferedReader(isr);
         
            arr = new ArrayList<String>();
            // ���۸� �������� �о�鿩 ���� ����
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
				     //System.err.println("�̸� ���� ���� : " + file1);

				    }else{
				   	 System.err.println("�̸� ���� : " + file1 +" > "+file2);
				    }
			
			content += game_str+ "\n"; //+ "\n"
				// String stringForIntArray = Arrays.toString(game_str);
				
				j++;
				
				
			}
			//System.out.println("================== ���� ���� ��� ==================");
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

			File file1 = new File("D:/����/�۾�������/��/" + string1);
			File file2 = new File("D:/����/�۾�������/��/" + num + ".mp3");

			if (!file1.renameTo(file2)) {
				System.err.println("�̸� ���� ���� : " + file1);
			}
			num++;
		}
	}

}
