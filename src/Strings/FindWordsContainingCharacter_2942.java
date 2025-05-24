//2942. Find Words Containing Character
//Solved
//Easy
//Topics
//Companies
//Hint
//You are given a 0-indexed array of strings words and a character x.
//
//Return an array of indices representing the words that contain the character x.
//
//Note that the returned array may be in any order.
//
// 
//
//Example 1:
//
//Input: words = ["leet","code"], x = "e"
//Output: [0,1]
//Explanation: "e" occurs in both words: "leet", and "code". Hence, we return indices 0 and 1.
//Example 2:
//
//Input: words = ["abc","bcd","aaaa","cbc"], x = "a"
//Output: [0,2]
//Explanation: "a" occurs in "abc", and "aaaa". Hence, we return indices 0 and 2.
//Example 3:
//
//Input: words = ["abc","bcd","aaaa","cbc"], x = "z"
//Output: []
//Explanation: "z" does not occur in any of the words. Hence, we return an empty array.
// 
//
//Constraints:
//
//1 <= words.length <= 50
//1 <= words[i].length <= 50
//x is a lowercase English letter.
//words[i] consists only of lowercase English letters.


package Strings;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter_2942 {
	
//	approch:
//	we can simply use a for loop to interate each string and check char exists or not
//	time complexity :O(n*l)
//	space complexity :O(n)
	    public static List<Integer> findWordsContaining(String[] words, char x) {
	        List<Integer> res = new ArrayList();
	        for(int i =0;i<words.length;i++){
	            int idx= words[i].indexOf(""+x);
	            if(idx!=-1){
	                res.add(i);
	            }
	        }
	        return res;
	    }
	

	public static void main(String[] args) {
		
		
		//Example 1:

		String [] words1 = {"leet","code"};
		char x1 = 'e';
		List<Integer> output1= new ArrayList( Arrays.asList(0,1));

		//Example 2:

		String [] words2 = {"abc","bcd","aaaa","cbc"};
		char x2 = 'a';
		List<Integer> output2= new ArrayList( Arrays.asList(0,2));

		//Example 3:
		
		String [] words3 = {"abc","bcd","aaaa","cbc"};
		char x3 = 'z';
		List<Integer> output3= new ArrayList( );

		System.out.println("Brute Force Approch : ");
		
		List<Integer> ans1 = findWordsContaining(words1,x1);
		List<Integer> ans2 = findWordsContaining(words2,x2);
		List<Integer> ans3 = findWordsContaining(words3,x3);
		
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
		if(output3.equals(ans3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ output3);
			System.out.println("Your Answer :"+ ans3);
		}



	}

}

