//150. Evaluate Reverse Polish Notation
//Solved
//Medium
//Topics
//Companies
//You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
//
//Evaluate the expression. Return an integer that represents the value of the expression.
//
//Note that:
//
//The valid operators are '+', '-', '*', and '/'.
//Each operand may be an integer or another expression.
//The division between two integers always truncates toward zero.
//There will not be any division by zero.
//The input represents a valid arithmetic expression in a reverse polish notation.
//The answer and all the intermediate calculations can be represented in a 32-bit integer.
// 
//
//Example 1:
//
//Input: tokens = ["2","1","+","3","*"]
//Output: 9
//Explanation: ((2 + 1) * 3) = 9
//Example 2:
//
//Input: tokens = ["4","13","5","/","+"]
//Output: 6
//Explanation: (4 + (13 / 5)) = 6
//Example 3:
//
//Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
//Output: 22
//Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22
// 
//
//Constraints:
//
//1 <= tokens.length <= 104
//tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].


package Stacks;

import java.util.Stack;

class EvaluateReversePolishNotation_150 {
	
// best approch : use stack 
// just iterate over the entire array each time a number comes
//	just push  it in stack but when an operator come pop 2 element from stack
//	apply that operation on it and push result again in stack
//	if the exp is valid at last you will have your output at last element in stack
//	time complexity :O(n)
//	space complexity :O(n)
	
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack();
        for(int i =0;i<tokens.length;i++){
            String curr= tokens[i];
            if(isOperator(curr)){
                int x = stk.pop();
                int y = stk.pop();
                if(curr.equals("+")){
                int ans = y+x;
                stk.push(ans);
                }
                if(curr.equals("-")){
                int ans = y-x;
                stk.push(ans);
                }
                if(curr.equals("*")){
                int ans = y*x;
                stk.push(ans);
                }
                if(curr.equals("/")){
                int ans = y/x;
                stk.push(ans);
                }
            }else{
                stk.push(Integer.parseInt(curr));
            }
        }
        return stk.pop();
    }
    
    
    public static boolean isOperator(String str){
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }
    
    public static void main(String[] args) {
    	
    	//Example 1:

    	String []tokens1 = {"2","1","+","3","*"};
    	int output1=9;
    	
    	//Output: 9
    	//Explanation: ((2 + 1) * 3) = 9
    	//Example 2:

    	String []tokens2 = {"4","13","5","/","+"};
    	int output2=6;
    	
    	//Input: tokens = ["4","13","5","/","+"]
    	//Output: 6
    	//Explanation: (4 + (13 / 5)) = 6
    	//Example 3:

    	String []tokens3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
    	int output3=22;
    	
    	
    	System.out.println("Best Approch :");
    	
    	int ans1= evalRPN(tokens1);    	
    	int ans2= evalRPN(tokens2);    	
    	int ans3= evalRPN(tokens3);    	
    	
    	if(ans1==output1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ output1);
			System.out.println("Your Output : "+ ans1);
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ output2);
			System.out.println("Your Output : "+ ans2);
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Excepted Output : "+ output2);
			System.out.println("Your Output : "+ ans3);
		}


		
	}
}
