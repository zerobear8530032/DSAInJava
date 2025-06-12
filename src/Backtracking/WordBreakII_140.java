//140. Word Break II
//Solved
//Hard
//Topics
//premium lock icon
//Companies
//Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.
//
//Note that the same word in the dictionary may be reused multiple times in the segmentation.
//
// 
//
//Example 1:
//
//Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
//Output: ["cats and dog","cat sand dog"]
//Example 2:
//
//Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
//Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
//Explanation: Note that you are allowed to reuse a dictionary word.
//Example 3:
//
//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: []
// 
//
//Constraints:
//
//1 <= s.length <= 20
//1 <= wordDict.length <= 1000
//1 <= wordDict[i].length <= 10
//s and wordDict[i] consist of only lowercase English letters.
//All the strings of wordDict are unique.
//Input is generated in a way that the length of the answer doesn't exceed 105.
//
//
package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class WordBreakII_140 {

// approch:
//	we can  use recusrive back tracking with process, unprocess method where at we first go from left to right in the string
//	and taking each character one  by 1
//	creating a word if the word exists in out dict (set) then we 
//	will call the recusive function where we add the word and a blank space at unprocess
//	and from current idx + 1 till end of s will be send to next call
//	this will create ans in unprocess when the process is blank or finish if the process get blank and the current word not found we
//	can just let it iterate to skip all uncessasry words
    public static List<String> wordBreak(String s, List<String> wordDict) {
	       HashSet<String> dict= new HashSet(wordDict);
	       List<String> res= new ArrayList();
	       helper(s,"",dict,res) ;
	       return res;
	    }
	    public static void helper(String s ,String unp,  HashSet<String> dict, List<String> res){
	        if(s.isBlank() || s.isEmpty()){
	            res.add(unp.strip());
	            return ;
	        }
	        StringBuilder word = new StringBuilder();
	        for(int i=0;i<s.length();i++){
	            char ch = s.charAt(i);
	            word.append(ch);
	            if(dict.contains(word.toString())){
	                StringBuilder unprocess= new StringBuilder();
	                unprocess.append(unp);
	                unprocess.append(word);
	                unprocess.append(" ");
	                helper(s.substring(i+1),unprocess.toString(),dict,res);
	            }
	        }
	    }
	    
	    public static boolean check(List<String> res, List<String> output) {
	    	if(output.size()!=res.size()) {
	    		return false;
	    	}
	    	Collections.sort(output);
	    	Collections.sort(res);
	    	for(int i =0;i<output.size();i++) {
	    		if(!res.get(i).equals(output.get(i))) {
	    			return false;
	    		}
	    	}
	    	
	    	
	    	return true;
	    }
	
	public static void main(String[] args) {
		
		
		//Example 1:

		String  s1 = "catsanddog";
		List<String> wordDict1 = new ArrayList(Arrays.asList("cat","cats","and","sand","dog"));
		List<String> output1 = new ArrayList(Arrays.asList("cats and dog","cat sand dog"));

		//Example 2:

		String  s2 = "pineapplepenapple";
		List<String> wordDict2 = new ArrayList(Arrays.asList("apple","pen","applepen","pine","pineapple"));
		List<String> output2 = new ArrayList(Arrays.asList("pine apple pen apple","pineapple pen apple","pine applepen apple"));

		//Example 3:
		
		String  s3 = "catsandog";
		List<String> wordDict3 = new ArrayList(Arrays.asList("cats","dog","sand","and","cat"));
		List<String> output3 = new ArrayList();

		
		List<String> ans1 = wordBreak(s1, wordDict1);
		List<String> ans2 = wordBreak(s2, wordDict2);
		List<String> ans3 = wordBreak(s3, wordDict3);
		
		

    	if(check(output1,ans1)) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Ouput :"+ output1);
    		System.out.println("Your Answer :"+ ans1);  		
    	}
    	
    	if(check(output2,ans2)) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Ouput :"+ output2);
    		System.out.println("Your Answer :"+ ans2);  		
    	}
    	if(check(output3,ans3)) {
    		System.out.println("Case 3 Passed");
    	}else {
    		System.out.println("Case 3 Failed");
    		System.out.println("Expected Ouput :"+ output3);
    		System.out.println("Your Answer :"+ ans3);  		
    	}

	}

}
