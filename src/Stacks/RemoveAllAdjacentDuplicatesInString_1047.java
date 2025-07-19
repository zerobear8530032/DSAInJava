//1047. Remove All Adjacent Duplicates In String
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
//
//We repeatedly make duplicate removals on s until we no longer can.
//
//Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
//
// 
//
//Example 1:
//
//Input: s = "abbaca"
//Output: "ca"
//Explanation: 
//For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
//Example 2:
//
//Input: s = "azxxzy"
//Output: "ay"
// 
//
//Constraints:
//
//1 <= s.length <= 105
//s consists of lowercase English letters.
package Stacks;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString_1047 {
	
//	approch :
//	we can use a stack and iterate over the string 
//	if the stack is empty we push it 
//	if the character at top equal to character current indx we pop element
//	and push if top is not equal to next 
	 public static String removeDuplicates(String s) {
	        Stack<Character> stk = new Stack();
	        for (int i = 0; i < s.length(); i++) {
	            char ch = s.charAt(i);
	            if (stk.isEmpty() || stk.peek() != ch) {
	                stk.push(ch);
	            } else {
	                stk.pop();
	            } 
	        }
	        StringBuilder res = new StringBuilder();
	        while (!stk.isEmpty()) {
	            res.append(stk.pop());
	        }
	        return res.reverse().toString();
	    }
	public static void main(String[] args) {
		
		//Example 1:

		String s1 = "abbaca";
		String output1= "ca";

		//Example 2:

		String s2 = "azxxzy";
		String output2= "ay";
		
		System.out.println("Best Approch :");
		
		String ans1= removeDuplicates(s1);
		String ans2= removeDuplicates(s2);
		
		if(ans1.equals(output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2.equals(output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		
		
		
	}

}
