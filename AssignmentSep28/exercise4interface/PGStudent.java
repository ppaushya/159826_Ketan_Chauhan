package exercise4interface;

public class PGStudent extends Student implements StudentMethods{

	public PGStudent() {
		super();
	}
	
	public PGStudent(int studentId, String studentName, int attendence, char grade) {
		super(studentId,studentName,attendence,grade);
	}

	@Override
	public void displayGrade() {
		System.out.println("Grade for PG Student: "+grade);
	}

	@Override
	public void displayAttendence() {
		System.out.println("Attendense for PG Student: "+attendence);
	}
	
	
}
