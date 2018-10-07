import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Driver {
	public static void main(String[] args) throws ParseException {
		
		System.out.println("Project 1 driver executing main()...");
		List<Student> lst = Student.studentInfo();
		
		System.out.println("Printing the details of all the Students");
		for(Student std: lst)
		{
			System.out.println(std.display());
		}
		
		System.out.println(lst.get(0).linkRegistration());
		
	}
}
