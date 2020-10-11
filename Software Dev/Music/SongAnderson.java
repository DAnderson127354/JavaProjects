//
//Danielle Anderson
//Due March 26 before 1:30 pm
//This is the song class that contains constructors and methods for song objects
public class SongAnderson 
{
	//creating private instance variables
	private String myTitle;
	private String myArtist;
	private int myRunTime;
	
	public SongAnderson() 
	{
		//initializing instance variables
		myTitle = "Default";
		myArtist = "Default";
		myRunTime = 0;
	}//SongAnderson null constructor
	
	public SongAnderson(String newTitle, String newArtist, int newRunTime)
	{
		//setting up instance variables
		myTitle = newTitle;
		myArtist = newArtist;
		myRunTime = newRunTime;
	}//SongAnderson full constructor
	
	public void setTitle(String newTitle)
	{
		myTitle = newTitle;
	} //setTitle
	
	public void setArtist(String newArtist)
	{
		myArtist = newArtist;
	} //setArtist
	
	public void setRunTime(int newRunTime)
	{
		myRunTime = newRunTime;
	} //setRunTime
	
	public String getTitle()
	{
		return myTitle;
	}//getTitle
	
	public String getArtist()
	{
		return myArtist;
	}//getArtist
	
	public int getRunTime()
	{
		return myRunTime;
	}//getRunTime
	
	//convert nonStrings to string format
	public String toString()
	{
		//initializing local variables
		int minutes = 0;
		int seconds = 0;
		
		minutes = myRunTime/60;
		seconds = myRunTime%60;
		
		String time = minutes + " minutes and " + seconds + " seconds.";
		return time;
	}//toString

}//SongAnderson
