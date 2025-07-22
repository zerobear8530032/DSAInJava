//921. Minimum Add to Make Parentheses Valid
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//A parentheses string is valid if and only if:
//
//It is the empty string,
//It can be written as AB (A concatenated with B), where A and B are valid strings, or
//It can be written as (A), where A is a valid string.
//You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
//
//For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
//Return the minimum number of moves required to make s valid.
//
// 
//
//Example 1:
//
//Input: s = "())"
//Output: 1
//Example 2:
//
//Input: s = "((("
//Output: 3
// 
//
//Constraints:
//
//1 <= s.length <= 1000
//s[i] is either '(' or ')'.

package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class MinimumAddToMakeParenthesesValid_921 {
	    public static int minAddToMakeValid(String s) {
	        Stack<Character> stack = new Stack();
	        int counter=0;
	        for(int i =0;i<s.length();i++){
	            char ch = s.charAt(i);
	            if(ch=='('){
	                stack.push(ch);
	            }else {
	                if(stack.isEmpty()){
	                    counter++;
	                }else{
	                    stack.pop();
	                }
	            }
	        }       
	        counter+=stack.size();
	        return counter;
	   }
	
	public static void main(String[] args) {
		
		//Example 1:

		String  s1 = "())";
		int output1= 1;

		//Example 2:

		String  s2 = "(((";
		int output2= 3;
		
		//Example 3:
		
		String  s3 = "()))((";
		int output3= 4;
		
		int  ans1=minAddToMakeValid(s1);
		int  ans2=minAddToMakeValid(s2);
		int  ans3=minAddToMakeValid(s3);
		
		
		if((output1==ans1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Your Output :"+(ans1) );
			System.out.println("Actual Output :"+(output1));			
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Your Output :"+ (ans2));
			System.out.println("Actual Output :"+ (output2));			
		}
		if((output3==ans3)) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Your Output :"+ (ans3));
			System.out.println("Actual Output :"+ (output3));			
		}

		


	}

}
