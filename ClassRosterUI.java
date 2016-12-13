import java.util.Scanner;

public class ClassRosterUI {
	
	
	
	public static void printMenu() { 
		System.out.println("Welcome to Class Roster Manager! \n" 
		+ "Select an action based on the following menu: \n" 
		+ "---------- \n"
		+ " ac: Add Course \n" 
		+ "dc: Drop Course \n" 
		+ " as: Add Student \n" 
		+ "ds: Drop Student \n"
		+ "p: Print ClassRoster \n"
		+ "q: Quit Program \n"
		+ "---------- \n");
	}

	public static String getCommand() { 
		
		Scanner s = new Scanner(System.in); 
		System.out.println("Enter a command: ");
		boolean input = true;
		String command = s.next();
		
		while(input) { 
			
			String result;
			
			switch(command){
			
			case "ac": 
				result = "ac"; 
				input = false;
				return result;
				
			case "dc": 
				result = "dc"; 
				input = false;
				return result; 
				
			case "as": 
				result = "as"; 
				input = false;
				return result;
			
			case "ds": 
				result = "ds"; 
				input = false;
				return result;
		
			case "p": 
				result = "p"; 
				input = false;
				return result;
			
			case "q": 
				result = "q"; 
				input = false;
				return result;
			
			default: 
				System.out.println("Enter a valid command:");
				command = s.next();

				} };
				s.close();
				return command; };
				
		

		
		
	}
 

				

