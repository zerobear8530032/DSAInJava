//1911. Maximum Alternating Subsequence Sum
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//The alternating sum of a 0-indexed array is defined as the sum of the elements at even indices minus the sum of the elements at odd indices.
//
//For example, the alternating sum of [4,2,5,3] is (4 + 5) - (2 + 3) = 4.
//Given an array nums, return the maximum alternating sum of any subsequence of nums (after reindexing the elements of the subsequence).
//
//A subsequence of an array is a new array generated from the original array by deleting some elements (possibly none) without changing the remaining elements' relative order. For example, [2,7,4] is a subsequence of [4,2,3,7,2,1,4] (the underlined elements), while [2,4,2] is not.
//
//
//
//Example 1:
//
//Input: nums = [4,2,5,3]
//Output: 7
//Explanation: It is optimal to choose the subsequence [4,2,5] with alternating sum (4 + 5) - 2 = 7.
//Example 2:
//
//Input: nums = [5,6,7,8]
//Output: 8
//Explanation: It is optimal to choose the subsequence [8] with alternating sum 8.
//Example 3:
//
//Input: nums = [6,2,1,2,4,5]
//Output: 10
//Explanation: It is optimal to choose the subsequence [6,1,5] with alternating sum (6 + 5) - 1 = 10.
//
//
//Constraints:
//
//1 <= nums.length <= 105
//1 <= nums[i] <= 105
package DynamicProgramming;

public class MaximumAlternatingSubsequenceSum_1911 {
//    approch:
//    here we use recusive + memo
//    simply we can send a flag of even , odd to the call to make sure elements are even of odd
//    we are adding if the current element is even and substracting if current element are odd
//    time complexity : O(n)
//    space complexity : O(2*n)
    public static long maxAlternatingSum(int[] nums) {
        Long [][] memo= new Long [nums.length+1][2];
        return helper(0, nums, true, memo);
    }
    public static long helper(int idx, int[] nums, boolean isEven,Long [][] memo) {
        int row= isEven? 0:1;
        if(memo[idx][row]!=null){
            return memo[idx][row];
        }
        if (idx == nums.length) {
            return 0;
        }
        long val = nums[idx];
        if (isEven==false) {val= -val;}
        long take= helper(idx+1,nums,!isEven,memo)+val;
        long notTake= helper(idx+1,nums,isEven,memo);
        long res= Math.max(take,notTake);
        memo[idx][row]=res;
        return res;
    }

    public static long maxAlternatingSumBottomUp(int[] nums) {
        long [][] table = new long [nums.length+1][2];
        for(int i=1;i<table.length;i++){
            // EVEN sub sequence:
            table[i][0]= Math.max(table[i-1][1]-nums[i-1],table[i-1][0]);
            // odd sub sequence:
            table[i][1]= Math.max(table[i-1][0]+nums[i-1],table[i-1][1]);
        }
        return Math.max(table[nums.length][0],table[nums.length][1]);
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {4,2,5,3};
        int output1= 7;

        //Example 2:

        int [] nums2 = {5,6,7,8};
        int output2= 8;

        //Example 3:

        int [] nums3 = {6,2,1,2,4,5};
        int output3= 10;


        System.out.println("Top Down DP");

        long ans1= maxAlternatingSum(nums1);
        long ans2= maxAlternatingSum(nums2);
        long ans3= maxAlternatingSum(nums3);
        if(output1==(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(output3==(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }

        System.out.println("Bottom UP DP");

        ans1= maxAlternatingSumBottomUp(nums1);
        ans2= maxAlternatingSumBottomUp(nums2);
        ans3= maxAlternatingSumBottomUp(nums3);
        if(output1==(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(output3==(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }
    }
}
