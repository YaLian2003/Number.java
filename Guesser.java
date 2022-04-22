//NumberGuesser.java
//Yangyang Lian

public class NumberGuesser {
   //These 2 instance variables will keep track of the original bound values
   private int originalLowerBound;
   private int originalUpperBound;
   //These 2 will keep track of current state
   private int currentLowerBound;
   private int currentUpperBound;
  
   //Constructor
   public NumberGuesser(int lowerBound, int upperBound) {
       this.originalLowerBound = lowerBound;
       this.originalUpperBound = upperBound;
       this.currentLowerBound = lowerBound;
       this.currentUpperBound = upperBound;
   }
  
   //method:higher
   public void higher() {
       //It will set the lower bound to current guess
       this.currentLowerBound = getCurrentGuess();
   }
  
   //method: lower
   public void lower() {
       //it will set the upper bound to the current guess
       this.currentUpperBound = getCurrentGuess();
   }
  
   //the method will generate the current guess
   public int getCurrentGuess() {
       return (this.currentLowerBound+this.currentUpperBound)/2;
   }
  
   //It will reset the current state to the original values
   public void reset() {
       this.currentLowerBound = this.originalLowerBound;
       this.currentUpperBound = this.originalUpperBound;
   }

}

//Guessingprogram.java
import java.util.Scanner;

public class Guessingprogram {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);//create scanner instance
       //Create object of Number Guess with lower and upper bound as 1 and 100 respectively.
       NumberGuesser ng = new NumberGuesser(1,100);
       //start a do-while loop. It will keep track of each number guessing game
       do {
           System.out.print("Think of a number from 1 to 100\n");
           while(true) {//start a inner while loop till the guess is correct
               int guessedNumber = ng.getCurrentGuess();//get current guess
               System.out.print("Is the number "+guessedNumber+"? (h/l/c):");
               String input = sc.next();//get answer from user if the guess is right
               if(input.equals("h"))
                   ng.higher();//if input is h, call higher method
               else if(input.equals("l"))
                   ng.lower();//if input is l, call lower method
               else if(input.equals("c")) {//if it is c, it means guess is correct
                   System.out.println("You picked "+guessedNumber+"? Great pick.");
                   break;//so break out of inner while loop
               }else {//for any other input, it is invalid
                   System.out.println("Invalid input.");
               }
           }
           System.out.print("Do you want to play again: (y/n):");
           String playAgain = sc.next();//check if user wants to play again or not
           if(playAgain.equals("n"))//if not, then break out of the do-while loop
               break;
           else//if want to play again, then rest the current state to original state
               ng.reset();
       }while(true);
       //end message
       System.out.println("Good bye.");
      
   }

}
