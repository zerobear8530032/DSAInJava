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
import java.util.HashSet;
import java.util.List;

public class ConcatenatedWords_472 {
//	approch:
//	here we use recursion and back tracking where we try to combine every single
//	word with each other and check it exists in the dict if yes we add it in result
//	time complexity : O(m^d)
//	space complexity : O(W × L + D × L)
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
    
    
        public static void main(String[] args) {
    	//Example 1:

    	String [] words1= {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
    	List<String> output1= new ArrayList(Arrays.asList("catsdogcats","dogcatsdog","ratcatdogcat"));

    	//Example 2:

    	String [] words2 = {"cat","dog","catdog"};
    	List<String> output2= new ArrayList(Arrays.asList("catdog"));

    	System.out.println(findAllConcatenatedWordsInADictBruteForce(words1));
    	System.out.println(findAllConcatenatedWordsInADictBruteForce(words2));
	}
}