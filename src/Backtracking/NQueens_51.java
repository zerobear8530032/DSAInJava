//51. N-Queens
//Hard
//Topics
//premium lock icon
//Companies
//The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
//
//Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
//
//Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
//
// 
//
//Example 1:
//
//
//Input: n = 4
//Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
//Example 2:
//
//Input: n = 1
//Output: [["Q"]]
// 
//
//Constraints:
//
//1 <= n <= 9


package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens_51 {
	
//	approch :
//	  we can use recursive back tracking by selecting a cell and checking is it safe or not
//	if safe we can put it there other wise we cna just skip that cell
//	time complexity : (N!*N)
//	space complexity : (N*N)
	    public static List<List<String>> solveNQueens(int n) {
	        char [][] board = new char [n][n];
	        for(char [] row : board) {
	        	Arrays.fill(row, '.');
	        }
	        List<List<String>> res= new ArrayList();
	        placeQueens(board,res, 0);
	        return res;
	    }
	    public static void placeQueens(char [][] board,List<List<String>> res , int row){
	        if(row==board.length){
	            List<String> b= new ArrayList();
	            for(char [] r:board){
	                b.add(new String(r));
	            }
	            res.add(b);
	            return ;
	        }
	        for(int i =0;i<board[row].length;i++){
	            if(isSafe(board,row,i)){
	                char prev= board[row][i];
	                board[row][i]='Q';
	                placeQueens(board,res,row+1);
	                // back track:
	                board[row][i]=prev;
	            }
	        }
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
		List<List<String>> output1= new ArrayList(Arrays.asList(
				Arrays.asList(".Q..","...Q","Q...","..Q."),
				Arrays.asList ("..Q.","Q...","...Q",".Q..")
				));

		
		//Example 2:
		int n2 = 1;
		List<List<String>> output2= new ArrayList(Arrays.asList(
				Arrays.asList("Q")));
		
		
		List<List<String>> ans1 = solveNQueens(n1);
		List<List<String>> ans2 = solveNQueens(n2);
		
		

		if(output1.equals(ans1)) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Ouput :"+ output1);
    		System.out.println("Your Answer :"+ ans1);  		
    	}
    	
    	if(output2.equals(ans2)) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Ouput :"+ output2);
    		System.out.println("Your Answer :"+ ans2);  		
    	}
	}

}
