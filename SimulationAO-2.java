public class SimulationAO {
    public static void main(String [] args) {
    
    int HOUR_TO_MIN = 60;
    double [] distanceFreeway = {4.7,5.3}; // array for segment distances of the freeway 
    double [] distanceCity = {3.4,4.1,2.5}; // array for segment distances of the city
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
   
    // user inputs
    int size = UtilsAO.readInt("How many simulation iteration: ", false);

    //allocate memory for this array 
    speedRangeFreeway = new int[2];  
        speedRangeFreeway[0] = UtilsAO.readInt("Average freeway speed (MPH min)? > ", false);
        speedRangeFreeway[1] = UtilsAO.readInt("Average freeway speed (MPH max)? > ", false);
      
    speedRangeCity = new int [2];
        speedRangeCity[0] = UtilsAO.readInt("Average city speed (MPH min)? > ", false);
        speedRangeCity[1] = UtilsAO.readInt("Average city speed (MPH max)? > ", false);
   
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
    
    // array instantiations 
      
    
    // for loop 1:
    for (int i = 0; i < size ; i++){
        speedFreeway1 [i] = UtilsAO.randomInt(speedRangeFreeway[0], speedRangeFreeway [1]);
        speedFreeway2 [i] = UtilsAO.randomInt(speedRangeFreeway[0], speedRangeFreeway [1]);
        speedCity1 [i] = UtilsAO.randomInt(speedRangeCity[0], speedRangeCity [1]);
        speedCity2 [i] = UtilsAO.randomInt(speedRangeCity[0], speedRangeCity [1]);
        speedCity3 [i] = UtilsAO.randomInt(speedRangeCity[0], speedRangeCity [1]);
        
        timeFreeway1 [i] = (distanceFreeway [0] / speedFreeway1 [i]) * HOUR_TO_MIN; 
        timeFreeway2 [i] = (distanceFreeway [1] / speedFreeway2 [i]) * HOUR_TO_MIN;
        
        timeCity1 [i] = (distanceCity [0] / speedCity1 [i]) * HOUR_TO_MIN;
        timeCity2 [i] = (distanceCity [1] / speedCity2 [i]) * HOUR_TO_MIN;
        timeCity3 [i] = (distanceCity [2] / speedCity1 [i]) * HOUR_TO_MIN;

        travelFreeway [i] = timeFreeway1 [i] + timeFreeway2 [i];
        travelCity [i] = timeCity1 [i] + timeCity2 [i] + timeCity3 [i];
       
    }
    // simulation calcs
    
    // output labeling
    
    // for loop 2: 
    // output data display 
    System.out.println("=============================================");
    System.out.println("TRAFFIC SIMULATION FOR 3 ITERATIONS");
    System.out.println("=============================================");
    System.out.println("LEGEND: s=speed [MPH], t=time T= total time [mins] // f = freeway, c=city // #=iteration or segment");
    System.out.println("### sc1  tc1 sc2  tc2 sc3  tc3    sf1  tf1 sf2  tf2   Tcity  Tfwy fastest route");
    System.out.println("=== === ==== === ==== === ====    === ==== === ====   ===== ===== =============");
    
 
    
   for (int i = 0; i < size ; i++){
  
  //here start printing the stuff in a printf statement 
       if ( travelFreeway [i] > travelCity [i]) {
       System.out.println("Free");
       }
       else
       System.out.println("City");
       }
       System.out.printf("#1 %d	%.2f	%d	%.2f	%d	%.2f      	%d	%.2f	%d	%.2f		%.2f	%f %s",speedCity1 [i] , timeCity1 [i] , speedCity2 [i], timeCity2 [i], speedCity3 [i], timeCity3 [i], speedFreeway1 [i], timeFreeway1 [i], speedFreeway2 [i], timeFreeway2 [i], travelCity [i], travelFreeway [i]);
    }

    // summary reporting
    }  
