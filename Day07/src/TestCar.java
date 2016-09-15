
public class TestCar {
	public static void main(String[] args) {
		SportsCar c1 = new SportsCar("벤츠", 4, "검정", false);
		SportsCar c2 = new SportsCar("람보르기니", 2, "빨강", true);

		c1.print();
		c2.print();

	}// end of main
}// end of class

class Car {
	String name = "";
	int door;
	String color = "";

	Car() {
	}

	Car(String name, int door, String color) {
		this.name = name;
		this.door = door;
		this.color = color;
	}
}

class SportsCar extends Car {
	boolean openRoof;

	SportsCar() {
	};

	public SportsCar(boolean openRoof) {
		this.openRoof = openRoof;
	}

	public SportsCar(String name, int door, String color, boolean openRoof) {
		this.name = name;
		this.door = door;
		this.color = color;
		this.openRoof = openRoof;
	}

	void print() {
		System.out.println(name + "\t" + door + "개\t" + color + "색\t" + (openRoof ? "지붕 열림" : "지붕 안열림"));
	}
}
