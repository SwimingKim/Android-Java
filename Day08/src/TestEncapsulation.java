/**
 * Modifiers 제어자 =>캡슐화
 */
public class TestEncapsulation {
	public static void main(String[] args) {
		Time t = new Time();
		t.setHour(3);
		t.setMinute(44);
		t.setSecond(28);
		System.out.println(t.getHour() + ":" + t.getMinute() + ":" + t.getSecond());

	}// end of main
}// end of class

class Time {
	private int hour;
	private int minute;
	private int second;

	// setter 메서드
	public void setHour(int hour) {
		if (hour < 0 || hour > 23) {
			System.out.println("시간의 범위를 벗어났습니다");
			return;
		}
		this.hour = hour;
	}

	public void setMinute(int minute) {
		if (minute < 0 || minute > 60) {
			System.out.println("분의 범위를 벗어났습니다");
			return;
		}
		this.minute = minute;
	}

	public void setSecond(int second) {
		if (second < 0 || second > 100) {
			System.out.println("초의 범위를 벗어났습니다");
			return;
		}
		this.second = second;
	}

	// getter 메서드
	int getHour() {
		return hour;
	}

	int getMinute() {
		return minute;
	}

	int getSecond() {
		return second;
	}

}