//3665. Twisted Mirror Path Count
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given an m x n binary grid grid where:
//
//grid[i][j] == 0 represents an empty cell, and
//grid[i][j] == 1 represents a mirror.
//A robot starts at the top-left corner of the grid (0, 0) and wants to reach the bottom-right corner (m - 1, n - 1). It can move only right or down. If the robot attempts to move into a mirror cell, it is reflected before entering that cell:
//
//If it tries to move right into a mirror, it is turned down and moved into the cell directly below the mirror.
//If it tries to move down into a mirror, it is turned right and moved into the cell directly to the right of the mirror.
//If this reflection would cause the robot to move outside the grid boundaries, the path is considered invalid and should not be counted.
//
//Return the number of unique valid paths from (0, 0) to (m - 1, n - 1).
//
//Since the answer may be very large, return it modulo 109 + 7.
//
//Note: If a reflection moves the robot into a mirror cell, the robot is immediately reflected again based on the direction it used to enter that mirror: if it entered while moving right, it will be turned down; if it entered while moving down, it will be turned right. This process will continue until either the last cell is reached, the robot moves out of bounds or the robot moves to a non-mirror cell.
//
//
//
//Example 1:
//
//Input: grid = [[0,1,0],[0,0,1],[1,0,0]]
//
//Output: 5
//
//Explanation:
//
//Number	Full Path
//1	(0, 0) → (0, 1) [M] → (1, 1) → (1, 2) [M] → (2, 2)
//2	(0, 0) → (0, 1) [M] → (1, 1) → (2, 1) → (2, 2)
//3	(0, 0) → (1, 0) → (1, 1) → (1, 2) [M] → (2, 2)
//4	(0, 0) → (1, 0) → (1, 1) → (2, 1) → (2, 2)
//5	(0, 0) → (1, 0) → (2, 0) [M] → (2, 1) → (2, 2)
//[M] indicates the robot attempted to enter a mirror cell and instead reflected.
//
//Example 2:
//
//Input: grid = [[0,0],[0,0]]
//
//Output: 2
//
//Explanation:
//
//Number	Full Path
//1	(0, 0) → (0, 1) → (1, 1)
//2	(0, 0) → (1, 0) → (1, 1)
//Example 3:
//
//Input: grid = [[0,1,1],[1,1,0]]
//
//Output: 1
//
//Explanation:
//
//Number	Full Path
//1	(0, 0) → (0, 1) [M] → (1, 1) [M] → (1, 2)
//(0, 0) → (1, 0) [M] → (1, 1) [M] → (2, 1) goes out of bounds, so it is invalid.
//
//
//Constraints:
//
//m == grid.length
//n == grid[i].length
//2 <= m, n <= 500
//grid[i][j] is either 0 or 1.
//grid[0][0] == grid[m - 1][n - 1] == 0
package DynamicProgramming;

public class TwistedMirrorPathCount_3665 {
    static final int MOD= 1000000007;
    public static int uniquePaths(int[][] grid) {
        Integer [][][] dp = new Integer [grid.length][grid[0].length][3];
        return helper(grid,0,0,' ',dp);
    }

    public static int helper(int [][] grid , int r , int c, char direction, Integer [][][] dp){
        if(r<0 || c<0 || r==grid.length || c==grid[0].length){
            return 0;
        }
        int dirIndex= -1;
        if(direction==' '){
            dirIndex=0;
        }else if(direction=='R'){
            dirIndex=1;
        }else{
            dirIndex=2;
        }

        if(r==grid.length-1 && c==grid[0].length-1){
            return 1;
        }
        if(dp[r][c][dirIndex]!=null){
            return dp[r][c][dirIndex];
        }
        int value = grid[r][c];
        if(value ==0){
            int down = helper(grid,r+1,c,'D',dp);
            int right = helper(grid,r,c+1,'R',dp);
            return dp[r][c][dirIndex]=(down + right)%MOD;
        }else{
            if(direction=='D'){
                return dp[r][c][dirIndex]=helper(grid,r,c+1,'R',dp);
            }else{
                return dp[r][c][dirIndex]= helper(grid,r+1,c,'D',dp);
            }
        }
    }
    public static void main(String[] args) {
        //Example 1:

        int [][] grid1 = {{0,1,0},{0,0,1},{1,0,0}};
        int output1= 5;

        //Example 2:

        int [][] grid2 = {{0,0},{0,0}};
        int output2= 2;

        //Example 3:

        int [][] grid3 = {{0,1,1},{1,1,0}};
        int output3= 1;

        int ans1=uniquePaths(grid1);
        int ans2=uniquePaths(grid2);
        int ans3=uniquePaths(grid3);


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
