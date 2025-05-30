//Longest Possible Route in a Matrix with Hurdles
//Last Updated : 04 Jun, 2023
//Given an M x N matrix, with a few hurdles arbitrarily placed, calculate the length of the longest possible route possible from source to a destination within the matrix. We are allowed to move to only adjacent cells which are not hurdles. The route cannot contain any diagonal moves and a location once visited in a particular path cannot be visited again.
//
//For example, the longest path with no hurdles from source to destination is highlighted below. The length of the path is 24.
// 1 1 1 1 1 1 1 1 1 1
// 1 1 0 1 1 0 1 1 0 1
// 1 1 1 1 1 1 1 1 1 1


package Backtracking;

public class LongestPath {
//	backtracking :
//	we can use backtracking and check each direction what is the highest we can go each side and add it to the result

	public static int findLongestPath(int [][] board, int r, int c) {
		return helper(board, r,c,0,0,0);
	}
	public static int helper(int [][] board, int dr , int dc,int cr , int cc,int curr) {
		if(cr<0 || cr==board.length || cc<0 || cc== board[0].length) {
			return 0;
		}
		if(board[cr][cc]==0) {
			return 0;
		}
		if(dr==cr && dc ==cc) {
			return curr;
		}
		int res=0;
		int temp =board[cr][cc];
		board[cr][cc]=0;
		int left = helper(board,dr,dc,cr,cc-1,curr+1);
		int right= helper(board,dr,dc,cr,cc+1,curr+1);
		int up= helper(board,dr,dc,cr-1,cc,curr+1);
		int down= helper(board,dr,dc,cr+1,cc,curr+1);
		res= Math.max(left, res);
		res= Math.max(right, res);
		res= Math.max(up, res);
		res= Math.max(down, res);
		board[cr][cc]=temp;
		
		return res;
		
	}
	
	public static void main(String[] args) {
		
		int [][] maze = {
				{1,1,1,1,1,1,1,1,1,1},
				{1,1,0,1,1,0,1,1,0,1},
				{1,1,1,1,1,1,1,1,1,1}
		};
		
		System.out.println(findLongestPath(maze, 1, 7));
	}

}
