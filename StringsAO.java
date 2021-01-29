/*
 * Name:       Ahmed Osman
 *
 * Course:     CS-12, Spring 2020
 *
 * Date:       03/15/2020
 *
 * Filename:   StringsAO.java
 * 
 * Purpose:  
 */     
import java.util.Scanner;

public class StringsAO {
    
    public static void main(String [] args) {
      
       char sep = ' ';
       int p1, p2, p3, p4; 
       int userInput;
       
       String subStr;
       String trimmed;
      
       Scanner scanner = new Scanner (System.in);
       System.out.print("Enter desired string: " );
       String myStr = scanner.nextLine();
      
      
       
       
       System.out.println("1) myStr is:\t" + myStr);
       System.out.println();
       
       System.out.println("2) length of myStr:\t\t" + myStr.length());     
       System.out.println("3) first and last chars of myStr are:\t\t" + myStr.charAt(0) + " and " + myStr.charAt( myStr.length() - 1));       
       System.out.println();
       
       System.out.println("4a) myStr as all caps:\t\t" + myStr.toUpperCase());
       System.out.println("4b) myStr is unchanged:\t\t" + myStr);
       System.out.println("5a) myStr as lower case:\t" + myStr.toLowerCase());
       System.out.println("5b) myStr is unchanged:\t\t" + myStr);
       System.out.println();
          
       System.out.print("Character at which index? > ");
       userInput = scanner.nextInt();
       System.out.println("6) char at index " + userInput + ": \t\t\t\t" + myStr.charAt(userInput));
       System.out.println();
      
       scanner.nextLine();
       System.out.print("Search string to locate? > ");
       String userAnswer = scanner.nextLine();
       
       System.out.println("7) substring can is located at index: " + myStr.indexOf(userAnswer));
       System.out.println("8) desired substring is:\t\t\t\t" + myStr.substring(myStr.indexOf(userAnswer)));
       System.out.println();
       
       
       p1 = myStr.indexOf(",");
       System.out.println("9) first comma is at index: \t " + p1);
       
       p2 = myStr.indexOf(",", p1+1);            
       System.out.println("10) second comma is at index: \t" + p2);
       
       p3 = myStr.indexOf(",", p2+1);
       System.out.println("11) third comma is at index:\t" + p3);
       System.out.println();
                        
       subStr= myStr.substring(p2, p3);   
       System.out.print("12) between commas 2 and 3 is: " + subStr);
       System.out.println("  length = " + subStr.length()); 
       
       trimmed = subStr.trim();                   
       System.out.print("13) between commas 2 and 3 is: " + trimmed);
       System.out.println(" length = " + trimmed.length());
       }
}