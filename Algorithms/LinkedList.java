/*Danielle Anderson
9/27/19
435L-111*/
public class LinkedList 
{
	
	// The LinkedList Node class
	private class Node
	{
		
		int data;
		Node next;
		
		Node(int gdata)
		{
			this.data = gdata;
			this.next = null;
		}
	}//node
	
	// The LinkedList fields
	Node head;
	
	// Constructor
	LinkedList(int gdata)
	{
		this.head = new Node(gdata);
	}//linkedlist
	
	public void Insertend(int gdata)
	{
		Node current = this.head;

		while(current.next!= null)
		{
			current = current.next;
		}
		
		Node newnode = new Node(gdata);
		current.next = newnode;
		
	}//Insertend
	
	public void Listprint()
	{
		Node current = this.head;

		while(current!= null)
		{
			System.out.print(current.data + " ");
			current = current.next;
		}
		
		System.out.println();
		
	}//ListPrint
	
	public void Removemin() 
	{
	// Complete this method to remove the minimum value in a linkedlist
		Node current = this.head;
		Node prev = null;
		//if there is nothing smaller than the head in the list,
		//then it is the minimum by default
		Node min = current; 
		
		//go through each node in the list
		while(current.next != null)
		{
			//if there is a value less than the min
			//change the min and previous node accordingly
			if (current.next.data <= min.data)
			{
				min = current.next;
				prev = current;
			}//if
			current = current.next;
		}//while
		if (min == this.head)
			this.head = min.next;
		else
			prev.next = min.next;
	}//Removemin
	
	public static void main(String[] args) 
	{
		
		LinkedList exlist = new LinkedList(8);
		
		exlist.Insertend(1);
		exlist.Insertend(5);
		exlist.Insertend(2);
		exlist.Insertend(7);
		exlist.Insertend(10);
		exlist.Insertend(3);
		
		exlist.Listprint();
		//output: 8 1 5 2 7 10 3
		
		exlist.Removemin();
		
		exlist.Listprint();
		//output should be: 8 5 2 7 10 3
		
	}//main
}//LinkedList

