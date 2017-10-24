//Jarod DeWeese
//10/24/17
import java.util.*;
public class PayrollApp
{
	public static void main(String args[])	
	{
		ArrayList <Payroll> payRollList = new ArrayList<>();
		
		makePayrollObject();
	}
	public static Payroll makePayrollObject()
	{
		String name = "";
		int idNumber = 0;
		double payRate =0.0;
		double hoursWorked= 0.0;
		Scanner s = new Scanner(System.in);
		boolean shouldLoop = true;
		boolean shouldGetAnotherEmployee = true;
		do
		{
		do{
			try
			{
				System.out.print("Enter employee's name:");
				name = s.nextLine();
				if(name.equals(""))
				{
					throw new Exception("empty String");
				}
				shouldLoop = false;
			}
			catch (Exception e)
			{
				System.out.println("\nName required. Please re-enter");
				shouldLoop = true;
			}
		}while(shouldLoop);
		//getting the id number
		do{
			try
			{
				System.out.print("Enter employee's 6-digit ID:");
				String temp = s.nextLine();
				idNumber = Integer.parseInt(temp);
				if(idNumber>= 100000 && idNumber <=999999)
				{
					shouldLoop = false;
				}
				else
					throw new Exception();
			}
			catch (NumberFormatException e)
			{
				System.out.println("Enter a valid integer");
				shouldLoop = true;
			}
			catch(Exception e)
			{
				System.out.println("ID must be exactly 6-digits");
			}
		}while(shouldLoop);
		//getting the payrate
		do{
			try
			{
				System.out.printf("Enter %s pay rate:",name);
				String temp = s.nextLine().replaceAll("$","");
				System.out.println(temp);
				payRate = Double.parseDouble(temp);
				if(payRate < 5 || payRate > 99.99)
				{
					throw new Exception();
				}
				shouldLoop = false;
			}
			catch (NumberFormatException e)
			{
				System.out.println("No characters allowed. Enter doubles only.");
				shouldLoop =true;
			}
			catch (Exception e)
			{
				System.out.println("\nPayrate must be at least $5 and no more than $99.99");
				shouldLoop = true;
			}	
		}while(shouldLoop);
		//get hours worked
		do{
			try
			{
				System.out.printf("Enter %s's hours worked:", name);
				hoursWorked = Double.parseDouble(s.nextLine());
				if(hoursWorked <= 0.0 || hoursWorked >= 80.0)
				{
					throw new RuntimeException("dingus");
				}
				shouldLoop = false;
			}
			catch(RuntimeException e)
			{
				System.out.println("Enter a double between 0 and 80");
				shouldLoop = true;
			}
			catch (Exception e)
			{
				System.out.println("\nNo characters allowed. Enter doubles only");
				shouldLoop = true;
			}
		}while(shouldLoop);
		payRollList.add(new Payroll(name,idNumber,payRate, hoursWorked));
		System.out.print("Would you like to enter another student? (Y/N):");
		String temp = s.nextLine().toLowerCase();
		if(temp.charAt(0) == 'y')
		{
			shouldGetAnotherEmployee = true;
		}
		else
			shouldGetAnotherEmployee = false;
		}while(shouldGetAnotherEmployee);
		System.out.println("Current contents of ArrayList...");
		for(Payroll employee: payRollList)
		{
			System.out.println(employee.toString());
			System.out.println();
		}
		System.out.print("Enter an ID Number");
	}//end main
}//end class