//472. Concatenated Words
//Hard
//Topics
//premium lock icon
//Companies
//Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.
//
//A concatenated word is defined as a string that is comprised entirely of at least two shorter words (not necessarily distinct) in the given array.
//
// 
//
//Example 1:
//
//Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
//Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
//Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
//"dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
//"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
//Example 2:
//
//Input: words = ["cat","dog","catdog"]
//Output: ["catdog"]
// 
//
//Constraints:
//
//1 <= words.length <= 104
//1 <= words[i].length <= 30
//words[i] consists of only lowercase English letters.
//All the strings of words are unique.
//1 <= sum(words[i].length) <= 105

package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ConcatenatedWords_472 {
	
	
	
//	approch:
//	here we use recursion and back tracking where we try to combine every single
//	word with each other and check it exists in the dict if yes we add it in result

//	time complexity : O(N* L *L) idk 
//	space complexity : O(L*L) 
    public static List<String> findAllConcatenatedWordsInADictBruteForce(String[] words) {
     int maxLength =0;
     HashSet<String> set= new HashSet(); 
     for(String s:words){
        maxLength=Math.max(maxLength,s.length());
        set.add(s);
     }
     
     return helper("",0,set,maxLength);
    }
    public static List<String> helper(String word,int count,HashSet<String> words,int maxLength){
        if(word.length()>maxLength){
            return null;
        }
        if(count>=2){
            if(words.contains(word)){
                List<String> localres= new ArrayList<String>();
                localres.add(word);
                return localres;
            }
        }
        List<String> res = new ArrayList();
        for(String w:words){
        	StringBuilder concat = new StringBuilder(word);
        	concat.append(w);
            List<String> recres=helper(concat.toString(),count+1,words,maxLength);
            if(recres!=null){
            res.addAll(recres);
            }
        }
        return res;
    }
    
    
    public static List<String> findAllConcatenatedWordsInADictBetter(String[] words) {
    	HashSet<String> set= new HashSet();
    	for(String s:words) {
    		set.add(s);   	
    	}
    	List<String> ans = new ArrayList();
    	for(String word:words) {
    		set.remove(word);
    		if(helperBetter(word,set)) {
    			ans.add(word);
    		}
    		set.add(word);
    	}
    	return ans;
    }
    
    
    public static boolean helperBetter(String word, HashSet<String> words) {
    	for(int i =1;i<word.length();i++) {
    		String prefix = word.substring(0,i);
    		String suffix= word.substring(i);
    	      if (words.contains(prefix) &&
    	                (words.contains(suffix) || helperBetter(suffix, words))) {
    	                return true;
    	            }
    
    	}
    	return false;
    }
    
    
    
    
// 	approch:
// 	here we go through each and every word and try to find each substring of that word exists in our original set or not
//     if it exists we can say its a concatenated word other wise not
//     we use just memorization to do not compute pre computed substrings 
     public static List<String> findAllConcatenatedWordsInADictBest(String[] words) {
     	HashSet<String> set= new HashSet();
     	for(String s:words) {
     		set.add(s);   	
     	}
     	HashMap<String, Boolean > memo = new HashMap();
     	List<String> ans = new ArrayList();
     	for(String word:words) {
     		if(helperBest(word,set,memo)) {
     			set.remove(word);
     			ans.add(word);
     			set.add(word);
     		}
     	}
     	return ans;
     }
     
     public static boolean helperBest(String word, HashSet<String> words,HashMap<String,Boolean> memo) {
     	if(memo.containsKey(word)) {
     		return memo.get(word);
     	}
     	for(int i =1;i<word.length();i++) {
     		String prefix = word.substring(0,i);
     		String suffix= word.substring(i);
     		 if (words.contains(prefix) &&
 	                (words.contains(suffix) || helperBest(suffix, words,memo))) {
     			 memo.put(word,true);
 	                return true;
 	            }
     	}
     	memo.put(word, false);
     	return false;
     }
  
    
    public static boolean check(List<String> res, List<String>output) {
    	if(res.size()!=output.size()) return false;
    	Collections.sort(res);
    	Collections.sort(output);
    	return res.equals(output);
    }
       
        public static void main(String[] args) {
    	//Example 1:

    	String [] words1= {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
    	List<String> output1= new ArrayList(Arrays.asList("catsdogcats","dogcatsdog","ratcatdogcat"));

    	//Example 2:

    	String [] words2 = {"cat","dog","catdog"};
    	List<String> output2= new ArrayList(Arrays.asList("catdog"));
    	
    	
    	
    	System.out.println("Brute Force Approch :");

    	List<String> ans1=findAllConcatenatedWordsInADictBruteForce(words1);
    	List<String> ans2=findAllConcatenatedWordsInADictBruteForce(words2);
    	
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
    	System.out.println("Better Approch :");
    	
    	ans1=findAllConcatenatedWordsInADictBetter(words1);
    	ans2=findAllConcatenatedWordsInADictBetter(words2);


    	
    	if(output1.equals(ans1)) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Ouput :"+ output1);
    		System.out.println("Your Answer :"+ ans1);  		
    	}
    	
    	if(output2.equals(ans2)) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Ouput :"+ output2);
    		System.out.println("Your Answer :"+ ans2);  		
    	}
    	System.out.println("Best Approch :");
    	
    	ans1=findAllConcatenatedWordsInADictBest(words1);
    	ans2=findAllConcatenatedWordsInADictBest(words2);
    	
    	
    	if(output1.equals(ans1)) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Ouput :"+ output1);
    		System.out.println("Your Answer :"+ ans1);  		
    	}
    	
    	if(output2.equals(ans2)) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Ouput :"+ output2);
    		System.out.println("Your Answer :"+ ans2);  		
    	}


	}
}