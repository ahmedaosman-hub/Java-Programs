/*
 * Name:       Ahmed Osman
 *
 * Course:     CS-13, Fall 2020
 *
 * Date:       11/14/2020
 *
 * Filename:   DriverQueue.java
 * 
 * Purpose:    Adding more methods to the Queue class. Methods implemented : Constructor, Dequeue, Enqueue, toString, restore, getMax
 */
import java.util.*;

class Queue {

    ArrayList<Integer> list;
   public Queue()
   {
     list = new ArrayList<Integer>();
   }
   public void enqueue(Integer num)
   {
      list.add(num);
   }
   public Integer dequeue()
   {
     return list.remove(0);
   }
   public String toString()
   {
     String s = "";
     Queue copy = new Queue();
     boolean b = false;
     while(!b)
     {
       try
       {
          int num = this.dequeue();
          copy.enqueue(num);
          s = s + " " + num;
       }
       catch(Exception e)
       {
          b = true;
       }
     }
    
    
     //System.out.println(copy.list+ "&&&&");
     restore(copy);
     return s;
     }
     

    public int getMax() {
        Queue copy = new Queue();
        boolean b = false;
        int max = 0;
        while (!b) {
            try {
                int num = this.dequeue();
                copy.enqueue(num);              
                if (num > max) {
                    max = num;
                }
            } catch (Exception e) {
                b = true;
            }
        }
        restore(copy);
        return max;
    }

    public void restore(Queue q) {
        boolean b = false;
        while (!b) {
            try {
                this.enqueue(q.dequeue());
            } catch (Exception e) {
                b = true;
            }
        }
    }

    public int getMin() {
        Queue list = new Queue();
        boolean a = false;
        int min = Integer.MAX_VALUE;
        while (!a) {
            try {
                int num = this.dequeue();
                list.enqueue(num);
                if (num < min) {
                    min = num;
                }
            } catch (Exception e) {
                a = true;
            }
        }
        restore(list);
        return min;
    }
    // Method reverses the queue

    public void reverseOrder() {
        // declare extra storage
        ArrayList<Integer> stack = new ArrayList<Integer>();
        boolean b = false;
        int num;
        while (!b) {
            try {
                // dequeue an element
                num = this.dequeue();
                // push element to stack 
              stack.add(0,num);
            } catch (Exception e) {
                b = true;
            }
        }

        // Pop the elements from the stack and rebuild the queue. 
        b = false;
        while (!b) {
            try {
                // pop an element from the stack
                num = stack.remove(0);
                this.enqueue(num);
            } catch (Exception e) {
                b = true;
            }
        }
    }

    public double getAverage() {
        // declare sum, average, and count
        double sum = 0;
        double average = 0;
        int count = 0;
        // declare a queue called copy 
        Queue copy = new Queue();
        boolean b = false;
        while (!b) {
            try {
                // dequeue an element from the queue and store it in a variable
                int n1 = this.dequeue();
                //enqueue the element to queue copy 
                copy.enqueue(n1);
                // add the dequeued element to the sum
                sum = n1 + sum ;
                // incremenet the count 
                count = 1 + count; 
            } catch (Exception e) {
                b = true;
            }
        }
        //call the restore method
        restore(copy);
        //return average
        average = sum / count;
        return average; 

    }

    public boolean isSorted() {

        //Declare and instantiate queue
        Queue q = new Queue();
        boolean b = false;
        boolean sorted = true;
        while (!b) {
            try {
                int n1 = this.dequeue();
                int n2 = this.dequeue();
                q.enqueue(n1);
                q.enqueue(n2);
                if (n1 > n2) {
                    sorted = false;
                }
            } catch (Exception e) {
                b = true;
            }
        }
        restore(q);
        return sorted;
    }
}

public class DriverQueue {

    public static void main(String[] args) {
        Queue m = new Queue();
        m.enqueue(10);
        m.enqueue(12);
        m.enqueue(15);
        m.enqueue(7);
        m.enqueue(100);
        m.enqueue(22);
        System.out.println("The queue is : " + m);
        m.reverseOrder();
        System.out.println("The queue in the reverse order is: " + m);
        m.reverseOrder();
        System.out.println("The queue is back to its original state: " + m);
        System.out.printf("Average = %.2f\n", m.getAverage());
        System.out.println("Max = " + m.getMax());
        System.out.println("Min = " + m.getMin());
        System.out.println("The list is sorted: " + m.isSorted());

    }

}


