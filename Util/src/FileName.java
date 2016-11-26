import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileName {
	public static void main(String[] args) throws IOException {

		//Byte ��� ���ὺƮ��(�� ��Ʈ��)�� ���� ��Ʈ����
		//1)BufferedInput/OUtputStream=>buffer�� ����� ��� �Ѵ�
		//2)Data Input/Output Stream =>�ڹ��� �⺻ �ڷ��� ������ Stream ����
		//3) Object Input/Output Stream =>Ŭ������ ��ü�� Stream ����

		ArrayList<String> word = new ArrayList<String>();
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Desktop\\memo.txt");
			Scanner s = new Scanner( fis );
			while ( s.hasNext( ) ){
				word.add(s.nextLine());
			}
		} catch ( Exception e ){
			e.printStackTrace( );
		}
		
		//���� ���� ����
		//1) ������ �д´�=>InputStream����
		//1-1) ������ ũ��� ũ��(1mb,1gb~)
		//1-2) ������ �ɰ��� �۾��� �ؾ� �Ѵ�.=>�ɰ��� ���� �ϴ� ��:����!(���۶�� �ӽ� ������ ���� ������ ����)

		//2) ���ۿ� ������ ������ �� �ִ�
		//2-1) ���� ����
		//2-2) ������� ���Ͽ� ���� ����(����)���� ä���=>���Ͽ� ��� ������ OutputStream

		int num = 0;
		for (int i = 0; i < word.size(); i++) {
			System.out.println(i+1);
			String name = i+1+"";
						
			File file=new File("C:\\Users\\Administrator\\Desktop\\���� ����\\"+name+".mp3"); //���� �̸� �ֱ�
			if(file.exists()){
				//���� �� ���=>�۾� ���� ����

				//���� �б� ���� fileInputStream ��������
				FileInputStream fis=new FileInputStream(file); //=>�� ��Ʈ��(���� ��Ʈ��)
				BufferedInputStream bis=new BufferedInputStream(fis);//=>���� ��Ʈ��

				//������ �ɰ��� ��� ���� ���۸� ����=>���� ũ�Ⱑ ũ�� ������
				byte []buffer=new byte[32];
				int readCnt=0;

				//int bis.read(����)
				//return: ���۰� ���� ũ��=>����� ���Ͽ��� �о���� ������ ������ ���� �����ϸ� EOF(-1)�� ����
				//read(buffer)=>���Ͽ��� ���� �����͸� ���ۿ� ���� �ִ´�

				File copyFile=new File("C:\\Users\\Administrator\\Desktop\\voice\\"+word.get(i)+".mp3");//**�ش� �̸����� �ڹ�������Ʈ ���� �ȿ� ���� ���� ������
				copyFile.createNewFile(); //=>���� ����

				//buffer�� ����ִ� ������ ���Ͽ� ��� �ؾ� �ϹǷ� FileOutputStream ����
				FileOutputStream fos=new FileOutputStream(copyFile);
				BufferedOutputStream bos=new BufferedOutputStream(fos);



				//��Ʈ������ �����͸� ������ �ڵ����� �������� �Ѿ��.
				while((readCnt=bis.read(buffer))!=-1){
					//					System.out.println("���� ���� ũ��: "+readCnt);
					bos.write(buffer); //BufferedInputStream�� �̿��� ���� ����(����)�� ������ ���Ͽ� �״�� ä�� �ִ´�
				}

				bis.close(); //�ݵ�� close����� ���� �ȳ�
				bos.close();
			}else{
				//���� �� �� ���
				System.out.println("xx"+word.get(i));
			}
		}




		//������ ���� �ϴ°�?

	}//end of main
}//end of class
