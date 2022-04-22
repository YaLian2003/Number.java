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
