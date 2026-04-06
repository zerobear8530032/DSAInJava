//874. Walking Robot Simulation
//Medium
//Topics
//premium lock icon
//Companies
//A robot on an infinite XY-plane starts at point (0, 0) facing north. The robot receives an array of integers commands, which represents a sequence of moves that it needs to execute. There are only three possible types of instructions the robot can receive:
//
//-2: Turn left 90 degrees.
//-1: Turn right 90 degrees.
//1 <= k <= 9: Move forward k units, one unit at a time.
//Some of the grid squares are obstacles. The ith obstacle is at grid point obstacles[i] = (xi, yi). If the robot runs into an obstacle, it will stay in its current location (on the block adjacent to the obstacle) and move onto the next command.
//
//Return the maximum squared Euclidean distance that the robot reaches at any point in its path (i.e. if the distance is 5, return 25).
//
//Note:
//
//There can be an obstacle at (0, 0). If this happens, the robot will ignore the obstacle until it has moved off the origin. However, it will be unable to return to (0, 0) due to the obstacle.
//North means +Y direction.
//East means +X direction.
//South means -Y direction.
//West means -X direction.
//
//
//Example 1:
//
//Input: commands = [4,-1,3], obstacles = []
//
//Output: 25
//
//Explanation:
//
//The robot starts at (0, 0):
//
//Move north 4 units to (0, 4).
//Turn right.
//Move east 3 units to (3, 4).
//The furthest point the robot ever gets from the origin is (3, 4), which squared is 32 + 42 = 25 units away.
//
//Example 2:
//
//Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//
//Output: 65
//
//Explanation:
//
//The robot starts at (0, 0):
//
//Move north 4 units to (0, 4).
//Turn right.
//Move east 1 unit and get blocked by the obstacle at (2, 4), robot is at (1, 4).
//Turn left.
//Move north 4 units to (1, 8).
//The furthest point the robot ever gets from the origin is (1, 8), which squared is 12 + 82 = 65 units away.
//
//Example 3:
//
//Input: commands = [6,-1,-1,6], obstacles = [[0,0]]
//
//Output: 36
//
//Explanation:
//
//The robot starts at (0, 0):
//
//Move north 6 units to (0, 6).
//Turn right.
//Turn right.
//Move south 5 units and get blocked by the obstacle at (0,0), robot is at (0, 1).
//The furthest point the robot ever gets from the origin is (0, 6), which squared is 62 = 36 units away.
//
//
//
//Constraints:
//
//1 <= commands.length <= 104
//commands[i] is either -2, -1, or an integer in the range [1, 9].
//0 <= obstacles.length <= 104
//-3 * 104 <= xi, yi <= 3 * 104
//The answer is guaranteed to be less than 231.
package HashSet;

import java.util.Arrays;
import java.util.HashSet;

public class WalkingRobotSimulation_874  {
//    we can simulate the process using  a hashset as grid where we create a inital robot position
//    and move it up down left right , we can maintian a hahsset to check obstacles
//    as string of position "x,y" this allow us to stop when the obstact encounter other wise move
//    time complexity : O(n)
//    space complexity : O(obstacles)
    public static int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> set = new HashSet();
        char [] directions = {'N','E','S','W'};
        int dir=0;
        int [] pos={0,0};
        System.out.println(Arrays.toString(pos));
        System.out.println(directions[dir]);
        int res=0;
        for(int [] pairs:obstacles){
            set.add(pairs[0]+","+pairs[1]);
        }
        for(int x:commands){
            if(x==-1){
                if(dir==0 || dir ==1 || dir ==2 ){dir++;}
                else{dir=0;}
            }else  if(x==-2){
                if(dir==3 || dir ==1 || dir ==2 ){dir--;}
                else{dir=3;}
            }else{
                move(pos,directions[dir],x,set);
                res= Math.max((pos[0]*pos[0])+(pos[1]*pos[1]),res);
                System.out.println(directions[dir]);
                System.out.println("REs "+res);
            }
        }
        return res;
    }
    public static int [] move(int [] pairs,char dir,int steps,HashSet<String> set ){
        if(dir == 'N'){
            for(int i =1;i<=steps;i++){
                String key =(pairs[0])+","+(pairs[1]+1);
                if(set.contains(key)){
                    break;
                }else{
                    pairs[1]++;
                }
            }
        }else if(dir == 'S'){
            for(int i =1;i<=steps;i++){
                String key =(pairs[0])+","+(pairs[1]-1);
                if(set.contains(key)){
                    // System.out.println("obstacle at "+key);
                    break;
                }else{
                    pairs[1]--;
                }
            }
        }else if(dir == 'E'){
            for(int i =1;i<=steps;i++){
                String key =(pairs[0]+1)+","+(pairs[1]);
                if(set.contains(key)){
                    // System.out.println("obstacle at "+key);
                    break;
                }else{
                    pairs[0]++;
                }
            }
        }else{
            for(int i =1;i<=steps;i++){
                String key =(pairs[0]-1)+","+(pairs[1]);
                if(set.contains(key)){
                    // System.out.println("obstacle at "+key);
                    break;
                }else{
                    pairs[0]--;
                }
            }
        }
        System.out.println(Arrays.toString(pairs));
        return pairs;
    }
    public static void main(String[] args) {
        //Example 1:

        int []commands1 = {4,-1,3};
        int [][] obstacles1 = {};
        int output1= 25;

        //Example 2:

        int []commands2 = {4,-1,4,-2,4};
        int [][] obstacles2 = {{2,4}};
        int output2= 65;

        //Example 3:

        int []commands3 = {6,-1,-1,6};
        int [][] obstacles3 = {{0,0}};
        int output3= 36;
        System.out.println("a1");
        int ans1 = robotSim(commands1,obstacles1);
        System.out.println("a2");
        int ans2 = robotSim(commands2,obstacles2);
        System.out.println("a3");
        int ans3 = robotSim(commands3,obstacles3);

        if(output1==(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2==(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }
        if(output3==(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output :"+ output3);
            System.out.println("Your Answer :"+ ans3);
        }
    }
}
