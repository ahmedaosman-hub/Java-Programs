/*
 * Name:       Ahmed Osman
 *
 * Course:     CS-12, Spring 2020
 *
 * Date:       03/08/20
 *
 * Filename:   CS12DateClientAO.java
 * 
 * Purpose:  Experiment using the API methods of java class, CS12Date.
 */

import java.util.Scanner; 
public class CS12DateClientAO {
    
    public static void main(String [] args) {
    
       int month; 
       int day;
       int year;
       
       CS12Date today = new CS12Date(); 
       CS12Date halloween = new CS12Date(10, 31, 2020);
       CS12Date myBday = new CS12Date(11, 01);
       CS12Date christmas  = new CS12Date();
      
       Scanner input  = new Scanner(System.in);
          
       System.out.println("1a) today explicitly using toString " + today.toString());
       System.out.println("1b) today implicitly using object name " + today);
       System.out.println();
       
       today.print("2) This is default constructor date of today");
       System.out.println();
       
       halloween.print("3) Halloween using m-d-y constructor ");
       System.out.println();
       
       myBday.print("4) Imaginary birthday using m-d constructor");
       System.out.println();
       
       christmas.setDate(300);
       System.out.println("5) Christmas using default constructor THEN setDate(): " + christmas);
       System.out.println();
       
       myBday.nextDate();
       myBday.nextDate();
       myBday.nextDate();
       System.out.println("6a) 3 days later using nextDate(): " + myBday);
       myBday.laterDate(7);
       System.out.println("6b) 1 week later using laterDate(): " + myBday);
       System.out.println();
       
       System.out.print("This year's birthday month? > ");
       month = input.nextInt();
       
       System.out.print("This year's birthday day > ");
       day = input.nextInt();
       
       System.out.print("This year's birthday year > ");
       year = input.nextInt();
       
       myBday.setMonth(month);
       myBday.setDay(day);
       myBday.setYear(year);
       
       myBday.print("7) This year's birthday using mutators is/was: ");
       myBday.getDateNum();
       System.out.println();
       
       System.out.println("8) This year's birthday " + myBday + " is/was day #: " + myBday.getDateNum() );
       System.out.println();
       
       System.out.println("9) Is today " + today + " my birthday " + myBday + "? " + myBday.equals(today) );
       System.out.println();
       
       System.out.println("10a) compare today to my birthday: " + today.compare(myBday) );
       System.out.println("10b) compare my birthday to today: " + myBday.compare(today) );
       System.out.println("10c) compare today to today: " + today.compare(today) );
       System.out.println();
       
       day = 0;
       month = 0;
       year = 0;
       System.out.println("11) This year's birthday with dashes is still: " + myBday.getMonth() + "-" + myBday.getDay() + "-" + myBday.getYear() );
       
     }
}