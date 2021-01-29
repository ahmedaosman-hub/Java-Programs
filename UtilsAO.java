/*
 * Name:     Ahmed Osman    
 *
 * Course:   CS 12
 *
 * Date:     04/04/2020
 *
 * Filename: UtilsAO.java
 *
 * Purpose:  A static utilities class that is a collection of useful utility methods.
 *           Must have CS12Date file in local directory.
 *            
 */
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Random;
  
public class UtilsAO {     
  
    // readInt method uses the User's Input and verifies if it is an integer. 
    public static int readInt(String prompt, boolean guiMode) {
        
        // set up data and objects
        Scanner input = new Scanner(System.in);
        int data = 0;
        String userInput = "", grade;
        boolean failed = true;
        
        // This 'if' uses Scanner to allow user to input an integer
        
        // If user does not input an integer it will repeat the question until they do so 
        if (guiMode == false) {  //this will allow the scanner
            System.out.print(prompt);
            while(!input.hasNextInt()) { // repeats the loop until the user has declared a input
                grade = input.nextLine();
                System.out.print(prompt);
            }
            data = input.nextInt();
        }
        
        // This verifies the user's integer using the JOptionPane and will repeat the question if input is not an integer
        else {
            while (failed == true) {
                try { //attempts to convert the input into an integer 
                    userInput = JOptionPane.showInputDialog(null, prompt);
                    data = Integer.parseInt(userInput);
                    failed = false;
                } 
                
                // in case the try has an error this will execute
                catch(NumberFormatException nfe) {
                }            
            }
        }
  		return data; // Returns the input
    }   
   
    // readDouble() method 
    public static double readDouble(String prompt, boolean guiMode) {
        
        // set up data and objects
        Scanner input = new Scanner(System.in);
        double data = 0;
        String userInput = "", grade;
        boolean failed = true;
        
        // This 'if' uses Scanner to allow user to input an integer
        
        // If user does not input an integer it will repeat the question until they do so 
        if (guiMode == false) {  //this will allow the scanner
            System.out.print(prompt);
            while(!input.hasNextInt()) { // repeats the loop until the user has declared a input
                grade = input.nextLine();
                System.out.print(prompt);
            }
            data = input.nextInt();
        }
        
        // This verifies the user's integer using the JOptionPane will also repeat the question if input is not an integer
        else {
            while (failed == true) {
                try { //attempts to convert the input into an integer 
                    userInput = JOptionPane.showInputDialog(null, prompt);
                    data = Integer.parseInt(userInput);
                    failed = false;
                } 
                
                // in case the try has an error this will execute
                catch(NumberFormatException nfe) {
                }            
            }
        }
  		return data; // Returns the input
    }
    
    //readChar() method is a clone of readInt() but reads a single char input
    public static char readChar(String prompt, boolean guiMode) {
        
        // set up data and objects
        Scanner input;
        char data;
        String userInput=null;
        
        //Uses the scanner to accept the user's inputted char
        if (guiMode == false) {
           input = new Scanner(System.in);		
           
           System.out.print(prompt);		
           data = input.next().charAt(0);
        }
        
        // Uses the JOptionPane to accept the user's inputted char
        else {	
            userInput = JOptionPane.showInputDialog(prompt);
            data = userInput.charAt(0);					
        }
        return data; // returns the input
    }
    
    // readString () method
    public static String readString(String prompt, boolean guiMode) {
       
        // set up data and objects
        Scanner input;
        String data;
        String userInput=null;
        
        //Uses the scanner to accept the user's inputted char
        if (guiMode == false) {
           input = new Scanner(System.in);		
           
           System.out.print(prompt);		
           data = input.next();
        }
       
        // Uses the JOptionPane to accept the user's inputted char
        else {	
            userInput = JOptionPane.showInputDialog(prompt);
            data = userInput;					
        }
        return data; // returns the input
    }
  
    // randomInt() method allows us to choose a random number in between a minimum and maximum value
    public static int randomInt(int minValue, int maxValue){
        //Set up data and objects
        Random rand = new Random();
        int randNum;
        
        // Sets a random number as the randNum variable
        randNum = rand.nextInt((maxValue - minValue) + 1) + minValue;
        
        // returns the random number
        return randNum;      
    }

    // getAge method uses the User's inputted dates to calculate birthdays. 
    public static int getAge(CS12Date dateBd, CS12Date dateRef) {
        int age = -1; // starting default output

        int dateBdM = dateBd.getMonth();
        int dateBdD = dateBd.getDay();
        int dateBdY = dateBd.getYear();
        int dateRefM = dateRef.getMonth();
        int dateRefD = dateRef.getDay();
        int dateRefY = dateRef.getYear();
             
        // case 1: check for future birth years.
        if (dateBdY > dateRefY) { 
            System.out.println("ERROR: provided birthdate " + dateBd + " is after current date " + dateRef);
            age = -1;
        }
                
        // case 2: check for future birth months in the same year.
        else if ((dateBdM > dateRefM) && (dateBdY == dateRefY)) {
            System.out.println("ERROR: provided birthdate " + dateBd + " is after current date " + dateRef);
            age = -1;
        }
        
        // case 3: check for future birth days in the same month and year. 
        else if ((dateBdD > dateRefD) && (dateBdM == dateRefM) && (dateBdY == dateRefY)) {
            System.out.println("ERROR: provided birthdate " + dateBd + " is after current date " + dateRef);
            age = -1;   
        }
                
        // if we get this far, person has been "born" and has a BD within 12 month year
                
        // case 4: check for birthdays in future months. 
        else if (dateBdM > dateRefM)  {
           	age = (dateRefY - dateBdY) - 1;
            
        }
        // case 5: check for birthdays in future day.
        else if ((dateBdD > dateRefD) && (dateBdM == dateRefM)) {
            age = (dateRefY - dateBdY) - 1;
        }
            
         // case 6: all other birthdays
        else {
           age = dateRefY - dateBdY;
           
        }
        // return ONE common age here, not multiple return statements above!
        return age;
    }
    // end 2-input overloaded version
    
    //---------------------------------------------------------------------------

    // returns the age as of TODAY'S date (1-input overloaded form, NO CHANGES NEEDED, DO NOT EDIT)
    public static int getAge(CS12Date dateBd) {
        int age;
        CS12Date dateToday = today();
        
        // calls overloaded version of above method, using TODAY as the reference date
        age = getAge(dateBd, dateToday);  
        return age;
    } // end 1-input overloaded version
    
    //---------------------------------------------------------------------------
    // date-related methods 
    //---------------------------------------------------------------------------
    
    // returns today's date as a CS12Date
    public static CS12Date today() {
    
        // simply return a default date, which is today
        return new CS12Date();
        
    }
      // pauses execution until any key is pressed, specific prompt
   private static void pause(String message) {
      // ignores any returned value
      readString(message);    // update with own Utils version if desired, but add boolean input
      System.out.println();   // add a blank line
   }
    
   // pauses execution until any key is pressed, generic prompt
   public static void pause() {
      pause("Press <Enter> to continue... ");
   }
    
   // get a String value (standalone, cmd-line only version)
   // update with own Utils version if desired, but add boolean input in above method call
   private static String readString(String prompt) {
    
      // set up data and objects
      String data;
      Scanner input = new Scanner(System.in);

      System.out.print(prompt);
      data = input.nextLine();
      
      return data;
   }
}
   
    
   
