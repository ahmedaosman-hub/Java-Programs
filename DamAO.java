
/*
 * Name:       Ahmed Osman
 *
 * Course:     CS-12, Spring 2020
 *
 * Date:       04/25/2020 
 *
 * Filename:   DamAO.java
 * 
 * Purpose:    Class implemented to calculate storage, capacity, and other features of a dam. Must have CS12Date and UtilsAO in the directory. 
 */

public class DamAO {
       
    // instance variables----------------
    private String name;    // Dam's name
    private int year;       // Dam's created year
    private double storage;    // Dam's storage amount
    private double capacity;   // Dam's capacity 
    private double inflow;     // Dam's inflow
    private double outflow;    // Dam's outflow
    private CS12Date date;     // Target date (Will be today's date)
    // constants-------------------------
    
    // other class data------------------
    
    // data above here
    
    // ==================================
    // methods below here
    
    // constructors----------------------
    
    // "1st" dam, will set the instance variables in their default state
    public DamAO(){           
		this.name = "<default dam>";
        this.year = 1900;
        this.storage = 0;
        this.capacity = 0;
        this.inflow = 0;
        this.outflow = 0;
        this.date = UtilsAO.today();
        
    }
    
    // full constructor, "2nd" Dam, will change all the instance variables and output them
    public DamAO(String name, 
                int year, 
                double storage, 
                double capacity, 
                double inflow,
                double outflow, 
                CS12Date date) { 
                
        setName(name);
        setYear(year);
        setCapacity(capacity);
        setStorage(storage);
        setInflow(inflow);
        setOutflow(outflow);
        setDate(date);

    }
    
    // "3rd" Dam, will change the name and year to dam 2 and 1963
    public DamAO(String name, int year){    
        this(); // will set all the instance variable to default values
        setName(name); // will change the name from the default value
        setYear(year); // will change the year from the default value

    }
    
    // "4th" Dam, will change the name and capacity of the dam to dam 3 and 10000.0
    public DamAO(String name, double capacity){ 
        this(); // will set all the instance variable to default values
        setName(name); // will change the name from the default value
        setCapacity(capacity);
    
    }
    
    // display methods-------------------
    
    // this method will change the output near the header 
    public String toString() {  
        return String.format("%s%9d%,10.0f%,12.0f%,7.0f%,11.0f%16s", name , year, storage, capacity, inflow, outflow, date ); 
            
    }
    
    // Will help format our output.
    public void print() {
        System.out.printf("%-25s%s%n", "name:", name);
        System.out.printf("%-25s%d%n", "year opened:", year);
        System.out.printf("%-25s%s%n", "date as of:" ,  date.toString());
        System.out.printf("%-25s%,.0f%n", "storage [acre-ft]:" , storage);
        System.out.printf("%-25s%,.0f%n", "capacity [acre-ft]:" , capacity);
        System.out.printf("%-25s%,.0f%n", "inflow [cu-ft/s]:" , inflow);
        System.out.printf("%-25s%,.0f%n", "outflow [cu-ft/s]:" , outflow); 
        System.out.printf("%-25s%d%n", "age [yrs]:", getAge());
        System.out.printf("%-25s%s%n", "status:" , getStatus());
        System.out.printf("%-25s%,.1f %%%n", "% full:", getPercentFull());
        System.out.printf("%-25s%d%n", "days until dam event:", getEventDays());
        System.out.printf("%-25s%s%n", "date of dam event:" , getEventDate());
    }
    
    // will print the equal sign barriers so that the user can know the title
    public void print(String message) {
      	for (int i = 0; i < message.length(); i++)
        	System.out.print("=");
      
      	System.out.println();
        System.out.println(message);
      
        for (int i = 0; i < message.length(); i++)
        	System.out.print("=");
      
        System.out.println();
        print();
        
    }
    
    // accessors, mutators---------------
    
    // Will return the name of the dam
    public String getName(){ 
        return this.name;
        
    }
  
    // Will get the open year of the dam
    public int getYear(){ 
        return this.year;
        
    }
    
    // Will get the storage amount
    public double getStorage(){      
        return this.storage;
        
    }
    
    // Will get the capacity amount
    public double getCapacity(){      
        return this.capacity;
        
    }
    
    // Will get the inflow amount
    public double getInflow(){      
        return this.inflow;
        
    }
    
    // Will get the outflow amount
    public double getOutflow(){      
        return this.outflow;
        
    }
    
    // Will get today's date
    public CS12Date getDate(){  
        return new CS12Date(this.date.getText());
        
    }
    
    // mutator
    
    // The method sets the name to a new value
    public void setName(String name){ 
        this.name = name;
        
    }
    // The method prompt the user for a new name and change the name
    public void setName(boolean mode) { 
        String data = UtilsAO.readString("Enter dam name: ", mode);
        setName(data);
        
    }
    
    // The method sets the year to a new value
    public void setYear(int year){
        if (year < 1900) {
            System.out.println("ERROR: year must be >= 1900, value unchanged");
        }
        else {
        	this.year = year;
        }
        
    }
    
    // The method prompts the user for a new year and change the year
    public void setYear(boolean mode){ 
        int data = UtilsAO.readInt("Enter dam opening year: ", mode);
        setYear(data);
        
    }
    
    // The method will set the storage to a new value
    public void setStorage(double storage){  
        if (storage > capacity) {
            System.out.println("ERROR: storage must be <= capacity, value unchanged");
        }
        else if (storage < 0) {
            System.out.println("ERROR: storage must be >= 0 acre-feet, value unchanged");
        }
        else
            this.storage = storage;
        
    }
    
    // The method will prompt the user for a new storage amount and change that storage
    public void setStorage(boolean mode){   
        double data = UtilsAO.readDouble("Enter current dam water storage [acre-ft]: ", mode);
        setStorage(data);
        
    }
    
    // The method will set the capacity of the dam to a new value
    public void setCapacity(double capacity){  
        if (capacity < 0) {
            System.out.println("ERROR: capacity must be >= 0 acre-feet, value unchanged");
        }
        else if (capacity < storage) {
            System.out.println("ERROR: capacity must be >= storage, value unchanged");
        }
        else 
            this.capacity = capacity;
        
    }
    
    // The method will ask the user for the dam's capacity and change it to that amount  
    public void setCapacity(boolean mode){      
        double data = UtilsAO.readDouble("Enter current dam water capacity [acre-ft] > ", mode);
        setCapacity( data );
        
    }
  
    // The method will set the inflow of the dam to a new value
    public void setInflow(double inflow){       
        if (inflow < 0) {
            System.out.println("ERROR: inflow must be >= 0 cu-ft/sec, value unchanged");
        }
        else
            this.inflow = inflow;
        
    }
    
    // the method will ask the user for the dam's inflow and change it to that amount
    public void setInflow(boolean mode){       
        double data = UtilsAO.readDouble("Enter current water inflow rate [cu-ft/sec]: ", mode);
        setInflow(data);
        
    }
    
    // The method will set the outflow of the dam to a new value
    public void setOutflow(double outflow){    
        if (storage == 0) {
            System.out.println("ERROR: storage = 0.0, cannot change outflow, not changed");
        }
        else if (outflow < 0) {
            System.out.println("ERROR: outflow must be >= 0 cu-ft/sec, value unchanged");
        }
        else
            this.outflow = outflow;
        
    }
    
    // The method will ask the user for the dam's outflow and change it to that amount
    public void setOutflow(boolean mode){    
        double data = UtilsAO.readDouble("Enter current water outflow rate [cu-ft/sec]: ", mode);
        setOutflow(data);
        
    }
    
    // The method will set the date for today's date
    public void setDate(CS12Date date){       
        this.date = date; 
        
    }
    
    // The method will ask the user for the measurement date and set it as that date
    public void setDate(boolean mode){                    
        int month = UtilsAO.readInt("Enter the month of the measurements date: ", mode);
        int day = UtilsAO.readInt("Enter day of the measurements date: ", mode);
        int year = UtilsAO.readInt("Enter year of the measurements date: ", mode);
        CS12Date date = new CS12Date(month, day, year);
        setDate (date);
        
    }
 
    // equivalence-----------------------
    
    // Returns a true statement if dam's are equal to themselves
    public boolean equals (Object obj) {    
        if (! (obj instanceof DamAO)){     // Returns a false statement if the dams should not be equal
            return false; 
        }
        else {                           
             DamAO a = (DamAO) obj;
            final double TOL = 0.000001;
            if (a.getName().equals(this.getName()) &&        // if all the variables are equal than return the dam as equal
                a.getYear() == this.getYear() &&
                Math.abs(a.getStorage() - this.getStorage()) < TOL &&
                Math.abs(a.getCapacity() - this.getCapacity()) < TOL &&
                Math.abs(a.getInflow() - this.getInflow()) < TOL &&
                Math.abs(a.getOutflow() - this.getOutflow()) < TOL &&
                a.getDate().equals(this.getDate())) {
         
                return true;
            }
            else {                                  // Otherwise return a false statement
                return false;
                
            }
        }
    }
    // Calculates the "age" of the dam
    public int getAge() {
        return UtilsAO.getAge( new CS12Date(1, 1, getYear()) );
        
    }

    // Explains the three phases of the dam depending on the inflow or outflow
    public String getStatus() {
        String status; 
        if (inflow > outflow) { // declares status as filling if inflow is greater than outflow
          status = ("filling");
        }
        else if (inflow < outflow) {// declares status as emptying if inflow is less than outflow
          status = ("emptying");
        }
        else { // otherwise declares status as holding
          status = ("holding");
        }
        return status;  // returns the status string
    }

    // Gets a percentage of the dam's capacity
    public double getPercentFull() {
        double status;
        if ( capacity > 0.0) { // calculates status is capacity is greater than 0
            status = storage / capacity * 100;
        }
        else { // otherwise sets status as 0
            status = 0.0; 
        }
        return status; // returns the status
    }
    
    // Determines when the dam will reach a certain event
    public int getEventDays() {
        double time = 0;
        final int CUFT_PER_ACREFT = 43560;
        final int SECS_PER_HR = 3600;
        final int HRS_PER_DAY = 24;
        if (inflow > outflow) { // calculates time if inflow is greater than outflow
             time = (capacity - storage) / (inflow - outflow);
        }
        else if ( outflow > inflow) { // calculates time if outflow is greater than inflow
             time = (0 - storage) / (inflow - outflow);
        }
        else { // otherwise sets time as -1
             time = -1;
        }
        return (int) Math.round( time * CUFT_PER_ACREFT / (SECS_PER_HR * HRS_PER_DAY) -0.5); // returns the time as a rounded down number
    }

    // Advances the getEventDays method by a certain number of days
    public CS12Date getEventDate() {
        int days = getEventDays ();
        CS12Date status = new CS12Date(date.getMonth(), date.getDay(), date.getYear());

        if (days == -1) { // if days = -1 add a hundred years
            status.setYear(status.getYear() + 100);
        }
        else { // otherwise return a later date
            status.laterDate(days);
        }
        return status;
    }
     
     // A wrapper method that prompts the 7 mutators for the 7 variables
     public void update(boolean mode) {
        setName(mode);
        setYear(mode);
        setCapacity(mode);
        setStorage(mode);
        setInflow(mode);
        setOutflow(mode);
        setDate(mode);
    }

    // Updates the storage amount if it is greater then the capacity
    public void importWater(double acreFeet) {
        double newStorage = getStorage() + acreFeet;
        
      	if(acreFeet <= 0){  // displays an error if the acreFeet is less than 0
           System.out.println("Error: Input value must be >= 0.0");
        }
      
        else {   // otherwise sets the inputted value as the new storage
          setStorage(newStorage);
        }
      
    }

    // Updates the storage amount if less than the capacity or less then zero
    public void releaseWater(double acreFeet) {
        double newStorage = getStorage() - acreFeet;

        if (acreFeet <= 0) {    // displays an error if acreFeet is less than 0
            System.out.println("Error: Input value must be >= 0.0");  
        } 
        else if ((storage - acreFeet) > capacity || storage - acreFeet < 0) {  // displays an error if the inputed value is less than 0
            System.out.println("Error: you cannot input a value that is less than the capacity.");
        }
        else {    // otherwise sests the input as the new storage
          setStorage(newStorage);
        }
    }

    // Updates the outflow amount if storage is less than 0
    public void increaseOutflow(double cuFtSec) {
        double newOutflow = getOutflow() + cuFtSec;

        if(cuFtSec <= 0) {     // displays an error if cuFtsec is less than or equal to 0
            System.out.println("Error: Input value must be >= 0.0");
        }
        else if(storage < 0) {  // displays an error if storage is less than 0
            System.out.println("Error: You cannot make changes to outflow since storage is less than 0");
        }
        else {        // otherwise sets the input as a new outflow
            setOutflow(newOutflow);
        
        }
    }

    // Updates the outflow amount if the storage is less 0 or outflow is less than 0
    public void decreaseOutflow(double cuFtSec) {
        double newOutflow = getOutflow() - cuFtSec;

        if(cuFtSec <= 0) {            // calculates if cuFtSec is less than or equal to 0 and displays an error method if so
            System.out.println("Error: Input value must be >= 0.0");
        }
        else if(storage < 0) {        // displays an error if storage is less than 0
            System.out.println("Error: You cannot make changes to outflow since storage is less than 0");
        }
         else {        // otherwise set the input as the new outflow
            setOutflow(newOutflow);
        }
    }


    
    
    
    //Main method 
    public static void main(String [] args) {       
        DamAO setRun, defaultDam;                   // Initializing variables
        String test;                                
        CS12Date dateTest;
        
    // Does not change any variables from the default
        setRun = new DamAO();                      // Sets the default variables 
        System.out.println("toString(): " + setRun); // Prints the output and default variables
        setRun.print("Dam created from default constructor: "); //Header
        UtilsAO.pause();                            // Slows down the output and asks user to "enter" 
        
    // Changes all the variables
        setRun = new DamAO("Dam 2", 1967, 23123.3, 343243.9, 231, 45, new CS12Date(1,1,2000)); //Sets these as the variables
        System.out.println("toString(): " + setRun);
        setRun.print("Dam created from full constructor: ");
        UtilsAO.pause();
       
    // Changes the name and year variables
        setRun = new DamAO("Dam 3", 2000);          // Sets the year variable
        System.out.println("toString(): " + setRun); // Prints the output and changes the year variable
        setRun.print("Dam created name/year constructor: "); //Header
        UtilsAO.pause();                             // Slows down the output
        
    // Changes the name and capacity variables
        setRun = new DamAO("Dam 4", 1000000.0 );      //Sets the capacity variables
        System.out.println("toString(): " + setRun);  // Prints the output and changes the capacity
        setRun.print("dam created name/capacity constructor: "); //Header
        UtilsAO.pause();
        
     //=================================================
    
    //Test all accesors and mutators-------------------
        System.out.println("===========================");
        System.out.println("Accessors and mutators");  // Prints the title
        System.out.println("===========================");
        setRun = new DamAO();                          // prepares to use the following inputs as the new variables
       
    // Asks the user for the name variable
        setRun.setName(false);                         
        System.out.println("get: name should be set to:		" + setRun.getName());  
        System.out.println();

    // Asks the user for the year variable
        setRun.setYear(false);
        System.out.println("get: year should be set to:		" + setRun.getYear());  
        System.out.println();

    // Asks the user for the date
        setRun.setDate(false);
        setRun.setDate(setRun.getDate());
        System.out.println("get: date should be set to:		" + setRun.getDate());

    // Asks the user for storage
        setRun.setStorage(false);
        System.out.println("get: storage should be set to:		" + setRun.getStorage());
        System.out.println();

    // Asks the user for the capacity 
        setRun.setCapacity(false);
        System.out.println("get: capacity should be set to:		" + setRun.getCapacity());
        System.out.println();

    // Asks the user for the inflow
        setRun.setInflow(false);
        System.out.println("get: inflow should be set to:    " + setRun.getInflow());     
        System.out.println();

    // asks the user for the outflow
        setRun.setOutflow(false);
        System.out.println("get: outflow should be set to:		" + setRun.getOutflow());
        System.out.println();
        
    //final dam state, updates the dam and prints results
        setRun.print("Updates Dam State");
        UtilsAO.pause();
        System.out.println();

    //==========================================
        System.out.println("===========================");
        System.out.println("Testing for equality...");        // Prints the equality header
        System.out.println("===========================");
        
        // same dam
        System.out.println("Any Dam should equal itself:				" + setRun.equals(setRun));    // Prints the results of the equal method 
        
        // different dams
        defaultDam = new DamAO();
        System.out.println("Any two DIFFERENT Dams should NOT be equal:	" + setRun.equals(defaultDam));    // Prints the results of the equal method
           
        // against other objects
        test = "test string";
        dateTest = new CS12Date();
        System.out.println("A Dam and a String should NOT be equal:		" + setRun.equals(test));           // Prints the results of the equal method
        System.out.println("A Dam and a CS12Date should NOT be equal:	" + setRun.equals(dateTest));       // Prints the results of the equal method
        System.out.println("End Week 12 unit test code for class DamAO");
        
    }// end main
}
   