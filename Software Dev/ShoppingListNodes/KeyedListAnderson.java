//
//Danielle Anderson
//Due 4/16/2018 before 1:30 pm
//This class sets up the keyed list which accesses node objects and adds and removes them to
//the list. It also clears a list of them, retrieves data on one, prints details of them,
//and counts and calculates information from them. It also has a null constructor.
public class KeyedListAnderson 
{
	//setting up private variable
	private NodeAnderson myHead;
	
	//null constructor for keyedList object
	public KeyedListAnderson()
	{
		//initializing variable
		myHead = null;
	}//KeyedListAnderson null
	
	//creates an empty viewable list
	public void clear()
	{
		//clearing the visible list by clearing the starting node
		myHead = null;
	}//clear
	
	//adds a new node containing new Item data to the list in alphabetical format
	public boolean add(ItemAnderson product)
	{
		//initialzing local variables
		boolean answer = false;
		boolean found = false;
		NodeAnderson current = myHead;
		NodeAnderson previous = null;
		NodeAnderson newNode = new NodeAnderson(product); //new node contains data of the new item
		
		//keep going until the list ends or the spot is found
		while (current != null && found == false)
		{
			//getting comparisons for sorting alphabetically
			String key1 = (current.getData()).getName();
			String key2 = product.getName();
			
			//look for right spot in order
			if (key1.compareToIgnoreCase(key2) > 0)
				found = true;
			else
			{
				//going to the next node
				previous = current;
				current = current.getNext();
			}//else
		}//while
		//if spot is at the start of the list or list is empty
		if (previous == null)
		{
			newNode.setNext(myHead);
			myHead = newNode;
			answer = true;
		}//if
		//if spot is in the middle or end of the list
		else
		{
			newNode.setNext(current);
			previous.setNext(newNode);
			answer = true;
		}//else
		
		return answer;
	}//add
	
	//removes a specified Item and its corresponding node from the list
	public boolean remove(String keyValue)
	{
		//initializing local variables
		boolean answer = false;
		NodeAnderson current = myHead;
		NodeAnderson previous = null;
		
		//keep going until requested item is found or the end of the list is reached
		while (answer != true && current != null)
		{
			String key = (current.getData()).getName();
			
			//checking to see if requested item is found
			if (key.compareToIgnoreCase(keyValue) == 0)
				answer = true;
			//goes to the next node
			else
			{
				previous = current;
				current = current.getNext();
			}//else
		}//while
		//if requested item was found
		if (answer == true)
		{
			//if item was the first in the list
			if (previous == null)
				myHead = myHead.getNext();
			//if item was anywhere else
			else
				previous.setNext(current.getNext());
		}//if
		return answer;
	}//remove
	
	//retrieves a specified Item
	public ItemAnderson retrieve(String keyValue)
	{
		//initializing local variables
		boolean found = false;
		ItemAnderson answer = null;
		NodeAnderson current = myHead;
		NodeAnderson previous = null;
		
		//keep going until requested item is found or the end of the list is reached
		while (current != null && found == false)
		{
			String key = (current.getData()).getName();
			
			//if item is found
			if (key.compareToIgnoreCase(keyValue) == 0)
			{
				answer = current.getData();
				found = true;
			}//if
			//goes to the next node
			else
			{
				previous = current;
				current = current.getNext();
			}//else
		}//while
		
		return answer;
	}//retrieve
	
	//checks to see if the list is empty
	public boolean isEmpty()
	{
		//initializing local variable
		boolean answer = false;
		//if first node is null the list is empty
		if (myHead == null)
			answer = true;
		return answer;
	}//isEmpty
	
	//displays details about each Item
	public void print()
	{
		//initializing local variables
		NodeAnderson current = myHead;
		int count = 1;
		
		//goes through whole list
		while (current != null)
		{
			//print details
			System.out.print("Item #" + count + ": " + (current.getData().getName()));
			System.out.print(", quantity: " + (current.getData().getQuantity()));
			System.out.println(", priced at: " + (current.getData().getPrice()));
			
			current = current.getNext(); //gets next node
			count++;
		}//while
	}//print
	
	//counts the number of Items using their quantity
	public int getCount()
	{
		//initializing local variables
		int total = 0;
		NodeAnderson current = myHead;
		
		//keeps going until end of list is reached
		while (current != null)
		{
			//counts total number of items
			total += (current.getData().getQuantity());
			current = current.getNext();
		}//while
		return total;
	}//getCount
	
	//calculates the total price of all the Items using their quantity and price
	public double calcTotal()
	{
		//initializing local variables
		double total = 0;
		NodeAnderson current = myHead;
		
		//keeps going until end of list is reached
		while (current != null)
		{
			//calculates total price
			total += ((current.getData().getPrice()) * (current.getData().getQuantity()));
			current = current.getNext();
		}//while
		return total;
	}//getCount
}//KeyedListAnderson
