
import java.util.*;
public interface myStack {
   public void push(String s);
   public String peek();
   public boolean isEmpty();
   public String pop();
}
class  Stack {  
   // declare an array list here
  list <String> s;
   // Instantiate the Array lists
   public Stack() { 
    s = new ArrayList <>();
   }
   
   // push the token to the top of the Stack
   public void push (String token) {
     // here you need to add token into ArrayList(s)
    s.add(token);
   }
   
   // pops and returns the element at the top of the stack without popping itj,
   public String pop () {
     // here we need to remove the last element from the ArrayList and need to return that
     // lets first get the last element from list
     String element  =  get(s.size() - 1);
     
     s.remove(s.size() - 1 );
     return element;
   }
   
   // returns the element at the top of the stack without popping it
   public String peek () {
   }
   
   // returns true if the stack is empty, returns false otherwise
   public Boolean isEmpty () {
   }
   
   // returns a string representing the elements in the stack
   public String toString () {
   }    
}

class Expression {
  private String exp;  // instance variable
  
  // assigns e to exp
  public Expression(String s) {
     exp = s;
  }
  
 
  public String getPostfix(){
                     
   return "";
  }
  private static int precedence(String opr){
     return 0;
  }
  public int evalPostfix() {
       return 0 ;       
   }
    
     
  
  private int calculate(int num1, int num2, String opr){
      return 0;
  }
  
class ExpDrive {
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
}