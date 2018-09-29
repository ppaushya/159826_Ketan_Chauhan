package exercise4interface;

public class UGStudent extends Student implements StudentMethods{

	public UGStudent() {
		super();
	}
	
	public UGStudent(int studentId, String studentName, int attendence, char grade) {
		super(studentId,studentName,attendence,grade);
	}

	@Override
	public void displayGrade() {
		System.out.println("Grade for UG Student: "+grade);
	}

	@Override
	public void displayAttendence() {
		System.out.println("Attendense for UG Student: "+attendence);
	}
	
}
