//2435. Paths in Matrix Whose Sum Is Divisible by K
//Solved
//Hard
//Topics
//premium lock icon
//Companies
//Hint
//You are given a 0-indexed m x n integer matrix grid and an integer k. You are currently at position (0, 0) and you want to reach position (m - 1, n - 1) moving only down or right.
//
//Return the number of paths where the sum of the elements on the path is divisible by k. Since the answer may be very large, return it modulo 109 + 7.
//
//
//
//Example 1:
//
//
//Input: grid = [[5,2,4],[3,0,5],[0,7,2]], k = 3
//Output: 2
//Explanation: There are two paths where the sum of the elements on the path is divisible by k.
//The first path highlighted in red has a sum of 5 + 2 + 4 + 5 + 2 = 18 which is divisible by 3.
//The second path highlighted in blue has a sum of 5 + 3 + 0 + 5 + 2 = 15 which is divisible by 3.
//Example 2:
//
//
//Input: grid = [[0,0]], k = 5
//Output: 1
//Explanation: The path highlighted in red has a sum of 0 + 0 = 0 which is divisible by 5.
//Example 3:
//
//
//Input: grid = [[7,3,4,9],[2,3,6,2],[2,3,7,0]], k = 1
//Output: 10
//Explanation: Every integer is divisible by 1 so the sum of the elements on every possible path is divisible by k.
//
//
//Constraints:
//
//m == grid.length
//n == grid[i].length
//1 <= m, n <= 5 * 104
//1 <= m * n <= 5 * 104
//0 <= grid[i][j] <= 100
//1 <= k <= 50
package DynamicProgramming;

import java.util.HashMap;

public class PathsInMatrixWhoseSumIsDivisibleByK_2435 {
    static int MOD = 1000000007;

    public static int numberOfPathsMemo(int[][] grid, int k) {
        Integer [][][] memo = new Integer[grid.length][grid[0].length][k];
        return helpermemo(grid, k, 0, 0, 0, memo);

        // return memo[grid.length][grid[0].length][0];
    }

    public static int helpermemo(int[][] grid, int k, int r, int c, int mod, Integer [][][] memo) {
        if(r==grid.length || c==grid[0].length){
            return 0;
        }
        int newMod = (grid[r][c]+mod)%k;
        if (r == grid.length - 1 && c == grid[0].length - 1) {
            return newMod % k == 0 ? 1 : 0;
        }
        if(memo[r][c][newMod]!=null){
            return memo[r][c][newMod];
        }
        // down:

        int down = helpermemo(grid, k, r + 1, c, newMod, memo)%MOD;
        // right
        int right = helpermemo(grid, k, r , c+1, newMod, memo)%MOD;

        memo[r][c][newMod]= (down+right)%MOD;
        return memo[r][c][newMod];
    }


        public  static int numberOfPathsBruteForce(int[][] grid, int k) {
            return helper(grid,k,0,0,0,new HashMap<>());
        }
        public static int helper(int [][] grid,int k, int r, int c, int sum, HashMap<String,Integer> memo){
            String key = r+","+c+","+sum;
            if(memo.containsKey(key)){
                return memo.get(key);
            }
            if(r==grid.length-1 && c== grid[0].length-1){
                return (sum+grid[r][c])%k==0? 1:0;
            }
            if(r==grid.length || c== grid[0].length){
                return 0;
            }
            // down
            int down =helper(grid,k,r+1,c,(sum+ grid[r][c])%k,memo)%MOD;
            // right
            int right =helper(grid,k,r,c+1,(sum+ grid[r][c])%k,memo)%MOD;
            int res=(down+right)%MOD;
            memo.put(key,res);
            return res;
        }

    public static void main(String[] args) {
        //Example 1:

        int [][] grid1 = {{5,2,4},{3,0,5},{0,7,2}};
        int k1 = 3;
        int output1= 2;

        //Example 2:

        int [][] grid2 = {{0,0}};
        int k2 = 5;
        int output2= 1;

        //Example 3:

        int [][] grid3 = {{7,3,4,9},{2,3,6,2},{2,3,7,0}};
        int k3 = 1;
        int output3= 10;


        System.out.println("Brute Force Approch :");
        int ans1 = numberOfPathsBruteForce(grid1,k1);
        int ans2 = numberOfPathsBruteForce(grid2,k2);
        int ans3 = numberOfPathsBruteForce(grid3,k3);
        if(output1==(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(output3==(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }

        System.out.println("Better Force Approch :");
        ans1 = numberOfPathsMemo(grid1,k1);
        ans2 = numberOfPathsMemo(grid2,k2);
        ans3 = numberOfPathsMemo(grid3,k3);
        if(output1==(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(output3==(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }


    }
}
