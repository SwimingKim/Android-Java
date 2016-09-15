
public class NovelTest {
	public static void main(String[] args) {

		Novel novel1 = new Novel("어둠의 속도", "1111");
		novel1.setAuthor("엘리자베스 문");
		novel1.setPublisher("출판사 A");

		Novel novel2 = new Novel("당신 인생의 이야기", "2222", "테드 창", "출판사 B");

		System.out.println(novel1.read());
		System.out.println(novel2.read());
	}// end of main
}// end of class

class Novel {
	String titile;
	String ISBN;
	String publisher;
	String author;
	String str = "";

	public Novel() {
	}

	public Novel(String titile, String ISBN) {
		this.titile = titile;
		this.ISBN = ISBN;
	}

	public Novel(String titile, String ISBN, String author, String publisher) {
		this.titile = titile;
		this.ISBN = ISBN;
		this.author = author;
		this.publisher = publisher;
	}

	void setAuthor(String author) {
		this.author = author;
	}

	void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String read() {
		String str = "";
		str += "ISBN : " + ISBN + ", Title : " + titile + ", 출판사 : " + author + ", 작가 : " + publisher;
		return str;
	}

}
