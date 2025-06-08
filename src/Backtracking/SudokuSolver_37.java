//37. Sudoku Solver
//Hard
//Topics
//premium lock icon
//Companies
//Write a program to solve a Sudoku puzzle by filling the empty cells.
//
//A sudoku solution must satisfy all of the following rules:
//
//Each of the digits 1-9 must occur exactly once in each row.
//Each of the digits 1-9 must occur exactly once in each column.
//Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
//The '.' character indicates empty cells.
//
// 
//
//Example 1:
//
//
//Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
//Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
//Explanation: The input board is shown above and the only valid solution is shown below:
//
//
// 
//
//Constraints:
//
//board.length == 9
//board[i].length == 9
//board[i][j] is a digit or '.'.
//It is guaranteed that the input board has only one solution.


package Backtracking;

import java.util.Arrays;
// we can use recursive back tracking to resolve the problem :
// time complexity : O(9^(n^2))
// space complexity : O(n)

public class SudokuSolver_37 {
	 public static  void solveSudoku(char[][] board) {
		 helper(board);
		 }
	 
	 public static boolean helper(char [][] board) {
		    int row =-1;
	        int col =-1;
	        int n =board.length;
	        boolean emptyLeft = true;
	        for(int i =0;i<n;i++){
	            for(int j=0;j<n;j++){
	                if(board[i][j]=='.'){
	                    row=i;
	                    col=j;
	                    emptyLeft=false;
	                    break;
	                }
	            }
	            if(emptyLeft==false){
	                break;
	            }
	        }
	        if(emptyLeft==true){
	            return true;
	        }
	        for(int num=1;num<=9;num++){
	            if(isSafe(board,row,col,num)){
	               board[row][col]=(char)(num+'0');
	               if(helper(board)) {
	            	   return true;
	               }else {
	            	   board[row][col]='.';	            	   
	               }
	            }
	            
	        }
	        return false;
	 }

	    public static boolean isSafe(char [][] board, int row, int col , int num){
	        // check row :
	        for(int i =0;i<board.length;i++){
	            if(board[row][i]==(char)('0'+num)){
	                return false;
	            }
	        }
	        // check row :
	        for(char [] rows : board){
	            if(rows[col]==(char)('0'+num)){
	                return false;
	            }
	        }
	        
	        // check grid :
	        int sqrt= (int) Math.sqrt(board.length);
	        int startrow = row - (row%sqrt);
	        int startcol = col - (col%sqrt);
	        for(int r=startrow;r<startrow+sqrt;r++){
	            for(int c= startcol;c<startcol+sqrt;c++){
	                if(board[r][c]==(char)('0'+num)){
	                    return false;
	                }
	            }
	        }

	        return true;
	    }
	public static void main(String[] args) {
		char [][] board1= {
				{ '5' , '3' , '.' , '.' , '7' , '.', '.' , '.' , '.' },
				{ '6' , '.' , '.' , '1' , '9' , '5' , '.' , '.' , '.' },
				{ '.' , '9' , '8' ,'.' , '.' , '.' , '.' , '6' , '.' },
				{ '8' , '.' , '.' ,'.' , '6' , '.' , '.' , '.' , '3' },
				{ '4' , '.' , '.' ,'8' , '.' , '3' , '.' , '.' , '1' },
				{ '7' , '.' , '.' ,'.' , '2' , '.' , '.' , '.' , '6' },
				{ '.' , '6' , '.' ,'.' , '.' , '.' , '2' , '8' , '.' },
				{ '.' , '.' , '.' ,'4' , '1' , '9' , '.' , '.' , '5' },
				{ '.' , '.' , '.' ,'.' , '8' , '.' , '.' , '7' , '9'}};
		
		solveSudoku(board1);
		
		for(char [] arr:board1) {
			System.out.println(Arrays.toString(arr));
		}

	}

}
