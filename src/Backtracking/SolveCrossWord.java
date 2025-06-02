//A  10X 10Crossword grid is provided to you, along with a set of words (or names of places) which need to be filled into the grid. Cells are marked either + or -. Cells marked with a - are to be filled with the word list.
//
//The following shows an example crossword from the input  grid and the list of words to fit, :
//
//Input 	   		Output
//
//++++++++++ 		++++++++++
//+------+++ 		+POLAND+++
//+++-++++++ 		+++H++++++
//+++-++++++ 		+++A++++++
//+++-----++ 		+++SPAIN++
//+++-++-+++ 		+++A++N+++
//++++++-+++ 		++++++D+++
//++++++-+++ 		++++++I+++
//++++++-+++ 		++++++A+++
//++++++++++ 		++++++++++
//POLAND;LHASA;SPAIN;INDIA
//Function Description
//
//Complete the crosswordPuzzle function in the editor below. It should return an array of strings, each representing a row of the finished puzzle.
//
//crosswordPuzzle has the following parameter(s):
//
//crossword: an array of  strings of length  representing the empty grid
//words: a string consisting of semicolon delimited strings to fit into 
//Input Format
//
//Each of the first  lines represents , each of which has  characters, .
//
//The last line contains a string consisting of semicolon delimited  to fit.
//
//Constraints
//
//
//
//
//Output Format
//
//Position the words appropriately in the  grid, then return your array of strings for printing.
//
//Sample Input 0
//
//+-++++++++
//+-++++++++
//+-++++++++
//+-----++++
//+-+++-++++
//+-+++-++++
//+++++-++++
//++------++
//+++++-++++
//+++++-++++
//LONDON;DELHI;ICELAND;ANKARA
//Sample Output 0
//
//+L++++++++
//+O++++++++
//+N++++++++
//+DELHI++++
//+O+++C++++
//+N+++E++++
//+++++L++++
//++ANKARA++
//+++++N++++
//+++++D++++
//Sample Input 1
//
//+-++++++++
//+-++++++++
//+-------++
//+-++++++++
//+-++++++++
//+------+++
//+-+++-++++
//+++++-++++
//+++++-++++
//++++++++++
//AGRA;NORWAY;ENGLAND;GWALIOR
//Sample Output 1
//
//+E++++++++
//+N++++++++
//+GWALIOR++
//+L++++++++
//+A++++++++
//+NORWAY+++
//+D+++G++++
//+++++R++++
//+++++A++++
//++++++++++
//Sample Input 2
//
//++++++-+++
//++------++
//++++++-+++
//++++++-+++
//+++------+
//++++++-+-+
//++++++-+-+
//++++++++-+
//++++++++-+
//++++++++-+
//ICELAND;MEXICO;PANAMA;ALMATY
//Sample Output 2
//
//++++++I+++
//++MEXICO++
//++++++E+++
//++++++L+++
//+++PANAMA+
//++++++N+L+
//++++++D+M+
//++++++++A+
//++++++++T+
//++++++++Y+


package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveCrossWord {
	
//	approch:
//	we will use recursive back tracking 
//	first we have a helper function which take input of question and final result output list res
//	now we itearte in entire board where we skip all the character which are +  or any alphabetic character
//	so when ever a blank space is comes like '-'
//	we check all directions of that 
//	up,down , left, right
//	once done we will find all possible words that can come in its place in side the wordlist/
//	now we will fill the words and remove the word from word list and send it to next recusion call
//	---------------------------------------------
//	important note : 
//	we will check either row first or column first and make a recusion call 
//	then after we will check col because if the row fill that blank in some way it will not be updated 
//	for our col check if we check all direction at once
//	so always check row first and make a recusion call or check col first then make a recursion call
//	then check the rest of ddirections 
//	---------------------------------------------
//	Worst-case Time: O((W·L)^W) (exponential)
//	Space Complexity: O(W·L)


    public static List<String> crosswordPuzzle(List<String> crossword, String words) {
    	List<String> wordList= new ArrayList(Arrays.asList(words.split(";")));
    	List<String>  res= new ArrayList<String>();
    	helper(crossword,wordList,res);
    	return res;
    }
    
    public static boolean helper(List<String> board, List<String> wordList,List<String> res) {
    	if(wordList.size()==0) {
    		res.addAll(board);
    		return true;// this will return true to prune all the next calls 
    	}
//    	get every row
    	for(int i =0;i<10;i++) {
    		String  strRow = board.get(i);
//    		get every character
    		for(int j =0;j<10;j++) {
    			char ch = strRow.charAt(j);
//    			this will pass this line only when the blank space is there
    			if(ch=='+' || (ch>='A' && ch <='Z')) {
    				continue;
    			}
//    			check left side / right side
    			String leftside =lookLeft(board, i, j-1);
    			String rightside =lookRight(board, i, j);
    			String row= leftside+rightside;// entire row word
//    			get all possible stirngs to put there
    			List<String> possibleWordRow = possible(wordList, row);
//    			get deleted words to back track
    			List<String> deleteWord = new ArrayList<String>();
//    			fill the words:
    			List<String> temp = new ArrayList<String>(board);
    			for(String word: possibleWordRow ) {
    				int r=i;
    				int c= j-leftside.length();
    				fillRow(board, word, r,c);
    				deleteWord.add(word);
    				wordList.remove(word);
//    				recursive call for row 
    				if(helper(board, wordList, res)) return true;
    			}
//    			get up / down side of words
    			String upside =lookUp(board, i-1, j);    			
    			String downside =lookDown(board, i, j);
    			String col = upside+downside;// entire word blanks
    			List<String> possibleWordCol = possible(wordList, col);// possible col words from list
//    			fill words at col
    			for(String word: possibleWordCol) {
    				int r=i-upside.length();
    				int c= j;
    				fillCol(board, word, r,c);
    				deleteWord.add(word);
    				wordList.remove(word);
//    				recursive call for col
    				if(helper(board, wordList, res)) return true;
    			}
//    			this will backtrack if the both possible words are missing
//    			means therea re no valid words to put in blanks means
//    			we have to remove some words 
    			if(possibleWordCol.size()==0 && possibleWordRow.size()==0) {
    				return false;
    			}
    			// back track
    			board=temp;
    			wordList.addAll(deleteWord);
    		}
    	}
    	return false;
    }
    
    
//    check left side of the row
    public static String lookLeft(List<String> board, int r, int c) {
    	StringBuilder  leftside = new StringBuilder();
    	String row= board.get(r);
    	for(int i = c;i>=0;i--) {
    		char ch = row.charAt(i);
    		if(ch=='+') {
    			break;
    		}
    		leftside.append(ch);
    	}
    	return leftside.reverse().toString();
    }
//    check right side of the row
    public static String lookRight(List<String> board, int r, int c) {
    	StringBuilder  rightside = new StringBuilder();
    	String row= board.get(r);
    	for(int i = c;i<row.length();i++) {
    		char ch = row.charAt(i);
    		if(ch=='+') {
    			break;
    		}
    		rightside.append(ch);
    	}
    	return rightside.toString();
    }
//    check up side of the col
    public static String lookUp(List<String> board, int r, int c) {
    	StringBuilder  upside= new StringBuilder();
    	for(int i=r;i>=0;i--) {
    		String str = board.get(i);
    		char ch = str.charAt(c);
    		if(ch=='+') {
    			break;
    		}
    		upside.append(ch);
    	}
    	return upside.reverse().toString();
    }
//    check down side of the col
    public static String lookDown(List<String> board, int r, int c) {
    	StringBuilder downside= new StringBuilder();
    	for(int i=r;i<10;i++) {
    		String str = board.get(i);
    		char ch = str.charAt(c);
    		if(ch=='+') {
    			break;
    		}
    		downside.append(ch);
    	}
    	return downside.toString();
    }
    
    public static boolean isCharacter(char ch) {
    	return ch>='A' && ch<='Z';
    }
    
//    find the possible string we can put in the blank spaces 
    public static List<String> possible(List<String> words, String str){
    	List<String> possiblewords = new ArrayList<String>();
    	for(String word : words) {
    		if(word.length()==str.length()) {
    			boolean possible=true;
    			for(int i =0;i<str.length();i++) {
    				if(str.charAt(i)=='-') {
    					continue;
    				}
    				if(str.charAt(i)!=word.charAt(i)) {
    					possible=false;
    					break;
    				}
    			}
    			if(possible) {
    				possiblewords.add(word);
    			}
    		}
    		
    	}
    	return possiblewords;
    }
    
//    fill board row wise
    public static void fillRow(List<String> board, String word, int row, int col) {
    	String strRow = board.get(row);
    	char[] charrow = strRow.toCharArray();
    	int idx =0;
    	for(int i = col;idx<word.length();i++) {
    		charrow[i]=word.charAt(idx);
    		idx++;
    	}
    	board.set(row, new String (charrow));
    }
//    fill board col wise
    public static void fillCol(List<String> board, String word, int row, int col) {
    	int idx =0;
    	for(int i = row;idx<word.length();i++) {
    		String rowStr = board.get(i);
    		char [] chararr= rowStr.toCharArray();
    		char ch = word.charAt(idx);
    		chararr[col]=ch;
    		board.set(i,new String(chararr));
    		idx++;
    	}
    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		Example 1:
		
		
		List<String> crossword1 = new ArrayList(Arrays.asList(
													"+-++++++++",
													"+-++++++++",
													"+-++++++++",
													"+-----++++",
													"+-+++-++++",
													"+-+++-++++",
													"+++++-++++",
													"++------++",
													"+++++-++++",
													"+++++-++++"));
		String words1="LONDON;DELHI;ICELAND;ANKARA";
		
		List<String> output1= new ArrayList(Arrays.asList(
													"+L++++++++",
													"+O++++++++",
													"+N++++++++",
													"+DELHI++++",
													"+O+++C++++",
													"+N+++E++++",
													"+++++L++++",
													"++ANKARA++",
													"+++++N++++",
													"+++++D++++"));
		
		
		List<String> crossword2 = new ArrayList(Arrays.asList(
				"+-++++++++",
				"+-++++++++",
				"+-------++",
				"+-++++++++",
				"+-++++++++",
				"+------+++",
				"+-+++-++++",
				"+++++-++++",
				"+++++-++++",
				"++++++++++"));
		String words2="AGRA;NORWAY;ENGLAND;GWALIOR";
		
		
		List<String> output2= new ArrayList(Arrays.asList(
				"+E++++++++",
				"+N++++++++",
				"+GWALIOR++",
				"+L++++++++",
				"+A++++++++",
				"+NORWAY+++",
				"+D+++G++++",
				"+++++R++++",
				"+++++A++++",
				"++++++++++"));

		
		List<String> crossword3 = new ArrayList(Arrays.asList(
				
				"+-++++++++",
				"+-++-+++++",
				"+-------++",
				"+-++-+++++",
				"+-++-+++++",
				"+-++-+++++",
				"++++-+++++",
				"++++-+++++",
				"++++++++++",
				"----------"		
				));
		String words3="CALIFORNIA;NIGERIA;CANADA;TELAVIV";
		List<String> output3= new ArrayList(Arrays.asList(
				"+C++++++++",
				"+A++T+++++",
				"+NIGERIA++",
				"+A++L+++++",
				"+D++A+++++",
				"+A++V+++++",
				"++++I+++++",
				"++++V+++++",
				"++++++++++",
				"CALIFORNIA"));
	
		
		List<String> ans1 = crosswordPuzzle(crossword1, words1);
		List<String> ans2 = crosswordPuzzle(crossword2, words2);
		List<String> ans3 = crosswordPuzzle(crossword3, words3);
		
		
		if(output1.equals(ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2.equals(ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(output3.equals(ans3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}


		
		

	}

}
