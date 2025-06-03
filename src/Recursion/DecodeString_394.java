//394. Decode String
//Medium
//Topics
//Companies
//Given an encoded string, return its decoded string.
//
//The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
//
//You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
//
//The test cases are generated so that the length of the output will never exceed 105.

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


package Recursion;

import java.util.List;
import java.util.Stack;

public class DecodeString_394 {

//	iterative approch :
//	we can use a astack where we input each character in the stack
//	untill the ']' appear when it does
//	we will pop all character untill '[' and then all digits 
//	once done we can repeat the string digits times and append all the 
//	String in side the stack and keep doing it 
//	at last pop whole string reverse and return ooutput:
//	time complexity :	O(S)	Where S is The Length Of TheDecodedString
//	space complexity :	O(S)	Where S is The Length Of TheDecodedString
	  public static String decodeString(String s) {
		  int idx =0;
		  int n = s.length();
		  Stack <Character> stack = new Stack();
		  while(idx<n) {
			  char ch=s.charAt(idx);
			  if(ch==']') {
				  StringBuilder str= new StringBuilder();
				  while(stack.peek()!='[') {
					  char ch1 =stack.pop();
					  str.append(ch1);
				  }
				  stack.pop();// remove opening bracket
				  StringBuilder repeat= new StringBuilder();
				  while(!stack.isEmpty() && isNumber(stack.peek())) {
					  char ch1 =stack.pop();
					  repeat.append(ch1);
				  }
				  int rep = Integer.parseInt(repeat.reverse().toString());
				  String repeated = repeatStr(rep,str.reverse().toString());
				 for(int i =0;i<repeated.length();i++) {
					 char ch2=repeated.charAt(i);
					 stack.push(ch2);
				 }
			  }else {
				  stack.push(ch);
			  }
			  idx++;				  
		  }
		  StringBuilder decode= new StringBuilder();
		  while(!stack.isEmpty()) {
			  char ch=stack.pop();
			  decode.append(ch);
		  }
		  return decode.reverse().toString();
		  
	  }
	 
	  public static String repeatStr(int n , String str) {
		  StringBuilder res= new StringBuilder();
		  for(int i =0;i<n;i++) {
			  res.append(str);
		  }
		  return res.toString();  
	  }
	  
	  public static boolean isCharacter(char ch) {
		  return ch<='z'&& ch>='a';
	  }
	  public static String decode(String str, int n) {
		  StringBuilder res= new StringBuilder();
		  for(int i =0;i<n;i++) {
			  res.append(str);
		  }
		  return res.toString();
	  }
	  public static boolean isNumber(char ch) {
		  return ch<='9'&& ch>='0';
	  }

	public static void main(String[] args) {
		
		

		//Example 1:

		String  s1 = "3[a]2[bc]";
		String output1= "aaabcbc";

		//Example 2:

		String  s2 = "3[a2[c]]";
		String output2= "accaccacc";

		//Example 3:

		String s3 = "2[abc]3[cd]ef";
		String output3= "abcabccdcdcdef";
		
		System.out.println("Iterative Approch :");
		
		String ans1 = decodeString(s1);
		String ans2 = decodeString(s2);
		String ans3 = decodeString(s3);
		
		
		if(output1.equals(ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2.equals(ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(output3.equals(ans3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}


	}

}
