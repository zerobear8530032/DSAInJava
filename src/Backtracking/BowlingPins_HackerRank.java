//Bowling is a sport in which a player rolls a bowling ball towards a group of pins, the target being to knock down the pins at the end of a lane.
//
//In this challenge, the rules of the game are slightly modified. Now, there are a given number of pins, and the pins are arranged in a horizontal line instead of a triangular formation. Two players have to play this game, taking alternate turns. Whoever knocks down the last pin(s) will be declared the winner.
//
//You are playing this game with your friend, and both of you have become proficient at it. You can knock down any single pin, or any two adjacent pins at one throw of a bowling ball, however, these are the only moves that you can perform. Some moves have already been played. Suddenly, you realize that it is possible to determine whether this game can be won or not, assuming optimal play. And luckily it's your turn right now.
//
//A configuration is represented by a string consisting of the letters X and I, where:
//
//I represents a position containing a pin.
//X represents a position where a pin has been knocked down.
//An example of such a configuration is shown in the image below. Here, the number of pins is , and the  pin has already been knocked down.
//
//Pins
//
//Its representation will be IXIIIIIIIIIII.
//
//Complete the function isWinning that takes the number of pins and the configuration of the pins as input, and return WIN or LOSE based on whether or not you will win.
//
//Given the current configuration of the pins, if both of you play optimally, determine whether you will win this game or not.
//
//Note
//
//A player has to knock down at least one pin in his turn.
//Both players play optimally.
//Input Format
//
//The first line contains an integer, , the number of test cases. Then  test cases follow.
//
//For each test case, the first line contains a single integer , denoting the number of pins. The second line contains a string of  letters, where each letter is either I or X.
//
//Constraints
//
//Each letter of the string (representing the configuration) is either I or X.
//There will be at least one I in the string.
//Output Format
//
//For each test case, print a single line containing WIN if you will win this game, otherwise LOSE.
//
//Sample Input 0
//
//4
//4
//IXXI
//4
//XIIX
//5
//IIXII
//5
//IIIII
//Sample Output 0
//
//LOSE
//WIN
//LOSE
//WIN
//Explanation 0
//
//Test Case 1: As the  pins are not adjacent, they can't be knocked down in a single turn. Therefore, you can only knock down one of the two pins. Then, in the next turn, your friend will knock down the last pin.
//
//Test Case 2: You can knock down both pins in a single turn.
//
//Test Case 3: You can knock down one or two pins from either side. Your friend can just copy your move on the other side and will be able to get the last move, hence win the game.
//
//Test Case 4: You can knock the middle pin, thus resulting in the configuration IIXII for your friend. Now, this configuration is the same as the previous test case. The difference is that now it is your friend's turn and you can copy his shot on the other side.


package Backtracking;

import java.util.ArrayList;
import java.util.List;

// approch simulate min max algorith 
//  time complexity O(2^n)
//  space complexity O(2^n)
class Move{
	 List<Integer> move;
	 int score;
	public List<Integer> getMove() {
		return move;
	}
	public void setMove(List<Integer> move) {
		this.move = move;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Move(List<Integer> move, int score) {
		this.move = move;
		this.score = score;
	}
	 
	 
	 
}

public class BowlingPins_HackerRank {
	
	
	  public static String isWinning(int n, String config) {
		  char pins []= config.toCharArray();
		  boolean isMax=true;
		  while(!isWon(pins)) {
			  if(isMax) {
				  Move getBestMove= minMax(pins, isMax);
				  playMove(pins, getBestMove.getMove());
			  }else {
				  Move getBestMove= minMax(pins, isMax);
				  playMove(pins, getBestMove.getMove());
			  }
			isMax=!isMax;  
		  }
		  if(isMax) {
			  return "LOSE";
		  }else {
			  return "WIN";
		  }
	  }
	  
	  public static void playMove(char [] arr , List<Integer> move) {
		  for(int i =0;i<move.size();i++) {
			  arr[move.get(i)]='X';
		  }
	  }
	  public static void undoMove(char [] arr , List<Integer> move) {
		  for(int i =0;i<move.size();i++) {
			  arr[move.get(i)]='I';
		  }
	  }
	  
	  
	  
	  
	  public static boolean isWon(char [] arr) {
		  for(char ch : arr) {
			  if(ch=='I') return false;
		  }
		  return true;
	  }
	  
	  public static Move minMax(char [] arr, boolean isMaximizing) {
		  if(isWon(arr)) {
			  int score=0;
			  if(isMaximizing) {
				  score = -10;
			  }else {
				  score = +10;				  
			  }
			  return new Move(null,score);
		  }
		  if(isMaximizing) {
			  int bestscore = Integer.MIN_VALUE;
			  List<Integer> bestmove=null;
			  List<List<Integer>> moves = generateAllMoves(arr);
			  for(List<Integer> move : moves) {
//				  make a move :
				  playMove(arr, move);
				  Move curmove=minMax(arr, false);
				  undoMove(arr, move);
				  if(curmove.getScore()>bestscore) {
					  bestscore=curmove.getScore();
					  bestmove=move;
				  }				  
			  }
			  return new Move(bestmove,bestscore);
		  }
		  
		  else{
			  int bestscore = Integer.MAX_VALUE;
			  List<Integer> bestmove=null;
			  List<List<Integer>> moves = generateAllMoves(arr);
			  for(List<Integer> move : moves) {
//				  make a move :
				  playMove(arr, move);
				  Move curmove=minMax(arr, true);
				  undoMove(arr, move);
				  if(curmove.getScore()<bestscore) {
					  bestscore=curmove.getScore();
					  bestmove=move;
				  }				  
			  }
			  return new Move(bestmove,bestscore);
		  }
		  
		  
		  
		  
	  }
	  
	
	
	
	public static List<List<Integer>> generateAllMoves(char [] pins) {
		List<List<Integer>> moves = new ArrayList<List<Integer>>();
		for(int i =0;i<pins.length;i++) {
			if(pins[i]=='X') {
				continue;
			}
			if(pins[i]=='I') {
				List<Integer> move = new ArrayList();
				move.add(i);
				moves.add(move);
			}
			if(i+1<pins.length && (pins[i]=='I' && pins[i+1]=='I')) {
				List<Integer> move = new ArrayList();
				move.add(i);
				move.add(i+1);
				moves.add(move);
			}
		}
		return moves;
	}

	public static void main(String[] args) {
		
		
//		Example 1 :
		int pins1=4;
		String config1= "IXXI";
		
//		Example 2 :
		
		int pins2=4;
		String config2= "XIIX";
		
//		Example 3 :
		
		int pins3=5;
		String config3= "IIXII";

//		Example 4 :
		
		int pins4=5;
		String config4= "IIIII";
		
		
		System.out.println(isWinning(pins1, config1));
		System.out.println(isWinning(pins2, config2));
		System.out.println(isWinning(pins3, config3));
		System.out.println(isWinning(pins4, config4));
			
		
	}

}
