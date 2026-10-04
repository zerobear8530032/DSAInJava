//678. Valid Parenthesis String
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
//
//The following rules define a valid string:
//
//Any left parenthesis '(' must have a corresponding right parenthesis ')'.
//Any right parenthesis ')' must have a corresponding left parenthesis '('.
//Left parenthesis '(' must go before the corresponding right parenthesis ')'.
//'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
//
//
//Example 1:
//
//Input: s = "()"
//Output: true
//Example 2:
//
//Input: s = "(*)"
//Output: true
//Example 3:
//
//Input: s = "(*))"
//Output: true
//Example 4:
//
//Input: s = "("
//Output: false
//
//
//Constraints:
//
//1 <= s.length <= 100
//s[i] is '(', ')' or '*'.
package DynamicProgramming;

public class ValidParenthesisString_678 {
//    approch :
//    we can use dp and simulate every possible state and
//    memorize it
//    time complexity : O(n*n)
//    space complexity : O(n*n)
    public static boolean checkValidString(String s) {
        Boolean [][] memo = new Boolean [s.length()+1][s.length()+1];
        return helper(0,s,0,memo);
    }

    public static boolean helper(int idx , String s , int balance, Boolean [][] memo){
        if(balance <0){
            return false;
        }
        if(idx==s.length()){
            return balance==0;
        }
        if(memo[idx][balance]!=null){
            return memo[idx][balance];
        }
        char ch = s.charAt(idx);
        boolean res= false;
        if(ch == '('){
            res= res || helper(idx+1,s,balance+1,memo);
        }
        if(ch == ')'){
            res= res || helper(idx+1,s,balance-1,memo);
        }
        if(ch == '*'){
            res= res || helper(idx+1,s,balance+1,memo);
            res= res || helper(idx+1,s,balance-1,memo);
            res = res || helper(idx+1,s,balance,memo);
        }
        return memo[idx][balance]=res;
    }
    public static void main(String[] args) {
        //Example 1:

        String  s1 = "()";
        boolean output1= true;

        //Example 2:

        String s2 = "(*)";
        boolean output2= true;

        //Example 3:

        String s3 = "(*))";
        boolean output3= true;

        //Example 4:

        String s4 = "(";
        boolean output4= false;

        boolean ans1= checkValidString(s1);
        boolean ans2= checkValidString(s2);
        boolean ans3= checkValidString(s3);
        boolean ans4= checkValidString(s4);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }
        if(output4==ans4) {
            System.out.println("Case 4 Passed");
        }else {
            System.out.println("Case 4 Failed");
            System.out.println("Actual Output :"+output4 );
            System.out.println("Your Output :"+ans4);
        }


    }
}
