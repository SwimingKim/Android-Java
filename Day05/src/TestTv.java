/**
 * 클래스 메서드 활용
 */
public class TestTv {
	public static void main(String[] args) {

		Tv t1 = new Tv();
		t1.name = "삼성파브";
		t1.size = 40;
		t1.channel = 11;
		t1.volumn = 10;
		t1.power = false;
		int x = t1.add(3, 9);
		System.out.println(x);
		System.out.println(t1.add(3, 9));
		System.out.println(t1.add2(9));

		System.out.println(t1.channel);
		t1.channelDown();
		t1.channelDown();
		System.out.println(t1.channel);

		t1.powerOnOff();
		System.out.println(t1.power);

		t1.ppp();
		t1.printPower();

	}// end of main
}// end of class

class Tv {// 추상화 작업
	String name;// 제품명
	int size;// 화면 크기
	int channel;// 채널
	int volumn;// 소리크기
	boolean power;// 전원

	void printPower() {// 현재 전원 상태가 켜졌는지 꺼졌는지 출력
		System.out.println(power ? "켜져있습니다" : "꺼져있습니다");
	}

	void powerOnOff() {// 파워 켜->끄고, 꺼-> 켜라

		// if(power){
		// power = false;
		// } else power = true;

		// power = power ? false : true;
		power = !power;
	}

	// void powerOn(){
	// power=true;
	// }
	//
	// void powerOff() {
	// power=false;
	// }
	//
	void channelDown() {// 변수에 저장된 channel값을 1증가시키기
		channel--;
	}

	void channelUp() {// 변수에 저장된 channel값을 1증가시키기
		channel++;
	}

	// 메서드(실행문들의 묶음)
	// 반환값 : 리턴값 - 1개만 사용가능, 사용안하려면 void
	// 메서드명 : 함수 호출시 사용하는 이름
	// 인자값 : 파라미터, 매개변수 - 사용하지 않아도 되고, 여러개의 인자를 사용할 수 있다.
	// 반환값, 메서드명, 인자값
	void ppp() {
		System.out.println("나는 메서드다");
		return;// 리턴타입이 void일 경우는 return문을 써도 되고 안 써도 된다
	}

	int add2(int x) {// 인자값을 받아서 +2하여 리턴하는 메서드
		int y = x + 2;
		return y;
	}

	int add(int x, int y) {// 인자값을 두개 받아서 더해서 리턴하는 메서드
		int z = x + y;
		return z;
	}
}