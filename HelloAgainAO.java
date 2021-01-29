/*
 * Name:Ahmed Osman
 *
 * Course: CS-12 Spring 2020
 *
 * Date: 02/09/2020
 *
 * Filename: HelloAgainAO.java
 *
 * Purpose: Refactored Hello World Java application, now uses a utility class
 */

public class HelloAgainAO {

    public static void main(String [] args) {
    
       // create a new object, one specific instance of the class
       HelloAO person = new HelloAO ();
    
       // print greeting for the default person
       person.printGreeting();
     
       // update the object, and print the new greeting
       person.setFirstName (" Ahmed");
       person.setLastName ("Osman");
       person.printGreeting();
      
  
   }
     
}