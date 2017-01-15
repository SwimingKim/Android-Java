/**
 * 여자친구 객체 추상화
 */
public class TestGirl {
	public static void main(String[] args) {
		Girl g1 = new Girl("강모연", 35, 80);
		Girl g2 = new Girl("윤명주", 30, 85);
		Girl g3 = new Girl();

		g1.printGirl();
		g2.printGirl();
		g3.printGirl();

	}// end of main
}// end of class

class Girl {
	String name = "";
	int age;
	int pretty;// 이쁜 척도(100점만점)

	Girl() {
	}

	Girl(String name, int age, int pretty) {
		this.name = name;
		this.age = age;
		this.pretty = pretty;
	}

	void printGirl() {
		System.out.println(name + "양\t" + age + "살\t" + pretty + "점");
	}

}
