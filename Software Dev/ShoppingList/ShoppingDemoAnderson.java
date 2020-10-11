//
//Danielle Anderson
//Due 4/9/2018 before 1:30 pm
//This program reads in a file and/or input and sorts it into a shopping list with
//each item sorted alphabetically. Items in this list can also be removed, located,
//printed, counted, and calculated to find a total cost via methods that access other
//classes.
import java.util.*;
import java.text.*;
import java.io.*;

public class ShoppingDemoAnderson 
{
	public static void main(String[] args) 
	{
		//initializing variables
		int choice = -1;
		boolean isAdded = false;
		boolean isRemoved = false;
		boolean isEmpty = false;
		int count = 0;
		double cost = 0.0;
		int quantity = 0;
		double price = 0.0;
		String name = "Default";
		KeyedListAnderson list = new KeyedListAnderson(); //creating list
		Scanner keyboard = new Scanner(System.in);
		DecimalFormat moneyStyle = new DecimalFormat("$0.00"); //format for money
		
		//getting files to read
		System.out.println("Enter a file name: ");
		String fileName = keyboard.next();
		File myFile = new File(fileName);
		
		try
		{
			Scanner input = new Scanner(myFile);
			
			//reading from each line in a file to create an item
			while(input.hasNext())
			{
				String itemName = input.next();
				int itemQuantity = input.nextInt();
				double itemPrice = input.nextDouble();
				ItemAnderson item = new ItemAnderson(itemName, itemQuantity, itemPrice);
				list.add(item);
			}//while
			input.close();
			System.out.println("File was successfully read.");
		}//try
		catch(Exception ex) //if an error occurs
		{
			System.out.println("There was an error in reading this file.");
		}//catch
		do
		{
			//display menu
			System.out.println("Enter the corresponding number to choose an option: ");
			System.out.println("1. Add an item to the list");
			System.out.println("2. Delete an item from the list");
			System.out.println("3. Print each item from the list");
			System.out.println("4. Search for a user-specified item in the list");
			System.out.println("5. Count the total number of items in the list");
			System.out.println("6. Total the cost of the items in the list");
			System.out.println("7. Determine whether the list is empty");
			System.out.println("8. Clear the list");
			System.out.println("0. Quit");
			choice = keyboard.nextInt(); //get user's choice
			
			//user choice goes to necessary method
			switch (choice)
			{
			case 1: //add an item to the list
					System.out.println("Enter the name of the item: ");
					name = keyboard.next();
					System.out.println("Enter the quantity of the item: ");
					quantity = keyboard.nextInt();
					System.out.println("Enter the unit price of the item: ");
					price = keyboard.nextDouble();
					ItemAnderson newItem = new ItemAnderson(name, quantity, price); //creating a new item object
					isAdded = list.add(newItem);
					//indicate if addition was successful
					if (isAdded == true)
						System.out.println("The item was successfully added to the list.");
					else
						System.out.println("The item cannot be added to the list.");
					break;
			case 2: //remove an item from the list
					System.out.println("Enter the name of the item to remove: ");
					name = keyboard.next(); //get item to be removed
					isRemoved = list.remove(name);
					//indicate if removal was successful
					if (isRemoved == true)
						System.out.println("The item was successfully removed from the list.");
					else
						System.out.println("This item was not found on the list and cannot be removed.");
					break;
			case 3: //print out details of list
					//check to make sure there are items in the list, indicate otherwise
					if (list.isEmpty()== false)
						list.print();
					else
						System.out.println("There is nothing to print.");
					break;
			case 4: //find details of an item in the list
					System.out.println("Enter the name of an item to search for: ");
					name = keyboard.next(); //get item to search for
					ItemAnderson item = list.retrieve(name);
					//indicate if item was not found otherwise display info
					if (item != null)
						System.out.println("The list contains " + item.getQuantity() + " " + item.getName() + "(s)" + " priced at " + moneyStyle.format(item.getPrice()) + " a piece.");
					else
						System.out.println(name + " was not found.");
					break;
			case 5: //count the number of items (including quantity) in the list
					count = list.getCount();
					System.out.println("The number of items in the list is: " + count + ".");
					break;
			case 6: //find the total cost of all the items in the list
					cost = list.calcTotal();
					System.out.println("The total cost of all items in the list is: " + moneyStyle.format(cost) + ".");
					break;
			case 7: //indicate whether or not the list is empty
					isEmpty = list.isEmpty();
					if (isEmpty == true)
						System.out.println("The list is empty.");
					else
						System.out.println("The list is not empty.");
					break;
			case 8: //clear list
					list.clear();
					break;
			case 0: //display ending message
					System.out.println("Goodbye.");
			}//switch
			
		}//do
		while (choice != 0);
		keyboard.close();
	}//main
}//ShoppingDemoAnderson
