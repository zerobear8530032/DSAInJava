//22. Generate Parentheses
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//
//
//Example 1:
//
//Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
//Example 2:
//
//Input: n = 1
//Output: ["()"]
//
//
//Constraints:
//
//1 <= n <= 8


package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses_22 {
//    Brute force Approch : simple create all possible pairs
//    validate them correct or not
//    and return them
//    time complexity : O(2^n *k): k is the string size
//    space complexity : O(n*k)
    public static List<String> generateParenthesisBruteForce(int n) {
        List<String> pairs= new ArrayList();
        generate(n*2,pairs,"");
        List<String> res = new ArrayList();
        for(String pair:pairs){
            if(validate(pair)){
                res.add(pair);
            }
        }
        return res;
    }

    public static boolean validate(String s){
        Stack<Character> stk= new Stack();
        for(int i =0;i<s.length();i++){
            char ch =s.charAt(i);
            if(ch==')' && stk.isEmpty() ){
                return false;
            }
            if(ch=='('){
                stk.push(ch);
            }
            if(ch==')'){
                stk.pop();
            }
        }
        return stk.isEmpty();
    }

    public static void generate(int n , List<String> pairs,String curr){
        if(n==0){
            pairs.add(curr);
            return ;
        }
        // opening parenthesis
        generate(n-1,pairs,curr+"(");
        // closing parenthesis
        generate(n-1,pairs,curr+")");
    }
//    best approch : use simple logic
//    we can only add a closing parenthesis when opening one is used once
//    and we can only use opening ones n times
//    so we can  use recursion where if openingused<closing
//    and apply closing
//    and opening brackets are applied only n times
//    time complexity : O(2^n)
//    space complexity : O(n)
    public static List<String> generateParenthesisBetter(int n) {
        List<String> res = new ArrayList();
        generate(n,n, res, "");
        return res;
    }

    public static void generate(int open, int close, List<String> res, String currRes) {
        if (open == 0 && close == 0) {
            res.add(currRes);
        }
        // open can be applied as many times we want
        if (open > 0) {
            generate(open - 1, close, res, currRes + '(');
        }
        if (open < close) {
            // apply close and open both
            generate(open, close - 1, res, currRes + ')');
        }
    }
    public static void main(String[] args) {
        //Example 1:

        int n1 = 3;
        List<String> output1= new ArrayList<>(Arrays.asList("((()))","(()())","(())()","()(())","()()()"));

        //Example 2:

        int n2 = 1;
        List<String> output2= new ArrayList<>(Arrays.asList("()"));

        List<String> ans1= generateParenthesisBruteForce(n1);
        List<String> ans2= generateParenthesisBruteForce(n2);
        System.out.println("Brute Force Approch :");
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

        ans1= generateParenthesisBetter(n1);
        ans2= generateParenthesisBetter(n2);
        System.out.println("Better Approch :");
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



    }
}
