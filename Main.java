import java.util.*;
class Main{
	public static void main(String[] args) throws NullPointerException{
		Scanner sc = new Scanner(System.in);
		UserInput userinput = new UserInput();
		Object[] details = new Object[3];

		System.out.println("Enter the number of students: ");
		int n = sc.nextInt();

		ArrayList<Student> studs = new ArrayList<>();
		for (int i=0;i<n;i++){
			Student new_guy= new Student();
			details = userinput.inputStudent();
			new_guy.setName((String) details[0]);
			new_guy.setDob((String) details[2]);
			new_guy.setPrn((Integer) details[1]);
			studs.add(new_guy);
		}

		display(studs);
		int c;
		while (true){
			System.out.println("\nEnter 1 to display the records\nEnter 2 to search for a student" +
					"\nEnter 3 to delete an entry\nEnter 4 to add a new entry\nEnter 5 to exit");
			c= sc.nextInt();
			if (c==1){
				if (n!=0)
					display(studs);
				else{
					System.out.println("The records are empty");
				}
			}
			else if (c==2) {
				System.out.print("Enter the PRN you want to search: ");
				int v = sc.nextInt();
				Student s = search(v, studs);
				if (s != null) {
					System.out.println("Entry found\n"+s.getName() + ", " + s.getPrn() + ", " + s.getDob());
				} else {
					System.out.println("The PRN does not exist in the database");
				}
			}
			else if (c==3){
				System.out.print("Enter the PRN you want to search: ");
				int v = sc.nextInt();
				delet(v, studs);
				n--;
			}
			else if (c==4){
				Student new_guy= new Student();
				details = userinput.inputStudent();
				new_guy.setName((String) details[0]);
				new_guy.setDob((String) details[2]);
				new_guy.setPrn((Integer) details[1]);
				studs.add(new_guy);
				n++;
				System.out.println("Record successfully added");
			}
			else if (c==5){
				System.exit(0);
			}
			else {
				System.out.println("\nPlease enter a valid input\n");

			}
		}

	}

	public static void display(ArrayList<Student> student){
		int count=1;
		System.out.println("____________________Printing Records____________________");
		for (Student x: student){
			System.out.println("_______________"+"Record "+count+"___________");
			System.out.println(x.getName()+", "+x.getPrn()+", "+x.getDob());
		count++;
		}
	}

	public static Student search(int p, ArrayList<Student> stud){
		for (Student x:stud){
			if (p==x.getPrn()){
				return x;
			}
		}
		return null;
	}

	public static void delet(int p, ArrayList<Student> stud){
		Student s = search(p, stud);
		if (s!=null){
			stud.remove(s);
			System.out.println("Record deleted");
		} else{
			System.out.println("The element does not exist in the list");
		}
	}
}


		