//1717. Maximum Score From Removing Substrings
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given a string s and two integers x and y. You can perform two types of operations any number of times.
//
//Remove substring "ab" and gain x points.
//For example, when removing "ab" from "cabxbae" it becomes "cxbae".
//Remove substring "ba" and gain y points.
//For example, when removing "ba" from "cabxbae" it becomes "cabxe".
//Return the maximum points you can gain after applying the above operations on s.
//Example 1:
//
//Input: s = "cdbcbbaaabab", x = 4, y = 5
//Output: 19
//Explanation:
//- Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
//- Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
//- Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
//- Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
//Total score = 5 + 4 + 5 + 5 = 19.
//Example 2:
//
//Input: s = "aabbaaxybbaabb", x = 5, y = 4
//Output: 20
// 
//
//Constraints:
//
//1 <= s.length <= 105
//1 <= x, y <= 104
//s consists of lowercase English letters.
package Stacks;

import java.util.Stack;

public class MaximumScoreFromRemovingSubstrings_1717 {
//	approch :
//	to get max score we can perform the operation first which give high score
//	now to remove we will just keep pushing each char in stack 
//	and check if the top is a and current char is b 
//	we can pop and add the res same we can perfomr it for AB operation
//	at last we can seperatly form both and return the sum of both  operations
//	time complexity :O(n)
//	space complexity :O(n)
	    public static int maximumGain(String s, int x, int y) {
	        if(x<y){
	            Stack<Character> stk = new Stack();
	            int yres=removeBA(stk,s,y);
	            StringBuilder processed= new StringBuilder();
	            while(!stk.isEmpty()){
	                processed.append(stk.pop());
	            }
	           
	            int xres=removeAB(stk,processed.reverse().toString(),x);
	            return xres+yres;
	        }else{
	            Stack<Character> stk = new Stack();
	            int xres=removeAB(stk,s,x);
	            StringBuilder processed= new StringBuilder();
	            while(!stk.isEmpty()){
	                processed.append(stk.pop());
	            }
	           
	            int yres=removeBA(stk,processed.reverse().toString(),y);
	            return xres+yres;
	        }

	    }

	    public static int removeBA(Stack<Character> stk, String str, int y) {
	        int res = 0;
	        for (int i = 0; i < str.length(); i++) {
	            char ch = str.charAt(i);
	            if (!stk.isEmpty() && stk.peek() == 'b' && ch == 'a') {
	                stk.pop();
	                res += y;
	            } else {
	                stk.push(ch);
	            }
	        }
	        return res;
	    }
	    public static int removeAB(Stack<Character> stk, String str, int x) {
	        int res = 0;
	        for (int i = 0; i < str.length(); i++) {
	            char ch = str.charAt(i);
	            if (!stk.isEmpty() && stk.peek() == 'a' && ch == 'b') {
	                stk.pop();
	                res += x;
	            } else {
	                stk.push(ch);
	            }
	        }
	        return res;
	    }
	
	public static void main(String[] args) {
		//Example 1:

		String s1 = "cdbcbbaaabab";
		int x1 = 4, y1 = 5;
		int output1=19;
		
		//Example 2:

		String s2 = "aabbaaxybbaabb";
		int x2 = 5, y2 = 4;
		int output2=20;
		
		
		int ans1= maximumGain(s1,x1,y1);		
		int ans2= maximumGain(s2,x2,y2);		
		
		
		if(ans1==(output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==(output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}


	}

}
