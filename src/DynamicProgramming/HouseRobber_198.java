// 198. House Robber
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
//Example 2:
//
//Input: nums = [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//Total amount you can rob = 2 + 9 + 1 = 12.
//
//
//Constraints:
//
//1 <= nums.length <= 100
//0 <= nums[i] <= 400
package DynamicProgramming;

public class HouseRobber_198 {
// approch : brute recursiv approch
//    time complexity : O(2^n)
//    space complexity : O(n)
    public static int rob(int[] nums) {
        return helper(0,nums);
    }
    public static int helper(int idx, int [] nums){
        if(idx>=nums.length){
            return 0;
        }
        int res=0;
        for(int i=idx;i<nums.length;i++){
            int rob = helper(i+2,nums)+nums[i];
            int skip = helper(i+1,nums);
            res= Math.max(res,skip);
            res= Math.max(res,rob);
        }
        return res;
    }
    // approch : Memorization  approch
//    time complexity : O(n^2)
//    space complexity : O(n)
    public static int robMemo(int[] nums) {
        Integer [] memo = new Integer [nums.length+2];
        return helperMemo(0,nums,memo);
    }
    public static int helperMemo(int idx, int [] nums, Integer [] memo){
        if(memo[idx]!=null){
            return memo[idx];
        }
        if(idx>=nums.length){
            return 0;
        }
        int res=0;
        for(int i=idx;i<nums.length;i++){
            int rob = helperMemo(i+2,nums,memo)+nums[i];
            int skip = helperMemo(i+1,nums,memo);
            res= Math.max(res,skip);
            res= Math.max(res,rob);
        }
        memo[idx]= res;
        return res;
    }

// approch :
//  we can use bottom up dp
//  where we build the approch in revese order
//  form each table[i] we look behind table[i-1] previous house
//  form each table[i] we look behind table[i-2] previous or previous house
//    time complexity : O(n)
//    space complexity : O(n)
    public static int robBottomUp(int[] nums) {
        int [] table = new int [nums.length+1];
        table[0]=0;// stolen 0 houses
        table[1]=nums[0];// stolen 1 houses
        for(int i =2;i<table.length;i++){
            int stole = nums[i-1]+table[i-2];// stole current house + 2 housr back
            int skip = table[i-1];// skip current house and take profit of previous house
            table[i]= Math.max(stole,skip);
        }
        return table[nums.length];
    }
    // approch :
    //  we can use bottom up dp
    //  where we build the approch in revese order
//    from previous we can see we only need 2 previous ones so we can use 2 variables rather then entire array
    //    time complexity : O(n)
    //    space complexity : O(n)
    public static int robBottomUpBest(int[] nums) {
        int rob1=0;
        int rob2=nums[0];
        for(int i =2;i<nums.length+1;i++){
            int stole = nums[i-1]+rob1;
            int skip = rob2;
            rob1= rob2;
            rob2= Math.max(stole,skip);
        }
        return rob2;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,2,3,1};
        int output1= 4;

        //Example 2:

        int [] nums2 = {2,7,9,3,1};
        int output2= 12;

        int ans1 = rob(nums1);
        int ans2 = rob(nums2);


        System.out.println("Brute Force Recursion");

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


        System.out.println("MEMO  Recursion");

        ans1 = robMemo(nums1);
        ans2 = robMemo(nums2);
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
        System.out.println("Bottom Up");

        ans1 = robBottomUp(nums1);
        ans2 = robBottomUp(nums2);
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
        System.out.println("Bottom Up Best");

        ans1 = robBottomUpBest(nums1);
        ans2 = robBottomUpBest(nums2);
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
    }
}
