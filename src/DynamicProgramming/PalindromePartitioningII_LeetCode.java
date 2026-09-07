//132. Palindrome Partitioning II
//Solved
//Difficulty: Hard
//Given a string s, partition s such that every substring of the partition is a palindrome.
//Return the minimum cuts needed for a palindrome partitioning of s.
//
//Examples:
//
//Input: s = "aab"
//Output: 1
//Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
//
//Input: s = "a"
//Output: 0
//
//Input: s = "ab"
//Output: 1
//
//Constraints:
//1 <= s.length <= 2000
//s consists of lowercase English letters only.

package DynamicProgramming;

public class PalindromePartitioningII_LeetCode {

//    approach :
//    1. Use MCM (Matrix Chain Multiplication) pattern.
//    2. For every substring [i...j], try every possible partition k.
//    3. Solve the left and right parts recursively and add 1 for the cut.
//    4. If the entire substring [i...j] is already a palindrome, no cut is required.
//    5. Use memoization to store the minimum cuts for every [i...j].
//
//    time complexity : O(n^3)
//    space complexity : O(n^2)

    public static int minCut(String s) {
        Integer[][] memo = new Integer[s.length() + 1][s.length() + 1];
        return helper(s, 0, s.length() - 1, memo);
    }

    public static int helper(String s, int i, int j, Integer[][] memo) {

        if (i > j) {
            return 0;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int res = Integer.MAX_VALUE;

        if (isPalindrome(s, i, j)) {
            memo[i][j] = 0;
            return 0;
        }

        for (int k = i + 1; k <= j; k++) {

            int left = 0;

            if (memo[i][k - 1] != null) {
                left = memo[i][k - 1];
            } else {
                left = helper(s, i, k - 1, memo);
                memo[i][k - 1] = left;
            }

            int right = 0;

            if (memo[k][j] != null) {
                right = memo[k][j];
            } else {
                right = helper(s, k, j, memo);
                memo[k][j] = right;
            }

            int tempRes = left + right + 1;

            res = Math.min(tempRes, res);
        }

        memo[i][j] = res;

        return res;
    }

    public static boolean isPalindrome(String s, int l, int r) {

        while (l <= r) {

            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) {

        // Example 1:
        String s1 = "aab";
        int output1 = 1;

        // Example 2:
        String s2 = "a";
        int output2 = 0;

        // Example 3:
        String s3 = "ab";
        int output3 = 1;

        int ans1 = minCut(s1);
        int ans2 = minCut(s2);
        int ans3 = minCut(s3);

        if (ans1 == output1) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output :" + output1);
            System.out.println("Your Answer :" + ans1);
        }

        if (ans2 == output2) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output :" + output2);
            System.out.println("Your Answer :" + ans2);
        }

        if (ans3 == output3) {
            System.out.println("Case 3 Passed");
        } else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output :" + output3);
            System.out.println("Your Answer :" + ans3);
        }
    }
}