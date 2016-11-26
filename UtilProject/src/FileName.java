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

		//Byte 기반 연결스트림(주 스트림)의 보조 스트림들
		//1)BufferedInput/OUtputStream=>buffer을 만들어 줘야 한다
		//2)Data Input/Output Stream =>자바의 기본 자료형 형태의 Stream 지원
		//3) Object Input/Output Stream =>클래스의 객체를 Stream 지원

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
		
		//파일 복사 과정
		//1) 파일을 읽는다=>InputStream으로
		//1-1) 파일의 크기는 크다(1mb,1gb~)
		//1-2) 파일을 쪼개서 작업을 해야 한다.=>쪼개는 역할 하는 것:버퍼!(버퍼라는 임시 공간에 파일 조각을 저장)

		//2) 버퍼에 파일의 조각이 들어가 있다
		//2-1) 파일 생성
		//2-2) 만들어진 파일에 파일 조각(버퍼)들을 채운다=>파일에 써야 함으로 OutputStream

		int num = 0;
		for (int i = 0; i < word.size(); i++) {
			System.out.println(i+1);
			String name = i+1+"";
						
			File file=new File("C:\\Users\\Administrator\\Desktop\\영어 더빙\\"+name+".mp3"); //파일 이름 넣기
			if(file.exists()){
				//존재 할 경우=>작업 복사 진행

				//파일 읽기 위해 fileInputStream 가져오기
				FileInputStream fis=new FileInputStream(file); //=>주 스트림(연결 스트림)
				BufferedInputStream bis=new BufferedInputStream(fis);//=>보조 스트림

				//파일을 쪼개서 담기 위한 버퍼를 생성=>파일 크기가 크기 때문에
				byte []buffer=new byte[32];
				int readCnt=0;

				//int bis.read(버퍼)
				//return: 버퍼가 읽은 크기=>현재는 파일에서 읽어오기 때문에 파일의 끝에 도달하면 EOF(-1)값 리턴
				//read(buffer)=>파일에서 읽은 데이터를 버퍼에 집어 넣는다

				File copyFile=new File("C:\\Users\\Administrator\\Desktop\\voice\\"+word.get(i)+".mp3");//**해당 이름으로 자바프로젝트 폴더 안에 복사 파일 생성됌
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
				System.out.println("xx"+word.get(i));
			}
		}




		//파일이 존재 하는가?

	}//end of main
}//end of class
