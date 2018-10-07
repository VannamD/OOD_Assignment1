import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Student extends Person {

	private String parent_name;
	private Date reg_date;
	private int membership;
	private RegistrationTracking rt;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String input) throws ParseException{
		super();
		String[] info = input.split(",");
		super.setName(info[0]);
		super.setAge(new Integer(info[1]));
		this.setParent_name(info[2]);
		this.reg_date = new SimpleDateFormat("mm-dd-yyyy").parse(info[3]);
		this.membership = new Integer(info[4]);
	}
	
	public String linkRegistration()
	{
		rt = new RegistrationTracking(this);
		return "Registration has been verified, here are the details: " + rt.checkExpiry();
	}
	
	public static List<Student> studentInfo() throws ParseException
	{
		List<Student> lst = new ArrayList<Student>();
		try {
			FileReader fr = new FileReader("Book1.csv");
			BufferedReader br = new BufferedReader(fr);
			String inputLine = null;
			
			while( (inputLine=br.readLine()) != null)
			{
				lst.add(new Student(inputLine));
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found\n");
		} catch (IOException e) {
			System.out.println("Problem occured in Reading the file!\n");
		}
		
		return lst;
	}
	
	public String display() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		String Persondetails = super.display();
		return Persondetails + "parent_name=" + parent_name + ", reg_date=" + sdf.format(reg_date) + ", " + "Membership Plan=" + membership;
	}

	public String getParent_name() {
		return parent_name;
	}

	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public int getMembership() {
		return membership;
	}

	public void setMembership(int membership) {
		this.membership = membership;
	}
	
}
