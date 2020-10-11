//
//Danielle Anderson
//Due: 3/5/2018 before 1:30 pm
//This program creates rectangle objects and calls upon rectangle class to
//adjust the width, height, and fill style of rectangles and prints the filled
//and outlined version out. It also calculates area and perimeter
import java.util.*;

public class RectangleDemoAnderson 
{

	public static void main(String[] args) 
	{
		//initializing variables
		char choice = ' ';
		int width = 0;
		int height = 0;
		char fillStyle = ' ';
		Scanner keyboard = new Scanner(System.in);
		
		//creating a rectangle object
		Rectangle r = new Rectangle(10, 5, '*'); //uses default settings
		
		//loop for displaying menu
		do
		{
			System.out.println("Enter the corresponding letter to choose an option:");
			System.out.println("W : Assign the Width");
			System.out.println("H : Assign the Height");
			System.out.println("F : Assign the Fill Style");
			System.out.println("A : Calculate the Area");
			System.out.println("P : Calculate the Perimeter");
			System.out.println("T : Text Description of the Rectangle");
			System.out.println("D : Draw the Rectangle");
			System.out.println("O : Draw the Outline of the Rectangle");
			System.out.println("Q : Quit");
			
			//getting user choice
			String fake = keyboard.next();
			fake = fake.toUpperCase(); //case of user input does not matter
			choice = fake.charAt(0);
			
			//calls upon appropriate methods from rectangle class
			switch (choice)
			{
			case 'W':
				System.out.println("Enter the width: ");
				width = keyboard.nextInt();
				r.setWidth(width); //setting width of rectangle
				break;
			case 'H':
				System.out.println("Enter the height: ");
				height = keyboard.nextInt();
				r.setHeight(height); //setting height of rectangle
				break;
			case 'F':
				System.out.println("Enter the fill style: ");
				String hold = keyboard.next(); //holds a string to get fillstyle from
				fillStyle = hold.charAt(0); //getting char fillstyle
				r.setFillStyle(fillStyle); //setting fill style
				break;
			case 'A':
				System.out.println("Area: " + r.calcArea()); //calculates and prints area
				break;
			case 'P':
				System.out.println("Perimeter: " + r.calcPerimeter()); //calculates and prints perimeter
				break;
			case 'T':
				System.out.println("Width: " + r.getWidth()); //prints width
				System.out.println("Height: " + r.getHeight()); //prints height
				System.out.println("Fill Style: " + r.getFillStyle()); //prints fillstyle
				break;
			case 'D':
				r.drawRectangle(); //calls method to draw rectangle
				break;
			case 'O':
				r.drawOutline(); //calls method to draw outline of rectangle
				break;
			case 'Q':
				System.out.println("Goodbye."); //indicates to user they have quitted
			}//switch
			
		}//do
		while (choice != 'Q'); //only way to quit is to type Q, invalid letters do nothing and loops
	}//main

}//RectangleDemoAnderson
