//
//Danielle Anderson
//Due March 26 before 1:30 pm
//This program displays a menu of options to adjust a mixCD. It calls on other classes
//to add a song object to an array of songs, find the song object with the longest
//runtime, find the song object with the shortest runtime, find the number of songs in
//the array, find the total remaining runtime, display details about each song, and delete
//the longest song from the CD.

import java.util.*;

public class MusicDemoAnderson 
{
	public static void main(String[] args) 
	{
		//initialize instance variables
		char choice = ' ';
		int runtime = 0;
		int remainMin = 0;
		int remainSec = 0;
		int remainTime = 0;
		boolean isAdded = false;
		MixCDAnderson mixCD = new MixCDAnderson(); //create a mixCD object
		Scanner keyboard = new Scanner(System.in);
		
		do
		{
			//display menu of options
			System.out.println("Please enter the corresponding letter to perform an action.");
			System.out.println("A - Add a Song to the CD");
			System.out.println("L - Find the Song with the Longest runtime");
			System.out.println("S - Find the Song with the Shortest runtime");
			System.out.println("N - Find the Number of Songs on the CD");
			System.out.println("R - Find the total remaining time of the CD");
			System.out.println("P - Print out details about all Songs on the CD");
			System.out.println("D - Delete the Longest Song from the CD");
			System.out.println("Q - Quit");
			
			//get the letter to pick an option
			String fake = keyboard.next();
			fake = fake.toUpperCase();
			choice = fake.charAt(0);
			
			//calls on necessary methods depending on the option picked
			switch (choice)
			{
			case 'A' : 	//adding a song by creating a new song object
						System.out.println("Please enter the title of the song: ");
						String title = keyboard.next();
						System.out.println("Please enter the song artist: ");
						String artist = keyboard.next();
						System.out.println("Please enter the runtime of the song: ");
						runtime = keyboard.nextInt();
						
						SongAnderson newSong = new SongAnderson(title, artist, runtime);
						isAdded = mixCD.addToCD(newSong);
						
						//indicates whether or not the song was added
						if (isAdded)
							System.out.println("Your song was successfully added.");
						else
							System.out.println("Your song could not be added. There is not enough room left on the CD.");
						System.out.println();
						break;
			case 'L' : 	//finding the longest song by finding the runtime
						if (mixCD.getSize() > 0) //make sure there is a song to be long
						{
							SongAnderson longSong = mixCD.findLongestSong();
							System.out.println("The longest song in the CD is " + longSong.getTitle() + " by " + longSong.getArtist());
							System.out.println("Its runtime is " + longSong.toString());
						}//if
						else //if there are no songs
							System.out.println("There are currently no songs on the CD.");
						System.out.println();
						break;
			case 'S' : 	//finding the shortest song by finding the runtime
						if (mixCD.getSize() > 0) //make sure there is a song to be short
						{
							SongAnderson shortSong = mixCD.findShortestSong();
							System.out.println("The shortest song in the CD is " + shortSong.getTitle() + " by " + shortSong.getArtist());
							System.out.println("Its runtime is " + shortSong.toString());
						}//if
						else //if there are no songs
							System.out.println("There are currently no songs on the CD.");
						System.out.println();
						break;
			case 'N' : 	//finding the number of songs on the CD
						System.out.println("The number of songs on the CD is " + mixCD.getSize());
						System.out.println();
						break;
			case 'R' : 	//finding the remaining time on the CD
						remainTime = mixCD.calcRemainingTime();
						remainMin = remainTime/60;
						remainSec = remainTime%60;
						System.out.println("The remaining time of the CD is " + remainMin + " minutes and " + remainSec + " seconds.");
						System.out.println();
						break;
			case 'P' : 	//printing out the list of songs with their details
						if (mixCD.getSize() > 0) //make sure there is a song to display
							mixCD.printSongList();
						else //if there are no songs
							System.out.println("There are currently no songs on the CD.");
						System.out.println();
						break;
			case 'D' : 	//deleting the longest song (if there are multiple of the same length deletes the first one found)
						if (mixCD.getSize() > 0) //make sure this is a song to delete
						{
							SongAnderson longestSong = mixCD.findLongestSong(); //gets longest song first
							mixCD.removeFromCD(longestSong); //puts longest song as parameter
							System.out.println("Song " + longestSong.getTitle() + " by " + longestSong.getArtist() + " has been removed.");
						}
						else //if there are no songs
							System.out.println("There are currently no songs on the CD.");
						System.out.println();
						break;
			case 'Q' : 	//displaying a goodbye for quitting
						System.out.println("Goodbye.");
			}//switch
		}//do
		while (choice != 'Q'); //keeps looping until quit condition
		keyboard.close(); //close scanner
	}//main

}//MusicDemoAnderson
