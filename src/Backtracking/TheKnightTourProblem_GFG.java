//The Knight's tour problem
//Last Updated : 06 May, 2025
//Given an n × n chessboard with a Knight starting at the top-left corner (position (0, 0)). The task is to determine a valid Knight's Tour where where the Knight visits each cell exactly once following the standard L-shaped moves of a Knight in chess.
//If a valid tour exists, print an n × n grid where each cell contains the step number (starting from 0) at which the Knight visits that cell. If no tour is possible, print -1.
//
//Examples:
//
//Input: n = 5
//Output:  
//0 5 14 9 20 
//13 8 19 4 15 
//18 1 6 21 10 
//7 12 23 16 3 
//24 17 2 11 22 
//Explanation: The output represents one valid Knight's Tour on a 5x5 board. The number in each cell indicates the order in which it is visited starting from (0, 0) as step 0. 
//
//Input: n = 3
//Output: -1
//Explanation: It is not possible to find a valid Knight's Tour on a 3x3 chessboard since the Knight cannot visit all 9 cells exactly once without revisiting or getting stuck.

package Backtracking;

import java.util.Arrays;

public class TheKnightTourProblem_GFG {
	
	public static void knightTour(int n) {
		int step=0;
		int [][] board = new int [n][n];
		for(int [] row:board) {
			Arrays.fill(row, -1);
		}
		if(!tour(board, 0, 0, 0)) {
			System.out.println("No Valid Path Which Can Reach Every Square");
		}	
		
	}
	
	public static boolean tour(int [][] board, int row , int col, int step) {
		if(row<0 || col<0 || row>=board.length || col>=board.length) {
			return false;
		}
		if(board[row][col]>=0) {
			return false;
		}
		if(step==(board.length*board.length)-1) {
			board[row][col]=step;
			printMatrix(board);
			return true;
		}
		int prev = board[row][col];
		board[row][col]=step;
//		up right
		boolean upright =tour(board, row-2, col+1, step+1);
		if(upright) {
			return true;
		}
//		up left
		boolean upleft  =tour(board, row-2, col-1, step+1);		
		if(upleft) {
			return true;
		}
		
//		down right
		boolean downright =tour(board, row+2, col+1, step+1);
		if(downright) {
			return true;
		}
		
//		down left
		boolean downleft  =tour(board, row+2, col-1, step+1);
		if(downleft) {
			return true;
		}
		
		
//		left up
		boolean leftup  =tour(board, row-1, col-2, step+1);
		if(leftup) {
			return true;
		}
		
//		left down
		boolean leftdown  =tour(board, row+1, col-2, step+1);
		if(leftdown) {
			return true;
		}
		
		
//		right up
		boolean rightup  =tour(board, row-1, col+2, step+1);
		if(rightup) {
			return true;
		}
		
//		right down
		boolean rightdown  =tour(board, row+1, col+2, step+1);
		if(rightdown) {
			return true;
		}
		
		
		board[row][col]=prev;	
		return upleft||upright||downleft||downright||leftup||leftdown||rightup||rightdown;
	}
	
	public static void printMatrix(int [][] board) {
		int n = board.length;
		for(int i =0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int n =5;		
		
		knightTour(n);
		
	}

}
