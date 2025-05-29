//1079. Letter Tile Possibilities
//Medium
//Topics
//Companies
//Hint
//You have n  tiles, where each tile has one letter tiles[i] printed on it.
//
//Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.
//
// 
//
//Example 1:
//
//Input: tiles = "AAB"
//Output: 8
//Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
//Example 2:
//
//Input: tiles = "AAABBC"
//Output: 188
//Example 3:
//
//Input: tiles = "V"
//Output: 1
// 
//
//Constraints:
//
//1 <= tiles.length <= 7
//tiles consists of uppercase English letters.


package Recursion;

import java.util.HashSet;
import java.util.List;
public class LetterTilePossibilities_1079 {

//	brute force :
//	using recusion and back tracking we can solve this question
//	where we use process and unprocess technique where we take a process string as inital empty
//	and use unprocess character from 0 till end
//	and keep trying them and adding in a hashset at last we will get a hashset of all unqiue combination
//	we can return result;
//	Time complexity: O(n × n!)
//	Space complexity: O(n × n!)

    public static int numTilePossibilitiesBruteForce(String tiles) {
    	
    	HashSet<String > res= new HashSet<String>();
    	helperBruteForce("",tiles,res);
    	return res.size();

    }
    
    public static void helperBruteForce(String p, String unp,HashSet<String> res) {
    	if(unp.isBlank()) {
    		res.add(p);
    		return ;
    	}
    	for(int i =0;i<unp.length();i++) {
    	
    		char ch = unp.charAt(i);
    		String process= p+ch;
    		String start= unp.substring(0,i);
    		String end = unp.substring(i+1,unp.length());
    		String unprocess=start+end;
    		res.add(process);
    		helperBruteForce(process, unprocess, res);		
    	}  	
    }

//	Better approch :
//  the approch is same we can use hashset to skip already computed result from hashset
//	we can return result;
//	Time complexity: O(n × n!)
//	Space complexity: O(n × n!)
    
    public static int numTilePossibilitiesBetter(String tiles) {
    	
    	HashSet<String > res= new HashSet<String>();
    	helperBetter("",tiles,res);
    	return res.size();
    	
    }
    
    public static void helperBetter(String p, String unp,HashSet<String> res) {
    	if(unp.isBlank()) {
    		res.add(p);
    		return ;
    	}
    	for(int i =0;i<unp.length();i++) {
    		
    		char ch = unp.charAt(i);
    		String process= p+ch;
    		String start= unp.substring(0,i);
    		String end = unp.substring(i+1,unp.length());
    		String unprocess=start+end;
    		res.add(process);
    		helperBetter(process, unprocess, res);		
    	}  	
    }
    
//	Best approch :
//  instead of storing every single string
//  we can use a frequency map and apply back tracking over that 
//  this will allow us to get all the possible unique combination of strings 
//	Time complexity: O(n × n!)
//	Space complexity: O(1)
    
    public static int numTilePossibilitiesBest(String tiles) {
    	int [] charmap = new int [26];
    	for(int i =0;i<tiles.length();i++) {
    		char ch = tiles.charAt(i);
    		charmap[ch-'A']++;
    	}
    	
    	return helperBest(charmap);

    	
    }
    
    public static int helperBest(int [] map) {
    	int res=0;
    	for(int i =0;i<map.length;i++) {// this will act as a base case if charmap is empty result will be 0
    		if(map[i]>0) {
    			res+=1;
    			map[i]--;
    			res+=helperBest(map);
    			map[i]++;
    		}
    	}
    	return res;
    }


    public static void main(String[] args) {
    	
//    	Example 1 :
    	
    	String s1= "AAB";
    	int output1=8;
    	
//    	Example 2 :
    	
    	String s2= "AAABBC";
    	int output2=188;
    	
//    	Example 3 :
    	
    	String s3= "V";
    	int output3=1;
    	
    	System.out.println("Brute Force Approch ");
    	
		int ans1= numTilePossibilitiesBruteForce(s1);
		int ans2= numTilePossibilitiesBruteForce(s2);
		int ans3= numTilePossibilitiesBruteForce(s3);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ output2);
			System.out.println("Your Answer :"+ ans2);
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ output3);
			System.out.println("Your Answer :"+ ans3);
		}
		System.out.println("Better Approch ");
		
		ans1= numTilePossibilitiesBetter(s1);
		ans2= numTilePossibilitiesBetter(s2);
		ans3= numTilePossibilitiesBetter(s3);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ output2);
			System.out.println("Your Answer :"+ ans2);
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ output3);
			System.out.println("Your Answer :"+ ans3);
		}
		
		System.out.println("Best Approch ");
		
		ans1= numTilePossibilitiesBest(s1);
		ans2= numTilePossibilitiesBest(s2);
		ans3= numTilePossibilitiesBest(s3);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ output2);
			System.out.println("Your Answer :"+ ans2);
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ output3);
			System.out.println("Your Answer :"+ ans3);
		}

    }
}

