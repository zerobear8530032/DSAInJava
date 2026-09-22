// Perfect Squares
// Solved
// Difficulty: Medium
// Given an integer n, return the least number of perfect square numbers that sum to n.
//
// A perfect square is an integer that is the square of an integer.
// For example, 1, 4, 9, 16, 25...
//
// Examples:
//
// Input: n = 13
// Output: 2
// Explanation:
// 13 = 4 + 9
//
// Input: n = 6
// Output: 3
// Explanation:
// 6 = 4 + 1 + 1
//
// Constraints:
// 1 <= n <= 10,000


package DynamicProgramming;

public class PerfectSquares_NeetCode {

    // Recursive approach with memoization.
    //
    // n represents the remaining value that we need to form.
    // depth represents the number of perfect squares chosen so far.
    //
    // At every step, we try every perfect square that is <= n.
    //
    // Example:
    // n = 13
    //
    // We can choose:
    // 9 -> remaining = 4
    // 4 -> remaining = 9
    // 1 -> remaining = 12
    //
    // When n becomes 0, we have successfully formed the original number.
    // depth represents how many perfect squares were used.
    //
    // dp[n][depth] stores the minimum number of squares required
    // for the current state.
    //
    // Base cases:
    //
    // n == 0:
    // We have successfully formed the target.
    // Return the current depth.
    //
    // n < 0:
    // This path is invalid, so return Integer.MAX_VALUE.
    //
    // Time complexity:
    // O(n * n * sqrt(n)) in the worst case because the state contains
    // both n and depth.
    //
    // Space complexity:
    // O(n * n) for the DP table.
    //
    // Note:
    // The depth dimension is actually unnecessary because the answer
    // for a remaining n does not depend on how many squares were already
    // chosen. This can be optimized to a 1D DP array.
    public static int numSquares(int n) {
        Integer [] dp = new Integer[10001];
        dp[0]=0;
        for(int num = 1;num<dp.length;num++){
            int res =Integer.MAX_VALUE;
            for(int i=1;i<=Math.sqrt(num);i++){
                res =Math.min(res,dp[num-i*i]+1);
            }
            dp[num]=res;

        }
        return dp[n];
    }

    public static int numSquaresMemo(int n){
        Integer [] dp = new Integer[n+1];
        return helper(n,dp);
    }

    public static int helper(int n,Integer [] dp){
        if(dp[n]!=null){
            return dp[n];
        }
        if(n==0){
            return 0;
        }
        int res =Integer.MAX_VALUE;
        for(int i =1;i<=Math.sqrt(n);i++){
            res =Math.min(res,helper(n-i*i,dp)+1);
        }
        dp[n]=res;
        return res;
    }


    public static void main(String[] args) {

        // Example 1:

        int n1 = 13;
        int output1 = 2;


        // Example 2:

        int n2 = 6;
        int output2 = 3;


        System.out.println("Recursion memorization approach :");


        int ans1 = numSquaresMemo(n1);
        int ans2 = numSquaresMemo(n2);


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


        System.out.println("Bottom Up Approch :");


        ans1 = numSquares(n1);
        ans2 = numSquares(n2);


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