/*
 * Name:Ahmed Osman
 *
 * Course: CS-12 Spring 2020
 *
 * Date: 02/01/2020
 *
 * Filename: HelloWorldAO.java
 *
 * Purpose: Simple Hello World Java application to test the language
 */

public class HelloWorldAO {

   public static void main(String [] args) {
   
      printGreeting ("Ahmed","Osman");
   }
   
   private static void printGreeting(String firstName, String lastName) {
     
      System.out.println("Hello " + firstName + 
                           
                                      " " + lastName +
                            
                             ", good to have you in class");
                             
                             
                             
     }
}