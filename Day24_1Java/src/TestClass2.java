/**
 * Ŭ���� ���
 */
public class TestClass2 {
	public static void main(String[] args) {
		new Point3D().x = 3;

	}// end of main
}// end of class

class Boy { // Ŭ������ ���� = �߻�ȭ�Ѵ�
	int age; // 0
	String name = "";// ������ Ÿ�Ժ����� null�� �⺻ ��
	boolean sex;// false

	int getAge() {
		return age;
	}

	boolean isSex() {// booleanŸ���� get�� �ƴ϶� is�� �̿��Ѵ�
		return sex;
	}

	public Boy() {// �⺻ ������

	}

	public Boy(int age, String name, boolean sex) {
		super();
		this.age = age;
		this.name = name;
		this.sex = sex;
	}

}

class Point2D { // 2���� ��ǥ��
	int x;
	int y;

}

class Point3D extends Point2D { // 3���� ��ǥ��
	// int x;
	// int y;
	int z;

}