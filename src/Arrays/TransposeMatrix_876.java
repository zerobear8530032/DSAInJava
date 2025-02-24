//	867. Transpose Matrix
//	Solved
//	Easy
//	Topics
//	Companies
//	Hint
//	Given a 2D integer array matrix, return the transpose of matrix.
//	
//	The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
//	
//	
//	
//	 
//	
//	Example 1:
//	
//	Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//	Output: [[1,4,7],[2,5,8],[3,6,9]]
//	Example 2:
//	
//	Input: matrix = [[1,2,3],[4,5,6]]
//	Output: [[1,4],[2,5],[3,6]]
//	 
//	
//	Constraints:
//	
//	m == matrix.length
//	n == matrix[i].length
//	1 <= m, n <= 1000
//	1 <= m * n <= 105
//	-109 <= matrix[i][j] <= 109

package Arrays;

import java.util.Arrays;

public class TransposeMatrix_876 {
//	brute Force Approch :
//	here we use a buffer array as a linear storage of col wise matrix
//	then we can add them at the ans 
//	time complexity :O(m*n)->2*O(m*n) 
//	space complexity :O(m*n) ->2*O(m*n) 
	  public static int[][] transposeBruteForce(int[][] matrix) {
		  int [][] ans = new int [matrix[0].length][matrix.length];
		  int buffer[] = new int [matrix.length*matrix[0].length];
		  int index=0;
		  for(int  cols =0;cols<matrix[0].length;cols++) {
			  for(int rows=0;rows<matrix.length;rows++) {
				  buffer[index]=matrix[rows][cols];
				  index++;
			  }
		  }
		  
		  index =0;
		  for(int rows=0;rows<ans.length;rows++) {
			  for(int cols=0;cols<ans[rows].length;cols++) {
				  ans[rows][cols]=buffer[index];
				  index++;
			  }
		  }
		  
		  return ans;
          
	    }

	  
	  
//	Optimize Force Approch :
//	here we use a just swap row to col and col to row 
//	time complexity :O(m*n) 
//	space complexity :O(m*n) -> this is output  
	  
	  public static int[][] transposeOptimze(int[][] matrix) {
		  int [][] ans = new int [matrix[0].length][matrix.length];
		  for(int cols=0;cols<matrix[0].length;cols++) {
			  for(int rows=0;rows<matrix.length;rows++) {
				 ans[cols][rows]= matrix[rows][cols];
			  }
		  }
		  return ans;
		  
	  }
	  
	  
	  public static boolean check (int ans[][], int output[][]) {
		  if(ans.length!=output.length || ans[0].length!=output[0].length) {
			  return false;
		  }
		  for(int i =0;i<ans.length;i++) {
			  if(ans[i].length!=output[i].length) {
				  return false;
			  }
			  
			  for(int j =0;j<ans[i].length;j++) {
				  
				  if(ans[i][j]!=output[i][j]) {
					  return false;
				  }
			  }
			  
		  }
		  
		  return true;
	  }
	
	  public static String printImage(int [][]img) {
	    	
	    	StringBuilder str = new StringBuilder("{");
	    	System.out.print("[");
	    	for(int i =0;i<img.length;i++) {
	    		str.append(Arrays.toString(img[i]));
	    	}
	    	str.append("]");
	    	return str.toString();
	    }
	public static void main(String[] args) {
		//	Example 1:
		//	
			int[][] matrix1= {{1,2,3},{4,5,6},{7,8,9}};
			int[][] output1= {{1,4,7},{2,5,8},{3,6,9}};
		
		//	Example 2:
			
			int[][] matrix2= {{1,2,3},{4,5,6}};
			int[][] output2= {{1,4},{2,5},{3,6}};
			
			
			int ans1[][]=transposeBruteForce(matrix1);
			int ans2[][]=transposeBruteForce(matrix2);
			
			
			if(check(output1, ans1)) {
				System.out.println("Case 1 Passed");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Expected Ouput :"+ printImage(output1));
				System.out.println("Your Answer :"+ printImage(ans1));
			}
			if(check(output2, ans2)) {
				System.out.println("Case 2 Passed");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Expected Ouput :"+ printImage(output2));
				System.out.println("Your Answer :"+printImage(ans2) );
			}
			
			System.out.println("Optimize Approch :");
			
			ans1=transposeOptimze(matrix1);
			ans2=transposeOptimze(matrix2);
			
			
			if(check(output1, ans1)) {
				System.out.println("Case 1 Passed");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Expected Ouput :"+ printImage(output1));
				System.out.println("Your Answer :"+ printImage(ans1));
			}
			if(check(output2, ans2)) {
				System.out.println("Case 2 Passed");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Expected Ouput :"+ printImage(output2));
				System.out.println("Your Answer :"+printImage(ans2) );
			}

	}
}

