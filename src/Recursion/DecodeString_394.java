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

public class DecodeString_394 {

	  public static String decodeString(String s) {
		  return helper(s);
	  }
	  
	  public static String helper(String s) {
		  if(!s.contains("[")) {
			  return "";
		  }
		  if(s.isBlank()) {
			  return "";
		  }
		  int multiple=0;
		  int idx =0;
		  StringBuilder prefix= new StringBuilder();
		  int n = s.length();
		  while(idx<n && isCharacter(s.charAt(idx))) {
			  prefix.append(s.charAt(idx));
			  idx++;
		  }
		  StringBuilder num = new StringBuilder();
		  while(idx<n && isNumber(s.charAt(idx))) {
			  num.append(s.charAt(idx));
			  idx++;
		  }
		  String inner ="";
		  if(s.charAt(idx)=='[') {
			  int open =1;
			  int close =0;
			  idx++;
			  StringBuilder recursive = new StringBuilder();
			  while(idx<n) {
				  if(s.charAt(idx)=='[') {
					  open++;
				  }
				  if(s.charAt(idx)==']') {
					  close++;
				  }
				  if(open==close) break;
				  recursive.append(s.charAt(idx));
				  idx++;
			  }
			  idx++;
			  inner= helper(recursive.toString());
		  }
		  
		  return prefix
		  
	  }
	  
	  
	  public static boolean isCharacter(char ch) {
		  return ch<='z'&& ch>='a';
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
		
		
		System.out.println();

	}

}
