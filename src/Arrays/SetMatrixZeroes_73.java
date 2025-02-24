//73. Set Matrix Zeroes
//Solved
//Medium
//Topics
//Companies
//Hint
//Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
//
//You must do it in place.
//
// 
//
//Example 1:
//
//
//Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//Output: [[1,0,1],[0,0,0],[1,0,1]]
//Example 2:
//
//
//Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
// 
//
//Constraints:
//
//m == matrix.length
//n == matrix[0].length
//1 <= m, n <= 200
//-231 <= matrix[i][j] <= 231 - 1
// 
//
//Follow up:
//
//A straightforward solution using O(mn) space is probably a bad idea.
//A simple improvement uses O(m + n) space, but still not the best solution.
//Could you devise a constant space solution?

package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SetMatrixZeroes_73 {
	
//	brute force approch :
//	create alist of rows , cols we need to set 0 and simiulate it 
	
    public static void setZeroesBruteForce(int[][] matrix) {
    	HashSet<Integer> rows = new HashSet();
    	HashSet<Integer> cols = new HashSet();
    	
    	for(int i =0;i<matrix.length;i++) {
    		for(int j =0;j<matrix[i].length;j++) {
    				if(matrix[i][j]==0) {
    					rows.add(i);
    					cols.add(j);
    				}
    			}
    		}
    	for(int r:rows) {
    		setRowsToZeroBruteForce(r, matrix);
    	}
    	for(int c:cols) {
    		setColsToZeroBruteForce(c, matrix);
    	}
    	
    
    }
    public static void setColsToZeroBruteForce(int cols,int [][] matrix) {
    	for(int i =0;i<matrix.length;i++) {
    		matrix[i][cols]=0;
    	}
    }
    public static void setRowsToZeroBruteForce(int rows,int [][] matrix) {
    	for(int i =0;i<matrix[0].length;i++) {
    		matrix[rows][i]=0;
    	}
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
	  
	  public static String printMatrix(int [][]img) {
	    	
	    	StringBuilder str = new StringBuilder("{");
	    	System.out.print("[");
	    	for(int i =0;i<img.length;i++) {
	    		str.append(Arrays.toString(img[i]));
	    	}
	    	str.append("]");
	    	return str.toString();
	    }
	
    public static void main(String[] args) {
    	
//    		Example 1:

    		int [][]matrix1 = {{1,1,1},{1,0,1},{1,1,1}};
    		int [][]output1= {{1,0,1},{0,0,0},{1,0,1}};
    		
//    		Example 2:

    		int [][]matrix2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
    		int [][] output2= {{0,0,0,0},{0,4,5,0},{0,3,1,0}};
    		
    		setZeroesBruteForce(matrix1);
			setZeroesBruteForce(matrix2);
			
			
			if(check(output1, matrix1)) {
				System.out.println("Case 1 Passed");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Expected Ouput :"+ printMatrix(output1));
				System.out.println("Your Answer :"+ printMatrix(matrix1));
			}
			if(check(output2, matrix2)) {
				System.out.println("Case 2 Passed");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Expected Ouput :"+ printMatrix(output2));
				System.out.println("Your Answer :"+printMatrix(matrix2) );
			}
			
    		
    		
	}
}