//59. Spiral Matrix II
//Solved
//Medium
//Topics
//Companies
//Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
//
// 
//
//Example 1:
//
//
//Input: n = 3
//Output: [[1,2,3],[8,9,4],[7,6,5]]
//Example 2:
//
//Input: n = 1
//Output: [[1]]
// 
//
//Constraints:
//
//1 <= n <= 20

package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrixII_59 {
//	approch :precice pointer movement :
//	to do this problem we need 4 pointers top,bottom,left,right, element counter starting at 1
//	these act as wall of matrix means we does not go beyond that
//	now this becomes simple when we move top row once iterated we will increase top
//	which mean the entire row is iterated next we iterate right col and decrement right pointer
//	then we iterate bottom row and increase bottom pointer 
//	lastly we iterate the left col and increment left pointer
//	while iterating each row and col increment and set the values of cells
//	time complexity : O(n*n)
//	space complexity : O(n*n)
	public static int[][] generateMatrix(int n) {
    	int [][] matrix = new int[n][n];
        	int top = -1;
        	int bottom=matrix.length;
        	int left=-1;
        	int right=matrix[0].length;
        	int elements =1;
        	int totalelement = bottom*right;
        	
        	while(top<bottom) {
        		int row = top+1;
        		int col = left+1;
        		
        		while(col!=right) {// top row
        			matrix[row][col]=elements;
        			col++;
        			elements++;
        		}
        		if(elements>totalelement) {
        			return matrix;
        		}
        		
        		if(col==right) {
        			top++;
        			row=top+1;
        			col--;
        		}
        		while(row!=bottom) {// right col
        			matrix[row][col]=elements;
        			row++;
        			elements++;
        		}
        		if(elements>totalelement) {
        			return matrix;
        		}
        		if(row==bottom) {
        			right--;
        			col=right-1;
        			row--;
           		}
        		while(col!=left) {// bottom row
        			matrix[row][col]=elements;
        			col--;
        			elements++;
        		}
        		if(elements>totalelement) {
        			return matrix;
        		}
        		if(col==left) {
        			bottom--;
        			row=bottom-1;
        			col++;
           		}
        		
        		while(row!=top) {// left col
        			matrix[row][col]=elements;
        			row--;
        			elements++;
        		}
        		if(elements>totalelement) {
        			return matrix;
        		}
        		if(row==top) {
        			left++;
        			row=top+1;
        			col++;
        		}
        		
        		
        	}
        	
        	
        	
        	return matrix;

        
    }
    public static boolean  check(int [][] ans,int [][] output) {
    	if(ans.length!=output.length) {
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
    	
    	StringBuilder str = new StringBuilder("[");
    	for(int i =0;i<img.length;i++) {
    		str.append(Arrays.toString(img[i]));
    	}
    	str.append("]");
    	return str.toString();
    }
    public static void main(String[] args) {
    	//Example 1:

    	int n1 = 3;
    	int [][] output1= {{1,2,3},{8,9,4},{7,6,5}};

    	//Example 2:

    	int n2 = 1;
    	int [][] output2= {{1}};
    	
    	int [][] ans1= generateMatrix(n1);
    	int [][] ans2= generateMatrix(n2);
    	
    	if(check(ans1,output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ printMatrix(output1));
			System.out.println("Your Answer :"+ printMatrix(ans1));
		}
		
    	if(check(ans2,output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+printMatrix(output2));
			System.out.println("Your Answer :"+ printMatrix(ans2));
		}

	}
}