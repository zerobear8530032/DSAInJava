//Longest Repeating Subsequence
//Solved
//Difficulty: MediumAccuracy: 48.54%Submissions: 149K+Points: 4Average Time: 20m
//Given string str, find the length of the longest repeating subsequence such that it can be found twice in the given string.
//
//The two identified subsequences A and B can use the same ith character from string s if and only if that ith character has different indices in A and B. For example, A = "xax" and B = "xax" then the index of the first "x" must be different in the original string for A and B.
//
//Examples :
//
//Input: s = "axxzxy"
//Output: 2
//Explanation: The given array with indexes looks like
//a x x z x y
//0 1 2 3 4 5
//The longest subsequence is "xx". It appears twice as explained below.
//subsequence A
//x x
//0 1  <-- index of subsequence A
//------
//1 2  <-- index of s
//subsequence B
//x x
//0 1  <-- index of subsequence B
//------
//2 4  <-- index of s
//We are able to use character 'x' (at index 2 in s) in both subsequences as it appears on index 1 in subsequence A and index 0 in subsequence B.
//Input: s = "axxxy"
//Output: 2
//Explanation: The given array with indexes looks like
//a x x x y
//0 1 2 3 4
//The longest subsequence is "xx". It appears twice as explained below.
//subsequence A
//x x
//0 1  <-- index of subsequence A
//------
//1 2  <-- index of s
//subsequence B
//x x
//0 1  <-- index of subsequence B
//------
//2 3  <-- index of s
//We are able to use character 'x' (at index 2 in s) in both subsequencesas it appears on index 1 in subsequence A and index 0 in subsequence B.
//Constraints:
//1 <= s.size() <= 103
package DynamicProgramming;

public class LongestRepeatingSubsequence_GFG {
//    approch : we can solve it using LCS just taje the character where n1 , n2 are nt equal
//    time complexity : O(n*m)
//    space complexity : O(n*m)
    public static int longestRepSubseq(String s) {
        String s1=s;
        String s2=s;
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
                if(s1.charAt(n1-1)==s2.charAt(n2-1) && n1!=n2){
                    dp[n1][n2]= dp[n1-1][n2-1]+1;
                }else{
                    dp[n1][n2]= Math.max(dp[n1-1][n2],dp[n1][n2-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    public static void main(String[] args) {
        String s1= "axxxy";
        int output1= 2;

        String s2= "axxzxy";
        int output2 = 2;

        int ans1= longestRepSubseq(s1);
        int ans2= longestRepSubseq(s2);

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
