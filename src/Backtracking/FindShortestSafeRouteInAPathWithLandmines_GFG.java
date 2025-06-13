//Find shortest safe route in a path with landmines
//Given a path in the form of a rectangular matrix having few landmines arbitrarily placed (marked as 0), calculate length of the shortest safe route possible from any cell in the first column to any cell in the last column of the matrix. We have to avoid landmines and their four adjacent cells (left, right, above and below) as they are also unsafe. We are allowed to move to only adjacent cells which are not landmines. i.e. the route cannot contains any diagonal moves.
//
//Examples:  
//
//Input: 
//A 12 x 10 matrix with landmines marked as 0
//[ 1  1  1  1  1  1  1  1  1  1 ]
//[ 1  0  1  1  1  1  1  1  1  1 ]
//[ 1  1  1  0  1  1  1  1  1  1 ]
//[ 1  1  1  1  0  1  1  1  1  1 ]
//[ 1  1  1  1  1  1  1  1  1  1 ]
//[ 1  1  1  1  1  0  1  1  1  1 ]
//[ 1  0  1  1  1  1  1  1  0  1 ]
//[ 1  1  1  1  1  1  1  1  1  1 ]
//[ 1  1  1  1  1  1  1  1  1  1 ]
//[ 0  1  1  1  1  0  1  1  1  1 ]
//[ 1  1  1  1  1  1  1  1  1  1 ]
//[ 1  1  1  0  1  1  1  1  1  1 ]
//Output:  
//Length of shortest safe route is 13 (Highlighted in Bold)

package Backtracking;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindShortestSafeRouteInAPathWithLandmines_GFG {
	public static int  shortestPath(int [][] board) {		
//		preprocess board:
		
		int entry =1;
		HashMap<Integer,int []> map= new HashMap();
		int [][] preprocessed= new int [board.length][board[0].length];
		for(int i =0;i<board.length;i++) {
			for(int j =0;j<board[i].length;j++) {
				if(board[i][j]==0) {
					map.put(entry, new int[] {i,j});
					entry++;
				}
				preprocessed[i][j]=board[i][j];
			}
		}
		
		for(Map.Entry<Integer, int [] >e: map.entrySet()) {
			int [] pair = e.getValue();
			int r = pair[0];
			int c = pair[1];
			setDangerous(r, c, preprocessed);
		}
		
		
		int res= Integer.MAX_VALUE;
		
		
		for(int i =0;i<preprocessed.length;i++) {
			int possibleres= helper(preprocessed, i,0,0);
			res=Math.min(possibleres, res);
		}
		return res;
	}
	
	
	public static void setDangerous(int row, int col , int [][] board) {
		if(row-1>=0) {
			board[row-1][col]=0;
		}
		if(row+1<board.length) {
			board[row+1][col]=0;
		}
		if(col+1<board[row].length) {
			board[row][col+1]=0;
		}
		if(col-1>=0) {
			board[row][col-1]=0;
		}
		
	}
	
	public static int helper(int [][] board, int row, int col, int step) {
		if(row< 0 || col<0  || row==board.length ||  col== board[0].length) {
			return Integer.MAX_VALUE;
		}
		if(board[row][col]==-1 || board[row][col]==0) {
			return Integer.MAX_VALUE;
		}
		
		if (col == board[0].length - 1) {
			return step;
		}

		
		int res= Integer.MAX_VALUE;
		int prev= board[row][col];
		board[row][col]=-1;
//		check up:
		res = Math.min(res,helper(board, row-1, col,step+1));
		
//		check down:
		res = Math.min(res,helper(board, row+1, col,step+1));
		
//		check left:
		res = Math.min(res,helper(board, row, col-1,step+1));
		
//		check up:
		res = Math.min(res,helper(board, row, col+1,step+1));
		board[row][col]=prev;
		
		return res;
	}
	
	

	public static void main(String[] args) {

		//Examples 1 :  
		
		int[][] grid = {
				
		{ 1,  1,  1,  1,  1,  1,  1,  1,  1,  1 },
		{ 1,  0,  1,  1,  1,  1,  1,  1,  1,  1 },
		{ 1,  1,  1,  0,  1,  1,  1,  1,  1,  1 },
		{ 1,  1,  1,  1,  0,  1,  1,  1,  1,  1 },
		{ 1,  1,  1,  1,  1,  1,  1,  1,  1,  1 },
		{ 1,  1,  1,  1,  1,  0,  1,  1,  1,  1 },
		{ 1,  0,  1,  1,  1,  1,  1,  1,  0,  1 },
		{ 1,  1,  1,  1,  1,  1,  1,  1,  1,  1 },
		{ 1,  1,  1,  1,  1,  1,  1,  1,  1,  1 },
		{ 0,  1,  1,  1,  1,  0,  1,  1,  1,  1 },
		{ 1,  1,  1,  1,  1,  1,  1,  1,  1,  1 },
		{ 1,  1,  1,  0,  1,  1,  1,  1,  1,  1 }
		};
		
		
		int ans1 =shortestPath(grid);
		int output1=13;
		
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}

		

	}

}
