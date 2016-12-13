import java.lang.reflect.Array;

public class Course {

	private String courseCode; 
	private String courseName; 
	private int currentEnrollment; 
	private Student[] studentsInCourse; 
	
	public Course() { 
		courseCode = ""; 
		courseName = ""; 
		currentEnrollment = 0; 
		studentsInCourse = new Student[50];
		
	};
	
	public Course (String courseCode, String courseName){ 
		this.courseCode = courseCode; 
		this.courseName = courseName; 
	}
	

	// methods 
	
	public void addStudent(Student s) throws StudentLimitException, DuplicateStudentException{ 
		//do something here to add student to the array

		if (currentEnrollment == 50){
			throw new StudentLimitException(); } 
		
		if (currentEnrollment == 0) { 
			studentsInCourse[0] = s;
			currentEnrollment ++; }
		else { 
			for (int i = 0; i<currentEnrollment; i++) { 
				
				if (s.getLastName().compareTo(studentsInCourse[i].getLastName()) < 0){
					for (int j = currentEnrollment; j>i; j--) { 
						studentsInCourse[j] = studentsInCourse[j-1];
					}
				currentEnrollment++; 
				studentsInCourse[i] = s;
				break;		}
			
				else if(s.getLastName().equals(studentsInCourse[i].getLastName())) { 
					if(s.getStudentID() < studentsInCourse[i].getStudentID()) { 
						for(int j = currentEnrollment; j>i; j-- ) { 
							studentsInCourse[j] = studentsInCourse[j-1];
							currentEnrollment++; 
							studentsInCourse[i] = s;
							break;
						}
					}
				else if (s.getStudentID() == studentsInCourse[i].getStudentID()){
					throw new DuplicateStudentException(); }; } } }

		
	}
	
	public void removeStudent(int studentID) throws EmptyStudentListException, StudentNotFoundException { 
		if (currentEnrollment == 0) { throw new EmptyStudentListException();}; 
		
		for (int i = 0; i < currentEnrollment; i++) { 
			if (studentID == studentsInCourse[i].getStudentID()) { 
				
				for (int j = i + 1; j < currentEnrollment; j++) { 
					studentsInCourse[i] = studentsInCourse[j]; } 
			studentsInCourse[currentEnrollment - 1] = null;
			currentEnrollment --;
			break;
		
			}
			
			else if (i == currentEnrollment - 1) {
				throw new StudentNotFoundException(); }		
			
		} }
		
		
	


	
	
	//Setter and Getters :) 
	
	public void setCourseCode(String c) { 
		this.courseCode = c;
	}
	
	public void setCourseName(String n)  {
		this.courseName = n; 
	}
	
	public void setCurrentEnrollment(int s) { 
		this.currentEnrollment = s;
	}
	
	
	public String getCourseCode() { 
		return this.courseCode;
	}
	
	public String getCourseName() { 
		return this.courseName;
	}
	
	public int getCurrentEnrollment() { 
		return this.currentEnrollment;
	}

	public Student[] getStudentsInCourse() { 
		return this.studentsInCourse;
	}
	
	
}
	
