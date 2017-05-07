/**
 * 쓰레드 Thread - 하나의 프로세스(실행된 프로그램) 안에서 시분할 스케줄링을 통해, 마치 동시에 여러 작업을 진행하는 듯한 효과를
 * 주는 것
 */
public class TestThread {
	public static void main(String[] args) {

		MyT mt = new MyT();
		mt.start();

		Thread t = new Thread(new Runnable() {// 인터페이스 구현
			public void run() {// 별도의 쓰레드로 동작시킬 작업
				for (int i = 0; i < 100000; i++) {
					System.out.println("★");
				}
			}
		});
		t.start();

		for (int i = 0; i < 100000; i++) {
			System.out.println("|");
		}

	}// end of main
}// end of class

class MyT extends Thread {// Thread 클래스를 상속받아서 run 메서드 구현
	@Override
	public void run() {
		for (int i = 0; i < 100000; i++) {
			System.out.println("ㅡ");
		}
	}
}