/*
 * Name:       Ahmed Osman
 *
 * Course:     CS-13, Fall 2020
 *
 * Date:       11/14/2020
 *
 * Filename:   ExpDrive.java
 * 
 * Purpose:    Create a program that converts an infix expression to a postfix expression and evaluate it.  
 */
 
import java.util.*;

interface myStack {
    public void push(String s);
    public String peek();
    public boolean isEmpty();
    public String pop();
}

class Stack implements myStack { 
    // declare an array list here
    java.util.List<String> s;

    // Instantiate the Array lists
    Stack() { 
        s = new java.util.ArrayList<>();
    }

   // push the token to the top of the Stack
    public void push (String token) {
        s.add(token);
    }

    // pops and returns the element at the top of the stack.
    
    public String pop () {
        String element;
        
        // If the element is empty dont return anything
        if (isEmpty()) {
            return null;
        } else {
            element = s.remove(s.size() - 1 );
        }

        return element;
    }

    // returns the element at the top of the stack without popping it
    public String peek () {
        if (isEmpty()){
            return null;
        } else {
         return s.get(s.size() - 1);
        }
    } 

    // returns true if the stack is empty, returns false otherwise
    
    public boolean isEmpty () {
        return s.isEmpty();
    }

    // returns a string representing the elements in the stack
    public String toString () {
        return s.toString();
    }
}

class Expression {
  private String exp;  // instance variable
  
  // assigns e to exp
  public Expression(String s) {
     exp = s;
  }
  
  // Ranking method
  private static int precedence(String opr){
    
    // If string is a multiplication or division
    if (opr.equals("*") || opr.equals("/")){
      return 3;
    } 
    // If string is addition or subtraction
    else if (opr.equals("+") || opr.equals("-")) {
      return 2;
    }
    return 0;
  }
  
  // Solve the expression
  private static int calculate(int num1, int num2, String opr){
    if (opr.equals("*")){
      return num1 * num2;
    }
    else if (opr.equals("/")){
      return num1 / num2;
    }
    else if (opr.equals("+")){
      return num1 + num2;
    }
    else if (opr.equals("-")){
      return num1 - num2;
    }
    else {
      return 0;
    }
  }
  
    // returns postfix of exp
    public String getPostfix(){  
        String postfix = "";
        Stack o = new Stack();
        StringTokenizer st = new StringTokenizer(exp," "); 
        while(st.hasMoreTokens()) {
            String token = st.nextToken();
            
            // If the token has any of the operations
            if (token.equals("*") || token.equals("/") || token.equals("+") || token.equals("/")){
                int number = precedence(token);
                
                // If the precedence is 3
                if (number == 3){
                    // Stack is not empty and precedence is 3
                    while (!o.isEmpty() && precedence(o.peek()) == 3) {
                        postfix = postfix + " "+ o.pop();
                    }
                  // Or if precedence is 2
                } else if (precedence(token) == 2) {
                    // Stack is not empty but the precedence is either 3 or 2
                    while (!o.isEmpty() && (precedence(o.peek()) == 3  || precedence(o.peek()) == 2)) {
                        postfix = postfix + " " + o.pop();
                    }
                }

                o.push(token);
            } else {
                postfix = postfix + " " + token;
            }

            while (!o.isEmpty()) {
                postfix = postfix + " " + o.pop(); 
            }
        }

        return postfix;
    }

  // evaluates the postfix expression
  public int evalPostfix() {
    String post = this.getPostfix();
    Stack j = new Stack();
    int result = 0;
    StringTokenizer st = new StringTokenizer(post, " "); 
    while (st.hasMoreTokens()) { 
      String token = st.nextToken();
      if (!token.equals("*") || !token.equals("/") || !token.equals("+") || !token.equals("-")) { 
        j.push(token);
      } else {
        String n1 = j.pop();
        String n2 = j.pop();
        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);
        result = calculate(num1, num2, token);
 
        j.push(result + "");
      }
    }
    // Convert the string to integers 
    int solution = Integer.parseInt(j.pop()); 
    return solution;
   }
 }
 
public class ExpDrive {
  public static void main(String[] args) {
     
    // String s = "5 - 2";
     ArrayList <String> exp = new ArrayList<String>();
     exp.add("2 + 3 + 7 * 4 - 2 / 3");
     exp.add("3 - 4 / 2 + 6 * 3");
     exp.add("5 * 6 - 8 + 2 * 10");
     exp.add("4 + 8 * 3 - 2 / 34");
     exp.add("6 - 3 + 6 / 2 * 4 - 8");
     for(int i = 0; i < exp.size(); i++) {
     
        Expression e1 = new Expression(exp.get(i));
        String post = e1.getPostfix();
        int result = e1.evalPostfix();
        System.out.println("Infix: "+ exp.get(i) + ",  postfix: " + post + " = " + result);
     }

  } 
}

