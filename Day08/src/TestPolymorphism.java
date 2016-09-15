/**
 * 다형성(Polymorphism) : 객체를 여러 종류의 참조변수에 담을 수 있는 성질 => 부모의 참조변수에 자식의 객체를 담을 수 있다
 */

// 자바에서는 다중상속이 안된다
// 왜냐하면, 명확한 언어를 만들기 위해서 = 애매모호한 언어를 없애기 위해서
class Q {
}

class R extends Q {
}

class P extends Q {
}

class T extends P {
}

public class TestPolymorphism {
	public static void main(String[] args) {
		Q q = new Q();
		R r = new R();
		P p = new P();
		T t = new T();

		Q q1 = r;
		Q q2 = p;
		Q q3 = t;
		// R r1 = q;//자식의 참조변수에 부모의 객체를 넣을 수 없다
		R rr = (R) q1;// 자식의 참조변수에 부모의 객체를 넣을 수 없다, 넣으려면 형변환이 필요하다

	}// end of main
}// end of class
