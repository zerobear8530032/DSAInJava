//516. Longest Palindromic Subsequence
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given a string s, find the longest palindromic subsequence's length in s.
//
//A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
//
//
//
//Example 1:
//
//Input: s = "bbbab"
//Output: 4
//Explanation: One possible longest palindromic subsequence is "bbbb".
//Example 2:
//
//Input: s = "cbbd"
//Output: 2
//Explanation: One possible longest palindromic subsequence is "bb".
//
//
//Constraints:
//
//1 <= s.length <= 1000
//s consists only of lowercase English letters.
package DynamicProgramming;

public class LongestPalindromicSubsequence_516 {
//    approch : here we can just find lcs(s,reverese(S)) is our answer
//    time complexity : O(n*m)
//    space complexity : O(n*m)
    public static int longestPalindromeSubseq(String s) {
        String s1=s;
        String s2=new StringBuilder(s).reverse().toString();
        Integer [][] dp= new Integer[s.length()+1][s.length()+1];

        for(int n1 =0;n1<dp.length;n1++){
            for(int n2=0;n2<dp.length;n2++){
                if(n1==0 || n2==0){
                    dp[n1][n2]=0;
                }
            }
        }
        for(int n1 =1;n1<dp.length;n1++){
            for(int n2=1;n2<dp.length;n2++){
                if(s1.charAt(n1-1)== s2.charAt(n2-1)){
                    dp[n1][n2]= dp[n1-1][n2-1]+1;
                }else{
                    dp[n1][n2]= Math.max(dp[n1-1][n2],dp[n1][n2-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    public static void main(String[] args) {
    //Example 1:

    String s1 = "bbbab";
    int output1 =4;

    //Example 2:

    String s2 = "cbbd";
    int output2 =2;

    int ans1= longestPalindromeSubseq(s1);
    int ans2= longestPalindromeSubseq(s2);


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
