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
	

	public static List<String> res;
    public static List<String> crosswordPuzzle(List<String> crossword, String words) {

        List<String> wordslist = new ArrayList(Arrays.asList(words.split(";")));
        res= new ArrayList();
        helper(crossword, 0, 0, wordslist);
        return res;
    }
    public static void helper(List<String> board, int r, int c, List<String> words){
    	if(words.size()==0) {
    		res= new ArrayList(board);
    		return ;
    	}
    	for(int i =r;i<10;i++) {
    		for(int j =c;j<10;j++) {
    			String str= board.get(i);
    			char ch = str.charAt(j);
    			if(ch=='+'|| (ch>='A' && ch<='Z')) 
    			{continue;}
    			String rowStrRight=lookRowRight(board, i, j);
    			String colStrDown=lookColDown(board, i, j);
    			
    			String rowStrLeft=lookRowLeft(board, i, j);
    			String colStrUp=lookColUp(board, i, j);
    			
    			String colStr = colStrUp+colStrDown;
    			String rowStr = rowStrLeft+rowStrRight;
    			List<String> tempboard = new ArrayList(board);
    			List<String>possibleRow=getSimilarString(rowStr, words);
    			List<String>possibleCol=getSimilarString(colStr, words);
//    			try all row strings:
    			List<String> removedWords= new ArrayList();
    			for(String  strrow:possibleRow) {
    				int n = rowStrLeft.length();
    				fillRows(board,i,j-n,strrow);
    				removedWords.add(strrow);
    				words.remove(strrow);
    				helper(board, i, j, words);
    			}
    			for(String  strcol:possibleCol) {
    				int n = colStrUp.length();
    				fillCols(board,i-n,j,strcol);
    				removedWords.add(strcol);
    				words.remove(strcol);
    				helper(board, i, j, words);
    			}
    			board=tempboard;
    			words.addAll(removedWords);
    		}
    	}

    }
    
    public static void fillRows(List<String> board, int row,int col, String str){
    	String initalrow = board.get(row);
    	char [] chararr= initalrow.toCharArray();
    	int idx=0;
    	for(int i=col;i<col+str.length();i++) {
    		chararr[i]=str.charAt(idx);
    		idx++;
    	}
    	board.set(row, new String(chararr));
    }
    
    public static void fillCols(List<String> board, int row,int col, String str){
    	int idx =0;
    	for(int i =row;i<row+str.length();i++) {
    		String initalrow = board.get(i);
    		char [] chararr= initalrow.toCharArray();
    		chararr[col]=str.charAt(idx);
    		board.set(i, new String(chararr));
    		idx++;
    	}
    }
    
    public static List<String> getSimilarString(String str,List<String> arr){        
        List<String> res= new ArrayList();
        for(String s: arr){
                if(s.length()==str.length()){
                        boolean accept = true;
                        for(int i =0;i<s.length();i++){
                                if(str.charAt(i)==' ' || str.charAt(i)=='-'){
                                        continue;
                                }
                                if(str.charAt(i)!=s.charAt(i)){
                                        accept=false;
                                        break;
                                }
                        }
                        if(accept){
                                res.add(s);
                        }                      
                }
        }
        return res;
    }
    
    
    public static String lookColDown(List<String> board, int r,int c){
        if( r<0  ||  r>=10 ||c<0  ||  c>=10){
                return "";
        }        
        StringBuilder str= new StringBuilder();
        int idx=r;
        while(idx<10 && board.get(idx).charAt(c)!='+'){
        		String string = board.get(idx);
                char ch = string.charAt(c);
                if(ch>='A' && ch<='Z'){
                        str.append(ch);
                }else{
                        str.append(" ");
                }
                idx++;
        } 
        return str.toString();
    }
    public static String lookRowLeft(List<String> board, int r, int c){
        if( c<0 ||  c>=10 ||r<0   || r>=10 ){
                return "";
        }        
        StringBuilder str= new StringBuilder();
        int idx=c;
        	String row = board.get(r);
        	for(int i=idx;i>0;i--) {
        		char ch = row.charAt(i-1);
        		if(ch=='+') {
        			break;
        		}
        		str.insert(0, ch);
        	}
        return str.toString();
    }
    public static String lookColUp(List<String> board, int r,int c){
    	if( r<0  ||  r>=10 ||c<0  ||  c>=10){
    		return "";
    	}        
    	StringBuilder str= new StringBuilder();
    	int idx=r;
    	for(int i=r;i>0;i--) {
    		String row = board.get(i-1);
    		char ch = row.charAt(c);
    		if(ch=='+') {
    			break;
    		}
    		str.insert(0, ch);
    	}
    	return str.toString();
    }
    public static String lookRowRight(List<String> board, int r, int c){
    	if( c<0 ||  c>=10 ||r<0   || r>=10 ){
    		return "";
    	}        
    	StringBuilder str= new StringBuilder();
    	int idx=c;
    	while(idx<10 && board.get(r).charAt(idx)!='+'){
    		String string= board.get(r); 
    		char ch = string.charAt(idx);
    		if(ch>='A' && ch<='Z'){
    			str.append(ch);
    		}else{
    			str.append(" ");
    		}
    		idx++;
    	} 
    	return str.toString();
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		Example 1:
		
		
		List<String> crossword = new ArrayList(Arrays.asList(
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
		
		System.out.println(crosswordPuzzle(crossword, words1));

	}

}
