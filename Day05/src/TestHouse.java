
public class TestHouse {
	public static void main(String[] args) {
		House ho1 = new House();
		ho1.address = "연서로";
		ho1.roomNum = 3;
		ho1.size = 34;
		ho1.hasElavator = true;
		ho1.hasParkingPlace = true;
		ho1.print();

	}// end of main
}// end of class

class House {
	String address;
	int roomNum;// 방개수
	int size;// 평수
	boolean hasElavator;// 엘리베이터 유무
	boolean hasParkingPlace;// 주차장 유무

	void print() {// 멤버변수 값 출력
		System.out.println(address + "에 위치한 집은\n" + "방의 개수는 " + roomNum + "개이고,\n" + "평수는 " + size + "평이고,\n"
				+ "엘리베이터는 " + (hasElavator ? "있고,\n" : "없고,\n") + "주차장은 " + (hasParkingPlace ? "있습니다" : "없습니다"));
	}

}
