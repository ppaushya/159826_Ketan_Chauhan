package exercise4interface;

public class Student {

	int studentId;
	String studentName;
	int attendence;
	char grade;
	
	public Student() {
		super();
	}
	
	public Student(int studentId, String studentName, int attendence, char grade) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.attendence = attendence;
		this.grade = grade;
	}
}
