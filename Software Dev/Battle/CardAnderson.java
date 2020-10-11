//
//Danielle Anderson
//Due 4/30/18 before 1:30 pm
//This class creates a card object that has an int value and a char suit.
//It uses constructors, getters  to create and give data about the card.
public class CardAnderson 
{
	//setting up private variables
	private int myValue;
	private char mySuit;
	
	//null constructor
	public CardAnderson()
	{
		//initializing variables
		myValue = 0;
		mySuit = 'z';
	}//CardAnderson null
	
	//full constructor
	public CardAnderson(int newValue, char newSuit)
	{
		//initializing variables
		myValue = newValue;
		mySuit = newSuit;
	}//CardAnderson full
	
	//returns the value of the card
	public int getValue()
	{
		return myValue;
	}//getValue
	
	//returns the suit of the card
	public char getSuit()
	{
		return mySuit;
	}//getSuit
}//CardAnderson
