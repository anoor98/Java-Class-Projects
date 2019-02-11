
public class Date212 {
	
	//private int date;
	private int month;
	private int day;
	private int year;
	
	public Date212() {
		this.setMonth("0");
		this.setDay("0");
		this.setYear("0");
	}
	
	public Date212 (String d) {
		year = Integer.parseInt(d.substring(0, 4));
		month = Integer.parseInt(d.substring(4, 6));
		day = Integer.parseInt(d.substring(6));
		if(this.validDate() == false) {
			System.out.println("False Date. ");
		}
	}
	
	public int getMonth() {return month;}
	public int getDay() {return day;}
	public int getYear() {return year;}
	
	public void setDate(String d) {
		if(this.validDate() == false) {
			System.out.println("False date.");
		}
		else {
		new Date212(d);
		}
	}
	
	public void setMonth(String d) {
		month = Integer.parseInt(d.substring(4, 5));
	}
	public void setDay(String d) {
		day = Integer.parseInt(d.substring(6));
	}
	public void setYear(String d) {
		year = Integer.parseInt(d.substring(0, 3));
	}
	
	public String toString() {
		String format = (this.getMonth() + "/" +
						   this.getDay() + "/" +
						   this.getYear());
		return format;
	}
	
	public boolean validDate() { //validates a Date212 objects day according to the month as well 
		if ((this.getMonth() >= 1
			&& this.getMonth() <= 12 && this.getDay() >= 1)) {
			return true;
		} 
		
		else if ((this.getMonth() == 1 || this.getMonth() == 3 || 
					this.getMonth() == 5 || this.getMonth() == 7 || 
					this.getMonth() == 8 || this.getMonth() == 10 || 
					this.getMonth() == 12) && 
				  (this.getDay() <= 31 && this.getDay() >= 1)) {
			return true;		
		}
		
		else if ((this.getMonth() == 2) && 
					(this.getDay() <= 28 && this.getDay() >= 1)) {
			return true;
		}
		
		else if ((this.getMonth() == 4 || this.getMonth() == 6 || 
					this.getMonth() == 9 || this.getMonth() == 11) 
					&& (this.getDay() <= 30 && this.getDay() >= 1)) {
			return true;
		}
		else if(this.getYear() == 0 || this.getMonth() == 0 
				|| this.getDay() == 0) {
				return false;
		}
		
		else return false;
	}
	
	public boolean toCompare(Date212 arg) throws Exception {
		if(this.getYear() == arg.getYear()) {
			if(this.getMonth() == arg.getMonth()) {
				if(this.getDay() > arg.getDay()) {
					return true;
				} 
				else return false;
			}
			else if(this.getMonth() > arg.getMonth()) {
				return true;
			}
			else return false;
		}
		else if(this.getYear() > arg.getYear()) {
			return true;
		}
		else return false;
	}
	
}
