

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
				File file = new File("C:\\Users\\Administrator\\Desktop\\all\\"+word.get(i)+".mp3");//파일 이름 넣기"

				if(file.exists()){
					//존재 할 경우=>작업 복사 진행

					//파일 읽기 위해 fileInputStream 가져오기
					FileInputStream fis=new FileInputStream(file); //=>주 스트림(연결 스트림)
					BufferedInputStream bis=new BufferedInputStream(fis);//=>보조 스트림

					//파일을 쪼개서 담기 위한 버퍼를 생성=>파일 크기가 크기 때문에
					byte []buffer=new byte[1024];
					int readCnt=0;

					//int bis.read(버퍼)
					//return: 버퍼가 읽은 크기=>현재는 파일에서 읽어오기 때문에 파일의 끝에 도달하면 EOF(-1)값 리턴
					//read(buffer)=>파일에서 읽은 데이터를 버퍼에 집어 넣는다
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
					
					File copyFile=new File("C:\\Users\\Administrator\\Desktop\\voice\\"+name+".mp3");//**해당 이름으로 자바프로젝트 폴더 안에 복사 파일 생성됌
					copyFile.createNewFile(); //=>파일 생성

					//buffer에 들어있는 내용을 파일에 출력 해야 하므로 FileOutputStream 형성
					FileOutputStream fos=new FileOutputStream(copyFile);
					BufferedOutputStream bos=new BufferedOutputStream(fos);



					//스트림에서 데이터를 읽으면 자동으로 다음으로 넘어간다.
					while((readCnt=bis.read(buffer))!=-1){
						//					System.out.println("읽힌 파일 크기: "+readCnt);
						bos.write(buffer); //BufferedInputStream을 이용해 읽은 내용(버퍼)를 복사할 파일에 그대로 채워 넣는다
					}

					bis.close(); //반드시 close해줘야 에러 안남
					bos.close();
				}else{
					//존재 안 할 경우
					System.out.println((int)(i+1)+" "+word.get(i));
				}
			}
		}


	}//end of main

}//end of class
