//187. Repeated DNA Sequences
//Medium
//Topics
//Companies
//The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
//
//For example, "ACGAATTCCG" is a DNA sequence.
//When studying DNA, it is useful to identify repeated sequences within the DNA.
//
//Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.
//
// 
//
//Example 1:
//
//Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//Output: ["AAAAACCCCC","CCCCCAAAAA"]
//Example 2:
//
//Input: s = "AAAAAAAAAAAAA"
//Output: ["AAAAAAAAAA"]
// 
//
//Constraints:
//
//1 <= s.length <= 105
//s[i] is either 'A', 'C', 'G', or 'T'.

package BitWise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class RepeatedDNASequences_187 {
//	Brute Force approch :
//	here we first take each and every single substring of length 0  till n
//	of length 10 each 
//	check that substring exists in original string from i +1 till n 
//	if yes add it to sub string other wise continue
//	at last just add all hashset item in list 
//	time complexity : O(n*n)
//	time complexity : O(n)
    public static List<String> findRepeatedDnaSequencesBruteForce(String s) {
    	List<String> ans = new ArrayList<String>();
    	HashSet<String> set = new HashSet<String>();
    	if(s.length()<10) {
    		return ans;
    	}
    	int n = s.length();
    	for(int i =0;i<n-10;i++) {
    			String str=s.substring(i,i+10);
    			int idx = s.indexOf(str,i+1);
    			if(idx!=-1) {
    				set.add(str);
    			}
    	}
    	ans.addAll(set);
    	return ans;
    }
//	Better approch :
//	here we first take each and every single substring of length 0  till n
//	of length 10 each 
//  here we can use a sliding window which take each substring from 0 to n
//  each of size 10 each time we take a substring we check it present in our hashset
//  if yes we will add it to iour answer if not we add to hashset and move to next ont
//  time complexity : O(n)
//	space complexity : O(n)
    public static List<String> findRepeatedDnaSequencesBetter(String s) {
    	List<String> ans = new ArrayList<String>();
    	HashSet<String> set = new HashSet<String>();
    	HashSet<String> ansset = new HashSet<String>();
    	
    	if(s.length()<=10) {
    		return ans;
    	}
    	int n = s.length();
    	for(int i =0;i<n-9;i++) {
    		String str=s.substring(i,i+10);
    		if(set.contains(str)) {
    			ansset.add(str);
    		}else {
    			set.add(str);    			
    		}
    	}
    	ans.addAll(ansset);
    	return ans;
    }
    
//	Best approch :
//	here we first take each and every single substring of length 0  till n
//	of length 10 each 
//  here we can use a sliding window which take each substring from 0 to n
//  each of size 10 each time we take a substring we check it present in our hashset
//  if yes we will add it to iour answer if not we add to hashset and move to next ont
//  time complexity : O(n*n)
//	space complexity : O(n)
    public static List<String> findRepeatedDnaSequencesBest(String s) {
    	HashSet<Integer> set = new HashSet();
    	List<String> ans = new ArrayList();
    	HashMap<Character,Integer> map = new HashMap();
    	map.put('A', 0);
    	map.put('C', 1);
    	map.put('G', 2);
    	map.put('T', 3);
    	int left=0;
    	int bitMask=0;
    	for(int  right=0;right<s.length();right++) {
    		char ch = s.charAt(right);
    		bitMask= bitMask<<2;
    		bitMask=bitMask^map.get(ch);
    		if(((right-left)+1)==10) {
    			if(set.contains(bitMask)) {
    				ans.add(s.substring(left,right+1));
    			}
    			set.add(bitMask);
    			bitMask=0;
    		}
    		while((right-left)+1>10) {
    			left++;
    		}
    	}
    	
    	return ans;
    	
    }
    
    
    public static void main(String[] args) {
    	//Example 1:

    	String s1 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    	List<String> output1= new ArrayList(Arrays.asList("AAAAACCCCC","CCCCCAAAAA"));

    	//Example 2:

    	String  s2 = "AAAAAAAAAAAAA";
    	List<String> output2= new ArrayList(Arrays.asList("AAAAAAAAAA"));
    	
    	System.out.println(findRepeatedDnaSequencesBest(s1));
    	System.out.println(findRepeatedDnaSequencesBest(s2));

	}
}