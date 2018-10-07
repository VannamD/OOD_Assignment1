import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class RegistrationTracking {

	private int validity; //depends on which type of membership taken (Gold = 24 Months, Silver = 12 Months, Bronze = 6 months)
	private Date exp_date;
	
	public RegistrationTracking(Student std) {
		super();
		if(std.getMembership() == 1) //1 represents gold
		{
			this.validity = 24;
			Calendar mycal = Calendar.getInstance();
			mycal.setTime(std.getReg_date());
			mycal.add(Calendar.MONTH, +24);
			this.exp_date = mycal.getTime();
		}
		
		if(std.getMembership() == 2) //2 represents Silver
		{
			this.validity = 12;
			Calendar mycal = Calendar.getInstance();
			mycal.setTime(std.getReg_date());
			mycal.add(Calendar.MONTH, +12);
			this.exp_date = mycal.getTime();
		}
		
		if(std.getMembership() == 3) //3 represents Bronze
		{
			this.validity = 6;
			Calendar mycal = Calendar.getInstance();
			mycal.setTime(std.getReg_date());
			mycal.add(Calendar.MONTH, +6);
			this.exp_date = mycal.getTime();
		}	
	}
	
	public String checkExpiry()
	{
		String ans = null;
		Date today = new Date();
		if (today.compareTo(this.exp_date) == 0)
			ans = "Your membership has expired!";
		else if (today.compareTo(this.exp_date) < 0)
		{
			Calendar exp = new GregorianCalendar();
			exp.setTime(this.exp_date);
			Calendar now = new GregorianCalendar();
			now.setTime(today);
			
			int years = exp.get(Calendar.YEAR) - now.get(Calendar.YEAR);
			int months = exp.get(Calendar.MONTH) - now.get(Calendar.MONTH);
			int gap = years*12 + months;
			ans =  "You have " + gap + " months remaining before your membership expires!";
		}
		return ans;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public Date getExp_date() {
		return exp_date;
	}

	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}
	
	
}
