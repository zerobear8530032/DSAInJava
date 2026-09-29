//2267. Check if There Is a Valid Parentheses String Path
//Solved
//Hard
//Topics
//premium lock icon
//Companies
//Hint
//A parentheses string is a non-empty string consisting only of '(' and ')'. It is valid if any of the following conditions is true:
//
//It is ().
//It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.
//It can be written as (A), where A is a valid parentheses string.
//You are given an m x n matrix of parentheses grid. A valid parentheses string path in the grid is a path satisfying all of the following conditions:
//
//The path starts from the upper left cell (0, 0).
//The path ends at the bottom-right cell (m - 1, n - 1).
//The path only ever moves down or right.
//The resulting parentheses string formed by the path is valid.
//Return true if there exists a valid parentheses string path in the grid. Otherwise, return false.
//
//
//
//Example 1:
//
//
//Input: grid = [["(","(","("],[")","(",")"],["(","(",")"],["(","(",")"]]
//Output: true
//Explanation: The above diagram shows two possible paths that form valid parentheses strings.
//The first path shown results in the valid parentheses string "()(())".
//The second path shown results in the valid parentheses string "((()))".
//Note that there may be other valid parentheses string paths.
//Example 2:
//
//
//Input: grid = [[")",")"],["(","("]]
//Output: false
//Explanation: The two possible paths form the parentheses strings "))(" and ")((". Since neither of them are valid parentheses strings, we return false.
//
//
//Constraints:
//
//m == grid.length
//n == grid[i].length
//1 <= m, n <= 100
//grid[i][j] is either '(' or ')'.
package DynamicProgramming;

public class CheckIfThereIsAValidParentheses_2267 {
    public static boolean hasValidPath(char[][] grid) {
        Boolean [][][] dp= new Boolean [grid.length+1][grid[0].length+1][grid.length+grid[0].length+1];
        return helper(grid,grid.length-1,grid[0].length-1,0,dp);
    }

    public static boolean helper(char [][] grid , int r , int c , int open, Boolean [][][] dp){
        if(r<0 || c<0 || open<0){
            return false;
        }
        if(dp[r][c][open]!=null){
            return dp[r][c][open];
        }
        if(r==0 && c==0){
            open+= grid[r][c]==')'? 1:-1;
            return open ==0;
        }
        char ch = grid[r][c];
        int change = ch ==')' ? 1:-1;

        boolean up = helper(grid,r-1,c,open+change,dp);
        boolean right = helper(grid,r,c-1,open+change,dp);
        return dp[r][c][open]=up || right;
    }

    public static void main(String[] args) {
        //Example 1:

        char [][]grid1 = {{'(','(','('},{')','(',')'},{'(','(',')'},{'(','(',')'}};
        boolean output1= true;

        //Example 2:

        char [][] grid2 = {{')',')'},{'(','('}};
        boolean output2= false;

        boolean ans1= hasValidPath(grid1);
        boolean ans2= hasValidPath(grid2);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        
    }
}
