//322. Coin Change
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
//
//Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
//
//You may assume that you have an infinite number of each kind of coin.
//
// Example 1:
// coins = [1,2,5], amount = 11
// Output = 3
// Explanation: 11 = 5 + 5 + 1
//
// Example 2:
// coins = [2], amount = 3
// Output = -1
//
// Example 3:
// coins = [1], amount = 0
// Output = 0

package DynamicProgramming;

public class CoinChange_322 {
// approch :
//    here we can simply make  it recusive to bottom up tabulation
//    time complexity : O(n*m)
//    space complexity : O(n*m)
    public static int coinChangeTopDown(int[] coins, int amount) {

        Integer[][] dp = new Integer[coins.length + 1][amount + 1];

        for (int n = 0; n < dp.length; n++) {
            for (int a = 0; a < dp[n].length; a++) {

                if (n == 0 && a == 0) {
                    dp[n][a] = 0;
                } else if (n == 0) {
                    dp[n][a] = Integer.MAX_VALUE;
                }
            }
        }

        for (int n = 1; n < dp.length; n++) {

            for (int a = 0; a < dp[n].length; a++) {

                if (coins[n - 1] <= a) {

                    int take = dp[n][a - coins[n - 1]];

                    if (take != Integer.MAX_VALUE) {
                        take++;
                    }

                    int skip = dp[n - 1][a];

                    dp[n][a] = Math.min(take, skip);

                } else {

                    dp[n][a] = dp[n - 1][a];
                }
            }
        }

        int result = dp[coins.length][amount];

        return result == Integer.MAX_VALUE ? -1 : result;
    }


// approch :
//    here we can use simple unbounded knapsack question :
//    only thing we handle is when their is no valid solution we return max_value
//    and if valid solution is return we return sol +1 to bove calls
//    time complexity : O(n*m)
//    space complexity : O(n*m)
    public static int coinChangeMemorize(int[] coins, int amount) {

        Integer[][] memo =
                new Integer[coins.length + 1][amount + 1];

        int result =
                helper(coins, amount, coins.length, memo);

        return result == Integer.MAX_VALUE ? -1 : result;
    }


    public static int helper(
            int[] coins,
            int amount,
            int n,
            Integer[][] memo) {

        if (memo[n][amount] != null) {
            return memo[n][amount];
        }

        if (n == 0 && amount == 0) {
            return 0;
        }

        if (n == 0) {
            return Integer.MAX_VALUE;
        }

        if (coins[n - 1] <= amount) {

            int take =
                    helper(
                            coins,
                            amount - coins[n - 1],
                            n,
                            memo
                    );

            if (take != Integer.MAX_VALUE) {
                take++;
            }

            int skip =
                    helper(
                            coins,
                            amount,
                            n - 1,
                            memo
                    );

            int result = Math.min(take, skip);

            memo[n][amount] = result;

            return result;

        } else {

            int result =
                    helper(
                            coins,
                            amount,
                            n - 1,
                            memo
                    );

            memo[n][amount] = result;

            return result;
        }
    }


    public static void main(String[] args) {

        // Example 1

        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        int output1 = 3;


        // Example 2

        int[] coins2 = {2};
        int amount2 = 3;
        int output2 = -1;


        // Example 3

        int[] coins3 = {1};
        int amount3 = 0;
        int output3 = 0;


        System.out.println("Recursive Memorization Solution:");

        int ans1 =
                coinChangeMemorize(coins1, amount1);

        int ans2 =
                coinChangeMemorize(coins2, amount2);

        int ans3 =
                coinChangeMemorize(coins3, amount3);


        if (ans1 == output1) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output : " + output1);
            System.out.println("Your Answer : " + ans1);
        }


        if (ans2 == output2) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output : " + output2);
            System.out.println("Your Answer : " + ans2);
        }


        if (ans3 == output3) {
            System.out.println("Case 3 Passed");
        } else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output : " + output3);
            System.out.println("Your Answer : " + ans3);
        }


        System.out.println("Top Down Solution:");

        ans1 =
                coinChangeTopDown(coins1, amount1);

        ans2 =
                coinChangeTopDown(coins2, amount2);

        ans3 =
                coinChangeTopDown(coins3, amount3);


        if (ans1 == output1) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output : " + output1);
            System.out.println("Your Answer : " + ans1);
        }


        if (ans2 == output2) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output : " + output2);
            System.out.println("Your Answer : " + ans2);
        }


        if (ans3 == output3) {
            System.out.println("Case 3 Passed");
        } else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output : " + output3);
            System.out.println("Your Answer : " + ans3);
        }
    }
}