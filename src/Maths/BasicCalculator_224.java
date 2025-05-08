//224. Basic Calculator
//Solved
//Hard
//Topics
//Companies
//Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
//
//Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
//
//Example 1:
//
//Input: s = "1 + 1"
//Output: 2
//Example 2:
//
//Input: s = " 2-1 + 2 "
//Output: 3
//Example 3:
//
//Input: s = "(1+(4+5+2)-3)+(6+8)"
//Output: 23
// 
//
//Constraints:
//
//1 <= s.length <= 3 * 105
//s consists of digits, '+', '-', '(', ')', and ' '.
//s represents a valid expression.
//'+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
//'-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
//There will be no two consecutive operators in the input.
//Every number and running calculation will fit in a signed 32-bit integer.

package Maths;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculator_224 {

	
	 public static int calculate(String s) {   
		 Stack<Integer> stack = new Stack<Integer>();
		 Stack<Character> operators= new Stack<Character>();
		 if(!s.contains("+")  && !s.contains("-") ) {
	            StringBuilder str= new StringBuilder();
	            for(int i=0;i<s.length();i++){
	                if(s.charAt(i)==')' || s.charAt(i)=='(' || s.charAt(i)==' '){
	                    continue;
	                }
	                str.append(s.charAt(i));
	            }
				 return Integer.parseInt(str.toString());
			 }
		 s="("+s+")";
		 int n = s.length();
		 int i=0;
		 int res=0;
		 while(i<n) {
			 char ch =s.charAt(i);
			 if(ch==' ') {
				 i++;
				 continue;
			 }else if(ch=='(') {
				 stack.push(ch+'0');
			 }else if(isOperator(ch)) {
				 operators.push(ch);
			 }else if(isNumber(ch)) {
				 int num=0;
				 while(i<n && isNumber(s.charAt(i))) {
					 int x = s.charAt(i)-'0';
					 num=num*10+x;
					 i++;
				 }
				 if(!operators.isEmpty()) {
					 int operator=operators.pop();
					 if(operator=='+') {
						 stack.push(num);
					 }else {
						 stack.push(-num);
					 }
				}else {
					stack.push(num);
				}
				 continue;
			 }else if(ch==')') {
				 int eval=0;
				 while(stack.peek()!='(') {
					 int n1=stack.pop();
					 if(stack.peek()=='(') {
						stack.pop();
						if(!operators.isEmpty()) {
							if(operators.pop()=='+') {
								stack.push(+n1);
							}else {
								stack.push(-n1);								
							}
						}
						break;
					 }else {
						 int n2=stack.pop();
						 eval= n1+n2;
						 stack.push(eval);
					 }
				 }
				 if(stack.peek()=='(') {
					 
					 stack.pop();
				 }
				 res+=eval;
				 }
			 
			 
			 i++;
		 }
		 return res;
	    }
	 
	 public static boolean isNumber(char ch) {
		return ch>='0' && ch<='9';
	 }
	 public static boolean isOperator(char ch) {
		 return ch=='+' || ch =='-';
	 }
	
	public static void main(String[] args) {
		
		
		//Example 1:

		String s1 = "1 + 1";
		int output1=2;

		//Example 2:

		String s2 = " 2-1 + 2 ";
		int output2=3;

		//Example 3:

		String s3 = "(1+(4+5+2)-3)+(6+8)";
		int output3=23;
		
		//Example 4:
		
		String s4 = "0";
		int output4=0;
		
		System.out.println(calculate("1-(     -2)"));
//		System.out.println(calculate(s2));
//		System.out.println(calculate(s3));
//		System.out.println(calculate(s4));
		


	}

}
