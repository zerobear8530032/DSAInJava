//find all the total number of paths to reach the end of the matrix 
package Recursion.learning;

import java.util.ArrayList;
import java.util.List;

public class MazeProblem {

	public static int totalPaths(int r,int c) {
		if(r==1 || c==1) return 1;
		
		int down = totalPaths(r-1,c);
		int right = totalPaths(r,c-1);
		return down+right;
	}
	
//	print all paths
	public static  void printTotalPaths(String p,int r,int c) {
		if(r==-1 || c==-1) {
			
			return ;
		}
		if(r==1 && c==1) {
			System.out.print(p+" , ");
			return ;
		}
		printTotalPaths(p+'D',r-1,c);
		printTotalPaths(p+'R',r,c-1);
	}
//	return all paths
	public static  List<String> returnTotalPaths(String p,int r,int c) {
		if(r==-1 || c==-1) {
			return new ArrayList();
		}
		if(r==1 && c==1) {
			List<String> res= new ArrayList();
			res.add(p);
			return res;
		}
		List<String> output=new ArrayList();
		List<String> down =returnTotalPaths(p+'D',r-1,c);
		if(down!=null) output.addAll(down);
		List<String> left =returnTotalPaths(p+'R',r,c-1);
		if(left!=null) output.addAll(left);
		return output;
	}
	
	
	public static int totalPathsDiagonal(int r,int c) {
		if(r==0 || c==0) return 0;
		if(r==1 || c==1) return 1;
		
		int down = totalPaths(r-1,c);
		int right = totalPaths(r,c-1);
		int diagonal = totalPaths(r-1,c-1);
		return down+right+diagonal;
	}
	
//	print all paths
	public static  void printTotalPathsDiagonal(String p,int r,int c) {
		if(r==0 || c==0) {
			return ;
		}
		if(r==1 && c==1) {
			System.out.print(p+" , ");
			return ;
		}
		printTotalPaths(p+'D',r-1,c);
		printTotalPaths(p+'R',r,c-1);
		printTotalPaths(p+"d",r-1,c-1);
	}
//	return all paths
	public static  List<String> returnTotalPathsDiagonal(String p,int r,int c) {
		if(r==-1 || c==-1) {
			return new ArrayList();
		}
		if(r==1 && c==1) {
			List<String> res= new ArrayList();
			res.add(p);
			return res;
		}
		List<String> output=new ArrayList();
		List<String> down =returnTotalPaths(p+'D',r-1,c);
		if(down!=null) output.addAll(down);
		List<String> left =returnTotalPaths(p+'R',r,c-1);
		if(left!=null) output.addAll(left);
		List<String> diagonal =returnTotalPaths(p+'d',r,c-1);
		if(diagonal!=null) output.addAll(diagonal);
		return output;
	}
	
	public static void main(String[] args) {
		
		int r1=3, c1=3;
		int r2=5, c2=3;
		int r3=2, c3=6;
		
//		System.out.println(totalPaths(r1, c1));
//		System.out.println(totalPaths(r2, c2));
//		System.out.println(totalPaths(r3, c3));
//		
//		printTotalPaths("",r1, c1);
//		System.out.println();		
//		printTotalPaths("",r2, c2);
//		System.out.println();
//		printTotalPaths("",r3, c3);
//		System.out.println();
//		
//		System.out.println(returnTotalPaths("",r1, c1));
//		System.out.println(returnTotalPaths("",r2, c2));
//		System.out.println(returnTotalPaths("",r3, c3));
		
//		System.out.println(totalPathsDiagonal(r1, c1));
//		System.out.println(totalPathsDiagonal(r2, c2));
//		System.out.println(totalPathsDiagonal(r3, c3));
		
//		printTotalPathsDiagonal("",r1, c1);
//		System.out.println();		
//		printTotalPathsDiagonal("",r2, c2);
//		System.out.println();
//		printTotalPathsDiagonal("",r3, c3);
//		System.out.println();

		System.out.println(returnTotalPathsDiagonal("",r1, c1));
		System.out.println(returnTotalPathsDiagonal("",r2, c2));
		System.out.println(returnTotalPathsDiagonal("",r3, c3));
		

	}
}
