//Decode Ways
//Medium
//Topics
//Company Tags
//Hints
//A string consisting of uppercase english characters can be encoded to a number using the following mapping:
//
//'A' -> "1"
//'B' -> "2"
//...
//'Z' -> "26"
//To decode a message, digits must be grouped and then mapped back into letters using the reverse of the mapping above. There may be multiple ways to decode a message. For example, "1012" can be mapped into:
//
//"JAB" with the grouping (10 1 2)
//"JL" with the grouping (10 12)
//The grouping (1 01 2) is invalid because 01 cannot be mapped into a letter since it contains a leading zero.
//
//Given a string s containing only digits, return the number of ways to decode it. You can assume that the answer fits in a 32-bit integer.
//
//Example 1:
//
//Input: s = "12"
//
//Output: 2
//
//Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
//Example 2:
//
//Input: s = "01"
//
//Output: 0
//Explanation: "01" cannot be decoded because "01" cannot be mapped into a letter.
//
//Constraints:
//
//1 <= s.length <= 100
//s consists of digits
package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class DecodeWays_NEETCODE {
//    we just check if its possible to partition string at idx - idx +1 , idx - idx+2
//    where these 1, 2 digits are <=26 && not 0 if thats true
//    we keep partition rest other wise we return 0 as this parition is not possible
//    time complexity : O(n)
//    space complexity : O(n)
        public static int numDecodings(String s) {
            Integer [] memo= new Integer[s.length()+1];

            return helper(s,0,memo);
        }
        public static int helper(String s , int idx,Integer [] memo){
            if(memo[idx]!=null){
                return memo[idx];
            }
            if(idx>=s.length()){
                return 1;
            }
            if(s.charAt(idx)=='0'){
                return 0;
            }

            int takeOne =helper(s,idx+1,memo);

            int takeTwo =0;
            if(idx+1<s.length()){
                String substr= s.substring(idx,idx+2);
                if(Integer.parseInt(substr)<=26){
                    takeTwo=helper(s,idx+2,memo);
                }
            }
            memo[idx]=takeOne+takeTwo;
            return memo[idx];
        }


    public static void main(String[] args) {
        //Example 1:

        String s1 = "12";
        int output1= 2;

        //Example 2:

        String s2 = "01";
        int output2 =0;

        //Example 3:

        String s3 = "1201234";
        int output3 =3;

        int ans1= numDecodings(s1);
        int ans2= numDecodings(s2);
        int ans3= numDecodings(s3);


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
