//62. Unique Paths
//Medium
//Topics
//Companies
//There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
//
//Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
//
//The test cases are generated so that the answer will be less than or equal to 2 * 109.
//
// 
//
//Example 1:
//
//
//Input: m = 3, n = 7
//Output: 28
//Example 2:
//
//Input: m = 3, n = 2
//Output: 3
//Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
//1. Right -> Down -> Down
//2. Down -> Down -> Right
//3. Down -> Right -> Down
// 
//
//Constraints:
//
//1 <= m, n <= 100
package Maths;

public class UniquePaths_62 {
	 public static int uniquePaths(int m, int n) {
	        return pathHelper(0,0,n,m);
	    }
	    public static int pathHelper(int r , int c, int m,int n){
	        if(r>=m || c>=n ){
	            return 1;
	        }
	        int goleft= pathHelper(r,c+1,m,n);
	        int goright= pathHelper(r+1,c,m,n);
	        return goleft+goright;
	    }
	
	public static void main(String[] args) {
		//Example 1:

		int m1 = 3, n1 = 7;
		int output1=28;
		
		//Example 2:
		
		int m2 = 3, n2 = 2;
		int output2=3;
		
		
		System.out.println(uniquePaths(m1, n1) );
		

	}

}
