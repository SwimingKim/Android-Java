/**
 * 인터페이스 interface : 껍데기(선언부)만 있는 것 (클래스가 아니다)
 * 
 */
public class TestInterface {
	public static void main(String[] args) {
		// I i = new I();//인터페이스로는 객체생성불가
		MyI m = new MyI();
	}// end of main
}// end of class

class MyI implements I {// interface를 구축한다
	@Override
	public void print() {
	}

	@Override
	public void p() {
	}
}

interface I {
	public static final int a = 3;// 모든 변수에는 public static final을 선언해야 함
	int b = 4;// 위 제어자를 선언하지 않으면, 컴파일러가 알아서 추가해준다
	static int c = 5;// 부족한 부분을 알아서 추가해준다

	public abstract void print();// 모든 메서드에는 public abstract를 선언해야 함

	void p();// 위 제어자를 선언하지 않으면, 컴파일러가 알아서 추가해준다

}