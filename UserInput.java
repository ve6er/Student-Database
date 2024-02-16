import java.util.*;

public class UserInput{
	Scanner scan = new Scanner(System.in);
	String name, dob;
	int prn;
	
	Object[] array = new Object[3];

	public Object[] inputStudent(){
		System.out.println("Enter the name of the student: ");
		name= scan.next();

		System.out.println("Enter the PRN of the student: ");
		prn = scan.nextInt();

		System.out.println("Enter the date of birth of the student: ");
		dob= scan.next();
		array[0]= name;
		array[1]= prn;
		array[2]= dob;
		
		return array;
	}
}