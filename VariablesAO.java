/*
 * Name:       Ahmed Osman
 *
 * Course:     CS-12, Spring 2020
 *
 * Date:       02/23/20
 *
 * Filename:   VariablesAO.java
 * 
 * Purpose:    practice setting up and displaying Java variables
 */
 
public class VariablesAO {
    
   public static void main(String [] args) {
    
      // declarations and initializations
      int        valueDozen = 12;
      boolean    tabLights = true;
      int        zip_Code = 95747;
      double     deskCost = 15.99;
      int        itemStock = 42;
      double     jonesClose = 29398.08F;
      double     taxRate = 0.0725;
      char       mathGrade = 'B'; 
      String     data = "Shawn Morgan O'Shea";
      long       book_ISBN = 1234567890123L;
      double     rainFall = 0.15;
       
      // problem 1:  compute the value of a dozen
      System.out.println("1) the value of a dozen is: \t\t\t" + valueDozen);
    
      // problem 2:  compute if the tab lights are on
      System.out.println("2) are the tab lights on: \t\t\t\t" + tabLights);
     
      // problem 3:  compute what the delivery zip code is
      System.out.println("3) delivery zip code is: \t\t\t\t"  + zip_Code);
      
      // problem 4:  compute how much is the desk organizer
      System.out.println("4) Target desk organizer costs:\t\t\t"+ deskCost);
      
      // problem 5:  compute the amount of items in stock
      System.out.println("5) items in stock: \t\t\t\t\t\t" + itemStock);
     
      // problem 6:  compute the recent dow jones close
      System.out.println("6) recent Dow Jones close: \t\t\t\t" + jonesClose);
     
      // problem 7:  compute the tax rate of rocklin 
      System.out.println("7) City of Rocklin Tax Rate: \t\t\t" + taxRate);
     
      // problem 8:  compute the student's math grade
      System.out.println("8) Student's math grade: \t\t\t\t" + mathGrade);
     
      // problem 9:  compute the students full name
      System.out.println("9) Student's full name: \t\t\t\tShawn Morgan O'Shea");
     
      // problem 10: compute the book's ISBN code
      System.out.println("10) Amazon book ISBN-13:\t\t\t\t" + book_ISBN);
     
      // problem 11: compute the amount of rainfall in 24 hours
      System.out.println("11) 24hr rainfall amount: \t\t\t\t" + rainFall);
  
    }
    
}