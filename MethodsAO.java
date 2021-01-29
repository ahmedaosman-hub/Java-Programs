 /*
 * Name:       Ahmed Osman
 *
 * Course:     CS-12, Spring 2020
 *
 * Date:       03/02/2020
 *
 * Filename:   MethodsAO
 *
 * Purpose:    Writing simple Java methods to produce two outputs for Temperature Conversion and Currency Conversion
 */

import java.util.Scanner;

public class MethodsAO {
    
    // data variables
    double fTemp;
    double cTemp;
    double dollars;
    double euros; 
    
    // required main method of the class
    public static void main(String [] args) {
    double fTemp = obtainDouble("Enter temperature in deg F > ");
    double cTemp = convertTemp(fTemp);            
    createBox(fTemp + " deg F is equal to " + cTemp + " deg C");
    
    double dollars = obtainDouble("Enter number of dollars to > ");
    double euros = calculateCurrency(dollars);
    createBox("$" + dollars + " is equal to " + euros + " Euros");
                        
    } // end main
    // (1) create a method to allow the user to obtain a double using the scanner
    public static double obtainDouble (String prompt) {      
    System.out.print(prompt);
    Scanner input = new Scanner (System.in);
    return input.nextDouble();
    }
    // (2) create a method to show an input string in a box
    public static void createBox (String box) {
    System.out.println("==========================");
    System.out.println(box);
    System.out.println("==========================");
    }
    // (3) create a method to convert from farenheit to celsius 
    public static double convertTemp (double fTemp) {
    double cTemp = (double) 5/9 * (fTemp - 32);
    return cTemp;
    } 
    // (4) create a method to convert USD into Euros 
    // Euros = Conv. Rate * Dollars
    public static double calculateCurrency (double dollars) {
    double CONV_RATE = .923127; 
    double euros = dollars * CONV_RATE;  
    return euros;
    }
}