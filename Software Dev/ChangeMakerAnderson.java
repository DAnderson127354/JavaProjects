//
// Danielle Anderson
// Prog 1
// 1/29/18 before 1:30 PM
// This program will calculate the change of an inputed number in bills and coins
// It implements division and modules in order to find the number of bills and coins
// that are change for the inputed number

import java.util.*; //import java library

public class ChangeMakerAnderson {

	public static void main(String[] args) 
	{
	//initializing all variables
	int amount = 0;
	int originalAmount = 0;
	int twentyBills = 0;
	int tenBills = 0;
	int fiveBills = 0;
	int bills = 0;
	int quaters = 0;
	int dimes = 0;
	int nickels = 0;
	int pennies = 0;
	int totalBills = 0;
	int totalCoins = 0;
	
	//program instructions and description
	System.out.println("Enter a positive whole number.");
	System.out.println("I will output a combination of bills and coins");
	System.out.println("that equals that amount in change.");
	
	//getting input via scanner
	Scanner keyboard = new Scanner(System.in); 
	amount = keyboard.nextInt(); //next int inputed will be set as the amount
	
	originalAmount = amount;
	
	//calculating number of bills and coins that go into amount
	//finds number of bills/coins that fit into amount
	//finds remaining amount and repeats
	
	twentyBills = amount/2000; //twenty dollars = 2000 pennies
	amount = amount%2000;	
	tenBills = amount/1000;	   //ten dollars = 1000 pennies
	amount = amount%1000;
	fiveBills = amount/500;    //five dollars = 500 pennies
	amount = amount%500;
	bills = amount/100;		   //one dollar = 100 pennies
	amount = amount%100;
	quaters = amount/25; 	   //quarter = 25 pennies
	amount = amount%25;
	dimes = amount/10; 		   //dime = 10 pennies
	amount = amount%10;
	nickels = amount/5; 	   //nickel = 5 pennies
	amount = amount%5;
	pennies = amount; 		   //pennies is ultimately any remainder
	
	//calculating total number of bills and coins
	totalBills = twentyBills + tenBills + fiveBills + bills;
	totalCoins = quaters + dimes + nickels + pennies;
	
	//displaying results
	System.out.println(originalAmount + " cents can be given as:");
	System.out.println(twentyBills + " twenty dollar bill(s),");
	System.out.println(tenBills + " ten dollar bill(s),");
	System.out.println(fiveBills + " five dollar bill(s),");
	System.out.println(bills + " one dollar bill(s),");
	System.out.println(quaters + " quater(s),");
	System.out.println(dimes + " dime(s),");
	System.out.println(nickels + " nickel(s),");
	System.out.println("and " + pennies + " penny/pennies,");
	System.out.println("for a total of " + totalBills + " dollar bill(s)");
	System.out.println("and " + totalCoins + " coin(s).");
	
	}//main

}//Prog1

