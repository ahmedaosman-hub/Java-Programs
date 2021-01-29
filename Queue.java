import java.util.*;
public class Queue
{
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
   public int getMax()
   {
     Queue copy = new Queue();
     boolean b= false;
     int max = 0;
     while(!b)
     {
       try
       {
          int num = this.dequeue();
          if(num > max)
             max = num;
          copy.enqueue(num);   
          
       }
       catch(Exception e)
       {
         b = true;
       }
     }
     restore(copy);
     return max;
   }
   public void restore(Queue q)
   {
      boolean b = false;
      while(!b)
      {
         try
         {
            this.enqueue(q.dequeue());
         }
         catch(Exception e)
         {
            b = true;
         }
      }
   }
    public Integer getMin()
   {
                   
     return null;             
       
          
   }
   public void reverseOrder()
   {
   }
   public double getAverage()
   {
       return 0;        
   }
   public boolean isSorted()
   {
      return false;         
   }

   
   
   
   }
class Driver
{
   public static void main(String[] args)
   {
     Queue m = new Queue();
     m.enqueue(10);
     m.enqueue(12);
     m.enqueue(15);
     m.enqueue(7);
     m.enqueue(100);
     m.enqueue(22);
     System.out.println(m);
     
     System.out.println(m.getMax());
     System.out.println(m);
           
   }
}