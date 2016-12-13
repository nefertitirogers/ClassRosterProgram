import java.util.Scanner;

// public class MyException extends Exception {}
//public class DuplicateCourseException extends Exception{}; 

public class RosterManager {
	private Course[] course; 
	private int totalClasses;
	//private ClassRosterUI CUI; 
	
	// constructors 
	
	public RosterManager () { 
		totalClasses = 0; 
		course = new Course[10];
	
	}
	
	public RosterManager(int totalClasses, Course[] course) { 
		this.totalClasses = totalClasses; 
		this.course = course; }; 


	// methods 
	
	public void run() throws CourseLimitException, DuplicateCourseException, CourseNotFoundException, EmptyCourseListException, StudentLimitException,
	DuplicateStudentException, EmptyStudentListException, StudentNotFoundException { 
		/* Runs the main loop of the program. This prints the menu, accepts user
input, and handles each of the user commands.
• Handles the custom Exceptions and prints the messages to the user. */
		//this.CUI = new ClassRosterUI();
		String menu = "---------- \n"
				+ " ac: Add Course \n" 
				+ "dc: Drop Course \n" 
				+ " as: Add Student \n" 
				+ "ds: Drop Student \n"
				+ "p: Print ClassRoster \n"
				+ "q: Quit Program \n"
				+ "---------- \n";
		String command = ClassRosterUI.getCommand();
		Scanner s = new Scanner(System.in); 
		
		switch(command){
		
		case "ac": 
			System.out.println("Enter Course Code: "); 
			String courseCode = s.next(); 
			System.out.println("Enter Course Name: ");
			String courseName = s.next();
			
			Course ac = new Course(courseCode, courseName);
			try {
				addCourse(ac);} 
			
			catch (CourseLimitException e) { 
				System.out.println("ERROR cannot add course.");}

			catch(DuplicateCourseException e) { 
				System.out.println("ERROR this course is already in the roster!");}
			
			finally { System.out.println(menu);
			s.close();};
			
			break; 
			
		case "dc": 
			System.out.println("Enter Course Code: "); 
			String cCode = s.next();
			
			try{
			deleteCourse(cCode);} 
			
			catch(EmptyCourseListException e){
				System.out.println("ERROR the course list is empty!");
			}
			catch (CourseNotFoundException e) { 
				System.out.println("ERROR course is not found in the course list!");}
			
			finally { System.out.println(menu);
			s.close();};
			
			break;
			

		case "as": 
			System.out.println("Enter course code for Student: "); 
			String cc = s.next(); 
			System.out.println("Enter StudentID: ");
			int studentID = Integer.parseInt(s.next()); 
			System.out.println("Enter last name: ");
			String lastName = s.next();
			System.out.println("Enter first name ");
			String firstName = s.next();
			
			Student as = new Student(studentID, firstName, lastName);
			
			try{
			addStudent(cc, as);} 
			
			catch(StudentLimitException e) { 
				System.out.println("ERROR student cannot be added, course it full!");
			}
			
			catch(DuplicateStudentException e) { 
				System.out.println("ERROR student is already enrolled in course!");
			}
			
			finally { System.out.println(menu);
				s.close();};
			
			break;
			
		case "ds": 
			System.out.println("Enter course code for Student: "); 
			String Coursecd = s.next(); 
			System.out.println("Enter StudentID: ");
			int studentiD = Integer.parseInt(s.next()); 	
			
			try{
			deleteStudent(studentiD, Coursecd);}
			
			catch(EmptyStudentListException e) { 
				System.out.println("ERROR the course is already!");
			}
			
			catch(StudentNotFoundException e) { 
				System.out.println("ERROR student cannot be found in the course"); }
			
			finally { System.out.println(menu);
			s.close();};
			
			break;

		case "p": 
			
			printRoster();

		default:
			break; };
	
	}
	
	public void addCourse(Course c) throws DuplicateCourseException, CourseLimitException { 
		boolean thrown = false;
		if (totalClasses == 10) { 
			throw new CourseLimitException(); }
		
		for (int i = 0; i < totalClasses; i++) {
			if (c.getCourseCode() == course[i].getCourseCode()) { 
				thrown = true;
				throw new DuplicateCourseException(); };
		if (thrown == false) { 
			course[totalClasses] = c; };
		}
	}

	public void deleteCourse(String courseCode) throws CourseNotFoundException, EmptyCourseListException { 
		boolean thrown = true;
		if (totalClasses == 0) { 
			thrown = false;
			throw new EmptyCourseListException(); 
			}
		
		for (int i = 0; i < totalClasses; i++) {
			if(course[i].getCourseCode().equalsIgnoreCase(courseCode)) { 
				thrown = false;
				for (int j = i+1; j < totalClasses; j++) { 
					course[i] = course[j];
			course[totalClasses-1] = null; 
			totalClasses --;
			break;
				}
			}
		if (thrown == true) { 
			throw new CourseNotFoundException(); }}
		
	}
	
	public void addStudent(String courseCode, Student s) throws StudentLimitException, DuplicateStudentException, 
	CourseNotFoundException { 
		for (int i = 0; i < course.length; i++) { 
			if (course[i].getCourseCode() == courseCode) {
				try {course[i].addStudent(s);} 
				
				catch (StudentLimitException e) { 
					throw new StudentLimitException(); }

				catch(DuplicateStudentException e) { 
					throw new DuplicateStudentException();}}}
			
		throw new CourseNotFoundException(); } 	
	
	
	public void deleteStudent(int id, String courseCode) throws EmptyStudentListException, StudentNotFoundException, 
	CourseNotFoundException { 
		// Deletes a student from an already existing course code
		
		for (int i = 0; i < course.length; i++) { 
			if (course[i].getCourseCode() == courseCode) { 
				
				try{ course[i].removeStudent(id); 
				
				} catch (StudentNotFoundException e) { 
					throw new StudentNotFoundException();
				}
				catch(EmptyStudentListException e) { 
					throw new EmptyStudentListException();}
				} }
				
		throw new CourseNotFoundException(); }
 


	public void printRoster() {
		
		for( int i =0; i < course.length; i++) { 
			System.out.println("*********************" + course[i].getCourseCode() + ": " + course[i].getCourseName());
			System.out.println("Enrolled: " + course[i].getCurrentEnrollment());
			
			for(int j = 0; j < course[i].getStudentsInCourse().length; j++) { 
				System.out.println(course[i].getStudentsInCourse()[j].getStudentID() + " | " + course[i].getStudentsInCourse()[j].getLastName() + 
						", " + course[i].getStudentsInCourse()[j].getFirstName() + "\n"); }
			System.out.println("*********************");
			}
		}
	};


