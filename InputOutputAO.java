/*
 * Name:       Ahmed Osman
 *
 * Course:     CS-12, Spring 2020
 *
 * Date:       03/21/2020
 *
 * Filename:   InputOutputAO.java
 * 
 * Purpose:    To work with several input-output related Java classes to perform command line and GUI popups. 
 */

import java.util.Scanner;

import javax.swing.JOptionPane;

public class InputOutputAO {
  
    public static void main(String [] args) {
      
        int wins;
        int losses;
        String teamName;
        double winRatio;
        int votesReceived;
        int votesCast;
        double percentageVote; 
        String outStr;
        String percentageVoteFormat;
    
    
        Scanner input = new Scanner(System.in);

        //Problem 1: Allows a user to input a sports team's name, wins, and losses to calculate a winning ratio. 
        System.out.print("Enter team name: ");
        teamName = input.nextLine();
    
        System.out.print("Enter games won: ");
        wins = input.nextInt();
    
        System.out.print("Enter games lost: ");
        losses = input.nextInt();
        
        winRatio = (double) wins / losses; 
        System.out.printf("1) Winning ratio for %s this season is: %.3f \n\n", teamName, winRatio );    
        
        //Problem 2: A prompt to calculate and display the percentage of the support by using the votes received and casted. 
        votesReceived = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of voters recieved:"));
        votesCast = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of votes cast:"));
        percentageVoteFormat = " Votes received: %d \n Votes Cast: %d \n Percentage of support:  %10.2f%% ";
        
        percentageVote = (double) votesReceived / votesCast * 100;
        outStr = String.format(percentageVoteFormat, votesReceived, votesCast, percentageVote);
        JOptionPane.showMessageDialog(null, outStr);
    
        //Problem 3: A redisplay of the results of 1 and 2 but with a fixed text label.
        System.out.printf(" 3a) %10s %50f \n ", "Team winning ratio:  ", winRatio);
        System.out.printf("3b) %10s %50f","Percentage of support: ", percentageVote);
   } // end main
} // end class
