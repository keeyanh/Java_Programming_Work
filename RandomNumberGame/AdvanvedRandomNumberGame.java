import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Project {

	static boolean[] correct;
	static boolean allCorrect;
	static ArrayList<Integer>[] incorrectGuesses;
	static int[] RandomNumberArray;
	static int[] numGuesses;
	
	
	public static String IsInputInt(String x) {
		
		 try
		    {
		        Integer.parseInt(x);
		        String a;
		        a = " ";
		        return a;
		        
		    } catch (NumberFormatException ex)
		    {
		    	String b;
		    	b = "Input Is invalid";		
		        return b;
		    }
		}
		
	public static int getRandomNumber(int min, int max) {
	    Random r = new Random();
	    return r.nextInt((max - min) + 1) + min;
	}
	
	
public static void playRound(int PlayerNumber) {
		
		System.out.println("Player " + (PlayerNumber+1) + " Please enter a guess)");
		
		Scanner Userinput = new Scanner(System.in);
		int Inp = Userinput.nextInt();
		int x;
		x = IsGuessCorrect(PlayerNumber, Inp, RandomNumberArray[PlayerNumber]);
		
		
		if(x == 1){
			correct[PlayerNumber] = true;
			System.out.println("Input Is Correct");
		}else if (x == 2) {
			
			String a = "Input Is Too Low";
			System.out.println(a);
			
			
			
		}else if(x == 3) {
			
			String b = "Input Is Too High";
			System.out.println(b);	
		}
	}
	
	public static int IsGuessCorrect(int NumberOfPlayer, int user, int randNum) {
		
		numGuesses[NumberOfPlayer]++;
		
		
		if(user == randNum) {
			return 1;
		}else if(user < randNum) {
			incorrectGuesses[NumberOfPlayer].add(user);
			return 2;
		}else {
			incorrectGuesses[NumberOfPlayer].add(user);
			return 3;
		
		}

	}


	 public static int findIndex(int arr[], int t) 
	    { 
	  
	        int index = Arrays.binarySearch(arr, t); 
	        return (index < 0) ? 1 : index+1; 
	        
	        
	        
	        
	        
	    } 
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
		String repeat = "yes";
		
		do
		{
		
		
		
		
		System.out.println("Hello and welcome to the random number game");
		System.out.println("Please enter the number of players you would like to play with");
		
		
		Scanner Input = new Scanner(System.in);
		String TestNumberofPlayers = Input.next();
		
		String y;
		
		y = IsInputInt(TestNumberofPlayers);
		
		System.out.println(y);
		
		int NumberOfPlayers = Integer.parseInt(TestNumberofPlayers); 
		int RandomNumber;
		int mi,ma;
		   
		
		correct = new boolean[NumberOfPlayers];
		allCorrect = false;
		RandomNumberArray = new int[NumberOfPlayers];
		numGuesses = new int[NumberOfPlayers];
		incorrectGuesses = new ArrayList[NumberOfPlayers];
		
		for (int i =0; i < NumberOfPlayers; i++ ) {
			
			System.out.println("Player " + (i+1)+ " Please Enter the range in which you would want the random number to be)");
			Scanner minimum = new Scanner(System.in);
			mi = minimum.nextInt();
			Scanner maximum = new Scanner(System.in);
			ma = maximum.nextInt();
			correct[i] = false;
			RandomNumber = getRandomNumber(mi,ma);
			RandomNumberArray[i]=RandomNumber;
			numGuesses[i] = 0;
			incorrectGuesses[i] = new ArrayList<Integer>();
			
		}
		
		
		for (int i =0; i < NumberOfPlayers; i++ ) {
			System.out.println(RandomNumberArray[i]);
		}
	
		
		int CurrentTurn = 0;
		
		while(!allCorrect) { 
			
		
			
			if(correct[CurrentTurn]) {
				if(CurrentTurn == NumberOfPlayers-1) {
					CurrentTurn = 0;
				}else {
					CurrentTurn++;
				}
				continue;
			}
			
			playRound(CurrentTurn);
			
			for(int i = 0; i< NumberOfPlayers; i++) {
				if (correct[i] == true){
					
					
					if(i == NumberOfPlayers-1) { 
						allCorrect=true;
					}
					
					
					
					
					continue;
				}else {
					break;
				}
			}
			
			
			if(CurrentTurn == NumberOfPlayers-1) {
				CurrentTurn = 0;
			}else {
				CurrentTurn++;
			}
			
		}
		
		for(int i = 0; i< NumberOfPlayers; i++) {
			System.out.println("Player: " + (i+1) + " Guesses: " + numGuesses[i]);
			System.out.print("Wrong Guesses: ");

			for(int j = 0; j < incorrectGuesses[i].size(); j++) {
				System.out.print(incorrectGuesses[i].get(j) + " ");
			}
			System.out.println();
				
			}
				
		 boolean check = false;
		  boolean check2 = false;
		  
		  
		int minValue = numGuesses[0];
			for(int i=1;i<numGuesses.length;i++){
			    if(numGuesses[i] < minValue){
				  minValue = numGuesses[i];
				  check = true;
			  }
			}
		int maxValue = numGuesses[0];
				for(int j=1;j < numGuesses.length;j++){
					if(numGuesses[j] > maxValue){
					maxValue = numGuesses[j];
					check2 = true;
							}		  
						}
			 
			  
				  
				  
		 
			 
				 
			  int [] placeValues;
			  placeValues = new int[NumberOfPlayers];
			 
			  int middleValue = numGuesses[0];
			  int middleValue2 = numGuesses[0];
			  
			  for(int j=1;j < numGuesses.length;j++){
				  
				  if (numGuesses[j] < numGuesses[0] && numGuesses[j] > minValue && numGuesses[j] < maxValue) {
					  	middleValue = numGuesses[j];
					  	placeValues[j] = middleValue;
					  	
					  	
				  }
					  	if(middleValue > numGuesses[j-1]) {
					  	middleValue2 = numGuesses[j-1];
					  	placeValues[j-1] = middleValue;
					  	}
					  	else if(numGuesses[j] > numGuesses[0] && numGuesses[j] > minValue && numGuesses[j] < maxValue) {
					  		
					  		middleValue = numGuesses[j];
					  		placeValues[j] = middleValue;
					  		
					  		if(middleValue < numGuesses[j-1]) {
							  	middleValue2 = numGuesses[j-1];
							  	placeValues[j-1] = middleValue2;
							  	}		
			
					  	}
					  
	
			  }
			placeValues[0] = minValue;
			placeValues[placeValues.length-1] = maxValue;  

			boolean check4 = IntStream.of(placeValues).anyMatch(x -> x==0);

			if(check4 == false) {
			
					for(int j=0;j < numGuesses.length;j++){
						System.out.println("Player number " + ((findIndex(numGuesses,placeValues[j])))+ " came in Place#" + (findIndex(placeValues,placeValues[j])) + " with " + placeValues[j] + " guesses" );				
					
					}
				
			}
			

			if(check4 == true) {

				System.out.println("Player number " + ((findIndex(numGuesses,minValue)))+ " got first place with " + minValue + " guesses" );
		
				for (int a = 0; a < numGuesses.length; a++) {
				    for (int k = a + 1; k < numGuesses.length; k++) {
			 	System.out.println("Player number " + ((findIndex(numGuesses,placeValues[k])))+ " has tied with player " + ((findIndex(numGuesses,placeValues[a])) + " and came in Place#" + (findIndex(placeValues,placeValues[a])) + " with " + numGuesses[a] + " guesses" ));
				  break;
				    }
				    break;
				}
				
				
				System.out.println("Player number " + ((findIndex(numGuesses,maxValue)))+ " got last place with " + maxValue + " guesses" );
			}
				
		
			for(int j=0;j < placeValues.length;j++){
				
				System.out.println(placeValues[j]);
				
				
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