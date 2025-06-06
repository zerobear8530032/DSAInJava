package Backtracking;

public class NKnightsProblem {
	
	public static int Knights(boolean [][] board) {
		int k =board.length;
		return helper(board,0,0,k);
	}

	public static int helper(boolean[][] board, int r, int c,int knight) {
		if(knight==0) {
			displayboard(board);
			System.out.println();
			return 1;
		}
		if(knight!=0 && r==board.length) {
			return 0;
		}
		int count =0;
		if(c==board.length) {
			helper(board,r+1,0,knight);
			return 0;
		}
		
		if(isSafe(board,r,c)) {
			board[r][c]=true;
			count += helper(board,r,c,knight-1);	
			board[r][c]=false;
		}		
		helper(board,r,c+1,knight);
		return count ;
		
	}
	
	public static boolean isSafe(boolean [][] board, int row , int col) {
		if(board[row][col]) {
			return false;
		}
		
		
		//		check up:
		int r = row-2;
		int c= col;
		if(r>=0) {
			if(c-1>=0) {
				if(board[r][c-1]) {
					return false;
				}
			}
			if(c+1<board.length) {
				if(board[r][c+1]) {
					return false;
				}
			}
		}
		//		check down:
		r = row+2;
		c= col;
		if(r<board.length) {
			if(c-1>=0) {
				if(board[r][c-1]) {
					return false;
				}
			}
			if(c+1<board.length) {
				if(board[r][c+1]) {
					return false;
				}
			}
		}
		
		//		check left '
		r = row;
		c= col-2;
		if(c>=0) {
			if(r-1>=0) {
				if(board[r-1][c]) {
					return false;
				}
			}
			if(r+1<board.length) {
				if(board[r+1][c]) {
					return false;
				}
			}
		}
		//		check right
		r = row;
		c= col+2;
		if(c<board.length) {
			if(r-1>=0) {
				if(board[r-1][c]) {
					return false;
				}
			}
			if(r+1<board.length) {
				if(board[r+1][c]) {
					return false;
				}
			}
		}
		
		
		
		
		return true;
	}

	private static void displayboard(boolean [][] board) {
		for(int i =0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(board[i][j]) {
					System.out.print('K');
				}else {
					System.out.print('X');					
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
//		int n1 = 4;
//		boolean [][] board1 = new boolean [n1][n1];
//		System.out.println(Knights(board1));
		int n2 = 2;
		boolean [][] board2 = new boolean [n2][n2];
		System.out.println(Knights(board2));
		

	}

}
