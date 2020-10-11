//create basic calculator
import java.util.*; //import java library

public class Calculator 
{
	public static void main(String[] arg)
	{
	//define variables
		//input double
		//input string (sign) or enter (calculates)
	double num = 0.0;
	String sign = " ";
	double result = 0.0;
	String entry = " ";
	
	System.out.println("Please enter a number: ");
	Scanner keyboard = new Scanner(System.in);
	result = keyboard.nextDouble();
	//loop until input becomes enter
	while (!entry.equalsIgnoreCase("enter"))
	{
		System.out.println("Enter a math sign or type enter to calculate and display result:");
		entry = keyboard.next();
		if (!entry.equalsIgnoreCase("enter"))
		{
			sign = entry;
			if (sign.equalsIgnoreCase("+"))
			{
				System.out.println("Please enter a number: ");
				num = keyboard.nextDouble();
				result = add(result, num);
			}
			else if (sign.equalsIgnoreCase("-"))
			{
				System.out.println("Please enter a number: ");
				num = keyboard.nextDouble();
				result = sub(result, num);
			}
			else if (sign.equalsIgnoreCase("*"))
			{
				System.out.println("Please enter a number: ");
				num = keyboard.nextDouble();
				result = mult(result, num);
			}
			else if (sign.equalsIgnoreCase("/"))
			{
				System.out.println("Please enter a number: ");
				num = keyboard.nextDouble();
				result = div(result, num);
			}
			else
				System.out.println("Please enter a proper math sign.");
		}//if
	}//while
	
	System.out.println("The result is " + result);
	}//main
	
	//addition method
	public static double add(double num1, double num2)
	{
		double sum = 0.0;
		sum = num1 + num2;
		return sum;
	}//add
	//subtraction method
	public static double sub(double num1, double num2)
	{
		double remain = 0.0;
		remain = num1 - num2;
		return remain;
	}//sub
	//multiplication method
	public static double mult(double num1, double num2)
	{
		double product = 0.0;
		product= num1 * num2;
		return product;
	}//mult
	//division method
	public static double div(double num1, double num2)
	{
		double quotient = 0.0;
		quotient= num1 / num2;
		return quotient;
	}//div
}//Calculator
