
public class Student {
	
	// instance variables
	
	private int studentID; 
	private String firstName; 
	private String lastName; 
	
	//constructors
	
	public Student () { 
		studentID = 0; 
		firstName = ""; 
		lastName = ""; 
	}
	
	
	public Student(int studentID, String firstName, String lastName){ 
		this.studentID = studentID; 
		this.firstName = firstName; 
		this.lastName = lastName;
	}
	
	// methods
	
	public void setStudentID( int i) { 
		this.studentID = i;
	}
	
	public void setFirstName(String n){ 
		this.firstName = n;
	}
	
	public void setLastName(String n) { 
		this.lastName = n;
	}
	
	public int getStudentID () { 
		return this.studentID;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() { 
		return this.lastName;
	}

}
