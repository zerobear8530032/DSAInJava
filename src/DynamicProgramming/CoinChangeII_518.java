//518. Coin Change II
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
//
//Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
//
//You may assume that you have an infinite number of each kind of coin.
//
//The final answer is guaranteed to fit into a signed 32-bit integer.
//
//
//
//Example 1:
//
//Input: amount = 5, coins = [1,2,5]
//Output: 4
//Explanation: there are four ways to make up the amount:
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
//Example 2:
//
//Input: amount = 3, coins = [2]
//Output: 0
//Explanation: the amount of 3 cannot be made up just with coins of 2.
//Example 3:
//
//Input: amount = 10, coins = [10]
//Output: 1
//
//
//Constraints:
//
//1 <= coins.length <= 300
//1 <= coins[i] <= 5000
//All the values of coins are unique.
//0 <= amount <= 5000
package DynamicProgramming;

public class CoinChangeII_518 {

    //    we just used take skip method with unbounded knap sack variation and memorized it
    //    time complexity : O(n*m)
    //    space complexity : O(n*m)
    public static int changeMemo(int amount, int[] coins) {
        Integer [][] memo= new Integer[coins.length][amount];
        return helper(coins,amount,coins.length,memo);
    }
    //    we just convert our memorization approch to top down
    //    time complexity : O(n*m)
    //    space complexity : O(n*m)
    public static int changeTopDown(int amount, int[] coins) {
        Integer [][] dp = new Integer[coins.length+1][amount+1];
        for(int n=0;n<dp.length;n++){
            for(int a=0;a<dp[n].length;a++){
                if(a==0){
                    dp[n][a]=1;
                }else if(n==0){
                    dp[n][a]=0;
                }
            }
        }
        for(int n=1;n<dp.length;n++){
            for(int a=1;a<dp[n].length;a++){
                if(coins[n-1]<=a){
                    int take = dp[n][a-coins[n-1]];
                    int skip = dp[n-1][a];
                    dp[n][a]=take+skip;
                }else{
                    int skip = dp[n-1][a];
                    dp[n][a]=skip;
                }
            }
        }
        return dp[coins.length][amount];
    }

    public static int helper(int [] coins, int amount , int n,Integer [][] memo){
        if(memo[n][amount]!=null){
            return memo[n][amount];
        }
        if(n==0){
            return amount==0? 1 : 0;
        }

        if(coins[n-1]<=amount){
            int take = helper(coins,amount-coins[n-1],n,memo);
            int skip = helper(coins,amount,n-1,memo);
            int res = take + skip;
            memo[n][amount]=res;
            return res;
        }
        int res = helper(coins,amount,n-1,memo);
        memo[n][amount]=res;
        return res;
    }
    public static void main(String[] args) {


        //Example 1:

        int [] coins1={1,2,5};
        int amount1= 5;
        int output1=4;

        //Example 2:

        int [] coins2={2};
        int amount2= 3;
        int output2=0;

        //Example 3:

        int [] coins3={10};
        int amount3= 10;
        int output3=1;

        System.out.println("Recusive Memorization Approch :");
        int ans1= changeMemo(amount1,coins1);
        int ans2= changeMemo(amount2,coins2);
        int ans3= changeMemo(amount3,coins3);
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
        System.out.println("Top Down Approch :");
        ans1= changeTopDown(amount1,coins1);
        ans2= changeTopDown(amount2,coins2);
        ans3= changeTopDown(amount3,coins3);
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
