//1219. Path with Maximum Gold
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.
//
//Return the maximum amount of gold you can collect under the conditions:
//
//Every time you are located in a cell you will collect all the gold in that cell.
//From your position, you can walk one step to the left, right, up, or down.
//You can't visit the same cell more than once.
//Never visit a cell with 0 gold.
//You can start and stop collecting gold from any position in the grid that has some gold.
// 
//
//Example 1:
//
//Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
//Output: 24
//Explanation:
//[[0,6,0],
// [5,8,7],
// [0,9,0]]
//Path to get the maximum gold, 9 -> 8 -> 7.
//Example 2:
//
//Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
//Output: 28
//Explanation:
//[[1,0,7],
// [2,0,6],
// [3,4,5],
// [0,3,0],
// [9,0,20]]
//Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
// 
//
//Constraints:
//
//m == grid.length
//n == grid[i].length
//1 <= m, n <= 15
//0 <= grid[i][j] <= 100
//There are at most 25 cells containing gold.

package Backtracking;

import java.util.List;

public class PathWithMaximumGold_1219 {
	
	
//	approch: we check for each cell and use dfs to get max gold possible
//	time complexity : O(k × k!), k ≤ 25
//	Space Complexity: O(k)

	public static  int getMaximumGold(int[][] grid) {
		int res = 0;
		for(int i =0;i<grid.length;i++) {
			for(int j =0;j<grid[i].length;j++) {
				if(grid[i][j]!=0) {
					res= Math.max(res,dfs(grid,i,j));
				}
			}
		}
		return res;
        
    }
	
//	here in dfs we try to go in each direction and get max gold  of that direction
//	and only accept gold from the direction which have most gold
	public static int dfs(int [][] grid, int r, int c) {
		if(r<0 || c<0 || r==grid.length || c==grid[0].length) {
			return 0;
		}
		if(grid[r][c]==0) {
			return 0;
		}
		int res =grid[r][c];
		int temp = grid[r][c];
		grid[r][c]=0;

		int maxGold = 0;
		maxGold = Math.max(maxGold, dfs(grid, r - 1, c));
		maxGold = Math.max(maxGold, dfs(grid, r + 1, c));
		maxGold = Math.max(maxGold, dfs(grid, r, c - 1));
		maxGold = Math.max(maxGold, dfs(grid, r, c + 1));
		
		grid[r][c] = temp;  // backtrack
		
		return res + maxGold;
	}
	

	public static void main(String[] args) {
		//Example 1:

		int [][] grid1 = {{0,6,0},{5,8,7},{0,9,0}};
		int output1=24;

		//Example 2:

		int [][] grid2 = {{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}};
		int output2=28;
		

		
		int ans1= getMaximumGold(grid1);
		int ans2= getMaximumGold(grid2);
		
		if(output1==(ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);
		}
		if(output2 == (ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ output2);
			System.out.println("Your Answer :"+ ans2);
		}
		

	}

}
