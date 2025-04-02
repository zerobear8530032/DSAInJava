//79. Word Search
//Medium
//Topics
//Companies
//Given an m x n grid of characters board and a string word, return true if word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
// 
//
//Example 1:
//
//
//Input: board = [["A","B","C","E"},["S","F","C","S"},["A","D","E","E"}}, word = "ABCCED"
//Output: true
//Example 2:
//
//
//Input: board = [["A","B","C","E"},["S","F","C","S"},["A","D","E","E"}}, word = "SEE"
//Output: true
//Example 3:
//
//
//Input: board = [["A","B","C","E"},["S","F","C","S"},["A","D","E","E"}}, word = "ABCB"
//Output: false
// 
//
//Constraints:
//
//m == board.length
//n = board[i].length
//1 <= m, n <= 6
//1 <= word.length <= 15
//board and word consists of only lowercase and uppercase English letters.
// 
//
//Follow up: Could you use search pruning to make your solution faster with a larger board?

package Recursion;

public class WordSearch_79 {
	
	
	 public static boolean exist(char[][] board, String word) {
		 int r= board.length;
		 int c= board[0].length;
		 boolean  [][]mark = new boolean[r][c]; 
	      for(int i =0;i<r;i++) {
	    	  for(int j=0;j<c;j++) {
	    		  if(board[i][j]==word.charAt(0)) {
	    			  if( dfs(board, mark, i, j, word, 0)) {
	    				  return true;
	    			  }
	    		  }
	    	  }
	      }
	      return false;
	    } 
	 public static boolean dfs(char [][] grid,boolean [][] marks,int r, int c,String word, int index) {
		 if(index==word.length()) {
			 return true;
		 }
		 if((r<0 || c<0 || r>=grid.length || c>=grid[0].length) ) {
			 return false;
		 }
		 if(marks[r][c]==true || grid[r][c]!=word.charAt(index) ) {
			 return false;
		 }
		  
		 
		 marks[r][c]=true;
		 boolean up=dfs(grid, marks, r-1, c, word, index+1) ;
		 boolean down=dfs(grid, marks, r+1, c, word, index+1) ;
		 boolean left=dfs(grid, marks, r, c-1, word, index+1) ;
		 boolean right=dfs(grid, marks, r, c+1, word, index+1) ;
		 boolean ans =  up|| down|| left || right;
		 marks[r][c]=false;
		 return ans;
	 }

	public static void main(String[] args) {
		
		//Example 1:

		char [][] board1 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word1 = "ABCCED";
		boolean output1= true;
		
		//Example 2:
		
		char [][] board2 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word2 = "SEE";
		boolean output2= true;
				
		//Example 3:
		//
		char [][] board3 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word3 = "ABCB";
		boolean output3= false;

		System.out.println(exist(board1, word1));
	}

}
