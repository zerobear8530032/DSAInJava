//Rod Cutting
//Solved
//Difficulty: MediumAccuracy: 60.66%Submissions: 229K+Points: 4Average Time: 20m
//Given a rod of length n inches and an array price[], where price[i] denotes the value of a piece of length i (1-based Index). Determine the maximum value obtainable by cutting up the rod and selling the pieces.
//
//Note: The value of n is equal to the size of price array.
//
//Example:
//
//Input: price[] = [1, 5, 8, 9, 10, 17, 17, 20]
//Output: 22
//Explanation: The maximum obtainable value is 22 by cutting in two pieces of lengths 2 and 6, i.e., 5 + 17 = 22.
//Input: price[] = [3, 5, 8, 9, 10, 17, 17, 20]
//Output: 24
//Explanation: The maximum obtainable value is 24 by cutting the rod into 8 pieces of length 1, i.e, 8*price[1] = 8*3 = 24.
//Input: price[] = [3]
//Output: 3
//Explanation: There is only 1 way to pick a piece of length 1.
//Constraints:
//
//1 ≤ price.size() ≤ 103
//1 ≤ price[i] ≤ 106
package DynamicProgramming;

public class RodCutting_GFG {
//    we can use the take and skip algo but here we can take the current index until our
//    current rod length allow it
//    time complexity : O(n*m)
//    space complexity : O(n*m)
    public static int cutRodMemo(int[] price) {
        Integer [][] memo = new Integer[price.length+1][price.length+1];
        return helper(price,price.length,price.length,memo);
    }
    public  static int helper(int [] price, int  rodSize , int n,Integer [][] memo){
        if(memo[n][rodSize]!=null){
            return memo[n][rodSize];
        }
        if(n==0 || rodSize==0){
            return 0;
        }
        if(rodSize>=n){
            int cut = helper(price,rodSize-n,n,memo)+price[n-1];
            int skip = helper(price,rodSize,n-1,memo);
            int res= Math.max(cut,skip);
            memo[n][rodSize]=res;
            return res;
        }
        memo[n][rodSize]=helper(price,rodSize,n-1,memo);
        return memo[n][rodSize];
    }

    //    approch we can convert recursive  to top down dp
//    time complexity : O(n*m)
//    space complexity : O(n*m)

    public static int cutRodTopDown(int[] price) {
        Integer [][] dp = new Integer[price.length+1][price.length+1];
        for(int n=0;n<dp.length;n++){
            for(int r=0;r<dp[n].length;r++){
                if(n==0 || r==0){
                    dp[n][r]=0;
                }
            }
        }
        for(int n=1;n<dp.length;n++){
            for(int r=1;r<dp[n].length;r++){
                if(r>=n){
                    int cut = dp[n][r-n]+price[n-1];
                    int skip = dp[n-1][r];
                    dp[n][r]= Math.max(cut,skip);
                }else{
                    dp[n][r]=dp[n-1][r];
                }
            }
        }
        return dp[price.length][price.length];
    }
    public static void main(String[] args) {
        //Example:

        int [] price1 = {1, 5, 8, 9, 10, 17, 17, 20};
        int output1= 22;

        int [] price2 = {3, 5, 8, 9, 10, 17, 17, 20};
        int output2=24;

        int [] price3 = {3};
        int output3= 3;

        System.out.println("Top Down DP");

        int ans1= cutRodTopDown(price1);
        int ans2= cutRodTopDown(price2);
        int ans3= cutRodTopDown(price3);

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
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }
        System.out.println("Recursive Memorization DP");

        ans1= cutRodMemo(price1);
        ans2= cutRodMemo(price2);
        ans3= cutRodMemo(price3);

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
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }

    }

}
