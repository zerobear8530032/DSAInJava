//https://www.geeksforgeeks.org/check-for-balanced-parenthesis-without-using-stack/
//Check for balanced parenthesis without using stack
//Last Updated : 16 Mar, 2023
//Given an expression string exp, write a program to examine whether the pairs and the orders of “{“, ”}”, ”(“, ”)”, ”[“, ”]” are correct in exp. 
//
//Examples: 
//
//Input : exp = “[()]{}{[()()]()}”
//Output : true
//
//Input : exp = “[(])”
//Output : false

package Recursion;

import java.util.Arrays;
import java.util.Stack;

public class CheckForBalancedParenthesisWithoutUsingStack_GFG {
//	Using iterative Approch : 
//	time complexity :O(n)
//	space complexity :O(n)
	public static boolean checkValidParethesisIterative(String str) {
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

//	Using Recursion Approch : 
//	time complexity :O(n^n)
//	space complexity :O(n)
	public static boolean checkValidParethesisRec(String str) {
		char [] arr= str.toCharArray();
		return checkParenthesisRec(arr, arr.length);
	}
	public static char findClosing(char ch ) {
		if(ch=='(') return ')';
		if(ch=='[') return ']';
		if(ch=='{') return '}';
		return Character.MIN_VALUE;
	}
	
 
	
	public static boolean  checkParenthesisRec(char[] arr,int n) {
		// Base cases
        if (n == 0)return true;
        if (n == 1)return false;
        if (arr[0] == ')' || arr[0] == '}' || arr[0] == ']')return false;
		
        char closing = findClosing(arr[0]);
		int i ,count=0;
		for(i=1;i<n;i++) {
			if(arr[0]==arr[i]) {
				count++;
			}
			if(arr[i]==closing) {
				 if (count == 0) break;
	                count--;
			}
		}

//		if we does not find any closing parenthesis
		 if (i == n) return false;
		 
		 if (i == 1) return checkParenthesisRec(Arrays.copyOfRange(arr, i + 1, n), n - 2);
		 return checkParenthesisRec(Arrays.copyOfRange(arr, 1, i), i - 1) && checkParenthesisRec(Arrays.copyOfRange(arr, (i + 1), n), n - i - 1);
    
	}

	public static void main(String[] args) {

		String exp1= "[()]{}{[()()]()}";
		boolean output1=true;

		String exp2= "[(])";
		boolean output2=false;
			
		String exp3= "[]{[][][]}{{";
		boolean output3=false;
		
		System.out.println("Iterative Approch :");
		
		boolean ans1=checkValidParethesisIterative(exp1);
		boolean ans2=checkValidParethesisIterative(exp2);
		boolean ans3=checkValidParethesisIterative(exp3);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Your Output :"+ ans1);
			System.out.println("Actual Output :"+ output1);			
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Your Output :"+ ans2);
			System.out.println("Actual Output :"+ output2);			
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Your Output :"+ ans3);
			System.out.println("Actual Output :"+ output3);			
		}
		
		System.out.println("Recursion :");
		
		ans1=checkValidParethesisRec(exp1);
		ans2=checkValidParethesisRec(exp2);
		ans3=checkValidParethesisRec(exp3);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Your Output :"+ ans1);
			System.out.println("Actual Output :"+ output1);			
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Your Output :"+ ans2);
			System.out.println("Actual Output :"+ output2);			
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Your Output :"+ ans3);
			System.out.println("Actual Output :"+ output3);			
		}
	}
}
