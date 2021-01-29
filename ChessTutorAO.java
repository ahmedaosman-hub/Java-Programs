/*
 * Name:       Ahmed Osman
 *
 * Course:     CS-12, Spring 2020
 *
 * Date:       04/18/2020
 *
 * Filename:   ChessTutorAO.java
 * 
 * Purpose:    To use UtilsAO and create a logic program to solve the chess tutor earnings. 
 *             This will also have the ability to display daily earnings, total earnings, and history of the earnings.
 */
public class ChessTutorAO {
    // Main method will display the menu to later call upon
    public static void main (String [] args) {
    
        String menu =   "-----------------------------\n"       +
                        "Chess Tutoring Income Options\n"       +
                        "-----------------------------\n"       +
                        "Daily earnings on Day N         [D]\n" +
                        "Total earnings up to Day N      [T]\n" +
                        "History of earnings up to Day N [H]\n" +
                        "Quit                            [Q]\n" +
                        "Enter option: ";
                        
        // Calls the menu and records the user's input as option
        char option = UtilsAO.readChar(menu, false);
        
        // Connects the cases with the method's used. Having lower case and upper case will prevent an error if the user inputs in any form
        boolean exit = false;
        
        while (!exit) {
            switch (option) {
                // Daily Earnings Case
                case 'd': 
                case 'D': 
                showDailyEarnings();
                break;
                
                // Total Earnings Case
                case 't': 
                case 'T':
                showTotalEarnings();
                break;
                
                // History Earnings Case   
                case 'h': 
                case 'H':
                showHistoryEarnings();
                break;
                
                // Added feature to allow the user to quit application    
                case 'q': 
                case 'Q': 
                exit = true;
                break;
                
                // This will re-ask in case user does not place a familiar option
                default:
                System.out.println("Unrecognized Option " + option + ", please try again");
            }
        }
    }
    // Uses exponents to solve how much money is made for the inputted day
    public static void showDailyEarnings() {
        int day = getValidDay() ;
        double earning = Math.pow(2, day -1);
        //present the user with the daily earning of the inputted day
        System.out.printf("==> Daily earnings on Day %d will be: $%,.2f\n", day, earning/ 100);
 
    }
    // Calculates how much money is days leading to the inputted day
    public static void showTotalEarnings() {
        // set up data and objects
        int day = getValidDay();
        double earnings, totalEarnings = 0; 
        // Will create a loop to record all the days up to the user's inputted day, and then add them together 
        for (int i = 1; i <= day; i++) {
            earnings = Math.pow(2, i -1);
            totalEarnings += earnings; 
        }   // will present the total earnings to the user up to the inputted day
            System.out.printf("==> Total earnings thru Day %d will be: $%,.2f\n", day, totalEarnings/100);
    }
    // Shows how much money is made leading to the inputted day    
    public static void showHistoryEarnings() {
        // set up data and objects
        boolean MILLIONAIRE = false, BILLIONAIRE = false;
        int day = getValidDay();
        double earnings, totalEarnings = 0;
       
        System.out.println(" Day            Daily Earnings [$]            Total Earnings [$]");
        // a repeat of the previous method but will display the day the user gained a million 
        for (int i = 1; i <= day; i++) { // will calculate and add the totals 
            earnings = Math.pow(2, i -1);
            totalEarnings += earnings; 
            System.out.printf("%4d%,30.2f%,30.2f",i,earnings/100,totalEarnings/100);
            if ( !MILLIONAIRE && totalEarnings >= 100000000) { // if more then a million it will display 
        	    System.out.println(" <=== DAY " + i + ": I'M A MILLIONARE!!!");
        	    MILLIONAIRE = true;
            }
            else if (!BILLIONAIRE && totalEarnings >= 100000000000.0 ){ // will display when the user will make a billion
        	    System.out.println(" <=== DAY " + i + ": I'M A BILLIONARE!!!");
        	    BILLIONAIRE = true;                
            }
           else {
                System.out.println(); // if user did not get a million or billion we will skip a line
           }
        }
    }   
    // Allows an inputted day between 1-64
    public static int getValidDay() {  
        // set up data and objects      
        final int DAYS_UPPER_LIMIT = 64;		
        int day;
        // will receive the user's input 
        day = UtilsAO.readInt("Enter a chess teaching day [1-"+ 
                   DAYS_UPPER_LIMIT + "] > ", false);
        while ((day < 1) || (day > DAYS_UPPER_LIMIT )) { // will consistently loop until user inputs a proper number 
            System.out.println("ERROR: day must be 1-"+ 
                   DAYS_UPPER_LIMIT + ", please re-enter"); // if user does not input a number between 1-64, this will tell them to re-enter
             day = UtilsAO.readInt("Enter a chess teaching day [1-"+ 
                   DAYS_UPPER_LIMIT + "] > ", false);
        }
        return day; // returns the variable so we can use for other methods
    }

}
