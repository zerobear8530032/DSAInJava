//20. Valid Parentheses
//Solved
//Easy
//Topics
//Companies
//Hint
//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.
// 
//
//Example 1:
//
//Input: s = "()"
//
//Output: true
//
//Example 2:
//
//Input: s = "()[]{}"
//
//Output: true
//
//Example 3:
//
//Input: s = "(]"
//
//Output: false
//
//Example 4:
//
//Input: s = "([])"
//
//Output: true
//
// 
//
//Constraints:
//
//1 <= s.length <= 104
//s consists of parentheses only '()[]{}'.

package Stacks;

import java.util.Stack;

class ValidParentheses_20 {
//	approch :
//	  check wheather the stack is empty if it is check any closing brarackets are comming if yes return true
//	if any open brakets coming push in stack
//	check when ever a closing bracket comes the top element in stack is same type of closing breacket
//	if true continue other wise return false
//	last return true is stack is empty other wise false
    public static  boolean isValid(String str) {
       Stack<Character> stack = new Stack();		
		for(int i =0;i<str.length();i++) {
			char ch =str.charAt(i);
			if(stack.isEmpty()) {
				if(ch==']'  || ch=='}' || ch==')' ) {
					return false;
				}
			}
			if(ch=='[' || ch =='{' || ch== '(') {
				stack.push(ch);
			}else {
				char top= stack.peek();
				if(top == '[' && ch==']'  || top == '{' && ch=='}' || top == '(' && ch==')') {
				    stack.pop()	;
				}else {
					return false;
				}
			}		
		}
		return stack.isEmpty();		
	
    }
    public static void main(String[] args) {
    	//Example 1:

    	String s1 = "()";
    	boolean output1=true;

    	//Example 2:

    	String s2 = "()[]{}";
    	boolean output2=true;

    	//Example 3:
    	
    	String s3 = "(]";
    	boolean output3=false;
    	
    	//Example 4:

    	String s4 = "([])";
    	boolean output4=true;
    	
		boolean ans1= isValid(s1);
		boolean ans2= isValid(s2);
		boolean ans3= isValid(s3);
		boolean ans4= isValid(s4);
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
		if(ans4==output4) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Expected Ouput :"+ (output4));
			System.out.println("Your Answer :"+ (ans4));
		}

	}
}