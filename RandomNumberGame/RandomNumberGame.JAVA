import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HelpWithJava {

		public static int getRandomNumber(int min, int max) {
		    Random r = new Random();
		    return r.nextInt((max - min) + 1) + min;
		}
	public static boolean IsInputInteger(String x) {
		try {
			Integer.parseInt(x);
			return true;
		}catch(NumberFormatException ex) {
           return false;
		}
	}
	public static int IsGuessCorrect(String s, int x) {
		
		int d = Integer.parseInt(s);

		if (x == d) 
		{
			return x;		
		}
		else if (x < d)  {
			
			return d;
		}
		else if (x > d) {
			
			return d;	
		}
		return 0;
		
	}
	public static int GuessAgain(int RandomNumber) {
		
		
		System.out.println("please enter an integer guess");
		//look at this again
		Scanner Userinput = new Scanner(System.in);
		
		String UserGuess = Userinput.next();
		
		boolean check;
		
		check = IsInputInteger(UserGuess);
		
		if (check == true) {
		}
		else{
			System.out.println("The input is not an integer");
		}
		int check2;
		check2 = IsGuessCorrect(UserGuess,RandomNumber);
		return check2;
	}
		public static void main(String[] args) {
			
			String repeat = "yes";
			
			do
			{
				
			int RandomNumber;
			int mi,ma;
			System.out.println("Please Enter the range in which you would want the random number to be)");
			Scanner minimum = new Scanner(System.in);
			mi = minimum.nextInt();
			Scanner maximum = new Scanner(System.in);
			ma = maximum.nextInt();
			
			RandomNumber = getRandomNumber(mi,ma);
			
			System.out.println(RandomNumber);
			
			System.out.println("please enter an integer guess");
			//look at this again
			Scanner Userinput = new Scanner(System.in);
			
			String UserGuess = Userinput.next();
			
			boolean check;
			
			check = IsInputInteger(UserGuess);
			
			if (check == true) {
				
				System.out.println("The input is an integer");
				
			}
			else{
				
				System.out.println("The input is not an integer");
				
			}
			
			List<Integer> Guesses = new ArrayList<Integer>();
			
			int check2;
			check2 = IsGuessCorrect(UserGuess,RandomNumber);
			Guesses.add(check2);
			
			
			for (int i = 0; check2 != RandomNumber; i++) {
					
				if(check2 > RandomNumber) {
					System.out.println("Guess Is Too High, Guess Again");
					check2 = GuessAgain(RandomNumber);
					Guesses.add(check2);
					
				}
			else if (check2 < RandomNumber) {
					
					System.out.println("Guess Is Too Low");
					check2 = GuessAgain(RandomNumber);
					Guesses.add(check2);
				}
				
			}
			if (check2 == RandomNumber) {
				
				System.out.println("Guess Is Correct");
			}
			
			System.out.println("Number of incorrect guesses are ");
			int size;
			size = Guesses.size();
			System.out.println(size-1);
			
			
			if ((size-1) == 0) {
				
				System.out.println("There are no incorrect guesses");
				
			}
			else {
			
			System.out.println("The incorrect guesses are ");
			Guesses.remove(size-1);
			for(int i =0; i < Guesses.size(); i++) {
	            System.out.println(Guesses.get(i));
	        }
			}
			
			System.out.println("would you like to play again?");
			System.out.println("please type yes if you would like to");
			System.out.println("Please type no if you would not like to");
			
			Scanner answer = new Scanner(System.in);
			repeat = answer.next();
			
			
			
			}while(repeat.equals("yes"));

			System.out.println("Thanks for playing, Have a Nice day");
			
			
			}
			
		}