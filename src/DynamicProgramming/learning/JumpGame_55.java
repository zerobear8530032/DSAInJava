//55. Jump Game
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
//
//Return true if you can reach the last index, or false otherwise.
//
//
//
//Example 1:
//
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//Example 2:
//
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
//
//
//Constraints:
//
//1 <= nums.length <= 104
//0 <= nums[i] <= 105
package DynamicProgramming.learning;

import java.util.HashMap;

public class JumpGame_55 {
    public static boolean canJump(int[] nums) {
        return helper(nums, 0, new HashMap<>());
    }

    public static boolean helper(int [] nums, int position, HashMap<Integer,Boolean> memo){
        if(memo.containsKey(position)){
            return memo.get(position);
        }
        if(position == nums.length-1){
            return true;
        }
        if(position >= nums.length){
            return false;
        }
        int jumps=  nums[position];
        boolean reachEnd = false;
        for(int i=1;i<=jumps;i++){
            if(helper(nums,position+i,memo)){
                memo.put(position,true);
                return true;
            }
        }
        memo.put(position,reachEnd);
        return reachEnd;
    }
    public static void main(String[] args) {

        //Example 1:

        int [] nums1 = {2,3,1,1,4};
        boolean output1=true;

        //Example 2:

        int [] nums2 = {3,2,1,0,4};
        boolean output2=false;

        boolean ans1= canJump(nums1);
        boolean ans2= canJump(nums2);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+(output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+(output2));
            System.out.println("Your Answer :"+ (ans2));
        }


    }
}
