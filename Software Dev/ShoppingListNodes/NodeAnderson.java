//
//Danielle Anderson
//Due 4/16/2018 before 1:30 pm
//This class sets up the Node object with a null and full constructor initializing 
//the Item data and the next node. It also uses set and get methods to adjust and get
//info
public class NodeAnderson 
{
	//seting up private variables
	private ItemAnderson myData;
	private NodeAnderson myNext;
	
	//null constructor for node objects
	public NodeAnderson()
	{
		//initializing variables
		myData = null;
		myNext = null;
	}//NodeAnderson null
	
	//full constructor for node objects
	public NodeAnderson(ItemAnderson newData)
	{
		//initializing variables
		myData = newData;
		myNext = null;
	}//NodeAnderson full
	
	//sets myData (Item object) to a new Item
	public void setData(ItemAnderson newData)
	{
		//setting data to new data
		myData = newData;
	}//setData
	
	//sets myNext (Node object) to a new Node
	public void setNext(NodeAnderson newNext)
	{
		//setting next to a new next
		myNext = newNext;
	}//setNode
	
	//returns myData
	public ItemAnderson getData()
	{
		//getting data
		return myData;
	}//getData
	
	//returns myNext
	public NodeAnderson getNext()
	{
		//getting the reference to the next node
		return myNext;
	}//getNext
}//NodeAnderson
