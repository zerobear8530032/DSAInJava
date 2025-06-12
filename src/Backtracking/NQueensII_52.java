//52. N-Queens II
//Hard
//Topics
//premium lock icon
//Companies
//The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
//
//Given an integer n, return the number of distinct solutions to the n-queens puzzle.
//Example 1:
//
//
//Input: n = 4
//Output: 2
//Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
//Example 2:
//
//Input: n = 1
//Output: 1
// 
//
//Constraints:
//
//1 <= n <= 9

package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensII_52 {
	

//	approch :
//	  we can use recursive back tracking by selecting a cell and checking is it safe or not
//	if safe we can put it there other wise we cna just skip that cell
//	time complexity : (N!*N)
//	space complexity : (N*N)
	    public static int totalNQueens(int n) {
	        char [][] board = new char [n][n];
	        for(char [] row : board) {
	        	Arrays.fill(row, '.');
	        }
	        return placeQueens(board, 0);
	       
	    }
	    public static int  placeQueens(char [][] board, int row){
	        if(row==board.length){
	            return 1;
	        }
	        int res =0;
	        for(int i =0;i<board[row].length;i++){
	            if(isSafe(board,row,i)){
	                char prev= board[row][i];
	                board[row][i]='Q';
	                res+=placeQueens(board,row+1);
	                // back track:
	                board[row][i]=prev;
	            }
	        }
	        return res;
	    }
	    public static boolean isSafe(char [][] board, int row , int col){
	        // check up side:
	        for(int i = row;i>=0;i--){
	            if(board[i][col]=='Q'){
	                return false;
	            }
	        }
	        // check diagonal left:
	        int r=row;
	        int c=col;
	        while(r>=0 && c>=0){
	            if(board[r][c]=='Q'){
	                return false;
	            }
	            r--;
	            c--;
	        }
	        // check diagonal right:
	        r=row;
	        c=col;
	        while(r>=0 && c<board.length){
	            if(board[r][c]=='Q'){
	                return false;
	            }
	            r--;
	            c++;
	        }


	        return true;
	    }
	

	public static void main(String[] args) {

		
		//Example 1:

		int n1 = 4;
		int output1=2;
		
		//Example 2:
		int n2 = 1;
		int output2=1;
		
		int ans1 = totalNQueens(n1);
		int ans2 = totalNQueens(n2);
		
		

		if(output1==ans1) {
  		System.out.println("Case 1 Passed");
  	}else {
  		System.out.println("Case 1 Failed");
  		System.out.println("Expected Ouput :"+ output1);
  		System.out.println("Your Answer :"+ ans1);  		
  	}
  	
  	if(output2==ans2) {
  		System.out.println("Case 2 Passed");
  	}else {
  		System.out.println("Case 2 Failed");
  		System.out.println("Expected Ouput :"+ output2);
  		System.out.println("Your Answer :"+ ans2);  		
  	}
	}


}
