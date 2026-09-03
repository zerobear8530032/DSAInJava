//Shortest Common Supersequence length
//Hard
//Topics
//premium lock icon
//Companies
//Hint
//Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences return the length of such sequence.
//
//A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.
//
//
//
//Example 1:
//
//Input: str1 = "abac", str2 = "cab"
//Output: 5
//Explanation:
//str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
//str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
//The answer provided is the shortest such string that satisfies these properties.
//Example 2:
//
//Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
//Output: 8
//
//
//Constraints:
//
//1 <= str1.length, str2.length <= 1000
//str1 and str2 consist of lowercase English letters.
package DynamicProgramming;

public class ShortestCommonSuperSequenceLength {
// approch : if we see 2 strings properly we can see
//  we can make a subsequence cotaining both sequences just by appending both s1,s2
//  but inorder to make sure its shortest we have to remove the repeating characters btw them
//  so we can find lcs of them which means the character which are common in btw them
//  now if we just keep the character unique in both strings s1,s2  and then we will have lcs *2 characters remaining
//    then we can just remove the  lcs character 1 time making it shortest
//    time compleixty : O (n*m)
//    space compleixty : O (n*m)
    public static int superSequenceLength(String s1, String s2){
        Integer [][] dp = new Integer[s1.length()+1][s2.length()+1];
        for(int n1=0;n1<dp.length;n1++){
            for(int n2=0;n2<dp[n1].length;n2++){
                if(n1==0 || n2==0){
                    dp[n1][n2]=0;
                }
            }
        }
        for(int n1=1;n1<dp.length;n1++){
            for(int n2=1;n2<dp[n1].length;n2++){
                if(s1.charAt(n1-1) ==s2.charAt(n2-1)){
                    dp[n1][n2]= dp[n1-1][n2-1]+1;
                }else{
                    int reduceLeft= dp[n1-1][n2];
                    int reduceRight= dp[n1][n2-1];
                    dp[n1][n2]= Math.max(reduceLeft,reduceRight);
                }
            }
        }
        int lcs= dp[s1.length()][s2.length()];
        return s1.length()+s2.length()-lcs;
    }

    public static void main(String[] args) {
        // Example 1:
        String s11 = "abac", s12 = "cab";
        int output1 = 5;

        //Example 2:
        String s21 = "aaaaaaaa", s22 = "aaaaaaaa";
        int output2 = 8;

        int ans1= superSequenceLength(s11,s12);
        int ans2= superSequenceLength(s21,s22);
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
