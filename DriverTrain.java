/*
 * Name:       Ahmed Osman
 *
 * Course:     CS-13, Fall 2020
 *
 * Date:       09/30/2020
 *
 * Filename:   Driver.java
 * 
 * Purpose:    Creating multiple methods for a train class. 
 */

// Our output main method
public class DriverTrain{
	public static void main(String[] args){
		Train myTrain = new Train();
      //our customers
		Passenger p1 = new Passenger("Alex", "Mano","123-456-7893", 12, "First class");
		Passenger p2 = new Passenger("Mary", "Trump", "123-456-4894", 23, "Coach class");
		Passenger p3 = new Passenger("Ali", "Busta", "123-456-7890", 34, "Business class");
		Passenger p4 = new Passenger("Jose", "Rorigues", "123-222-7890", 22, "First class");
		
		
		myTrain.add(p1);
		myTrain.add(p2);
		myTrain.add(p3);
		myTrain.add(p4);
		
		myTrain.printLast(); 
		System.out.print("\nSearching for Mano...");
		System.out.println(myTrain.search("Mano").toString());
		
		System.out.println("\nDeleting Mano...");
		System.out.println(myTrain.delete("Mano"));
		System.out.println(myTrain);


	}
}
// reserves everyones name and contact info
class Person{
	private String name;
	private String last;
	private String contact;
	public Person(String name, String last, String contact) {
		this.name = name;
		this.last = last;
		this.contact = contact;
	}
   //gets the name
	public String getName(){
		return name;
	}
   //gets the last name
	public String getLast(){
		return last;
	}
   //gets their phone number
	public String getPhone(){
		return contact;
	}
   //sets their name
	public void setName(String name){
		this.name = name;
	}
   //sets their last name
	public void setLast(String last){
		this.last = last;
	}
   //sets their phone 
	public void setPhone(String contact) {
		this.contact = contact;
	}
   
	public boolean equals(Object o) {
		if (o instanceof Person){
			Person p = (Person)o;
			return p.last.equals(this.last);
		}
		else
			return false;
	}
   //prints out the name and last name of the person
	public String toString(){
		return "\nName: " + name + "\nLast : "+ last + "\ncontact: "+ contact;
	}
}
//this class must extend the person class
class Passenger extends Person{
	private int seatNumber;
	private String seatClass;

	public Passenger (String name, String last, String contact, int seatNumber, String seatClass){
		super(name, last, contact);
		this.seatNumber = seatNumber; 
		this.seatClass = seatClass; 
	}
   //sets the seatNumber
	public int setseatNumber(){
		return seatNumber; 
	}
   //sets the seatClass
	public String setseatClass(){
		return seatClass;
	}
   //gets the seatNumber
	public void getseatNumber(){
		this.seatNumber = seatNumber;
	}
   //gets the seatClass
	public void getseatClass(){
		this.seatClass = seatClass;
	}
   //displays the seatNumber and the seatClass
	public String toString(){
		return super.toString() + "\nSeat number: " + seatNumber + "\nClassL: " + seatClass;
	}   
}
//lists all our methods
interface List{ 
	public boolean add(Object o);
	public Object search(Object o);  
	public boolean delete(Object o);
	public void printLast();

}
class Train implements List
{
	Passenger[] train;  //list of the passengers
	private static int count = 0; // number of the passengers in the train
	public Train()
	{
		train = new Passenger[10];
	}
	public boolean add(Object o){
		boolean b = o instanceof Passenger;
		if(!b) return false;
		train[count++] = (Passenger)o;
		return true;
		
	}
	public Object search (Object o){
		boolean b = o instanceof String;
		if(!b) return null;
		String name = (String)o; 
		for(int i = 0; i < count; i++) {
			if(train[i] != null && train[i].getLast().equals(name)) { 
				return train[i]; 
			} 
		}
		return null;
	}

	public boolean delete(Object o) {
		boolean b = o instanceof String;
		if(!b) return false;
		String name = (String)o; 
		for(int i = 0; i < count; i++) {
			if(train[i] != null && train[i].getLast().equals(name)) { 
				train[i] = null;
				count--;
				break;
			} 
		}
		return true;
	}
	public void printLast(){
		
		for(int i = 0; i < count; i++) {
			if(train[i] != null) { 
				System.out.println(train[i].getLast());
			} 
		}
	}
	public String toString(){
		String s = "";
		
		for(int i = 0; i < count; i++) {
			if(train[i] != null) { 
				s = s + train[i].toString() + "\n";
			} 
		}
		return s;
	}


}
