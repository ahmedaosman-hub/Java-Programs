/*
 * Name:Ahmed Osman
 *
 * Course: CS-12 Spring 2020
 *
 * Date: 02/09/2020
 *
 * Filename: HelloAO.java
 *
 * Purpose: Utility class component for Hello World
 */
 
 public class HelloAO {
 
    // instance variables: what the class is 
    private String firstName;
    private String lastName;
   
    // constructor: initalizes the class 
    public HelloAO () {
       firstName = " Anonymous";
       lastName = "Student";
   }
   
    // methods: what a class does
   
    // print a greeting given first and last names 
    public void printGreeting () {
      System.out.println("Hello" + firstName + 
                         " " + lastName + 
                         ", good to have you in class.");
   }
   
    // update the first name
    public void setFirstName (String first) {
      firstName= first;
   }
   
    // update the last name
    public void setLastName (String last) {
      lastName= last;
   }
    
}