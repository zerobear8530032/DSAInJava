//Chess is a very popular game played by hundreds of millions of people. Nowadays, we have chess engines such as Stockfish and Komodo to help us analyze games. These engines are very powerful pieces of well-developed software that use intelligent ideas and algorithms to analyze positions and sequences of moves, as well as find tactical ideas. Consider the following simplified version of chess:
//
//Board: It's played on a  board between two players named Black and White.
//Pieces and Movement:
//White initially has  pieces and Black initially has  pieces.
//There are no Kings and no Pawns on the board. Each player has exactly one Queen, at most two Rooks, and at most two minor pieces (i.e., a Bishop and/or Knight).
//Each piece's possible moves are the same as in classical chess, and each move made by any player counts as a single move.
//There is no draw when positions are repeated as there is in classical chess.
//Objective: The goal of the game is to capture the opponent’s Queen without losing your own.
//Given  and the layout of pieces for  games of simplified chess, implement a very basic (in comparison to the real ones) engine for our simplified version of chess with the ability to determine whether or not White can win in  moves (regardless of how Black plays) if White always moves first. For each game, print YES on a new line if White can win under the specified conditions; otherwise, print NO.
//
//Input Format
//
//The first line contains a single integer, , denoting the number of simplified chess games. The subsequent lines define each game in the following format:
//
//The first line contains three space-separated integers denoting the respective values of  (the number of White pieces),  (the number of Black pieces), and  (the maximum number of moves we want to know if White can win in).
//The  subsequent lines describe each chesspiece in the format t c r, where  is a character  denoting the type of piece (where  is Queen,  is Knight,  is Bishop, and  is Rook), and  and  denote the respective column and row on the board where the figure is placed (where  and ). These inputs are given as follows:
//Each of the  subsequent lines denotes the type and location of a White piece on the board.
//Each of the  subsequent lines denotes the type and location of a Black piece on the board.
//Constraints
//
//It is guaranteed that the locations of all pieces given as input are distinct.
//Each player initially has exactly one Queen, at most two Rooks and at most two minor pieces.
//Output Format
//
//For each of the  games of simplified chess, print whether or not White can win in  moves on a new line. If it's possible, print YES; otherwise, print NO.
//
//Sample Input 0
//
//1
//2 1 1
//N B 2
//Q B 1
//Q A 4
//Sample Output 0
//
//YES
//Explanation 0
//
//We play  games of simplified chess, where the initial piece layout is as follows:
//
//simplified-chess.png
//
//White is the next to move, and they can win the game in  move by taking their Knight to  and capturing Black's Queen. Because it took  move to win and , we print YES on a new line.

package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

interface pieces{
	public List<int []> generateAllPossibleMoves(int r, int c,pieces [][] board);
	default boolean canCapture(pieces[][] board,int currx, int curry, int oppx, int oppy ) {
		pieces player= board[currx][curry];
		pieces opponent= board[oppx][oppy];
		if(opponent==null) {
			return true;
		}
		return !(opponent.getColor().equals(player.getColor()));
	}	
	default boolean isInBounds(int r,pieces [][] board) {
		return r>=0 && r<board.length;
	}
	public String getName();
	public String getColor();
	
	public void setR(int r) ;
	public void setC(int c) ;
	public int getR() ;
	public int getC() ;
}


class Knight implements pieces{
	String color;
	int r;
	int c;
	
	
	public Knight(String color, int r , int c) {
		this.color=color;
		this.r=r;
		this.c=c;
	}
	
	public void setColor(String color) {
		this.color=color;
	}
	public String getColor() {
		return this.color;
	}
	
	@Override
	public int getR() {
		return this.r;
	}
	@Override
	public int getC() {
		return this.c;
	}
	@Override
	public void setR(int r) {
		this.r=r;
	}
	@Override
	public void setC(int c) {
		this.c=c;
	}
	
	@Override
	public String getName() {
		String name = this.color.charAt(0)+"K";
		return name;
	}
	
	
	
	@Override
	public String toString() {
		char ch = color.charAt(0);
		return ch+"K";
	}
	
	@Override
	public List<int[]> generateAllPossibleMoves(int r, int c, pieces [][] board) {
		List<int []>  moves = new ArrayList<int[]>();
		int row = r-2;
		if(isInBounds(row,board)) {
			int col = c+1;
			if(isInBounds(col,board)) {
				if(canCapture(board, r,c,row,col)) {
					moves.add( new int []{row,col});					
				}
			}
			col = c-1;
			if(isInBounds(col,board)) {
				if(canCapture(board, r,c,row,col)) {
					moves.add( new int []{row,col});					
				}
			}
		}
		row = r+2;
		if(isInBounds(row,board)) {
			int col = c+1;
			if(isInBounds(col,board)) {
				if(canCapture(board, r,c,row,col)) {
					moves.add( new int []{row,col});					
				}
			}
			col = c-1;
			if(isInBounds(col,board)) {
				if(canCapture(board, r,c,row,col)) {
					moves.add( new int []{row,col});					
				}
			}
		}
		int col = c-2;
		if(isInBounds(col,board)) {
			row = r+1;
			if(isInBounds(row,board)) {
				if(canCapture(board, r,c,row,col)) {
					moves.add( new int []{row,col});					
				}
			}
			row=r-1;
			if(isInBounds(row,board)) {
				if(canCapture(board, r,c,row,col)) {
					moves.add( new int []{row,col});					
				}
			}
		}
		col = c+2;
		if(isInBounds(col,board)) {
			row = r+1;
			if(isInBounds(row,board)) {
				if(canCapture(board, r,c,row,col)) {
					moves.add( new int []{row,col});					
				}
			}
			row=r-1;
			if(isInBounds(row,board)) {
				if(canCapture(board, r,c,row,col)) {
					moves.add( new int []{row,col});					
				}
			}
		}
		return moves;
	}
	
}


class Queen implements pieces{
	String color;
	int r;
	int c;
	
	public Queen(String color, int r , int c) {
		this.color=color;
		this.r=r;
		this.c=c;
	}
	
	public void setColor(String color) {
		this.color=color;
	}
	public String getColor() {
		return this.color;
	}
	
	@Override
	public int getR() {
		return this.r;
	}
	@Override
	public int getC() {
		return this.c;
	}
	@Override
	public void setR(int r) {
		this.r=r;
	}
	@Override
	public void setC(int c) {
		this.c=c;
	}
	
	
	@Override
	public String toString() {
		char ch = color.charAt(0);
		return ch+"Q";
	}
	
	@Override
	public String getName() {
		String name = this.color.charAt(0)+"Q";
		return name;
	}
	
	@Override
	public List<int[]> generateAllPossibleMoves(int r, int c, pieces [][] board) {
		List<int []> moves = new ArrayList<int[]>();
//		goUP:
		for(int i=r-1;i>=0;i--) {
			if(board[i][c]!=null) {
				if(canCapture(board,r,c,i,c )) {
					moves.add(new int [] {i,c});
					break;
				}else {
					break;
				}
			}else {
				moves.add(new int [] {i,c});
			}
		}
//		go down:
		for(int i=r+1;i<board.length;i++) {
			if(board[i][c]!=null) {
				if(canCapture(board,r,c,i,c )) {
					moves.add(new int [] {i,c});
					break;
				}else {
					break;
				}
			}else {
				moves.add(new int [] {i,c});
			}
		}
		
//		go left:
		for(int i=c-1;i>=0;i--) {
			if(board[r][i]!=null) {
				if(canCapture(board,r,c,r,i )) {
					moves.add(new int [] {r,i});
					break;
				}else {
					break;
				}
			}else {
				moves.add(new int [] {r,i});
			}
		}
//		go right:
		for(int i=c+1;i<board.length;i++) {
			if(board[r][i]!=null) {
				if(canCapture(board,r,c,r,i )) {
					moves.add(new int [] {r,i});
					break;
				}else {
					break;
				}
			}else {
				moves.add(new int [] {r,i});
			}
		}
		
//		go upper left:
		int row =r-1;
		int col =c-1;
		while(isInBounds(row, board) && isInBounds(col, board)) {
			if(board[row][col]!=null) {
				if(canCapture(board,r,c,row,col )) {
					moves.add(new int [] {row,col});
					break;
				}else {
					break;
				}
			}else {
				moves.add(new int [] {row,col});
			}
			row--;
			col--;
		}
//		go upper righ:
		row =r-1;
		col =c+1;
		while(isInBounds(row, board) && isInBounds(col, board)) {
			if(board[row][col]!=null) {
				if(canCapture(board,r,c,row,col )) {
					moves.add(new int [] {row,col});
					break;
				}else {
					break;
				}
			}else {
				moves.add(new int [] {row,col});
			}
			row--;
			col++;
		}
		
//		go down left:
		row =r+1;
		col =c-1;
		while(isInBounds(row, board) && isInBounds(col, board)) {
			if(board[row][col]!=null) {
				if(canCapture(board,r,c,row,col )) {
					moves.add(new int [] {row,col});
					break;
				}else {
					break;
				}
			}else {
				moves.add(new int [] {row,col});
			}
			row++;
			col--;
		}
//		go down right:
		row =r+1;
		col =c+1;
		while(isInBounds(row, board) && isInBounds(col, board)) {
			if(board[row][col]!=null) {
				if(canCapture(board,r,c,row,col )) {
					moves.add(new int [] {row,col});
					break;
				}else {
					break;
				}
			}else {
				moves.add(new int [] {row,col});
			}
			row++;
			col++;
		}
		return moves;
	}
	
}


class Rook implements pieces{
	String color;
	int r;
	int c;
	public Rook(String color, int row, int col) {
		this.color=color;
		this.r=r;
		this.c=c;
	}
	
	public void setColor(String color) {
		this.color=color;
	}
	public String getColor() {
		return this.color;
	}
	
	@Override
	public int getR() {
		return this.r;
	}
	@Override
	public int getC() {
		return this.c;
	}
	@Override
	public void setR(int r) {
		this.r=r;
	}
	@Override
	public void setC(int c) {
		this.c=c;
	}
	
	@Override
	public String toString() {
		char ch = color.charAt(0);
		return ch+"R";
	}
	
	@Override
	public List<int[]> generateAllPossibleMoves(int r, int c, pieces [][] board) {
		List<int []> moves = new ArrayList<int[]>();
//		goUP:
		for(int i=r-1;i>=0;i--) {
			if(board[i][c]!=null) {
				if(canCapture(board,r,c,i,c )) {
					moves.add(new int [] {i,c});
					break;
				}else {
					break;
				}
			}else {
				moves.add(new int [] {i,c});
			}
		}
//		go down:
		for(int i=r+1;i<board.length;i++) {
			if(board[i][c]!=null) {
				if(canCapture(board,r,c,i,c )) {
					moves.add(new int [] {i,c});
					break;
				}else {
					break;
				}
			}else {
				moves.add(new int [] {i,c});
			}
		}
		
//		go left:
		for(int i=c-1;i>=0;i--) {
			if(board[r][i]!=null) {
				if(canCapture(board,r,c,r,i )) {
					moves.add(new int [] {r,i});
					break;
				}else {
					break;
				}
			}else {
				moves.add(new int [] {r,i});
			}
		}
//		go right:
		for(int i=c+1;i<board.length;i++) {
			if(board[r][i]!=null) {
				if(canCapture(board,r,c,r,i )) {
					moves.add(new int [] {r,i});
					break;
				}else {
					break;
				}
			}else {
				moves.add(new int [] {r,i});
			}
		}
				return moves;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}

class Bishop implements pieces{
		String color;
		int r ;
		int c;
		public Bishop(String color, int r , int c) {
			this.color=color;
			this.r=r;
			this.c=c;
		}
		
		public void setColor(String color) {
			this.color=color;
		}
		public String getColor() {
			return this.color;
		}
		
		@Override
		public int getR() {
			return this.r;
		}
		@Override
		public int getC() {
			return this.c;
		}
		@Override
		public void setR(int r) {
			this.r=r;
		}
		@Override
		public void setC(int c) {
			this.c=c;
		}
		
		@Override
		public String toString() {
			char ch = color.charAt(0);
			return ch+"B";
		}
		
		@Override
		public List<int[]> generateAllPossibleMoves(int r, int c, pieces [][] board) {
			List<int []> moves = new ArrayList<int[]>();
//			go upper left:
			int row =r-1;
			int col =c-1;
			while(isInBounds(row, board) && isInBounds(col, board)) {
				if(board[row][col]!=null) {
					if(canCapture(board,r,c,row,col )) {
						moves.add(new int [] {row,col});
						break;
					}else {
						break;
					}
				}else {
					moves.add(new int [] {row,col});
				}
				row--;
				col--;
			}
//			go upper righ:
			row =r-1;
			col =c+1;
			while(isInBounds(row, board) && isInBounds(col, board)) {
				if(board[row][col]!=null) {
					if(canCapture(board,r,c,row,col )) {
						moves.add(new int [] {row,col});
						break;
					}else {
						break;
					}
				}else {
					moves.add(new int [] {row,col});
				}
				row--;
				col++;
			}
			
//			go down left:
			row =r+1;
			col =c-1;
			while(isInBounds(row, board) && isInBounds(col, board)) {
				if(board[row][col]!=null) {
					if(canCapture(board,r,c,row,col )) {
						moves.add(new int [] {row,col});
						break;
					}else {
						break;
					}
				}else {
					moves.add(new int [] {row,col});
				}
				row++;
				col--;
			}
//			go down right:
			row =r+1;
			col =c+1;
			while(isInBounds(row, board) && isInBounds(col, board)) {
				if(board[row][col]!=null) {
					if(canCapture(board,r,c,row,col )) {
						moves.add(new int [] {row,col});
						break;
					}else {
						break;
					}
				}else {
					moves.add(new int [] {row,col});
				}
				row++;
				col++;
			}

			return moves;
		}

		@Override
		public String getName() {
			return this.color.charAt(0)+"B";
		}
}





public class SimpleChessEngine {
	public static boolean canWin(pieces [][] board, int moves) {
		List<pieces>  blackpieces= new ArrayList();
		List<pieces>  whitepieces= new ArrayList();
		for(int i=0;i<board.length;i++) {
			for(int j =0;j<board.length;j++) {
				if(board[i][j]!=null) {
					String color= board[i][j].getColor();
					if(color.equalsIgnoreCase("White")) {
						whitepieces.add(board[i][j]);
					}else {
						blackpieces.add(board[i][j]);						
					}
				}
			}
		}
		return helper(board,moves,blackpieces,whitepieces);
	}
	
	
	
	
	 static boolean helper(pieces[][] board, int moves, List<pieces> blacks, List<pieces> whites) {
		 if(isWon(board)) {
			 return true;
		 }
		 if(moves==0) {
			 return false;
		 }
		 boolean result = false;
		 for(pieces p: whites) {
			 List<int []> allmoves= p.generateAllPossibleMoves(p.getR(), p.getC(), board);
			 int prevR= p.getR();
			 int prevC= p.getC();
			 for(int [] RC : allmoves) {
				 int nextR= RC[0];
				 int nextC= RC[1];
				 if(board[nextR][nextC]==null) {					 
				 p.setR(nextR);
				 p.setC(nextC);
				 board[prevR][prevC]=null;
				 board[nextR][nextC]=p;
				 printMatrix(board);
				 System.out.println();
				 System.out.println();

				 if(helper(board,moves-1,blacks,whites)) {
					 return true;
				 }else {
					 
//				 back tracked
				 board[nextR][nextC]=null;
				 board[prevR][prevC]=p;
				 p.setR(prevR);
				 p.setC(prevC);
				 printMatrix(board);
				 System.out.println();
				 System.out.println();
				 }
				 }else {
					 if(p.canCapture(board, prevR,prevC,nextR,nextC)) {
						 pieces captured=board[nextR][nextC];
						 p.setR(nextR);
						 p.setC(nextC);
						 board[prevR][prevC]=null;
						 board[nextR][nextC]=p;
						 if(captured.getColor().equals("White")) {
							 whites.remove(captured);
						 }else {
							 blacks.remove(captured);							 
						 }
						 printMatrix(board);
						 System.out.println();
						 System.out.println();

						 if(helper(board,moves-1,blacks,whites)) {
							 return true;
						 }else {
							 
						 p.setR(prevR);
						 p.setC(prevC);
						 if(captured.getColor().equals("Whites")) {
							 whites.add(captured);
						 }else {
							 blacks.add(captured);							 
						 }
						 board[nextR][nextC]=captured;
						 board[prevR][prevC]=p;
						 printMatrix(board);
						 System.out.println();
						 System.out.println();
						 }
					 }
					 
				 }
			 }
//			 black turns:
			 for(pieces bp: blacks) {
				 List<int []> allblackmoves= bp.generateAllPossibleMoves(bp.getR(), bp.getC(), board);
				 int prevBR= bp.getR();
				 int prevBC= bp.getC();
				 for(int [] RC : allblackmoves) {
					 int nextR= RC[0];
					 int nextC= RC[1];
					 if(board[nextR][nextC]==null) {					 
					 bp.setR(nextR);
					 bp.setC(nextC);
					 board[prevBR][prevBC]=null;
					 board[nextR][nextC]=bp;
					 printMatrix(board);
					 System.out.println();
					 System.out.println();

					 if(helper(board,moves,blacks,whites)) {
						 return true;
					 }else {
						 
//					 back tracked
					 board[nextR][nextC]=null;
					 board[prevBR][prevBC]=bp;
					 bp.setR(prevBR);
					 bp.setC(prevBC);
					 }
					 }else {
						 if(bp.canCapture(board, prevBR,prevBC,nextR,nextC)) {
							 pieces captured=board[nextR][nextC];
							 bp.setR(nextR);
							 bp.setC(nextC);
							 board[prevBR][prevBC]=null;
							 board[nextR][nextC]=bp;
							 if(captured.getColor().equals("White")) {
								 whites.remove(captured);
							 }else {
								 blacks.remove(captured);							 
							 }
							 printMatrix(board);
							 System.out.println();
							 System.out.println();

							 if(helper(board,moves,blacks,whites)) {
								 return true;
							 }else {
								 
							 bp.setR(prevBR);
							 bp.setC(prevBC);
							 if(captured.getColor().equals("Whites")) {
								 whites.add(captured);
							 }else {
								 blacks.add(captured);							 
							 }
							 board[nextR][nextC]=captured;
							 board[prevBR][prevBC]=bp;
							 }
						 }
						 
					 }
				 }				 

//				 -------------------
				 
			 }
			 
			 
			 
			 
		 }
		 return result;
		 
	}




	public static boolean isWon(pieces [][] board) {
		for(int i =0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				if(board[i][j]==null) {
					continue;
				}
				pieces piece= board[i][j];
				if(piece.getName().equals("BQ")) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	public static void printMatrix(pieces [][] matrix) {
		for(int i =0;i<matrix.length;i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		pieces [][] board= new pieces[4][4];
		int games = sc.nextInt();
		for(int i =0;i<games;i++) {
			int whitepieces= sc.nextInt();
			int blackpieces= sc.nextInt();
			int moves= sc.nextInt();
			for(int p =0;p<whitepieces;p++) {
				char type = sc.next().charAt(0);
				int col = sc.next().charAt(0)-'A';
				int row = board.length-sc.nextInt();
				if(type == 'Q') {
					pieces	player = new Queen("White",row,col);
					board[row][col]=player;
				}else if(type == 'N') {
					pieces	player = new Knight("White",row,col);					
					board[row][col]=player;
				}else if(type== 'R') {
					pieces	player = new Rook("White",row,col);										
					board[row][col]=player;
				}else {
					pieces	player = new Bishop("White",row,col);															
					board[row][col]=player;
				}
			}
			for(int p =0;p<blackpieces;p++) {
				char type = sc.next().charAt(0);
				int col = sc.next().charAt(0)-'A';
				int row = board.length-sc.nextInt();
				if(type=='Q') {
					pieces	player = new Queen("Black",row,col);
					board[row][col]=player;
				}else if(type == 'K') {
					pieces	player = new Knight("Black",row,col);					
					board[row][col]=player;
				}else if(type== 'R') {
					pieces	player = new Rook("Black",row,col);										
					board[row][col]=player;
				}else {
					pieces	player = new Bishop("Black",row,col);															
					board[row][col]=player;
				}
				
			}
			
			
			printMatrix(board);
			System.out.println();
			System.out.println();
			System.out.println(canWin(board,moves));
//			1
//			1 1 2
//			Q B 1
//			Q A 4
//1
//1 1 1
//Q B 1
//Q A 4

		}
		
	}
	}


