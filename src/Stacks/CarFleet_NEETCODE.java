//Car Fleet
//Solved
//There are n cars traveling to the same destination on a one-lane highway.
//
//You are given two arrays of integers position and speed, both of length n.
//
//position[i] is the position of the ith car (in miles)
//speed[i] is the speed of the ith car (in miles per hour)
//The destination is at position target miles.
//
//A car can not pass another car ahead of it. It can only catch up to another car and then drive at the same speed as the car ahead of it.
//
//A car fleet is a non-empty set of cars driving at the same position and same speed. A single car is also considered a car fleet.
//
//If a car catches up to a car fleet the moment the fleet reaches the destination, then the car is considered to be part of the fleet.
//
//Return the number of different car fleets that will arrive at the destination.
//
//Example 1:
//
//Input: target = 10, position = [1,4], speed = [3,2]
//
//Output: 1
//Explanation: The cars starting at 1 (speed 3) and 4 (speed 2) become a fleet, meeting each other at 10, the destination.
//
//Example 2:
//
//Input: target = 10, position = [4,1,0,7], speed = [2,2,1,1]
//
//Output: 3
//Explanation: The cars starting at 4 and 7 become a fleet at position 10. The cars starting at 1 and 0 never catch up to the car ahead of them. Thus, there are 3 car fleets that will arrive at the destination.
//
//Constraints:
//
//n == position.length == speed.length.
//1 <= n <= 1000
//0 < target <= 1000
//0 < speed[i] <= 100
//0 <= position[i] < target
//All the values of position are unique.

package Stacks;

import java.util.Arrays;
import java.util.Stack;

class Car implements Comparable<Car>{
    int position;
    int speed;

    @Override
    public String toString(){
        StringBuilder str= new StringBuilder("[");
        str.append(position).append(",").append(speed).append("]");
        return str.toString();
    }
    @Override
    public int compareTo(Car c){
        return c.position-this.position;
    }

    public Car(int post, int speed){
        this.position=post;
        this.speed=speed;
    }

}
public class CarFleet_NEETCODE {

        public static int carFleet(int target, int[] position, int[] speed) {
            Car [] cars= new Car[position.length];
            for(int i =0;i<cars.length;i++){
                cars[i]= new Car(position[i],speed[i]);
            }
            Arrays.sort(cars);
            Stack<Car> stk = new Stack<>();
            for(int i =0;i<cars.length;i++){
                if(stk.isEmpty()){
                    stk.push(cars[i]);
                }else{
                    float currCarTime=getTime(cars[i],target);
                    float aheadCar=getTime(stk.peek(),target);
                    if(currCarTime>aheadCar){
                        stk.push(cars[i]);
                    }
                }
            }
            return stk.size();
        }

        public static float getTime(Car c, int target){
            float distance = target-c.position;
            float time= distance/c.speed;
            return time;
        }


    public static void main(String[] args) {
        //Example 1:

        int  target1 = 10;
        int [] position1 = {1,4}, speed1 = {3,2};
        int output1=1;

        //Example 2:

        int  target2 = 10;
        int [] position2 = {4,1,0,7}, speed2 = {2,2,1,1};
        int output2=3;

        int ans1= carFleet(target1,position1,speed1);
        int ans2= carFleet(target2,position2,speed2);

        if(ans1==output1) {
            System.out.println("Case 1 Passed ");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Excepted Output : "+ output1);
            System.out.println("Your Output : "+ ans1);
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed ");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Excepted Output : "+ output2);
            System.out.println("Your Output : "+ ans2);
        }

    }
}
