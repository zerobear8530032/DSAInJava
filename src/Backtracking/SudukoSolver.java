

package Backtracking;

public class SudukoSolver {
//	public static boolean sudokusolver(int [][] board) {
//		int n = board.length;
//		int row =-1;
//		int col=-1;
//		
//		boolean emptyLeft = true;
////		replacing r , c from arguments
//		for(int i =0;i<n;i++) {
//			for(int j =0;j<n;j++) {
//				if(board[i][j]==0) {
//					row= i;
//					col= j;
//					emptyLeft=false;
//					break;
//				}
//			}
//			//if you fond empty element in row :
//			if(emptyLeft==false) {
//				break;
//			}
//		}
//		if(emptyLeft) {
//			return true;
//		}
//		
//		for(int num =1;num<=9;num++) {
//			if(isSafe(board,row,col,num)) {
//				board[row][col]=num;
//				if(sudokusolver(board)) {
//					display(board);
//					return true;
//				}else {
//					board[row][col]=0;					
//				}
//			}
//		}
//		return false;
//	}
	public static boolean sudokusolver(int [][] board) {
		int n = board.length;
		int  row =-1;
		int col =-1;
		boolean emptyLeft= true;
		for(int i =0;i<n;i++) {
			for(int j =0;j<n;j++) {
				if(board[i][j]==0) {
					row =i;
					col =j;
					emptyLeft=false;
					break;
				}
			}
//			if you found some empty elemennt in row
			if(emptyLeft==false) {
				break;
			}
		}
//		base conditiopn if entire grid is filled we return true
		if(emptyLeft==true) {
			return true;
		}
		
//		back track
		for(int  num  =1;num<=9;num++) {
			if(isSafe(board,num,row,col)) {
				board[row][col]=num;
				if(sudokusolver(board)) {
					return true;
				}else {
					board[row][col]=0;					
				}
			}
		}
		return false;
	}

	
	public static void display( int [][] board) {
		for(int i =0;i<board.length;i++) {
			for(int j =0;j<board.length;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
	public static boolean isSafe(int [][] board, int n, int row , int col) {
//		 check row :
		for(int i = 0 ;i<9;i++) {
			if(board[row][i]==n) {
				return false;
			}
		}
//		 check col :
		for(int i = 0 ;i<9;i++) {
			if(board[i][col]==n) {
				return false;
			}
		}
//		 check grid:
		int sqrt = (int) Math.sqrt(board.length);
		int r = row-(row%sqrt);
		int c = col-(col%sqrt);
		for(int i =r;i<r+sqrt;i++) {
			for(int j = c;j<c+sqrt;j++) {
				if(board[i][j]==n) {
					return false;
				}
			}
		}
		
		return true;
	}



	public static void main(String[] args) {
		
		int [][] board1= {
				{ 5 , 3 , 0 , 0 , 7 , 0 , 0 , 0 , 0 },
				{ 6 , 0 , 0 , 1 , 9 , 5 , 0 , 0 , 0 },
				{ 0 , 9 , 8 , 0 , 0 , 0 , 0 , 6 , 0 },
				{ 8 , 0 , 0 , 0 , 6 , 0 , 0 , 0 , 3 },
				{ 4 , 0 , 0 , 8 , 0 , 3 , 0 , 0 , 1 },
				{ 7 , 0 , 0 , 0 , 2 , 0 , 0 , 0 , 6 },
				{ 0 , 6 , 0 , 0 , 0 , 0 , 2 , 8 , 0 },
				{ 0 , 0 , 0 , 4 , 1 , 9 , 0 , 0 , 5 },
				{ 0 , 0 , 0 , 0 , 8 , 0 , 0 , 7 , 9}};
		if(sudokusolver(board1)) {
			display(board1);
		}
        if(sudokusolver(board1)) {
			display(board1);
		}
	}
}
