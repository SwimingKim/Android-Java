/**
 * 클래스 상속
 */
public class TestClass2 {
	public static void main(String[] args) {
		new Point3D().x = 3;

	}// end of main
}// end of class

class Boy { // 클래스의 정의 = 추상화한다
	int age; // 0
	String name = "";// 참조형 타입변수는 null이 기본 값
	boolean sex;// false

	int getAge() {
		return age;
	}

	boolean isSex() {// boolean타입은 get이 아니라 is로 이용한다
		return sex;
	}

	public Boy() {// 기본 생성자

	}

	public Boy(int age, String name, boolean sex) {
		super();
		this.age = age;
		this.name = name;
		this.sex = sex;
	}

}

class Point2D { // 2차원 좌표계
	int x;
	int y;

}

class Point3D extends Point2D { // 3차원 좌표계
	// int x;
	// int y;
	int z;

}