//1190. Reverse Substrings Between Each Pair of Parentheses
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given a string s that consists of lower case English letters and brackets.
//
//Reverse the strings in each pair of matching parentheses, starting from the innermost one.
//
//Your result should not contain any brackets.
//
//
//
//Example 1:
//
//Input: s = "(abcd)"
//Output: "dcba"
//Example 2:
//
//Input: s = "(u(love)i)"
//Output: "iloveu"
//Explanation: The substring "love" is reversed first, then the whole string is reversed.
//Example 3:
//
//Input: s = "(ed(et(oc))el)"
//Output: "leetcode"
//Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
//
//
//Constraints:
//
//1 <= s.length <= 2000
//s only contains lower case English characters and parentheses.
//It is guaranteed that all parentheses are balanced.
package Strings;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses_1190 {
//    approch :
//    we can use  a stack where we put string
//    in parenthesis in stack when pop they automatically reveres we collect them and put them again
//    in stack at end we can pop every thing reverse it and return as res;
//    time complexity : O(n*n)
//    space complexity : O(n)
    public static String reverseParentheses(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == ')'){
                StringBuilder substr= new StringBuilder();
                while(stk.peek()!='('){
                    substr.append(stk.pop());
                }
                stk.pop();

                for(int j = 0;j<substr.length();j++){
                    stk.push(substr.charAt(j));
                }
            }else{
                stk.push(ch);
            }
        }
        StringBuilder res= new StringBuilder();
        while(!stk.isEmpty()){
            res.append(stk.pop());
        }
        return res.reverse().toString();
    }
    public static void main(String[] args) {
        //Example 1:

        String s1 = "(abcd)";
        String output1= "dcba";

        //Example 2:

        String s2 = "(u(love)i)";
        String output2= "iloveu";

        //Example 3:

        String s3 = "(ed(et(oc))el)";
        String output3= "leetcode";

        String ans1= reverseParentheses(s1);
        String ans2= reverseParentheses(s2);
        String ans3= reverseParentheses(s3);

        if(output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }
        if(output3.equals(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ output3);
            System.out.println("Your Answer :"+ ans3);
        }
    }
}
