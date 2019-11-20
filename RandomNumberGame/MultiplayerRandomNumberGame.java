import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;




public class Multplayer {

	
	public static int PlayerNumbers() {
		int NumberofPlayers = 0;
		boolean check;
		do {
			Scanner input = new Scanner(System.in);
			try {
				
				NumberofPlayers = input.nextInt();
				check = false;
			}catch(Exception e) {
				
				System.out.println("Input invalid, please enter an integer");
				check = true;
				
				
			}
		}while(check == true);
		return NumberofPlayers;
		
	}
	
	public static boolean checkifInt(String x) {
		
		int y;
		
		try {
			y = Integer.parseInt(x);
			return true;
		}catch(NumberFormatException ex) {
            return false;
		}
		
		
		
		
	}
	
	public static String GetPlayerNames() {
		
		
		
		String name;
		Scanner input = new Scanner(System.in);
		name = input.next();
		return name;
		
			
	}
	
	public static int getRandomNumber(int min, int max) {
	    Random r = new Random();
	    return r.nextInt((max - min) + 1) + min;
	}
	
	public static String GetGuess(String x) {
		
		String guess = null;
		System.out.println(x + " please enter your guess ");
		Scanner input = new Scanner(System.in);
		guess = input.next();
		
		if (checkifInt(guess)) {
			guess = input.next();
			
			return guess;
			
		}else {
			
			
			System.out.println("please enter a integers");
		}
		
		 
		
		
		return null;
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		System.out.println("Welcome Players to the Random Number Game");;
		System.out.println("Please enter the number of players you would like to play with");
		
		int Players = PlayerNumbers();
		
		System.out.println("There are going to be " + Players + " number of players"  );
		System.out.println("Please enter your names ");
		
		List<String> PlayerNames = new ArrayList<String>();
		String name;
		
		for(int i = 0; i < Players; i++ ) {
			
			System.out.println("player " + (i+1) + " please enter your name");
			
			name = GetPlayerNames();
			PlayerNames.add(name);
		}
		Random rand = new Random();
		List<Integer> RandomNumbers = new ArrayList<Integer>();
		
		int RandomNumber;
		int mi,ma;
		System.out.println("Please Enter the range in which you would want the random number to be)");
		Scanner minimum = new Scanner(System.in);
		mi = minimum.nextInt();
		Scanner maximum = new Scanner(System.in);
		ma = maximum.nextInt();
		
		for(int i = 0; i < Players; i++ ) {
			
			RandomNumber = getRandomNumber(mi,ma);
			RandomNumbers.add(RandomNumber);
			System.out.println(RandomNumbers.get(i));
			
		}
		List<Integer> WrongGuesses = new ArrayList<Integer>();
		List<String> Guesses = new ArrayList<String>();
		
		
		String guess;
		
		for(int i = 0; i < Players; i++ ) {
			
			  guess = GetGuess(PlayerNames.get(i));
			  Guesses.add(guess);
			  
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
	}

}