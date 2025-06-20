package suduko.generation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GenerateSuduko {
	
	public static int [][] generateSuduko( ){
		int [][] board= new int[9][9];		
		generate(board);
		return board;
	}
	
	public static boolean  generate(int [][] board) {	
		int r=-1;
		int c=-1;
		boolean isEmpty=false;
		for(int i =0;i<board.length;i++) {
			for(int j =0;j<board.length;j++) {
				if(board[i][j]==0) {
					r=i;
					c=j;
					isEmpty=true;
					break;
				}
			}
			if(isEmpty) {
				break;
			}
		}
		if(isEmpty==false) {
			return true;
		}
		List<Integer> validIntegers=getValidNumbers(board,r,c ); 
		while(validIntegers.size()!=0) {
			int tryNum = getRandomNumber(validIntegers);
			validIntegers.remove(Integer.valueOf(tryNum));
			int prev= board[r][c];
			board[r][c]=tryNum;			
			if(generate(board)) {
				return true;
			}else {
				board[r][c]=prev;				
			}
		}
		
		return false;
	}
	
	public static List<Integer> getValidNumbers(int [][] board, int row, int col) {	
		List<Integer> canput = new ArrayList<>();
		for(int i =1;i<=9;i++) {
			if(isSafe(board,row,col,i)) {
				canput.add(i);
			}
		}
		return canput;
	}
	
	public  static boolean isSafe(int [][] board,int row , int col , int num) {
		// check entire row check entire column:
		for(int i =0;i<board.length;i++) {
			if(board[row][i]==num) {
				return false;
			}
		}
		// check entire cols :
		for(int rows []: board) {
			if(rows[col]==num) {
				return false;
			}
		}
		// check 3*3 grid:
		int sqrt=(int) Math.sqrt(board.length);
		int r= row-(row%sqrt);
		int c= col-(col%sqrt);
		for(int i =r;i<r+sqrt;i++){
			for(int j=c;j<c+sqrt;j++) {
				if(board[i][j]==num) {
					return false;
				}
			}
		}
		return true;
	}
	public static int getRandomNumber(List<Integer> list) {
		if(list.size()==0) {
			return -1;
		}
		Random ran = new Random();
		int generateidx = ran.nextInt(0,list.size());
		return list.get(generateidx);
	}
	
	public static void main(String[] args) {
		
		int [][] suduko = generateSuduko();
		for(int [] row:suduko) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	

}
