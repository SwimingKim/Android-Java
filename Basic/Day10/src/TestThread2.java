import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.Random;

/**
 * 쓰레드 활용
 */
public class TestThread2 {
	public static void main(String[] args) {
		Frame f = new Frame("쓰레드활용");
		f.setBounds(100, 100, 300, 400);
		f.setLayout(new GridLayout(3, 1));

		Label l1 = new Label();
		f.add(l1);
		Label l2 = new Label();
		f.add(l2);
		Label l3 = new Label();
		f.add(l3);

		f.setVisible(true);

		l1.setBackground(Color.BLACK);
		l2.setBackground(Color.blue);
		l3.setBackground(Color.red);

		Thread t1 = new Thread(new Runnable() {
			public void run() {// 별도의 쓰레드에서 작업할 내용 작성
				int r = 0;
				while (true) {
					for (int i = 0; i < 256000; i++) {
						l1.setBackground(new Color(i / 1000, 0, 0));// r,g,b
																	// 0~255
					}
					for (int j = 255000; j >= 0; j--) {
						l1.setBackground(new Color(j / 1000, 0, 0));
					}
				}
			}
		});
		t1.start();// 쓰레드 시작

		Thread t2 = new Thread(new Runnable() {
			public void run() {// r,g,b
				double r = 0;
				double g = 100;
				double b = 200;

				while (true) {
					r += 0.0001;
					g += 0.0002;
					b += 0.0003;
					l2.setBackground(new Color((int) r % 256, (int) g % 256, (int) b % 256));
				}
			}
		});
		t2.start();

		// new Thread().start();
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				Random ran = new Random();
				while (true) {
					int r = ran.nextInt(256);
					int g = ran.nextInt(256);
					int b = ran.nextInt(256);
					l3.setBackground(new Color(r, g, b));
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
			}
		});
		t3.start();

	}// end of main
}// end of class
