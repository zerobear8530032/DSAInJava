//1021. Remove Outermost Parentheses
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
//
//For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
//A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.
//
//Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
//
//Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
//
// 
//
//Example 1:
//
//Input: s = "(()())(())"
//Output: "()()()"
//Explanation: 
//The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
//After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
//Example 2:
//
//Input: s = "(()())(())(()(()))"
//Output: "()()()()(())"
//Explanation: 
//The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
//After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
//Example 3:
//
//Input: s = "()()"
//Output: ""
//Explanation: 
//The input string is "()()", with primitive decomposition "()" + "()".
//After removing outer parentheses of each part, this is "" + "" = "".
// 
//
//Constraints:
//
//1 <= s.length <= 105
//s[i] is either '(' or ')'.
//s is a valid parentheses string.

package Stacks;

import java.util.Stack;

public class RemoveOutermostParentheses_1021 {
//	approch :
//	we keep track of opening and closing parenthsis
//	when they are equal that means we have found a valid component now we will just remove 
//	the starting and ending bracket of the that component
//	but here we use stack that means when we pop the element will come in reverese that means 
//	each part will be reverse first before appending in the final answer
//	time complexity :O(n)
//	space complexity :O(n)
	
	  public static String removeOuterParenthesesBruteForce(String s) {
	        Stack<Character> stk = new Stack();
	        int open =0;
	        StringBuilder res= new StringBuilder();
	        for(int i =0;i<s.length();i++){
	            char ch = s.charAt(i);
	            stk.push(ch);
	            if(ch=='('){
	                open++;
	            }else if(ch==')'){
	                open--;
	            }
	            if(open==0){
	                StringBuilder part= new StringBuilder();
	                while(!stk.isEmpty()){
	                    part.append(stk.pop());
	                }
	                res.append(part.reverse().substring(1,part.length()-1));
	            }
	        }
	        return res.toString();
	    }
	  
//	better approch :
//	here we will start from each opening bracket and try to find its closing bracket
//	by keeping count of open if curr char is ( increase opne if ) we decrease open
//	if open == 0 means from the start of the index till iindex open ==0 is the 
//	component we can take substring of start+1 till index (index value will not include here)
//	and append all to the result :
//	time complexity :O(n)
//	space complexity :O(1): there will be extra space of substring but it will all add to result 
	  
	   public static String removeOuterParenthesesBetter(String s) {
	        int idx=0;
	        StringBuilder res= new StringBuilder();
	        while(idx<s.length()){
	            int open = 0;
	            int start=idx;
	            while(idx<s.length()){
	                char ch = s.charAt(idx);
	                if(ch=='('){
	                    open++;
	                }else{
	                    open--;
	                }
	                if(open==0){
	                    break;
	                }
	                idx++;
	            }
	            res.append(s.substring(start+1,idx));
	        }
	        return res.toString();
	    }
	   
//	   approch :
//	   here we will keep track of depth in while iterating if depth is greater then 0 means 
//	   we are inside the parenthesis means we can add the element
//	   if we encounter open breacket we will increase depth
//	   if we encounter closing we decrease depth 
	   public static String removeOuterParenthesesBest(String s) {
	        StringBuilder res= new StringBuilder();
	        int depth =0;
	        for(int i =0;i<s.length();i++){
	            char ch = s.charAt(i);
	            if(ch=='('){
	                if(depth>0){
	                    res.append(ch);
	                }
//	                this will increase after condition
	                depth++;
	                
	            }else  {
//	                this will decrease before condition
	                depth--;
	                if(depth>0){
	                    res.append(ch);
	                }
	            }
	        }
	        return res.toString();
	    }

	public static void main(String[] args) {
		
		//Example 1:

		String s1 = "(()())(())";
		String output1="()()()";

		//Example 2:

		String s2 = "(()())(())(()(()))";
		String output2="()()()()(())";
	
		//Example 3:

		String s3 = "()()";
		String output3="";

		System.out.println("Brute Force Approch :");
		
		String ans1= removeOuterParenthesesBruteForce(s1);
		String ans2= removeOuterParenthesesBruteForce(s2);
		String ans3= removeOuterParenthesesBruteForce(s3);
		
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
		System.out.println("Better Approch :");
		
		ans1= removeOuterParenthesesBetter(s1);
		ans2= removeOuterParenthesesBetter(s2);
		ans3= removeOuterParenthesesBetter(s3);
		
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
		
		System.out.println("Best Approch :");
		
		ans1= removeOuterParenthesesBest(s1);
		ans2= removeOuterParenthesesBest(s2);
		ans3= removeOuterParenthesesBest(s3);
		
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
