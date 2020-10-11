//
//Danielle Anderson
//Due 4/9/2018 before 1:30
//This program contains the methods for changing and displaying the shopping list of items.
//It sorts the list and adds a new item in the proper spot, removes an item, clears the list,
//displays info about each item in the list, and calculates the number of items and the total
//cost of each. It also uses a private method to find the index of a requested item.
public class KeyedListAnderson 
{
	//declaring private variables
	private ItemAnderson[] myList;
	private int mySize;

	public KeyedListAnderson()
	{
		//initializing variables
		myList = new ItemAnderson[20];
		for (int i = 0; i < 20; i++)
			myList[i] = null;
		mySize = 0;
	}//KeyedListAnderson null
	
	public void clear()
	{
		//set the viewable list to 0
		mySize = 0;
	}//clear
	
	private int findIndex(String keyValue)
	{
		//initialize local variables
		int answer = -1;
		//goes through each spot on the viewable list
		for (int i = 0; i < mySize; i++)
		{
			//initialize local variables
			String key1 = myList[i].getName();
			String key2 = keyValue;
			//compares variables
			if (key1.compareToIgnoreCase(key2) == 0)
			{
				answer = i;
			}//if
		}//for
		return answer;
	}//findIndex
	
	public boolean add(ItemAnderson product)
	{
		//initialize local variables
		boolean answer = false;
		int j = 0;
		boolean next = true;
		int pos = 0;
		//determine if adding an item is possible
		if (mySize < myList.length && findIndex(product.getName()) == -1)
		{
			//initialize local variables
			String key1 = product.getName();
			//goes through each spot of the list until unnecessary (guarantee loop)
			for (int i = 1; i < myList.length && next == true; i++)
			{
				//goes through each spot on the viewable list
				for (j = mySize; j > 0; j--)
				{
					//initialize local variable
					String key2 = myList[j-1].getName();
					//compare variables
					if (key1.compareToIgnoreCase(key2) < 0)
					{
						//skootch list to make room
						myList[j] = myList[j-1];
						pos = j-1;
						next = false; //going through the i loop again is unnecessary
					}//if
				}//for j
				//if j loop was never entered, the product will be last on the list
				if (next == true)
					pos = mySize;
				//otherwise it goes in the determined spot
				myList[pos] = product;
			}//for i
			mySize++;
			answer = true;
		}//if
		return answer;
	}//add
	
	public boolean remove(String keyValue)
	{
		//initialize local variables
		boolean answer = false;
		int pos = 0;
		pos = findIndex(keyValue);
		//if requested item is found
		if (pos != -1)
		{
			answer = true;
			//skootches the list back to "fill" in missing spot
			while (pos < mySize-1)
			{
				myList[pos] = myList[pos+1];
				pos++;
			}//while
			mySize--;
		}//if
		return answer;
	}//remove
	
	public ItemAnderson retrieve(String keyValue)
	{
		//initialize local variables
		ItemAnderson item = null;
		int pos = 0;
		pos = findIndex(keyValue);
		//if requested item is found return the item
		if (pos != -1)
			item = myList[pos];
		return item;
	}//retrieve
	
	public boolean isEmpty()
	{
		//initialize local variable
		boolean answer = false;
		//if there is no viewable list the list is empty
		if (mySize == 0)
			answer = true;
		return answer;
	}//isEmpty
	
	public boolean isFull()
	{
		//initialize local variable
		boolean answer = false;
		//if viewable list is equal to the length the list is full
		if (mySize == 20)
			answer = true;
		return answer;
	}//isFull
	
	public void print()
	{
		//goes through each spot on the viewable list
		for (int j = 0; j < mySize; j++)
		{
			System.out.println("Item " + (j+1) + ": " + myList[j].getName());
		}//for j
	}//print
	
	public int getCount()
	{
		//initialize local variable
		int sum = 0;
		//goes through each spot on the viewable list
		for (int i = 0; i < mySize; i++)
			sum += myList[i].getQuantity(); //adds together the sum
		return sum;
	}//getCount
	
	public double calcTotal()
	{
		//initialize local variable
		double total = 0.0;
		//goes through each spot on the viewable list
		for (int i = 0; i < mySize; i++)
			total += myList[i].getPrice() * myList[i].getQuantity(); //adds together the sum
		return total;
	}//calcTotal
}//KeyedListAnderson
