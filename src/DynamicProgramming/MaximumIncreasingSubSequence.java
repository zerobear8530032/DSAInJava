//300. Longest Increasing Subsequence
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given an integer array nums, return the length of the longest strictly increasing subsequence.
//
//
//
//Example 1:
//
//Input: nums = [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
//Example 2:
//
//Input: nums = [0,1,0,3,2,3]
//Output: 4
//Example 3:
//
//Input: nums = [7,7,7,7,7,7,7]
//Output: 1
//
//
//Constraints:
//
//1 <= nums.length <= 2500
//-104 <= nums[i] <= 104
//
//
//Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?

package DynamicProgramming;

public class MaximumIncreasingSubSequence {

// approch : we can use simple recurion + memo
//    where we only add the next element to subsequence if prev is smaller then cyrrebt
//    time compleixty : O(n*n)
//    space compleixty : O(n*n)
    public static int lengthOfLISBruteForce(int[] nums) {
        Integer [][] memo = new Integer[nums.length+1][nums.length+1];
        return helper(nums,0,-1,memo);
    }

    public static   int helper(int [] nums , int idx, int prev,Integer [][] memo){
        if(prev!=-1 && memo[idx][prev]!=null){
            return memo[idx][prev];
        }
        if(idx>=nums.length){return 0;}
        int take=0;
        if(prev==-1 || nums[prev]<nums[idx]){
            take = helper(nums,idx+1,idx,memo)+1;
        }
        int skip = helper(nums,idx+1,prev,memo);
        int res= Math.max(take,skip);
        if(prev!=-1){
            memo[idx][prev]=res;
        }
        return res;
    }
//    Better approch :
//    here we compute lis till index i and and try to add next elemetb to it  to increase it
//    time complexity : O(n*n)
//    space complexity : O(n)
    public static int lengthOfLISBottomUp(int[] nums) {
        int [] table = new int [nums.length+1];
        int lis=1;
        for(int i=0;i<table.length;i++){
            table[i]=1;
        }
        for(int i =0;i<nums.length;i++){
            for(int j =0;j<=i;j++){
                if(nums[j]<nums[i]){
                    table[i]=Math.max(table[i],table[j]+1);
                    lis=Math.max(lis,table[i]);
                }
            }
        }
        return lis;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {10,9,2,5,3,7,101,18};
        int output1= 4;

        //Example 2:

        int [] nums2 = {0,1,0,3,2,3};
        int output2= 4;

        //Example 3:


        int [] nums3 = {7,7,7,7,7,7};
        int output3= 1;

        System.out.println("Recursion");
        int ans1= lengthOfLISBruteForce(nums1);
        int ans2= lengthOfLISBruteForce(nums2);
        int ans3= lengthOfLISBruteForce(nums3);

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

        System.out.println("Bottom Up ");
        ans1= lengthOfLISBottomUp(nums1);
        ans2= lengthOfLISBottomUp(nums2);
        ans3= lengthOfLISBottomUp(nums3);

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

    }
}
