package project;

/**
  @author KIBRU KUTURE
 */

public class Date {
	private int day;
	private int month;
	private int year;
	public Date() {
		day=1;
		month=1;
		year=1000;
	}
	public Date(int day,int month,int year) {
		this.day=day;
		this.month=month;
		this.year=year;
	}
    public Date (Date date) {
    	this.day=date.day;
    	this.month=date.month;
    	this.year=date.year;
    }
    public void putDate(String date) {
    	String[] stringDate=date.split("/");
    	setDay(Integer.parseInt(stringDate[0].trim()));
    	setMonth(Integer.parseInt(stringDate[1].trim()));
    	setYear(Integer.parseInt(stringDate[2].trim()));
    	
    }
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month; 
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
        @Override
    public String toString() {
    	return "Day: "+day+","+"Month: "+month+ ","+"Year: "+year;
    }

}

