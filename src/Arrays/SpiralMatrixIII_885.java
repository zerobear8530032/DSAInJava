//	885. Spiral Matrix III
//	Solved
//	Medium
//	Topics
//	Companies
//	You start at the cell (rStart, cStart) of an rows x cols grid facing east. The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.
//	
//	You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later.). Eventually, we reach all rows * cols spaces of the grid.
//	
//	Return an array of coordinates representing the positions of the grid in the order you visited them.
//	
//	 
//	
//	Example 1:
//	
//	
//	Input: rows = 1, cols = 4, rStart = 0, cStart = 0
//	Output: {{0,0},{0,1},{0,2},{0,3}}
//	Example 2:
//	
//	
//	Input: rows = 5, cols = 6, rStart = 1, cStart = 4
//	Output: {{1,4},{1,5},{2,5},{2,4},{2,3},{1,3},{0,3},{0,4},{0,5},{3,5},{3,4},{3,3},{3,2},{2,2},{1,2},{0,2},{4,5},{4,4},{4,3},{4,2},{4,1},{3,1},{2,1},{1,1},{0,1},{4,0},{3,0},{2,0},{1,0},{0,0}}
//	 
//	
//	Constraints:
//	
//	1 <= rows, cols <= 100
//	0 <= rStart < rows
//	0 <= cStart < cols
//


package Arrays;

import java.util.Arrays;

public class SpiralMatrixIII_885 {
	
	 public static int[][]spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
		 int top=rStart;
		 int bottom=rStart;
		 int left=cStart; 
		 int right=cStart;
		 int ans [][]= new int [rows*cols][];
		 int elements =0;
		 int step=1;
		 int row=top;
		 int col=left;
		 while(elements<ans.length) {
			 int rs= 0;
			 while(rs<step) {// go to right
				 if(row<rows && col<cols && row>=0  && col>=0) {
					 ans[elements]= new int [] {row,col};					 
					 elements++;
				 }
				 col++;
				 rs++;
				 }
			 int ds=0;
			 while(ds<step) {// go to right
				 if(row<rows && col<cols && row>=0  && col>=0) {
					 ans[elements]= new int [] {row,col};					 
					 elements++;
				 }
				 row++;
				 ds++;
			 }
			 step++;
			 int ls= 0;
			 while(ls<step) {// go to right
				 if(row<rows && col<cols && row>=0  && col>=0 ) {
					 ans[elements]= new int [] {row,col};					 
					 elements++;
				 }
				 col--;
				 ls++;
				 }			 
			 int us= 0;
			 while(us<step) {// go to right
				 if(row<rows && col<cols && row>=0  && col>=0) {
					 ans[elements]= new int [] {row,col};					 
					 elements++;
				 }
				 row--;
				 us++;
			 }
			 step++;
			 
			 
		 }
		 return ans;
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
//		Example 1:

		int rows1 = 1, cols1 = 4;
		int rStart1 = 0, cStart1 = 0;
		int [][] output1= {{0,0},{0,1},{0,2},{0,3}};

//		Example 2:

		int rows2 = 5, cols2 = 6;
		int rStart2 = 1, cStart2 = 4;
		int [][] output2= {{1,4},{1,5},{2,5},{2,4},{2,3},{1,3},{0,3},{0,4},{0,5},{3,5},{3,4},{3,3},{3,2},{2,2},{1,2},{0,2},{4,5},{4,4},{4,3},{4,2},{4,1},{3,1},{2,1},{1,1},{0,1},{4,0},{3,0},{2,0},{1,0},{0,0}};

		System.out.println(printMatrix(spiralMatrixIII(rows1, cols1, rStart1, cStart1)));
		System.out.println(printMatrix(spiralMatrixIII(rows2, cols2, rStart2, cStart2)));
		
	}
}
