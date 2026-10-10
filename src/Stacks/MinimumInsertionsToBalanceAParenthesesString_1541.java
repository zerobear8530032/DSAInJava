//1541. Minimum Insertions to Balance a Parentheses String
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:
//
//Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
//Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
//In other words, we treat '(' as an opening parenthesis and '))' as a closing parenthesis.
//
//For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.
//You can insert the characters '(' and ')' at any position of the string to balance it if needed.
//
//Return the minimum number of insertions needed to make s balanced.
//
//
//
//Example 1:
//
//Input: s = "(()))"
//Output: 1
//Explanation: The second '(' has two matching '))', but the first '(' has only ')' matching. We need to add one more ')' at the end of the string to be "(())))" which is balanced.
//Example 2:
//
//Input: s = "())"
//Output: 0
//Explanation: The string is already balanced.
//Example 3:
//
//Input: s = "))())("
//Output: 3
//Explanation: Add '(' to match the first '))', Add '))' to match the last '('.
//
//
//Constraints:
//
//1 <= s.length <= 105
//s consists of '(' and ')' only.
package Stacks;

import java.util.Stack;

public class MinimumInsertionsToBalanceAParenthesesString_1541 {
//    approch :
//    here we follow a simple approch where we used a stack where opeining bracket is push in stack when it comes
//    when closing bracket comes it can comes in 3 ways
//    ither their is like this ())
//    or this ()
//    or this ))
//    or this )
//    so to handle all these case  we apply proper increments and in the end
//    we check is their are opeing brackets inide the stack they need closing bracket so size*2 + res is answer
//    time complexity : O(n)

    public static int minInsertions(String s) {
        Stack<Character> stk = new Stack();
        int res=0;
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                stk.push(ch);
            }else{
                if(i+1<s.length() && s.charAt(i+1)==')'){
                    if(stk.isEmpty()){
                        res++;
                    }else{
                        stk.pop();
                    }
                    i++;
                }else{
                    if(stk.isEmpty()){
                        res++;
                    }else{
                        stk.pop();
                    }
                    res++;
                }
            }
        }
        return res + stk.size()*2;
    }
//    approch : here we replace the stack with a counter
//    space complexity : O(n)
//    space complexity : O(1)
    public static int minInsertionsBetter(String s) {
        int res = 0;
        int balance=0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                balance++;
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    if (balance==0) {
                        res++;
                    } else {
                        balance--;
                    }
                    i++;
                } else {
                    if (balance==0) {
                        res++;
                    } else {
                        balance--;
                    }
                    res++;
                }
            }
        }
        return res + balance * 2;
    }

    public static void main(String[] args) {
        //Example 1:

        String  s1 = "(()))";
        int output1= 1;
        //Explanation: The second '(' has two matching '))', but the first '(' has only ')' matching. We need to add one more ')' at the end of the string to be "(())))" which is balanced.
        //Example 2:
        //
        String  s2 = "())";
        int output2= 0;
        //Explanation: The string is already balanced.
        //Example 3:
        //
        String  s3 = "))())(";
        int output3= 3;


        int ans1 =minInsertions(s1);
        int ans2 =minInsertions(s2);

        System.out.println("Brute Force Approch :");

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

        System.out.println("Optimize Approch :");

        ans1= minInsertionsBetter(s1);
        ans2= minInsertionsBetter(s2);
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




    }
}
