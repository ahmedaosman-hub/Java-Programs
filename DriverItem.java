/*
 * Name:       Ahmed Osman
 *
 * Course:     CS-13, Fall 2020
 *
 * Date:       09/ 26 /2020
 *
 * Filename:   Driver.java
 * 
 * Purpose:    Creating an online store that calculates the prices, shipping costs and total costs for customers.
 */
 
 
class ItemOsman {
	String barcode;
	double price;
	String name;
	int quantity; 
	boolean ship; 

   // sets the order of items
	public ItemOsman (String barcode, double price, String name, int quantity, boolean ship) {
		this.barcode = barcode;
		this.price = price;
		this.name = name;
		this.quantity = quantity; 
		this.ship = ship;
	}

   //initializing the variables 
	public ItemOsman(){
		barcode = null;
		price = 0;
		quantity = 0;
		ship = false; 
	}

   // getst the item
	public String getBarcode(){
		return barcode;
	}

   //gets the price
	public double getPrice() {
		return price;
	}

   // gets amount in quantity
	public int getQuantity() {
		return quantity;
	}

   // gets shipping
	public boolean getShip() {
		return ship;
	}

   // finds out the item
	public void setBarcode(String bar){
		bar = barcode;
	}

   //sets the price 
	public void setPrice(double p){
		p = price;
	}
   
   //sets the quantity amount
	public void setQuantity(int q){
		q = quantity;
	}
   
   // setst the shipping rate
	public void setShip(boolean s){
		s = ship;
	}

	public boolean equals(ItemOsman other){
		return this.barcode.equals(other.barcode);
	}
   
   
   //string that gets called in the output
	public String toString(){
		if(ship){
			return name + ", " + "quantitiy = " + quantity + ", price = " + price + ", this item can be shipped";

		}else{
			return name + ", " + "quantitiy = " + quantity + ", price = " + price + ", this item cannot be shipped";

		}
	}
   
   //calculates the cost of each items
	public double getCost(){
		return price * quantity;
	} 
}

class OnLineItem extends ItemOsman{
   
   //initializing our variables
	public static final int SHIP_RATE = 3;
	private double weight;
   
	public OnLineItem( String barcode, double price, String name, int quantity, boolean ship, double weight){
		super(barcode, price,name,quantity,ship);
		this.weight = weight;

	} 

	public OnLineItem(){
		super();
		this.weight = 0;
	}

   // gets tthe weight of the item
	public double getWeight(){
		return weight;
	}
   
   //setst the weight of the item 
	public void setWeight(double w){
		weight = w;
	}
   
   
	public boolean equals(OnLineItem other){
		return super.equals(other);
	}
   
   // displays out string
	public String toString(){

		String s = super.toString();
		return s;

	}
   
   //calculates the shipping cost by weight
	public double getShippingCost(){
		double shippingCost = weight * SHIP_RATE * getQuantity();
		return shippingCost;

	}

   // calculates the total cost after shipping and retail
	public double getTotalCost(){
		return getCost() + getShippingCost();
	}

}

// Driver or main method to test out our output.
public class DriverItem{
	public static void main(String[] args){
		System.out.println("welcome to my online shopping store");
		System.out.println();
		OnLineItem soap = new OnLineItem("", 5, "Soap", 3, true, 2);
		OnLineItem notebook = new OnLineItem("", 5, "Note book", 2, false, 2);
		OnLineItem lamp = new OnLineItem("", 2, "Lamp", 2, true, 2);
		
		System.out.println(soap);
		System.out.println("Shipping Cost: " + soap.getShippingCost());
		System.out.println("Total Cost: " + soap.getTotalCost());
		System.out.println();
		System.out.println(notebook);
		System.out.println("Shipping Cost: " + notebook.getShippingCost());
		System.out.println("Total Cost: " + notebook.getTotalCost());
		System.out.println();
		System.out.println(lamp);
		System.out.println("Shipping Cost: " + notebook.getShippingCost());
		System.out.println("Total Cost: " + notebook.getTotalCost());
		System.out.println();
		System.out.println("Your total cost is: " +(soap.getTotalCost()+notebook.getTotalCost()+notebook.getTotalCost()));
	}
}

