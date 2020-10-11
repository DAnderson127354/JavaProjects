//
//Danielle Anderson
//Due 4/30/18 before 1:30 pm
//This is a main class that runs a card game of battle using a stack of card objects.
//The main method loops through win conditions to continue or end the game and access
//different methods for each stage of the game. These include the deal method, which
//takes in a file and reads each line to assign an value for the card and then assigns
//a suit to this. There is the countCards method that counts the card of a stack, a
//winPlay method that gives the cards to the winner of the round, a copy method that
//copies the cards in the discard pile to the play pile, a play method that gets the
//value of the cards from each stack, and a printResults method that displays the winner
//and loser of the game.
import java.io.File;
import java.util.Scanner;

public class BattleDemoAnderson 
{
	public static void main(String[] args) 
	{
		//initialize variables
		int startDeck = 0;
		int numPlays = 0;
		String winner = "None";
		String loser = "None";
		StackAnderson discard1 = new StackAnderson();
		StackAnderson discard2 = new StackAnderson();
		
		StackAnderson[] deckList = new StackAnderson[2];
		
		StackAnderson play1 = new StackAnderson();
		StackAnderson play2 = new StackAnderson();
		
		System.out.println("Welcome to the game of battle!");
		
		//creating playing decks
		deckList = deal();
		play1 = deckList[0];
		play2 = deckList[1];
		
		//finding initial number of cards
		startDeck = countCards(play1) + countCards(play2);
		
		//while each player still has cards and the game hasn't gone too long
		while(countCards(play1) != 0 && countCards(play2) != 0 && numPlays < 1000)
		{
			//get each player's card for a round
			CardAnderson card1 = play(play1);
			CardAnderson card2 = play(play2);
			
			//compare values
			String winRound = compare(card1,card2);
		
			//decide winner of the round or lack of
			if (winRound.equals("Player 1")) //player 1 wins
			{
				//give both cards to player 1's discard pile
				discard1 = winPlay(discard1, card1);
				discard1 = winPlay(discard1, card2);
			}//if
			else if (winRound.equals("Player 2")) //player 2 wins
			{
				//give both cards to player 2's discard pile
				discard2 = winPlay(discard2, card2);
				discard2 = winPlay(discard2, card2);
			}//else if
			else //tie
			{
				//give each player back their card in their discard pile
				discard1 = winPlay(discard1, card1);
				discard2 = winPlay(discard2, card2);
			}//else
			
			//check to see if players need to take cards from their discard pile
			if (play1.isEmpty() && !discard1.isEmpty())
				play1 = copy(discard1, play1);
			if (play2.isEmpty() && !discard2.isEmpty())
				play2 = copy(discard2, play2);
			
			numPlays++; //count rounds
		}//while
		
		//determine winner and loser
		if (play1.isEmpty() && !play2.isEmpty()) //player 2 wins
		{
			winner = "Player 2";
			loser = "Player 1";
		}//if
		else if (!play1.isEmpty() && play2.isEmpty()) //player 1 wins
		{
			winner = "Player 1";
			loser = "Player 2";
		}//else if
		
		//show results
		printResults(winner, loser, startDeck, numPlays);
	}//main
	
	//reads input from a file to distribute to each player
	public static StackAnderson[] deal()
	{
		//initialize local variables
		StackAnderson deck1 = new StackAnderson();
		StackAnderson deck2 = new StackAnderson();
		StackAnderson[] list = new StackAnderson[2];
		char suit = 'z';
		boolean isAdded = false;
		int count = 0;
		
		//getting files to read
		System.out.println("Enter a file name: ");
		Scanner keyboard = new Scanner(System.in);
		String fileName = keyboard.next();
		File myFile = new File(fileName);
		try
		{
			Scanner input = new Scanner(myFile);
			
			//while there is still input and it does not exceed the deck maximum
			while (input.hasNext() && count < 52)
			{
				//get value
				int value = input.nextInt();
				//assign suit based on position in file
				if (count % 4 == 0)
					suit = 'D';
				else if (count % 3 == 0)
					suit = 'C';
				else if (count % 2 == 0)
					suit = 'S';
				else
					suit = 'H';
				//create a card object
				CardAnderson card = new CardAnderson(value, suit);
				//alternate between players
				if (count % 2 == 0)
					isAdded = deck1.push(card);
				else
					isAdded = deck2.push(card);
				count++;
			}//while
			//create a list of the decks to return both at once
			list[0] = deck1;
			list[1] = deck2;
			input.close();
			System.out.println("File was successfully read.");
		}//try
		catch(Exception ex) //if an error occurs
		{
			System.out.println("There was an error in reading this file.");
		}//catch
		keyboard.close();
		return list;
	}//deal
	
	//gets card from a player for a round in the game
	public static CardAnderson play(StackAnderson deck)
	{
		//initialize local variable
		CardAnderson card = new CardAnderson();
		card = deck.pop(); //get card from deck
		return card;
	}//play

	//compares the value of each card and determines the winner (higher card)
	public static String compare(CardAnderson card1, CardAnderson card2)
	{
		//initialize local variable
		String winner = "No one";
		//CardAnderson winCard = new CardAnderson();
		
		//determine winner
		if (card1.getValue() > card2.getValue()) //player 1 wins
			winner = "Player 1";
		else if (card1.getValue() < card2.getValue() )//player 2 wins
			winner = "Player 2";
		
		return winner;
		
	}//compare
	
	//gives card to specified deck
	public static StackAnderson winPlay(StackAnderson deck, CardAnderson card)
	{
		//initialize local variable
		boolean isAdded = false;
		//add card to deck
		isAdded = deck.push(card);
		
		return deck;
	}//winPlay
	
	//copy cards from one deck to another
	public static StackAnderson copy(StackAnderson discard, StackAnderson play)
	{
		//initialize local variables
		boolean isAdded = false;
		StackAnderson temp = new StackAnderson();
		CardAnderson card = new CardAnderson();
		//move discard to temporary deck to preserve order
		while (!discard.isEmpty())
		{
			card = discard.pop();
			isAdded = temp.push(card);
		}//while
		//put temporary deck cards to play deck
		while (!temp.isEmpty())
		{
			card = temp.pop();
			isAdded = play.push(card);
		}//while
		return play;
	}//copy
	
	//counts the number of cards in a deck by popping and pushing back
	public static int countCards(StackAnderson deck)
	{
		//initialize local variables
		boolean isAdded = false;
		StackAnderson temp = new StackAnderson();
		CardAnderson card = new CardAnderson();
		int count = 0;
		//pop into temporary deck to count
		while (!deck.isEmpty())
		{
			card = deck.pop();
			isAdded = temp.push(card);
			count++;
		}//while
		//push cards back to deck
		while (!temp.isEmpty())
		{
			card = temp.pop();
			isAdded = deck.push(card);
		}//while
		
		return count;
	}//countCards
	
	//display endgame results
	public static void printResults(String winner, String loser, int startCards, int numPlays)
	{
		System.out.println("Battle Card Game Summary");
		System.out.println("========================");
		System.out.println("The game was started with " + startCards + " cards.");
		System.out.println("There were " + numPlays + " plays in the game.");
		
		//check to see if tie
		if (winner.compareToIgnoreCase(loser) != 0)
		{
			System.out.println("The game ended with a clear winner.");
			System.out.println(loser + " ended with 0 cards.");
			System.out.println(winner + " ended with " + startCards + " cards.");
			System.out.println("The winner was " + winner + ".");
		}//if
		else
			System.out.println("The game ended in a tie.");
	}//printResults
}//BattleDemoAnderson
