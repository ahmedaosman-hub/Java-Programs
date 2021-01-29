/*
 * Name:       Ahmed Osman
 *
 * Course:     CS-12, Spring 2020
 *
 * Date:       02/23/20
 *
 * Filename:   OperatorsAO.java
 * 
 * Purpose:    Turn problem discriptions into Java statements
 */
 
public class OperatorsAO {
    
    public static void main(String [] args) {
       
        // all data declarations
        double sandwich;
        int chips;
        int soda;
        double lunchPrice;
        
        int eggs;
        final int ONE_DOZEN;
        int cartons;
        
        final double SALES_TAX_RATE;
        double price;
        double tax;
        
        final double PI;
        double radius;
        double area; 
        
        int bat;
        int atBats;
        double batAverage;
        
        int item1;
        
        int item2;
        int deliveryAmt;
        
        // all data initializations
        sandwich = 4.99;
        chips = 2;
        soda = 1;
        
        eggs = 796;
        ONE_DOZEN = 12;
        
        SALES_TAX_RATE = .0725;
        price = 129.99;
       
        PI = 3.14;
        radius = 4.5;
        
        bat = 123;
        atBats = 456;
        
        item1 = 100;
        
        item2= 200;
        deliveryAmt= 45;

        

        // problem 1: calculate total lunch price
        lunchPrice = sandwich + chips + soda;
        System.out.println("1) Lunch Price is:\t\t\t\t\t\t\t$" + lunchPrice);
        System.out.println();
        
        // problem 2: solve how many eggs can fill the cartons
        cartons = eggs/ONE_DOZEN;
        System.out.println("2) " + eggs + " eggs fills:\t\t\t\t\t\t\t" + cartons + "\tcartons");
        System.out.println();
                
        // problem 3: solve how many eggs will be left over
        cartons = eggs%ONE_DOZEN;
        System.out.println("3) " + eggs + " eggs leaves:\t\t\t\t\t\t\t" + cartons + "\teggs");
        System.out.println();
        
        // problem 4: calculate the sales tax
        tax = price * SALES_TAX_RATE;
        System.out.println("4) tax on " + price + " is:\t\t\t\t\t\t$" + tax);
        System.out.println(); 
              
        // problem 5: calculate the area of a circle
        area = PI * (radius*radius);
        System.out.println("5) radius= " + radius +" circle area is:\t\t\t\t" + area);
        System.out.println();
        
        // problem 6: calculate the batting average 
        batAverage = (double) bat / atBats;
        System.out.println("6) " + bat +" hits, " + atBats + " at-bats batting avg is:\t" + batAverage);
        System.out.println();
        
        //problem 7: calculate the new quantity of an item
        System.out.println("7a) item 1 inventory before:\t\t\t\t" + item1);
        item1--;
        System.out.println("7b) item 1 inventory after:\t\t\t\t\t" + item1);
        System.out.println();
        
        // problem 8: calculate the inventory after a new delivery 
        System.out.println("8a) item 2 inventory before:\t\t\t\t" + item2);
        item2 += deliveryAmt;
        System.out.println("8b) item 2 inventory after:\t\t\t\t\t" + item2);
       
    }
    
}