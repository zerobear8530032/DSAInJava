//79. Word Search
//Solved
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
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
//Output: true
//Example 2:
//
//
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
//Output: true
//Example 3:
//
//
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
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

package Backtracking;

public class WordSearch_79 {
		
	
//	better approch :
//  our approch is better by using a frequency of each ellement in our grid we 
//	can make a assumption word exists or not
//	like if the frequency of character in word is greater then in board we can exist eary
//	this can be done by traversing each word , array one time 
//	time complexity remains same but this allow us to search in recursive call when we 
//	are sure word will exits so the time complexity will not change
//	time complexity : O(M∗N∗4^L)
//	space complexity : O(L)
	
	public static boolean existBruteForce(char[][] board, String word) {
		for(int r =0;r<board.length;r++) {
			for(int c=0;c<board[r].length;c++) {
				if(board[r][c]==word.charAt(0)) {
					if(helper(board,word,0,r,c)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public static  boolean helper(char [][] board,String word, int index , int r, int c) {
		if(index==word.length()) {
			return true;
		}
		
		if(r==board.length || c==board[0].length || r<0 || c <0) {
			return false;
		}
		if(board[r][c]=='0' || board[r][c]!= word.charAt(index)) {
			return false;
		}
		
		char ch =word.charAt(index);
		char  originalchar= board[r][c];
		board[r][c]='0';
//	    	look at left :
		boolean left= helper(board,word,index+1,r,c-1);
//	    	look at right :
		boolean right= helper(board,word,index+1,r,c+1);	    	
//	    	look at up :
		boolean up= helper(board,word,index+1,r-1,c);
//	    	look at down :
		boolean down= helper(board,word,index+1,r+1,c);
		board[r][c]=originalchar;
		
		return left || right|| up || down;
		
		
		
		
	}
	
//	Brute Force approch :
//	we use simple back tracking where we  iterate over entire board first and find
//	first occurence of the word once found we will start our 
//	recursivve function which will check each character in all 4 direction using back tracking
//	we check the string index reach to the word length once it  is we return true
//	other wise we will search in other directions
//	and back track if required
//	time complexity : O(M∗N∗4^L)
//	space complexity : O(L)
	
	    public static boolean existBetter(char[][] board, String word) {
	    	if(!canExists(board, word)) {
	    		return false;
	    	}
	    	for(int r =0;r<board.length;r++) {
	    		for(int c=0;c<board[r].length;c++) {
	    			if(board[r][c]==word.charAt(0)) {
	    				if(helper(board,word,0,r,c)) {
	    					return true;
	    				}
	    			}
	    		}
	    	}
	        return false;
	    }
	    
	    public static boolean canExists(char [][] board, String word) {
	    	int [] map = new int [26];
	    	for(int i =0;i<word.length();i++) {
	    		char ch= word.charAt(i);
	    		
	    		if(ch<='Z' && ch>='A'){
		    		map[ch-'A']++;
	             }
	                if(ch<='z' && ch>='a'){
		    		map[ch-'a']++;
	             }

	    	}
	    	for(int i =0;i<board.length;i++) {
	    		for(int j =0;j<board[i].length;j++) {
	    			char ch= board[i][j];
	    			
	    			if(ch<='Z' && ch>='A'){
	    	    		map[ch-'A']--;
	                    }
	                if(ch<='z' && ch>='a'){
	    	    		map[ch-'a']--;
	                }

	    		}
	    	}
	    	
	    	for(int x:map) {
	    		if(x>0) return false;
	    	}
	    	return true;
	    }


		

	public static void main(String[] args) {
		
		//Example 1:

		char [][]board1 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String  word1 = "ABCCED";
		boolean output1=true;
		
		//Example 2:
	
		char [][]board2 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word2 = "SEE";
		boolean output2=true;

		//Example 3:

		char [][]board3 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word3= "ABCB";
		boolean output3=false;
			
		System.out.println("Brute Approch :");
		
		boolean ans1=existBruteForce(board1,word1);
		boolean ans2=existBruteForce(board2,word2);
		boolean ans3=existBruteForce(board3,word3);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}
		
		System.out.println("Better Approch :");
		
		ans1=existBetter(board1,word1);
		ans2=existBetter(board2,word2);
		ans3=existBetter(board3,word3);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}


	}

}
