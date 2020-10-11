//
//Danielle Anderson
//Due: 2/19/2018 before 1:30 PM
//This program uses methods to display movie purchases, calculating amount due,
//calculating total amount due, calculating average amount due, and finding minimums
//and maximums of calculated data

import java.util.*;
import java.text.*;

public class Movies 
{
	public static void main(String[] args) 
	{
		//initializing output
		int customerId = 0;
		int movieCount = 0;
		double moviesCost = 0.0;
		double serviceFee = 0.0;
		double amountDue = 0.0;
		int numOfCustomers = 0;
		double maxAmount = Integer.MIN_VALUE;
		int maxId = 0;
		double minAmount = Integer.MAX_VALUE;
		int minId = 0;
		double totalAmount = 0.0;
		double averageAmount = 0.0;
		boolean isMax = false;
		boolean isMin = false;
		
		Scanner keyboard = new Scanner(System.in);
		
		//getting first customer id
		do
		{
		System.out.println("Please enter customer id:");
		customerId = keyboard.nextInt();
		}//do
		while (customerId < 25000 && customerId != 0 || customerId > 99999);
		
		//main loop for multiple customer input
		while (customerId != 0)
		{
			System.out.println("Please enter customer name:");
			String customerName = keyboard.next();
		
			do
			{
				System.out.println("Please enter the number of movies ordered:");
				movieCount = keyboard.nextInt();
			}//do
			while (movieCount < 0);
			
			//method calls
			moviesCost = chooseMovies(movieCount); //calculates cost using length and rating
			serviceFee = calcServiceCharge(movieCount, moviesCost); //calculates service fee
			amountDue = calcTotalDue(moviesCost, serviceFee); //calculates total including tax
			outputResults(customerName, customerId, movieCount, moviesCost, serviceFee, amountDue); //displays results
			
			numOfCustomers++; //keeps track of the number of customers
			totalAmount += amountDue; //calculates total amount calculated
			isMax = maxTotalDue(amountDue, maxAmount); //returns true if current amount is the max so far
			isMin = minTotalDue(amountDue, minAmount); //returns true if current amount is the min so far
			
			//setting max and min
			if (isMax == true)
			{
				maxAmount = amountDue;
				maxId = customerId;
			}//if
			
			if (isMin == true)
			{
				minAmount = amountDue;
				minId = customerId;
			}//if
			
			//checks for more input
			do
			{
				System.out.println("Please enter customer id:");
				customerId = keyboard.nextInt();
			}//do
			while (customerId < 25000 && customerId > 99999);
		}//while
		
		//make sure average is not divided by zero
		if (numOfCustomers > 0)
			averageAmount = calcAverage(totalAmount, numOfCustomers); //finds total average
		else
		{
			averageAmount = 0;
			maxAmount = 0;
			minAmount = 0;
		}//else
		displayEnd(numOfCustomers, maxAmount, maxId, minAmount, minId, totalAmount, averageAmount); //displays results
	}//main

	//finds the cost of the movies chosen
	public static double chooseMovies(int numMovies)
	{
		//initializing local variables
		int movieLength = 0;
		char rating;
		String fake;
		double cost = 0.0;
		double rate = 0.0;
		double totalCost = 0.0;
		
		Scanner keyboard = new Scanner(System.in);
		
		for (int i = 0; i < numMovies; i++)
		{
			//getting movie run time (length) in minutes
			do
			{
				System.out.println("Please enter the length of the movie:");
				movieLength = keyboard.nextInt();
			}//do
			while (movieLength < 1 || movieLength > 240);
			
			//finding movie rating
			do
			{
				System.out.println("Please enter the movie rating:");
				fake = keyboard.next();
				fake = fake.toUpperCase();
			}//do
			while (fake.charAt(0) != 'G' && fake.charAt(0) != 'P' && fake.charAt(0) != 'R'
					&& fake.charAt(0) != 'X' && fake.charAt(0) != 'O');
			
			rating = fake.charAt(0);
			
			//calculating rate based on rating
			switch (rating)
			{
				case 'G': rate = .039; //3.9 cents
						break;
				case 'P': rate = .054; //5.4 cents
						break;
				case 'R': rate = .068; // 6.8 cents
						break;
				case 'X': rate = .273; // 27.3 cents
						break;
				case 'O': rate = .04; // 4 cents
			}//switch
			
			cost = movieLength * rate; //calculating cost of individual movie
			totalCost += cost; //calculating total cost of movies purchased by one customer
		}//for
		
		return totalCost;		
	}//chooseMovie
	
	//calculating service charge based on number of movies purchased
	public static double calcServiceCharge(int numMovies, double costSum)
	{
		//initializing local variables
		double serviceCharge = 0.0;
		
		//finding service charge
		if (numMovies >= 1 && numMovies <= 3)
			serviceCharge = costSum * .18;
		else if (numMovies >= 4 && numMovies <= 7)
			serviceCharge = costSum * .15;
		else if (numMovies >= 8 && numMovies <= 11)
			serviceCharge = costSum * .11;
		else
			serviceCharge = costSum * .05;
		
		return serviceCharge;
	}//calcServiceCharge
	
	//calculating total amount
	public static double calcTotalDue(double costs, double service)
	{
		//initializing local variables
		double due = 0.0;
		double tax = 0;
		
		//calculating total
		due = costs + service;
		tax = due * .07;
		due += tax;
		
		return due;
	}//calcTotalDue
	
	//determining if current amount is the max so far
	public static boolean maxTotalDue(double amount, double currentMax)
	{
		//initializing local variables
		double maxSoFar = currentMax;
		boolean max = false;
		
		//finding max so far
		if (amount > maxSoFar)
		{
			maxSoFar = amount;
			max = true;
		}//if

		return max;
	}//maxTotalDue
	
	//determining if current amount is the min so far
	public static boolean minTotalDue(double amount, double currentMin)
	{
		//initializing local variables
		double minSoFar = currentMin;
		boolean min = false;
		
		//finding min so far
		if (amount < minSoFar)
		{
			minSoFar = amount;
			min = true;
		}//if
		
		return min;
	}//minTotalDue
	
	//calculating average amount out of total entered
	public static double calcAverage(double sum, int num)
	{
		//initializing local variables
		double average = 0.0;
		
		//calculating average
		average = sum/num;
		
		return average;
	}//calcAverage
	
	//outputting and formatting results
	public static void outputResults(String customName, int customId, int moviesPurchased, 
									double costSum, double servCharge, double amount)
	{
		DecimalFormat moneyStyle = new DecimalFormat("$0.00");
		
		System.out.println("Customer name: " + customName);
		System.out.println("Customer id: " + customId);
		System.out.println("Number of movies purchased: " + moviesPurchased);
		System.out.println("Total cost of movies: " + moneyStyle.format(costSum));
		System.out.println("Service charged: " + moneyStyle.format(servCharge));
		System.out.println("Total amount due: " + moneyStyle.format(amount));
		System.out.println();
	}//outputResults
	
	//outputting and formatting results
	public static void displayEnd(int customerCount, double highAmount, int highId,
								double lowAmount, int lowId, double costSum, double avgAmount)
	{
		DecimalFormat moneyStyle = new DecimalFormat("$0.00");
		
		System.out.println("Number of customers entered: " + customerCount);
		System.out.println("Highest amount calculated: " + moneyStyle.format(highAmount));
		System.out.println("Customer id charged with highest amount: " + highId);
		System.out.println("Lowest amount calculated: " + moneyStyle.format(lowAmount));
		System.out.println("Customer id charged with lowest amount: " + lowId);
		System.out.println("Total sum of amount due: " + moneyStyle.format(costSum));
		System.out.println("Average of amounts due: " + moneyStyle.format(avgAmount));
	}//displayEnd
}//Movies