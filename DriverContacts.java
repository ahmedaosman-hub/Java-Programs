/*
 *	Name:			Ahmed	Osman
 *
 *	Course:		CS-13, Fall	2020
 *
 *	Date:			10/07/2020
 *
 *	Filename:	ContantAppOsman.java
 *	
 *	Purpose:		Creating	an	app to keep	track	of	all the contact info	of	my	friends.
 */
 
import java.util.*;
import java.io.*;
import java.util.ArrayList;

class	Person implements Comparable <Person>{
 
   //Declaring the variables
	private String	first;
	private String	last;
	private String	phone;

   //First constructor
	public Person(String first, String last, String phone){
		this.first =	first;
		this.last	= last;
		this.phone =	phone;
	}
   

   //Get First name
	public String getFirst(){
		return	first;
	}
   
   //Gets last name
	public String getLast(){
		return	last;
	}

   //Gets phone number
	public String getPhone(){
		return	phone;
	}

   //Sets the first name
	public void	setFirst(String n){
		first = n;
	}
   
   //Sets the last name
	public void	setLast(String	l){
		last =	l;
	}
 
   //Sets the phone number
	public void	setPhone(String p){
		phone = p;
	}

   //Prints the full name and phone number
	public String toString(){
		return first + " " + last	+ " "	+ phone;
	}
   
   //Determines if two people are the same
	public boolean	equals(Person p){
		return last.equalsIgnoreCase(p.last) && first.equalsIgnoreCase(p.first);
   }

   //Determines if two people are different
	public int compareTo(Person p) {
     int i = this.last.compareTo(p.last);
     if (i == 0) 
       return p.first.compareTo(first);
     else 
       return i;
   }

}

//Contact Class
class	Directory {

	private ArrayList<Person>	contacts;

	public Directory(){
		contacts = new ArrayList<>();
	}
   
   //Adds a contact name and phone
	public boolean addContact(String name, String last, String phone){
		Person p	= new	Person(name, last, phone);

		for(int	i = 0; i	< contacts.size(); i++){
	     Person	c = contacts.get(i);
		  if(c.equals(p)){
		    return false;
			}

		}
		contacts.add(p);
		  return true;
	}
   
   //Deletes a contact
	public boolean deleteContact(String last){
		for(int	i = 0; i	< contacts.size(); i++){
			String c	= contacts.get(i).getLast();
			if(c.equals(last)){
				contacts.remove(i);
				return true;
			}
		}
		return false;
	}
   
   //Searches for a contact
	public String searchContact(String last){
		for(int	i = 0; i	< contacts.size(); i++){
			String c	= contacts.get(i).getLast();
			if(c.equals(last)){
				return contacts.get(i).getPhone();
			}
		}
		return null;
	}
   
   //Prints out our String
	public String toString(){
		String s = "";
		for(int i = 0; i < contacts.size(); i++){
			s = s	+ contacts.get(i).toString() + " ";
		}
		return s;
	}
	
	public void add (String first, String last, String phone){
      Person p = new Person(first, last, phone);
      contacts.add(p);
   }
   
   
   //Outer loop
   public void selectionSort(){
   
     ArrayList<Person> sorted = new ArrayList<Person>();
     while (!contacts.isEmpty()) {
     
    	//Inner loop
		int lowestIndex = 0;
		for (int i = 1; i < contacts.size(); i++) {
  	     if (contacts.get(lowestIndex).compareTo(contacts.get(i)) > 0) {
    	    lowestIndex = i;
	       
          sorted.add(contacts.get(lowestIndex));
	       contacts.remove(lowestIndex);
          contacts = sorted;
        }
      }
     }      
   }
      
    public void insertionSort() {
      for (int i = 1; i < contacts.size(); i++) {
        for (int j = i; j > 0; j--) {
          if (contacts.get(j).compareTo(contacts.get(j - 1)) >= 0) {
            break;
          } 
            else {
              Person temp = contacts.get(j);
              contacts.set(j, contacts.get(j - 1));
              contacts.set(j - 1, temp);
            }
          }
        }
    }

    public void bubbleSort() {
      int j = i;
      
      for (int i = 0; i < contacts.size(); i++){
        if (contacts.get(j + 1).compareTo(contacts.get(j)) < 0){
          String temp = contacts.get(j);
          contacts.set(j, contacts.get(j + 1));
          contacts.set(j + 1, temp);
         }
      }    
    }
    
    

    public int binarySearch(Person p){
      int begin = 0;
      int end = contacts.size() - 1; 
      int middle = (begin + end) / 2; 
        while (begin <= end){
           if (contacts.get(middle).equalsIgnoreCase(p)){
              return middle;
           }
           if (p.compareTo(contacts.get(middle)) > 0){
              begin = middle + 1;
           }
           else 
              end = middle - 1;
           }
          return -1;
    }
    
   //Prints out our String
	public String toString(){
     String s = "";
	    for(int i	= 0; i <	contacts.size(); i++){
		   s = s	+ contacts.get(i).toString() + "\n";
		 }
		 return s;
   }
}	



//Our main method
public class DriverContacts{
	public static void main(String[] args){

		Directory myContact = new Directory();
       
       
      //Our contacts
		myContact.addContact("Ana", "Baily", "568-345-9999");
		myContact.addContact("Mary", "Busta", "111-222-3333");
		myContact.addContact("Richard", "Smith", "123-123-4567");
		myContact.addContact("Alex", "Rodrigues", "987-567-7777");
		myContact.addContact("Sarah", "Schulz", "555-666-7777");
  

      //Lists needed to test our methods
      
      contacts.selectionSort();
		System.out.println(myContact.toString());
      
      myContact.addContact("Zack" , "Lambard" , "345-777-8989");
      myContact.addContact("Alex" , "Cook" , "111-222-3333");
      myContact.addContact("Roy" , "Trump" , "333-555-6666");
      
      contacts.insertionSort();
      System.out.println(myContact.toString());
      
      myContact.addContact("Sarah" , "Lee" , "888-999-9008");
      myContact.addContact("Ashley" , "Lu" , "123-444-0780");
      myContact.addContact("Jose" , "Brown" , "111-999-6556");
      
      contacts.bubbleSort();
      System.out.println(myContact.toString());
      
      contacts.binarySearch();
      System.out.println(myContact.toString());
      

     }
} 
   
   

