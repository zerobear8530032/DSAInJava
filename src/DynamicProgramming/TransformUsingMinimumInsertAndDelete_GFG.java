//Transform using Minimum Insert and Delete
//Solved
//Difficulty: MediumAccuracy: 65.29%Submissions: 83K+Points: 4
//Given two strings s1 and s2. The task is to remove or insert the minimum number of characters from/in s1 to transform it into s2. It could be possible that the same character needs to be removed from one point of s1 and inserted into another point.
//
//Examples :
//
//Input: s1 = "heap", s2 = "pea"
//Output: 3
//Explanation: 'p' and 'h' deleted from heap. Then, 'p' is inserted at the beginning.
//Input : s1 = "geeksforgeeks", s2 = "geeks"
//Output: 8
//Explanation: 8 deletions, i.e. remove all characters of the string "forgeeks".
//Constraints:
//
//1 ≤ s1.size(), s2.size() ≤ 1000
package DynamicProgramming;

public class TransformUsingMinimumInsertAndDelete_GFG {
//    approch : if we see it we can find a lcs of 2 strings
//    which will give common sequence btw 2 strings now after removing lcs from string 1
//    rest of the characters needs to be deleted
//    and after that if their are characters which are still missing can be inserted in string 2
//    thus making it text1.length()-lcs+ text2.length()-lcs; as answer
//    time complexity : O(n*m)
//    space complexity : O(n*m)
    public static int minOperations(String text1, String text2) {
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
        int lcs=dp[text1.length()][text2.length()];
        return text1.length()-lcs+ text2.length()-lcs;
    }
    public static void main(String[] args) {
        String s11 = "heap", s12 = "pea";
        int output1= 3;

        String s21 = "geeksforgeeks", s22 = "geeks";
        int output2 =8;

        int ans1= minOperations(s11,s12);
        int ans2= minOperations(s21,s22);

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
