//980. Unique Paths III
//Solved
//Hard
//Topics
//premium lock icon
//Companies
//You are given an m x n integer array grid where grid[i][j] could be:
//
//1 representing the starting square. There is exactly one starting square.
//2 representing the ending square. There is exactly one ending square.
//0 representing empty squares we can walk over.
//-1 representing obstacles that we cannot walk over.
//Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
//
// 
//
//Example 1:
//
//
//Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
//Output: 2
//Explanation: We have the following two paths: 
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
//2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
//Example 2:
//
//
//Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
//Output: 4
//Explanation: We have the following four paths: 
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
//2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
//3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
//4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
//Example 3:
//
//
//Input: grid = [[0,1],[2,0]]
//Output: 0
//Explanation: There is no path that walks over every empty square exactly once.
//Note that the starting and ending square can be anywhere in the grid.
// 
//
//Constraints:
//
//m == grid.length
//n == grid[i].length
//1 <= m, n <= 20
//1 <= m * n <= 20
//-1 <= grid[i][j] <= 2
//There is exactly one starting cell and one ending cell.


package Backtracking;
class UniquePathsIII_980 {
	
    public static  int uniquePathsIII(int[][] board) {
        for(int i =0;i<board.length;i++){
            for(int j =0;j<board[i].length;j++){
                if(board[i][j]==1){
                    return traverse(board,i,j);
                }
            }
        }
        return 0;
    }

    public static int traverse(int [][] board , int row , int col ) {
        if(row<0 || col<0 || row==board.length || col==board[0].length){
            return 0;
        }
        if(board[row][col]==-1){
            return 0;
        }
        if(board[row][col]==2){
             if(checkCoverEveryCell(board)){
                return 1;
             }
             return 0;
        }

        int res=0;
        int prev = board[row][col];
        board[row][col]=-1;
        //  check up :
        res+= traverse(board,row-1,col);
        //  check up :
        res+= traverse(board,row+1,col);
        //  check left :
        res+= traverse(board,row,col-1);
        //  check right :
        res+= traverse(board,row,col+1);
        board[row][col]=prev;
        return res;
    }
    public static boolean checkCoverEveryCell(int [][] board){
        for(int i =0;i<board.length;i++){
            for(int j =0;j<board[i].length;j++){
                if(board[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }
    
    
    public static void main(String[] args) {

//    	Example 1:
    	    	
    	int [][]grid1 = {{1,0,0,0},{0,0,0,0,},{0,0,2,-1}};
    	int output1=2;		

//    	Example 2:
    	
    	int [][]grid2 = {{1,0,0,0},{0,0,0,0,},{0,0,0,2}};
    	int output2=4;		

//    	Example 3:
    	
    	int [][]grid3 = {{0,1},{2,0}};
    	int output3=0;		
    	
    	int ans1= uniquePathsIII(grid1);
    	int ans2= uniquePathsIII(grid2);
    	int ans3= uniquePathsIII(grid3);
    	
    	
		
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