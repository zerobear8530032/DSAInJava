//72. Edit Distance
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
//
//You have the following three operations permitted on a word:
//
//Insert a character
//Delete a character
//Replace a character
//
//
//Example 1:
//
//Input: word1 = "horse", word2 = "ros"
//Output: 3
//Explanation:
//horse -> rorse (replace 'h' with 'r')
//rorse -> rose (remove 'r')
//rose -> ros (remove 'e')
//Example 2:
//
//Input: word1 = "intention", word2 = "execution"
//Output: 5
//Explanation:
//intention -> inention (remove 't')
//inention -> enention (replace 'i' with 'e')
//enention -> exention (replace 'n' with 'x')
//exention -> exection (replace 'n' with 'c')
//exection -> execution (insert 'u')
//
//
//Constraints:
//
//0 <= word1.length, word2.length <= 500
//word1 and word2 consist of lowercase English letters.
package DynamicProgramming;

public class Edit_Distance_72 {
//   approch :
//    we can use similar way we use in lcs just by carully moving pointers and matching
//    string we can simulate process
//    time complexity : O(N*M)
//    space complexity : O(N*M)
    public static int minDistance(String word1, String word2) {
        Integer [][] dp= new Integer [word1.length()+1][word2.length()+1];
        int lcs = lcs(word1,word2,word1.length(),word2.length(),dp);
        return lcs;
    }

    public static int lcs(String w1, String w2, int idx1, int idx2, Integer [][] dp){
        if(idx1==0 || idx2==0){
            return Math.max(idx1,idx2);
        }
        if(dp[idx1][idx2]!=null){
            return dp[idx1][idx2];
        }
        if(w1.charAt(idx1-1)!=w2.charAt(idx2-1)){
            int insert = lcs(w1,w2,idx1,idx2-1,dp)+1;
            int replace = lcs(w1,w2,idx1-1,idx2-1,dp)+1;
            int delete = lcs(w1,w2,idx1-1,idx2,dp)+1;
            int res= Math.min(insert,Math.min(replace,delete));
            return dp[idx1][idx2]=res;
        }else{
            int res = lcs(w1,w2,idx1-1,idx2-1,dp);
            return dp[idx1][idx2]=res;
        }
    }
    public static void main(String[] args) {

        //Example 1:

        String word11 = "horse", word12 = "ros";

        int output1= 3;

        //Example 2:

        String word21 = "intention", word22 = "execution";
        int output2=5;

        int ans1= minDistance(word11,word12);
        int ans2= minDistance(word21,word22);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
    }
}
