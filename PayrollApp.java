//Jarod DeWeese
//10/24/17
import java.util.*;
public class PayrollApp
{
	public static void main(String args[])	
	{
		Scanner s = new Scanner(System.in);
		boolean shouldGetAnotherEmployee;
		ArrayList <Payroll> payRollList = new ArrayList<>();
		// System.out.print("Enter an ID# to delete:");
		 int tempID =-12;//= Integer.parseInt(s.nextLine());
		do
		{
			payRollList.add(makePayrollObject(payRollList));
			System.out.print("Would you like to enter another employee? (Y/N):");
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
			HashMap <Integer, Payroll> map = new HashMap <>(payRollList.size());
			for(Payroll elem: payRollList)
			{
				map.put(elem.getID(), elem);
			}

			System.out.print("Enter an ID number to delete corresponding record: ");
			boolean shouldLoop = true;
			while(shouldLoop)
			{
				try
				{
					String tempString = s.nextLine();
					if(tempString.length() !=6)
					{
						shouldLoop = true;
						throw new RuntimeException();
					}
					tempID = Integer.parseInt(tempString);
					if(map.get(tempID) != null)
						shouldLoop = false;
				}
				catch(Exception e)
				{
					System.out.print("Enter valid ID number");
				}
			}
			for(int i = 0; i<payRollList.size(); i++)
			{
				int myInt = payRollList.get(i).getID();
				if(myInt == tempID)
				{
					payRollList.remove(i);
					System.out.println("Employee with ID# " + myInt+" removed from ArrayList");
				}
			}
			System.out.println("Enter the info for final employee to be added to the list");
			payRollList.add(makePayrollObject(payRollList));
			System.out.println("Final contents of ArrayList...");
			for(Payroll employee: payRollList)
			{
				System.out.println(employee.toString());
				System.out.println();
			}
	}
	public static Payroll makePayrollObject( ArrayList <Payroll> payRollList)
	{
		String name = "";
		int idNumber = 0;
		double payRate =0.0;
		double hoursWorked= 0.0;
		Scanner s = new Scanner(System.in);
		boolean shouldLoop = true;
		boolean shouldGetAnotherEmployee = true;
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
				boolean isADuplicate = true;
				for(Payroll elem: payRollList)
				{
					if(idNumber == elem.getID())
					{
						throw new RuntimeException();
					}
				}
				if(idNumber>= 100000 && idNumber <=999999)
				{
					shouldLoop = false;
				}
				else
				{
					shouldLoop = true;
					throw new Exception();
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Enter a valid integer");
				shouldLoop = true;
			}
			catch(RuntimeException e)
			{
				System.out.println("It seems you have entered a duplicate, try agiain");
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
				//System.out.println(temp);
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
		return new Payroll(name,idNumber,payRate, hoursWorked);
	}//end makePayrollObjects
}//end class