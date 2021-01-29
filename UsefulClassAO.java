/*
 * Name:       Ahmed Osman
 *
 * Course:     CS-12, Spring 2020
 *
 * Date:       03/17/20
 *
 * Filename:   UsefulClassAO.java
 * 
 * Purpose:    To work with two classes, Random and Math,
 */

import java.util.Scanner;
import java.util.Random;


public class UsefulClassAO {
    
    public static void main(String [] args) {
    
    Scanner input = new Scanner(System.in);
    String    str = new String("hello ");
    Random   rand = new Random();
   
    int num1, num2;
    int num;
    int rand1, rand2, rand3, rand4;  
    double result;
    double side1;
    double side2;
    double radius;
    
    System.out.print("Enter minimum random number bound: ");
    num1 = input.nextInt();
    System.out.print("Enter maximum random number bound: ");
    num2 = input.nextInt();
    System.out.println();
    
    rand1 = rand.nextInt((num2 - num1) + 1) + num1;
    rand2 = rand.nextInt((num2 - num1) + 1) + num1;
    rand3 = rand.nextInt((num2 - num1) + 1) + num1;
    rand4 = rand.nextInt((num2 - num1) + 1) + num1;
    System.out.println("1) range: " + num1 + "-" + num2 + " random #s: " + rand1 + " "+ rand2 + " " + rand3 + " " + rand4 );
    System.out.println();
  
    System.out.println("2a) smallest random number: " + Math.min(rand1, Math.min(rand2, Math.min(rand3, rand4))));                                                        
    System.out.println("2b) largest random number: " + Math.max(rand1, Math.max(rand2, Math.max(rand3, rand4))));
    System.out.println();
    
    System.out.print("Enter side a: ");
    side1 = input.nextDouble();
  
    System.out.print("Enter side b: ");
    side2 = input.nextDouble(); 
    System.out.println();
    
    result = Math.sqrt(Math.pow(side1,2) + Math.pow(side2,2));
    
    System.out.println("3) sides: a = " + side1 + " b = " + side2);
    System.out.println("   hyp:   h = " + result + " (exact) ");
    System.out.println("          h = " + (int) Math.round(result) + " (rounded)");
    System.out.println();
    
    System.out.print("Enter sphere radius: ");
    radius = input.nextDouble();
    System.out.println();
    System.out.print("4) sphere r = " + radius + "		 sphere V = " + 4/3.0 * Math.PI * Math.pow(radius,3));
    System.out.println();       
 
    }
}