/*
 * Name:       Ahmed Osman
 *
 * Course:     CS-12, Spring 2020
 *
 * Date:       03/01/20
 *
 * Filename:   ExternalInputAO.java
 * 
 * Purpose:    Update the Operators program and add input prompts using Scanner.
 */
 
import java.util.Scanner;

public class ExternalInputAO {
    
    public static void main(String [] args) {
       
        // all data declarations
        
        // new input object of type Scanner
        Scanner input= new Scanner (System.in);
        
        //input data
        double sandwich;
        double chips;
        double soda;
        double lunchPrice;
        
        int eggs;
        final int ONE_DOZEN = 12;
        int cartons;
        
        final double SALES_TAX_RATE = .0725;
        double price;
        double tax;
        
        final double PI = 3.14;
        double radius;
        double area; 
        
        int bat;
        int atBats;
        double batAverage;
        
        int item1;
        
        int item2;
        int deliveryAmt;
        
        //Sandwich
        System.out.print("Enter sandwich price: ");
        sandwich = input.nextDouble();
        
        //Chips
        System.out.print("Enter chips price: ");
        chips = input.nextDouble();
                
        //Soda
        System.out.print("Enter soda price: ");
        soda = input.nextDouble();
        
        //Eggs
        System.out.print("Enter the number of eggs: ");
        eggs = input.nextInt();
        
        // price
        System.out.print("Enter retail price of item:");
        price = input.nextDouble();
       
        //radius
        System.out.print("Enter circle radius: ");
        radius = input.nextDouble();
        
        // hits
        System.out.print("Enter the numbers of hits: ");
        bat = input.nextInt();
       
        // atBats
        System.out.print("Enter the number of at-bats: ");
        atBats = input.nextInt();
        
        // Item 1
        System.out.print("Enter starting Item 1 quantity:");
        item1 = input.nextInt();
        
        // item 2
        System.out.print("Enter starting Item 2 quantity:");
        item2 = input.nextInt();
       
        // delivery amount
        System.out.print("Enter Item 2 delivery quantity:");
        deliveryAmt = input.nextInt();
       
        // problem 1: calculate total lunch price
        lunchPrice = (double) sandwich + chips + soda;
        System.out.print("1) Lunch Price is:\t\t\t\t\t\t\t$" + lunchPrice);
        System.out.println();
        System.out.println();
        
        // problem 2: solve how many eggs can fill the cartons
        cartons = eggs / ONE_DOZEN;
        System.out.print("2) " + eggs + " eggs fills:\t\t\t\t\t\t\t" + cartons + "\tcartons");
        System.out.println();
        System.out.println();
         
        // problem 3: solve how many eggs will be left over
        cartons = eggs % ONE_DOZEN;
        System.out.print("3) " + eggs + " eggs leaves:\t\t\t\t\t\t\t" + cartons + "\teggs");
        System.out.println();
        System.out.println();
        
        // problem 4: calculate the sales tax
        tax = price * SALES_TAX_RATE;
        System.out.print("4) tax on " + price + " is:\t\t\t\t\t\t\t$" + tax);
        System.out.println();
        System.out.println();
       
        // problem 5: calculate the area of a circle
        area = PI * (radius*radius);
        System.out.print("5) r= " + radius +" circle area is:\t\t\t\t\t" + area);
        System.out.println();
        System.out.println();
        
        // problem 6: calculate the batting average 
        batAverage = (double) bat / atBats;
        System.out.print("6) " + bat +" hits, " + atBats + " at-bats batting avg is:\t\t" + batAverage);
        System.out.println();
        System.out.println();
        
        //problem 7: calculate the new quantity of an item
        System.out.print("7a) item 1 inventory before:\t\t\t\t" + item1);
        item1--;
        System.out.println();
        System.out.print("7b) item 1 inventory after:\t\t\t\t\t" + item1);
        System.out.println();
        System.out.println();
       
        // problem 8: calculate the inventory after a new delivery 
        System.out.print("8a) item 2 inventory before:\t\t\t\t" + item2);
        item2 += deliveryAmt;
        System.out.println();
        System.out.print("8b) item 2 inventory after:\t\t\t\t\t" + item2); 
        System.out.println(); 
    }
    
}