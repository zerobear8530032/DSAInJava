//	1252. Cells with Odd Values in a Matrix
//	Solved
//	Easy
//	Topics
//	Companies
//	Hint
//	There is an m x n matrix that is initialized to all 0's. There is also a 2D array indices where each indices[i] = [ri, ci] represents a 0-indexed location to perform some increment operations on the matrix.
//	
//	For each location indices[i], do both of the following:
//	
//	Increment all the cells on row ri.
//	Increment all the cells on column ci.
//	Given m, n, and indices, return the number of odd-valued cells in the matrix after applying the increment to all locations in indices.
//	
//	 
//	
//	Example 1:
//	
//	
//	Input: m = 2, n = 3, indices = [[0,1],[1,1]]
//	Output: 6
//	Explanation: Initial matrix = [[0,0,0],[0,0,0]].
//	After applying first increment it becomes [[1,2,1],[0,1,0]].
//	The final matrix is [[1,3,1],[1,3,1]], which contains 6 odd numbers.
//	Example 2:
//	
//	
//	Input: m = 2, n = 2, indices = [[1,1],[0,0]]
//	Output: 0
//	Explanation: Final matrix = [[2,2],[2,2]]. There are no odd numbers in the final matrix.
//	 
//	
//	Constraints:
//	
//	1 <= m, n <= 50
//	1 <= indices.length <= 100
//	0 <= ri < m
//	0 <= ci < n
//	 
//	
//	Follow up: Could you solve this in O(n + m + indices.length) time with only O(n + m) extra space?

package Arrays;

public class CellsWithOddValuesInAMatrix_1252 {
//	approch :
//	create a matrix of M*N
//	now iterate over indices and increment at each row i and col i
	
	
	 public static int oddCellsBruteForce(int m, int n, int[][] indices) {
	        int [][] matrix = new int [m][n];
	        for(int i =0;i<indices.length;i++) {
	        	incrementrow(matrix, indices[i][0]);
	        	incrementcol(matrix, indices[i][1]);
	        }
	        
	        
	        int odd=0;
	        for(int i =0;i<matrix.length;i++) {
	        	for(int j=0;j<matrix[i].length;j++) {
	        		if(matrix[i][j]%2!=0) {
	        			odd++;
	        		}
	        	}
	        }
	        return odd;
	        
	    }
//	 row increment 
	 public static void incrementrow(int [][] matrix,int row) {
		 for(int i =0;i<matrix[row].length;i++) {
			 matrix[row][i]++;
		 }
	 }
	 public static void incrementcol(int [][] matrix,int col) {
		 for(int i =0;i<matrix.length;i++) {
			 matrix[i][col]++;
		 }
	 }
	 
//	 optimize approch :
//	 we can just make 2 boolean array which can act as entire row and col
//	 row array size = n
//	 col array size = m
//	 now just flip true to false and false to true 
//	 in the index[0] and index[1] at row and col array
//	 at iterate with row * col
//	 and check where row[i]!=col[j]
//	 if both are not equal increase counter
//	 and return at last 
//	 
		    public static int oddCellsOptimize(int m, int n, int[][] indices) {
		         boolean[] rowFlips = new boolean[m];
		        boolean[] colFlips = new boolean[n];

		        // Track row and column flips
		        for (int[] index : indices) {
		            rowFlips[index[0]] = !rowFlips[index[0]];
		            colFlips[index[1]] = !colFlips[index[0]];
		        }

		        int oddCount = 0;

		        // Compute the number of odd-valued cells
		        for (int i = 0; i < m; i++) {
		            for (int j = 0; j < n; j++) {
		                if (rowFlips[i] != colFlips[j]) {
		                    oddCount++;
		                }
		            }
		        }

		        return oddCount;
		    }
		
	 
	public static void main(String[] args) {
		
	//		Example 1:
			int m1 = 2, n1 = 3; 
			int [][]indices1 = {{0,1},{1,1}};
			int output1=6;
	
	//		Example 2:
			int m2 = 2, n2 = 2; 
			int [][]indices2 = {{1,1},{0,0}};
			int output2=0;
			
			
			int ans1 =oddCellsBruteForce(m1, n1, indices1);
			int ans2 =oddCellsBruteForce(m2, n2, indices2);
			
			System.out.println("Brute Force Approch :");
			
			if(output1==ans1) {
				System.out.println("Case 1 Passed");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Expected Ouput :"+ output1);
				System.out.println("Your Answer :"+ ans1);
			}
			if(output2==ans2) {
				System.out.println("Case 2 Passed");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Expected Ouput :"+ output2);
				System.out.println("Your Answer :"+ ans2);
			}
			
			System.out.println("Optimize Approch :");
			ans1 =oddCellsOptimize(m1, n1, indices1);
			ans2 =oddCellsOptimize(m2, n2, indices2);			
			if(output1==ans1) {
				System.out.println("Case 1 Passed");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Expected Ouput :"+ output1);
				System.out.println("Your Answer :"+ ans1);
			}
			if(output2==ans2) {
				System.out.println("Case 2 Passed");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Expected Ouput :"+ output2);
				System.out.println("Your Answer :"+ ans2);
			}
			
			System.out.println("Optimize Approch :");
			
			
			
	
		
	}
	
}

