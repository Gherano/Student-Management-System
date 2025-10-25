import java.util.ArrayList;
import java.util.Scanner;
public class SmsApp {
public static void main(String[] args) {
	ArrayList<Student> studentList = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	
	studentList.add(new Student("Alice",101,3.8));
	studentList.add(new Student("bob",102,3.2));

	 runMenu(studentList,scanner);     
    }
	public static void runMenu(ArrayList<Student>list,Scanner scan) {
		while(true) {
			System.out.println("\n--- Student Management System ---");
			System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student GPA");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scan.nextInt();
            switch(choice) {
            case 1:
            	addStudent(list,scan);
            break;
            case 2:
            	viewStudents(list);
            	break;
            case 3:
            	updateGpa(list,scan);
            	break;
            case 4:
            	System.out.println("exiting system");
            	scan.close();
            	return;
            default:
            	System.out.println("invalid choice please try again");
            }
		}
        
    }
	public static void addStudent(ArrayList<Student>list,Scanner scan) {
		System.out.print("entername");
		String name = scan.next();
		System.out.print("enterId");
		int id = scan.nextInt();
		System.out.print("enetergpa");
		double gpa = scan.nextDouble();
		
		Student newStudent = new Student(name,id,gpa);
		list.add(newStudent); 
		System.out.println("student added succesfully");
	}
	public static void viewStudents(ArrayList<Student>list) {
		if (list.isEmpty()) {
			System.out.println("no student found");
			return;
		}
		System.out.println("\n--- All Students ---");
		for(int i=0; i<list.size(); i++){
			Student student = list.get(i);
			System.out.println(student);
			
		}
		System.out.println("--------------------");
	}
	public static void updateGpa(ArrayList<Student>list,Scanner scan) {
		System.out.println("enter id of student to update");
		int idToFind = scan.nextInt();
		boolean found = false;
		for (int i=0;i<list.size(); i++) {
			Student student = list.get(i);
			if (student.getId()==idToFind) {
				System.out.println("enter newGpa");
				double newGpa = scan.nextDouble();
				student.setGpa(newGpa);
				System.out.println("gpa updated" + student.getName());
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("student with id" + idToFind +"not found");
		}
	}



}













