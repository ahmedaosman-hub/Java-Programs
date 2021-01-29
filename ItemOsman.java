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
 
 
class ItemOsman {
	String barcode;
	double price;
	String name;
	int quantity; 
	boolean ship; 

	public ItemOsman (String barcode, double price, String name, int quantity, boolean ship) {
		this.barcode = barcode;
		this.price = price;
		this.name = name;
		this.quantity = quantity; 
		this.ship = ship;
	}

	public ItemOsman(){
		barcode = null;
		price = 0;
		quantity = 0;
		ship = false; 
	}

	public String getBarcode(){
		return barcode;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public boolean getShip() {
		return ship;
	}

	public void setBarcode(String bar){
		bar = barcode;
	}

	public void setPrice(double p){
		p = price;
	}

	public void setQuantity(int q){
		q = quantity;
	}

	public void setShip(boolean s){
		s = ship;
	}

	public boolean equals(ItemOsman other){
		return this.barcode.equals(other.barcode);
	}

	public String toString(){
		if(ship){
			return name + ", " + "quantitiy = " + quantity + ", price = " + price + ", this item can be shipped";

		}else{
			return name + ", " + "quantitiy = " + quantity + ", price = " + price + ", this item cannot be shipped";

		}
	}

	public double getCost(){
		return price * quantity;
	} 
}

class OnLineItem extends ItemOsman{

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

	public double getWeight(){
		return weight;
	}
	public void setWeight(double w){
		weight = w;
	}

	public boolean equals(OnLineItem other){
		return super.equals(other);
	}

	public String toString(){

		String s = super.toString();
		return s;

	}

	public double getShippingCost(){
		double shippingCost = weight * SHIP_RATE * getQuantity();
		return shippingCost;

	}

	public double getTotalCost(){
		return getCost() + getShippingCost();
	}

}
public class Driver{
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

