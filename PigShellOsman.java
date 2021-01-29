 /*
 * Name:       Ahmed Osman
 *
 * Course:     CS-13,Fall 2020
 *
 * Date:       08/10/2020
 *
 * Filename:   PigShellOsman.java
 * 
 * Purpose:    To create a dice game called Pig. Pig requires a computer and a player 
 *             to each take turns rolling a dice to 30 points.
 */                 
import java.util.*; 
public class PigShellOsman {
  /*This method displays the instructions to play the game.*/
   public static void description()
   {
   System.out.printf("Welcome to the game of Pig!%nBoth players start off with zero points. %nComputer roll the dice three times in a row, the sum of the dice will be players point %n Player will be prompted to enter a key or enter 'end' %n Everytime the player enters a key a dice will be rolled %n If the dice is a 1, the player will lose all the points and player's turn is over %n As long as the player's dice isn't a one, player will keep playing%n Then computer turn begins %n Player and the computer take turn playing %n The first player to reach 30 points or more wins. %n%n");
      
   }
   public static void main(String[] args){
      description();
      play();
        
  
   }
   public static void play()
   {  
      Random rand = new Random();
      Scanner scan = new Scanner(System.in);
   
      boolean flag = true;  //a flag to end the game
      int compScore = 0;    //computer total score
      int playerScore = 0;// player total score
      int compToss = 0;   //holds the sum of the three dice rolled
      int playerToss = 0;//hold the value of the rolled dice for the player
      int pRound = 0;    //number of the round player won
      int cRound = 0;    //number of the round computer won
       
      while(flag){
         //reset all the variables to zero for a new round of the game
         compScore = 0;
         playerScore = 0;
         compToss = 0;
         playerToss = 0;
          
         //loop until either the computer wins or the palyer wins
         while(!(compScore >= 30 || playerScore >= 30)){
              // generate three random numbers 1-6
              int a = rand.nextInt(6) + 1;
              int b = rand.nextInt(6) + 1;
              int c = rand.nextInt(6) + 1;
              
              
           
              //add the random numbers to the computer total points
              compScore += a + b + c;  
              System.out.println("Computer's Turn");
              System.out.println("Computer rolled: " + a + ", " + b + ", " + c);
              System.out.println("Computer score is now: "+ compScore);
              if(compScore >= 30){
            	  break;
              }
              
           
            //roll the dice by generating a random number between 1-6, store it in playerToss
             //playerToss = rand.nextInt(6) + 1;
           
           //loop until the player get a one                   
            while(true){
               //prompt the player to enter a key or enter end
               System.out.printf("Type any key to roll or 'end' to end turn: ");
               String end = scan.next();
               
               //if the player enters "end" break ot of the loop
               if (end.equals("end")) {
                 break;
               }
               //else roll the dice, by generating a random number 1-6
               else{
                 playerToss = rand.nextInt(6) + 1;
                 
               }
             
               
             //if the playerToss is one, display a message that you got a 1, and your turn is over 
               if (playerToss == 1){
                 System.out.printf("Player got a one. Score reset to 0.%nPlayers turn is over.%n");
                 playerScore = 0;
                 break;
               }
               
              //add the playerToss to the playerScore
                playerScore += playerToss; 
              //display the number on the dice
                System.out.printf("Player rolled a %d%n",playerToss);
                //display the player score
                System.out.println("Player Score is now: "+ playerScore);
              //check to see if the playerScore is gretaer than 30, if so  break out of the loop
                if (playerScore >= 30){
                  break;
                }
              
            }
                           
                
         }
         //check to see who was the winner 
         if(compScore > playerScore){
            System.out.println("Computer is the winner!");
            cRound++;
         }else{
            System.out.println("Player is the winner!");
            pRound++;
         }
         //ask if player wants to play another round
         System.out.println("Do you want to play another round?");
         String answer = scan.next();
         if(answer.equalsIgnoreCase("no"))
            flag = false;
      }
      //display the final score
      System.out.println("---- Final Score ----");
      System.out.println("Computer:  " + cRound + "   Player:  " + pRound);
   }
}


