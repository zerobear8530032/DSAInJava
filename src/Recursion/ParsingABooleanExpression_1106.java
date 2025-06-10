//1106. Parsing A Boolean Expression
//Hard
//Topics
//premium lock icon
//Companies
//Hint
//A boolean expression is an expression that evaluates to either true or false. It can be in one of the following shapes:
//
//'t' that evaluates to true.
//'f' that evaluates to false.
//'!(subExpr)' that evaluates to the logical NOT of the inner expression subExpr.
//'&(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical AND of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
//'|(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical OR of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
//Given a string expression that represents a boolean expression, return the evaluation of that expression.
//
//It is guaranteed that the given expression is valid and follows the given rules.
//
//Example 1:
//
//Input: expression = "&(|(f))"
//Output: false
//Explanation: 
//First, evaluate |(f) --> f. The expression is now "&(f)".
//Then, evaluate &(f) --> f. The expression is now "f".
//Finally, return false.
//Example 2:
//
//Input: expression = "|(f,f,f,t)"
//Output: true
//Explanation: The evaluation of (false OR false OR false OR true) is true.
//Example 3:
//
//Input: expression = "!(&(f,t))"
//Output: true
//Explanation: 
//First, evaluate &(f,t) --> (false AND true) --> false --> f. The expression is now "!(f)".
//Then, evaluate !(f) --> NOT false --> true. We return true.
// 
//
//Constraints:
//
//1 <= expression.length <= 2 * 104
//expression[i] is one following characters: '(', ')', '&', '|', '!', 't', 'f', and ','.
package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParsingABooleanExpression_1106 {
	   	
	public  static boolean parseBoolExpr(String expression) {
		Stack<Character> stk = new Stack();
		for(int i =0;i<expression.length();i++) {
			char ch = expression.charAt(i);
			if(ch==',') continue;
			if(ch!=')') {
				stk.add(expression.charAt(i));
			}else {
				List<Boolean> subexp = new ArrayList();
				while(stk.peek()!='(') {
					char opsymbol= stk.pop();
					boolean op = getValue(opsymbol);
					subexp.add(op);
				}
//				remove ( from stack;
				stk.pop();
				char operator=stk.pop();
				if(operator=='!') {
					boolean first = !subexp.get(0);
					if(first) {
						stk.push('t');						
					}else {
						stk.push('f');												
					}
				}else if(operator=='&') {
					boolean last =subexp.get(subexp.size()-1);
					for(int e=subexp.size()-2;e>=0;e--) {
						last= last && subexp.get(e);
					}
					if(last) {
						stk.push('t');						
					}else {
						stk.push('f');												
					}
				}else if(operator=='|') {
					boolean last =subexp.get(subexp.size()-1);
					for(int e=subexp.size()-2;e>=0;e--) {
						last= last || subexp.get(e);
					}
					if(last) {
						stk.push('t');						
					}else {
						stk.push('f');												
					}
				}
				}
		}
		
		return getValue(stk.pop());
	}
	
	public static boolean getValue(char ch) {
		return ch=='t';
	}
	
	public static void main(String[] args) {
		//Example 1:

		String expression1 = "&(|(f))";
		boolean output1=false;

		//Example 2:

		String expression2 = "|(f,f,f,t)";
		boolean output2=true;

		//Example 3:

		String expression3 = "!(&(f,t))";
		boolean output3=true;
		
		
    	boolean ans1=parseBoolExpr(expression1);
    	boolean ans2=parseBoolExpr(expression2);
    	boolean ans3=parseBoolExpr(expression3);
    	
    	System.out.println("Iterative Approch :");
    	
    	if(output1==ans1) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);  		
    	}
    	if(output2==ans2) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Ouput :"+ output2);
    		System.out.println("Your Answer :"+ ans2);  		
    	}
    	if(output3==ans3) {
    		System.out.println("Case 3 Passed");
    	}else {
    		System.out.println("Case 3 Failed");
    		System.out.println("Expected Ouput :"+ output3);
    		System.out.println("Your Answer :"+ ans3);  		
    	}
	}

}
