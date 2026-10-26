package DynamicProgramming;

public class StoneGame {
// approch :
//    we can simulate the game using a score where alice try to maximize score while
//    the bob turn we minimize score and subtract the score
//    at the end we have our answer as positive means alice won other wise bob
//    time complexity : O(n*m)
//    space complexity : O(n*m)
    public static boolean stoneGame(int[] piles) {
        Integer[][][] dp =
                new Integer[piles.length][piles.length][2];

        return helper(piles, 0, piles.length - 1, 1, dp) > 0;
    }

    public static int helper(
            int[] piles,
            int start,
            int end,
            int aliceTurn,
            Integer[][][] dp
    ) {
        if (start > end) {
            return 0;
        }

        if (dp[start][end][aliceTurn] != null) {
            return dp[start][end][aliceTurn];
        }

        if (aliceTurn == 1) {
            int takeLeft =
                    helper(piles, start + 1, end, 0, dp)
                            + piles[start];

            int takeRight =
                    helper(piles, start, end - 1, 0, dp)
                            + piles[end];

            return dp[start][end][aliceTurn] =
                    Math.max(takeLeft, takeRight);

        } else {
            int takeLeft =
                    helper(piles, start + 1, end, 1, dp)
                            - piles[start];

            int takeRight =
                    helper(piles, start, end - 1, 1, dp)
                            - piles[end];

            return dp[start][end][aliceTurn] =
                    Math.min(takeLeft, takeRight);
        }
    }

    public static void main(String[] args) {
        int[] piles1 = {1, 2, 3, 1};
        boolean output1 = true;

        int[] piles2 = {2, 1};
        boolean output2 = true;

        System.out.println("Stone Game - DP Memoization:");

        boolean ans1 = stoneGame(piles1);
        boolean ans2 = stoneGame(piles2);

        if (ans1 == output1) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output: " + output1);
            System.out.println("Your Answer: " + ans1);
        }

        if (ans2 == output2) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output: " + output2);
            System.out.println("Your Answer: " + ans2);
        }
    }
}
