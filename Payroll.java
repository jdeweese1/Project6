import java.text.DecimalFormat;
public class Payroll
{
	private String name;
	private int idNumber;
	private double payRate;
	private double hoursWorked;

	public Payroll()
	{

	}
	public Payroll(String inString, int inInt, double inPayRate, double inHoursWorked)
	{
		name = inString;
		idNumber = inInt;
		payRate = inPayRate;
		hoursWorked = inHoursWorked;
	}
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
	public String getStringPay()
	{
		DecimalFormat df = new DecimalFormat("$##,###.##");
		return df.format(getPay());
	}
	public double getPay()
	{
		if(hoursWorked > 40)
		{
			return payRate * 40 + (1.5 *payRate) * (hoursWorked -40);
		}
		else
			return payRate * hoursWorked;
	}
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(name +"\n");
		sb.append(Integer.toString(idNumber) +"\n");
		sb.append(getStringPay());
		return sb.toString();

	}
}