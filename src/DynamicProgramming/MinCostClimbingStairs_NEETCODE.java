//Min Cost Climbing Stairs
//Solved
//You are given an array of integers cost where cost[i] is the cost of taking a step from the ith floor of a staircase. After paying the cost, you can step to either the (i + 1)th floor or the (i + 2)th floor.
//
//You may choose to start at the index 0 or the index 1 floor.
//
//Return the minimum cost to reach the top of the staircase, i.e. just past the last index in cost.
//
//Example 1:
//
//Input: cost = [1,2,3]
//
//Output: 2
//Explanation: We can start at index = 1 and pay the cost of cost[1] = 2 and take two steps to reach the top. The total cost is 2.
//
//Example 2:
//
//Input: cost = [1,2,1,2,1,1,1]
//
//Output: 4
//Explanation: Start at index = 0.
//
//Pay the cost of cost[0] = 1 and take two steps to reach index = 2.
//Pay the cost of cost[2] = 1 and take two steps to reach index = 4.
//Pay the cost of cost[4] = 1 and take two steps to reach index = 6.
//Pay the cost of cost[6] = 1 and take one step to reach the top.
//The total cost is 4.
//Constraints:
//
//2 <= cost.length <= 100
//0 <= cost[i] <= 100
package DynamicProgramming;
import java.util.*;
public class MinCostClimbingStairs_NEETCODE {
    public static int minCostClimbingStairs(int[] cost) {

        return Math.min(helper(cost, 0, new HashMap<Integer,Integer>()),helper(cost,1,new HashMap<Integer,Integer>()));
    }
    public static int helper(int []cost, int idx, HashMap<Integer,Integer> memo){
        if(memo.containsKey(idx)){
            return memo.get(idx);
        }
        if(idx>=cost.length){
            return 0;
        }
        int minCost= Integer.MAX_VALUE;

        int costOneStep= helper(cost,idx+1,memo)+cost[idx];
        int costTwoStep= helper(cost,idx+2,memo)+cost[idx];

        minCost= Math.min(costOneStep,minCost);
        minCost= Math.min(costTwoStep,minCost);
        memo.put(idx,minCost);
        return minCost;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] cost1 = {1,2,3};
        int output1= 2;

        //Example 2:

        int [] cost2 = {1,2,1,2,1,1,1};
        int output2= 4;

        int ans1= minCostClimbingStairs(cost1);
        int ans2= minCostClimbingStairs(cost2);

        if(output1== ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2== ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }


    }
}
