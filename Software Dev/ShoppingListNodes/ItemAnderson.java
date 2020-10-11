//
//Danielle Anderson
//Due 4/16/2018 before 1:30
//This program is the item class that contains the getters and constructors of an item object
public class ItemAnderson 
{
	//declare private variables
	private String myName;
	private int myQuantity;
	private double myPrice;
	
	//null constructor for Item object
	public ItemAnderson()
	{
		//initialize variables
		myName = "Default";
		myQuantity = 0;
		myPrice = 0.0;
	}//ItemAnderson null
	
	//full constructor for Item object
	public ItemAnderson(String newName, int newQuantity, double newPrice)
	{
		//initialize variables
		myName = newName;
		myQuantity = newQuantity;
		myPrice = newPrice;
	}//ItemAnderson full
	
	//return myName
	public String getName()
	{
		//returns name
		return myName;
	}//getName
	
	//returns myQuantity
	public int getQuantity()
	{
		//returns quantity
		return myQuantity;
	}//getQuantity
	
	//returns myPrice
	public double getPrice()
	{
		//returns price
		return myPrice;
	}//getPrice
	
}//ItemAnderson
