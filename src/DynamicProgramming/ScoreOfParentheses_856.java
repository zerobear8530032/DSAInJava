//856. Score of Parentheses
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given a balanced parentheses string s, return the score of the string.
//
//The score of a balanced parentheses string is based on the following rule:
//
//"()" has score 1.
//AB has score A + B, where A and B are balanced parentheses strings.
//(A) has score 2 * A, where A is a balanced parentheses string.
//
//
//Example 1:
//
//Input: s = "()"
//Output: 1
//Example 2:
//
//Input: s = "(())"
//Output: 2
//Example 3:
//
//Input: s = "()()"
//Output: 2
//
//
//Constraints:
//
//2 <= s.length <= 50
//s consists of only '(' and ')'.
//s is a balanced parentheses string.
package DynamicProgramming;


import java.util.HashMap;

public class ScoreOfParentheses_856 {
//    approch :
//    we can process parenthisis by
//    looking for starting and end parenthesis
//    of we found such parenthesis we check re their nested ones
//    if yes we termed current one as  2* s.substring (l+1,right-1)+ s.substring(right,length)
//    if parenthisis have no nested ones we termed as 1+ right side of the string
//    aafater be compute all this we got our answer
//    if we momerize this :
//    time complexity : O( n*n)
//    space complexity : O( n*n)

    public static int scoreOfParentheses(String s) {
        HashMap<String,Integer> map = new HashMap<>();
        return helper(s,map);
    }

    public static int helper(String s, HashMap<String,Integer> map){
        if(s.isBlank()){
            return 0;
        }
        if(map.containsKey(s)){
            return map.get(s);
        }
        int left= 0;
        int depth =0;
        for(int right =0;right<s.length();right++){
            char ch = s.charAt(right);
            if(ch=='('){
                depth++;
            }else{
                depth--;
            }
            if(depth==0 && right-left==1){
                int res=1+ helper(s.substring(right+1),map);
                map.put(s,res);
                return res;
            }else if(depth ==0){
                int res= 2* helper(s.substring(left+1,right),map)+ helper(s.substring(right+1),map);
                map.put(s,res);
                return res;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        //Example 1:

        String s1 = "()";
        int output1=1;

        //Example 2:
        //
        String s2 = "(())";
        int output2=2;

        //Example 3:

        String s3 = "()()";
        int output3=2;

        int ans1= scoreOfParentheses(s1);
        int ans2= scoreOfParentheses(s2);
        int ans3= scoreOfParentheses(s3);


        if (ans1 == output1) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output : " + output1);
            System.out.println("Your Answer : " + ans1);
        }


        if (ans2 == output2) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output : " + output2);
            System.out.println("Your Answer : " + ans2);
        }


        if (ans3 == output3) {
            System.out.println("Case 3 Passed");
        } else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output : " + output3);
            System.out.println("Your Answer : " + ans3);
        }
    }
}
