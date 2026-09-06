//115. Distinct Subsequences
//Solved
//Hard
//Topics
//premium lock icon
//Companies
//Given two strings s and t, return the number of distinct subsequences of s which equals t.
//
//The test cases are generated so that the answer fits on a 32-bit signed integer.
//
//
//
//Example 1:
//
//Input: s = "rabbbit", t = "rabbit"
//Output: 3
//Explanation:
//As shown below, there are 3 ways you can generate "rabbit" from s.
//rabbbit
//rabbbit
//rabbbit
//Example 2:
//
//Input: s = "babgbag", t = "bag"
//Output: 5
//Explanation:
//As shown below, there are 5 ways you can generate "bag" from s.
//babgbag
//babgbag
//babgbag
//babgbag
//babgbag
//
//
//Constraints:
//
//1 <= s.length, t.length <= 1000
//s and t consist of English letters.
package DynamicProgramming;

public class DistinctSubsequences_115 {


    public static int numDistinctBottomUp(String s, String t) {

        int[][] dp = new int[s.length() + 1][t.length() + 1];

        // Base case:
        // Empty t can always be formed by choosing nothing.
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        // dp[0][j] is already 0 for j > 0 because
        // an empty s cannot form a non-empty t.

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {

                    // Take the current character from s
                    int take = dp[i - 1][j - 1];

                    // Skip the current character from s
                    int skip = dp[i - 1][j];

                    dp[i][j] = take + skip;

                } else {

                    // Characters don't match,
                    // so we have to skip the current character from s.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }

        public static int numDistinctMemo(String s, String t) {
            Integer [][] memo = new Integer[s.length()+1][t.length()+1];
            return helper(s,t,s.length(),t.length(),memo);
        }

        public static int helper(String s, String t, int n1, int n2,Integer [][] memo){
            if(memo[n1][n2]!=null){
                return memo[n1][n2];
            }
            if(n2==0){
                return 1;
            }
            if(n1==0){
                return 0;
            }

            if(s.charAt(n1-1)==t.charAt(n2-1)){
                int take = helper(s,t,n1-1,n2-1,memo);
                int skip = helper(s,t,n1-1,n2,memo);
                memo[n1][n2]=take+skip;
                return take + skip;
            }else{
                return memo[n1][n2]=helper(s,t,n1-1,n2,memo);
            }
        }


    public static void main(String[] args) {

        // Example 1

        String s1 = "rabbbit";
        String t1 = "rabbit";
        int output1 = 3;

        // Example 2

        String s2 = "babgbag";
        String t2 = "bag";
        int output2 = 5;

        System.out.println("Memorization Approch :");

        int ans1 = numDistinctMemo(s1, t1);
        int ans2 = numDistinctMemo(s2, t2);

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



        System.out.println("Tabulation Approch :");

        ans1 = numDistinctBottomUp(s1, t1);
        ans2 = numDistinctBottomUp(s2, t2);

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
    }
}