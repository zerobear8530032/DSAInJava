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
//Output: "cabac"
//Explanation:
//str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
//str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
//The answer provided is the shortest such string that satisfies these properties.
//Example 2:
//
//Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
//Output: "aaaaaaaa"
//
//
//Constraints:
//
//1 <= str1.length, str2.length <= 1000
//str1 and str2 consist of lowercase English letters.
package DynamicProgramming;

public class ShortestCommonSuperSequence_1092 {
    // approch : we can use similr way to priint like we did with lcs here when we have a choice to cjoose
//    bigger number we als include that character lso rest is same
//    time compleixty : O (n*m)
//    space compleixty : O (n*m)
    public static String superSequence(String s1, String s2){
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
        int n1= s1.length();
        int n2= s2.length();
        StringBuilder res= new StringBuilder();
        while(n1>0 && n2>0){
            if(s1.charAt(n1-1)==s2.charAt(n2-1)){
                res.append(s1.charAt(n1-1));
                n1--;
                n2--;
            }else{
                if(dp[n1][n2-1]<dp[n1-1][n2]){
                    res.append(s1.charAt(n1-1));
                    n1--;
                }else{
                    res.append(s2.charAt(n2-1));
                    n2--;
                }
            }
        }
        // System.out.println(res+" "+n1+" "+n2);
        while(n1>0){
            res.append(s1.charAt(n1-1));
            n1--;
        }
        while(n2>0){
            res.append(s2.charAt(n2-1));
            n2--;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        // Example 1:
        String s11 = "abac", s12 = "cab";
        String output1 = "cabac";

        //Example 2:
        String s21 = "aaaaaaaa", s22 = "aaaaaaaa";
        String output2 = "aaaaaaaa";

        String ans1= superSequence(s11,s12);
        String ans2= superSequence(s21,s22);
        if(ans1.equals(output1)){
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2.equals(output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
    }
}
