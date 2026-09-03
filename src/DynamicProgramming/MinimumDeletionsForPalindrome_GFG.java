//Minimum Deletions for Palindrome
//Solved
//Difficulty: MediumAccuracy: 58.8%Submissions: 99K+Points: 4
//Given a string s, the task is to find minimum characters to be removed from the string so that the resultant string forms a palindrome. The order of characters should be maintained.
//
//Examples:
//
//Input: s = "aebcbda"
//Output: 2
//Explanation: Remove characters 'e' and 'd'.
//Input: s = "geeksforgeeks"
//Output: 8
//Explanation: To make "geeksforgeeks" a palindrome, the longest palindromic subsequence is "eefee" (length 5). The minimum deletions are:
//13 (length of s) - 5 = 8.
//Constraints:
//
//1 ≤ s.size() ≤ 103
package DynamicProgramming;

public class MinimumDeletionsForPalindrome_GFG {
//    approch : as we know we can find longest palindromic subsequence
//    by finding lcs of (s,reverse(s))
//    so here we just need to find longest paldindrom subsequence  length and substract it with string length is our answer
//    time complexity : O(n*m)
//    space complexity : O(n*m)
    public static int minDeletions(String s) {

        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();
        Integer [][] dp = new Integer[s.length() + 1][s.length() + 1];

        for (int n1 = 0; n1<dp.length; n1++) {
            for (int n2 = 0; n2<dp.length; n2++) {
                if (n1 == 0 || n2 == 0) {
                    dp[n1][n2] = 0;
                }
            }
        }
        for (int n1 = 1; n1<dp.length; n1++) {
            for (int n2 = 1; n2<dp.length; n2++) {
                if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
                    dp[n1][n2] = dp[n1 - 1][n2 - 1]+1;
                } else {
                    dp[n1][n2] = Math.max(dp[n1 - 1][n2], dp[n1][n2 - 1]);
                }
            }
        }
        int lcs = dp[s1.length()][s1.length()];
        return s1.length()-lcs;

    }
    public static void main(String[] args) {
        String s1 = "aebcbda";
        int output1= 2;

        String s2 = "geeksforgeeks";
        int output2= 8;

        int ans1= minDeletions(s1);
        int ans2= minDeletions(s2);


        if(ans1==output1){
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }

    }
}
