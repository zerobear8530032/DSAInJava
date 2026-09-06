//92. Is Subsequence
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
//
//A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
//
//
//
//Example 1:
//
//Input: s = "abc", t = "ahbgdc"
//Output: true
//Example 2:
//
//Input: s = "axc", t = "ahbgdc"
//Output: false
//
//
//Constraints:
//
//0 <= s.length <= 100
//0 <= t.length <= 104
//s and t consist only of lowercase English letters.
//
//
//Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
package DynamicProgramming;

public class IsSubsequence_92 {
    public static boolean isSubsequence(String s1, String s2) {
        Integer [][] dp= new Integer[s1.length()+1][s2.length()+1];
        for(int n1=0;n1<dp.length;n1++){
            for(int n2=0;n2<dp[n1].length;n2++){
                if(n1==0 || n2==0){
                    dp[n1][n2]=0;
                }
            }
        }
        for(int n1=1;n1<dp.length;n1++){
            for(int n2=1;n2<dp[n1].length;n2++){
                if(s1.charAt(n1-1)==s2.charAt(n2-1)){
                    dp[n1][n2]= dp[n1-1][n2-1]+1;
                }else{
                    dp[n1][n2]= Math.max(dp[n1-1][n2],dp[n1][n2-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()]==s1.length();
    }
    public static void main(String[] args) {
        //Example 1:

        String s1 = "abc", t1 = "ahbgdc";
        boolean output1=true;

        //Example 2:

        String s2 = "axc", t2 = "ahbgdc";
        boolean output2= false;


        boolean ans1= isSubsequence(s1,t1);
        boolean ans2= isSubsequence(s2,t2);
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
