

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sound {

	public static void main(String[] args) throws IOException  {
		
		ArrayList<String> word = new ArrayList<String>();
//		C:\Users\Administrator\Desktop
		try{
			FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Desktop\\memo.txt");

			Scanner s = new Scanner(fis);
			while(s.hasNext()){
				word.add(s.nextLine());
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		{
			for (int i = 0; i < word.size(); i++) {
				File file = new File("C:\\Users\\Administrator\\Desktop\\all\\"+word.get(i)+".mp3");//���� �̸� �ֱ�"

				if(file.exists()){
					//���� �� ���=>�۾� ���� ����

					//���� �б� ���� fileInputStream ��������
					FileInputStream fis=new FileInputStream(file); //=>�� ��Ʈ��(���� ��Ʈ��)
					BufferedInputStream bis=new BufferedInputStream(fis);//=>���� ��Ʈ��

					//������ �ɰ��� ��� ���� ���۸� ����=>���� ũ�Ⱑ ũ�� ������
					byte []buffer=new byte[1024];
					int readCnt=0;

					//int bis.read(����)
					//return: ���۰� ���� ũ��=>����� ���Ͽ��� �о���� ������ ������ ���� �����ϸ� EOF(-1)�� ����
					//read(buffer)=>���Ͽ��� ���� �����͸� ���ۿ� ���� �ִ´�
//
//					for (int j = 0; j < word.size(); i++) {
//						word.set(j, word.get(j).replace(target, replacement));					
//					}
//					
					String name = String.valueOf(i+1);
					if (i+1<10) {
						name = "000"+name;
					} else if (i+1<100) {
						name = "00"+name;
					} else if(i+1<=1000) {
						name = "0"+name;
					}
					
					File copyFile=new File("C:\\Users\\Administrator\\Desktop\\voice\\"+name+".mp3");//**�ش� �̸����� �ڹ�������Ʈ ���� �ȿ� ���� ���� ������
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
					System.out.println((int)(i+1)+" "+word.get(i));
				}
			}
		}


	}//end of main

}//end of class
