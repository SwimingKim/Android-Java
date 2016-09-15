
public class TestMovie {
	public static void main(String[] args) {
		Movie mo1 = new Movie();
		mo1.title = "미스컨덕트";
		mo1.type = "액션";
		mo1.grade = 3;
		mo1.veiwCount = 10000;

		mo1.print();

		Movie mo2 = new Movie();
		mo2.title = "미션임파서블";
		mo2.type = "액션";
		mo2.grade = 4;
		mo2.veiwCount = 100000;

		mo2.print();

		Movie mmm[] = new Movie[2];
		mmm[0] = mo1;
		mmm[1] = mo2;

	}// end of main
}// end of class

class Movie {
	String title;// 제목
	String type;// 장르
	int grade;// 관객평점
	int veiwCount;// 관객수

	void print() {// 멤버변수 출력
		System.out.println("해당 영화는 " + title + "이고,\n" + "장르는 " + type + "이며,\n" + "관객평점은 " + grade + "점을 기록했으며,\n"
				+ "총 관객 수는 " + veiwCount + "명입니다.");

	}
}
