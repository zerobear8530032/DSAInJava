//2211. Count Collisions on a Road
//Attempted
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//There are n cars on an infinitely long road. The cars are numbered from 0 to n - 1 from left to right and each car is present at a unique point.
//
//You are given a 0-indexed string directions of length n. directions[i] can be either 'L', 'R', or 'S' denoting whether the ith car is moving towards the left, towards the right, or staying at its current point respectively. Each moving car has the same speed.
//
//The number of collisions can be calculated as follows:
//
//When two cars moving in opposite directions collide with each other, the number of collisions increases by 2.
//When a moving car collides with a stationary car, the number of collisions increases by 1.
//After a collision, the cars involved can no longer move and will stay at the point where they collided. Other than that, cars cannot change their state or direction of motion.
//
//Return the total number of collisions that will happen on the road.
//
//
//
//Example 1:
//
//Input: directions = "RLRSLL"
//Output: 5
//Explanation:
//The collisions that will happen on the road are:
//- Cars 0 and 1 will collide with each other. Since they are moving in opposite directions, the number of collisions becomes 0 + 2 = 2.
//- Cars 2 and 3 will collide with each other. Since car 3 is stationary, the number of collisions becomes 2 + 1 = 3.
//- Cars 3 and 4 will collide with each other. Since car 3 is stationary, the number of collisions becomes 3 + 1 = 4.
//- Cars 4 and 5 will collide with each other. After car 4 collides with car 3, it will stay at the point of collision and get hit by car 5. The number of collisions becomes 4 + 1 = 5.
//Thus, the total number of collisions that will happen on the road is 5.
//Example 2:
//
//Input: directions = "LLRR"
//Output: 0
//Explanation:
//No cars will collide with each other. Thus, the total number of collisions that will happen on the road is 0.
//
//
//Constraints:
//
//1 <= directions.length <= 105
//directions[i] is either 'L', 'R', or 'S'.
package Stacks;

import java.util.Stack;

public class CountCollisionsOnARoad_2211 {
//   approch :
//    we can use  a stack and handle 2 cases
//     we know the only time collision cause is R going to S or L
//    of Left going to Right or S
//    and after a collision we can assume both cars are stationary
//    so we can check this by going left to right
//    if a car is moving right add it to stack
//    if there is a stationary car
//    check is there a car in top of stack which was going right
//    and increment the res untill we found it exist
//    if the car going left
//    then check is there a car going right in stack top
//    if there are multiple we will add how many card going to right + 1
//    cause first R-><-L coliition is count as 2 rest are counted as 1
//    same if the top is S we assum the car will collide tostationary car
//    so we add 1
//    time complexity : O(n)
//    space complexity : O(n)
    public static int countCollisionsBruteForce(String directions) {
        Stack<Character> stk = new Stack();
        int res = 0;
        for (int i = 0; i < directions.length(); i++) {
            char direction = directions.charAt(i);
            if (direction == 'L' && !stk.isEmpty()) {
                if(stk.peek()=='S'){
                    res+=1;
                }else{
                    int countRight= 0;
                    while (!stk.isEmpty() && stk.peek()=='R') {
                        countRight++;
                        stk.pop();
                    }
//                    the first collision will be of 2 collision rest collision will be of 1
                    stk.push('S');
                    res+= countRight+1;
                }
            } else if (direction == 'R') {
                stk.push('R');
            } else if (direction == 'S') {
                while (!stk.isEmpty() && stk.peek() == 'R') {
                    res += 1;
                    stk.pop();
                }
                stk.push('S');
            }
        }
        return res;
    }

//    all leading right going cars and alll trailing left going cars are safe rest
//    all moving card will collid
//    time complexity : O(n)
//    space complexity : O(1)
    public static int countCollisionsBetter(String directions) {
        int left=0;
        int right=directions.length()-1;
        while(left<directions.length() && directions.charAt(left)=='L'){
            left++;
        }
        while(right>=0 && directions.charAt(right)=='R'){
            right--;
        }
        int res=0;
        for(int i =left;i<=right;i++){
            if(directions.charAt(i)!='S'){
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        String directions1 = "RLRSLL";
        int output1= 5;

        //Example 2:

        String directions2 = "LLRR";
        int output2= 0;

        //Example 3:

        String directions3 = "SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR";
        int output3= 20;

        //Example 4:

        String directions4= "LLRLRLLSLRLLSLSSSS";
        int output4= 10;

        System.out.println("Brute Force ");
        int ans1 = countCollisionsBruteForce(directions1);
        int ans2 = countCollisionsBruteForce(directions1);
        int ans3 = countCollisionsBruteForce(directions1);
        int ans4 = countCollisionsBruteForce(directions1);
        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2== output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3== output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }
        if(ans4== output4) {
            System.out.println("Case 4 Passed");
        }else {
            System.out.println("Case 4 Failed");
            System.out.println("Expected Ouput :"+ (output4));
            System.out.println("Your Answer :"+ (ans4));
        }
        System.out.println("Better Force ");
        ans1 = countCollisionsBetter(directions1);
        ans2 = countCollisionsBetter(directions1);
        ans3 = countCollisionsBetter(directions1);
        ans4 = countCollisionsBetter(directions1);
        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2== output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3== output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }
        if(ans4== output4) {
            System.out.println("Case 4 Passed");
        }else {
            System.out.println("Case 4 Failed");
            System.out.println("Expected Ouput :"+ (output4));
            System.out.println("Your Answer :"+ (ans4));
        }

    }
}
