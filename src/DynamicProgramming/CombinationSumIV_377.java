//377. Combination Sum IV
//Medium
//Topics
//premium lock icon
//Companies
//Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
//
//The test cases are generated so that the answer can fit in a 32-bit integer.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3], target = 4
//Output: 7
//Explanation:
//The possible combination ways are:
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//Note that different sequences are counted as different combinations.
//Example 2:
//
//Input: nums = [9], target = 3
//Output: 0
//
//
//Constraints:
//
//1 <= nums.length <= 200
//1 <= nums[i] <= 1000
//All the elements of nums are unique.
//1 <= target <= 1000
//
//
//Follow up: What if negative numbers are allowed in the given array? How does it change the problem? What limitation we need to add to the question to allow negative numbers?


package DynamicProgramming;

public class CombinationSumIV_377 {

    // Since order matters, we don't use the take/skip approach here.
    // For every target, we can choose any number from nums.
    //
    // dp[target] represents the number of combinations that can form target.
    //
    // Base case:
    // target == 0 means we successfully formed the target.
    // There is exactly 1 way to form 0: choose nothing.
    //
    // Recurrence:
    // For every x in nums:
    //     helper(target - x)
    //
    // Time complexity : O(target * nums.length)
    // Space complexity : O(target)
    static int combinationSum4Memo(int[] nums, int target) {
        Integer[] dp = new Integer[target + 1];
        return helperMemo(nums, target, dp);
    }

    public static int helperMemo(int[] nums, int target, Integer[] memo) {

        if (target == 0) {
            return 1;
        }

        if (memo[target] != null) {
            return memo[target];
        }

        int res = 0;

        for (int x : nums) {
            if (x <= target) {
                res += helperMemo(nums, target - x, memo);
            }
        }

        memo[target] = res;
        return res;
    }


    // Time and space complexity is same.
    // Just convert the recursive approach into bottom-up approach.
    //
    // dp[t] represents the number of ordered combinations that can form t.
    //
    // We iterate over target first and then nums.
    // This is important because order matters in Combination Sum IV.
    //
    // Time complexity : O(target * nums.length)
    // Space complexity : O(target)

    static int combinationSum4TopDown(int[] nums, int target) {

        Integer[] dp = new Integer[target + 1];

        dp[0] = 1;

        for (int t = 1; t < dp.length; t++) {

            int res = 0;

            for (int x : nums) {

                if (x <= t) {
                    res += dp[t - x];
                }
            }

            dp[t] = res;
        }

        return dp[target];
    }


    // Same recursive approach without memoization.
    // Kept here to understand the original recursion before applying DP.
    //
    // Time complexity : Exponential
    // Space complexity : O(target) due to recursion stack

    public static int helper(int[] nums, int target) {

        if (target == 0) {
            return 1;
        }

        int res = 0;

        for (int x : nums) {

            if (x <= target) {
                res += helper(nums, target - x);
            }
        }

        return res;
    }


    public static void main(String[] args) {

        // Example 1:

        int[] nums1 = {1, 2, 3};
        int target1 = 4;
        int output1 = 7;

        // Example 2:

        int[] nums2 = {9};
        int target2 = 3;
        int output2 = 0;


        System.out.println("Recursion memorization approach :");

        int ans1 = combinationSum4Memo(nums1, target1);
        int ans2 = combinationSum4Memo(nums2, target2);


        if (ans1 == output1) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output : " + output1);
            System.out.println("Your Answer : " + ans1);
        }

        if (ans2 == output2) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output : " + output2);
            System.out.println("Your Answer : " + ans2);
        }


        System.out.println("Bottom Up approach :");

        ans1 = combinationSum4TopDown(nums1, target1);
        ans2 = combinationSum4TopDown(nums2, target2);


        if (ans1 == output1) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output : " + output1);
            System.out.println("Your Answer : " + ans1);
        }

        if (ans2 == output2) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output : " + output2);
            System.out.println("Your Answer : " + ans2);
        }
    }
}
