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

import java.util.Arrays;

interface pieces{
	public int getRow() ;
	public void setRow(int row) ;
	public int getCol() ;
	public void setCol(int col) ;
	public String getColor() ;
	public void setColor(String color) ;
	public String toString() ;	
}

class Knight implements pieces{
	int row;
	int col ;
	String color ;
	public Knight(int r, int c,String color) {
		row=r;
		col=c;
		this.color= color;
	}
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Knight";
	}
	
	public void moveUpLeft(pieces [][] matrix, Knight k) throws Exception {
		if(row-2<0) {
			throw new Exception();
		}
		if(col-1<0) {
			throw new Exception();
		}	
		int r= row-2;
		int c= col-1;
		if(matrix[r][c]== null){
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=k;
		}else {
			pieces piece= matrix[r][c];
			if(piece.getColor().equals(k.getColor())){
				throw new Exception();	
			}		
		}

	}
	public void moveUpRight(pieces [][] matrix, Knight k) throws Exception {
		if(row-2<0) {
			throw new Exception();
		}
		if(col+1>=matrix[0].length) {
			throw new Exception();
		}	
		int r= row-2;
		int c= col+1;
		if(matrix[r][c]== null){
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=k;
		}else {
			pieces piece= matrix[r][c];
			if(piece.getColor().equals(k.getColor())){
				throw new Exception();	
			}		
		}
	}
	public void moveDownLeft(pieces [][] matrix, Knight k) throws Exception {
		if(row+2>=matrix.length) {
			throw new Exception();
		}
		if(col-1<0) {
			throw new Exception();
		}	
		int r= row+2;
		int c= col-1;
		if(matrix[r][c]== null){
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=k;
		}else {
			pieces piece= matrix[r][c];
			if(piece.getColor().equals(k.getColor())){
				throw new Exception();	
			}		
		}
	}
	public void moveDownRight(pieces [][] matrix, Knight k) throws Exception {
		if(row+2>=matrix.length) {
			throw new Exception();
		}
		if(col+1>=matrix[0].length) {
			throw new Exception();
		}	
		int r= row+2;
		int c= col+1;
		if(matrix[r][c]== null){
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=k;
		}else {
			pieces piece= matrix[r][c];
			if(piece.getColor().equals(k.getColor())){
				throw new Exception();	
			}		
		}
	}
	
	
	
	public void moveLeftUp(pieces [][] matrix, Knight k) throws Exception {
		if(col-2<0) {
			throw new Exception();
		}
		if(row-1<0) {
			throw new Exception();
		}	
		int c= col-1;
		int r= row-1;
		if(matrix[r][c]== null){
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=k;
		}else {
			pieces piece= matrix[r][c];
			if(piece.getColor().equals(k.getColor())){
				throw new Exception();	
			}		
		}
	}
	
	public void moveLeftDown(pieces [][] matrix, Knight k) throws Exception {
		if(col-2<0) {
			throw new Exception();
		}
		if(row+1>=matrix.length) {
			throw new Exception();
		}		
		int c= col-1;
		int r= row+1;
		if(matrix[r][c]== null){
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=k;
		}else {
			pieces piece= matrix[r][c];
			if(piece.getColor().equals(k.getColor())){
				throw new Exception();	
			}		
		}

	}
	public void moveRightUp(pieces [][] matrix, Knight k) throws Exception {
		if(col+2>=matrix[0].length) {
			throw new Exception();
		}
		if(row-1<0) {
			throw new Exception();
		}		
		int c= col+2;
		int r= row-1;
		if(matrix[r][c]== null){
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=k;
		}else {
			pieces piece= matrix[r][c];
			if(piece.getColor().equals(k.getColor())){
				throw new Exception();	
			}		
		}
	}
	public void moveRightDown(pieces [][] matrix, Knight k) throws Exception {
		if(col+2>=matrix[0].length) {
			throw new Exception();
		}
		if(row+1>=matrix.length) {
			throw new Exception();
		}		
		int c= col+2;
		int r= row+1;
		if(matrix[r][c]== null){
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=k;
		}else {
			pieces piece= matrix[r][c];
			if(piece.getColor().equals(k.getColor())){
				throw new Exception();	
			}		
		}
		

		}
}


class Bishop implements pieces{
	int row;
	int col ;
	String color ;
	public Bishop(int r, int c,String color) {
		row=r;
		col=c;
		this.color= color;
	}
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	@Override
	public String toString() {
		return "Bishop";
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void moveUpLeft(pieces [][] matrix, Bishop b) throws Exception {
		if(row-1<0) {
			throw new Exception();
		}
		if(col-1<0) {
			throw new Exception();
		}	
		int r= row-1;
		int c= col-1;
		if(matrix[r][c]== null){
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=b;
		}else {
			pieces piece= matrix[r][c];
			if(piece.getColor().equals(b.getColor())){
				throw new Exception();	
			}		
		}

	}
	public void moveUpRight(pieces [][] matrix, Bishop b) throws Exception {
		if(row-1<0) {
			throw new Exception();
		}
		if(col+1>=matrix[0].length) {
			throw new Exception();
		}	
		int r= row-1;
		int c= col+1;
		if(matrix[r][c]== null){
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=b;
		}else {
			pieces piece= matrix[r][c];
			if(piece.getColor().equals(b.getColor())){
				throw new Exception();	
			}		
		}
	}
	public void moveDownLeft(pieces [][] matrix, Bishop b) throws Exception {
		if(row+1>=matrix.length) {
			throw new Exception();
		}
		if(col-1<0) {
			throw new Exception();
		}	
		int r= row+1;
		int c= col-1;
		if(matrix[r][c]== null){
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=b;
		}else {
			pieces piece= matrix[r][c];
			if(piece.getColor().equals(b.getColor())){
				throw new Exception();	
			}		
		}
	}
	public void moveDownRight(pieces [][] matrix, Bishop b) throws Exception {
		if(row+1>=matrix.length) {
			throw new Exception();
		}
		if(col+1>=matrix[0].length) {
			throw new Exception();
		}	
		int r= row+1;
		int c= col+1;
		if(matrix[r][c]== null){
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=b;
		}else {
			pieces piece= matrix[r][c];
			if(piece.getColor().equals(b.getColor())){
				throw new Exception();	
			}		
		}

	}
}


class Rook implements pieces{
	int row;
	int col ;
	String color ;
	public Rook(int r, int c,String color) {
		row=r;
		col=c;
		this.color= color;
	}

	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Rook";
	}
	
	public void moveUp(pieces [][] matrix, Rook ro) throws Exception {
		if(row-1<0) {
			throw new Exception();
		}
		int r= row-1;
		int c=col;
		if(matrix[r][c]== null){
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=ro;
		}else {
			pieces piece= matrix[r][c];
			if(piece.getColor().equals(ro.getColor())){
				throw new Exception();	
			}		
		}


	}
	public void moveDown(pieces [][] matrix, Rook ro) throws Exception {
		if(row+1>=matrix.length) {
			throw new Exception();
		}
		
		int r= row+1;
		int c= col;
		if(matrix[r][c]== null){
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=ro;
		}else {
			pieces piece= matrix[r][c];
			if(piece.getColor().equals(ro.getColor())){
				throw new Exception();	
			}		
		}


	}
	public void moveLeft(pieces [][] matrix, Rook ro) throws Exception {
		if(col-1<0) {
			throw new Exception();
		}
		int r= row;
		int c= col-1;
		if(matrix[r][c]== null){
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=ro;
		}else {
			pieces piece= matrix[r][c];
			if(piece.getColor().equals(ro.getColor())){
				throw new Exception();	
			}		
		}

	}
	public void moveRight(pieces [][] matrix, Rook ro) throws Exception {
		if(col+1>=matrix.length) {
			throw new Exception();
		}
		int r= row;
		int c= col+1;
		if(matrix[r][c]== null){
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=ro;
		}else {
			pieces piece= matrix[r][c];
			if(piece.getColor().equals(ro.getColor())){
				throw new Exception();	
			}		
		}	
	}
		
}


class Queen implements pieces{
	int row;
	int col ;
	String color ;
	public Queen(int r, int c,String color) {
		row=r;
		col=c;
		this.color= color;
	}

	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Queen";
	}
	
	public void moveUp(pieces [][] matrix, Queen q) throws Exception {
		if(row-1<0) {
			throw new Exception();
		}
		int r= row-1;
		int c= col;
		if(matrix[r][c]== null){
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=q;
		}else {
			pieces piece= matrix[r][c];
			if(piece.getColor().equals(q.getColor())){
				throw new Exception();	
			}		
		}
	}
	public void moveDown(pieces [][] matrix, Queen q) throws Exception {
		if(row+1>=matrix.length) {
			throw new Exception();
		}
		int r= row+1;
		int c= col;
		if(matrix[r][c]== null){
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=q;
		}else {
			pieces piece= matrix[r][c];
			if(piece.getColor().equals(q.getColor())){
				throw new Exception();	
			}		
		}
	}
	public void moveLeft(pieces [][] matrix, Queen q) throws Exception {
		if(col-1<0) {
			throw new Exception();
		}
		int r= row;
		int c= col-1;
		if(matrix[r][c]== null){
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=q;
		}else {
			pieces piece= matrix[r][c];
			if(piece.getColor().equals(q.getColor())){
				throw new Exception();	
			}		
		}
	}
	public void moveRight(pieces [][] matrix, Queen q) throws Exception {
		if(col+1>=matrix.length) {
			throw new Exception();
		}
		int r= row;
		int c= col+1;
		if(matrix[r][c]== null){
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=q;
		}else {
			pieces piece= matrix[r][c];
			if(piece.getColor().equals(q.getColor())){
				throw new Exception();	
			}		
		}
	}
	
	public void moveUpLeft(pieces [][] matrix, Queen q) throws Exception {
		if(row-1<0) {
			throw new Exception();
		}
		if(col-1<0) {
			throw new Exception();
		}	
		int r= row-1;
		int c= col-1;
		if(matrix[r][c]== null){
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=q;
		}else {
			pieces piece= matrix[r][c];
			if(piece.getColor().equals(q.getColor())){
				throw new Exception();	
			}		
		}
	}
	public void moveUpRight(pieces [][] matrix, Queen q) throws Exception {
		if(row-1<0) {
			throw new Exception();
		}
		if(col+1>=matrix[0].length) {
			throw new Exception();
		}	
		int r= row-1;
		int c= col+1;
		if(matrix[r][c]== null){
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=q;
		}else {
			pieces piece= matrix[r][c];
			if(piece.getColor().equals(q.getColor())){
				throw new Exception();	
			}		
		}
	}
	public void moveDownLeft(pieces [][] matrix, Queen q) throws Exception {
		if(row+1>=matrix.length) {
			throw new Exception();
		}
		if(col-1<0) {
			throw new Exception();
		}	
		int r= row+1;
		int c= col-1;
		if(matrix[r][c]== null){
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=q;
		}else {
			pieces piece= matrix[r][c];
			if(piece.getColor().equals(q.getColor())){
				throw new Exception();	
			}		
		}
	}
	public void moveDownRight(pieces [][] matrix, Queen q) throws Exception {
		if(row+1>=matrix.length) {
			throw new Exception();
		}
		if(col+1>=matrix[0].length) {
			throw new Exception();
		}	
		int r= row+1;
		int c= col+1;
		if(matrix[r][c]== null){
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=q;
		}else {
			pieces piece= matrix[r][c];
			if(piece.getColor().equals(q.getColor())){
				throw new Exception();	
			}		
			matrix[row][col]=null;
			row=r;
			col=c;
			matrix[row][col]=q;
		}
	}
	
}


public class SimpleChessEngine {

	public static void main(String[] args) throws Exception {
		
		pieces [][] matrix = new pieces[5][5];
		Queen q = new Queen(2,2, "black");
		matrix[2][2]= q;
		System.out.println("----------------------------------------");
		for(int i =0;i<5;i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		System.out.println("----------------------------------------");
		q.moveDownRight(matrix, q);
		for(int i =0;i<5;i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		System.out.println("----------------------------------------");
		
		
	}

}
