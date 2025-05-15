//find all the possible paths to reach the end of a maze where 
// you can move in all 4 directions

package Backtracking;

import java.util.Arrays;

public class MoveToEnd {
	
	
	public static void printAllPaths(String path,boolean [][] maze, int r, int c) {
		if(r>=maze.length || c>=maze[0].length || r<0 || c<0 ) {
			return ;
		}
		if(maze[r][c]==false) {
			return ;
		}
		
		if(r==maze.length-1 && c==maze.length-1) {
			System.out.println(path);
			return;
		}
		
		//	left side
		maze[r][c]=false;
		printAllPaths(path+"L", maze, r, c-1);
		
		//	right side
		printAllPaths(path+"R", maze, r, c+1);
		
		//	down side
		printAllPaths(path+"D", maze, r+1, c);
		
		//	up side
		printAllPaths(path+"U", maze, r-1, c);
		maze[r][c]=true;
	}
	
	public static void printAllPathsWithSteps(String path,int step, boolean [][] maze,int [][] paths, int r, int c) {
		if(r>=maze.length || c>=maze[0].length || r<0 || c<0 ) {
			return ;
		}
		if(maze[r][c]==false) {
			return ;
		}
		
		if(r==maze.length-1 && c==maze.length-1) {
			paths[r][c]=step;
			for(int [] x:  paths) {
				System.out.println(Arrays.toString(x));
			}
			System.out.println(path);
			System.out.println();
			return;
		}
		
		//	left side
		maze[r][c]=false;
		paths[r][c]=step;
		printAllPathsWithSteps(path+'L',step+1,maze,paths, r, c-1);
		
		//	right side
		printAllPathsWithSteps(path+'R',step+1, maze,paths, r, c+1);
		
		//	down side
		printAllPathsWithSteps(path+'D',step+1, maze, paths,r+1, c);
		
		//	up side
		printAllPathsWithSteps(path+'U',step+1, maze, paths,r-1, c);
		paths[r][c]=0;
		maze[r][c]=true;
	}
	public static void main(String args[]) {
		
		boolean [] [] maze= 
			{
					{true,true,true},
					{true,true,true},
					{true,true,true}				
			};
		int [] [] paths=  new int [3][3];
		
		printAllPathsWithSteps("",1, maze, paths, 0, 0);
		
	}

}
