//
//Danielle Anderson
//Due March 26 before 1:30 pm
//This is the class for the mixCD object which contains an array of song objects. It
//uses methods to add songs to the array if there is enough space as well as find song
//lengths, delete long songs, calculate remaining time, and display information about
//the songs
public class MixCDAnderson 
{
	//creating private instance variables
	private SongAnderson[] mySongs;
	private int mySize;
	
	public MixCDAnderson() 
	{
		//initializing instance variables
		mySongs = new SongAnderson[12];
		mySize = 0;
	}//MixCDAnderson null constructor

	public int getSize()
	{
		return mySize;
	}//getSize
	
	//method to add songs to the array
	public boolean addToCD(SongAnderson Song)
	{
		//initializing local variables
		boolean isAdded = false;
		int totalTime = 0;
		
		//getting total runtime already on CD
		for (int i = 0; i < mySize; i++)
		{
			totalTime += mySongs[i].getRunTime();
		}//for
		
		//checking if there is enough space to add
		if (mySize < mySongs.length)
		{
			if (Song.getRunTime() + totalTime <= 4800)
			{
				mySongs[mySize] = Song;
				mySize++;
				isAdded = true;
			}//if
		}//if
		
		//indicate if song was added
		return isAdded;
	}//addToCD
	
	//method to remove longest song
	public void removeFromCD(SongAnderson Song) //gets the longest song as parameter
	{
		//finding the longest song in array
		for (int i = 0; i < mySize; i++)
		{
			if (mySongs[i] == Song)
				mySongs[i] = mySongs[mySize-1]; //replacing longest song with the last song
		}//for
		mySize -= 1;
	}//removeFromCD
	
	//method to find longest song
	public SongAnderson findLongestSong()
	{
		//initializing local variables
		int longest = mySongs[0].getRunTime(); //longest is default the first song's runtime
		int j = 0;
		
		//finds longest song in array
		for (int i = 0; i < mySize; i++)
		{
			if (mySongs[i].getRunTime() > longest)
			{
				longest = mySongs[i].getRunTime();
				j = i;
			}//if	
		}//for
		
		return mySongs[j];
	}//findLongestSong
	
	//method for finding the shortest song
	public SongAnderson findShortestSong()
	{
		//initializing local variables
		int shortest = mySongs[0].getRunTime(); //shortest is default first song's runtime
		int j = 0;
		
		//finding shortest sing in array
		for (int i = 0; i < mySize; i++)
		{
			if (mySongs[i].getRunTime() < shortest)
			{
				shortest = mySongs[i].getRunTime();
				j = i;
			}//if	
		}//for
		
		return mySongs[j];
	}//findShortestSong
	
	//method for finding the remaining time
	public int calcRemainingTime()
	{
		//initializing local variables
		int remainingTime = 4800; //4800 seconds = 80 minutes
		int totalTime = 0;
		
		//getting the total time from each song
		for (int i = 0; i < mySize; i++)
		{
			totalTime += mySongs[i].getRunTime();
		}//for
		remainingTime -= totalTime;
		
		return remainingTime;
	}//calcRemainingTime
	
	//method for printing the list of songs
	public void printSongList()
	{
		System.out.println("This is a list of all the songs in this CD: ");
		
		//goes through each song in array
		for (int i = 0; i < mySize; i++)
		{
			System.out.println("Song # " + (i+1) + " " + mySongs[i].getTitle() + " by " + mySongs[i].getArtist() + " runtime: " + mySongs[i].toString());
		}//for
	}//printSongList
	
}//MixCDAnderson
