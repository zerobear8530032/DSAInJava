//Longest Common Substring
//Solved
//Difficulty: Medium
//Accuracy: 42.69%
//Submissions: 348K+
//Points: 4
//
//Given two strings s1 and s2, determine the length of the longest substring
//that appears in both strings.
//
//Example:
//
//Input: s1 = "ABCDGH", s2 = "ACDGHR"
//Output: 4
//Explanation: The longest common substring is "CDGH" with a length of 4.
//
//Input: s1 = "abc", s2 = "acb"
//Output: 1
//Explanation: The longest common substrings are "a", "b", "c" all having length 1.
//
//Input: s1 = "YZ", s2 = "yz"
//Output: 0
//Explanation: Comparison is case-sensitive, so 'Y' != 'y' and 'Z' != 'z'.
//Hence, no common substring exists.
//
//Constraints:
//
//1 <= s1.size(), s2.size() <= 10^3
//Both strings consist only of uppercase and lowercase English letters.

package DynamicProgramming;

public class LongestCommonSubstring_GFG {

    /*
        Longest Common Substring is different from Longest Common Subsequence.

        Here dp[i][j] represents the length of the common substring
        ending at s1[i-1] and s2[j-1].

        If characters match:
            dp[i][j] = dp[i-1][j-1] + 1

        If characters do not match:
            dp[i][j] = 0

        We keep a separate max variable because the longest substring
        can end anywhere in the DP table.

        Time Complexity: O(n*m)
        Space Complexity: O(n*m)
    */

    public static int longCommSubstrTopDown(String s1, String s2) {

        Integer[][] dp = new Integer[s1.length() + 1][s2.length() + 1];

        int max = 0;

        for (int n1 = 0; n1 < dp.length; n1++) {
            for (int n2 = 0; n2 < dp[n1].length; n2++) {

                if (n1 == 0 || n2 == 0) {
                    dp[n1][n2] = 0;
                }
            }
        }

        for (int n1 = 1; n1 < dp.length; n1++) {
            for (int n2 = 1; n2 < dp[n1].length; n2++) {

                if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {

                    dp[n1][n2] = dp[n1 - 1][n2 - 1] + 1;

                    max = Math.max(max, dp[n1][n2]);

                } else {

                    dp[n1][n2] = 0;
                }
            }
        }

        return max;
    }


    /*
        Memoization version.

        dp[n1][n2] represents the length of the common substring
        ending at s1[n1-1] and s2[n2-1].

        If characters match:
            helper(n1-1,n2-1) + 1

        If characters do not match:
            0

        Since the answer can occur at any position, we keep max
        separately.

        Time Complexity: O(n*m)
        Space Complexity: O(n*m)
    */

    public static int longCommSubstrMemo(String s1, String s2) {

        Integer[][] memo = new Integer[s1.length() + 1][s2.length() + 1];

        int max = 0;

        for (int n1 = 1; n1 <= s1.length(); n1++) {
            for (int n2 = 1; n2 <= s2.length(); n2++) {

                int current = helper(s1, s2, n1, n2, memo);

                max = Math.max(max, current);
            }
        }

        return max;
    }

    public static int helper(
            String s1,
            String s2,
            int n1,
            int n2,
            Integer[][] memo) {

        if (n1 == 0 || n2 == 0) {
            return 0;
        }

        if (memo[n1][n2] != null) {
            return memo[n1][n2];
        }

        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {

            memo[n1][n2] =
                    helper(s1, s2, n1 - 1, n2 - 1, memo) + 1;

        } else {

            memo[n1][n2] = 0;
        }

        return memo[n1][n2];
    }


    public static void main(String[] args) {

        // Examples

        String s1 = "ABCDGH";
        String s2 = "ACDGHR";
        int output1 = 4;

        String s3 = "abc";
        String s4 = "acb";
        int output2 = 1;

        String s5 = "YZ";
        String s6 = "yz";
        int output3 = 0;


        System.out.println("Top Down DP");

        int ans1 = longCommSubstrTopDown(s1, s2);
        int ans2 = longCommSubstrTopDown(s3, s4);
        int ans3 = longCommSubstrTopDown(s5, s6);

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

        if (ans3 == output3) {
            System.out.println("Case 3 Passed");
        } else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output : " + output3);
            System.out.println("Your Answer : " + ans3);
        }


        System.out.println("Recursive Memorization DP");

        ans1 = longCommSubstrMemo(s1, s2);
        ans2 = longCommSubstrMemo(s3, s4);
        ans3 = longCommSubstrMemo(s5, s6);

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

        if (ans3 == output3) {
            System.out.println("Case 3 Passed");
        } else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output : " + output3);
            System.out.println("Your Answer : " + ans3);
        }
    }
}