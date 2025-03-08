//Difficulty:
//Category:
//Hidden
//Successful Submissions:
//41,081+
//River Sizes
//You're given a two-dimensional array (a matrix) of potentially unequal height and width containing only 0s and 1s. Each 0 represents land, and each 1 represents part of a river. A river consists of any number of 1s that are either horizontally or vertically adjacent (but not diagonally adjacent). The number of adjacent 1s forming a river determine its size.
//
//Note that a river can twist. In other words, it doesn't have to be a straight vertical line or a straight horizontal line; it can be L-shaped, for example.
//
//Write a function that returns an array of the sizes of all rivers represented in the input matrix. The sizes don't need to be in any particular order.
//
//Sample Input
//matrix = [
//  [1, 0, 0, 1, 0],
//  [1, 0, 1, 0, 0],
//  [0, 0, 1, 0, 1],
//  [1, 0, 1, 0, 1],
//  [1, 0, 1, 1, 0],
//]
//Sample Output
//[1, 2, 2, 2, 5] // The numbers could be ordered differently.
//
// The rivers can be clearly seen here:
// [
//   [1,  ,  , 1,  ],
//   [1,  , 1,  ,  ],
//   [ ,  , 1,  , 1],
//   [1,  , 1,  , 1],
//   [1,  , 1, 1,  ],
// ]


package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class River_Sizes_ALGOEXPERT {
//	approch : use iterate over matrix and check for island cells if found we try to find all island cells of that island 
//	and add it in the ans list
//	we can use DFS/BFS to find all island cell
//	finally once all island cell are counted return the output as a list 
//	time complexity :O(M*N)
//	space complexity :O(M*N)+ recursion depth 
	
	public static List<Integer> riverSizes(int[][] matrix) {
		 boolean [][] visitedmatrix= new boolean[matrix.length][matrix[0].length];// visited matrix will store all elements 
		 List<Integer>ans = new ArrayList();// answer list
		 for(int i =0;i<matrix.length;i++) {// check matrix each element
			 for(int j=0;j<matrix[i].length;j++) {
				 if(matrix[i][j]==1 && !visitedmatrix[i][j]) {	// check we are at island cell and we have never visited it				 
					int c=	helper(matrix, i, j, visitedmatrix, 0);// use helper
					ans.add(c);// count in the answer 
				 }
			 }
		 }
		 return ans; 
	 }
	 
//	 helper will use DFS 
	 public static int helper(int [][] matrix, int row,int col,boolean [][] visited,int count ){
		 if(row<0 || col<0 || row>=matrix.length || col>=matrix[0].length || visited[row][col] || matrix[row][col]==0) {
			 return 0;
		 }
		 
		 if(matrix[row][col]==1) {
			 count++;
		 }
		 
		 visited[row][col]=true;
		 
//		 explore up:
		 count=Math.max(count,helper(matrix,  row-1, col,visited,count) );
//		 explore down:
		 count=Math.max(count,helper(matrix,  row+1, col,visited,count) );
//		 explore left:
		 count=Math.max(count,helper(matrix,  row, col+1,visited,count) );
//		 explore right:
		 count=Math.max(count,helper(matrix,  row, col-1,visited,count) );

		 
		 return count;
		 
	 }
	 public static boolean check (List<Integer> ans,List<Integer> output) {
		 Collections.sort(ans);
		 Collections.sort(output);
		 return ans.equals(output);
	 }
	
	public static void main(String[] args) {
		//Sample Input
		int [][]matrix = {
		  {1, 0, 0, 1, 0},
		  {1, 0, 1, 0, 0},
		  {0, 0, 1, 0, 1},
		  {1, 0, 1, 0, 1},
		  {1, 0, 1, 1, 0},
		};
		
		List <Integer> output1=new ArrayList(Arrays.asList(1, 2, 2, 2, 5));
	List<Integer> ans1= riverSizes(matrix);
	
	
	if(check(ans1, output1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");
		System.out.println("Expected Ouput :"+ output1);
		System.out.println("Your Answer :"+ (ans1));
		}
	
	}
}
