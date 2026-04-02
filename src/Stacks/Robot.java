//2751. Robot Collisions
//Hard
//Topics
//premium lock icon
//Companies
//Hint
//There are n 1-indexed robots, each having a position on a line, health, and movement direction.
//
//You are given 0-indexed integer arrays positions, healths, and a string directions (directions[i] is either 'L' for left or 'R' for right). All integers in positions are unique.
//
//All robots start moving on the line simultaneously at the same speed in their given directions. If two robots ever share the same position while moving, they will collide.
//
//If two robots collide, the robot with lower health is removed from the line, and the health of the other robot decreases by one. The surviving robot continues in the same direction it was going. If both robots have the same health, they are both removed from the line.
//
//Your task is to determine the health of the robots that survive the collisions, in the same order that the robots were given, i.e. final health of robot 1 (if survived), final health of robot 2 (if survived), and so on. If there are no survivors, return an empty array.
//
//Return an array containing the health of the remaining robots (in the order they were given in the input), after no further collisions can occur.
//
//Note: The positions may be unsorted.
//
//
//
//
//Example 1:
//
//
//
//Input: positions = [5,4,3,2,1], healths = [2,17,9,15,10], directions = "RRRRR"
//Output: [2,17,9,15,10]
//Explanation: No collision occurs in this example, since all robots are moving in the same direction. So, the health of the robots in order from the first robot is returned, [2, 17, 9, 15, 10].
//Example 2:
//
//
//
//Input: positions = [3,5,2,6], healths = [10,10,15,12], directions = "RLRL"
//Output: [14]
//Explanation: There are 2 collisions in this example. Firstly, robot 1 and robot 2 will collide, and since both have the same health, they will be removed from the line. Next, robot 3 and robot 4 will collide and since robot 4's health is smaller, it gets removed, and robot 3's health becomes 15 - 1 = 14. Only robot 3 remains, so we return [14].
//Example 3:
//
//
//
//Input: positions = [1,2,5,6], healths = [10,10,11,11], directions = "RLRL"
//Output: []
//Explanation: Robot 1 and robot 2 will collide and since both have the same health, they are both removed. Robot 3 and 4 will collide and since both have the same health, they are both removed. So, we return an empty array, [].
//
//
//Constraints:
//
//1 <= positions.length == healths.length == directions.length == n <= 105
//1 <= positions[i], healths[i] <= 109
//directions[i] == 'L' or directions[i] == 'R'
//All values in positions are distinct
package Stacks;

import java.util.*;

class Robot implements Comparable<Robot>{
    int position;
    int health;
    char direction;
    int index;

    public Robot(int position, int health, char direction, int index) {
        this.position = position;
        this.health = health;
        this.direction = direction;
        this.index = index;
    }

    public int compareTo(Robot robot){
        return this.position-robot.position;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "position=" + position +
                ", health=" + health +
                ", direction=" + direction +
                ", index=" + index +
                '}';
    }
}
class Solution {
    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> res= new ArrayList<>();
        List<Robot> robots = new ArrayList();
        Stack<Robot> stk = new Stack<>();
        for(int i=0;i<positions.length;i++){
            robots.add(new Robot(positions[i],healths[i],directions.charAt(i),i));
        }
        Collections.sort(robots);
        for(Robot robot:robots){
            if(stk.isEmpty() && robot.direction=='R') {
                stk.add(robot);
                continue;
            }
            if(!stk.isEmpty() && stk.peek().direction==robot.direction ){
                stk.push(robot);
                continue;
            }
            while(!stk.isEmpty() && (stk.peek().direction=='R' && robot.direction=='L' ||  stk.peek().direction=='L' && robot.direction=='R') && stk.peek().health<robot.health){
                    robot.health--;
                    stk.pop();
            }

            if(!stk.isEmpty() && stk.peek().health==robot.health){stk.pop();}
            else if(!stk.isEmpty() && stk.peek().direction==robot.direction){stk.push(robot);}
            else if(!stk.isEmpty() && stk.peek().health>robot.health){stk.peek().health--;}
            else{stk.push(robot);}
        }


        return process(stk);
    }

    public static List<Integer> process(Stack<Robot> robots){
        List<Robot> sortedRobots= new ArrayList<>();
        while(!robots.isEmpty() ){
            sortedRobots.add(robots.pop());
        }
        Collections.sort(sortedRobots,new Comparator<Robot>() {
            @Override
            public int compare(Robot o1, Robot o2) {
                return o1.index-o2.index;
            }
        });
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < sortedRobots.size(); i++) {
            res.add(sortedRobots.get(i).health);
        }
        return  res;
    }

    public static void main(String[] args) {
        //Example 1:

        int [] positions1 = {5,4,3,2,1}, healths1 = {2,17,9,15,10};
        String directions1 = "RRRRR";
        List<Integer> output1= new ArrayList<>(Arrays.asList(2,17,9,15,10));

        //Example 2:

        int [] positions2 = {3,5,2,6}, healths2 = {10,10,15,12};
        String directions2 = "RLRL";
        List<Integer> output2= new ArrayList<>(Arrays.asList(14));

        //Example 3:

        int [] positions3 = {1,2,5,6}, healths3 = {10,10,11,11};
        String directions3 = "RLRL";
        List<Integer> output3= new ArrayList<>();

        //Example 4:

        int [] positions4 = {11,44,16}, healths4 = {1,20,17};
        String directions4 = "RLR";
        List<Integer> output4= new ArrayList<>(Arrays.asList(18));


        List<Integer> ans1= survivedRobotsHealths(positions1,healths1,directions1);
        List<Integer> ans2= survivedRobotsHealths(positions2,healths2,directions2);
        List<Integer> ans3= survivedRobotsHealths(positions3,healths3,directions3);
        List<Integer> ans4= survivedRobotsHealths(positions4,healths4,directions4);

        if(output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }
        if(output3.equals(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output :"+ output3);
            System.out.println("Your Answer :"+ ans3);
        } 
        if(output4.equals(ans4)) {
            System.out.println("Case 4 Passed");
        }else {
            System.out.println("Case 4 Failed");
            System.out.println("Expected Output :"+ output4);
            System.out.println("Your Answer :"+ ans4);
        }

    }
}