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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class UniquePaths_62 {
//	brute force approch :
//	using recursion we can solve this question
//	not the most efficient way it will take 2 ^n times
//	time complexxity :O(2^n + 2^m)
//	space : O(n)
	 public static int uniquePaths(int m, int n) {
	        return pathHelper(0,0,n,m);
	    }
	    public static int pathHelper(int currR , int currC, int m,int n){
	    	 if(currR>=m || currC>=n) {
	    		 return 0;
	    	 }
	    	 if(currR==m-1 && currC==n-1) {
	    		 return 1;
	    	 }
	    	 
	    	 int ans = pathHelper(currR+1,currC,m,n);
	    	 ans=ans+pathHelper(currR,currC+1,m,n);
	    	 return ans;
	    }
	    
//	better approch :
//	we can consider the number of path tp reach the target by checking form
//	starting till end wher we take end as 1 
//	and to reach right we need 1 step 
//	similartly to reach from one positiobn before we need 1 + next position
//	simialr we can do it for each and every path 
//	time complexxity :O(m*n)
//	space : O((m+1)*(n+1))
	    public static int uniquePathsBetter(int m, int n) {
	    	int matrix [][]= new int [m+1][n+1];
	    	matrix[m-1][n-1]=1;
	    	for(int i =m-1;i>=0;i--) {
	    		for(int j=n-1;j>=0;j--) {
	    			if(m-1==i && n-1==j) continue;
	    			int r=matrix[i][j+1];
	    			int d=matrix[i+1][j];
	    			matrix[i][j]= r+d;
	    		}
	    	}
	    	return matrix[0][0];
	    	
	    }
	    
	    
//	best approch :	    
//	    This problem can be modelled as a math combinatorics problem.
//
//
//
//	    We start at (0, 0) cell and move to (m-1, n-1) cell.
//	    We need to make m-1 down-moves and n-1 right-moves to reach the destination cell.
//	    Thus, we need to perform a total number of m+n-2 moves.
//	    At each cell along the path, we can choose either the right-move or down-move and we need to find the number of unique combinations of these choices (which eventually leads to unique paths).
//	    This is nothing but calculating the number of different ways to choose m-1 down-moves and n-1 right-moves from a total of m+n-2 moves. Mathematically, this can be represented as -
//
//
//	    We could cancel out the (n-1)! as well in the above evaluation. We will do one of those based on min(m,n) to give best time complexity in the solution below.
//	time complexxity :O(n)
//	space : O(1)
	    public static int uniquePathsBest(int m, int n) {
	    	 long ans = 1;
	         for(int i = m+n-2, j = 1; i >= Math.max(m, n); i--, j++) 
	             ans = (ans * i) / j;
	         return (int) ans;   
	
	    }
	    public static double factorial(long x) {
	    	double prod=1;
	    	for(int i=2;i<=x;i++) {
	    		prod*=i;
	    	}
	    	return x;
	    }
	    
	    
	
	public static void main(String[] args) {
		//Example 1:

		int m1 = 3, n1 = 7;
		int output1=28;
		
		//Example 2:
		
		int m2 = 3, n2 = 2;
		int output2=3;
		
		System.out.println("Brute force Approch :");
		
		int ans1=uniquePathsBetter(m1,n1);
		int ans2=uniquePathsBetter(m2,n2);
		
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
		
		System.out.println("Better Approch :");
		
		ans1=uniquePathsBetter(m1,n1);
		ans2=uniquePathsBetter(m2,n2);
		
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


		System.out.println("Best Approch :");
		
		ans1=uniquePathsBest(m1,n1);
		ans2=uniquePathsBest(m2,n2);

		
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
