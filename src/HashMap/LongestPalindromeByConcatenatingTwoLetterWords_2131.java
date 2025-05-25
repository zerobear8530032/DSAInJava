//2131. Longest Palindrome by Concatenating Two Letter Words
//Attempted
//Medium
//Topics
//Companies
//Hint
//You are given an array of strings words. Each element of words consists of two lowercase English letters.
//
//Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.
//
//Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.
//
//A palindrome is a string that reads the same forward and backward.
//
// 
//
//Example 1:
//
//Input: words = ["lc","cl","gg"]
//Output: 6
//Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6.
//Note that "clgglc" is another longest palindrome that can be created.
//Example 2:
//
//Input: words = ["ab","ty","yt","lc","cl","ab"]
//Output: 8
//Explanation: One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt", of length 8.
//Note that "lcyttycl" is another longest palindrome that can be created.
//Example 3:
//
//Input: words = ["cc","ll","xx"]
//Output: 2
//Explanation: One longest palindrome is "cc", of length 2.
//Note that "ll" is another longest palindrome that can be created, and so is "xx".
// 
//
//Constraints:
//
//1 <= words.length <= 105
//words[i].length == 2
//words[i] consists of lowercase English letters.

package HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestPalindromeByConcatenatingTwoLetterWords_2131 {

//	approch :
//	we know there are each string of length 2 so
//	if we reverse the string and same pair exists in our array we can 
//	assume we can use both of them 
//	so we can create a hashmap to get ferquency count of each string 
//	and by checking if there reverse and orignal frequency is greater then 0 we can take them as our palindrome
//	but if the string is like aa , bb, cc then it causes some problem where 
//	we need to consider there frequency to be even then only we can use thme other wise we 
//	we can only take n-1 such strings 
//	but if there are multiple odd strings we can take one of them as extra string
//	example : aa, ba,cc,cc,cc,aa,ba,aa : aa cc ab cc ba cc aa /cc aa ab cc ba aa cc both are valid answer  
//	here we can see there are mutlple odd both char equal string but valid can be either aa taken 3 times or c taken 3 times
//	time complexity :O(n)
//	space complexity :O(n)
	    public static int longestPalindrome(String[] words) {
	        int count =0;
	        HashMap<String,Integer> map = new HashMap();     
	        for(String s: words){
	        	if(map.containsKey(s)) {
	        		map.put(s,map.get(s)+1);
	        	}else {
	        		map.put(s,1);
	        	}
	        }
	        boolean oneextra=false;
	        for(String s:words) {
	        	char l= s.charAt(0);
	        	char r=s.charAt(1);
	        	String revs= r+""+l;
	        	if(l==r) {
	        		int val = map.get(s);
	        		if(val==0) {
	        			continue;
	        		}
	        		if(val%2==0) {
	        			count+= 2*val;
	        		}else {
	        			count+= (val-1)*2;
	        			oneextra=true;
	        		}
	        		map.put(s,0);
	        	}
	        	else if(map.containsKey(s) && map.containsKey(revs)) {
	        		if(map.get(s) ==0 || map.get(revs)==0) {
	        			continue;
	        		}else {
	        			map.put(s, map.get(s)-1);
	        			map.put(revs, map.get(revs)-1);
	        			count +=4;
	        		}
	        	}
	        }
	        if(oneextra) {
	        	count+=2;
	        }
	        return count;
	    }
	
	
	public static void main(String[] args) {
		//Example 1:
		
		String [] words1 = {"lc","cl","gg"};
		int output1=6;

		//Example 2:

		String [] words2 = {"ab","ty","yt","lc","cl","ab"};
		int output2=8;


		//Example 3:
		
		String [] words3 = {"cc","ll","xx"};
		int output3=2;
		
		//Example 4:
		
		String [] words4 = {"em","pe","mp","ee","pp","me","ep","em","em","me"};
		int output4=14;


		
		int ans1=longestPalindrome(words1);
		int ans2=longestPalindrome(words2);
		int ans3=longestPalindrome(words3);
		int ans4=longestPalindrome(words4);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}
		if(output4==ans4) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Actual Output :"+output4);
			System.out.println("Your Output :"+ans4);
		}


	}

}
