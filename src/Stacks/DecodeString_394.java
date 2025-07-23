//394. Decode String
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given an encoded string, return its decoded string.
//
//The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
//
//You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
//
//The test cases are generated so that the length of the output will never exceed 105.
//
// 
//
//Example 1:
//
//Input: s = "3[a]2[bc]"
//Output: "aaabcbc"
//Example 2:
//
//Input: s = "3[a2[c]]"
//Output: "accaccacc"
//Example 3:
//
//Input: s = "2[abc]3[cd]ef"
//Output: "abcabccdcdcdef"
// 
//
//Constraints:
//
//1 <= s.length <= 30
//s consists of lowercase English letters, digits, and square brackets '[]'.
//s is guaranteed to be a valid input.
//All the integers in s are in the range [1, 300].
package Stacks;

import java.util.Stack;

public class DecodeString_394 {
	
//	approch :
//	add every character to stack until ']'
//	when it comes we will pop all string till '['
//	then top all character which are digits 
//	now reverse both string extracted and the num extracted 
//	now push string in stack character by character digit times
//	in the end  we can just pop all elements and store it in a string
//	in reverese order as output
//	time complexity :O(n*m) : n is number of string and m is number of times we multiply it 
//	space complexity :O(n*m) :  
	    public static String decodeString(String s) {
	        Stack<Character> stk = new Stack();
	        for(int i =0;i<s.length();i++){
	            char ch = s.charAt(i);
	            if(ch!=']'){
	                stk.push(ch);
	            }else{
	                StringBuilder str= new StringBuilder();
	                while(!stk.isEmpty() && stk.peek()!='['){
	                    str.append(stk.pop());
	                }
	                str.reverse();
	                stk.pop();
	                StringBuilder num =new StringBuilder();
	                char top = stk.peek();
	                while(!stk.isEmpty() && top>='0' && top<='9' ){
	                    num.append(stk.pop());
	                    if(!stk.isEmpty()){
	                    top=stk.peek();

	                    }
	                }
	                num.reverse();
	                putMultipleString(stk,str.toString(),Integer.parseInt(num.toString()));
	            }
	        }
	            StringBuilder res= new StringBuilder();
	            while(!stk.isEmpty()){
	                res.append(stk.pop());
	            }
	            return res.reverse().toString();
	    }
	    public static void putMultipleString(Stack<Character> stk, String str, int multiple){
	        for(int i =0;i<multiple;i++){
	            for(int j=0;j<str.length();j++){
	                char ch = str.charAt(j);
	                stk.push(ch);
	            }
	        }
	    }
	

	public static void main(String[] args) {
		
		//Example 1:

		String s1 = "3[a]2[bc]";
		String output1 ="aaabcbc";
		
		//Example 2:

		String s2 = "3[a2[c]]";
		String output2 ="accaccacc";

		//Example 3:
		
		String s3 = "2[abc]3[cd]ef";
		String output3 ="abcabccdcdcdef";
		
		
		String ans1= decodeString(s1);		
		String ans2= decodeString(s2);		
		String ans3= decodeString(s3);		
		
		
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
		if(ans3.equals(output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}


	}

}
