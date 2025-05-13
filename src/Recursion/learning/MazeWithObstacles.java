package Recursion.learning;

import java.util.ArrayList;
import java.util.List;

public class MazeWithObstacles {

	
	public static int totalPaths(boolean [][] maze, int r, int c) {
		if(r==-1 || c==-1) {
			return 0;
		}
		if(maze[r][c]==false) {
			return 0;
		}
		if(r==0 && c==0 ) {
			return 1;
		}
		int down = totalPaths(maze, r-1, c);
		int right= totalPaths(maze, r, c-1);
		return right+down;
		
	}
	
	public static void printTotalPaths(String p,boolean [][] maze, int r, int c) {
		if(r==-1 || c==-1) {
			return ;
		}
		if(maze[r][c]==false) {
			return ;
		}
		if(r==0 && c==0 ) {
			System.out.print(p+" ,");
			return ;
		}
		printTotalPaths(p+'D',maze, r-1, c);
		printTotalPaths(p+'R',maze, r, c-1);
	}
	
	public static List<String> returnTotalPaths(String p,boolean [][] maze, int r, int c) {
		if(r==-1 || c==-1) {
			return null;
		}
		if(maze[r][c]==false) {
			return null;
		}
		if(r==0 && c==0 ) {
			List<String> res=new ArrayList<String>();
			res.add(p);
			return res;
		}
		
		List<String> res=new ArrayList<String>();
		List<String> down=returnTotalPaths(p+'D',maze, r-1, c);
		if(down!=null) {
			res.addAll(down);
		}
		List<String> right=returnTotalPaths(p+'R',maze, r, c-1);
		if(right!=null) {
			res.addAll(right);
		}
		return res;
	}
	public static void main(String[] args) {
		
		boolean [][] matrix1 = {
								{true,true,true},
								{true,false,true},
								{true,true,true}
								};
		boolean [][] matrix2 = {
								{true,true,true,true},
								{true,false,true,true},
								{true,true,true,true}
								};
		
		System.out.println(totalPaths(matrix1, matrix1.length-1, matrix1[0].length-1));
		System.out.println(totalPaths(matrix2, matrix2.length-1, matrix2[0].length-1));
				
		printTotalPaths("",matrix1 ,matrix1.length-1, matrix1[0].length-1);
		System.out.println();
		printTotalPaths("",matrix2 ,matrix2.length-1, matrix2[0].length-1);
		System.out.println();
		
		System.out.println(returnTotalPaths("",matrix1, matrix1.length-1, matrix1[0].length-1));
		System.out.println(returnTotalPaths("",matrix2, matrix2.length-1, matrix2[0].length-1));
		
		
		
	}

}
