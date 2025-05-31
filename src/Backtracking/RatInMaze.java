//Rat in a Maze
//Last Updated : 23 Apr, 2025
//Given an n x n binary matrix representing a maze, where 1 means open and 0 means blocked, a rat starts at (0, 0) and needs to reach (n - 1, n - 1).
//
//The rat can move up (U), down (D), left (L), and right (R), but:
//
//It cannot visit the same cell more than once.
//It can only move through cells with value 1.
//Return all possible paths from the source to the destination as strings. If no path exists, return -1.
//
//Example:
//
//Input:
//
//
//
//Output: DRDDRR
//Explanation:
//




package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
	public static void AllPaths(int [][] board){
		List<String > res= new ArrayList();
		helper(board,"", 0, 0,res);
		if(res.size()==0) {
			System.out.println(-1);
		}else {
			System.out.println(res);
		}
		
	}
	
	public static void helper(int [][] board,String path ,int r, int c,List<String> res) {
		if(r<0 || c<0 || r==board.length || c == board[0].length) {
			return ;
		}
		if(board[r][c]==-1) {
			return ;
		}
		if(r==board.length-1 && c==board[0].length-1) {
			res.add(path);
			return ;
		}
		int temp =board[r][c]=-1;
		board[r][c]=-1;
//		go left :
		
		helper(board, path+'L', r, c-1,res);		
//		go right :
		helper(board, path+'R', r, c+1,res);
//		go up :
		helper(board, path+'U', r-1, c,res);		
//		go down:
		helper(board, path+'D', r+1, c,res);		
		board[r][c]=temp;
	}
	
	public static void main(String[] args) {
		
		int [][] board1= {
				{1,-1,-1,-1},
				{1,1,-1,1},
				{-1,1,-1,-1},
				{1,1,1,1}
						};
		int [][] board2= {
				{1,-1,-1,-1},
				{-1,-1,-1,1},
				{-1,1,-1,-1},
				{1,1,1,1}
		};

		AllPaths(board1);		
		AllPaths(board2);
	}

}
