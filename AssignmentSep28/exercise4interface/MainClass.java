package exercise4interface;

public class MainClass {

	public static void main(String[] args) {
		UGStudent ug = new UGStudent(1,"Amit",90,'A');
		ug.displayAttendence();
		ug.displayGrade();


		PGStudent pg = new PGStudent(2,"Bharat",75,'B');
		pg.displayAttendence();
		pg.displayGrade();
	}

}
