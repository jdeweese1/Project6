/**
* The Payroll is a supporting class for the PayrollApp class. This class provides constructors
*equals(), getStringPay(), getPay(), getID() and toString() methods
* @author Jarod DeWees
* @version (which number project this is)
*/
import java.text.DecimalFormat;

public class Payroll
{
	private String name;
	private int idNumber;
	private double payRate;
	private double hoursWorked;
	/**
* This constructor takes in a String and Integer and assigns the String to name, and the Integer to idNumber
* @param  inString String is the name
* @param inInt Integer  is the idNumber of the employee
*/
	public Payroll(String inString, int inInt)
	{
		name = inString;
		idNumber = inInt;
	}
	/**
* This constructor takes in a String, Integer and two doubles, it  assigns the String to name, and the Integer to idNumber, the first double to PayRate, and the second to HoursWorked
* @param inString String of the name
* @param inInt Integer of idNumber
* @param inPayRate double of the employee's hourly rate
* @param inHoursWorked double of the employee's weekly hours worked
*/
	public Payroll(String inString, int inInt, double inPayRate, double inHoursWorked)
	{
		name = inString;
		idNumber = inInt;
		payRate = inPayRate;
		hoursWorked = inHoursWorked;
	}
	/**
* returns whether or not the two Payroll objects are equal to each other (have the same idNumber)
* @param  inObject Payroll object
* @return boolean true or false depending if the two objects are equal
*/
	public boolean equals(Payroll inObject)
	{
		if(inObject.idNumber == idNumber)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
*returns a String of the pay, rounded to two decimal places
* @return String of the pay, rounded to two decimal places
*/
	public String getStringPay()
	{
		DecimalFormat df = new DecimalFormat("$##,###.##");
		return df.format(getPay());
	}
	/**
* returns the double of the pay for the Payroll object
* @return returns the exact double representation of how much the pay is
*/
	public double getPay()
	{
		if(hoursWorked > 40)
		{
			return payRate * 40 + (1.5 *payRate) * (hoursWorked -40);
		}
		else
			return payRate * hoursWorked;
	}
	/**
* turns a Payroll object into a String
* @return Name followed by, followed by ID, followed by Gross Pay
*/
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(name +"\n");
		sb.append("ID #" + Integer.toString(idNumber) +"\n");
		sb.append("Gross Pay - "+getStringPay());
		return sb.toString();

	}
	/**
* getter method for the idNumber of a Payroll object
* @return The idNumber of a Payroll object
*/
	public int getID()
	{
		return idNumber;
	}
}