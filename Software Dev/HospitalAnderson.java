//
//Danielle Anderson
//Prog 3
//2/12/18 before 1:30PM
//This program outputs the bill that is charged based on an entered patient's
//properties, and displays the number of inputs and the maximum input

//importing scanner and decimal format
import java.util.*;
import java.text.*;

public class HospitalAnderson 
{

	public static void main(String[] args) 
	{
		//initializing variables
		double income = 0;
		int days = 0;
		int id = 0;
		double diem = 0;
		char insurance;
		double adminFee = 500;
		double serviceFee = 0;
		double discount = 0;
		double totalBill = 0;
		String insuranceName = "";
		String fake = "";
		int numOfPatients = 0;
		double maxBill = 0;
		int maxId = 0;
		int numOfBills = 0;
		double billAverage = 0;
		double sumOfBills = 0;
		
		//creating scanner object for input and decimal format for output
		Scanner keyboard = new Scanner(System.in);
		DecimalFormat moneyStyle = new DecimalFormat("$0.00");
		
		//getting initial input to start loop
		do
		{
			System.out.println("Enter 0 for the id to quit.");
			System.out.println("Enter the patient's id number:");
			id = keyboard.nextInt();
		}//do
		while (id < 0);
		
		while (id != 0) //loop for patient input
		{
		
			do //making sure income is positive
			{
				//getting patient's properties
				System.out.println("Enter the patient's household income:");
				income = keyboard.nextDouble();
			}//do
			while (income < 0);
		
			do //making sure plan is valid
			{
				System.out.println("Enter the first letter of the patient's insurance plan:");
				fake = keyboard.next();
				fake = fake.toLowerCase();
			}//do
			while (fake.charAt(0) != 'b' && fake.charAt(0) != 'm' && fake.charAt(0) != 'h'&& fake.charAt(0) != 'n');
		
			insurance = fake.charAt(0);//assigning insurance as a single character
		
			do
			{
				System.out.println("Enter the number of days the patient has" +
					" stayed in the hospital:");
				days = keyboard.nextInt();
			}//do
			while ((days < 1) || (days > 365)); //making sure days are within a year
		
			//finding amount the patient needs to pay per day based on their properties
			switch (insurance)
			{
			//insurance plan BluePlus
				case 'b': 
					if (income >= 15000)
					{
						if (income <= 67500)
							diem = 85;
						else
							diem = 150;
					}//if
					else
					{
						diem = 50;
					}//else
					insuranceName = "Blue Plus";
					break;
			//insurance plan Med-Health
				case 'm': 
					if (income >= 20000)
						{
							if (income <= 75000)
								diem = 100;
							else
								diem = 200;
						}//if
					else
					{
						diem = 65;
					}//else
					insuranceName = "Med-Health";
					break;
			//insurance plan HealthPlan
				case 'h':
					if (income >= 17500)
					{
						if (income <= 63000)
							diem = 90;
						else
							diem = 150;
					}//if			
					else
					{
						diem = 55;
					}//else
					insuranceName = "Health Plan";
					break;
			//No insurance plan
				case 'n': diem = 500;
					insuranceName = "None";
			}//switch
		
			//finding total service fee
			serviceFee = diem * days;
			//checking if patient is eligible for a discount
			if (days > 25)
				discount = (days/7) * 300;
			else 
				discount = 0;
		
			//calculating total bill
			totalBill = (adminFee + serviceFee) - discount;
		
			if (totalBill >= maxBill)
			{
				maxBill = totalBill;
				maxId = id;
			}//if
		
			//outputting results with formated results
			System.out.println("Patient ID: " + id);
			System.out.println("Patient's Household Income: " + moneyStyle.format(income));
			System.out.println("Patient's Insurance Plan: " + insuranceName);
			System.out.println("Number of Days Spent at Hospital: " + days);
			System.out.println("Admittance Fee: " + moneyStyle.format(adminFee));
			System.out.println("Per Diem Rate: " + moneyStyle.format(diem));
			System.out.println("Service Fee: " + moneyStyle.format(serviceFee));
			System.out.println("Discount: " + moneyStyle.format(discount));
			System.out.println("Total Bill: " + moneyStyle.format(totalBill));
		
			numOfPatients++; //counting the number of patients
			numOfBills++; //counting the number of bills
			sumOfBills += totalBill; //calculating the sum amount of all bills
		
			//prompting for patient id
			do
			{
				System.out.println();
				System.out.println("Enter 0 for the id to quit.");
				System.out.println("Enter the patient's id number:");
				id = keyboard.nextInt();
			}//do
			while (id < 0);
			}//while (main loop)
		
		//calculating bill average
		if (sumOfBills != 0 && numOfBills != 0) //making sure if no bills are entered
			billAverage = sumOfBills / numOfBills; //the bill average is zero and not
		else										//divided by zero
			billAverage = 0;
		
		//displaying output
		System.out.println("Number of Patients Entered: " + numOfPatients);
		System.out.println("Highest Bill Amount: " + moneyStyle.format(maxBill));
		System.out.println("Patient Id Charged with Highest Bill: " + maxId);
		System.out.println("Total Amount of Bills Processed: " + moneyStyle.format(sumOfBills));
		System.out.println("Average Bil Processed: " + moneyStyle.format(billAverage));
	}//main

}//HospitalAnderson
