//1312. Minimum Insertion Steps to Make a String Palindrome
//Solved
//Hard
//Topics
//premium lock icon
//Companies
//Hint
//Given a string s. In one step you can insert any character at any index of the string.
//
//Return the minimum number of steps to make s palindrome.
//
//A Palindrome String is one that reads the same backward as well as forward.
//
//
//
//Example 1:
//
//Input: s = "zzazz"
//Output: 0
//Explanation: The string "zzazz" is already palindrome we do not need any insertions.
//Example 2:
//
//Input: s = "mbadm"
//Output: 2
//Explanation: String can be "mbdadbm" or "mdbabdm".
//Example 3:
//
//Input: s = "leetcode"
//Output: 5
//Explanation: Inserting 5 characters the string becomes "leetcodocteel".
//
//
//Constraints:
//
//1 <= s.length <= 500
//s consists of lowercase English letters.
package DynamicProgramming;

public class MinimumInsertionStepsToMakeAStringPalindrome_1312 {
//    approch : if we find Longest palindromic subsequence we can say the rest of character
//    can be inserted any where to make the string palindromic
//    time complexity : O(n*m)
//    space complexity : O(n*m)
    public  static int minInsertions(String s) {
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
        //Example 1:

        String s1= "zzazz";
        int output1= 0;

        //Example 2:

        String s2 = "mbadm";
        int output2= 2;

        //Example 3:

        String s3 = "leetcode";
        int output3=5;

        int ans1=minInsertions(s1);
        int ans2=minInsertions(s2);
        int ans3=minInsertions(s3);

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
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }

    }
}
