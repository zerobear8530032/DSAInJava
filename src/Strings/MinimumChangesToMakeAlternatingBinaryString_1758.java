//1758. Minimum Changes To Make Alternating Binary String
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.
//
//The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.
//
//Return the minimum number of operations needed to make s alternating.
//
//
//
//Example 1:
//
//Input: s = "0100"
//Output: 1
//Explanation: If you change the last character to '1', s will be "0101", which is alternating.
//Example 2:
//
//Input: s = "10"
//Output: 0
//Explanation: s is already alternating.
//Example 3:
//
//Input: s = "1111"
//Output: 2
//Explanation: You need two operations to reach "0101" or "1010".
//
//
//Constraints:
//
//1 <= s.length <= 104
//s[i] is either '0' or '1'.
package Strings;

public class MinimumChangesToMakeAlternatingBinaryString_1758 {
//    approch : their are only 2 possible ptterns which can be form one starting with 0 other with 1
//    so w cn check by starting char at both points and alternting them very time if the char is not whats present in originl
//    string we can use operation to alternate it
//    in the end return minimum of which pattern required less swps.
//    time complexity : O(n)
//    space complexity : O(1)
    public static int minOperations(String s) {
        int opc1=0;
        int opc2=0;
        char ch1 = '0';
        char ch2 = '1';
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch1!= ch){
                opc1++;
            }
            ch1 = ch1=='0' ? '1':'0';
            if(ch2!= ch){
                opc2++;
            }
            ch2 = ch2=='0' ? '1':'0';
        }
        return Math.min(opc1,opc2);
    }
    public static void main(String[] args) {
        //Example 1:

        String s1 = "0100";
        int output1=1;

        //Example 2:

        String s2 = "10";
        int output2=0;

        //Example 3:

        String s3 = "1111";
        int output3=2;

        int ans1= minOperations(s1);
        int ans2= minOperations(s2);
        int ans3= minOperations(s3);

        if(output1==(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2==(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }
        if(output3==(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ output3);
            System.out.println("Your Answer :"+ ans3);
        }
    }
}
