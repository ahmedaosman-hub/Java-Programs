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

class	Person	implements Comparable <Person>{

	private String	first;
	private String	last;
	private String	phone;

	public Person(String first,	String last, String phone){
		this.first =	first;
		this.last	= last;
		this.phone =	phone;
	}

	public String getFirst(){
		return	first;
	}
	public String getLast(){
		return	last;
	}

	public String getPhone(){
		return	phone;
	}

	public void	setFirst(String n){
		first = n;
	}

	public void	setLast(String	l){
		last =	l;
	}

	public void	setPhone(String p){
		phone = p;
	}

	public String toString(){
		return first + " " + last	+ " "	+ phone;
	}

	public boolean	equals(Person other){
		return first.equals(other.getFirst()) && last.equals(other.getLast()) && phone.equals(other.getPhone());
	}

	public int compareTo(Person	other){
		return last.compareTo(other.getLast());
	}


}


class	Directory {

	private ArrayList<Person>	contacts;

	public	Directory(){
		contacts =	new ArrayList<>();
	}
	public	boolean addContact(String name, String	last,	String phone){
		Person p	= new	Person(name,	last,	phone);

		for(int	i = 0; i	< contacts.size(); i++){
			Person	c = contacts.get(i);
			if(c.equals(p)){
				return	false;
			}

		}
		contacts.add(p);
		return true;
	}

	public	boolean deleteContact(String last){
		for(int	i = 0; i	< contacts.size(); i++){
			String c	= contacts.get(i).getLast();
			if(c.equals(last)){
				contacts.remove(i);
				return	true;
			}

		}
		return false;
	}
	public String searchContact(String last){
		for(int	i = 0; i	< contacts.size(); i++){
			String c	= contacts.get(i).getLast();
			if(c.equals(last)){
				return	contacts.get(i).getPhone();
			}

		}
		return null;
	}

	public	String toString(){
		String s =	"";
		for(int i	= 0; i <	contacts.size(); i++){
			s = s	+ contacts.get(i).toString() + "\n";
		}
		return s;
	}

}
public class Driver{
	public static void main(String[] args){

		Directory myContact = new Directory();

		myContact.addContact("Ana", "Baily", "568-345-9999");
		myContact.addContact("Mary", "Busta", "111-222-3333");
		myContact.addContact("Smith", "Richard", "123-123-4567");
		myContact.addContact("Alex", "Rodrigues", "987-567-7777");
		myContact.addContact("Sarah", "Schulz", "555-666-7777");

		System.out.println(myContact.toString());
		System.out.println("Removing Ana Baily from the contact");
		System.out.println();
		myContact.deleteContact("Baily");
		System.out.println("List of contacts after removing Ana Baily");
		System.out.println(myContact.toString());
		System.out.println("Searching the contact for Smith");
		System.out.println(myContact.searchContact("Richard"));
		System.out.println();
		System.out.println("Adding a new contact");
		myContact.addContact("Justin", "Wayne", "707-444-2352");
		System.out.println(myContact.toString());
		
		System.out.println("search for Dobeck that is not in the list");
		if(myContact.searchContact("Dobeck")==null){
			System.out.println("Contact info not found");
		}
	}
}