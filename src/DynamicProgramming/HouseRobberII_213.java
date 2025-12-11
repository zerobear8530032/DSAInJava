//213. House Robber II
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
//
//
//
//Example 1:
//
//Input: nums = [2,3,2]
//Output: 3
//Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
//Example 2:
//
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
//Example 3:
//
//Input: nums = [1,2,3]
//Output: 3
//
//
//Constraints:
//
//1 <= nums.length <= 100
//0 <= nums[i] <= 1000
//
package DynamicProgramming;

public class HouseRobberII_213 {
//    approch : we can use brute force simply marking every single robbed house
//    time complexity : O(2^n)
//    space complexity : O(n)
    public static int robBruteForce(int[] nums) {
        boolean [] robbed= new boolean[nums.length];
        return helper(0,nums,robbed);
    }
    public static int helper(int idx, int [] nums , boolean[] robbed){
        if(idx>=nums.length){return 0;}
        int rob =0;
        if(!(idx==nums.length-1 && robbed[0]==true)){
            robbed[idx]=true;
            rob = nums[idx]+helper(idx+2,nums,robbed);
            robbed[idx]=false;
        }
        int skip = helper(idx+1,nums,robbed);
        return Math.max(skip,rob);
    }


//    intution we can take either first house or either last house
//    so we can use 2 recusion with range 0 to n-2 house & 1 to n-1 house
// time complexity : O(n)
// space complexity : O(n)

    public static int robRecMemo(int[] nums) {
        if(nums.length==1){return nums[0];}
        Integer [] dp1 = new Integer[nums.length+2];
        Integer [] dp2 = new Integer[nums.length+2];
        boolean [] robbed= new boolean[nums.length];
        return Math.max(helper(1,nums,nums.length,dp1),helper(0,nums,nums.length-1,dp2));
    }
    public static int helper(int idx,int [] nums , int n, Integer [] memo){
        if(memo[idx]!=null){
            return memo[idx];
        }
        if(idx>=n){
            return 0;
        }
        int rob= nums[idx]+helper(idx+2,nums,n,memo);
        int skip= helper(idx+1,nums,n,memo);
        int res=Math.max(rob,skip);
        memo[idx]=res;
        return res;
    }

// the approch is same just we use bototm up way
// time complexity : O(n)
// space complexity : O(n)
    public static int robBottomUp(int[] nums) {
        if(nums.length==1){return nums[0];}
        int[] dp1 = new int[nums.length];
        dp1[0] = 0;
        dp1[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            int rob = nums[i - 1] + dp1[i - 2];
            int skip = dp1[i - 1];
            dp1[i] = Math.max(rob, skip);
        }
        int[] dp2 = new int[nums.length];
        dp2[0] = 0;
        dp2[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int rob = nums[i] + dp2[i - 2];
            int skip = dp2[i-1];
            dp2[i] = Math.max(rob, skip);
        }
        return Math.max(dp1[nums.length-1], dp2[nums.length - 1]);
    }
// the approch is same just we use bottom up way but we can see the next state need only prev 2 states
//    so we can use those to make is optimze in space
// time complexity : O(n)
// space complexity : O(1)
    public static int robBottomUpOptimize(int[] nums) {
    int res=0;
    if(nums.length==1){return nums[0];}
    int[] dp1 = new int[nums.length];
    int rob1 = 0;
    int rob2 = nums[0];
    for (int i = 2; i < nums.length; i++) {
        int rob = nums[i - 1] + rob1;
        int skip = rob2;
        rob1=rob2;
        rob2 = Math.max(rob, skip);
    }
    res=Math.max(rob2,res);
    rob1 = 0;
    rob2 = nums[1];
    for (int i = 2; i < nums.length; i++) {
        int rob = nums[i] + rob1;
        int skip = rob2;
        rob1=rob2;
        rob2= Math.max(rob, skip);
    }
    res=Math.max(res,rob2);
    return res;
}

    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {2,3,2};
        int output1= 3;

        //Example 2:

        int [] nums2 = {1,2,3,1};
        int output2= 4;

        //Example 3:

        int [] nums3 = {1,2,3};
        int output3=3;

        System.out.println("Brute Recusion:");
        int ans1= robBruteForce(nums1);
        int ans2= robBruteForce(nums2);
        int ans3= robBruteForce(nums3);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }

        System.out.println("Memo Recusion:");
        ans1= robRecMemo(nums1);
        ans2= robRecMemo(nums2);
        ans3= robRecMemo(nums3);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }

        System.out.println("Bottom UP iterative:");
        ans1= robBottomUp(nums1);
        ans2= robBottomUp(nums2);
        ans3= robBottomUp(nums3);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }

        System.out.println("Bottom UP Optimize:");
        ans1= robBottomUpOptimize(nums1);
        ans2= robBottomUpOptimize(nums2);
        ans3= robBottomUpOptimize(nums3);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }
    }
}
