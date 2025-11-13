//3228. Maximum Number of Operations to Move Ones to the End
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given a binary string s.
//
//You can perform the following operation on the string any number of times:
//
//Choose any index i from the string where i + 1 < s.length such that s[i] == '1' and s[i + 1] == '0'.
//Move the character s[i] to the right until it reaches the end of the string or another '1'. For example, for s = "010010", if we choose i = 1, the resulting string will be s = "000110".
//Return the maximum number of operations that you can perform.
//
//
//
//Example 1:
//
//Input: s = "1001101"
//
//Output: 4
//
//Explanation:
//
//We can perform the following operations:
//
//Choose index i = 0. The resulting string is s = "0011101".
//Choose index i = 4. The resulting string is s = "0011011".
//Choose index i = 3. The resulting string is s = "0010111".
//Choose index i = 2. The resulting string is s = "0001111".
//Example 2:
//
//Input: s = "00111"
//
//Output: 0
//
//
//
//Constraints:
//
//1 <= s.length <= 105
//s[i] is either '0' or '1'.
package Greedy;

public class MaximumNumberOfOperationsToMoveOnesToTheEnd_3228 {
    //    here we can use simple logic
//    where we go left to right
//    find the next 1 appear after 1
//    so we need 2 nested loop
//    time complexity : O(n)
//    space complexity : O(1)
    public static int maxOperations(String s) {
        int operations =0;
        int idx =0;
        int countOne=0;
        while(idx<s.length()){
//            this loop skip all starting ones
            while(idx<s.length() && s.charAt(idx)=='1'){
                countOne++;
                idx++;
            }
//            this looop skip all gaps of 0
            boolean gapPresent = false;
            while(idx<s.length() && s.charAt(idx)=='0'){
                idx++;
                gapPresent=true;
            }
            if(gapPresent){// if there is a gap detected we know each 1 cost 1 operation to
//                shift eacg time
                operations+= countOne;
            }
        }
        return operations;
    }
    public static void main(String[] args) {
        //Example 1:

        String s1 = "1001101";
        int output1= 4;

        //Example 2:

        String s2 = "00111";
        int output2= 0;

        //Example 3:

        String s3 = "0011100";
        int output3= 3;

        int ans1= maxOperations(s1);
        int ans2= maxOperations(s2);
        int ans3= maxOperations(s3);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+(output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+(output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+(output3));
            System.out.println("Your Answer :"+ (ans3));
        }


    }
}
