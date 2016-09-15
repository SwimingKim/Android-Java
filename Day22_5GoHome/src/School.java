
public class School {

	public static void main(String[] args) {
		Member professor = new Professor("Han");
		Member student1 = new Student("Kim");
		Member student2 = new Student("Lee");
		Member student3 = new Student("Park");

		Course java1 = new Course(professor);
		java1.setMaxStudent(2);

		java1.enroll(student1);
		java1.enroll(student2);
		java1.enroll(student3);

		System.out.println(java1.toString());

	}// end of main
}// end of class

class Course {
	String proffessor;
	String student = "";
	String out = "";
	int max;
	int num;

	public Course() {
	}

	public Course(Member proffessor) {
		this.proffessor = proffessor.toString();
	}

	void setMaxStudent(int max) {
		this.max = max;
	}

	void enroll(Member student) {
		if (num < max) {
			this.student += student.toString() + "\n";
			this.num++;
		} else {
			this.out = student.toString();
		}
	}

	public String toString() {
		String str = "";
		str += out + "��, ���� ������ " + (num <= max ? "����" : "���� ��") + " á���ϴ�.\n";
		str += "�� ������ " + proffessor.toString() + " ������ �����Դϴ�.\n";
		str += "������ ����� ������ �����ϴ� :\n" + student.toString();
		return str;
	}
}

class Professor extends Member {
	String proffessor = "";

	public Professor() {
	}

	public Professor(String proffessor) {
		this.proffessor = proffessor;
	}

	public String toString() {
		return proffessor;
	}

}

class Student extends Member {
	String student = "";

	public Student() {
	}

	public Student(String student) {
		this.student = student;
	}

	public String toString() {
		return student;
	}

}

abstract class Member {
}
