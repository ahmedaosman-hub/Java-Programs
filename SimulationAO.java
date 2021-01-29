/*
 * Name:       Ahmed Osman
 *
 * Course:     CS-12, Spring 2020
 *
 * Date:       05/17/20
 *
 * Filename:   SimulationAO.java
 * 
 * Purpose:    To set up a traffic simulation and determine the quickest driving time between point A and B.
 */
public class SimulationAO {
    public static void main(String [] args) {
    
        // sets up data and objects
        int HOUR_TO_MIN = 60;
        double [] distanceFreeway = {4.7,5.3}; // array for segment distances of the freeway 
        double [] distanceCity = {3.4,4.1,2.5}; // array for segment distances of the city
        double cityLength = 0.0;               // starting point of the city travel segments
        double freewayLength = 0.0;            // starting point of the freeway travel segments
        String fastestRoute;                   // variable for the fastest route calculations
        int freewayFastest = 0;                // starting point for the freeway fastest route
        int cityFastest = 0;                   // starting point for the city fastest route
        int tiedFastest = 0;                   // starting point for the tied route
        
        // array declarations 
        int [] speedRangeFreeway;  // array for average speed range for the freeway
        int [] speedRangeCity;     // array for average speed range for the city
        int [] speedFreeway1;      // first array for random speed of the freeway
        int [] speedFreeway2;      // second array for random speed of the freeway
        int [] speedCity1;         // first array for random speed of the city
        int [] speedCity2;         // second array for random speed of the city
        int [] speedCity3;         // third array for random speed of the city
        double [] timeFreeway1;       // first array for segment travel times of the freeway
        double [] timeFreeway2;       // second array for segment travel times of the freeway
        double [] timeCity1;          // first array for segment travel times of the city
        double [] timeCity2;          // second array for segment travel times of the city
        double [] timeCity3;          // third array for segment travel times of the city
        double [] travelFreeway;      // array for the total travel time of the freeway
        double [] travelCity;         // array for the total travel time of the city
        speedRangeFreeway = new int[2];  // array for the input of the freeway speeds
        speedRangeCity = new int [2];    // array for the input of the city speeds


        // asks the user input for how many simulations will be run
        int size = UtilsAO.readInt("How many simulation iteration: ", false);
        speedRangeFreeway[0] = UtilsAO.readInt("Average freeway speed (MPH min)? > ", false);
        speedRangeFreeway[1] = UtilsAO.readInt("Average freeway speed (MPH max)? > ", false);
        speedRangeCity[0] = UtilsAO.readInt("Average city speed (MPH min)? > ", false);
        speedRangeCity[1] = UtilsAO.readInt("Average city speed (MPH max)? > ", false);
        
        // memory allocations for the arrays    
        speedFreeway1 = new int [size];
        speedFreeway2 = new int [size];
        speedCity1 = new int [size];
        speedCity2 = new int [size];
        speedCity3 = new int [size];
        timeFreeway1 = new double [size];
        timeFreeway2 = new double [size];
        timeCity1 = new double [size]; 
        timeCity2 = new double [size];
        timeCity3 = new double [size];
        travelFreeway = new double [size];
        travelCity = new double [size];
    
        // for loop 1: Calculate the speed ranges, the time it takes for each segment, and the overall time
        for (int i = 0; i < size ; i++){
        
            // Calculate the speed ranges
            speedFreeway1 [i] = UtilsAO.randomInt(speedRangeFreeway[0], speedRangeFreeway [1]);
            speedFreeway2 [i] = UtilsAO.randomInt(speedRangeFreeway[0], speedRangeFreeway [1]);
            speedCity1 [i] = UtilsAO.randomInt(speedRangeCity[0], speedRangeCity [1]);
            speedCity2 [i] = UtilsAO.randomInt(speedRangeCity[0], speedRangeCity [1]);
            speedCity3 [i] = UtilsAO.randomInt(speedRangeCity[0], speedRangeCity [1]);
            
            // The times it takes for each segment 
            timeFreeway1 [i] = (distanceFreeway [0] / speedFreeway1 [i]) * HOUR_TO_MIN; 
            timeFreeway2 [i] = (distanceFreeway [1] / speedFreeway2 [i]) * HOUR_TO_MIN;
            
            timeCity1 [i] = (distanceCity [0] / speedCity1 [i]) * HOUR_TO_MIN;
            timeCity2 [i] = (distanceCity [1] / speedCity2 [i]) * HOUR_TO_MIN;
            timeCity3 [i] = (distanceCity [2] / speedCity1 [i]) * HOUR_TO_MIN;
    
            // The total calculations of the time
            travelFreeway [i] = timeFreeway1 [i] + timeFreeway2 [i];
            travelCity [i] = timeCity1 [i] + timeCity2 [i] + timeCity3 [i];
           
        }
        
        System.out.println();
        
        // Displays how many simulations will be run
        for (int i = 0; i < size; i++) {  
        
        // if i is less than size the run will continue displaying the message
        System.out.println("performing simulation for iteration    " + (i + 1) + "..." );
        }
    
        // Output display and header
        System.out.println();
        System.out.println("=============================================");
        System.out.println("TRAFFIC SIMULATION FOR 3 ITERATIONS");
        System.out.println("=============================================\n");
        System.out.println("LEGEND:    s=speed [MPH], t=time T= total time [mins] // f = freeway, c=city // #=iteration or segment\n");
        System.out.println("###  sc1   tc1 sc2   tc2 sc3   tc3    sf1   tf1 sf2   tf2    Tcity   Tfwy fastest route");
        System.out.println("===  === ===== === ===== === =====    === ===== === =====    =====  ===== =============");
    
        // if i is less than size the calculations will continue running
        for ( int i = 0; i < size ; i++){ 
            
            // if freeway takes longer the city route will be displayed
            if (travelFreeway [i] > travelCity [i]){  
                fastestRoute = "   city faster";
                cityFastest++;
        }
        
        // if city takes longer the freeway route will be displayed
        else if (travelCity [i] > travelFreeway [i]) {  
            fastestRoute = " freeway faster";
            freewayFastest++;
        }
        
        // otherwise it is a toss up
        else{  
            fastestRoute = "    toss up";
            tiedFastest++; 
        }
        // Prints all the results using a format 
        System.out.printf("  %d%5d%6.2f%4d%6.2f%4d%6.2f%7d%6.2f%4d%6.2f%9.2f%7.2f%2s \n" , i + 1, speedCity1 [i] , timeCity1 [i] , speedCity2 [i], timeCity2 [i], speedCity3 [i], timeCity3 [i], speedFreeway1 [i], timeFreeway1 [i], speedFreeway2 [i], timeFreeway2 [i], travelCity [i], travelFreeway [i], fastestRoute);
        
        }     
    
        // Displays the summary reports
        System.out.println();
        System.out.println("=============================================");
        System.out.println("OVERALL SUMMARY OF RESULTS");
        System.out.println("=============================================");
        System.out.println();
        
        // Displays the travel segments 
        System.out.print("   city travel segments [miles]: ");
        
        // if i is less than distanceCity.length then we will display the city travel segments
        for (int i = 0; i < distanceCity.length ; i++){  
           
            // add the city length to the distance city to get the new length
            cityLength +=  distanceCity [i];
            System.out.printf(" %.1f  ", distanceCity [i]);
        }
    
        System.out.println();
        System.out.print("freeway travel segments [miles]: ");
        
        // if i is less than distanceFreeway.length then we will display the freeway travel segments
        for (int i = 0; i < distanceFreeway.length; i++){  
            
            // adds the freeway length to the distance freeway to get the new length
            freewayLength += distanceFreeway [i];
            System.out.printf(" %.1f ", distanceFreeway [i]);
        while (distanceFreeway.length = 100){
        
        }  
        
        // Display the simulations ran and the range of the speed limits
        System.out.println();
        System.out.println();
        System.out.println(size + " trips taken");
        System.out.println("    " + cityLength + " city miles, speed range " + speedRangeCity [0] + "-" + speedRangeCity [1] + " MPH");
        System.out.println("    " + freewayLength + " fwy miles, speed range " + speedRangeFreeway [0] + "-" + speedRangeFreeway [1] + " MPH"); 
    
        // Displays which route was faster in the simulations
        System.out.println();
        System.out.println("city route faster    " + cityFastest +"/" + size + " times (" + ((double)(cityFastest) / size) * 100 + ")");
        System.out.println(" fwy route faster    " + freewayFastest + "/" + size + " times (" + ((double) (freewayFastest) / size) * 100 + ")" );
        System.out.println("        a toss-up    " + tiedFastest + "/" + size + " times (" + ((double) (tiedFastest) / size) * 100 + ")" );
        }
}   
        