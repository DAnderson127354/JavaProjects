//
//Danielle Anderson
//Due 2/26/2018 before 1:30
//This program uses methods to create an array of grades, an array of positive numbers,
//and an array of negative numbers. It uses helper methods to find the highest, lowest,
//and average grade, the number of even or odd numbers, and the number of times a target
//number is included

import java.util.*;

public class ArraysAnderson 
{

	public static void main(String[] args) 
	{
		//initializing variables
		int choice = -1;
		Scanner keyboard = new Scanner(System.in);
		
		//output menu screen and allow choices to be made until sentinel value is reached
		do
		{
		System.out.println("Choose a program (enter the integer on the left to choose):");
		System.out.println("(1) Handle Grades");
		System.out.println("(2) More Evens or More Odds?");
		System.out.println("(3) How Many Times?");
		System.out.println("(0) Quit");
		choice = keyboard.nextInt(); //getting user choice
		
		//menu selections
		switch (choice)
		{
		case 1: handleGrades();
			break;
		case 2: evenOrOdd();
			break;
		case 3: howManyTimes();
			break;
		case 0: System.out.println("Goodbye."); //quits menu
		}//switch
		}//do
		while(choice != 0); //repeats until sentinel value of zero is entered
	}//main
	
	//method creates a list of 10 doubles as grades
	public static void handleGrades()
	{
		//initializing local variables
		Scanner keyboard = new Scanner(System.in);
		double[] gradeList = new double[10];
		double high = 0;
		double low = 0;
		double average = 0;

		//loops 10 times and asks for doubles
		for (int i = 0; i < 10; i++)
		{
			System.out.println("Please enter grade " + (i+1)); //displays number of grades user is at
			gradeList[i] = keyboard.nextDouble();
		}//for
		
		high = highGrade(gradeList); //method call to find highest entered grade
		low = lowGrade(gradeList); //method call to find lowest entered grade
		average = averageGrade(gradeList); // method call to find average of entered grade
		
		//display results from helper methods
		System.out.println("The highest grade entered is " + high);
		System.out.println("The lowest grade entered is " + low);
		System.out.println("The average grade is " + average);
		System.out.println();
	}//handleGrades
	
	//helper method for handleGrades that finds the highest grade entered
	public static double highGrade(double[] list) //takes in array from handleGrades
	{
		//initializing local variables
		double max = list[0]; //first grade is highest to start for comparison
		for (int i = 0; i < 10; i++) //loops 10 times 
			if (list[i] > max) //check if this number is the highest
				max = list[i];
		return max; //returns highest number in array
	}//highGrade
	
	//helper method for handleGrades that finds the lowest grade entered
	public static double lowGrade(double[] list) //takes in array from handleGrades
	{
		//initializing local variables
		double min = list[0];
		for (int i = 0; i < 10; i++) //loops 10 times 
			if (list[i] < min) //check if this number is the lowest
				min = list[i];
		return min; //returns lowest number in array
	}//lowGrade
	
	//helper method for handleGrades that finds the average of all grades entered
	public static double averageGrade(double[] list) //takes in array from handleGrades
	{
		//initializing local variables
		double average = 0;
		double sum = 0;
		for (int i = 0; i < 10; i++) //loops 10 times 
			sum += list[i]; //creates a sum
		average = sum/10; //calculate average
		return average; //returns average of numbers in array
	}//averageGrade
	
	//method creates a list of at most 20 positive integers or until sentinel value is reached
	public static void evenOrOdd()
	{
		//initializing local variables
		int[] numList = new int[20];
		int count = 0;
		int num = 0;
		Scanner keyboard = new Scanner(System.in);
		//loops until count reaches 20 or a negative number is inputed
		while (count < 20 && num >= 0)
		{
			System.out.println("Enter a number:");
			System.out.println("(Enter a negative number to quit)");
			num = keyboard.nextInt();
			if (num >= 0) //check to prevent negative number from being put in array
			{
				numList[count] = num; 
				count++; //only counts when input is positive (length of array)
			}//if
		}//while
		printNum(numList, count); //calls helper method to print array
	}//evenOrOdd
	
	//helper method for evenOrOdd that prints array
	public static void printNum(int[] list, int length) //takes in array and number of numbers inputed
	{
		//initializing local variables
		int evens = 0;
		int odds = 0;
		//loops for as long as the number of inputed numbers is
		for (int i = 0; i < length; i++)
		{
			if (list[i] % 2 == 0) //check if even
				evens++;
			else //check if odd
				odds++;
		}//for
		if (evens > odds) //more evens than odds
		{
			System.out.println("There are more evens in this array.");
			System.out.print("Evens in array: ");
			for (int e = 0; e < length; e++) //loops for as long as the number of inputed numbers is
				if (list[e] % 2 == 0) //print out only the even numbers in the array
					System.out.print(list[e] + " ");
		}//if
		else if (evens < odds) //more odds than evens
		{
			System.out.println("There are more odds in this array.");
			System.out.print("Odds in array: ");
			for (int o = 0; o < length; o++) //loops for as long as the number of inputed numbers is
				if (list[o] % 2 != 0) //print out only the odd numbers in the array
					System.out.print(list[o]+ " ");
		}//else if
		else //tie of evens and odds
		{
			System.out.println("There is an equal amount of evens and odds in this array.");
			System.out.print("Array given: ");
			for (int j = 0; j < length; j++)//loops for as long as the number of inputed numbers is
				System.out.print(list[j]+ " "); //print out full array
		}//else
		System.out.println();
		System.out.println();
	}//printNum
	
	//method creates an array of at most 10 negative doubles and asks for a target number
	public static void howManyTimes()
	{
		//initializing local variables
		Scanner keyboard = new Scanner(System.in);
		double[] negativeList = new double[10];
		int count = 0;
		double num = -1;
		double target = 0;
		//loops until count reaches 10 or a positive number is inputed
		while (count < 10 && num < 0)
		{
			System.out.println("Enter a negative number");
			System.out.println("(Enter positive number to quit)");
			num = keyboard.nextDouble();
			if (num < 0) //make sure no positive number is put into the array
			{
				negativeList[count] = num;
				count++; //only counts when input is negative (length of array)
			}//if
		}//while
		System.out.println("Enter a target number to see if it is in the array: ");
		target = keyboard.nextDouble(); //getting target number
		//calling helper method to print the number of times the target in array
		printTarget(negativeList, target, count); 
	}//howManyTimes

	public static void printTarget(double[] list, double targetNum, int length)
	{
		//initializing local variables
		int countTarget = 0;
		System.out.print("Array given: ");
		//loops for as long as the number of inputed numbers is
		for (int i = 0; i < length; i++)
		{
			if (list[i] == targetNum) //look for target number
				countTarget++;
			System.out.print(list[i] + " "); //display full array
		}//for
		System.out.println();
		System.out.println("Target: " + targetNum); //display target number
		System.out.println("Number of times target appears: " + countTarget); //display number of times target in array
		System.out.println();
	}//printTarget
}//ArraysAnderson
