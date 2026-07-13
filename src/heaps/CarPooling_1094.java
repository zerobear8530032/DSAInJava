//1094. Car Pooling
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).
//
//You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.
//
//Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.
//
//
//
//Example 1:
//
//Input: trips = [[2,1,5],[3,3,7]], capacity = 4
//Output: false
//Example 2:
//
//Input: trips = [[2,1,5],[3,3,7]], capacity = 5
//Output: true
//
//
//Constraints:
//
//1 <= trips.length <= 1000
//trips[i].length == 3
//1 <= numPassengersi <= 100
//0 <= fromi < toi <= 1000
//1 <= capacity <= 105
package heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

class Trip{
    int from;
    int passengers;
    int to;

    public Trip(int passengers, int from , int to){
        this.from=from;
        this.to=to;
        this.passengers=passengers;
    }

    public String toString(){
        return "[ passengers : "+passengers+" , from : "+from+" , to : "+to+"]";
    }

}


public class CarPooling_1094 {
    public static boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<Trip> waiting = new PriorityQueue<>((t1, t2)->t1.from-t2.from);
        PriorityQueue<Trip> ongoing = new PriorityQueue<>((t1,t2)->t1.to-t2.to);
        int time =0;
        int currCapacity =0;
        for(int [] trip:trips){
            Trip t= new Trip(trip[0],trip[1],trip[2]);
            waiting.add(t);
        }
        while(!waiting.isEmpty() ||  !ongoing.isEmpty()){
            while(!ongoing.isEmpty() && time==ongoing.peek().to){
                Trip trip=ongoing.poll();
                currCapacity-=trip.passengers;
            }

            while(!waiting.isEmpty() && time==waiting.peek().from){
                Trip trip = waiting.poll();
                if(currCapacity+trip.passengers<=capacity){
                    ongoing.add(trip);
                }else{
                    return false;
                }
                currCapacity+=trip.passengers;
            }
            time++;
        }
        return true;
    }
    public static void main(String[] args) {

        //Example 1:

        int [][] trips1 = {{2,1,5},{3,3,7}};
        int capacity1 = 4;
        boolean output1= false;

        //Example 2:

        int [][] trips2 = {{2,1,5},{3,3,7}};
        int capacity2 = 5;
        boolean output2=true;

        boolean ans1= carPooling(trips1,capacity1);
        boolean ans2= carPooling(trips2,capacity2);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+output1);
            System.out.println("Your Answer :"+ans1);
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+output2);
            System.out.println("Your Answer :"+ ans2);
        }
    }
}
