//Q3. Remove K-Balanced Substrings
//Medium
//5 pt.
//You are given a string s consisting of '(' and ')', and an integer k.
//
//A string is k-balanced if it is exactly k consecutive '(' followed by k consecutive ')', i.e., '(' * k + ')' * k.
//
//For example, if k = 3, k-balanced is "((()))".
//
//You must repeatedly remove all non-overlapping k-balanced substrings from s, and then join the remaining parts. Continue this process until no k-balanced substring exists.
//
//Return the final string after all possible removals.
//
//
//
//​​​​​​​Example 1:
//
//Input: s = "(())", k = 1
//
//Output: ""
//
//Explanation:
//
//k-balanced substring is "()"
//
//Step	Current s	k-balanced	Result s
//1	(())	(())	()
//2	()	()	Empty
//Thus, the final string is "".
//
//Example 2:
//
//Input: s = "(()(", k = 1
//
//Output: "(("
//
//Explanation:
//
//k-balanced substring is "()"
//
//Step	Current s	k-balanced	Result s
//1	(()(	(()(	((
//2	((	-	((
//Thus, the final string is "((".
//
//Example 3:
//
//Input: s = "((()))()()()", k = 3
//
//Output: "()()()"
//
//Explanation:
//
//k-balanced substring is "((()))"
//
//Step	Current s	k-balanced	Result s
//1	((()))()()()	((()))()()()	()()()
//2	()()()	-	()()()
//Thus, the final string is "()()()".
//
//
//
//Constraints:
//
//2 <= s.length <= 105
//s consists only of '(' and ')'.
//1 <= k <= s.length / 2
package Strings;

import java.util.Stack;

public class RemoveKBalancedSubstrings {
//     approch :
//     find the consicutive opening and closing sequence and remove them until there are not more left
//    we can do this recursive
//    time complexity : O(n*n)
//    space complexity : O(n)
    public static String removeSubstringBruteForce(String s, int k) {
        return helper(s,k,"");
    }
    public static String helper(String s ,int k, String prev){
        if(prev.equals(s)){return s;}
        int idx =0;
        int n = s.length();
        while(idx<n){
            //  skip all closing brackets from start:
            while(idx<n && s.charAt(idx)==')'){idx++;}
            int start= idx;
            boolean validOpening = true;
            for(int i =idx;i<Math.min(start+k,n);i++){
                if(s.charAt(i)==')'){
                    validOpening=false;
                    break;
                }
                idx++;
            }
            if(validOpening==false){
                continue;
            }
            boolean validClosing = true;
            if(s.length()-idx<k){continue;}
            int secondHalf = idx;
            for(int i =idx;i<Math.min(secondHalf+k,n);i++){
                if(s.charAt(i)=='('){
                    validClosing=false;
                    break;
                }
                idx++;
            }
            if(validClosing){
//                System.out.println(start);
                String res=  s.substring(0,start)+s.substring(idx);
                return helper(res,k,s);
            }else{
                idx=start+1;
            }
        }
        return s;
    }
// better approch :

    static class Pair {
        char symbol;
        int size;


        public Pair(char ch , int len){
            this.symbol=ch;
            this.size=len;
        }
        @Override
        public String toString() {
            return "Pair{" +
                    "symbol=" + symbol +
                    ", length=" + size +
                    '}';
        }
    }
    public static String removeSubstringBetter(String s, int k) {
        Stack<Pair> stk = new Stack<>();
        int n = s.length();
        int i = 0;

        while (i < n) {
            // count consecutive '('
            int start = i;
            while (i < n && s.charAt(i) == '(') i++;
            int openCount = i - start;
            if (openCount > 0) {
                if (!stk.isEmpty() && stk.peek().symbol == '(') {
                    stk.peek().size += openCount;
                } else {
                    stk.push(new Pair('(', openCount));
                }
            }

            // count consecutive ')'
            start = i;
            while (i < n && s.charAt(i) == ')') i++;
            int closeCount = i - start;
            if (closeCount > 0) {
                if (!stk.isEmpty() && stk.peek().symbol == ')') {
                    stk.peek().size += closeCount;
                } else {
                    stk.push(new Pair(')', closeCount));
                }
            }

            // try to remove k-balanced sequences
            while (stk.size() >= 2) {
                Pair closeSeq = stk.pop();
                Pair openSeq = stk.pop();

                if (openSeq.symbol == '(' && closeSeq.symbol == ')') {
                    int pairs = Math.min(openSeq.size, closeSeq.size) / k;
                    if (pairs == 0) {
                        // not enough to remove -> push back
                        stk.push(openSeq);
                        stk.push(closeSeq);
                        break;
                    }
                    openSeq.size -= pairs * k;
                    closeSeq.size -= pairs * k;

                    if (openSeq.size > 0) stk.push(openSeq);

                    if (closeSeq.size > 0) {
                        if (!stk.isEmpty() && stk.peek().symbol == ')') {
                            stk.peek().size += closeSeq.size;
                        } else {
                            stk.push(closeSeq);
                        }
                    }
                } else {
                    // invalid pair, push back
                    stk.push(openSeq);
                    stk.push(closeSeq);
                    break;
                }
            }
        }

        // build result
        StringBuilder sb = new StringBuilder();
        for (Pair p : stk) {
            sb.append(String.valueOf(p.symbol).repeat(p.size));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        // Example 1:

        String s1 = "(())";
        int k1 = 1;
        String output1= "";



        //Example 2:

        String s2 = "(()(";
        int k2 = 1;
        String output2= "((";

        //Example 3:

        String s3 = "((()))()()()";
        int k3 = 3;
        String output3="()()()";

        //Example 4:

        String s4 = ")(()";
        int k4 = 1;
        String output4=")(";

        System.out.println("Better Approch :");

        String ans1 = removeSubstringBruteForce(s1,k1);
        String ans2 = removeSubstringBruteForce(s2,k2);
        String ans3 = removeSubstringBruteForce(s3,k3);
        String ans4 = removeSubstringBruteForce(s4,k4);


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
        if(output3.equals(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3);
            System.out.println("Your Output :"+ans3);
        }
        if(output4.equals(ans4)) {
            System.out.println("Case 4 Passed");
        }else {
            System.out.println("Case 4 Failed");
            System.out.println("Actual Output :"+output4);
            System.out.println("Your Output :"+ans4);
        }

        System.out.println("Better Approch :");

        ans1 = removeSubstringBetter(s1,k1);
        ans2 = removeSubstringBetter(s2,k2);
        ans3 = removeSubstringBetter(s3,k3);
        ans4 = removeSubstringBetter(s4,k4);


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
        if(output3.equals(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3);
            System.out.println("Your Output :"+ans3);
        }
        if(output4.equals(ans4)) {
            System.out.println("Case 4 Passed");
        }else {
            System.out.println("Case 4 Failed");
            System.out.println("Actual Output :"+output4);
            System.out.println("Your Output :"+ans4);
        }



    }
}
