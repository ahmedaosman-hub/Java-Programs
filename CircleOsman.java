/*
 * Name:       Ahmed Osman
 *
 * Course:     CS-13, Fall 2020
 *
 * Date:       09/16/2020
 *
 * Filename:   CircleOsman.java
 * 
 * Purpose:    Creating a class and testing it. We used circles, placing coordinates, radiuses, areas and perimeters. 
 */
 
import java.lang.Math;
import java.text.DecimalFormat;

// First constructor. Declares the variables.
public class CircleOsman {  
  double centerX;  
  double centerY;
  double radius; 
  
  // Initialized the variables.
  public CircleOsman() {
    centerX = 0.0;
    centerY = 0.0; 
    radius = 1.0;
  }
  
  //Accessor Method
  public CircleOsman(double initCenterX, double initCenterY, double initRadius) {
    centerX = initCenterX;
    centerY = initCenterY;
    setRadius(initRadius);
  }
  
  //Allows us to call the x coordinate
  public double getCenterX() {
    return centerX;
  }
  
  //Allows us to call the y coordinate
  public double getCenterY() {
    return centerY;
  }
  
  //Allows us to call the radius
  public double getRadius() {
    return radius;
  }
  
  //Allows us to solve for the perimeter of a circle
  public double getPerimeter() {
    return radius * 2 * Math.PI;
    
  }
  
  //Allows us to solve for the area of a circle
  public double getArea() {
    return Math.PI * Math.pow(radius, 2);
  }
  
  //Allows us to set a new number as the x coordinate
  public void setCenterX (double newCenterX){
    centerX = newCenterX;
  }
  
  //Allows us to set a new number as the y coordinate
  public void setCenterY (double newCenterY) {
    centerY = newCenterY;
  }
  
  //Allows us to set a new radius 
  public void setRadius (double newRadius) {
    radius = newRadius;
    if (newRadius <= 0){
      radius = 0;
    }
   
  }
  
  //Allows us to test if two or more circles equal each other
  public boolean equals(CircleOsman other) {
  
    if (other.centerX == centerX) {
      if (other.centerY == centerY) {
        if (other.radius == radius) {
          return true;
        }
      }
    }
  
    return false; 
  }
  
  //Basic string that displays the coordinates and radius
  public String toString() {
    return "Center: (" + centerX + "," + centerY + ") Radius: " + radius;
  } 
}

//Our client code to test our class
class CircleClientOsman {
  public static void main(String[] args) {
    DecimalFormat format = new DecimalFormat("0.#");
  
    // Testing constructors. Sets the beginning circle and test the constructors
    System.out.println("TESTING CONSTRUCTORS:");
    CircleOsman constructors = new CircleOsman();
    System.out.println("No-Argument Circle: Center:(" + format.format(constructors.getCenterX()) + "," + format.format(constructors.getCenterY()) +  ") Radius: " + format.format(constructors.getRadius()));
    constructors = new CircleOsman(15, 25, 50);
    System.out.println("Circle instantiated using center at (15, 25) and a radius of 50 is: Center: (" + format.format(constructors.getCenterX()) + ", " + format.format(constructors.getCenterY()) + ") Radius: " + format.format(constructors.getRadius()));
    constructors = new CircleOsman(15, 25, -5);
    System.out.println("Circle instantiated using center at (15, 25) and a radius of -5 is: Center: (" + format.format(constructors.getCenterX()) + ", " + format.format(constructors.getCenterY()) + ") Radius: " + format.format(constructors.getRadius()));
    System.out.println();
    
    //Testing Accessor Methods.. Allows us to call the coordinates and radius.
    System.out.println("TESTING ACCESSOR METHODS:");
    CircleOsman accessors = new CircleOsman(15, 25, 50);
    System.out.println("x- coordinate of the center is: " + format.format(accessors.getCenterX()));
    System.out.println("y- coordinate of the center is: " + format.format(accessors.getCenterY()));
    System.out.println("radius is: " + format.format(accessors.getRadius()));
    System.out.println("perimeter is: " + format.format(accessors.getPerimeter()));
    System.out.println("area is: " + format.format(accessors.getArea()));
    System.out.println();
    
    //Testing Mutator Methods.. Allows us to set new coordinates and radius
    System.out.println("TESTING MUTATOR METHODS");
    CircleOsman mutators = new CircleOsman(); // Default first.
    mutators.setCenterX(1);
    mutators.setCenterY(2);
    mutators.setRadius(10);
    System.out.println("After using the set method to change the center to: (1, 2) and the radius to 10:");
    System.out.println("The circle is: Center: " + format.format(mutators.getCenterX()) +  "," + format.format(mutators.getCenterY()) + " Radius: " + format.format(mutators.getRadius()));
    System.out.println("After changing the radius to -15: ");
    mutators.setRadius(-15);
    System.out.println("The circle is: Center: (" + format.format(mutators.getCenterX()) + ", " + format.format(mutators.getCenterY()) + ") Radius: " + format.format(mutators.getRadius()));
    System.out.println();
    
    //Testing Equal Methods. We test if two circles are equal here
    System.out.println("TESTING EQUAL METHODS");
    
    //Setting up new circles to test.
    CircleOsman c1 = new CircleOsman(1, 1, 1);
    CircleOsman c2 = new CircleOsman(2, 2, 2);
    CircleOsman c3 = new CircleOsman(1, 2, 1);
    CircleOsman c4 = new CircleOsman(2, 2, 2);
    
    //Displaying the coordinates and radius of those circles. 
    System.out.println("circle1 is: " + c1);
    System.out.println("circle2 is: " + c2);
    System.out.println("circle3 is: " + c3);
    System.out.println("circle4 is: " + c4);
    System.out.println();
        
    
    // Tests the equal of two circles
    if (c1.equals(c2)) {
      System.out.println("circle1 equals circle2");
    }
    else {
      System.out.println("circle1 does not equal circle2");
    }
    if (c1.equals(c3)) {
      System.out.println("circle1 equals circle3");
    }
    else {
      System.out.println("circle1 does not equal circle3");
    }
    if (c2.equals(c4)){
      System.out.println("circle2 equals circle4"); 
    }
    else {
      System.out.println("circle2 does not equals circle4");
    }
  }
}


