
public class NovelTest {
	public static void main(String[] args) {

		Novel novel1 = new Novel("����� �ӵ�", "1111");
		novel1.setAuthor("�����ں��� ��");
		novel1.setPublisher("���ǻ� A");

		Novel novel2 = new Novel("��� �λ��� �̾߱�", "2222", "�׵� â", "���ǻ� B");

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
		str += "ISBN : " + ISBN + ", Title : " + titile + ", ���ǻ� : " + author + ", �۰� : " + publisher;
		return str;
	}

}
