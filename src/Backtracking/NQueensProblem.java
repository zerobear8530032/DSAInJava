// we are given a N*N board where we have to place N queens in such a  way where every single queen is safe 
package Backtracking;

public class NQueensProblem {
	
//	N queens :
	public static int Queens(boolean [][]board, int n) {
		return placeQueens(board,0);
	}
	public static int placeQueens(boolean [][] board, int row) {
		if(row ==board.length) {
			displayBoard(board);
			System.out.println();
			return 1;
		}
		int count =0;
		for(int col=0;col<board[row].length;col++) {
			if(isSafe(board,row,col)) {
				board[row][col]=true;
				count+=placeQueens(board, row+1);
				board[row][col]=false;
			}
		}
		return count;
		
	}
	
	public static boolean isSafe(boolean[][] board, int row, int col) {
		if(board[row][col]) {
			return false;
		}
//		check above:
		for(int r =0;r<row;r++) {
			boolean queen =board[r][col]; 
			if(queen) {
				return false;
			}
		}
		
//		check left diagonal:
		int r=row;
		int c = col;
		while(r>=0 && c>=0) {
			boolean queen =board[r][c]; 
			if(queen) {
				return false;
			}	
			r--;
			c--;
		}
//		check right diagonal:
		r=row;
		c = col;
		while(r>=0 && c<board[0].length) {
			boolean queen =board[r][c]; 
			if(queen) {
				return false;
			}	
			r--;
			c++;
		}
		return true;
		
	}
	public static void displayBoard(boolean [][] board) {
		for(int r=0;r<board.length;r++) {
			for(int c=0;c<board.length;c++) {
				if(board[r][c]) {
					System.out.print("Q");
				}else {
					System.out.print("X");					
				}
			}
			System.out.println();
		}
	}
	
//	
	public static void main(String args[]) {
		
		boolean [][] board = new boolean [4][4];
		System.out.println(Queens(board, board.length));
		
	}

}
