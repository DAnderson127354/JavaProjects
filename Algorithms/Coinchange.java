//Danielle Anderson
//12/6/19
//435L-111

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Coinchange {

	public static int greedycoinchange(int givenvalue, int[] givencoins, int numcoins)
	{
		
		// Complete the code here to make change of givenvalue using coins in the array givencoins
		// Minimize the number of coins used
		// Input: Coin denominations in array givencoins are already sorted in descending order
		// Output: The number of coins used to make change of givenvalue

		if (givenvalue != 0)
		{
			if (givencoins[0] <= givenvalue)
				givenvalue -= givencoins[0];
			
			else if (givencoins[1] <= givenvalue)
				givenvalue -= givencoins[1];
			
			else if (givencoins[2] <= givenvalue)
				givenvalue -= givencoins[2];
			
			else
				givenvalue -= givencoins[3];
			
			numcoins++;
			numcoins = greedycoinchange(givenvalue, givencoins, numcoins);
		}

		return numcoins;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 0; // n cents
		int num = 0;
		
		Scanner reader = new Scanner(System.in);  
		
		System.out.println("Please enter the value you want to make change: ");
		
		n = reader.nextInt();
		
		int[] coins = {25, 10, 5, 1};
		
		
		System.out.println("used "+ greedycoinchange(n, coins, num) +" coins for "+ n + " cents");
		
		
		
	}

}

