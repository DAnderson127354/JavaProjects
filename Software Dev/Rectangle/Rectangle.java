//
//Danielle Anderson
//Due: 3/5/2018 before 1:30 pm
//This is the rectangle class that sets and returns the width, height, and fillstyle
//of rectangle objects created in main. It also calculates the area and perimeter
//and prints out the rectangle and outline of the rectangle
public class Rectangle 
{
	//creating private instance variables
	private int myWidth;
	private int myHeight;
	private char myFillStyle;

	public Rectangle() //null constructor
	{
		//initializing variables
		myWidth = 0;
		myHeight = 0;
		myFillStyle = ' ';
	}//Rectangle
	
	public Rectangle(int newWidth, int newHeight, char newFillStyle) //full constructor
	{
		//setting up variables
		myWidth = newWidth;
		myHeight = newHeight;
		myFillStyle = newFillStyle;
	}//Rectangle
	
	public void setWidth(int newWidth) //sets width of rectangle
	{
		if (newWidth > 0)
			myWidth = newWidth;
	}//setWidth
	
	public void setHeight(int newHeight) //sets height of rectangle
	{
		if (newHeight > 0)
			myHeight = newHeight;
	}//setHeight
	
	public void setFillStyle(char newFillStyle) //sets fillstyle of rectangle
	{
		myFillStyle = newFillStyle;
	}//setFillStyle
	
	public int getWidth() //returns width of rectangle
	{
		return myWidth;
	}//getWidth
	
	public int getHeight() //returns height of rectangle
	{
		return myHeight;
	}//getHeight
	
	public char getFillStyle() //returns fillstyle of rectangle
	{
		return myFillStyle;
	}//getFillStyle
	
	public int calcArea() //calculates area
	{
		int area = 0; //initializing variable
		area = myHeight * myWidth; //calculating area
		return area;
	}//calcArea
	
	public int calcPerimeter() //calculates perimeter
	{
		int perimeter = 0; //initializing variable
		perimeter = myHeight * 2 + myWidth * 2; //calculating perimeter
		return perimeter;
	}//calcPerimeter
	
	public void drawRectangle() //displays rectangle
	{
		for (int i = 0; i < myHeight; i++) //goes through each 'row'
		{
			System.out.println();
			for (int j = 0; j < myWidth; j++) //goes through each 'column'
				System.out.print(myFillStyle + " "); //prints rectangle
		}//for i
		System.out.println(); //extra space between rectangle and menu
		System.out.println();
	}//drawRectangle
	
	public void drawOutline()
	{
		for (int i = 0; i < myHeight; i++) //goes through each 'row'
		{
			System.out.println();
			for (int j = 0; j < myWidth; j++) //goes through each 'column'
			{
				if (i != 0 && i != myHeight - 1) //check if at the top or bottom
				{
					if (j != 0 && j != myWidth-1) //check if at the sides
						System.out.print(" " + " "); //empty space inside
					else
						System.out.print(myFillStyle + " "); //prints outline of top and bottom
				}//if
				else
					System.out.print(myFillStyle + " "); //prints outline of sides
			}//for j
		}//for i
		System.out.println(); //extra space
		System.out.println();
	}//drawOutline

}//Rectangle
