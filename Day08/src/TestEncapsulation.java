/**
 * Modifiers ������ =>ĸ��ȭ
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

	// setter �޼���
	public void setHour(int hour) {
		if (hour < 0 || hour > 23) {
			System.out.println("�ð��� ������ ������ϴ�");
			return;
		}
		this.hour = hour;
	}

	public void setMinute(int minute) {
		if (minute < 0 || minute > 60) {
			System.out.println("���� ������ ������ϴ�");
			return;
		}
		this.minute = minute;
	}

	public void setSecond(int second) {
		if (second < 0 || second > 100) {
			System.out.println("���� ������ ������ϴ�");
			return;
		}
		this.second = second;
	}

	// getter �޼���
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