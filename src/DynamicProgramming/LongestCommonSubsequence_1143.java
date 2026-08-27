//1143. Longest Common Subsequence
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
//
//A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
//
//For example, "ace" is a subsequence of "abcde".
//A common subsequence of two strings is a subsequence that is common to both strings.
//
//
//
//Example 1:
//
//Input: text1 = "abcde", text2 = "ace"
//Output: 3
//Explanation: The longest common subsequence is "ace" and its length is 3.
//Example 2:
//
//Input: text1 = "abc", text2 = "abc"
//Output: 3
//Explanation: The longest common subsequence is "abc" and its length is 3.
//Example 3:
//
//Input: text1 = "abc", text2 = "def"
//Output: 0
//Explanation: There is no such common subsequence, so the result is 0.
//
//
//Constraints:
//
//1 <= text1.length, text2.length <= 1000
//text1 and text2 consist of only lowercase English characters.
package DynamicProgramming;

public class LongestCommonSubsequence_1143 {
        public static int longestCommonSubsequenceTopDown(String text1, String text2) {
            Integer [][] dp = new Integer[text1.length()+1][text2.length()+1];
            for(int n1=0;n1<dp.length;n1++){
                for(int n2=0;n2<dp[n1].length;n2++){
                    if(n1==0 || n2==0){
                        dp[n1][n2]=0;
                    }
                }
            }
            for(int n1=1;n1<dp.length;n1++){
                for(int n2=1;n2<dp[n1].length;n2++){
                    if(text1.charAt(n1-1) ==text2.charAt(n2-1)){
                        dp[n1][n2]= dp[n1-1][n2-1]+1;
                    }else{
                        int reduceLeft= dp[n1-1][n2];
                        int reduceRight= dp[n1][n2-1];
                        dp[n1][n2]= Math.max(reduceLeft,reduceRight);
                    }
                }
            }
            return dp[text1.length()][text2.length()];
        }
        public static  int longestCommonSubsequenceMemorize(String text1, String text2){
            Integer [][] memo = new Integer[text1.length()+1][text2.length()+1];
            return helper(text1,text2,text1.length(),text2.length(),memo);
        }
        public static int helper(String s1,String s2, int n1, int n2, Integer[][] memo){
            if(memo[n1][n2]!=null){
                return memo[n1][n2];
            }
            if(n1==0 || n2==0){
                return 0;
            }
            if(s1.charAt(n1-1)==s2.charAt(n2-1)){
                int res= helper(s1,s2,n1-1,n2-1,memo)+1;
                memo[n1][n2]=res;
                return res;
            }else{
                int reduceLeft= helper(s1,s2,n1-1,n2,memo);
                int reduceRight= helper(s1,s2,n1,n2-1,memo);
                int res= Math.max(reduceLeft,reduceRight);
                memo[n1][n2]=res;
                return res;
            }
        }

    public static void main(String[] args) {
        //Example 1:

        String text11 = "abcde", text12 = "ace";
        int output1= 3;

        //Example 2:

        String text21 = "abc", text22 = "abc";
        int output2= 3;

        //Example 3:

        String text31 = "abc", text32 = "def";
        int output3 =0;


        System.out.println("Recursive Memorization Solution:");
        int ans1= longestCommonSubsequenceMemorize(text11,text12);
        int ans2= longestCommonSubsequenceMemorize(text21,text22);
        int ans3= longestCommonSubsequenceMemorize(text31,text32);

        if(ans1==output1) {
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
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }
        System.out.println("Top Down Solution:");
        ans1= longestCommonSubsequenceTopDown(text11,text12);
        ans2= longestCommonSubsequenceTopDown(text21,text22);
        ans3= longestCommonSubsequenceTopDown(text31,text32);

        if(ans1==output1) {
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
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }
    }
}
