
public class TestEncapsulation2 {
	public static void main(String[] args) {

		Car c1 = new Car();
		c1.setName("벤츠");
		c1.setDoor(4);
		c1.setEngine(1490);

		System.out.println(c1.getName() + ",\t" + c1.getDoor() + "개,\t" + c1.getEngine());

	}// end of main
}// end of class

class Car {
	private String name = "";
	private int door;
	private float engine;

	// getter/setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDoor() {
		return door;
	}

	public void setDoor(int door) {
		this.door = door;
	}

	public float getEngine() {
		return engine;
	}

	public void setEngine(float engine) {
		this.engine = engine;
	}

}