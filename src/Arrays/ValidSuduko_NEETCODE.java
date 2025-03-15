//Valid Sudoku
//You are given a a 9 x 9 Sudoku board board. A Sudoku board is valid if the following rules are followed:
//
//Each row must contain the digits 1-9 without duplicates.
//Each column must contain the digits 1-9 without duplicates.
//Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without duplicates.
//Return true if the Sudoku board is valid, otherwise return false
//
//Note: A board does not need to be full or be solvable to be valid.
//
//Example 1:
//
//
//
//Input: board = 
//[["1","2",".",".","3",".",".",".","."],
// ["4",".",".","5",".",".",".",".","."],
// [".","9","8",".",".",".",".",".","3"],
// ["5",".",".",".","6",".",".",".","4"],
// [".",".",".","8",".","3",".",".","5"],
// ["7",".",".",".","2",".",".",".","6"],
// [".",".",".",".",".",".","2",".","."],
// [".",".",".","4","1","9",".",".","8"],
// [".",".",".",".","8",".",".","7","9"]]
//
//Output: true
//Example 2:
//
//Input: board = 
//[["1","2",".",".","3",".",".",".","."],
// ["4",".",".","5",".",".",".",".","."],
// [".","9","1",".",".",".",".",".","3"],
// ["5",".",".",".","6",".",".",".","4"],
// [".",".",".","8",".","3",".",".","5"],
// ["7",".",".",".","2",".",".",".","6"],
// [".",".",".",".",".",".","2",".","."],
// [".",".",".","4","1","9",".",".","8"],
// [".",".",".",".","8",".",".","7","9"]]
//
//Output: false
//Explanation: There are two 1's in the top-left 3x3 sub-box.
//
//Constraints:
//
//board.length == 9
//board[i].length == 9
//board[i][j] is a digit 1-9 or '.'.



package Arrays;

import java.util.HashSet;

class ValidSuduko_NEETCODE {
//	approch : iterate over entire board
//	check which cell have a value and check if that repeat in there row and cols 
//	once done check all 3x3 small matrix that there any repeating number
//	time complexity :O(n*m)^2;
	
    public static boolean isValidSudoku(char[][] board) {
        for(int i =0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]!='.'){
                    if(checkrow(board,j) ==false) return false;
                    if(checkcol(board,i) ==false) return false;
                }
            }
        }
        if(!checkmatrix(board,0,0)) return false;
        if(!checkmatrix(board,0,3)) return false;
        if(!checkmatrix(board,0,6)) return false;
        if(!checkmatrix(board,3,0)) return false;
        if(!checkmatrix(board,3,3)) return false;
        if(!checkmatrix(board,3,6)) return false;
        if(!checkmatrix(board,6,0)) return false;
        if(!checkmatrix(board,6,3)) return false;
        if(!checkmatrix(board,6,6)) return false;



        return true;
    }
    public static boolean checkmatrix(char [][] board,int row,int col){
        HashSet<Character> set = new HashSet();
        int r =row;
        for(int i =0;i<3;i++) {
        	int c = col;
        	for(int j =0;j<3;j++) {
        		char  ch = board[r][c];
        		if(ch=='.') {c++; 
        			continue;}
        		if(set.contains(ch)) return false;
        		else set.add(ch);
        		c++;
        	}	
        	r++;
        }
        return true;
    }



    public static boolean checkrow(char [][] arr,int col){
        HashSet<Character> set = new HashSet();
        for(int i =0;i<arr.length;i++){
            if(arr[i][col]=='.') continue;
            if(set.contains(arr[i][col])){
                return false;
            }else{
                set.add(arr[i][col]);
            }
        }
        return true;
    }
    public static boolean checkcol(char [][] arr,int row){
        HashSet<Character> set = new HashSet();
        for(int i =0;i<arr[row].length;i++){
            if(arr[row][i]=='.') continue;
            if(set.contains(arr[row][i])){
                return false;
            }else{
                set.add(arr[row][i]);
            }
        }
        return true;
    }
    public static void main(String[] args) {
    	char [][] board1=
    			{{'1','2','.','.','3','.','.','.','.'},
    			 {'4','.','.','5','.','.','.','.','.'},
    			 {'.','9','8','.','.','.','.','.','3'},
    			 {'5','.','.','.','6','.','.','.','4'},
    			 {'.','.','.','8','.','3','.','.','5'},
    			 {'7','.','.','.','2','.','.','.','6'},
    			 {'.','.','.','.','.','.','2','.','.'},
    			 {'.','.','.','4','1','9','.','.','8'},
    			 {'.','.','.','.','8','.','.','7','9'}};

    	boolean output1=true;

    	
    	char [][] board2= 
    		     {{'1','2','.','.','3','.','.','.','.'},
    			 {'4','.','.','5','.','.','.','.','.'},
    			 {'.','9','1','.','.','.','.','.','3'},
    			 {'5','.','.','.','6','.','.','.','4'},
    			 {'.','.','.','8','.','3','.','.','5'},
    			 {'7','.','.','.','2','.','.','.','6'},
    			 {'.','.','.','.','.','.','2','.','.'},
    			 {'.','.','.','4','1','9','.','.','8'},
    			 {'.','.','.','.','8','.','.','7','9'}};
    	boolean output2= false;
    	
    	char [][] board3= 
    		{{'.','.','.','.','5','.','.','1','.'},
    		{'.','4','.','3','.','.','.','.','.'},
			{'.','.','.','.','.','3','.','.','1'},
			{'8','.','.','.','.','.','.','2','.'},
			{'.','.','2','.','7','.','.','.','.'},
			{'.','1','5','.','.','.','.','.','.'},
			{'.','.','.','.','.','2','.','.','.'},
			{'.','2','.','9','.','.','.','.','.'},
			{'.','.','4','.','.','.','.','.','.'}};
    	boolean output3= false;                      
    	
    	boolean ans1=isValidSudoku(board1);
    	boolean ans2=isValidSudoku(board2);
    	boolean ans3=isValidSudoku(board3);
		
		System.out.println("Brute Force Approch :");
		
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
