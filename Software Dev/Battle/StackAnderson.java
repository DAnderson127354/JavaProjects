//
//Danielle Anderson
//Due 4/30/18 before 1:30 pm
//This class creates a Stack object consisting of a list of card objects. It has a max
//size of the list and a int variable to reference the current top of the stack. It uses
//a push method to add to the top of the stack, a pop method to remove from the top of
//the stack, and isFull and isEmpty methods to indicate their respective conditions.
//It also has a null constructor.
public class StackAnderson 
{
	//setting up private variables
	private CardAnderson[] myList;
	private int myTop;
	private static final int MAXSIZE = 52;
	
	//null constructor
	public StackAnderson()
	{
		//initializing variables
		myList = new CardAnderson[MAXSIZE];
		myTop = -1;
	}//StackAnderson null
	
	//adds to the top of the stack
	public boolean push(CardAnderson card)
	{
		//initializing local variable
		boolean answer = false;
		//check to see if there is room to add
		if (isFull() == false)
		{
			myTop++; //create a new top of the stack
			myList[myTop] = card; //add card
			answer = true; //indicate addition was successful
		}//if
		return answer;
	}//push
	
	//removes from the top of the stack
	public CardAnderson pop()
	{
		//initializing local variable
		CardAnderson answer = null;
		//check to make sure there is something to be removed
		if (isEmpty() == false)
		{
			answer = myList[myTop]; //get item to be removed
			myTop--; //remove item
		}//if
		return answer;
	}//pop
	
	//check to see if stack is full
	public boolean isFull()
	{
		//initialize local variable
		boolean answer = false;
		//if max size is reached
		if (myTop == MAXSIZE)
			answer = true; //stack is full
		return answer;
	}//isFull
	
	//check to see if stack is empty
	public boolean isEmpty()
	{
		//initialize local variable
		boolean answer = false;
		//if top is not in stack
		if (myTop == -1)
			answer = true; //stack is empty
		return answer;
	}//isFull
	
}//StackAnderson
