/*
 * Name:       Ahmed Osman
 *
 * Course:     CS-13, Fall 2020
 *
 * Date:       10/23/2020
 *
 * Filename:   DriverMovieList.java
 * 
 * Purpose:    To create a link list to display movies ratings,watched amount, and genre.  
 */
 
public class DriverMovieList {
	public static void main (String [] args)
	{
		MovieList list = new MovieList();
		list.add("Reservoir Dogs", "drama",5, 20000); 
		list.add("Airplane", "Funny", 3, 1200);
		list.add("Doctor Zhivago","comedy", 4,23000);
		list.add("The Deer Hunter", "Family", 3, 2345);
		System.out.println("Here is the list of the movies\n");
		System.out.println(list);
		System.out.println("\nhere is the the movie that was most watched");
		System.out.println(list.mostWatched());
		System.out.println("Here is the list of 5 stars ratings");
		System.out.println(list.getMovie(5));
		System.out.println("removing Reservoir movie");
		list.remove("Reservior Dogs");
		System.out.println(list);
		System.out.println("Displaying the second movie in the list");
		System.out.println(list.get(1));
		System.out.println("adding a movie at position 2");
		list.add(2, "Up", "Carton",3,4500);
		System.out.println(list);
		int i = list.indexOf("Up"); 
		System.out.println("The movie up is in the position " + i); 
	}

} 
// Movie Class
class Movie {
	private String name;
	private	String genre;
	private int ratings;
	private int watched; 
   
   //Constructors
	public Movie(String name, String genre, int ratings, int watched){
		this.name = name;
		this.genre = genre;
		this.ratings = ratings;
		this.watched = watched; 
	}
   //Gets the name of a movie
	String getName(){
		return name;
	}
   
   //Gets the genre of a movie
	String getGenre(){
		return genre;
	}
   
   //Gets the ratings of a movie
	int getRatings(){
		return ratings;
	}
   
   //Gets the amount of people who watched the movie
	int getWatched(){
		return watched;
	}
   
   //Sets the name of the movie
	void setName(String name){
		this.name = name;
	}
   
   //Sets the genre of a movie
	void setGenre(String genre){
		this.genre = genre;
	}
   
   //Sets the ratings of a movie
	void setRatings(int ratings){
		this.ratings = ratings;
	}

   //Sets the amount of people who watched the movie
	void setWatched(int watched){
		this.watched = watched; 
	}
	
   //Displays the movies name, genre, ratings, and views
	public String toString(){
		return name + ", " + genre + ", " + ratings + ", " + watched;
	}
	
	
}

class ListNode {
    
	private Movie m;
	private ListNode next;

	public ListNode(Movie m){
		this.m = m;
	}
   
   //Constructor
	public ListNode(){
		this.m = null;
		this.next = null;
	}

   //Constructor
	public ListNode(Movie m, ListNode next){
		this.m = m;
		this.next = next;
	}
   
	public Movie getMovie(){
		return m;
	}

	public ListNode getNext(){
		return next;
	}

	public void setNext(ListNode next){
		this.next = next;
	}


}

interface List {
	public void add(String name, String genre, int ratings, int watched);
	public void add(int index, String name, String genre, int star, int people);
	public int indexOf(String movieName);
	public void remove(String movieName);
	public int size();
	public String toString();
	public Movie get(int position);
}
class MovieList implements List{
	private ListNode front; 
	public int size = 0;

	//constructors
	public MovieList(){}

	//add movie to the end of the list
	public void add(String name, String genre, int ratings, int watched){
		Movie movie = new Movie(name, genre, ratings, watched);
		if (front == null){
			front = new ListNode(movie);
		} else {
			ListNode cursor = front;

			while (cursor.getNext() != null){
				cursor = cursor.getNext();
			}
			cursor.setNext(new ListNode (movie)); 
		}
	} 

	//adds the movie at the given index 
	public void add(int index, String name, String genre, int ratings, int watched){
		Movie movie = new Movie(name, genre, ratings,  watched); 
		ListNode newNode = new ListNode(movie);

		if (index == 0){
			newNode.setNext(front);
			front = newNode;
		}
		else {
			ListNode cNode = front;
			int i = 1;
			while (i<index && cNode.getNext() != null) {
				i++;
				cNode = cNode.getNext();
			}
			newNode.setNext(cNode.getNext());
			cNode.setNext(newNode);
		}
	} 
	//returns the movie at the given index 
	public int indexOf(String movieName){
		ListNode current = front;
		int i = 0;

		while (current != null) {
			if (current.getMovie().getName().equals(movieName)) {
				return i;
			}
			i++;
			current = current.getNext();
		}
		return -1;

	} 

	//removes the movie from the list 
	public void remove(String movieName){
		if (front == null){
			return;
		}
		else if (front.getMovie().getName().equals(movieName)) {
			front = front.getNext();
		}
		else {
			ListNode current = front.getNext();
			ListNode prev = front;
			while(current != null) {
				if (current.getMovie().getName().equals(movieName)) {
					prev.setNext(current.getNext());
				}
				prev = current;
				current = current.getNext();
			}
		}
	} 
	//returns the size of the list 
	public int size(){ 
		ListNode cursor = front;
		int size = 0;
		while (cursor != null){
			size += 1;
			cursor = cursor.getNext(); 
		}
		return size; 
	} 

	//create a string from all the movies in the list 
	public String toString(){
		
		ListNode current = front;
		String movies = "";
		while(current != null){
			movies += current.getMovie().toString() + "\n";
			current = current.getNext();
		}
		
		return movies;
	} 

	//returns the movie at the given index 
	public Movie get(int pos){
		int count = 0;
		ListNode current = front;
		Movie m = null;
		while(current != null){
			
			if(count == pos){
				return current.getMovie();
			}
			
			count++;
			current = current.getNext();
		}
		
		return m;
	} //returns the list of the movie with the give star 
	public String getMovie(int star){
		
		ListNode current = front;
		String movies = "";
		while(current != null){
			if(current.getMovie().getRatings() == star){
				movies += current.getMovie().toString() + "\n";
			}
			
			current = current.getNext();
		}
		
		return movies;
		
		
	} 

	//return the movie with the max number of peopel watched. 
	public Movie mostWatched(){
		ListNode current = front;
		Movie m = null;
		int max = current.getMovie().getWatched();
		while(current != null){
			if (max < current.getMovie().getWatched()){
				max = current.getMovie().getWatched();
				m = current.getMovie();
			}
			current = current.getNext();
		}
		
		return m;
	} 
}

