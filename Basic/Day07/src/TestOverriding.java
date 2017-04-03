/**
 * 오버라이딩(Over riding):조상클래스로부터 상속받은 메서드의 내용을 재정의하는 것 조건 :부모클래스의 메서드 선언부와 자식클래스에서
 * 재정의하는 메서드 선언부가 동일해야함
 * 
 * 오버로딩과의 차이점 오버로딩(Over loading) : 하나의 클래스 안에서 메서드의 이름을 동일하게 사용하는 것 조건 : 매개변수의
 * 개수 or 타입 or 순서가 달라야 한다
 */
public class TestOverriding {
	public static void main(String[] args) {
		PP pp = new PP();
		pp.x = 1;
		pp.y = 2;
		pp.printPP();

		PPP ppp = new PPP();
		ppp.x = 40;
		ppp.y = 50;
		ppp.z = 60;
		ppp.printPP();

	}// end of main
}// end of class

class PP {// 2차원 좌표계
	int x;
	int y;

	void printPP() {
		System.out.println(x + "," + y);
	}
}

class PPP extends PP {// 3차원 좌표계
	int z;

	// @Override
	// void printPP() {
	// super.printPP();
	// }

	@Override // 어노테이션 :오버라이딩 기법을 적용했으므로 선언부가 같아야함을 의미
	void printPP() {
		// System.out.println(x+","+y+","+z);
		super.printPP();
		System.out.print("," + z);
	}

}
